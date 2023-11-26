package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CompanyResponsibleService.class})
@ExtendWith(SpringExtension.class)
class CompanyResponsibleServiceTest {
  @MockBean
  private CompanyResponsibleRepository companyResponsibleRepository;

  @Autowired
  private CompanyResponsibleService companyResponsibleService;
  /**
   * Method under test: {@link CompanyResponsibleService#showAllCompanyResponsible(int, int)}
   */
  @Test
  void testShowAllCompanyResponsible() {
    // Arrange
    PageImpl<CompanyResponsible> pageImpl = new PageImpl<>(new ArrayList<>());
    when(companyResponsibleRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<CompanyResponsible> actualShowAllCompanyResponsibleResult = companyResponsibleService
        .showAllCompanyResponsible(10, 3);

    // Assert
    verify(companyResponsibleRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllCompanyResponsibleResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllCompanyResponsibleResult);
  }

  /**
   * Method under test: {@link CompanyResponsibleService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(companyResponsibleRepository).deleteById(Mockito.<Integer>any());
    when(companyResponsibleRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    companyResponsibleService.delete(1);

    // Assert that nothing has changed
    verify(companyResponsibleRepository).deleteById(Mockito.<Integer>any());
    verify(companyResponsibleRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link CompanyResponsibleService#update(CompanyResponsible)}
   */
  @Test
  void testUpdate() {
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
    when(companyResponsibleRepository.save(Mockito.<CompanyResponsible>any())).thenReturn(companyResponsible);
    when(companyResponsibleRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    CompanyResponsible companyresponsible = new CompanyResponsible();
    companyresponsible.setAccount(account2);
    companyresponsible.setCompany(company2);
    companyresponsible.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyresponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyresponsible.setLastName("Doe");
    companyresponsible.setName("Name");
    companyresponsible.setPosition("Position");
    companyresponsible.setResponsibleId(1);
    companyresponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyresponsible.setUpdatedBy("2020-03-01");

    // Act
    companyResponsibleService.update(companyresponsible);

    // Assert that nothing has changed
    verify(companyResponsibleRepository).existsById(Mockito.<Integer>any());
    verify(companyResponsibleRepository).save(Mockito.<CompanyResponsible>any());
    assertEquals("1970-01-01", companyresponsible.getCreatedAt().toLocalDate().toString());
    assertEquals("1970-01-01", companyresponsible.getUpdatedAt().toLocalDate().toString());
    assertEquals("2020-03-01", companyresponsible.getUpdatedBy());
    assertEquals("Doe", companyresponsible.getLastName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", companyresponsible.getCreatedBy());
    assertEquals("Name", companyresponsible.getName());
    assertEquals("Position", companyresponsible.getPosition());
    assertEquals(1, companyresponsible.getResponsibleId());
    assertEquals(account, companyresponsible.getAccount());
    assertEquals(company, companyresponsible.getCompany());
  }

  /**
   * Method under test: {@link CompanyResponsibleService#find(int)}
   */
  @Test
  void testFind() {
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
    when(companyResponsibleRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    CompanyResponsible actualFindResult = companyResponsibleService.find(1);

    // Assert
    verify(companyResponsibleRepository).findById(Mockito.<Integer>any());
    assertSame(companyResponsible, actualFindResult);
  }

  /**
  * Method under test: {@link CompanyResponsibleService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(companyResponsibleRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = companyResponsibleService.count();

    // Assert
    verify(companyResponsibleRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

