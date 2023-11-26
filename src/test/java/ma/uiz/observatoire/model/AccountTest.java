package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Account.class})
@ExtendWith(SpringExtension.class)
class AccountTest {
  @Autowired
  private Account account;

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Account.AccountBuilder#build()}
   *   <li>{@link Account.AccountBuilder#accountId(int)}
   *   <li>{@link Account.AccountBuilder#accountRoles(Set)}
   *   <li>{@link Account.AccountBuilder#conversations(Set)}
   *   <li>{@link Account.AccountBuilder#email(String)}
   *   <li>{@link Account.AccountBuilder#enabled(boolean)}
   *   <li>{@link Account.AccountBuilder#mobileNumber(String)}
   *   <li>{@link Account.AccountBuilder#password(String)}
   *   <li>{@link Account.AccountBuilder#userName(String)}
   * </ul>
   */
  @Test
  void testAccountBuilderBuild() {
    // Arrange
    Account.AccountBuilder accountIdResult = Account.builder().accountId(1);
    HashSet<AccountRole> accountRoles = new HashSet<>();
    Account.AccountBuilder accountRolesResult = accountIdResult.accountRoles(accountRoles);
    HashSet<Conversation> conversations = new HashSet<>();

    // Act
    Account actualBuildResult = accountRolesResult.conversations(conversations)
        .email("jane.doe@example.org")
        .enabled(true)
        .mobileNumber("42")
        .password("iloveyou")
        .userName("janedoe")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getMobileNumber());
    assertEquals("iloveyou", actualBuildResult.getPassword());
    assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
    assertEquals("jane.doe@example.org", actualBuildResult.getUsername());
    assertEquals("janedoe", actualBuildResult.getUserName());
    assertNull(actualBuildResult.getCreatedBy());
    assertNull(actualBuildResult.getUpdatedBy());
    assertNull(actualBuildResult.getCreatedAt());
    assertNull(actualBuildResult.getUpdatedAt());
    assertEquals(1, actualBuildResult.getAccountId());
    Collection<? extends GrantedAuthority> authorities = actualBuildResult.getAuthorities();
    assertTrue(authorities.isEmpty());
    Set<Conversation> conversations2 = actualBuildResult.getConversations();
    assertTrue(conversations2.isEmpty());
    assertTrue(actualBuildResult.isAccountNonExpired());
    assertTrue(actualBuildResult.isAccountNonLocked());
    assertTrue(actualBuildResult.isCredentialsNonExpired());
    assertTrue(actualBuildResult.isEnabled());
    assertSame(accountRoles, authorities);
    assertSame(conversations, conversations2);
    assertSame(authorities, actualBuildResult.getAccountRoles());
  }

  /**
   * Method under test: {@link Account#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Account()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Account#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Account account2 = new Account();

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

    // Act and Assert
    assertTrue(account2.canEqual(account3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Account#Account()}
  *   <li>{@link Account#setAccountId(int)}
  *   <li>{@link Account#setAccountRoles(Set)}
  *   <li>{@link Account#setConversations(Set)}
  *   <li>{@link Account#setEmail(String)}
  *   <li>{@link Account#setEnabled(boolean)}
  *   <li>{@link Account#setMobileNumber(String)}
  *   <li>{@link Account#setPassword(String)}
  *   <li>{@link Account#setUserName(String)}
  *   <li>{@link Account#toString()}
  *   <li>{@link Account#getAccountId()}
  *   <li>{@link Account#getAccountRoles()}
  *   <li>{@link Account#getAuthorities()}
  *   <li>{@link Account#getConversations()}
  *   <li>{@link Account#getEmail()}
  *   <li>{@link Account#getMobileNumber()}
  *   <li>{@link Account#getPassword()}
  *   <li>{@link Account#getUserName()}
  *   <li>{@link Account#getUsername()}
  *   <li>{@link Account#isAccountNonExpired()}
  *   <li>{@link Account#isAccountNonLocked()}
  *   <li>{@link Account#isCredentialsNonExpired()}
  *   <li>{@link Account#isEnabled()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Account actualAccount = new Account();
    actualAccount.setAccountId(1);
    HashSet<AccountRole> accountRoles = new HashSet<>();
    actualAccount.setAccountRoles(accountRoles);
    HashSet<Conversation> conversations = new HashSet<>();
    actualAccount.setConversations(conversations);
    actualAccount.setEmail("jane.doe@example.org");
    actualAccount.setEnabled(true);
    actualAccount.setMobileNumber("42");
    actualAccount.setPassword("iloveyou");
    actualAccount.setUserName("janedoe");
    String actualToStringResult = actualAccount.toString();
    int actualAccountId = actualAccount.getAccountId();
    Set<AccountRole> actualAccountRoles = actualAccount.getAccountRoles();
    Collection<? extends GrantedAuthority> actualAuthorities = actualAccount.getAuthorities();
    Set<Conversation> actualConversations = actualAccount.getConversations();
    String actualEmail = actualAccount.getEmail();
    String actualMobileNumber = actualAccount.getMobileNumber();
    String actualPassword = actualAccount.getPassword();
    String actualUserName = actualAccount.getUserName();
    String actualUsername = actualAccount.getUsername();
    boolean actualIsAccountNonExpiredResult = actualAccount.isAccountNonExpired();
    boolean actualIsAccountNonLockedResult = actualAccount.isAccountNonLocked();
    boolean actualIsCredentialsNonExpiredResult = actualAccount.isCredentialsNonExpired();

    // Assert that nothing has changed
    assertEquals("42", actualMobileNumber);
    assertEquals("Account(accountId=1, userName=janedoe, password=iloveyou, email=jane.doe@example.org, enabled=true,"
        + " mobileNumber=42, conversations=[], accountRoles=[])", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("jane.doe@example.org", actualUsername);
    assertEquals("janedoe", actualUserName);
    assertEquals(1, actualAccountId);
    assertTrue(actualIsAccountNonExpiredResult);
    assertTrue(actualIsAccountNonLockedResult);
    assertTrue(actualIsCredentialsNonExpiredResult);
    assertTrue(actualAccount.isEnabled());
    assertSame(accountRoles, actualAccountRoles);
    assertSame(conversations, actualConversations);
    assertSame(actualAccountRoles, actualAuthorities);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Account#Account(int, String, String, String, boolean, String, Set, Set)}
   *   <li>{@link Account#setAccountId(int)}
   *   <li>{@link Account#setAccountRoles(Set)}
   *   <li>{@link Account#setConversations(Set)}
   *   <li>{@link Account#setEmail(String)}
   *   <li>{@link Account#setEnabled(boolean)}
   *   <li>{@link Account#setMobileNumber(String)}
   *   <li>{@link Account#setPassword(String)}
   *   <li>{@link Account#setUserName(String)}
   *   <li>{@link Account#toString()}
   *   <li>{@link Account#getAccountId()}
   *   <li>{@link Account#getAccountRoles()}
   *   <li>{@link Account#getAuthorities()}
   *   <li>{@link Account#getConversations()}
   *   <li>{@link Account#getEmail()}
   *   <li>{@link Account#getMobileNumber()}
   *   <li>{@link Account#getPassword()}
   *   <li>{@link Account#getUserName()}
   *   <li>{@link Account#getUsername()}
   *   <li>{@link Account#isAccountNonExpired()}
   *   <li>{@link Account#isAccountNonLocked()}
   *   <li>{@link Account#isCredentialsNonExpired()}
   *   <li>{@link Account#isEnabled()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange
    HashSet<Conversation> conversations = new HashSet<>();

    // Act
    Account actualAccount = new Account(1, "janedoe", "iloveyou", "jane.doe@example.org", true, "42", conversations,
        new HashSet<>());
    actualAccount.setAccountId(1);
    HashSet<AccountRole> accountRoles = new HashSet<>();
    actualAccount.setAccountRoles(accountRoles);
    HashSet<Conversation> conversations2 = new HashSet<>();
    actualAccount.setConversations(conversations2);
    actualAccount.setEmail("jane.doe@example.org");
    actualAccount.setEnabled(true);
    actualAccount.setMobileNumber("42");
    actualAccount.setPassword("iloveyou");
    actualAccount.setUserName("janedoe");
    String actualToStringResult = actualAccount.toString();
    int actualAccountId = actualAccount.getAccountId();
    Set<AccountRole> actualAccountRoles = actualAccount.getAccountRoles();
    Collection<? extends GrantedAuthority> actualAuthorities = actualAccount.getAuthorities();
    Set<Conversation> actualConversations = actualAccount.getConversations();
    String actualEmail = actualAccount.getEmail();
    String actualMobileNumber = actualAccount.getMobileNumber();
    String actualPassword = actualAccount.getPassword();
    String actualUserName = actualAccount.getUserName();
    String actualUsername = actualAccount.getUsername();
    boolean actualIsAccountNonExpiredResult = actualAccount.isAccountNonExpired();
    boolean actualIsAccountNonLockedResult = actualAccount.isAccountNonLocked();
    boolean actualIsCredentialsNonExpiredResult = actualAccount.isCredentialsNonExpired();

    // Assert that nothing has changed
    assertEquals("42", actualMobileNumber);
    assertEquals("Account(accountId=1, userName=janedoe, password=iloveyou, email=jane.doe@example.org, enabled=true,"
        + " mobileNumber=42, conversations=[], accountRoles=[])", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("jane.doe@example.org", actualUsername);
    assertEquals("janedoe", actualUserName);
    assertEquals(1, actualAccountId);
    assertTrue(actualIsAccountNonExpiredResult);
    assertTrue(actualIsAccountNonLockedResult);
    assertTrue(actualIsCredentialsNonExpiredResult);
    assertTrue(actualAccount.isEnabled());
    assertSame(accountRoles, actualAccountRoles);
    assertSame(conversations2, actualConversations);
    assertSame(actualAccountRoles, actualAuthorities);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
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

    // Act and Assert
    assertNotEquals(account, null);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
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

    // Act and Assert
    assertNotEquals(account, "Different type to Account");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
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

    // Act and Assert
    assertEquals(account, account);
    int expectedHashCodeResult = account.hashCode();
    assertEquals(expectedHashCodeResult, account.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
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

    // Act and Assert
    assertEquals(account, account2);
    int expectedHashCodeResult = account.hashCode();
    assertEquals(expectedHashCodeResult, account2.hashCode());
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Account account = new Account();
    account.setAccountId(2);
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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    HashSet<AccountRole> accountRoles = new HashSet<>();
    accountRoles.add(accountRole);

    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(accountRoles);
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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");

    HashSet<Conversation> conversations = new HashSet<>();
    conversations.add(conversation);

    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(conversations);
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.now().atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("john.smith@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail(null);
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("Jan 1, 2020 8:00am GMT+0100");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber(null);
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals13() {
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
    account.setPassword("Jan 1, 2020 8:00am GMT+0100");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals14() {
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
    account.setPassword(null);
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals15() {
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
    account.setUserName("Jan 1, 2020 8:00am GMT+0100");

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

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link Account#equals(Object)}
   */
  @Test
  void testEquals16() {
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
    account.setUserName(null);

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

    // Act and Assert
    assertNotEquals(account, account2);
  }
}

