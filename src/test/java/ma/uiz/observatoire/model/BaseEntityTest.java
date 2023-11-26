package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Account.class})
@ExtendWith(SpringExtension.class)
class BaseEntityTest {
  @Autowired
  private BaseEntity baseEntity;

  /**
  * Method under test: {@link BaseEntity#equals(Object)}
  */
  @Test
  void testEquals() {
    // Arrange, Act and Assert
    assertNotEquals(new Account(), null);
    assertNotEquals(new Account(), "Different type to BaseEntity");
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Account account = new Account();

    // Act and Assert
    assertEquals(account, account);
    int expectedHashCodeResult = account.hashCode();
    assertEquals(expectedHashCodeResult, account.hashCode());
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals3() {
    // Arrange
    Account account = new Account();
    Account account2 = new Account();

    // Act and Assert
    assertEquals(account, account2);
    int expectedHashCodeResult = account.hashCode();
    assertEquals(expectedHashCodeResult, account2.hashCode());
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals4() {
    // Arrange
    Account.AccountBuilder accountIdResult = Account.builder().accountId(1);
    Account.AccountBuilder accountRolesResult = accountIdResult.accountRoles(new HashSet<>());
    Account buildResult = accountRolesResult.conversations(new HashSet<>())
        .email("jane.doe@example.org")
        .enabled(true)
        .mobileNumber("42")
        .password("iloveyou")
        .userName("janedoe")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, new Account());
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Account account = new Account();
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Account account = new Account();
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Account account = new Account();
    account.setCreatedAt(LocalDate.now().atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Account account = new Account();
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Account account = new Account();
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    Account account = new Account();
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    Account account = new Account();
    account.setUpdatedAt(LocalDate.now().atStartOfDay());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    Account account = new Account();
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    Account account = new Account();
    account.setUpdatedBy("2020-03-01");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
    Account account = new Account();
    account.setUpdatedBy("2020/03/01");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Account account2 = mock(Account.class);
    when(account2.isEnabled()).thenReturn(true);
    when(account2.getAccountId()).thenReturn(1);
    when(account2.getCreatedBy()).thenReturn(null);
    when(account2.getUpdatedBy()).thenReturn("2020-03-01");
    when(account2.getCreatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.getUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(account2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(account, account2);
  }

  /**
   * Method under test: {@link BaseEntity#getCreatedAt()}
   */
  @Test
  void testGetCreatedAt() {
    // Arrange, Act and Assert
    assertNull(baseEntity.getCreatedAt());
  }

  /**
   * Method under test: {@link BaseEntity#getCreatedBy()}
   */
  @Test
  void testGetCreatedBy() {
    // Arrange, Act and Assert
    assertNull(baseEntity.getCreatedBy());
  }

  /**
   * Method under test: {@link BaseEntity#getUpdatedAt()}
   */
  @Test
  void testGetUpdatedAt() {
    // Arrange, Act and Assert
    assertNull(baseEntity.getUpdatedAt());
  }

  /**
   * Method under test: {@link BaseEntity#getUpdatedBy()}
   */
  @Test
  void testGetUpdatedBy() {
    // Arrange, Act and Assert
    assertNull(baseEntity.getUpdatedBy());
  }

  /**
   * Method under test: {@link BaseEntity#setCreatedAt(LocalDateTime)}
   */
  @Test
  void testSetCreatedAt() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    baseEntity.setCreatedAt(createdAt);

    // Assert
    assertSame(createdAt, baseEntity.getCreatedAt());
  }

  /**
   * Method under test: {@link BaseEntity#setCreatedBy(String)}
   */
  @Test
  void testSetCreatedBy() {
    // Arrange and Act
    baseEntity.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertEquals("Jan 1, 2020 8:00am GMT+0100", baseEntity.getCreatedBy());
  }

  /**
   * Method under test: {@link BaseEntity#setUpdatedAt(LocalDateTime)}
   */
  @Test
  void testSetUpdatedAt() {
    // Arrange
    LocalDateTime updatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    baseEntity.setUpdatedAt(updatedAt);

    // Assert
    assertSame(updatedAt, baseEntity.getUpdatedAt());
  }

  /**
   * Method under test: {@link BaseEntity#setUpdatedBy(String)}
   */
  @Test
  void testSetUpdatedBy() {
    // Arrange and Act
    baseEntity.setUpdatedBy("2020-03-01");

    // Assert
    assertEquals("2020-03-01", baseEntity.getUpdatedBy());
  }
}

