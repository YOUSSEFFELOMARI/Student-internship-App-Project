package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.repository.AccountRepository;
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

@ContextConfiguration(classes = {AccountService.class})
@ExtendWith(SpringExtension.class)
class AccountServiceTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private AccountService accountService;
  /**
   * Method under test: {@link AccountService#showAllAccount(int, int)}
   */
  @Test
  void testShowAllAccount() {
    // Arrange
    PageImpl<Account> pageImpl = new PageImpl<>(new ArrayList<>());
    when(accountRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Account> actualShowAllAccountResult = accountService.showAllAccount(10, 3);

    // Assert
    verify(accountRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllAccountResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllAccountResult);
  }

  /**
   * Method under test: {@link AccountService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(accountRepository).deleteById(Mockito.<Integer>any());
    when(accountRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    accountService.delete(1);

    // Assert that nothing has changed
    verify(accountRepository).deleteById(Mockito.<Integer>any());
    verify(accountRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link AccountService#update(Account)}
   */
  @Test
  void testUpdate() {
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
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account);
    when(accountRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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
    accountService.update(account2);

    // Assert that nothing has changed
    verify(accountRepository).existsById(Mockito.<Integer>any());
    verify(accountRepository).save(Mockito.<Account>any());
    assertEquals("00:00", account2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", account2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", account2.getUpdatedBy());
    assertEquals("42", account2.getMobileNumber());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", account2.getCreatedBy());
    assertEquals("iloveyou", account2.getPassword());
    assertEquals("jane.doe@example.org", account2.getUsername());
    assertEquals("janedoe", account2.getUserName());
    assertEquals(1, account2.getAccountId());
    assertTrue(account2.getAuthorities().isEmpty());
    assertTrue(account2.getConversations().isEmpty());
  }

  /**
   * Method under test: {@link AccountService#find(int)}
   */
  @Test
  void testFind() {
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
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Account actualFindResult = accountService.find(1);

    // Assert
    verify(accountRepository).findById(Mockito.<Integer>any());
    assertSame(account, actualFindResult);
  }

  /**
  * Method under test: {@link AccountService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(accountRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = accountService.count();

    // Assert
    verify(accountRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

