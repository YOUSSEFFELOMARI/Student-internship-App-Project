package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.repository.DiplomaTypeRepository;
import ma.uiz.observatoire.repository.DomainRepository;
import ma.uiz.observatoire.repository.StudentDiplomaRepository;
import ma.uiz.observatoire.repository.StudentLanguageRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OfferMapperImpl.class})
@ExtendWith(SpringExtension.class)
class OfferMapperTest {
  @MockBean
  private ApplicationRepository applicationRepository;

  @MockBean
  private CompanyRepository companyRepository;

  @MockBean
  private DiplomaTypeRepository diplomaTypeRepository;

  @MockBean
  private DomainRepository domainRepository;

  @Autowired
  private OfferMapper offerMapper;

  @MockBean
  private StudentDiplomaRepository studentDiplomaRepository;

  @MockBean
  private StudentLanguageRepository studentLanguageRepository;

  @MockBean
  private StudentRepository studentRepository;
  /**
  * Method under test: {@link OfferMapper#afterMapping(Offer)}
  */
  @Test
  void testAfterMapping() {
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
    Date ExpirationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offer.setExpirationDate(ExpirationDate);
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    Date publicationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offer.setPublicationDate(publicationDate);
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");

    // Act
    offerMapper.afterMapping(offer);

    // Assert that nothing has changed
    assertEquals("00:00", offer.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", offer.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", offer.getUpdatedBy());
    assertEquals("Assignment City", offer.getAssignmentCity());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", offer.getCreatedBy());
    assertEquals("Offer Name", offer.getOfferName());
    assertEquals("The characteristics of someone or something", offer.getDescription());
    assertEquals(1, offer.getOfferId());
    assertEquals(10.0d, offer.getSalaryMax());
    assertEquals(10.0d, offer.getSalaryMin());
    assertTrue(offer.getApplications().isEmpty());
    assertTrue(offer.getDiplomaTypes().isEmpty());
    assertTrue(offer.getDomains().isEmpty());
    assertTrue(offer.getStudentLanguages().isEmpty());
    assertSame(company, offer.getCompany());
    assertSame(ExpirationDate, offer.getExpirationDate());
    assertSame(publicationDate, offer.getPublicationDate());
  }

  /**
   * Method under test: {@link OfferMapper#afterMapping(Offer)}
   */
  @Test
  void testAfterMapping2() {
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
    Offer offer = mock(Offer.class);
    when(offer.getApplications()).thenReturn(new HashSet<>());
    doNothing().when(offer).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer).setCreatedBy(Mockito.<String>any());
    doNothing().when(offer).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer).setUpdatedBy(Mockito.<String>any());
    doNothing().when(offer).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(offer).setAssignmentCity(Mockito.<String>any());
    doNothing().when(offer).setCompany(Mockito.<Company>any());
    doNothing().when(offer).setDescription(Mockito.<String>any());
    doNothing().when(offer).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    doNothing().when(offer).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(offer).setExpirationDate(Mockito.<Date>any());
    doNothing().when(offer).setOfferId(anyInt());
    doNothing().when(offer).setOfferName(Mockito.<String>any());
    doNothing().when(offer).setPublicationDate(Mockito.<Date>any());
    doNothing().when(offer).setSalaryMax(anyDouble());
    doNothing().when(offer).setSalaryMin(anyDouble());
    doNothing().when(offer).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
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

    // Act
    offerMapper.afterMapping(offer);

    // Assert
    verify(offer).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(offer).setCreatedBy(Mockito.<String>any());
    verify(offer).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(offer).setUpdatedBy(Mockito.<String>any());
    verify(offer).getApplications();
    verify(offer).setApplications(Mockito.<Set<Application>>any());
    verify(offer).setAssignmentCity(Mockito.<String>any());
    verify(offer).setCompany(Mockito.<Company>any());
    verify(offer).setDescription(Mockito.<String>any());
    verify(offer).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    verify(offer).setDomains(Mockito.<Set<Domain>>any());
    verify(offer).setExpirationDate(Mockito.<Date>any());
    verify(offer).setOfferId(anyInt());
    verify(offer).setOfferName(Mockito.<String>any());
    verify(offer).setPublicationDate(Mockito.<Date>any());
    verify(offer).setSalaryMax(anyDouble());
    verify(offer).setSalaryMin(anyDouble());
    verify(offer).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
  }

  /**
   * Method under test: {@link OfferMapper#afterMapping(Offer)}
   */
  @Test
  void testAfterMapping3() {
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

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(new CompanyLegalForm());
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company2);
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

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(application);
    Offer offer2 = mock(Offer.class);
    when(offer2.getApplications()).thenReturn(applicationSet);
    doNothing().when(offer2).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer2).setCreatedBy(Mockito.<String>any());
    doNothing().when(offer2).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer2).setUpdatedBy(Mockito.<String>any());
    doNothing().when(offer2).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(offer2).setAssignmentCity(Mockito.<String>any());
    doNothing().when(offer2).setCompany(Mockito.<Company>any());
    doNothing().when(offer2).setDescription(Mockito.<String>any());
    doNothing().when(offer2).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    doNothing().when(offer2).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(offer2).setExpirationDate(Mockito.<Date>any());
    doNothing().when(offer2).setOfferId(anyInt());
    doNothing().when(offer2).setOfferName(Mockito.<String>any());
    doNothing().when(offer2).setPublicationDate(Mockito.<Date>any());
    doNothing().when(offer2).setSalaryMax(anyDouble());
    doNothing().when(offer2).setSalaryMin(anyDouble());
    doNothing().when(offer2).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company);
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

    // Act
    offerMapper.afterMapping(offer2);

    // Assert
    verify(offer2).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(offer2).setCreatedBy(Mockito.<String>any());
    verify(offer2).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(offer2).setUpdatedBy(Mockito.<String>any());
    verify(offer2).getApplications();
    verify(offer2).setApplications(Mockito.<Set<Application>>any());
    verify(offer2).setAssignmentCity(Mockito.<String>any());
    verify(offer2).setCompany(Mockito.<Company>any());
    verify(offer2).setDescription(Mockito.<String>any());
    verify(offer2).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    verify(offer2).setDomains(Mockito.<Set<Domain>>any());
    verify(offer2).setExpirationDate(Mockito.<Date>any());
    verify(offer2).setOfferId(anyInt());
    verify(offer2).setOfferName(Mockito.<String>any());
    verify(offer2).setPublicationDate(Mockito.<Date>any());
    verify(offer2).setSalaryMax(anyDouble());
    verify(offer2).setSalaryMin(anyDouble());
    verify(offer2).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
  }

  /**
   * Method under test: {@link OfferMapper#afterMapping(Offer)}
   */
  @Test
  void testAfterMapping4() {
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

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(new CompanyLegalForm());
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company2);
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

    Company company3 = new Company();
    company3.setAddress1("17 High St");
    company3.setAddress2("17 High St");
    company3.setCity("London");
    company3.setCompanyEmail("john.smith@example.org");
    company3.setCompanyId(2);
    company3.setCompanyLegalForm(new CompanyLegalForm());
    company3.setCompanyName("ma.uiz.observatoire.model.Company");
    company3.setCompanyPhone("8605550118");
    company3.setCompanyResponsibles(new HashSet<>());
    company3.setCompanySiret("ma.uiz.observatoire.model.Company");
    company3.setCompanyWebsite("ma.uiz.observatoire.model.Company");
    company3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company3.setCreatedBy("Created By");
    company3.setDomains(new HashSet<>());
    company3.setImageUrl("Image Url");
    company3.setRegion("Region");
    company3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company3.setUpdatedBy("2020/03/01");
    company3.setZipCode("OX1 1PT");

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("ma.uiz.observatoire.model.Offer");
    offer2.setCompany(company3);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Created By");
    offer2.setDescription("Description");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(2);
    offer2.setOfferName("ma.uiz.observatoire.model.Offer");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(0.5d);
    offer2.setSalaryMin(0.5d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020/03/01");

    Account account2 = new Account();
    account2.setAccountId(2);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Created By");
    account2.setEmail("john.smith@example.org");
    account2.setEnabled(false);
    account2.setMobileNumber("Mobile Number");
    account2.setPassword("Password");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020/03/01");
    account2.setUserName("User Name");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("17 High St");
    student2.setAddress2("17 High St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("ma.uiz.observatoire.model.Student");
    student2.setCertificates(new HashSet<>());
    student2.setCity("London");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Created By");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("Image Url");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Smith");
    student2.setLicences(new HashSet<>());
    student2.setName("ma.uiz.observatoire.model.Student");
    student2.setRegion("Region");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(2);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020/03/01");
    student2.setZipCode("OX1 1PT");

    Application.ApplicationPk applicationPk2 = new Application.ApplicationPk();
    applicationPk2.setOffer(offer2);
    applicationPk2.setStudent(student2);

    Application application2 = new Application();
    application2
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    application2.setApplicationPk(applicationPk2);
    application2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    application2.setCreatedBy("Created By");
    application2.setStatus(Application.AppStatus.REFUSED);
    application2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    application2.setUpdatedBy("2020/03/01");

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(application2);
    applicationSet.add(application);
    Offer offer3 = mock(Offer.class);
    when(offer3.getApplications()).thenReturn(applicationSet);
    doNothing().when(offer3).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer3).setCreatedBy(Mockito.<String>any());
    doNothing().when(offer3).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer3).setUpdatedBy(Mockito.<String>any());
    doNothing().when(offer3).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(offer3).setAssignmentCity(Mockito.<String>any());
    doNothing().when(offer3).setCompany(Mockito.<Company>any());
    doNothing().when(offer3).setDescription(Mockito.<String>any());
    doNothing().when(offer3).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    doNothing().when(offer3).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(offer3).setExpirationDate(Mockito.<Date>any());
    doNothing().when(offer3).setOfferId(anyInt());
    doNothing().when(offer3).setOfferName(Mockito.<String>any());
    doNothing().when(offer3).setPublicationDate(Mockito.<Date>any());
    doNothing().when(offer3).setSalaryMax(anyDouble());
    doNothing().when(offer3).setSalaryMin(anyDouble());
    doNothing().when(offer3).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
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

    // Act
    offerMapper.afterMapping(offer3);

    // Assert
    verify(offer3).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(offer3).setCreatedBy(Mockito.<String>any());
    verify(offer3).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(offer3).setUpdatedBy(Mockito.<String>any());
    verify(offer3).getApplications();
    verify(offer3).setApplications(Mockito.<Set<Application>>any());
    verify(offer3).setAssignmentCity(Mockito.<String>any());
    verify(offer3).setCompany(Mockito.<Company>any());
    verify(offer3).setDescription(Mockito.<String>any());
    verify(offer3).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    verify(offer3).setDomains(Mockito.<Set<Domain>>any());
    verify(offer3).setExpirationDate(Mockito.<Date>any());
    verify(offer3).setOfferId(anyInt());
    verify(offer3).setOfferName(Mockito.<String>any());
    verify(offer3).setPublicationDate(Mockito.<Date>any());
    verify(offer3).setSalaryMax(anyDouble());
    verify(offer3).setSalaryMin(anyDouble());
    verify(offer3).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
  }

  /**
   * Method under test: {@link OfferMapper#mapDiplomaTypeSourceToId(DiplomaType)}
   */
  @Test
  void testMapDiplomaTypeSourceToId() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals("Diploma Type Name", offerMapper.mapDiplomaTypeSourceToId(diplomaType));
  }

  /**
   * Method under test: {@link OfferMapper#mapDiplomaTypeSourceToId(DiplomaType)}
   */
  @Test
  void testMapDiplomaTypeSourceToId2() {
    // Arrange
    DiplomaType diplomaType = mock(DiplomaType.class);
    when(diplomaType.getDiplomaTypeName()).thenReturn("Diploma Type Name");
    doNothing().when(diplomaType).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diplomaType).setCreatedBy(Mockito.<String>any());
    doNothing().when(diplomaType).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diplomaType).setUpdatedBy(Mockito.<String>any());
    doNothing().when(diplomaType).setDiplomaAbbreviation(Mockito.<String>any());
    doNothing().when(diplomaType).setDiplomaLevel(anyInt());
    doNothing().when(diplomaType).setDiplomaTypeId(anyInt());
    doNothing().when(diplomaType).setDiplomaTypeName(Mockito.<String>any());
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    // Act
    String actualMapDiplomaTypeSourceToIdResult = offerMapper.mapDiplomaTypeSourceToId(diplomaType);

    // Assert
    verify(diplomaType).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(diplomaType).setCreatedBy(Mockito.<String>any());
    verify(diplomaType).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(diplomaType).setUpdatedBy(Mockito.<String>any());
    verify(diplomaType).getDiplomaTypeName();
    verify(diplomaType).setDiplomaAbbreviation(Mockito.<String>any());
    verify(diplomaType).setDiplomaLevel(anyInt());
    verify(diplomaType).setDiplomaTypeId(anyInt());
    verify(diplomaType).setDiplomaTypeName(Mockito.<String>any());
    assertEquals("Diploma Type Name", actualMapDiplomaTypeSourceToIdResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapLanguageSourceToId(StudentLanguage)}
   */
  @Test
  void testMapLanguageSourceToId() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals("en", offerMapper.mapLanguageSourceToId(studentLanguage));
  }

  /**
   * Method under test: {@link OfferMapper#mapLanguageSourceToId(StudentLanguage)}
   */
  @Test
  void testMapLanguageSourceToId2() {
    // Arrange
    StudentLanguage studentLanguage = mock(StudentLanguage.class);
    when(studentLanguage.getLanguageName()).thenReturn("en");
    doNothing().when(studentLanguage).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLanguage).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentLanguage).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLanguage).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentLanguage).setLanguageId(anyInt());
    doNothing().when(studentLanguage).setLanguageLevel(anyInt());
    doNothing().when(studentLanguage).setLanguageName(Mockito.<String>any());
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    // Act
    String actualMapLanguageSourceToIdResult = offerMapper.mapLanguageSourceToId(studentLanguage);

    // Assert
    verify(studentLanguage).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setCreatedBy(Mockito.<String>any());
    verify(studentLanguage).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setUpdatedBy(Mockito.<String>any());
    verify(studentLanguage).getLanguageName();
    verify(studentLanguage).setLanguageId(anyInt());
    verify(studentLanguage).setLanguageLevel(anyInt());
    verify(studentLanguage).setLanguageName(Mockito.<String>any());
    assertEquals("en", actualMapLanguageSourceToIdResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapDomainSourceToId(Domain)}
   */
  @Test
  void testMapDomainSourceToId() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals("Domain Name", offerMapper.mapDomainSourceToId(domain));
  }

  /**
   * Method under test: {@link OfferMapper#mapDomainSourceToId(Domain)}
   */
  @Test
  void testMapDomainSourceToId2() {
    // Arrange
    Domain domain = mock(Domain.class);
    when(domain.getDomainName()).thenReturn("Domain Name");
    doNothing().when(domain).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(domain).setCreatedBy(Mockito.<String>any());
    doNothing().when(domain).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(domain).setUpdatedBy(Mockito.<String>any());
    doNothing().when(domain).setDomainId(anyInt());
    doNothing().when(domain).setDomainName(Mockito.<String>any());
    doNothing().when(domain).setSpecialities(Mockito.<Set<Speciality>>any());
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    // Act
    String actualMapDomainSourceToIdResult = offerMapper.mapDomainSourceToId(domain);

    // Assert
    verify(domain).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(domain).setCreatedBy(Mockito.<String>any());
    verify(domain).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(domain).setUpdatedBy(Mockito.<String>any());
    verify(domain).getDomainName();
    verify(domain).setDomainId(anyInt());
    verify(domain).setDomainName(Mockito.<String>any());
    verify(domain).setSpecialities(Mockito.<Set<Speciality>>any());
    assertEquals("Domain Name", actualMapDomainSourceToIdResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapIdtoCompanySource(CompanyDTO)}
   */
  @Test
  void testMapIdtoCompanySource() {
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
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    CompanyDTO s = new CompanyDTO();
    s.setCompanyId(1);
    s.setCompanyName("Company Name");

    // Act
    Company actualMapIdtoCompanySourceResult = offerMapper.mapIdtoCompanySource(s);

    // Assert
    verify(companyRepository).findById(Mockito.<Integer>any());
    assertSame(company, actualMapIdtoCompanySourceResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapIdtoDiplomaTypeSource(String)}
   */
  @Test
  void testMapIdtoDiplomaTypeSource() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
    Optional<DiplomaType> ofResult = Optional.of(diplomaType);
    when(diplomaTypeRepository.findByDiplomaTypeName(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    DiplomaType actualMapIdtoDiplomaTypeSourceResult = offerMapper.mapIdtoDiplomaTypeSource("foo");

    // Assert
    verify(diplomaTypeRepository).findByDiplomaTypeName(Mockito.<String>any());
    assertSame(diplomaType, actualMapIdtoDiplomaTypeSourceResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapIdToLanguageSource(String)}
   */
  @Test
  void testMapIdToLanguageSource() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    Optional<StudentLanguage> ofResult = Optional.of(studentLanguage);
    when(studentLanguageRepository.findByLanguageName(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    StudentLanguage actualMapIdToLanguageSourceResult = offerMapper.mapIdToLanguageSource("foo");

    // Assert
    verify(studentLanguageRepository).findByLanguageName(Mockito.<String>any());
    assertSame(studentLanguage, actualMapIdToLanguageSourceResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapIdToDomainSource(String)}
   */
  @Test
  void testMapIdToDomainSource() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    Optional<Domain> ofResult = Optional.of(domain);
    when(domainRepository.findByDomainName(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    Domain actualMapIdToDomainSourceResult = offerMapper.mapIdToDomainSource("foo");

    // Assert
    verify(domainRepository).findByDomainName(Mockito.<String>any());
    assertSame(domain, actualMapIdToDomainSourceResult);
  }

  /**
   * Method under test: {@link OfferMapper#mapDateToFormattedDate(java.util.Date)}
   */
  @Test
  void testMapDateToFormattedDate() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    offerMapper.mapDateToFormattedDate(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Method under test: {@link OfferMapper#mapDateToFormattedDate(Date)}
   */
  @Test
  void testMapDateToFormattedDate2() {
    // Arrange, Act and Assert
    assertEquals("", offerMapper.mapDateToFormattedDate(null));
  }
}

