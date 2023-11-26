package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
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
@ContextConfiguration(classes = {Offer.class})
@ExtendWith(SpringExtension.class)
class OfferTest {
  @Autowired
  private Offer offer;

  /**
   * Method under test: {@link Offer#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Offer()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Offer#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Offer offer2 = new Offer();

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

    Offer offer3 = new Offer();
    offer3.setApplications(new HashSet<>());
    offer3.setAssignmentCity("Assignment City");
    offer3.setCompany(company);
    offer3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer3.setDescription("The characteristics of someone or something");
    offer3.setDiplomaTypes(new HashSet<>());
    offer3.setDomains(new HashSet<>());
    offer3.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer3.setOfferId(1);
    offer3.setOfferName("Offer Name");
    offer3.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer3.setSalaryMax(10.0d);
    offer3.setSalaryMin(10.0d);
    offer3.setStudentLanguages(new HashSet<>());
    offer3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(offer2.canEqual(offer3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Offer}
  *   <li>{@link Offer#setApplications(Set)}
  *   <li>{@link Offer#setAssignmentCity(String)}
  *   <li>{@link Offer#setCompany(Company)}
  *   <li>{@link Offer#setDescription(String)}
  *   <li>{@link Offer#setDiplomaTypes(Set)}
  *   <li>{@link Offer#setDomains(Set)}
  *   <li>{@link Offer#setExpirationDate(Date)}
  *   <li>{@link Offer#setOfferId(int)}
  *   <li>{@link Offer#setOfferName(String)}
  *   <li>{@link Offer#setPublicationDate(Date)}
  *   <li>{@link Offer#setSalaryMax(double)}
  *   <li>{@link Offer#setSalaryMin(double)}
  *   <li>{@link Offer#setStudentLanguages(Set)}
  *   <li>{@link Offer#toString()}
  *   <li>{@link Offer#getApplications()}
  *   <li>{@link Offer#getAssignmentCity()}
  *   <li>{@link Offer#getCompany()}
  *   <li>{@link Offer#getDescription()}
  *   <li>{@link Offer#getDiplomaTypes()}
  *   <li>{@link Offer#getDomains()}
  *   <li>{@link Offer#getExpirationDate()}
  *   <li>{@link Offer#getOfferId()}
  *   <li>{@link Offer#getOfferName()}
  *   <li>{@link Offer#getPublicationDate()}
  *   <li>{@link Offer#getSalaryMax()}
  *   <li>{@link Offer#getSalaryMin()}
  *   <li>{@link Offer#getStudentLanguages()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Offer actualOffer = new Offer();
    HashSet<Application> applications = new HashSet<>();
    actualOffer.setApplications(applications);
    actualOffer.setAssignmentCity("Assignment City");
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
    actualOffer.setCompany(company);
    actualOffer.setDescription("The characteristics of someone or something");
    HashSet<DiplomaType> diplomaTypes = new HashSet<>();
    actualOffer.setDiplomaTypes(diplomaTypes);
    HashSet<Domain> domains = new HashSet<>();
    actualOffer.setDomains(domains);
    Date ExpirationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualOffer.setExpirationDate(ExpirationDate);
    actualOffer.setOfferId(1);
    actualOffer.setOfferName("Offer Name");
    Date publicationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualOffer.setPublicationDate(publicationDate);
    actualOffer.setSalaryMax(10.0d);
    actualOffer.setSalaryMin(10.0d);
    HashSet<StudentLanguage> studentLanguages = new HashSet<>();
    actualOffer.setStudentLanguages(studentLanguages);
    actualOffer.toString();
    Set<Application> actualApplications = actualOffer.getApplications();
    String actualAssignmentCity = actualOffer.getAssignmentCity();
    Company actualCompany = actualOffer.getCompany();
    String actualDescription = actualOffer.getDescription();
    Set<DiplomaType> actualDiplomaTypes = actualOffer.getDiplomaTypes();
    Set<Domain> actualDomains = actualOffer.getDomains();
    Date actualExpirationDate = actualOffer.getExpirationDate();
    int actualOfferId = actualOffer.getOfferId();
    String actualOfferName = actualOffer.getOfferName();
    Date actualPublicationDate = actualOffer.getPublicationDate();
    double actualSalaryMax = actualOffer.getSalaryMax();
    double actualSalaryMin = actualOffer.getSalaryMin();

    // Assert that nothing has changed
    assertEquals("Assignment City", actualAssignmentCity);
    assertEquals("Offer Name", actualOfferName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1, actualOfferId);
    assertEquals(10.0d, actualSalaryMax);
    assertEquals(10.0d, actualSalaryMin);
    assertSame(applications, actualApplications);
    assertSame(diplomaTypes, actualDiplomaTypes);
    assertSame(domains, actualDomains);
    assertSame(studentLanguages, actualOffer.getStudentLanguages());
    assertSame(company, actualCompany);
    assertSame(ExpirationDate, actualExpirationDate);
    assertSame(publicationDate, actualPublicationDate);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, null);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, "Different type to Offer");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Offer#equals(Object)}
   *   <li>{@link Offer#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(offer, offer);
    int expectedHashCodeResult = offer.hashCode();
    assertEquals(expectedHashCodeResult, offer.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Offer#equals(Object)}
   *   <li>{@link Offer#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(offer, offer2);
    int expectedHashCodeResult = offer.hashCode();
    assertEquals(expectedHashCodeResult, offer2.hashCode());
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(new CompanyLegalForm());
    company.setCompanyName("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyWebsite("Jan 1, 2020 8:00am GMT+0100");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Jan 1, 2020 8:00am GMT+0100");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Jan 1, 2020 8:00am GMT+0100");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("Jan 1, 2020 8:00am GMT+0100");
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
    student.setName("Jan 1, 2020 8:00am GMT+0100");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

    Application.ApplicationPk applicationPk = new Application.ApplicationPk();
    applicationPk.setOffer(offer);
    applicationPk.setStudent(student);

    Application application = new Application();
    application
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    application.setApplicationPk(applicationPk);
    application.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    application.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    application.setStatus(Application.AppStatus.VALIDATED);
    application.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    application.setUpdatedBy("2020-03-01");

    HashSet<Application> applications = new HashSet<>();
    applications.add(application);

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm);
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

    Offer offer2 = new Offer();
    offer2.setApplications(applications);
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company3 = new Company();
    company3.setAddress1("42 Main St");
    company3.setAddress2("42 Main St");
    company3.setCity("Oxford");
    company3.setCompanyEmail("jane.doe@example.org");
    company3.setCompanyId(1);
    company3.setCompanyLegalForm(companyLegalForm2);
    company3.setCompanyName("Company Name");
    company3.setCompanyPhone("6625550144");
    company3.setCompanyResponsibles(new HashSet<>());
    company3.setCompanySiret("Company Siret");
    company3.setCompanyWebsite("Company Website");
    company3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company3.setDomains(new HashSet<>());
    company3.setImageUrl("https://example.org/example");
    company3.setRegion("us-east-2");
    company3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company3.setUpdatedBy("2020-03-01");
    company3.setZipCode("21654");

    Offer offer3 = new Offer();
    offer3.setApplications(new HashSet<>());
    offer3.setAssignmentCity("Assignment City");
    offer3.setCompany(company3);
    offer3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer3.setDescription("The characteristics of someone or something");
    offer3.setDiplomaTypes(new HashSet<>());
    offer3.setDomains(new HashSet<>());
    offer3.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer3.setOfferId(1);
    offer3.setOfferName("Offer Name");
    offer3.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer3.setSalaryMax(10.0d);
    offer3.setSalaryMin(10.0d);
    offer3.setStudentLanguages(new HashSet<>());
    offer3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer2, offer3);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Jan 1, 2020 8:00am GMT+0100");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity(null);
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.now().atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("Jan 1, 2020 8:00am GMT+0100");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription(null);
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(null);
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(2);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals15() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Jan 1, 2020 8:00am GMT+0100");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals16() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName(null);
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals17() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals18() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(null);
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals19() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(0.5d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }

  /**
   * Method under test: {@link Offer#equals(Object)}
   */
  @Test
  void testEquals20() {
    // Arrange
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(0.5d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offer, offer2);
  }
}

