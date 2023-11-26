package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityExistsException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.auth.AuthenticationRequest;
import ma.uiz.observatoire.auth.AuthenticationResponse;
import ma.uiz.observatoire.auth.RegisterRequest;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.AccountMapper;
import ma.uiz.observatoire.mapper.StudentMapper;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.Token;
import ma.uiz.observatoire.repository.AccountRepository;
import ma.uiz.observatoire.repository.AccountRoleRepository;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import ma.uiz.observatoire.repository.TokenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationService.class})
@ExtendWith(SpringExtension.class)
class AuthenticationServiceTest {
  @MockBean
  private AccountMapper accountMapper;

  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private AccountRoleRepository accountRoleRepository;

  @MockBean
  private AuthenticationManager authenticationManager;

  @Autowired
  private AuthenticationService authenticationService;

  @MockBean
  private CompanyRepository companyRepository;

  @MockBean
  private CompanyResponsibleRepository companyResponsibleRepository;

  @MockBean
  private JwtService jwtService;

  @MockBean
  private PasswordEncoder passwordEncoder;

  @MockBean
  private StudentMapper studentMapper;

  @MockBean
  private StudentRepository studentRepository;

  @MockBean
  private TokenRepository tokenRepository;
  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Token token = new Token();
    token.setAccount(account2);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    when(tokenRepository.save(Mockito.<Token>any())).thenReturn(token);
    when(jwtService.generateToken(Mockito.<Account>any())).thenReturn("ABC123");

    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(1);
    accountDTO.setImageUrl("https://example.org/example");
    accountDTO.setRoles(new HashSet<>());
    accountDTO.setUserName("janedoe");
    when(accountMapper.mapToDto(Mockito.<Account>any())).thenReturn(accountDTO);

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findByCompanySiret(Mockito.<String>any())).thenReturn(ofResult);

    Account account3 = new Account();
    account3.setAccountId(1);
    account3.setAccountRoles(new HashSet<>());
    account3.setConversations(new HashSet<>());
    account3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account3.setEmail("jane.doe@example.org");
    account3.setEnabled(true);
    account3.setMobileNumber("42");
    account3.setPassword("iloveyou");
    account3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setUpdatedBy("2020-03-01");
    account3.setUserName("janedoe");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");

    CompanyResponsible companyResponsible = new CompanyResponsible();
    companyResponsible.setAccount(account3);
    companyResponsible.setCompany(company2);
    companyResponsible.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setLastName("Doe");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");
    when(companyResponsibleRepository.save(Mockito.<CompanyResponsible>any())).thenReturn(companyResponsible);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act
    AuthenticationResponse actualRegisterResult = authenticationService
        .register(passwordResult.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());

    // Assert
    verify(accountMapper).mapToDto(Mockito.<Account>any());
    verify(companyRepository).findByCompanySiret(Mockito.<String>any());
    verify(jwtService).generateToken(Mockito.<Account>any());
    verify(accountRepository).save(Mockito.<Account>any());
    verify(companyResponsibleRepository).save(Mockito.<CompanyResponsible>any());
    verify(tokenRepository).save(Mockito.<Token>any());
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
    assertEquals("ABC123", actualRegisterResult.getToken());
    assertNull(actualRegisterResult.getStudent());
    assertSame(accountDTO, actualRegisterResult.getUser());
    assertSame(company, actualRegisterResult.getCompany());
  }

  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister2() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new EntityExistsException("An error occurred"));
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertThrows(EntityExistsException.class, () -> authenticationService
        .register(passwordResult.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build()));
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
  }

  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister3() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    RegisterRequest request = new RegisterRequest();
    request.setRoles(new ArrayList<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> authenticationService.register(request));
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
  }

  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister4() {
    // Arrange
    when(accountRepository.save(Mockito.<Account>any())).thenThrow(new EntityExistsException("An error occurred"));

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findByCompanySiret(Mockito.<String>any())).thenReturn(ofResult);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest request = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    request.setRoles(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityExistsException.class, () -> authenticationService.register(request));
    verify(companyRepository).findByCompanySiret(Mockito.<String>any());
    verify(accountRepository).save(Mockito.<Account>any());
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
  }

  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister5() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account);
    when(tokenRepository.save(Mockito.<Token>any())).thenThrow(new EntityExistsException("An error occurred"));
    when(jwtService.generateToken(Mockito.<Account>any())).thenReturn("ABC123");

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findByCompanySiret(Mockito.<String>any())).thenReturn(ofResult);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");

    CompanyResponsible companyResponsible = new CompanyResponsible();
    companyResponsible.setAccount(account2);
    companyResponsible.setCompany(company2);
    companyResponsible.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setLastName("Doe");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");
    when(companyResponsibleRepository.save(Mockito.<CompanyResponsible>any())).thenReturn(companyResponsible);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest request = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    request.setRoles(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityExistsException.class, () -> authenticationService.register(request));
    verify(companyRepository).findByCompanySiret(Mockito.<String>any());
    verify(jwtService).generateToken(Mockito.<Account>any());
    verify(accountRepository).save(Mockito.<Account>any());
    verify(companyResponsibleRepository).save(Mockito.<CompanyResponsible>any());
    verify(tokenRepository).save(Mockito.<Token>any());
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
  }

  /**
   * Method under test: {@link AuthenticationService#register(RegisterRequest)}
   */
  @Test
  void testRegister6() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account);
    when(tokenRepository.save(Mockito.<Token>any())).thenThrow(new EntityExistsException("An error occurred"));

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findByCompanySiret(Mockito.<String>any())).thenReturn(ofResult);
    when(companyResponsibleRepository.save(Mockito.<CompanyResponsible>any()))
        .thenThrow(new EntityExistsException("An error occurred"));
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest request = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    request.setRoles(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityExistsException.class, () -> authenticationService.register(request));
    verify(companyRepository).findByCompanySiret(Mockito.<String>any());
    verify(accountRepository).save(Mockito.<Account>any());
    verify(companyResponsibleRepository).save(Mockito.<CompanyResponsible>any());
    verify(passwordEncoder).encode(Mockito.<CharSequence>any());
  }

  /**
  * Method under test: {@link AuthenticationService#authenticate(AuthenticationRequest)}
  */
  @Test
  void testAuthenticate() throws AuthenticationException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");
    Optional<Account> ofResult = Optional.of(account);

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account2);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(accountRepository.findCompany(Mockito.<Account>any())).thenReturn(company);
    when(accountRepository.findStudent(Mockito.<Account>any())).thenReturn(student);
    when(accountRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

    Account account3 = new Account();
    account3.setAccountId(1);
    account3.setAccountRoles(new HashSet<>());
    account3.setConversations(new HashSet<>());
    account3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account3.setEmail("jane.doe@example.org");
    account3.setEnabled(true);
    account3.setMobileNumber("42");
    account3.setPassword("iloveyou");
    account3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setUpdatedBy("2020-03-01");
    account3.setUserName("janedoe");

    Token token = new Token();
    token.setAccount(account3);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    when(tokenRepository.save(Mockito.<Token>any())).thenReturn(token);
    when(tokenRepository.findAllValidTokenByUser(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(jwtService.generateToken(Mockito.<Account>any())).thenReturn("ABC123");

    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(1);
    accountDTO.setImageUrl("https://example.org/example");
    accountDTO.setRoles(new HashSet<>());
    accountDTO.setUserName("janedoe");
    when(accountMapper.mapToDto(Mockito.<Account>any())).thenReturn(accountDTO);

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenReturn(studentDTO);
    when(authenticationManager.authenticate(Mockito.<Authentication>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

    // Act
    AuthenticationResponse actualAuthenticateResult = authenticationService
        .authenticate(new AuthenticationRequest("jane.doe@example.org", "iloveyou"));

    // Assert
    verify(accountMapper).mapToDto(Mockito.<Account>any());
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    verify(accountRepository).findByEmail(Mockito.<String>any());
    verify(accountRepository).findCompany(Mockito.<Account>any());
    verify(accountRepository, atLeast(1)).findStudent(Mockito.<Account>any());
    verify(tokenRepository).findAllValidTokenByUser(Mockito.<Integer>any());
    verify(jwtService).generateToken(Mockito.<Account>any());
    verify(tokenRepository).save(Mockito.<Token>any());
    verify(authenticationManager).authenticate(Mockito.<Authentication>any());
    assertEquals("ABC123", actualAuthenticateResult.getToken());
    assertSame(accountDTO, actualAuthenticateResult.getUser());
    assertSame(studentDTO, actualAuthenticateResult.getStudent());
    assertSame(company, actualAuthenticateResult.getCompany());
  }

  /**
   * Method under test: {@link AuthenticationService#authenticate(AuthenticationRequest)}
   */
  @Test
  void testAuthenticate2() throws AuthenticationException {
    // Arrange
    when(authenticationManager.authenticate(Mockito.<Authentication>any()))
        .thenThrow(new EntityExistsException("An error occurred"));

    // Act and Assert
    assertThrows(EntityExistsException.class,
        () -> authenticationService.authenticate(new AuthenticationRequest("jane.doe@example.org", "iloveyou")));
    verify(authenticationManager).authenticate(Mockito.<Authentication>any());
  }

  /**
   * Method under test: {@link AuthenticationService#authenticate(AuthenticationRequest)}
   */
  @Test
  void testAuthenticate3() throws AuthenticationException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
    when(tokenRepository.findAllValidTokenByUser(Mockito.<Integer>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    when(jwtService.generateToken(Mockito.<Account>any())).thenReturn("ABC123");
    when(authenticationManager.authenticate(Mockito.<Authentication>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> authenticationService
        .authenticate(AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build()));
    verify(accountRepository).findByEmail(Mockito.<String>any());
    verify(tokenRepository).findAllValidTokenByUser(Mockito.<Integer>any());
    verify(jwtService).generateToken(Mockito.<Account>any());
    verify(authenticationManager).authenticate(Mockito.<Authentication>any());
  }

  /**
   * Method under test: {@link AuthenticationService#currentUser(String)}
   */
  @Test
  void testCurrentUser() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    Optional<Token> ofResult = Optional.of(token);
    when(tokenRepository.findByToken(Mockito.<String>any())).thenReturn(ofResult);

    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(1);
    accountDTO.setImageUrl("https://example.org/example");
    accountDTO.setRoles(new HashSet<>());
    accountDTO.setUserName("janedoe");
    when(accountMapper.mapToDto(Mockito.<Account>any())).thenReturn(accountDTO);

    // Act
    AccountDTO actualCurrentUserResult = authenticationService.currentUser("ma.uiz.observatoire.model.Account");

    // Assert
    verify(accountMapper).mapToDto(Mockito.<Account>any());
    verify(tokenRepository).findByToken(Mockito.<String>any());
    assertSame(accountDTO, actualCurrentUserResult);
  }

  /**
   * Method under test: {@link AuthenticationService#currentUser(String)}
   */
  @Test
  void testCurrentUser2() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    Optional<Token> ofResult = Optional.of(token);
    when(tokenRepository.findByToken(Mockito.<String>any())).thenReturn(ofResult);
    when(accountMapper.mapToDto(Mockito.<Account>any())).thenThrow(new EntityExistsException("An error occurred"));

    // Act and Assert
    assertThrows(EntityExistsException.class,
        () -> authenticationService.currentUser("ma.uiz.observatoire.model.Account"));
    verify(accountMapper).mapToDto(Mockito.<Account>any());
    verify(tokenRepository).findByToken(Mockito.<String>any());
  }

  /**
   * Method under test: {@link AuthenticationService#currentUser(String)}
   */
  @Test
  void testCurrentUser3() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");
    Token token = mock(Token.class);
    when(token.getAccount()).thenReturn(account2);
    doNothing().when(token).setAccount(Mockito.<Account>any());
    doNothing().when(token).setExpired(anyBoolean());
    doNothing().when(token).setId(Mockito.<Integer>any());
    doNothing().when(token).setRevoked(anyBoolean());
    doNothing().when(token).setToken(Mockito.<String>any());
    doNothing().when(token).setTokenType(Mockito.<Token.TokenType>any());
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    Optional<Token> ofResult = Optional.of(token);
    when(tokenRepository.findByToken(Mockito.<String>any())).thenReturn(ofResult);

    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(1);
    accountDTO.setImageUrl("https://example.org/example");
    accountDTO.setRoles(new HashSet<>());
    accountDTO.setUserName("janedoe");
    when(accountMapper.mapToDto(Mockito.<Account>any())).thenReturn(accountDTO);

    // Act
    AccountDTO actualCurrentUserResult = authenticationService.currentUser("ma.uiz.observatoire.model.Account");

    // Assert
    verify(accountMapper).mapToDto(Mockito.<Account>any());
    verify(token).getAccount();
    verify(token).setAccount(Mockito.<Account>any());
    verify(token).setExpired(anyBoolean());
    verify(token).setId(Mockito.<Integer>any());
    verify(token).setRevoked(anyBoolean());
    verify(token).setToken(Mockito.<String>any());
    verify(token).setTokenType(Mockito.<Token.TokenType>any());
    verify(tokenRepository).findByToken(Mockito.<String>any());
    assertSame(accountDTO, actualCurrentUserResult);
  }
}

