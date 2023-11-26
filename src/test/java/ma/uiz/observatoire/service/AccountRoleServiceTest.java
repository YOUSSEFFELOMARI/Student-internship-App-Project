package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import ma.uiz.observatoire.model.AccountRole;
import ma.uiz.observatoire.repository.AccountRoleRepository;
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

@ContextConfiguration(classes = {AccountRoleService.class})
@ExtendWith(SpringExtension.class)
class AccountRoleServiceTest {
  @MockBean
  private AccountRoleRepository accountRoleRepository;

  @Autowired
  private AccountRoleService accountRoleService;
  /**
   * Method under test: {@link AccountRoleService#showAllAccountRole(int, int)}
   */
  @Test
  void testShowAllAccountRole() {
    // Arrange
    PageImpl<AccountRole> pageImpl = new PageImpl<>(new ArrayList<>());
    when(accountRoleRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<AccountRole> actualShowAllAccountRoleResult = accountRoleService.showAllAccountRole(10, 3);

    // Assert
    verify(accountRoleRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllAccountRoleResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllAccountRoleResult);
  }

  /**
   * Method under test: {@link AccountRoleService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(accountRoleRepository).deleteById(Mockito.<Integer>any());
    when(accountRoleRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    accountRoleService.delete(1);

    // Assert that nothing has changed
    verify(accountRoleRepository).deleteById(Mockito.<Integer>any());
    verify(accountRoleRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link AccountRoleService#update(AccountRole)}
   */
  @Test
  void testUpdate() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");
    when(accountRoleRepository.save(Mockito.<AccountRole>any())).thenReturn(accountRole);
    when(accountRoleRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    AccountRole accountRole2 = new AccountRole();
    accountRole2.setAccountRoleId(1);
    accountRole2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole2.setRoleName("Role Name");
    accountRole2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole2.setUpdatedBy("2020-03-01");

    // Act
    accountRoleService.update(accountRole2);

    // Assert that nothing has changed
    verify(accountRoleRepository).existsById(Mockito.<Integer>any());
    verify(accountRoleRepository).save(Mockito.<AccountRole>any());
    assertEquals("00:00", accountRole2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", accountRole2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", accountRole2.getUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", accountRole2.getCreatedBy());
    assertEquals("Role Name", accountRole2.getRoleName());
    assertEquals(1, accountRole2.getAccountRoleId());
  }

  /**
   * Method under test: {@link AccountRoleService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    AccountRole accountRole = new AccountRole();
    accountRole.setAccountRoleId(1);
    accountRole.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    accountRole.setRoleName("Role Name");
    accountRole.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    accountRole.setUpdatedBy("2020-03-01");
    Optional<AccountRole> ofResult = Optional.of(accountRole);
    when(accountRoleRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    AccountRole actualFindResult = accountRoleService.find(1);

    // Assert
    verify(accountRoleRepository).findById(Mockito.<Integer>any());
    assertSame(accountRole, actualFindResult);
  }

  /**
  * Method under test: {@link AccountRoleService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(accountRoleRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = accountRoleService.count();

    // Assert
    verify(accountRoleRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

