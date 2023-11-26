package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.AccountRole;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountMapperImpl.class})
@ExtendWith(SpringExtension.class)
class AccountMapperImplTest {
  @Autowired
  private AccountMapperImpl accountMapperImpl;

  @MockBean
  private CompanyResponsibleRepository companyResponsibleRepository;

  @MockBean
  private StudentRepository studentRepository;
  /**
  * Method under test: {@link AccountMapperImpl#accountRoleSetToStringSet(Set)}
  */
  @Test
  void testAccountRoleSetToStringSet() {
    // Arrange, Act and Assert
    assertTrue(accountMapperImpl.accountRoleSetToStringSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link AccountMapperImpl#accountRoleSetToStringSet(Set)}
   */
  @Test
  void testAccountRoleSetToStringSet2() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    HashSet<AccountRole> set = new HashSet<>();
    set.add(accountRole);

    // Act
    Set<String> actualAccountRoleSetToStringSetResult = accountMapperImpl.accountRoleSetToStringSet(set);

    // Assert
    assertEquals(1, actualAccountRoleSetToStringSetResult.size());
    assertTrue(actualAccountRoleSetToStringSetResult.contains("Role Name"));
  }

  /**
   * Method under test: {@link AccountMapperImpl#accountRoleSetToStringSet(Set)}
   */
  @Test
  void testAccountRoleSetToStringSet3() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(2);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Created By");
    accountRole2.setRoleName("ma.uiz.observatoire.model.AccountRole");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020/03/01");

    HashSet<AccountRole> set = new HashSet<>();
    set.add(accountRole2);
    set.add(accountRole);

    // Act
    Set<String> actualAccountRoleSetToStringSetResult = accountMapperImpl.accountRoleSetToStringSet(set);

    // Assert
    assertEquals(2, actualAccountRoleSetToStringSetResult.size());
    assertTrue(actualAccountRoleSetToStringSetResult.contains("Role Name"));
    assertTrue(actualAccountRoleSetToStringSetResult.contains("ma.uiz.observatoire.model.AccountRole"));
  }

  /**
   * Method under test: {@link AccountMapperImpl#accountRoleSetToStringSet(Set)}
   */
  @Test
  void testAccountRoleSetToStringSet4() {
    // Arrange
    AccountRole accountRole = mock(AccountRole.class);
    when(accountRole.getRoleName()).thenReturn("Role Name");
    doNothing().when(accountRole).setAccountRoleId(anyInt());
    doNothing().when(accountRole).setRoleName(Mockito.<String>any());
    doNothing().when(accountRole).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(accountRole).setCreatedBy(Mockito.<String>any());
    doNothing().when(accountRole).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(accountRole).setUpdatedBy(Mockito.<String>any());
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    HashSet<AccountRole> set = new HashSet<>();
    set.add(accountRole);

    // Act
    Set<String> actualAccountRoleSetToStringSetResult = accountMapperImpl.accountRoleSetToStringSet(set);

    // Assert
    verify(accountRole).getRoleName();
    verify(accountRole).setAccountRoleId(anyInt());
    verify(accountRole).setRoleName(Mockito.<String>any());
    verify(accountRole).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(accountRole).setCreatedBy(Mockito.<String>any());
    verify(accountRole).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(accountRole).setUpdatedBy(Mockito.<String>any());
    assertEquals(1, actualAccountRoleSetToStringSetResult.size());
    assertTrue(actualAccountRoleSetToStringSetResult.contains("Role Name"));
  }

  /**
   * Method under test: {@link AccountMapperImpl#mapToDto(Account)}
   */
  @Test
  void testMapToDto() {
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

    CompanyResponsible companyResponsible = new CompanyResponsible();
    companyResponsible.setAccount(account);
    companyResponsible.setCompany(company);
    companyResponsible.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setLastName("Doe");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");
    Optional<CompanyResponsible> ofResult = Optional.of(companyResponsible);
    when(companyResponsibleRepository.findByAccount(Mockito.<Account>any())).thenReturn(ofResult);

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
    Optional<Student> ofResult2 = Optional.of(student);
    when(studentRepository.findByAccount(Mockito.<Account>any())).thenReturn(ofResult2);

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

    // Act
    AccountDTO actualMapToDtoResult = accountMapperImpl.mapToDto(account3);

    // Assert
    verify(companyResponsibleRepository).findByAccount(Mockito.<Account>any());
    verify(studentRepository).findByAccount(Mockito.<Account>any());
    assertEquals("Company Name", actualMapToDtoResult.getImageUrl());
    assertEquals("Name", actualMapToDtoResult.getUserName());
    assertEquals(1, actualMapToDtoResult.getAccountId());
    assertTrue(actualMapToDtoResult.getRoles().isEmpty());
  }
}

