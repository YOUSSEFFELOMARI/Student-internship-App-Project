package ma.uiz.observatoire.service;


import io.jsonwebtoken.JwtException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.auth.AuthenticationRequest;
import ma.uiz.observatoire.auth.AuthenticationResponse;
import ma.uiz.observatoire.auth.RegisterRequest;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.AccountMapper;
import ma.uiz.observatoire.mapper.StudentMapper;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final AccountRepository accountRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AccountRoleRepository accountRoleRepository;
    private final AccountMapper accountMapper;
    private final CompanyRepository companyRepository;
    private final StudentMapper studentMapper;
    private final CompanyResponsibleRepository companyResponsibleRepository;
    private final StudentRepository studentRepository;

    public AuthenticationResponse register(RegisterRequest request) {

        Set<AccountRole> accountRoles = request.getRoles().stream().map(s -> accountRoleRepository.findByRoleName(s).orElseThrow(() -> new EntityNotFoundException("AccountRole not found - name : " + s) {
        })).collect(Collectors.toSet());

        var account = Account.builder().userName(request.getUsername()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).accountRoles(accountRoles).build();
        Account savedUser;
        StudentDTO studentObj=null;
        Company companyObj=null;
        if (request.getCompanySiret() != null) {
            Company company = companyRepository.findByCompanySiret(request.getCompanySiret()).orElseThrow(() ->
                    new EntityNotFoundException("Company not found - SIRET : " + request.getCompanySiret()) {});
            companyObj=company;
            savedUser = accountRepository.save(account);
            CompanyResponsible responsible = new CompanyResponsible();
            responsible.setAccount(savedUser);
            responsible.setCompany(company);
            companyResponsibleRepository.save(responsible);
        }
        else if (request.getStudentCin() != null) {
            Student student = studentRepository.findByCIN(request.getStudentCin()).orElseThrow(() ->
                    new EntityNotFoundException("Student not found - CIN : " + request.getStudentCin()) {});
            if(student.getAccount()!=null)
                throw new EntityExistsException("Student Already have an account : "+request.getStudentCin());
            studentObj=studentMapper.mapToDto(student);
            savedUser = accountRepository.save(account);
            student.setAccount(savedUser);
            studentRepository.save(student);
        }
        else throw new UnsupportedOperationException("Account type undefined" );
        var jwtToken = jwtService.generateToken(account);
        saveUserToken(savedUser, jwtToken);
        AccountDTO accountDTO= accountMapper.mapToDto(savedUser);
        AuthenticationResponse resp=AuthenticationResponse.builder()
                .token(jwtToken)
                .user(accountDTO)
                .company(companyObj)
                .student(studentObj)
                .build();
        return resp;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var account = accountRepository.findByEmail(request.getEmail()).orElseThrow();
        SecurityContextHolder.getContext().setAuthentication(auth);
//        log.info(account.toString());
        var jwtToken = jwtService.generateToken(account);
        revokeAllUserTokens(account);
        saveUserToken(account, jwtToken);
        StudentDTO student=accountRepository.findStudent(account)!=null?
                studentMapper.mapToDto(accountRepository.findStudent(account))
                :null;
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(accountMapper.mapToDto(account))
                .student(student)
                .company(accountRepository.findCompany(account))
                .build();
    }

    private void saveUserToken(Account account, String jwtToken) {
        var token = Token.builder().account(account).token(jwtToken).tokenType(Token.TokenType.BEARER).expired(false).revoked(false).build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Account account) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(account.getAccountId());
        if (validUserTokens.isEmpty()) return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public AccountDTO currentUser(String token) {
        Token tokenModel = tokenRepository.findByToken(token.substring(7)).orElseThrow(() -> new JwtException("Invalid Token") {
        });
        Account account = tokenModel.getAccount();
        return accountMapper.mapToDto(account);
    }

    private void setContext(RegisterRequest request) {


    }
}
