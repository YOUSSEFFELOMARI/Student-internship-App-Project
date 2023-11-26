package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.StudentCertificate;
import ma.uiz.observatoire.model.StudentDiploma;
import ma.uiz.observatoire.model.StudentExperience;
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.model.StudentLicence;
import ma.uiz.observatoire.model.StudentSkill;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.StudentDiplomaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentMapperImpl.class})
@ExtendWith(SpringExtension.class)
class StudentMapperTest {
  @MockBean
  private ApplicationRepository applicationRepository;

  @MockBean
  private StudentDiplomaRepository studentDiplomaRepository;

  @Autowired
  private StudentMapper studentMapper;
  /**
   * Method under test: {@link StudentMapper#beforeMapping(Student)}
   */
  @Test
  void testBeforeMapping() {
    // Arrange
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(new ArrayList<>());
    when(studentDiplomaRepository.findByStudentDiplomaIdStudentStudentId(anyInt())).thenReturn(new ArrayList<>());

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

    // Act
    studentMapper.beforeMapping(student);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertTrue(student.getApplications().isEmpty());
    assertTrue(student.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapper#beforeMapping(Student)}
   */
  @Test
  void testBeforeMapping2() {
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
    when(studentDiplomaRepository.findByStudentDiplomaIdStudentStudentId(anyInt())).thenReturn(new ArrayList<>());

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

    // Act
    studentMapper.beforeMapping(student2);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals(1, student2.getApplications().size());
    assertTrue(student2.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapper#beforeMapping(Student)}
   */
  @Test
  void testBeforeMapping3() {
    // Arrange
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(new ArrayList<>());

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    StudentDiploma studentDiploma = new StudentDiploma();
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    ArrayList<StudentDiploma> studentDiplomaList = new ArrayList<>();
    studentDiplomaList.add(studentDiploma);
    when(studentDiplomaRepository.findByStudentDiplomaIdStudentStudentId(anyInt())).thenReturn(studentDiplomaList);

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

    // Act
    studentMapper.beforeMapping(student2);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals(1, student2.getStudentDiplomas().size());
    assertTrue(student2.getApplications().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapper#beforeMapping(Student)}
   */
  @Test
  void testBeforeMapping4() {
    // Arrange
    when(applicationRepository.findByApplicationPkStudentStudentId(anyInt())).thenReturn(new ArrayList<>());

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    StudentDiploma studentDiploma = new StudentDiploma();
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Created By");
    diplomaType2.setDiplomaAbbreviation("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(2);
    diplomaType2.setDiplomaTypeName("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020/03/01");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Created By");
    establishment2.setEstablishmentEmail("john.smith@example.org");
    establishment2.setEstablishmentId(2);
    establishment2.setEstablishmentPhone("8605550118");
    establishment2.setEstablishmentTitle("Mr");
    establishment2.setEstablishmentWebSite("ma.uiz.observatoire.model.Establishment");
    establishment2.setImageUrl("Image Url");
    establishment2.setUniversity(new University());
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020/03/01");

    Diploma diploma2 = new Diploma();
    diploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setCreatedBy("Created By");
    diploma2.setDiplomaId(2);
    diploma2.setDiplomaName("ma.uiz.observatoire.model.Diploma");
    diploma2.setDiplomaType(diplomaType2);
    diploma2.setEstablishment(establishment2);
    diploma2.setSpecialities(new HashSet<>());
    diploma2.setStudentDiplomas(new ArrayList<>());
    diploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setUpdatedBy("2020/03/01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId2 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId2.setDiploma(diploma2);
    studentDiplomaId2.setStudent(student2);

    StudentDiploma studentDiploma2 = new StudentDiploma();
    studentDiploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setCreatedBy("Created By");
    studentDiploma2.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStudentDiplomaId(studentDiplomaId2);
    studentDiploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setUpdatedBy("2020/03/01");

    ArrayList<StudentDiploma> studentDiplomaList = new ArrayList<>();
    studentDiplomaList.add(studentDiploma2);
    studentDiplomaList.add(studentDiploma);
    when(studentDiplomaRepository.findByStudentDiplomaIdStudentStudentId(anyInt())).thenReturn(studentDiplomaList);

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

    Student student3 = new Student();
    student3.setAccount(account3);
    student3.setAddress1("42 Main St");
    student3.setAddress2("42 Main St");
    student3.setApplications(new HashSet<>());
    student3.setCIN("CIN");
    student3.setCertificates(new HashSet<>());
    student3.setCity("Oxford");
    student3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student3.setExperiences(new HashSet<>());
    student3.setHobbies(new HashSet<>());
    student3.setImageUrl("https://example.org/example");
    student3.setLanguages(new HashSet<>());
    student3.setLastName("Doe");
    student3.setLicences(new HashSet<>());
    student3.setName("Name");
    student3.setRegion("us-east-2");
    student3.setSkills(new HashSet<>());
    student3.setStudentDiplomas(new HashSet<>());
    student3.setStudentId(1);
    student3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setUpdatedBy("2020-03-01");
    student3.setZipCode("21654");

    // Act
    studentMapper.beforeMapping(student3);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals(2, student3.getStudentDiplomas().size());
    assertTrue(student3.getApplications().isEmpty());
  }

  /**
  * Method under test: {@link StudentMapper#afterMapping(Student)}
  */
  @Test
  void testAfterMapping() {
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

    // Act
    studentMapper.afterMapping(student);

    // Assert that nothing has changed
    assertEquals("00:00", student.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", student.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", student.getUpdatedBy());
    assertEquals("21654", student.getZipCode());
    assertEquals("42 Main St", student.getAddress1());
    assertEquals("42 Main St", student.getAddress2());
    assertEquals("CIN", student.getCIN());
    assertEquals("Doe", student.getLastName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", student.getCreatedBy());
    assertEquals("Name", student.getName());
    assertEquals("Oxford", student.getCity());
    assertEquals("https://example.org/example", student.getImageUrl());
    assertEquals("us-east-2", student.getRegion());
    assertEquals(1, student.getStudentId());
    assertTrue(student.getApplications().isEmpty());
    assertTrue(student.getCertificates().isEmpty());
    assertTrue(student.getExperiences().isEmpty());
    assertTrue(student.getHobbies().isEmpty());
    assertTrue(student.getLanguages().isEmpty());
    assertTrue(student.getLicences().isEmpty());
    assertTrue(student.getSkills().isEmpty());
    assertTrue(student.getStudentDiplomas().isEmpty());
    assertSame(account, student.getAccount());
  }

  /**
   * Method under test: {@link StudentMapper#afterMapping(Student)}
   */
  @Test
  void testAfterMapping2() {
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
    Student student = mock(Student.class);
    when(student.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(student).setAddress1(Mockito.<String>any());
    doNothing().when(student).setAddress2(Mockito.<String>any());
    doNothing().when(student).setCity(Mockito.<String>any());
    doNothing().when(student).setRegion(Mockito.<String>any());
    doNothing().when(student).setZipCode(Mockito.<String>any());
    doNothing().when(student).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student).setCreatedBy(Mockito.<String>any());
    doNothing().when(student).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student).setUpdatedBy(Mockito.<String>any());
    doNothing().when(student).setAccount(Mockito.<Account>any());
    doNothing().when(student).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(student).setCIN(Mockito.<String>any());
    doNothing().when(student).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(student).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(student).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(student).setImageUrl(Mockito.<String>any());
    doNothing().when(student).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(student).setLastName(Mockito.<String>any());
    doNothing().when(student).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(student).setName(Mockito.<String>any());
    doNothing().when(student).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(student).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(student).setStudentId(anyInt());
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

    // Act
    studentMapper.afterMapping(student);

    // Assert
    verify(student).setAddress1(Mockito.<String>any());
    verify(student).setAddress2(Mockito.<String>any());
    verify(student).setCity(Mockito.<String>any());
    verify(student).setRegion(Mockito.<String>any());
    verify(student).setZipCode(Mockito.<String>any());
    verify(student).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(student).setCreatedBy(Mockito.<String>any());
    verify(student).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(student).setUpdatedBy(Mockito.<String>any());
    verify(student).getStudentDiplomas();
    verify(student).setAccount(Mockito.<Account>any());
    verify(student).setApplications(Mockito.<Set<Application>>any());
    verify(student).setCIN(Mockito.<String>any());
    verify(student).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(student).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(student).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(student).setImageUrl(Mockito.<String>any());
    verify(student).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(student).setLastName(Mockito.<String>any());
    verify(student).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(student).setName(Mockito.<String>any());
    verify(student).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(student).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(student).setStudentId(anyInt());
  }

  /**
   * Method under test: {@link StudentMapper#afterMapping(Student)}
   */
  @Test
  void testAfterMapping3() {
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

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    StudentDiploma studentDiploma = new StudentDiploma();
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    HashSet<StudentDiploma> studentDiplomaSet = new HashSet<>();
    studentDiplomaSet.add(studentDiploma);
    Student student2 = mock(Student.class);
    when(student2.getStudentDiplomas()).thenReturn(studentDiplomaSet);
    doNothing().when(student2).setAddress1(Mockito.<String>any());
    doNothing().when(student2).setAddress2(Mockito.<String>any());
    doNothing().when(student2).setCity(Mockito.<String>any());
    doNothing().when(student2).setRegion(Mockito.<String>any());
    doNothing().when(student2).setZipCode(Mockito.<String>any());
    doNothing().when(student2).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student2).setCreatedBy(Mockito.<String>any());
    doNothing().when(student2).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student2).setUpdatedBy(Mockito.<String>any());
    doNothing().when(student2).setAccount(Mockito.<Account>any());
    doNothing().when(student2).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(student2).setCIN(Mockito.<String>any());
    doNothing().when(student2).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(student2).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(student2).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(student2).setImageUrl(Mockito.<String>any());
    doNothing().when(student2).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(student2).setLastName(Mockito.<String>any());
    doNothing().when(student2).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(student2).setName(Mockito.<String>any());
    doNothing().when(student2).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(student2).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(student2).setStudentId(anyInt());
    student2.setAccount(account);
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

    // Act
    studentMapper.afterMapping(student2);

    // Assert
    verify(student2).setAddress1(Mockito.<String>any());
    verify(student2).setAddress2(Mockito.<String>any());
    verify(student2).setCity(Mockito.<String>any());
    verify(student2).setRegion(Mockito.<String>any());
    verify(student2).setZipCode(Mockito.<String>any());
    verify(student2).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(student2).setCreatedBy(Mockito.<String>any());
    verify(student2).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(student2).setUpdatedBy(Mockito.<String>any());
    verify(student2).getStudentDiplomas();
    verify(student2).setAccount(Mockito.<Account>any());
    verify(student2).setApplications(Mockito.<Set<Application>>any());
    verify(student2).setCIN(Mockito.<String>any());
    verify(student2).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(student2).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(student2).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(student2).setImageUrl(Mockito.<String>any());
    verify(student2).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(student2).setLastName(Mockito.<String>any());
    verify(student2).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(student2).setName(Mockito.<String>any());
    verify(student2).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(student2).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(student2).setStudentId(anyInt());
  }

  /**
   * Method under test: {@link StudentMapper#afterMapping(Student)}
   */
  @Test
  void testAfterMapping4() {
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

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    StudentDiploma studentDiploma = new StudentDiploma();
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Created By");
    diplomaType2.setDiplomaAbbreviation("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setDiplomaLevel(0);
    diplomaType2.setDiplomaTypeId(2);
    diplomaType2.setDiplomaTypeName("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020/03/01");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Created By");
    establishment2.setEstablishmentEmail("john.smith@example.org");
    establishment2.setEstablishmentId(2);
    establishment2.setEstablishmentPhone("8605550118");
    establishment2.setEstablishmentTitle("Mr");
    establishment2.setEstablishmentWebSite("ma.uiz.observatoire.model.Establishment");
    establishment2.setImageUrl("Image Url");
    establishment2.setUniversity(new University());
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020/03/01");

    Diploma diploma2 = new Diploma();
    diploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setCreatedBy("Created By");
    diploma2.setDiplomaId(2);
    diploma2.setDiplomaName("ma.uiz.observatoire.model.Diploma");
    diploma2.setDiplomaType(diplomaType2);
    diploma2.setEstablishment(establishment2);
    diploma2.setSpecialities(new HashSet<>());
    diploma2.setStudentDiplomas(new ArrayList<>());
    diploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setUpdatedBy("2020/03/01");

    Account account3 = new Account();
    account3.setAccountId(2);
    account3.setAccountRoles(new HashSet<>());
    account3.setConversations(new HashSet<>());
    account3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setCreatedBy("Created By");
    account3.setEmail("john.smith@example.org");
    account3.setEnabled(false);
    account3.setMobileNumber("Mobile Number");
    account3.setPassword("Password");
    account3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account3.setUpdatedBy("2020/03/01");
    account3.setUserName("User Name");

    Student student2 = new Student();
    student2.setAccount(account3);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaId2 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId2.setDiploma(diploma2);
    studentDiplomaId2.setStudent(student2);

    StudentDiploma studentDiploma2 = new StudentDiploma();
    studentDiploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setCreatedBy("Created By");
    studentDiploma2.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStudentDiplomaId(studentDiplomaId2);
    studentDiploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setUpdatedBy("2020/03/01");

    HashSet<StudentDiploma> studentDiplomaSet = new HashSet<>();
    studentDiplomaSet.add(studentDiploma2);
    studentDiplomaSet.add(studentDiploma);
    Student student3 = mock(Student.class);
    when(student3.getStudentDiplomas()).thenReturn(studentDiplomaSet);
    doNothing().when(student3).setAddress1(Mockito.<String>any());
    doNothing().when(student3).setAddress2(Mockito.<String>any());
    doNothing().when(student3).setCity(Mockito.<String>any());
    doNothing().when(student3).setRegion(Mockito.<String>any());
    doNothing().when(student3).setZipCode(Mockito.<String>any());
    doNothing().when(student3).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student3).setCreatedBy(Mockito.<String>any());
    doNothing().when(student3).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student3).setUpdatedBy(Mockito.<String>any());
    doNothing().when(student3).setAccount(Mockito.<Account>any());
    doNothing().when(student3).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(student3).setCIN(Mockito.<String>any());
    doNothing().when(student3).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(student3).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(student3).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(student3).setImageUrl(Mockito.<String>any());
    doNothing().when(student3).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(student3).setLastName(Mockito.<String>any());
    doNothing().when(student3).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(student3).setName(Mockito.<String>any());
    doNothing().when(student3).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(student3).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(student3).setStudentId(anyInt());
    student3.setAccount(account);
    student3.setAddress1("42 Main St");
    student3.setAddress2("42 Main St");
    student3.setApplications(new HashSet<>());
    student3.setCIN("CIN");
    student3.setCertificates(new HashSet<>());
    student3.setCity("Oxford");
    student3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student3.setExperiences(new HashSet<>());
    student3.setHobbies(new HashSet<>());
    student3.setImageUrl("https://example.org/example");
    student3.setLanguages(new HashSet<>());
    student3.setLastName("Doe");
    student3.setLicences(new HashSet<>());
    student3.setName("Name");
    student3.setRegion("us-east-2");
    student3.setSkills(new HashSet<>());
    student3.setStudentDiplomas(new HashSet<>());
    student3.setStudentId(1);
    student3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setUpdatedBy("2020-03-01");
    student3.setZipCode("21654");

    // Act
    studentMapper.afterMapping(student3);

    // Assert
    verify(student3).setAddress1(Mockito.<String>any());
    verify(student3).setAddress2(Mockito.<String>any());
    verify(student3).setCity(Mockito.<String>any());
    verify(student3).setRegion(Mockito.<String>any());
    verify(student3).setZipCode(Mockito.<String>any());
    verify(student3).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(student3).setCreatedBy(Mockito.<String>any());
    verify(student3).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(student3).setUpdatedBy(Mockito.<String>any());
    verify(student3).getStudentDiplomas();
    verify(student3).setAccount(Mockito.<Account>any());
    verify(student3).setApplications(Mockito.<Set<Application>>any());
    verify(student3).setCIN(Mockito.<String>any());
    verify(student3).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(student3).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(student3).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(student3).setImageUrl(Mockito.<String>any());
    verify(student3).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(student3).setLastName(Mockito.<String>any());
    verify(student3).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(student3).setName(Mockito.<String>any());
    verify(student3).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(student3).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(student3).setStudentId(anyInt());
  }

  /**
   * Method under test: {@link StudentMapper#afterMapping(Student)}
   */
  @Test
  void testAfterMapping5() {
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

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    Diploma diploma2 = new Diploma();
    diploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma2.setDiplomaId(1);
    diploma2.setDiplomaName("Diploma Name");
    diploma2.setDiplomaType(diplomaType2);
    diploma2.setEstablishment(establishment2);
    diploma2.setSpecialities(new HashSet<>());
    diploma2.setStudentDiplomas(new ArrayList<>());
    diploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setUpdatedBy("2020-03-01");

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

    Student student2 = new Student();
    student2.setAccount(account3);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma2);
    studentDiplomaPk.setStudent(student2);
    StudentDiploma studentDiploma = mock(StudentDiploma.class);
    when(studentDiploma.getStudentDiplomaId()).thenReturn(studentDiplomaPk);
    doNothing().when(studentDiploma).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentDiploma).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentDiploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentDiploma).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentDiploma).setCurrentYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setEndYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setStartYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setStudentDiplomaId(Mockito.<StudentDiploma.StudentDiplomaPk>any());
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    HashSet<StudentDiploma> studentDiplomaSet = new HashSet<>();
    studentDiplomaSet.add(studentDiploma);
    Student student3 = mock(Student.class);
    when(student3.getStudentDiplomas()).thenReturn(studentDiplomaSet);
    doNothing().when(student3).setAddress1(Mockito.<String>any());
    doNothing().when(student3).setAddress2(Mockito.<String>any());
    doNothing().when(student3).setCity(Mockito.<String>any());
    doNothing().when(student3).setRegion(Mockito.<String>any());
    doNothing().when(student3).setZipCode(Mockito.<String>any());
    doNothing().when(student3).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student3).setCreatedBy(Mockito.<String>any());
    doNothing().when(student3).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(student3).setUpdatedBy(Mockito.<String>any());
    doNothing().when(student3).setAccount(Mockito.<Account>any());
    doNothing().when(student3).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(student3).setCIN(Mockito.<String>any());
    doNothing().when(student3).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(student3).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(student3).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(student3).setImageUrl(Mockito.<String>any());
    doNothing().when(student3).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(student3).setLastName(Mockito.<String>any());
    doNothing().when(student3).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(student3).setName(Mockito.<String>any());
    doNothing().when(student3).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(student3).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(student3).setStudentId(anyInt());
    student3.setAccount(account);
    student3.setAddress1("42 Main St");
    student3.setAddress2("42 Main St");
    student3.setApplications(new HashSet<>());
    student3.setCIN("CIN");
    student3.setCertificates(new HashSet<>());
    student3.setCity("Oxford");
    student3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student3.setExperiences(new HashSet<>());
    student3.setHobbies(new HashSet<>());
    student3.setImageUrl("https://example.org/example");
    student3.setLanguages(new HashSet<>());
    student3.setLastName("Doe");
    student3.setLicences(new HashSet<>());
    student3.setName("Name");
    student3.setRegion("us-east-2");
    student3.setSkills(new HashSet<>());
    student3.setStudentDiplomas(new HashSet<>());
    student3.setStudentId(1);
    student3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student3.setUpdatedBy("2020-03-01");
    student3.setZipCode("21654");

    // Act
    studentMapper.afterMapping(student3);

    // Assert
    verify(student3).setAddress1(Mockito.<String>any());
    verify(student3).setAddress2(Mockito.<String>any());
    verify(student3).setCity(Mockito.<String>any());
    verify(student3).setRegion(Mockito.<String>any());
    verify(student3).setZipCode(Mockito.<String>any());
    verify(student3).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentDiploma).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(student3).setCreatedBy(Mockito.<String>any());
    verify(studentDiploma).setCreatedBy(Mockito.<String>any());
    verify(student3).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentDiploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(student3).setUpdatedBy(Mockito.<String>any());
    verify(studentDiploma).setUpdatedBy(Mockito.<String>any());
    verify(student3).getStudentDiplomas();
    verify(student3).setAccount(Mockito.<Account>any());
    verify(student3).setApplications(Mockito.<Set<Application>>any());
    verify(student3).setCIN(Mockito.<String>any());
    verify(student3).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(student3).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(student3).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(student3).setImageUrl(Mockito.<String>any());
    verify(student3).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(student3).setLastName(Mockito.<String>any());
    verify(student3).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(student3).setName(Mockito.<String>any());
    verify(student3).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(student3).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(student3).setStudentId(anyInt());
    verify(studentDiploma).getStudentDiplomaId();
    verify(studentDiploma).setCurrentYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setEndYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setStartYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setStudentDiplomaId(Mockito.<StudentDiploma.StudentDiplomaPk>any());
  }

  /**
   * Method under test: {@link StudentMapper#mapStudentDiplomaSourceToId(StudentDiploma)}
   */
  @Test
  void testMapStudentDiplomaSourceToId() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    StudentDiploma studentDiploma = new StudentDiploma();
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapStudentDiplomaSourceToId(studentDiploma).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapStudentDiplomaSourceToId(StudentDiploma)}
   */
  @Test
  void testMapStudentDiplomaSourceToId2() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(new University());
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaId = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId.setDiploma(diploma);
    studentDiplomaId.setStudent(student);

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    Diploma diploma2 = new Diploma();
    diploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma2.setDiplomaId(1);
    diploma2.setDiplomaName("Diploma Name");
    diploma2.setDiplomaType(diplomaType2);
    diploma2.setEstablishment(establishment2);
    diploma2.setSpecialities(new HashSet<>());
    diploma2.setStudentDiplomas(new ArrayList<>());
    diploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setUpdatedBy("2020-03-01");

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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma2);
    studentDiplomaPk.setStudent(student2);
    StudentDiploma studentDiploma = mock(StudentDiploma.class);
    when(studentDiploma.getStudentDiplomaId()).thenReturn(studentDiplomaPk);
    doNothing().when(studentDiploma).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentDiploma).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentDiploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentDiploma).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentDiploma).setCurrentYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setEndYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setStartYear(Mockito.<LocalDate>any());
    doNothing().when(studentDiploma).setStudentDiplomaId(Mockito.<StudentDiploma.StudentDiplomaPk>any());
    studentDiploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    studentDiploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapStudentDiplomaSourceToIdResult = studentMapper.mapStudentDiplomaSourceToId(studentDiploma);

    // Assert
    verify(studentDiploma).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentDiploma).setCreatedBy(Mockito.<String>any());
    verify(studentDiploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentDiploma).setUpdatedBy(Mockito.<String>any());
    verify(studentDiploma).getStudentDiplomaId();
    verify(studentDiploma).setCurrentYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setEndYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setStartYear(Mockito.<LocalDate>any());
    verify(studentDiploma).setStudentDiplomaId(Mockito.<StudentDiploma.StudentDiplomaPk>any());
    assertEquals(1, actualMapStudentDiplomaSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapCertificateSourceToId(StudentCertificate)}
   */
  @Test
  void testMapCertificateSourceToId() {
    // Arrange
    StudentCertificate certificate = new StudentCertificate();
    certificate.setCertificateId(1);
    certificate.setCertificateName("Certificate Name");
    certificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    certificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    certificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    certificate.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapCertificateSourceToId(certificate).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapCertificateSourceToId(StudentCertificate)}
   */
  @Test
  void testMapCertificateSourceToId2() {
    // Arrange
    StudentCertificate certificate = mock(StudentCertificate.class);
    when(certificate.getCertificateId()).thenReturn(1);
    doNothing().when(certificate).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(certificate).setCreatedBy(Mockito.<String>any());
    doNothing().when(certificate).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(certificate).setUpdatedBy(Mockito.<String>any());
    doNothing().when(certificate).setCertificateId(anyInt());
    doNothing().when(certificate).setCertificateName(Mockito.<String>any());
    certificate.setCertificateId(1);
    certificate.setCertificateName("Certificate Name");
    certificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    certificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    certificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    certificate.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapCertificateSourceToIdResult = studentMapper.mapCertificateSourceToId(certificate);

    // Assert
    verify(certificate).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(certificate).setCreatedBy(Mockito.<String>any());
    verify(certificate).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(certificate).setUpdatedBy(Mockito.<String>any());
    verify(certificate).getCertificateId();
    verify(certificate).setCertificateId(anyInt());
    verify(certificate).setCertificateName(Mockito.<String>any());
    assertEquals(1, actualMapCertificateSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapExperienceSourceToId(StudentExperience)}
   */
  @Test
  void testMapExperienceSourceToId() {
    // Arrange
    StudentExperience experience = new StudentExperience();
    experience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    experience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    experience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    experience.setExperienceDescription("Experience Description");
    experience.setExperienceId(1);
    experience.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    experience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    experience.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapExperienceSourceToId(experience).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapExperienceSourceToId(StudentExperience)}
   */
  @Test
  void testMapExperienceSourceToId2() {
    // Arrange
    StudentExperience experience = mock(StudentExperience.class);
    when(experience.getExperienceId()).thenReturn(1);
    doNothing().when(experience).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(experience).setCreatedBy(Mockito.<String>any());
    doNothing().when(experience).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(experience).setUpdatedBy(Mockito.<String>any());
    doNothing().when(experience).setEndDate(Mockito.<Date>any());
    doNothing().when(experience).setExperienceDescription(Mockito.<String>any());
    doNothing().when(experience).setExperienceId(anyInt());
    doNothing().when(experience).setStartDate(Mockito.<Date>any());
    experience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    experience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    experience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    experience.setExperienceDescription("Experience Description");
    experience.setExperienceId(1);
    experience.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    experience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    experience.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapExperienceSourceToIdResult = studentMapper.mapExperienceSourceToId(experience);

    // Assert
    verify(experience).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(experience).setCreatedBy(Mockito.<String>any());
    verify(experience).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(experience).setUpdatedBy(Mockito.<String>any());
    verify(experience).getExperienceId();
    verify(experience).setEndDate(Mockito.<Date>any());
    verify(experience).setExperienceDescription(Mockito.<String>any());
    verify(experience).setExperienceId(anyInt());
    verify(experience).setStartDate(Mockito.<Date>any());
    assertEquals(1, actualMapExperienceSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapHobbySourceToId(StudentHobby)}
   */
  @Test
  void testMapHobbySourceToId() {
    // Arrange
    StudentHobby hobby = new StudentHobby();
    hobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    hobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    hobby.setHobbiesName("Hobbies Name");
    hobby.setHobbyId(1);
    hobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    hobby.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapHobbySourceToId(hobby).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapHobbySourceToId(StudentHobby)}
   */
  @Test
  void testMapHobbySourceToId2() {
    // Arrange
    StudentHobby hobby = mock(StudentHobby.class);
    when(hobby.getHobbyId()).thenReturn(1);
    doNothing().when(hobby).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(hobby).setCreatedBy(Mockito.<String>any());
    doNothing().when(hobby).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(hobby).setUpdatedBy(Mockito.<String>any());
    doNothing().when(hobby).setHobbiesName(Mockito.<String>any());
    doNothing().when(hobby).setHobbyId(anyInt());
    hobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    hobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    hobby.setHobbiesName("Hobbies Name");
    hobby.setHobbyId(1);
    hobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    hobby.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapHobbySourceToIdResult = studentMapper.mapHobbySourceToId(hobby);

    // Assert
    verify(hobby).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(hobby).setCreatedBy(Mockito.<String>any());
    verify(hobby).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(hobby).setUpdatedBy(Mockito.<String>any());
    verify(hobby).getHobbyId();
    verify(hobby).setHobbiesName(Mockito.<String>any());
    verify(hobby).setHobbyId(anyInt());
    assertEquals(1, actualMapHobbySourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapLanguageSourceToId(StudentLanguage)}
   */
  @Test
  void testMapLanguageSourceToId() {
    // Arrange
    StudentLanguage language = new StudentLanguage();
    language.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    language.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    language.setLanguageId(1);
    language.setLanguageLevel(1);
    language.setLanguageName("en");
    language.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    language.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapLanguageSourceToId(language).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapLanguageSourceToId(StudentLanguage)}
   */
  @Test
  void testMapLanguageSourceToId2() {
    // Arrange
    StudentLanguage language = mock(StudentLanguage.class);
    when(language.getLanguageId()).thenReturn(1);
    doNothing().when(language).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(language).setCreatedBy(Mockito.<String>any());
    doNothing().when(language).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(language).setUpdatedBy(Mockito.<String>any());
    doNothing().when(language).setLanguageId(anyInt());
    doNothing().when(language).setLanguageLevel(anyInt());
    doNothing().when(language).setLanguageName(Mockito.<String>any());
    language.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    language.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    language.setLanguageId(1);
    language.setLanguageLevel(1);
    language.setLanguageName("en");
    language.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    language.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapLanguageSourceToIdResult = studentMapper.mapLanguageSourceToId(language);

    // Assert
    verify(language).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(language).setCreatedBy(Mockito.<String>any());
    verify(language).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(language).setUpdatedBy(Mockito.<String>any());
    verify(language).getLanguageId();
    verify(language).setLanguageId(anyInt());
    verify(language).setLanguageLevel(anyInt());
    verify(language).setLanguageName(Mockito.<String>any());
    assertEquals(1, actualMapLanguageSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapSkillSourceToId(StudentSkill)}
   */
  @Test
  void testMapSkillSourceToId() {
    // Arrange
    StudentSkill skill = new StudentSkill();
    skill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    skill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    skill.setSkillId(1);
    skill.setSkillName("Skill Name");
    skill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    skill.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapSkillSourceToId(skill).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapSkillSourceToId(StudentSkill)}
   */
  @Test
  void testMapSkillSourceToId2() {
    // Arrange
    StudentSkill skill = mock(StudentSkill.class);
    when(skill.getSkillId()).thenReturn(1);
    doNothing().when(skill).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(skill).setCreatedBy(Mockito.<String>any());
    doNothing().when(skill).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(skill).setUpdatedBy(Mockito.<String>any());
    doNothing().when(skill).setSkillId(anyInt());
    doNothing().when(skill).setSkillName(Mockito.<String>any());
    skill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    skill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    skill.setSkillId(1);
    skill.setSkillName("Skill Name");
    skill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    skill.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapSkillSourceToIdResult = studentMapper.mapSkillSourceToId(skill);

    // Assert
    verify(skill).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(skill).setCreatedBy(Mockito.<String>any());
    verify(skill).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(skill).setUpdatedBy(Mockito.<String>any());
    verify(skill).getSkillId();
    verify(skill).setSkillId(anyInt());
    verify(skill).setSkillName(Mockito.<String>any());
    assertEquals(1, actualMapSkillSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapLicenceSourceToId(StudentLicence)}
   */
  @Test
  void testMapLicenceSourceToId() {
    // Arrange
    StudentLicence license = new StudentLicence();
    license.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    license.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    license.setLicenceId(1);
    license.setLicenceName("Licence Name");
    license.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    license.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(1, studentMapper.mapLicenceSourceToId(license).intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapLicenceSourceToId(StudentLicence)}
   */
  @Test
  void testMapLicenceSourceToId2() {
    // Arrange
    StudentLicence license = mock(StudentLicence.class);
    when(license.getLicenceId()).thenReturn(1);
    doNothing().when(license).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(license).setCreatedBy(Mockito.<String>any());
    doNothing().when(license).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(license).setUpdatedBy(Mockito.<String>any());
    doNothing().when(license).setLicenceId(anyInt());
    doNothing().when(license).setLicenceName(Mockito.<String>any());
    license.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    license.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    license.setLicenceId(1);
    license.setLicenceName("Licence Name");
    license.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    license.setUpdatedBy("2020-03-01");

    // Act
    Integer actualMapLicenceSourceToIdResult = studentMapper.mapLicenceSourceToId(license);

    // Assert
    verify(license).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(license).setCreatedBy(Mockito.<String>any());
    verify(license).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(license).setUpdatedBy(Mockito.<String>any());
    verify(license).getLicenceId();
    verify(license).setLicenceId(anyInt());
    verify(license).setLicenceName(Mockito.<String>any());
    assertEquals(1, actualMapLicenceSourceToIdResult.intValue());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdtoStudentDiplomaSource(Integer)}
   */
  @Test
  void testMapIdtoStudentDiplomaSource() {
    // Arrange, Act and Assert
    Diploma diploma = studentMapper.mapIdtoStudentDiplomaSource(1).getStudentDiplomaId().getDiploma();
    assertEquals(1, diploma.getDiplomaId());
    assertTrue(diploma.getStudentDiplomas().isEmpty());
    assertTrue(diploma.getSpecialities().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToCertificateSource(Integer)}
   */
  @Test
  void testMapIdToCertificateSource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToCertificateSource(1).getCertificateId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToExperienceSource(Integer)}
   */
  @Test
  void testMapIdToExperienceSource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToExperienceSource(1).getExperienceId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToHobbySource(Integer)}
   */
  @Test
  void testMapIdToHobbySource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToHobbySource(1).getHobbyId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToLanguageSource(Integer)}
   */
  @Test
  void testMapIdToLanguageSource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToLanguageSource(1).getLanguageId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToSkillSource(Integer)}
   */
  @Test
  void testMapIdToSkillSource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToSkillSource(1).getSkillId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdToLicenceSource(Integer)}
   */
  @Test
  void testMapIdToLicenceSource() {
    // Arrange, Act and Assert
    assertEquals(1, studentMapper.mapIdToLicenceSource(1).getLicenceId());
  }

  /**
   * Method under test: {@link StudentMapper#mapIdAccountSource(Integer)}
   */
  @Test
  void testMapIdAccountSource() {
    // Arrange and Act
    Account actualMapIdAccountSourceResult = studentMapper.mapIdAccountSource(1);

    // Assert
    assertEquals(1, actualMapIdAccountSourceResult.getAccountId());
    assertTrue(actualMapIdAccountSourceResult.getAuthorities().isEmpty());
    assertTrue(actualMapIdAccountSourceResult.getConversations().isEmpty());
  }
}

