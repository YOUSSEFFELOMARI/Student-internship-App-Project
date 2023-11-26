package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AccountRole.class})
@ExtendWith(SpringExtension.class)
class AccountRoleTest {
  @Autowired
  private AccountRole accountRole;

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AccountRole.AccountRoleBuilder#build()}
   *   <li>{@link AccountRole.AccountRoleBuilder#accountRoleId(int)}
   *   <li>{@link AccountRole.AccountRoleBuilder#roleName(String)}
   * </ul>
   */
  @Test
  void testAccountRoleBuilderBuild() {
    // Arrange and Act
    AccountRole actualBuildResult = AccountRole.builder().accountRoleId(1).roleName("Role Name").build();

    // Assert
    assertEquals("Role Name", actualBuildResult.getAuthority());
    assertEquals("Role Name", actualBuildResult.getRoleName());
    assertNull(actualBuildResult.getCreatedBy());
    assertNull(actualBuildResult.getUpdatedBy());
    assertNull(actualBuildResult.getCreatedAt());
    assertNull(actualBuildResult.getUpdatedAt());
    assertEquals(1, actualBuildResult.getAccountRoleId());
  }

  /**
   * Method under test: {@link AccountRole#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new AccountRole()).canEqual("Other"));
  }

  /**
   * Method under test: {@link AccountRole#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    AccountRole accountRole2 = new AccountRole();

    AccountRole accountRole3 = new AccountRole();
    accountRole3.setAccountRoleId(1);
    accountRole3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole3.setRoleName("Role Name");
    accountRole3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(accountRole2.canEqual(accountRole3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link AccountRole#AccountRole()}
  *   <li>{@link AccountRole#setAccountRoleId(int)}
  *   <li>{@link AccountRole#setRoleName(String)}
  *   <li>{@link AccountRole#toString()}
  *   <li>{@link AccountRole#getAccountRoleId()}
  *   <li>{@link AccountRole#getAuthority()}
  *   <li>{@link AccountRole#getRoleName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    AccountRole actualAccountRole = new AccountRole();
    actualAccountRole.setAccountRoleId(1);
    actualAccountRole.setRoleName("Role Name");
    String actualToStringResult = actualAccountRole.toString();
    int actualAccountRoleId = actualAccountRole.getAccountRoleId();
    String actualAuthority = actualAccountRole.getAuthority();

    // Assert that nothing has changed
    assertEquals("AccountRole(accountRoleId=1, roleName=Role Name)", actualToStringResult);
    assertEquals("Role Name", actualAuthority);
    assertEquals("Role Name", actualAccountRole.getRoleName());
    assertEquals(1, actualAccountRoleId);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AccountRole#AccountRole(int, String)}
   *   <li>{@link AccountRole#setAccountRoleId(int)}
   *   <li>{@link AccountRole#setRoleName(String)}
   *   <li>{@link AccountRole#toString()}
   *   <li>{@link AccountRole#getAccountRoleId()}
   *   <li>{@link AccountRole#getAuthority()}
   *   <li>{@link AccountRole#getRoleName()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange and Act
    AccountRole actualAccountRole = new AccountRole(1, "Role Name");
    actualAccountRole.setAccountRoleId(1);
    actualAccountRole.setRoleName("Role Name");
    String actualToStringResult = actualAccountRole.toString();
    int actualAccountRoleId = actualAccountRole.getAccountRoleId();
    String actualAuthority = actualAccountRole.getAuthority();

    // Assert that nothing has changed
    assertEquals("AccountRole(accountRoleId=1, roleName=Role Name)", actualToStringResult);
    assertEquals("Role Name", actualAuthority);
    assertEquals("Role Name", actualAccountRole.getRoleName());
    assertEquals(1, actualAccountRoleId);
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, null);
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, "Different type to AccountRole");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AccountRole#equals(Object)}
   *   <li>{@link AccountRole#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(accountRole, accountRole);
    int expectedHashCodeResult = accountRole.hashCode();
    assertEquals(expectedHashCodeResult, accountRole.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AccountRole#equals(Object)}
   *   <li>{@link AccountRole#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(accountRole, accountRole2);
    int expectedHashCodeResult = accountRole.hashCode();
    assertEquals(expectedHashCodeResult, accountRole2.hashCode());
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(2);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, accountRole2);
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.now().atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, accountRole2);
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, accountRole2);
  }

  /**
   * Method under test: {@link AccountRole#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName(null);
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(accountRole, accountRole2);
  }
}

