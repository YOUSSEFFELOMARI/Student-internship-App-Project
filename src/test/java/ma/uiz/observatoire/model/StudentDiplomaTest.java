package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {StudentDiploma.class,
    StudentDiploma.StudentDiplomaPk.class})
@ExtendWith(SpringExtension.class)
class StudentDiplomaTest {
  @Autowired
  private StudentDiploma.StudentDiplomaPk studentDiplomaPk;

  @Autowired
  private StudentDiploma studentDiploma;

  /**
   * Method under test: {@link StudentDiploma#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentDiploma()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentDiploma#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentDiploma studentDiploma2 = new StudentDiploma();

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(3);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma studentDiploma3 = new StudentDiploma();
    studentDiploma3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma3.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setStudentDiplomaId(studentDiplomaId);
    studentDiploma3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentDiploma2.canEqual(studentDiploma3));
  }

  /**
   * Method under test: {@link StudentDiploma#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    StudentDiploma studentDiploma2 = new StudentDiploma();

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(3);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Diploma diploma = mock(Diploma.class);
    doNothing().when(diploma).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diploma).setCreatedBy(Mockito.<String>any());
    doNothing().when(diploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diploma).setUpdatedBy(Mockito.<String>any());
    doNothing().when(diploma).setDiplomaId(anyInt());
    doNothing().when(diploma).setDiplomaName(Mockito.<String>any());
    doNothing().when(diploma).setDiplomaType(Mockito.<DiplomaType>any());
    doNothing().when(diploma).setEstablishment(Mockito.<Establishment>any());
    doNothing().when(diploma).setSpecialities(Mockito.<Set<Speciality>>any());
    doNothing().when(diploma).setStudentDiplomas(Mockito.<List<StudentDiploma>>any());
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

    StudentDiploma studentDiploma3 = new StudentDiploma();
    studentDiploma3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma3.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma3.setStudentDiplomaId(studentDiplomaId);
    studentDiploma3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma3.setUpdatedBy("2020-03-01");

    // Act
    boolean actualCanEqualResult = studentDiploma2.canEqual(studentDiploma3);

    // Assert
    verify(diploma).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(diploma).setCreatedBy(Mockito.<String>any());
    verify(diploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(diploma).setUpdatedBy(Mockito.<String>any());
    verify(diploma).setDiplomaId(anyInt());
    verify(diploma).setDiplomaName(Mockito.<String>any());
    verify(diploma).setDiplomaType(Mockito.<DiplomaType>any());
    verify(diploma).setEstablishment(Mockito.<Establishment>any());
    verify(diploma).setSpecialities(Mockito.<Set<Speciality>>any());
    verify(diploma).setStudentDiplomas(Mockito.<List<StudentDiploma>>any());
    assertTrue(actualCanEqualResult);
  }

  /**
   * Method under test: default or parameterless constructor of {@link StudentDiploma}
   */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentDiploma actualStudentDiploma = new StudentDiploma();

    // Assert
    assertNull(actualStudentDiploma.getCreatedBy());
    assertNull(actualStudentDiploma.getUpdatedBy());
    assertNull(actualStudentDiploma.getCurrentYear());
    assertNull(actualStudentDiploma.getEndYear());
    assertNull(actualStudentDiploma.getStartYear());
    assertNull(actualStudentDiploma.getCreatedAt());
    assertNull(actualStudentDiploma.getUpdatedAt());
  }

  /**
   * Method under test: {@link StudentDiploma#equals(Object)}
   */
  @Test
  void testEquals() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    assertNotEquals(studentDiploma, null);
  }

  /**
   * Method under test: {@link StudentDiploma#equals(Object)}
   */
  @Test
  void testEquals2() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    assertNotEquals(studentDiploma, "Different type to StudentDiploma");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentDiploma#equals(Object)}
   *   <li>{@link StudentDiploma#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    assertEquals(studentDiploma, studentDiploma);
    int expectedHashCodeResult = studentDiploma.hashCode();
    assertEquals(expectedHashCodeResult, studentDiploma.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentDiploma#equals(Object)}
   *   <li>{@link StudentDiploma#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaId2 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaId2.setDiploma(diploma2);
    studentDiplomaId2.setStudent(student2);

    StudentDiploma studentDiploma2 = new StudentDiploma();
    studentDiploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentDiploma2.setCurrentYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setEndYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStartYear(LocalDate.of(1970, 1, 1));
    studentDiploma2.setStudentDiplomaId(studentDiplomaId2);
    studentDiploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentDiploma2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentDiploma, studentDiploma2);
    int expectedHashCodeResult = studentDiploma.hashCode();
    assertEquals(expectedHashCodeResult, studentDiploma2.hashCode());
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link StudentDiploma#setCurrentYear(LocalDate)}
  *   <li>{@link StudentDiploma#setEndYear(LocalDate)}
  *   <li>{@link StudentDiploma#setStartYear(LocalDate)}
  *   <li>{@link StudentDiploma#setStudentDiplomaId(StudentDiploma.StudentDiplomaPk)}
  *   <li>{@link StudentDiploma#toString()}
  *   <li>{@link StudentDiploma#getCurrentYear()}
  *   <li>{@link StudentDiploma#getEndYear()}
  *   <li>{@link StudentDiploma#getStartYear()}
  *   <li>{@link StudentDiploma#getStudentDiplomaId()}
  * </ul>
  */
  @Test
  void testSetCurrentYear() {
    // Arrange
    StudentDiploma studentDiploma = new StudentDiploma();
    LocalDate currentYear = LocalDate.of(1970, 1, 1);

    // Act
    studentDiploma.setCurrentYear(currentYear);
    LocalDate endYear = LocalDate.of(1970, 1, 1);
    studentDiploma.setEndYear(endYear);
    LocalDate startYear = LocalDate.of(1970, 1, 1);
    studentDiploma.setStartYear(startYear);
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
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
    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    studentDiploma.setStudentDiplomaId(studentDiplomaId);
    String actualToStringResult = studentDiploma.toString();
    LocalDate actualCurrentYear = studentDiploma.getCurrentYear();
    LocalDate actualEndYear = studentDiploma.getEndYear();
    LocalDate actualStartYear = studentDiploma.getStartYear();

    // Assert that nothing has changed
    assertEquals(
        "StudentDiploma(studentDiplomaId=StudentDiploma.StudentDiplomaPk(student=Student(studentId=1, name=Name,"
            + " lastName=Doe, CIN=CIN, account=Account(accountId=1, userName=janedoe, password=iloveyou, email=jane"
            + ".doe@example.org, enabled=true, mobileNumber=42, conversations=[], accountRoles=[]), studentDiplomas=[],"
            + " applications=[], certificates=[], experiences=[], hobbies=[], languages=[], skills=[], licences=[],"
            + " imageUrl=https://example.org/example), diploma=Diploma(diplomaId=1, diplomaName=Diploma Name,"
            + " establishment=Establishment(establishmentId=1, establishmentTitle=Dr, establishmentPhone=6625550144,"
            + " establishmentEmail=jane.doe@example.org, establishmentWebSite=Establishment Web Site, university"
            + "=University(universityId=1, universityTitle=Dr, universityPhone=6625550144, universityEmail=jane.doe"
            + "@example.org, universityWebsite=University Website, imageUrl=https://example.org/example), imageUrl"
            + "=https://example.org/example), diplomaType=DiplomaType(diplomaTypeId=1, diplomaTypeName=Diploma Type"
            + " Name, diplomaLevel=1, diplomaAbbreviation=Diploma Abbreviation), specialities=[], studentDiplomas=[])),"
            + " currentYear=1970-01-01, startYear=1970-01-01, endYear=1970-01-01)",
        actualToStringResult);
    assertSame(studentDiplomaId, studentDiploma.getStudentDiplomaId());
    assertSame(currentYear, actualCurrentYear);
    assertSame(endYear, actualEndYear);
    assertSame(startYear, actualStartYear);
  }

  /**
   * Method under test: {@link StudentDiploma.StudentDiplomaPk#canEqual(Object)}
   */
  @Test
  void testStudentDiplomaPkCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentDiploma.StudentDiplomaPk()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentDiploma.StudentDiplomaPk#canEqual(Object)}
   */
  @Test
  void testStudentDiplomaPkCanEqual2() {
    // Arrange
    StudentDiploma.StudentDiplomaPk studentDiplomaPk2 = new StudentDiploma.StudentDiplomaPk();

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(3);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk3 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk3.setDiploma(diploma);
    studentDiplomaPk3.setStudent(student);

    // Act and Assert
    assertTrue(studentDiplomaPk2.canEqual(studentDiplomaPk3));
  }

  /**
   * Method under test: {@link StudentDiploma.StudentDiplomaPk#canEqual(Object)}
   */
  @Test
  void testStudentDiplomaPkCanEqual3() {
    // Arrange
    StudentDiploma.StudentDiplomaPk studentDiplomaPk2 = new StudentDiploma.StudentDiplomaPk();

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(3);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Diploma diploma = mock(Diploma.class);
    doNothing().when(diploma).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diploma).setCreatedBy(Mockito.<String>any());
    doNothing().when(diploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diploma).setUpdatedBy(Mockito.<String>any());
    doNothing().when(diploma).setDiplomaId(anyInt());
    doNothing().when(diploma).setDiplomaName(Mockito.<String>any());
    doNothing().when(diploma).setDiplomaType(Mockito.<DiplomaType>any());
    doNothing().when(diploma).setEstablishment(Mockito.<Establishment>any());
    doNothing().when(diploma).setSpecialities(Mockito.<Set<Speciality>>any());
    doNothing().when(diploma).setStudentDiplomas(Mockito.<List<StudentDiploma>>any());
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk3 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk3.setDiploma(diploma);
    studentDiplomaPk3.setStudent(student);

    // Act
    boolean actualCanEqualResult = studentDiplomaPk2.canEqual(studentDiplomaPk3);

    // Assert
    verify(diploma).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(diploma).setCreatedBy(Mockito.<String>any());
    verify(diploma).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(diploma).setUpdatedBy(Mockito.<String>any());
    verify(diploma).setDiplomaId(anyInt());
    verify(diploma).setDiplomaName(Mockito.<String>any());
    verify(diploma).setDiplomaType(Mockito.<DiplomaType>any());
    verify(diploma).setEstablishment(Mockito.<Establishment>any());
    verify(diploma).setSpecialities(Mockito.<Set<Speciality>>any());
    verify(diploma).setStudentDiplomas(Mockito.<List<StudentDiploma>>any());
    assertTrue(actualCanEqualResult);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link StudentDiploma.StudentDiplomaPk}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#setDiploma(Diploma)}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#setStudent(Student)}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#toString()}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#getDiploma()}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#getStudent()}
   * </ul>
   */
  @Test
  void testStudentDiplomaPkConstructor() {
    // Arrange and Act
    StudentDiploma.StudentDiplomaPk actualStudentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
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
    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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
    actualStudentDiplomaPk.setDiploma(diploma);
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
    actualStudentDiplomaPk.setStudent(student);
    String actualToStringResult = actualStudentDiplomaPk.toString();
    Diploma actualDiploma = actualStudentDiplomaPk.getDiploma();

    // Assert that nothing has changed
    assertEquals("StudentDiploma.StudentDiplomaPk(student=Student(studentId=1, name=Name, lastName=Doe, CIN=CIN,"
        + " account=Account(accountId=1, userName=janedoe, password=iloveyou, email=jane.doe@example.org,"
        + " enabled=true, mobileNumber=42, conversations=[], accountRoles=[]), studentDiplomas=[], applications=[],"
        + " certificates=[], experiences=[], hobbies=[], languages=[], skills=[], licences=[], imageUrl=https:/"
        + "/example.org/example), diploma=Diploma(diplomaId=1, diplomaName=Diploma Name, establishment=Establishment"
        + "(establishmentId=1, establishmentTitle=Dr, establishmentPhone=6625550144, establishmentEmail=jane.doe"
        + "@example.org, establishmentWebSite=Establishment Web Site, university=University(universityId=1,"
        + " universityTitle=Dr, universityPhone=6625550144, universityEmail=jane.doe@example.org, universityWebsite"
        + "=University Website, imageUrl=https://example.org/example), imageUrl=https://example.org/example),"
        + " diplomaType=DiplomaType(diplomaTypeId=1, diplomaTypeName=Diploma Type Name, diplomaLevel=1,"
        + " diplomaAbbreviation=Diploma Abbreviation), specialities=[], studentDiplomas=[]))", actualToStringResult);
    assertSame(diploma, actualDiploma);
    assertSame(student, actualStudentDiplomaPk.getStudent());
  }

  /**
   * Method under test: {@link StudentDiploma.StudentDiplomaPk#equals(Object)}
   */
  @Test
  void testStudentDiplomaPkEquals() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma);
    studentDiplomaPk.setStudent(student);

    // Act and Assert
    assertNotEquals(studentDiplomaPk, null);
  }

  /**
   * Method under test: {@link StudentDiploma.StudentDiplomaPk#equals(Object)}
   */
  @Test
  void testStudentDiplomaPkEquals2() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma);
    studentDiplomaPk.setStudent(student);

    // Act and Assert
    assertNotEquals(studentDiplomaPk, "Different type to StudentDiplomaPk");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentDiploma.StudentDiplomaPk#equals(Object)}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#hashCode()}
   * </ul>
   */
  @Test
  void testStudentDiplomaPkEquals3() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma);
    studentDiplomaPk.setStudent(student);

    // Act and Assert
    assertEquals(studentDiplomaPk, studentDiplomaPk);
    int expectedHashCodeResult = studentDiplomaPk.hashCode();
    assertEquals(expectedHashCodeResult, studentDiplomaPk.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentDiploma.StudentDiplomaPk#equals(Object)}
   *   <li>{@link StudentDiploma.StudentDiplomaPk#hashCode()}
   * </ul>
   */
  @Test
  void testStudentDiplomaPkEquals4() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk.setDiploma(diploma);
    studentDiplomaPk.setStudent(student);

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
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

    StudentDiploma.StudentDiplomaPk studentDiplomaPk2 = new StudentDiploma.StudentDiplomaPk();
    studentDiplomaPk2.setDiploma(diploma2);
    studentDiplomaPk2.setStudent(student2);

    // Act and Assert
    assertEquals(studentDiplomaPk, studentDiplomaPk2);
    int expectedHashCodeResult = studentDiplomaPk.hashCode();
    assertEquals(expectedHashCodeResult, studentDiplomaPk2.hashCode());
  }
}

