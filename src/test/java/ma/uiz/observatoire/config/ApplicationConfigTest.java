package ma.uiz.observatoire.config;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ApplicationConfig.class, AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class ApplicationConfigTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private ApplicationConfig applicationConfig;
  /**
   * Method under test: {@link ApplicationConfig#userDetailsService()}
   */
  @Test
  void testUserDetailsService() throws UsernameNotFoundException {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R002 Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     1110/0x0000021c076f6e50.arg$1

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
    AccountRepository repository = mock(AccountRepository.class);
    when(repository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    UserDetails actualLoadUserByUsernameResult = (new ApplicationConfig(repository)).userDetailsService()
        .loadUserByUsername("janedoe");

    // Assert
    verify(repository).findByEmail(Mockito.<String>any());
    assertSame(account, actualLoadUserByUsernameResult);
  }

  /**
   * Method under test: {@link ApplicationConfig#userDetailsService()}
   */
  @Test
  void testUserDetailsService2() throws UsernameNotFoundException {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R002 Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     1110/0x0000021c076f6e50.arg$1

    // Arrange
    AccountRepository repository = mock(AccountRepository.class);
    Optional<Account> emptyResult = Optional.empty();
    when(repository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(UsernameNotFoundException.class,
        () -> (new ApplicationConfig(repository)).userDetailsService().loadUserByUsername("janedoe"));
    verify(repository).findByEmail(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ApplicationConfig#userDetailsService()}
   */
  @Test
  void testUserDetailsService3() throws UsernameNotFoundException {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R002 Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     1110/0x0000021c076f6e50.arg$1

    // Arrange
    AccountRepository repository = mock(AccountRepository.class);
    when(repository.findByEmail(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("User not found"));

    // Act and Assert
    assertThrows(UsernameNotFoundException.class,
        () -> (new ApplicationConfig(repository)).userDetailsService().loadUserByUsername("janedoe"));
    verify(repository).findByEmail(Mockito.<String>any());
  }

  /**
   * Method under test: {@link ApplicationConfig#authenticationProvider()}
   */
  @Test
  void testAuthenticationProvider() {
    // Arrange, Act and Assert
    assertTrue(applicationConfig.authenticationProvider() instanceof DaoAuthenticationProvider);
  }

  /**
  * Method under test: {@link ApplicationConfig#authenticationManager(AuthenticationConfiguration)}
  */
  @Test
  void testAuthenticationManager() throws Exception {
    // Arrange, Act and Assert
    assertTrue(applicationConfig.authenticationManager(new AuthenticationConfiguration()) instanceof ProviderManager);
  }

  /**
   * Method under test: {@link ApplicationConfig#passwordEncoder()}
   */
  @Test
  void testPasswordEncoder() {
    // Arrange, Act and Assert
    assertTrue(applicationConfig.passwordEncoder() instanceof BCryptPasswordEncoder);
  }
}

