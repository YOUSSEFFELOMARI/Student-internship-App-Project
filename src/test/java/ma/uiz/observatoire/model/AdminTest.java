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
@ContextConfiguration(classes = {Admin.class})
@ExtendWith(SpringExtension.class)
class AdminTest {
  @Autowired
  private Admin admin;

  /**
   * Method under test: {@link Admin#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Admin()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Admin#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Admin admin2 = new Admin();

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

    Admin admin3 = new Admin();
    admin3.setAccount(account);
    admin3.setAdminId(1);
    admin3.setAdminLastname("Doe");
    admin3.setAdminName("Admin Name");
    admin3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin3.setUniversity(university);
    admin3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(admin2.canEqual(admin3));
  }

  /**
   * Method under test: {@link Admin#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    Admin admin2 = new Admin();
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

    Admin admin3 = new Admin();
    admin3.setAccount(account);
    admin3.setAdminId(1);
    admin3.setAdminLastname("Doe");
    admin3.setAdminName("Admin Name");
    admin3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin3.setUniversity(university);
    admin3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin3.setUpdatedBy("2020-03-01");

    // Act
    boolean actualCanEqualResult = admin2.canEqual(admin3);

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
  *   <li>default or parameterless constructor of {@link Admin}
  *   <li>{@link Admin#setAccount(Account)}
  *   <li>{@link Admin#setAdminId(int)}
  *   <li>{@link Admin#setAdminLastname(String)}
  *   <li>{@link Admin#setAdminName(String)}
  *   <li>{@link Admin#setUniversity(University)}
  *   <li>{@link Admin#toString()}
  *   <li>{@link Admin#getAccount()}
  *   <li>{@link Admin#getAdminId()}
  *   <li>{@link Admin#getAdminLastname()}
  *   <li>{@link Admin#getAdminName()}
  *   <li>{@link Admin#getUniversity()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Admin actualAdmin = new Admin();
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
    actualAdmin.setAccount(account);
    actualAdmin.setAdminId(1);
    actualAdmin.setAdminLastname("Doe");
    actualAdmin.setAdminName("Admin Name");
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
    actualAdmin.setUniversity(university);
    String actualToStringResult = actualAdmin.toString();
    Account actualAccount = actualAdmin.getAccount();
    int actualAdminId = actualAdmin.getAdminId();
    String actualAdminLastname = actualAdmin.getAdminLastname();
    String actualAdminName = actualAdmin.getAdminName();

    // Assert that nothing has changed
    assertEquals("Admin Name", actualAdminName);
    assertEquals("Admin(adminId=1, adminName=Admin Name, adminLastname=Doe, university=University(universityId=1,"
        + " universityTitle=Dr, universityPhone=6625550144, universityEmail=jane.doe@example.org, universityWebsite"
        + "=University Website, imageUrl=https://example.org/example), account=Account(accountId=1, userName=janedoe,"
        + " password=iloveyou, email=jane.doe@example.org, enabled=true, mobileNumber=42, conversations=[],"
        + " accountRoles=[]))", actualToStringResult);
    assertEquals("Doe", actualAdminLastname);
    assertEquals(1, actualAdminId);
    assertSame(account, actualAccount);
    assertSame(university, actualAdmin.getUniversity());
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, null);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, "Different type to Admin");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Admin#equals(Object)}
   *   <li>{@link Admin#hashCode()}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(admin, admin);
    int expectedHashCodeResult = admin.hashCode();
    assertEquals(expectedHashCodeResult, admin.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Admin#equals(Object)}
   *   <li>{@link Admin#hashCode()}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(admin, admin2);
    int expectedHashCodeResult = admin.hashCode();
    assertEquals(expectedHashCodeResult, admin2.hashCode());
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(2);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Smith");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname(null);
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Jan 1, 2020 8:00am GMT+0100");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName(null);
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.now().atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }

  /**
   * Method under test: {@link Admin#equals(Object)}
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
    University university = mock(University.class);
    doNothing().when(university).setAddress1(Mockito.<String>any());
    doNothing().when(university).setAddress2(Mockito.<String>any());
    doNothing().when(university).setCity(Mockito.<String>any());
    doNothing().when(university).setRegion(Mockito.<String>any());
    doNothing().when(university).setZipCode(Mockito.<String>any());
    doNothing().when(university).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setCreatedBy(Mockito.<String>any());
    doNothing().when(university).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setUpdatedBy(Mockito.<String>any());
    doNothing().when(university).setImageUrl(Mockito.<String>any());
    doNothing().when(university).setUniversityEmail(Mockito.<String>any());
    doNothing().when(university).setUniversityId(anyInt());
    doNothing().when(university).setUniversityPhone(Mockito.<String>any());
    doNothing().when(university).setUniversityTitle(Mockito.<String>any());
    doNothing().when(university).setUniversityWebsite(Mockito.<String>any());
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(admin, admin2);
  }
}

