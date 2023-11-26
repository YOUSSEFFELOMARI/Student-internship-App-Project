package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import ma.uiz.observatoire.dto.ApplicationDTO;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.ApplicationMapper;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.OfferRepository;
import ma.uiz.observatoire.repository.StudentRepository;
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

@ContextConfiguration(classes = {ApplicationService.class})
@ExtendWith(SpringExtension.class)
class ApplicationServiceTest {
  @MockBean
  private ApplicationMapper applicationMapper;

  @MockBean
  private ApplicationRepository applicationRepository;

  @Autowired
  private ApplicationService applicationService;

  @MockBean
  private OfferRepository offerRepository;

  @MockBean
  private StudentRepository studentRepository;
  /**
   * Method under test: {@link ApplicationService#showAllApplication(int, int)}
   */
  @Test
  void testShowAllApplication() {
    // Arrange
    PageImpl<Application> pageImpl = new PageImpl<>(new ArrayList<>());
    when(applicationRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Application> actualShowAllApplicationResult = applicationService.showAllApplication(10, 3);

    // Assert
    verify(applicationRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllApplicationResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllApplicationResult);
  }

  /**
   * Method under test: {@link ApplicationService#findByOfferId(int)}
   */
  @Test
  void testFindByOfferId() {
    // Arrange
    when(applicationRepository.findByApplicationPkOfferOfferId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<ApplicationDTO> actualFindByOfferIdResult = applicationService.findByOfferId(1);

    // Assert
    verify(applicationRepository).findByApplicationPkOfferOfferId(anyInt());
    assertTrue(actualFindByOfferIdResult.isEmpty());
  }

  /**
   * Method under test: {@link ApplicationService#findByOfferId(int)}
   */
  @Test
  void testFindByOfferId2() {
    // Arrange
    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(new CompanyLegalForm());
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

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    when(applicationRepository.findByApplicationPkOfferOfferId(anyInt())).thenReturn(applicationList);

    CompanyDTO company2 = new CompanyDTO();
    company2.setCompanyId(1);
    company2.setCompanyName("Company Name");

    OfferDTO offer2 = new OfferDTO();
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate("2020-03-01");
    offer2.setLanguages(new HashSet<>());
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate("2020-03-01");
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);

    ApplicationDTO applicationDTO = new ApplicationDTO();
    applicationDTO
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    applicationDTO.setOffer(offer2);
    applicationDTO.setStatus(Application.AppStatus.VALIDATED);
    applicationDTO.setStudent(student2);
    when(applicationMapper.mapToDto(Mockito.<Application>any())).thenReturn(applicationDTO);

    // Act
    List<ApplicationDTO> actualFindByOfferIdResult = applicationService.findByOfferId(1);

    // Assert
    verify(applicationMapper).mapToDto(Mockito.<Application>any());
    verify(applicationRepository).findByApplicationPkOfferOfferId(anyInt());
    assertEquals(1, actualFindByOfferIdResult.size());
  }

  /**
   * Method under test: {@link ApplicationService#findByOfferId(int)}
   */
  @Test
  void testFindByOfferId3() {
    // Arrange
    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(new CompanyLegalForm());
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

    Company company2 = new Company();
    company2.setAddress1("17 High St");
    company2.setAddress2("17 High St");
    company2.setCity("London");
    company2.setCompanyEmail("john.smith@example.org");
    company2.setCompanyId(2);
    company2.setCompanyLegalForm(new CompanyLegalForm());
    company2.setCompanyName("ma.uiz.observatoire.model.Company");
    company2.setCompanyPhone("8605550118");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("ma.uiz.observatoire.model.Company");
    company2.setCompanyWebsite("ma.uiz.observatoire.model.Company");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Created By");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("Image Url");
    company2.setRegion("Region");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020/03/01");
    company2.setZipCode("OX1 1PT");

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("ma.uiz.observatoire.model.Offer");
    offer2.setCompany(company2);
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

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    when(applicationRepository.findByApplicationPkOfferOfferId(anyInt())).thenReturn(applicationList);

    CompanyDTO company3 = new CompanyDTO();
    company3.setCompanyId(1);
    company3.setCompanyName("Company Name");

    OfferDTO offer3 = new OfferDTO();
    offer3.setAssignmentCity("Assignment City");
    offer3.setCompany(company3);
    offer3.setDescription("The characteristics of someone or something");
    offer3.setDiplomaTypes(new HashSet<>());
    offer3.setDomains(new HashSet<>());
    offer3.setExpirationDate("2020-03-01");
    offer3.setLanguages(new HashSet<>());
    offer3.setOfferId(1);
    offer3.setOfferName("Offer Name");
    offer3.setPublicationDate("2020-03-01");
    offer3.setSalaryMax(10.0d);
    offer3.setSalaryMin(10.0d);

    StudentDTO student3 = new StudentDTO();
    student3.setAccount(3);
    student3.setCertificates(new HashSet<>());
    student3.setExperiences(new HashSet<>());
    student3.setHobbies(new HashSet<>());
    student3.setLanguages(new HashSet<>());
    student3.setLastName("Doe");
    student3.setLicences(new HashSet<>());
    student3.setName("Name");
    student3.setSkills(new HashSet<>());
    student3.setStudentDiplomas(new HashSet<>());
    student3.setStudentId(1);

    ApplicationDTO applicationDTO = new ApplicationDTO();
    applicationDTO
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    applicationDTO.setOffer(offer3);
    applicationDTO.setStatus(Application.AppStatus.VALIDATED);
    applicationDTO.setStudent(student3);
    when(applicationMapper.mapToDto(Mockito.<Application>any())).thenReturn(applicationDTO);

    // Act
    List<ApplicationDTO> actualFindByOfferIdResult = applicationService.findByOfferId(1);

    // Assert
    verify(applicationMapper, atLeast(1)).mapToDto(Mockito.<Application>any());
    verify(applicationRepository).findByApplicationPkOfferOfferId(anyInt());
    assertEquals(2, actualFindByOfferIdResult.size());
  }

  /**
   * Method under test: {@link ApplicationService#findByStudentId(int)}
   */
  @Test
  void testFindByStudentId() {
    // Arrange
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<ApplicationDTO> actualFindByStudentIdResult = applicationService.findByStudentId(1);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    assertTrue(actualFindByStudentIdResult.isEmpty());
  }

  /**
   * Method under test: {@link ApplicationService#findByStudentId(int)}
   */
  @Test
  void testFindByStudentId2() {
    // Arrange
    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(new CompanyLegalForm());
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

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(applicationList);

    CompanyDTO company2 = new CompanyDTO();
    company2.setCompanyId(1);
    company2.setCompanyName("Company Name");

    OfferDTO offer2 = new OfferDTO();
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate("2020-03-01");
    offer2.setLanguages(new HashSet<>());
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate("2020-03-01");
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);

    ApplicationDTO applicationDTO = new ApplicationDTO();
    applicationDTO
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    applicationDTO.setOffer(offer2);
    applicationDTO.setStatus(Application.AppStatus.VALIDATED);
    applicationDTO.setStudent(student2);
    when(applicationMapper.mapToDto(Mockito.<Application>any())).thenReturn(applicationDTO);

    // Act
    List<ApplicationDTO> actualFindByStudentIdResult = applicationService.findByStudentId(1);

    // Assert
    verify(applicationMapper).mapToDto(Mockito.<Application>any());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    assertEquals(1, actualFindByStudentIdResult.size());
  }

  /**
   * Method under test: {@link ApplicationService#findByStudentId(int)}
   */
  @Test
  void testFindByStudentId3() {
    // Arrange
    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(new CompanyLegalForm());
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

    Company company2 = new Company();
    company2.setAddress1("17 High St");
    company2.setAddress2("17 High St");
    company2.setCity("London");
    company2.setCompanyEmail("john.smith@example.org");
    company2.setCompanyId(2);
    company2.setCompanyLegalForm(new CompanyLegalForm());
    company2.setCompanyName("ma.uiz.observatoire.model.Company");
    company2.setCompanyPhone("8605550118");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("ma.uiz.observatoire.model.Company");
    company2.setCompanyWebsite("ma.uiz.observatoire.model.Company");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Created By");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("Image Url");
    company2.setRegion("Region");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020/03/01");
    company2.setZipCode("OX1 1PT");

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("ma.uiz.observatoire.model.Offer");
    offer2.setCompany(company2);
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

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(applicationList);

    CompanyDTO company3 = new CompanyDTO();
    company3.setCompanyId(1);
    company3.setCompanyName("Company Name");

    OfferDTO offer3 = new OfferDTO();
    offer3.setAssignmentCity("Assignment City");
    offer3.setCompany(company3);
    offer3.setDescription("The characteristics of someone or something");
    offer3.setDiplomaTypes(new HashSet<>());
    offer3.setDomains(new HashSet<>());
    offer3.setExpirationDate("2020-03-01");
    offer3.setLanguages(new HashSet<>());
    offer3.setOfferId(1);
    offer3.setOfferName("Offer Name");
    offer3.setPublicationDate("2020-03-01");
    offer3.setSalaryMax(10.0d);
    offer3.setSalaryMin(10.0d);

    StudentDTO student3 = new StudentDTO();
    student3.setAccount(3);
    student3.setCertificates(new HashSet<>());
    student3.setExperiences(new HashSet<>());
    student3.setHobbies(new HashSet<>());
    student3.setLanguages(new HashSet<>());
    student3.setLastName("Doe");
    student3.setLicences(new HashSet<>());
    student3.setName("Name");
    student3.setSkills(new HashSet<>());
    student3.setStudentDiplomas(new HashSet<>());
    student3.setStudentId(1);

    ApplicationDTO applicationDTO = new ApplicationDTO();
    applicationDTO
        .setApplicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    applicationDTO.setOffer(offer3);
    applicationDTO.setStatus(Application.AppStatus.VALIDATED);
    applicationDTO.setStudent(student3);
    when(applicationMapper.mapToDto(Mockito.<Application>any())).thenReturn(applicationDTO);

    // Act
    List<ApplicationDTO> actualFindByStudentIdResult = applicationService.findByStudentId(1);

    // Assert
    verify(applicationMapper, atLeast(1)).mapToDto(Mockito.<Application>any());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    assertEquals(2, actualFindByStudentIdResult.size());
  }

  /**
   * Method under test: {@link ApplicationService#update(Application)}
   */
  @Test
  void testUpdate() {
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
    when(applicationRepository.save(Mockito.<Application>any())).thenReturn(application);
    when(applicationRepository.existsById(Mockito.<Application.ApplicationPk>any())).thenReturn(true);

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

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");

    Application.ApplicationPk applicationPk2 = new Application.ApplicationPk();
    applicationPk2.setOffer(offer2);
    applicationPk2.setStudent(student2);

    Application applicationt = new Application();
    Date applicationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    applicationt.setApplicationDate(applicationDate);
    applicationt.setApplicationPk(applicationPk2);
    applicationt.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    applicationt.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    applicationt.setStatus(Application.AppStatus.VALIDATED);
    applicationt.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    applicationt.setUpdatedBy("2020-03-01");

    // Act
    applicationService.update(applicationt);

    // Assert that nothing has changed
    verify(applicationRepository).existsById(Mockito.<Application.ApplicationPk>any());
    verify(applicationRepository).save(Mockito.<Application>any());
    assertEquals("00:00", applicationt.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", applicationt.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", applicationt.getUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", applicationt.getCreatedBy());
    assertEquals(Application.AppStatus.VALIDATED, applicationt.getStatus());
    assertSame(applicationPk2, applicationt.getApplicationPk());
    assertSame(applicationDate, applicationt.getApplicationDate());
  }

  /**
  * Method under test: {@link ApplicationService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(applicationRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = applicationService.count();

    // Assert
    verify(applicationRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

