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
@ContextConfiguration(classes = {Student.class})
@ExtendWith(SpringExtension.class)
class StudentTest {
  @Autowired
  private Student student;

  /**
   * Method under test: {@link Student#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Student()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Student#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Student student2 = new Student();

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

    Student student3 = new Student();
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

    // Act and Assert
    assertTrue(student2.canEqual(student3));
  }

  /**
   * Method under test: {@link Student#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    Student student2 = new Student();
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

    Student student3 = new Student();
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
    boolean actualCanEqualResult = student2.canEqual(student3);

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
  *   <li>default or parameterless constructor of {@link Student}
  *   <li>{@link Student#setAccount(Account)}
  *   <li>{@link Student#setApplications(Set)}
  *   <li>{@link Student#setCIN(String)}
  *   <li>{@link Student#setCertificates(Set)}
  *   <li>{@link Student#setExperiences(Set)}
  *   <li>{@link Student#setHobbies(Set)}
  *   <li>{@link Student#setImageUrl(String)}
  *   <li>{@link Student#setLanguages(Set)}
  *   <li>{@link Student#setLastName(String)}
  *   <li>{@link Student#setLicences(Set)}
  *   <li>{@link Student#setName(String)}
  *   <li>{@link Student#setSkills(Set)}
  *   <li>{@link Student#setStudentDiplomas(Set)}
  *   <li>{@link Student#setStudentId(int)}
  *   <li>{@link Student#toString()}
  *   <li>{@link Student#getAccount()}
  *   <li>{@link Student#getApplications()}
  *   <li>{@link Student#getCIN()}
  *   <li>{@link Student#getCertificates()}
  *   <li>{@link Student#getExperiences()}
  *   <li>{@link Student#getHobbies()}
  *   <li>{@link Student#getImageUrl()}
  *   <li>{@link Student#getLanguages()}
  *   <li>{@link Student#getLastName()}
  *   <li>{@link Student#getLicences()}
  *   <li>{@link Student#getName()}
  *   <li>{@link Student#getSkills()}
  *   <li>{@link Student#getStudentDiplomas()}
  *   <li>{@link Student#getStudentId()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Student actualStudent = new Student();
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
    actualStudent.setAccount(account);
    HashSet<Application> applications = new HashSet<>();
    actualStudent.setApplications(applications);
    actualStudent.setCIN("CIN");
    HashSet<StudentCertificate> certificates = new HashSet<>();
    actualStudent.setCertificates(certificates);
    HashSet<StudentExperience> experiences = new HashSet<>();
    actualStudent.setExperiences(experiences);
    HashSet<StudentHobby> hobbies = new HashSet<>();
    actualStudent.setHobbies(hobbies);
    actualStudent.setImageUrl("https://example.org/example");
    HashSet<StudentLanguage> languages = new HashSet<>();
    actualStudent.setLanguages(languages);
    actualStudent.setLastName("Doe");
    HashSet<StudentLicence> licences = new HashSet<>();
    actualStudent.setLicences(licences);
    actualStudent.setName("Name");
    HashSet<StudentSkill> skills = new HashSet<>();
    actualStudent.setSkills(skills);
    HashSet<StudentDiploma> studentDiplomas = new HashSet<>();
    actualStudent.setStudentDiplomas(studentDiplomas);
    actualStudent.setStudentId(1);
    String actualToStringResult = actualStudent.toString();
    Account actualAccount = actualStudent.getAccount();
    Set<Application> actualApplications = actualStudent.getApplications();
    String actualCIN = actualStudent.getCIN();
    Set<StudentCertificate> actualCertificates = actualStudent.getCertificates();
    Set<StudentExperience> actualExperiences = actualStudent.getExperiences();
    Set<StudentHobby> actualHobbies = actualStudent.getHobbies();
    String actualImageUrl = actualStudent.getImageUrl();
    Set<StudentLanguage> actualLanguages = actualStudent.getLanguages();
    String actualLastName = actualStudent.getLastName();
    Set<StudentLicence> actualLicences = actualStudent.getLicences();
    String actualName = actualStudent.getName();
    Set<StudentSkill> actualSkills = actualStudent.getSkills();
    Set<StudentDiploma> actualStudentDiplomas = actualStudent.getStudentDiplomas();

    // Assert that nothing has changed
    assertEquals("CIN", actualCIN);
    assertEquals("Doe", actualLastName);
    assertEquals("Name", actualName);
    assertEquals("Student(studentId=1, name=Name, lastName=Doe, CIN=CIN, account=Account(accountId=1, userName=janedoe,"
        + " password=iloveyou, email=jane.doe@example.org, enabled=true, mobileNumber=42, conversations=[],"
        + " accountRoles=[]), studentDiplomas=[], applications=[], certificates=[], experiences=[], hobbies=[],"
        + " languages=[], skills=[], licences=[], imageUrl=https://example.org/example)", actualToStringResult);
    assertEquals("https://example.org/example", actualImageUrl);
    assertEquals(1, actualStudent.getStudentId());
    assertSame(applications, actualApplications);
    assertSame(certificates, actualCertificates);
    assertSame(experiences, actualExperiences);
    assertSame(hobbies, actualHobbies);
    assertSame(languages, actualLanguages);
    assertSame(licences, actualLicences);
    assertSame(skills, actualSkills);
    assertSame(studentDiplomas, actualStudentDiplomas);
    assertSame(account, actualAccount);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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

    // Act and Assert
    assertNotEquals(student, null);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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

    // Act and Assert
    assertNotEquals(student, "Different type to Student");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Student#equals(Object)}
   *   <li>{@link Student#hashCode()}
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

    // Act and Assert
    assertEquals(student, student);
    int expectedHashCodeResult = student.hashCode();
    assertEquals(expectedHashCodeResult, student.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Student#equals(Object)}
   *   <li>{@link Student#hashCode()}
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

    // Act and Assert
    assertEquals(student, student2);
    int expectedHashCodeResult = student.hashCode();
    assertEquals(expectedHashCodeResult, student2.hashCode());
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("17 High St");
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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN(null);
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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setLastName("Smith");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setLastName(null);
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setName("Jan 1, 2020 8:00am GMT+0100");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setName(null);
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }

  /**
   * Method under test: {@link Student#equals(Object)}
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
    student.setStudentId(2);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

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

    // Act and Assert
    assertNotEquals(student, student2);
  }
}

