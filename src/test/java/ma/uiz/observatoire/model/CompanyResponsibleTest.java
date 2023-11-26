package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CompanyResponsible.class})
@ExtendWith(SpringExtension.class)
class CompanyResponsibleTest {
  @Autowired
  private CompanyResponsible companyResponsible;

  /**
   * Method under test: {@link CompanyResponsible#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new CompanyResponsible()).canEqual("Other"));
  }

  /**
   * Method under test: {@link CompanyResponsible#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    CompanyResponsible companyResponsible2 = new CompanyResponsible();

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

    CompanyResponsible companyResponsible3 = new CompanyResponsible();
    companyResponsible3.setAccount(account);
    companyResponsible3.setCompany(company);
    companyResponsible3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible3.setLastName("Doe");
    companyResponsible3.setName("Name");
    companyResponsible3.setPosition("Position");
    companyResponsible3.setResponsibleId(1);
    companyResponsible3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(companyResponsible2.canEqual(companyResponsible3));
  }

  /**
   * Method under test: {@link CompanyResponsible#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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

    CompanyResponsible companyResponsible3 = new CompanyResponsible();
    companyResponsible3.setAccount(account);
    companyResponsible3.setCompany(company);
    companyResponsible3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible3.setLastName("Doe");
    companyResponsible3.setName("Name");
    companyResponsible3.setPosition("Position");
    companyResponsible3.setResponsibleId(1);
    companyResponsible3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible3.setUpdatedBy("2020-03-01");

    // Act
    boolean actualCanEqualResult = companyResponsible2.canEqual(companyResponsible3);

    // Assert
    verify(account).setAccountId(anyInt());
    verify(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    verify(account).setConversations(Mockito.<Set<Conversation>>any());
    verify(account).setEmail(Mockito.<String>any());
    verify(account).setEnabled(anyBoolean());
    verify(account).setMobileNumber(Mockito.<String>any());
    verify(account).setPassword(Mockito.<String>any());
    verify(account).setUserName(Mockito.<String>any());
    verify(account).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(account).setCreatedBy(Mockito.<String>any());
    verify(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(account).setUpdatedBy(Mockito.<String>any());
    assertTrue(actualCanEqualResult);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link CompanyResponsible}
  *   <li>{@link CompanyResponsible#setAccount(Account)}
  *   <li>{@link CompanyResponsible#setCompany(Company)}
  *   <li>{@link CompanyResponsible#setLastName(String)}
  *   <li>{@link CompanyResponsible#setName(String)}
  *   <li>{@link CompanyResponsible#setPosition(String)}
  *   <li>{@link CompanyResponsible#setResponsibleId(int)}
  *   <li>{@link CompanyResponsible#toString()}
  *   <li>{@link CompanyResponsible#getAccount()}
  *   <li>{@link CompanyResponsible#getCompany()}
  *   <li>{@link CompanyResponsible#getLastName()}
  *   <li>{@link CompanyResponsible#getName()}
  *   <li>{@link CompanyResponsible#getPosition()}
  *   <li>{@link CompanyResponsible#getResponsibleId()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    CompanyResponsible actualCompanyResponsible = new CompanyResponsible();
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
    actualCompanyResponsible.setAccount(account);
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
    actualCompanyResponsible.setCompany(company);
    actualCompanyResponsible.setLastName("Doe");
    actualCompanyResponsible.setName("Name");
    actualCompanyResponsible.setPosition("Position");
    actualCompanyResponsible.setResponsibleId(1);
    String actualToStringResult = actualCompanyResponsible.toString();
    Account actualAccount = actualCompanyResponsible.getAccount();
    Company actualCompany = actualCompanyResponsible.getCompany();
    String actualLastName = actualCompanyResponsible.getLastName();
    String actualName = actualCompanyResponsible.getName();
    String actualPosition = actualCompanyResponsible.getPosition();

    // Assert that nothing has changed
    assertEquals(
        "CompanyResponsible(responsibleId=1, name=Name, lastName=Doe, position=Position, company=Company(companyId=1,"
            + " companySiret=Company Siret, companyName=Company Name, companyPhone=6625550144, companyEmail=jane.doe"
            + "@example.org, companyWebsite=Company Website, domains=[], companyLegalForm=CompanyLegalForm(legalFormId=1,"
            + " legalFormName=Legal Form Name), companyResponsibles=[], imageUrl=https://example.org/example),"
            + " account=Account(accountId=1, userName=janedoe, password=iloveyou, email=jane.doe@example.org,"
            + " enabled=true, mobileNumber=42, conversations=[], accountRoles=[]))",
        actualToStringResult);
    assertEquals("Doe", actualLastName);
    assertEquals("Name", actualName);
    assertEquals("Position", actualPosition);
    assertEquals(1, actualCompanyResponsible.getResponsibleId());
    assertSame(account, actualAccount);
    assertSame(company, actualCompany);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals() {
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

    // Act and Assert
    assertNotEquals(companyResponsible, null);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals2() {
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

    // Act and Assert
    assertNotEquals(companyResponsible, "Different type to CompanyResponsible");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link CompanyResponsible#equals(Object)}
   *   <li>{@link CompanyResponsible#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
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

    // Act and Assert
    assertEquals(companyResponsible, companyResponsible);
    int expectedHashCodeResult = companyResponsible.hashCode();
    assertEquals(expectedHashCodeResult, companyResponsible.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link CompanyResponsible#equals(Object)}
   *   <li>{@link CompanyResponsible#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(companyResponsible, companyResponsible2);
    int expectedHashCodeResult = companyResponsible.hashCode();
    assertEquals(expectedHashCodeResult, companyResponsible2.hashCode());
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setCreatedAt(LocalDate.now().atStartOfDay());
    companyResponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setLastName("Doe");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setLastName("Smith");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setLastName(null);
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setName("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setName(null);
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setPosition("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setPosition(null);
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }

  /**
   * Method under test: {@link CompanyResponsible#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
    Account account = mock(Account.class);
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    companyResponsible.setResponsibleId(2);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");

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

    CompanyResponsible companyResponsible2 = new CompanyResponsible();
    companyResponsible2.setAccount(account2);
    companyResponsible2.setCompany(company2);
    companyResponsible2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible2.setLastName("Doe");
    companyResponsible2.setName("Name");
    companyResponsible2.setPosition("Position");
    companyResponsible2.setResponsibleId(1);
    companyResponsible2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyResponsible, companyResponsible2);
  }
}

