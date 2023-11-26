package ma.uiz.observatoire.mapper;

import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.ChatAccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    @Mapping(source = "accountRoles",target = "roles")
    public abstract AccountDTO mapToDto(Account account);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CompanyResponsibleRepository companyResponsibleRepository;
    protected String mapAccountRoleSourceToName(AccountRole accountRole) {
        return accountRole.getRoleName();
    }

    @AfterMapping
    public void afterMapping(@MappingTarget AccountDTO AccountDTO,Account sessionAccount) {
        Optional<Student> student=studentRepository.findByAccount(sessionAccount);
        Optional<CompanyResponsible> companyResponsible=companyResponsibleRepository.findByAccount(sessionAccount);
        student.ifPresent(s->{
            if(s.getImageUrl() != null) AccountDTO.setImageUrl(s.getImageUrl());
            if(s.getName()!=null) AccountDTO.setUserName(s.getName());
        });
        companyResponsible.ifPresent(c->{
            if(c.getCompany().getImageUrl()!=null) AccountDTO.setImageUrl(c.getCompany().getImageUrl());
            if(c.getCompany().getCompanyName()!=null) AccountDTO.setImageUrl(c.getCompany().getCompanyName());
        });
    }
}
