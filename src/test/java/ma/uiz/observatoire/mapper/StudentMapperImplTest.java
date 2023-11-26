package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Establishment;
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
class StudentMapperImplTest {
  @MockBean
  private ApplicationRepository applicationRepository;

  @MockBean
  private StudentDiplomaRepository studentDiplomaRepository;

  @Autowired
  private StudentMapperImpl studentMapperImpl;
  /**
  * Method under test: {@link StudentMapperImpl#integerSetToStudentCertificateSet(Set)}
  */
  @Test
  void testIntegerSetToStudentCertificateSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentCertificateSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentCertificateSet(Set)}
   */
  @Test
  void testIntegerSetToStudentCertificateSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentCertificateSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentCertificateSet(Set)}
   */
  @Test
  void testIntegerSetToStudentCertificateSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentCertificateSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentDiplomaSet(Set)}
   */
  @Test
  void testIntegerSetToStudentDiplomaSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentDiplomaSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentDiplomaSet(Set)}
   */
  @Test
  void testIntegerSetToStudentDiplomaSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentDiplomaSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentDiplomaSet(Set)}
   */
  @Test
  void testIntegerSetToStudentDiplomaSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentDiplomaSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentExperienceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentExperienceSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentExperienceSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentExperienceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentExperienceSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentExperienceSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentExperienceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentExperienceSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentExperienceSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentHobbySet(Set)}
   */
  @Test
  void testIntegerSetToStudentHobbySet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentHobbySet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentHobbySet(Set)}
   */
  @Test
  void testIntegerSetToStudentHobbySet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentHobbySet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentHobbySet(Set)}
   */
  @Test
  void testIntegerSetToStudentHobbySet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentHobbySet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLanguageSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLanguageSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentLanguageSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLanguageSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLanguageSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentLanguageSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLanguageSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLanguageSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentLanguageSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLicenceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLicenceSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentLicenceSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLicenceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLicenceSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentLicenceSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentLicenceSet(Set)}
   */
  @Test
  void testIntegerSetToStudentLicenceSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentLicenceSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentSkillSet(Set)}
   */
  @Test
  void testIntegerSetToStudentSkillSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.integerSetToStudentSkillSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentSkillSet(Set)}
   */
  @Test
  void testIntegerSetToStudentSkillSet2() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(2);

    // Act and Assert
    assertEquals(1, studentMapperImpl.integerSetToStudentSkillSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#integerSetToStudentSkillSet(Set)}
   */
  @Test
  void testIntegerSetToStudentSkillSet3() {
    // Arrange
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);

    // Act and Assert
    assertEquals(2, studentMapperImpl.integerSetToStudentSkillSet(set).size());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto() {
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

    Student s = new Student();
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
    assertTrue(s.getApplications().isEmpty());
    assertTrue(s.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto2() {
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

    Student s = new Student();
    s.setAccount(account2);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getStudentDiplomas().size());
    assertEquals(1, s.getStudentDiplomas().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(s.getApplications().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto3() {
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

    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    HashSet<StudentCertificate> studentCertificateSet = new HashSet<>();
    studentCertificateSet.add(studentCertificate);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(studentCertificateSet);
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getCertificates().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto4() {
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

    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    HashSet<StudentExperience> studentExperienceSet = new HashSet<>();
    studentExperienceSet.add(studentExperience);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(studentExperienceSet);
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getExperiences().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto5() {
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

    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    HashSet<StudentHobby> studentHobbySet = new HashSet<>();
    studentHobbySet.add(studentHobby);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(studentHobbySet);
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getHobbies().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto6() {
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

    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    HashSet<StudentLanguage> studentLanguageSet = new HashSet<>();
    studentLanguageSet.add(studentLanguage);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(studentLanguageSet);
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getLanguages().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto7() {
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

    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    HashSet<StudentLicence> studentLicenceSet = new HashSet<>();
    studentLicenceSet.add(studentLicence);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(studentLicenceSet);
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getLicences().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getSkills().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToDto(Student)}
   */
  @Test
  void testMapToDto8() {
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

    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    HashSet<StudentSkill> studentSkillSet = new HashSet<>();
    studentSkillSet.add(studentSkill);

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
    Student s = mock(Student.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(studentSkillSet);
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    when(s.getAccount()).thenReturn(account2);
    doNothing().when(s).setAddress1(Mockito.<String>any());
    doNothing().when(s).setAddress2(Mockito.<String>any());
    doNothing().when(s).setCity(Mockito.<String>any());
    doNothing().when(s).setRegion(Mockito.<String>any());
    doNothing().when(s).setZipCode(Mockito.<String>any());
    doNothing().when(s).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setCreatedBy(Mockito.<String>any());
    doNothing().when(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(s).setUpdatedBy(Mockito.<String>any());
    doNothing().when(s).setAccount(Mockito.<Account>any());
    doNothing().when(s).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(s).setCIN(Mockito.<String>any());
    doNothing().when(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    doNothing().when(s).setImageUrl(Mockito.<String>any());
    doNothing().when(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<StudentLicence>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<StudentSkill>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(account);
    s.setAddress1("42 Main St");
    s.setAddress2("42 Main St");
    s.setApplications(new HashSet<>());
    s.setCIN("CIN");
    s.setCertificates(new HashSet<>());
    s.setCity("Oxford");
    s.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setImageUrl("https://example.org/example");
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setRegion("us-east-2");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);
    s.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    s.setUpdatedBy("2020-03-01");
    s.setZipCode("21654");

    // Act
    StudentDTO actualMapToDtoResult = studentMapperImpl.mapToDto(s);

    // Assert
    verify(s).setAddress1(Mockito.<String>any());
    verify(s).setAddress2(Mockito.<String>any());
    verify(s).setCity(Mockito.<String>any());
    verify(s).setRegion(Mockito.<String>any());
    verify(s).setZipCode(Mockito.<String>any());
    verify(s).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(s).setCreatedBy(Mockito.<String>any());
    verify(s).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(s).setUpdatedBy(Mockito.<String>any());
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s, atLeast(1)).getStudentDiplomas();
    verify(s, atLeast(1)).getStudentId();
    verify(s).setAccount(Mockito.<Account>any());
    verify(s, atLeast(1)).setApplications(Mockito.<Set<Application>>any());
    verify(s).setCIN(Mockito.<String>any());
    verify(s).setCertificates(Mockito.<Set<StudentCertificate>>any());
    verify(s).setExperiences(Mockito.<Set<StudentExperience>>any());
    verify(s).setHobbies(Mockito.<Set<StudentHobby>>any());
    verify(s).setImageUrl(Mockito.<String>any());
    verify(s).setLanguages(Mockito.<Set<StudentLanguage>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<StudentLicence>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<StudentSkill>>any());
    verify(s, atLeast(1)).setStudentDiplomas(Mockito.<Set<StudentDiploma>>any());
    verify(s).setStudentId(anyInt());
    verify(applicationRepository).findByApplicationPkStudentStudentId(anyInt());
    verify(studentDiplomaRepository).findByStudentDiplomaIdStudentStudentId(anyInt());
    assertEquals("Doe", actualMapToDtoResult.getLastName());
    assertEquals("Name", actualMapToDtoResult.getName());
    assertEquals(1, actualMapToDtoResult.getAccount().intValue());
    assertEquals(1, actualMapToDtoResult.getSkills().size());
    assertEquals(1, actualMapToDtoResult.getStudentId());
    assertTrue(actualMapToDtoResult.getCertificates().isEmpty());
    assertTrue(actualMapToDtoResult.getExperiences().isEmpty());
    assertTrue(actualMapToDtoResult.getHobbies().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
    assertTrue(actualMapToDtoResult.getLicences().isEmpty());
    assertTrue(actualMapToDtoResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel() {
    // Arrange
    StudentDTO s = new StudentDTO();
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel2() {
    // Arrange
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel3() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(integerSet);
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getCertificates().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel4() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(integerSet);
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getExperiences().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel5() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(integerSet);
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getHobbies().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel6() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(integerSet);
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getLanguages().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel7() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(integerSet);
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getLicences().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel8() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(integerSet);
    when(s.getStudentDiplomas()).thenReturn(new HashSet<>());
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getSkills().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getStudentDiplomas().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#mapToModel(StudentDTO)}
   */
  @Test
  void testMapToModel9() {
    // Arrange
    HashSet<Integer> integerSet = new HashSet<>();
    integerSet.add(2);
    StudentDTO s = mock(StudentDTO.class);
    when(s.getStudentId()).thenReturn(1);
    when(s.getAccount()).thenReturn(3);
    when(s.getLastName()).thenReturn("Doe");
    when(s.getName()).thenReturn("Name");
    when(s.getCertificates()).thenReturn(new HashSet<>());
    when(s.getExperiences()).thenReturn(new HashSet<>());
    when(s.getHobbies()).thenReturn(new HashSet<>());
    when(s.getLanguages()).thenReturn(new HashSet<>());
    when(s.getLicences()).thenReturn(new HashSet<>());
    when(s.getSkills()).thenReturn(new HashSet<>());
    when(s.getStudentDiplomas()).thenReturn(integerSet);
    doNothing().when(s).setAccount(Mockito.<Integer>any());
    doNothing().when(s).setCertificates(Mockito.<Set<Integer>>any());
    doNothing().when(s).setExperiences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setHobbies(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLanguages(Mockito.<Set<Integer>>any());
    doNothing().when(s).setLastName(Mockito.<String>any());
    doNothing().when(s).setLicences(Mockito.<Set<Integer>>any());
    doNothing().when(s).setName(Mockito.<String>any());
    doNothing().when(s).setSkills(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    doNothing().when(s).setStudentId(anyInt());
    s.setAccount(3);
    s.setCertificates(new HashSet<>());
    s.setExperiences(new HashSet<>());
    s.setHobbies(new HashSet<>());
    s.setLanguages(new HashSet<>());
    s.setLastName("Doe");
    s.setLicences(new HashSet<>());
    s.setName("Name");
    s.setSkills(new HashSet<>());
    s.setStudentDiplomas(new HashSet<>());
    s.setStudentId(1);

    // Act
    Student actualMapToModelResult = studentMapperImpl.mapToModel(s);

    // Assert
    verify(s).getAccount();
    verify(s).getCertificates();
    verify(s).getExperiences();
    verify(s).getHobbies();
    verify(s).getLanguages();
    verify(s).getLastName();
    verify(s).getLicences();
    verify(s).getName();
    verify(s).getSkills();
    verify(s).getStudentDiplomas();
    verify(s).getStudentId();
    verify(s).setAccount(Mockito.<Integer>any());
    verify(s).setCertificates(Mockito.<Set<Integer>>any());
    verify(s).setExperiences(Mockito.<Set<Integer>>any());
    verify(s).setHobbies(Mockito.<Set<Integer>>any());
    verify(s).setLanguages(Mockito.<Set<Integer>>any());
    verify(s).setLastName(Mockito.<String>any());
    verify(s).setLicences(Mockito.<Set<Integer>>any());
    verify(s).setName(Mockito.<String>any());
    verify(s).setSkills(Mockito.<Set<Integer>>any());
    verify(s).setStudentDiplomas(Mockito.<Set<Integer>>any());
    verify(s).setStudentId(anyInt());
    assertEquals("Doe", actualMapToModelResult.getLastName());
    assertEquals("Name", actualMapToModelResult.getName());
    assertEquals(1, actualMapToModelResult.getStudentDiplomas().size());
    assertEquals(1, actualMapToModelResult.getStudentId());
    Account account = actualMapToModelResult.getAccount();
    assertEquals(3, account.getAccountId());
    assertTrue(account.getAccountRoles().isEmpty());
    assertTrue(account.getConversations().isEmpty());
    assertTrue(actualMapToModelResult.getApplications().isEmpty());
    assertTrue(actualMapToModelResult.getCertificates().isEmpty());
    assertTrue(actualMapToModelResult.getExperiences().isEmpty());
    assertTrue(actualMapToModelResult.getHobbies().isEmpty());
    assertTrue(actualMapToModelResult.getLanguages().isEmpty());
    assertTrue(actualMapToModelResult.getLicences().isEmpty());
    assertTrue(actualMapToModelResult.getSkills().isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentCertificateSetToIntegerSet(Set)}
   */
  @Test
  void testStudentCertificateSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentCertificateSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentCertificateSetToIntegerSet(Set)}
   */
  @Test
  void testStudentCertificateSetToIntegerSet2() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    HashSet<StudentCertificate> set = new HashSet<>();
    set.add(studentCertificate);

    // Act
    Set<Integer> actualStudentCertificateSetToIntegerSetResult = studentMapperImpl
        .studentCertificateSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentCertificateSetToIntegerSetResult.size());
    assertTrue(actualStudentCertificateSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentCertificateSetToIntegerSet(Set)}
   */
  @Test
  void testStudentCertificateSetToIntegerSet3() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(2);
    studentCertificate2.setCertificateName("ma.uiz.observatoire.model.StudentCertificate");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Created By");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020/03/01");

    HashSet<StudentCertificate> set = new HashSet<>();
    set.add(studentCertificate2);
    set.add(studentCertificate);

    // Act
    Set<Integer> actualStudentCertificateSetToIntegerSetResult = studentMapperImpl
        .studentCertificateSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentCertificateSetToIntegerSetResult.size());
    assertTrue(actualStudentCertificateSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentCertificateSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentCertificateSetToIntegerSet(Set)}
   */
  @Test
  void testStudentCertificateSetToIntegerSet4() {
    // Arrange
    StudentCertificate studentCertificate = mock(StudentCertificate.class);
    when(studentCertificate.getCertificateId()).thenReturn(1);
    doNothing().when(studentCertificate).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentCertificate).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentCertificate).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentCertificate).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentCertificate).setCertificateId(anyInt());
    doNothing().when(studentCertificate).setCertificateName(Mockito.<String>any());
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    HashSet<StudentCertificate> set = new HashSet<>();
    set.add(studentCertificate);

    // Act
    Set<Integer> actualStudentCertificateSetToIntegerSetResult = studentMapperImpl
        .studentCertificateSetToIntegerSet(set);

    // Assert
    verify(studentCertificate).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentCertificate).setCreatedBy(Mockito.<String>any());
    verify(studentCertificate).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentCertificate).setUpdatedBy(Mockito.<String>any());
    verify(studentCertificate).getCertificateId();
    verify(studentCertificate).setCertificateId(anyInt());
    verify(studentCertificate).setCertificateName(Mockito.<String>any());
    assertEquals(1, actualStudentCertificateSetToIntegerSetResult.size());
    assertTrue(actualStudentCertificateSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentDiplomaSetToIntegerSet(Set)}
   */
  @Test
  void testStudentDiplomaSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentDiplomaSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentDiplomaSetToIntegerSet(Set)}
   */
  @Test
  void testStudentDiplomaSetToIntegerSet2() {
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

    HashSet<StudentDiploma> set = new HashSet<>();
    set.add(studentDiploma);

    // Act
    Set<Integer> actualStudentDiplomaSetToIntegerSetResult = studentMapperImpl.studentDiplomaSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentDiplomaSetToIntegerSetResult.size());
    assertTrue(actualStudentDiplomaSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentDiplomaSetToIntegerSet(Set)}
   */
  @Test
  void testStudentDiplomaSetToIntegerSet3() {
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

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Created By");
    diplomaType2.setDiplomaAbbreviation("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setDiplomaLevel(Short.SIZE);
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

    HashSet<StudentDiploma> set = new HashSet<>();
    set.add(studentDiploma2);
    set.add(studentDiploma);

    // Act
    Set<Integer> actualStudentDiplomaSetToIntegerSetResult = studentMapperImpl.studentDiplomaSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentDiplomaSetToIntegerSetResult.size());
    assertTrue(actualStudentDiplomaSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentDiplomaSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentExperienceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentExperienceSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentExperienceSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentExperienceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentExperienceSetToIntegerSet2() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    HashSet<StudentExperience> set = new HashSet<>();
    set.add(studentExperience);

    // Act
    Set<Integer> actualStudentExperienceSetToIntegerSetResult = studentMapperImpl.studentExperienceSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentExperienceSetToIntegerSetResult.size());
    assertTrue(actualStudentExperienceSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentExperienceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentExperienceSetToIntegerSet3() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Created By");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("ma.uiz.observatoire.model.StudentExperience");
    studentExperience2.setExperienceId(2);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020/03/01");

    HashSet<StudentExperience> set = new HashSet<>();
    set.add(studentExperience2);
    set.add(studentExperience);

    // Act
    Set<Integer> actualStudentExperienceSetToIntegerSetResult = studentMapperImpl.studentExperienceSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentExperienceSetToIntegerSetResult.size());
    assertTrue(actualStudentExperienceSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentExperienceSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentExperienceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentExperienceSetToIntegerSet4() {
    // Arrange
    StudentExperience studentExperience = mock(StudentExperience.class);
    when(studentExperience.getExperienceId()).thenReturn(1);
    doNothing().when(studentExperience).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentExperience).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentExperience).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentExperience).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentExperience).setEndDate(Mockito.<Date>any());
    doNothing().when(studentExperience).setExperienceDescription(Mockito.<String>any());
    doNothing().when(studentExperience).setExperienceId(anyInt());
    doNothing().when(studentExperience).setStartDate(Mockito.<Date>any());
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    HashSet<StudentExperience> set = new HashSet<>();
    set.add(studentExperience);

    // Act
    Set<Integer> actualStudentExperienceSetToIntegerSetResult = studentMapperImpl.studentExperienceSetToIntegerSet(set);

    // Assert
    verify(studentExperience).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentExperience).setCreatedBy(Mockito.<String>any());
    verify(studentExperience).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentExperience).setUpdatedBy(Mockito.<String>any());
    verify(studentExperience).getExperienceId();
    verify(studentExperience).setEndDate(Mockito.<Date>any());
    verify(studentExperience).setExperienceDescription(Mockito.<String>any());
    verify(studentExperience).setExperienceId(anyInt());
    verify(studentExperience).setStartDate(Mockito.<Date>any());
    assertEquals(1, actualStudentExperienceSetToIntegerSetResult.size());
    assertTrue(actualStudentExperienceSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentHobbySetToIntegerSet(Set)}
   */
  @Test
  void testStudentHobbySetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentHobbySetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentHobbySetToIntegerSet(Set)}
   */
  @Test
  void testStudentHobbySetToIntegerSet2() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    HashSet<StudentHobby> set = new HashSet<>();
    set.add(studentHobby);

    // Act
    Set<Integer> actualStudentHobbySetToIntegerSetResult = studentMapperImpl.studentHobbySetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentHobbySetToIntegerSetResult.size());
    assertTrue(actualStudentHobbySetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentHobbySetToIntegerSet(Set)}
   */
  @Test
  void testStudentHobbySetToIntegerSet3() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Created By");
    studentHobby2.setHobbiesName("ma.uiz.observatoire.model.StudentHobby");
    studentHobby2.setHobbyId(2);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020/03/01");

    HashSet<StudentHobby> set = new HashSet<>();
    set.add(studentHobby2);
    set.add(studentHobby);

    // Act
    Set<Integer> actualStudentHobbySetToIntegerSetResult = studentMapperImpl.studentHobbySetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentHobbySetToIntegerSetResult.size());
    assertTrue(actualStudentHobbySetToIntegerSetResult.contains(1));
    assertTrue(actualStudentHobbySetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentHobbySetToIntegerSet(Set)}
   */
  @Test
  void testStudentHobbySetToIntegerSet4() {
    // Arrange
    StudentHobby studentHobby = mock(StudentHobby.class);
    when(studentHobby.getHobbyId()).thenReturn(1);
    doNothing().when(studentHobby).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentHobby).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentHobby).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentHobby).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentHobby).setHobbiesName(Mockito.<String>any());
    doNothing().when(studentHobby).setHobbyId(anyInt());
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    HashSet<StudentHobby> set = new HashSet<>();
    set.add(studentHobby);

    // Act
    Set<Integer> actualStudentHobbySetToIntegerSetResult = studentMapperImpl.studentHobbySetToIntegerSet(set);

    // Assert
    verify(studentHobby).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentHobby).setCreatedBy(Mockito.<String>any());
    verify(studentHobby).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentHobby).setUpdatedBy(Mockito.<String>any());
    verify(studentHobby).getHobbyId();
    verify(studentHobby).setHobbiesName(Mockito.<String>any());
    verify(studentHobby).setHobbyId(anyInt());
    assertEquals(1, actualStudentHobbySetToIntegerSetResult.size());
    assertTrue(actualStudentHobbySetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLanguageSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLanguageSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentLanguageSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLanguageSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLanguageSetToIntegerSet2() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage);

    // Act
    Set<Integer> actualStudentLanguageSetToIntegerSetResult = studentMapperImpl.studentLanguageSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentLanguageSetToIntegerSetResult.size());
    assertTrue(actualStudentLanguageSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLanguageSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLanguageSetToIntegerSet3() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Created By");
    studentLanguage2.setLanguageId(2);
    studentLanguage2.setLanguageLevel(Short.SIZE);
    studentLanguage2.setLanguageName("eng");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020/03/01");

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage2);
    set.add(studentLanguage);

    // Act
    Set<Integer> actualStudentLanguageSetToIntegerSetResult = studentMapperImpl.studentLanguageSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentLanguageSetToIntegerSetResult.size());
    assertTrue(actualStudentLanguageSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentLanguageSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLanguageSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLanguageSetToIntegerSet4() {
    // Arrange
    StudentLanguage studentLanguage = mock(StudentLanguage.class);
    when(studentLanguage.getLanguageId()).thenReturn(1);
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

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage);

    // Act
    Set<Integer> actualStudentLanguageSetToIntegerSetResult = studentMapperImpl.studentLanguageSetToIntegerSet(set);

    // Assert
    verify(studentLanguage).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setCreatedBy(Mockito.<String>any());
    verify(studentLanguage).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setUpdatedBy(Mockito.<String>any());
    verify(studentLanguage).getLanguageId();
    verify(studentLanguage).setLanguageId(anyInt());
    verify(studentLanguage).setLanguageLevel(anyInt());
    verify(studentLanguage).setLanguageName(Mockito.<String>any());
    assertEquals(1, actualStudentLanguageSetToIntegerSetResult.size());
    assertTrue(actualStudentLanguageSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLicenceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLicenceSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentLicenceSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLicenceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLicenceSetToIntegerSet2() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    HashSet<StudentLicence> set = new HashSet<>();
    set.add(studentLicence);

    // Act
    Set<Integer> actualStudentLicenceSetToIntegerSetResult = studentMapperImpl.studentLicenceSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentLicenceSetToIntegerSetResult.size());
    assertTrue(actualStudentLicenceSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLicenceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLicenceSetToIntegerSet3() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Created By");
    studentLicence2.setLicenceId(2);
    studentLicence2.setLicenceName("ma.uiz.observatoire.model.StudentLicence");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020/03/01");

    HashSet<StudentLicence> set = new HashSet<>();
    set.add(studentLicence2);
    set.add(studentLicence);

    // Act
    Set<Integer> actualStudentLicenceSetToIntegerSetResult = studentMapperImpl.studentLicenceSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentLicenceSetToIntegerSetResult.size());
    assertTrue(actualStudentLicenceSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentLicenceSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentLicenceSetToIntegerSet(Set)}
   */
  @Test
  void testStudentLicenceSetToIntegerSet4() {
    // Arrange
    StudentLicence studentLicence = mock(StudentLicence.class);
    when(studentLicence.getLicenceId()).thenReturn(1);
    doNothing().when(studentLicence).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLicence).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentLicence).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLicence).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentLicence).setLicenceId(anyInt());
    doNothing().when(studentLicence).setLicenceName(Mockito.<String>any());
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    HashSet<StudentLicence> set = new HashSet<>();
    set.add(studentLicence);

    // Act
    Set<Integer> actualStudentLicenceSetToIntegerSetResult = studentMapperImpl.studentLicenceSetToIntegerSet(set);

    // Assert
    verify(studentLicence).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentLicence).setCreatedBy(Mockito.<String>any());
    verify(studentLicence).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentLicence).setUpdatedBy(Mockito.<String>any());
    verify(studentLicence).getLicenceId();
    verify(studentLicence).setLicenceId(anyInt());
    verify(studentLicence).setLicenceName(Mockito.<String>any());
    assertEquals(1, actualStudentLicenceSetToIntegerSetResult.size());
    assertTrue(actualStudentLicenceSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentSkillSetToIntegerSet(Set)}
   */
  @Test
  void testStudentSkillSetToIntegerSet() {
    // Arrange, Act and Assert
    assertTrue(studentMapperImpl.studentSkillSetToIntegerSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentSkillSetToIntegerSet(Set)}
   */
  @Test
  void testStudentSkillSetToIntegerSet2() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    HashSet<StudentSkill> set = new HashSet<>();
    set.add(studentSkill);

    // Act
    Set<Integer> actualStudentSkillSetToIntegerSetResult = studentMapperImpl.studentSkillSetToIntegerSet(set);

    // Assert
    assertEquals(1, actualStudentSkillSetToIntegerSetResult.size());
    assertTrue(actualStudentSkillSetToIntegerSetResult.contains(1));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentSkillSetToIntegerSet(Set)}
   */
  @Test
  void testStudentSkillSetToIntegerSet3() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Created By");
    studentSkill2.setSkillId(2);
    studentSkill2.setSkillName("ma.uiz.observatoire.model.StudentSkill");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020/03/01");

    HashSet<StudentSkill> set = new HashSet<>();
    set.add(studentSkill2);
    set.add(studentSkill);

    // Act
    Set<Integer> actualStudentSkillSetToIntegerSetResult = studentMapperImpl.studentSkillSetToIntegerSet(set);

    // Assert
    assertEquals(2, actualStudentSkillSetToIntegerSetResult.size());
    assertTrue(actualStudentSkillSetToIntegerSetResult.contains(1));
    assertTrue(actualStudentSkillSetToIntegerSetResult.contains(2));
  }

  /**
   * Method under test: {@link StudentMapperImpl#studentSkillSetToIntegerSet(Set)}
   */
  @Test
  void testStudentSkillSetToIntegerSet4() {
    // Arrange
    StudentSkill studentSkill = mock(StudentSkill.class);
    when(studentSkill.getSkillId()).thenReturn(1);
    doNothing().when(studentSkill).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentSkill).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentSkill).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentSkill).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentSkill).setSkillId(anyInt());
    doNothing().when(studentSkill).setSkillName(Mockito.<String>any());
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    HashSet<StudentSkill> set = new HashSet<>();
    set.add(studentSkill);

    // Act
    Set<Integer> actualStudentSkillSetToIntegerSetResult = studentMapperImpl.studentSkillSetToIntegerSet(set);

    // Assert
    verify(studentSkill).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentSkill).setCreatedBy(Mockito.<String>any());
    verify(studentSkill).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentSkill).setUpdatedBy(Mockito.<String>any());
    verify(studentSkill).getSkillId();
    verify(studentSkill).setSkillId(anyInt());
    verify(studentSkill).setSkillName(Mockito.<String>any());
    assertEquals(1, actualStudentSkillSetToIntegerSetResult.size());
    assertTrue(actualStudentSkillSetToIntegerSetResult.contains(1));
  }
}

