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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Token.class})
@ExtendWith(SpringExtension.class)
class TokenTest {
  @Autowired
  private Token token;

  /**
   * Method under test: {@link Token#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Token()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Token#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Token token2 = new Token();

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

    Token token3 = new Token();
    token3.setAccount(account);
    token3.setExpired(true);
    token3.setId(1);
    token3.setRevoked(true);
    token3.setToken("ABC123");
    token3.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertTrue(token2.canEqual(token3));
  }

  /**
   * Method under test: {@link Token#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    Token token2 = new Token();
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

    Token token3 = new Token();
    token3.setAccount(account);
    token3.setExpired(true);
    token3.setId(1);
    token3.setRevoked(true);
    token3.setToken("ABC123");
    token3.setTokenType(Token.TokenType.BEARER);

    // Act
    boolean actualCanEqualResult = token2.canEqual(token3);

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
   * Method under test: {@link Token#Token()}
   */
  @Test
  void testConstructor() {
    // Arrange, Act and Assert
    assertEquals(Token.TokenType.BEARER, (new Token()).getTokenType());
  }

  /**
   * Method under test: {@link Token#Token(Integer, String, Token.TokenType, boolean, boolean, Account)}
   */
  @Test
  void testConstructor2() {
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

    // Act
    Token actualToken = new Token(1, "ABC123", Token.TokenType.BEARER, true, true, account);

    // Assert
    assertEquals("ABC123", actualToken.getToken());
    assertEquals(1, actualToken.getId().intValue());
    assertEquals(Token.TokenType.BEARER, actualToken.getTokenType());
    assertTrue(actualToken.isExpired());
    assertTrue(actualToken.isRevoked());
    Account expectedAccount = actualToken.account;
    assertSame(expectedAccount, actualToken.getAccount());
  }

  /**
   * Method under test: {@link Token#Token(Integer, String, Token.TokenType, boolean, boolean, Account)}
   */
  @Test
  void testConstructor3() {
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

    // Act
    Token actualToken = new Token(1, "ABC123", Token.TokenType.BEARER, true, true, account);

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
    assertEquals("ABC123", actualToken.getToken());
    assertEquals(1, actualToken.getId().intValue());
    assertEquals(Token.TokenType.BEARER, actualToken.getTokenType());
    assertTrue(actualToken.isExpired());
    assertTrue(actualToken.isRevoked());
    Account expectedAccount = actualToken.account;
    assertSame(expectedAccount, actualToken.getAccount());
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, null);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, "Different type to Token");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Token#equals(Object)}
   *   <li>{@link Token#hashCode()}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertEquals(token, token);
    int expectedHashCodeResult = token.hashCode();
    assertEquals(expectedHashCodeResult, token.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Token#equals(Object)}
   *   <li>{@link Token#hashCode()}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertEquals(token, token2);
    int expectedHashCodeResult = token.hashCode();
    assertEquals(expectedHashCodeResult, token2.hashCode());
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(false);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(2);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(null);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(false);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("Token");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken(null);
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(null);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(Token.TokenType.BEARER);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
   * Method under test: {@link Token#equals(Object)}
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    Token token2 = new Token();
    token2.setAccount(account2);
    token2.setExpired(true);
    token2.setId(1);
    token2.setRevoked(true);
    token2.setToken("ABC123");
    token2.setTokenType(null);

    // Act and Assert
    assertNotEquals(token, token2);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Token#setAccount(Account)}
  *   <li>{@link Token#setExpired(boolean)}
  *   <li>{@link Token#setId(Integer)}
  *   <li>{@link Token#setRevoked(boolean)}
  *   <li>{@link Token#setToken(String)}
  *   <li>{@link Token#setTokenType(Token.TokenType)}
  *   <li>{@link Token#toString()}
  *   <li>{@link Token#getAccount()}
  *   <li>{@link Token#getId()}
  *   <li>{@link Token#getToken()}
  *   <li>{@link Token#getTokenType()}
  *   <li>{@link Token#isExpired()}
  *   <li>{@link Token#isRevoked()}
  * </ul>
  */
  @Test
  void testSetAccount() {
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

    Token token = new Token();
    token.setAccount(account);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);

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

    // Act
    token.setAccount(account2);
    token.setExpired(true);
    token.setId(1);
    token.setRevoked(true);
    token.setToken("ABC123");
    token.setTokenType(Token.TokenType.BEARER);
    String actualToStringResult = token.toString();
    Account actualAccount = token.getAccount();
    Integer actualId = token.getId();
    String actualToken = token.getToken();
    Token.TokenType actualTokenType = token.getTokenType();
    boolean actualIsExpiredResult = token.isExpired();
    boolean actualIsRevokedResult = token.isRevoked();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("Token(id=1, token=ABC123, tokenType=BEARER, revoked=true, expired=true, account=Account(accountId=1,"
        + " userName=janedoe, password=iloveyou, email=jane.doe@example.org, enabled=true, mobileNumber=42,"
        + " conversations=[], accountRoles=[]))", actualToStringResult);
    assertEquals(1, actualId.intValue());
    assertEquals(Token.TokenType.BEARER, actualTokenType);
    assertTrue(actualIsExpiredResult);
    assertTrue(actualIsRevokedResult);
    assertSame(account2, actualAccount);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Token.TokenBuilder#build()}
   *   <li>{@link Token.TokenBuilder#account(Account)}
   *   <li>{@link Token.TokenBuilder#expired(boolean)}
   *   <li>{@link Token.TokenBuilder#id(Integer)}
   *   <li>{@link Token.TokenBuilder#revoked(boolean)}
   *   <li>{@link Token.TokenBuilder#token(String)}
   *   <li>{@link Token.TokenBuilder#tokenType(Token.TokenType)}
   * </ul>
   */
  @Test
  void testTokenBuilderBuild() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    HashSet<AccountRole> accountRoles = new HashSet<>();
    account.setAccountRoles(accountRoles);
    HashSet<Conversation> conversations = new HashSet<>();
    account.setConversations(conversations);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    account.setCreatedAt(ofResult.atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    account.setUpdatedAt(ofResult2.atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    // Act
    Token actualBuildResult = Token.builder()
        .account(account)
        .expired(true)
        .id(1)
        .revoked(true)
        .token("ABC123")
        .tokenType(Token.TokenType.BEARER)
        .build();

    // Assert
    Account account2 = actualBuildResult.getAccount();
    LocalDateTime createdAt = account2.getCreatedAt();
    assertEquals("00:00", createdAt.toLocalTime().toString());
    LocalDateTime updatedAt = account2.getUpdatedAt();
    assertEquals("00:00", updatedAt.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = updatedAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", account2.getUpdatedBy());
    assertEquals("42", account2.getMobileNumber());
    assertEquals("ABC123", actualBuildResult.getToken());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", account2.getCreatedBy());
    assertEquals("iloveyou", account2.getPassword());
    assertEquals("jane.doe@example.org", account2.getEmail());
    assertEquals("jane.doe@example.org", account2.getUsername());
    assertEquals("janedoe", account2.getUserName());
    assertEquals(1, actualBuildResult.getId().intValue());
    assertEquals(1, account2.getAccountId());
    assertEquals(Token.TokenType.BEARER, actualBuildResult.getTokenType());
    Collection<? extends GrantedAuthority> authorities = account2.getAuthorities();
    assertTrue(authorities.isEmpty());
    Set<Conversation> conversations2 = account2.getConversations();
    assertTrue(conversations2.isEmpty());
    assertTrue(account2.isAccountNonExpired());
    assertTrue(account2.isAccountNonLocked());
    assertTrue(account2.isCredentialsNonExpired());
    assertTrue(account2.isEnabled());
    assertTrue(actualBuildResult.isExpired());
    assertTrue(actualBuildResult.isRevoked());
    assertSame(accountRoles, authorities);
    assertSame(conversations, conversations2);
    assertSame(authorities, account2.getAccountRoles());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(actualBuildResult.account, account2);
  }
}

