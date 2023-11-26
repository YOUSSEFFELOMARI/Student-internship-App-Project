package ma.uiz.observatoire.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import ma.uiz.observatoire.auth.FilterChainExceptionHandler;
import ma.uiz.observatoire.auth.JwtAuthenticationFilter;
import ma.uiz.observatoire.repository.AccountRoleRepository;
import ma.uiz.observatoire.repository.TokenRepository;
import ma.uiz.observatoire.service.AccountRoleService;
import ma.uiz.observatoire.service.JwtService;
import ma.uiz.observatoire.service.LogoutService;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

class SecurityConfigurationTest {
  /**
  * Method under test: {@link SecurityConfiguration#corsConfigurationSource()}
  */
  @Test
  void testCorsConfigurationSource() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R027 Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //       org.springframework.security.authentication.AuthenticationProvider
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    JwtService jwtService = new JwtService(new AccountRoleService(mock(AccountRoleRepository.class)));
    JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(jwtService, new JdbcDaoImpl(),
        mock(TokenRepository.class));

    RunAsImplAuthenticationProvider authenticationProvider = new RunAsImplAuthenticationProvider();
    LogoutService logoutHandler = new LogoutService(mock(TokenRepository.class));

    // Act
    CorsConfigurationSource actualCorsConfigurationSourceResult = (new SecurityConfiguration(jwtAuthFilter,
        authenticationProvider, logoutHandler, new FilterChainExceptionHandler())).corsConfigurationSource();
    actualCorsConfigurationSourceResult.getCorsConfiguration(new MockHttpServletRequest());

    // Assert
    assertTrue(actualCorsConfigurationSourceResult instanceof UrlBasedCorsConfigurationSource);
  }

  /**
   * Method under test: {@link SecurityConfiguration#logFilter()}
   */
  @Test
  void testLogFilter() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R027 Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //       org.springframework.security.authentication.AuthenticationProvider
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    JwtService jwtService = new JwtService(new AccountRoleService(mock(AccountRoleRepository.class)));
    JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(jwtService, new JdbcDaoImpl(),
        mock(TokenRepository.class));

    RunAsImplAuthenticationProvider authenticationProvider = new RunAsImplAuthenticationProvider();
    LogoutService logoutHandler = new LogoutService(mock(TokenRepository.class));
    SecurityConfiguration securityConfiguration = new SecurityConfiguration(jwtAuthFilter, authenticationProvider,
        logoutHandler, new FilterChainExceptionHandler());

    // Act
    securityConfiguration.logFilter();

    // Assert
    Map<String, CorsConfiguration> corsConfigurations = ((UrlBasedCorsConfigurationSource) securityConfiguration
        .corsConfigurationSource()).getCorsConfigurations();
    assertEquals(1, corsConfigurations.size());
    assertTrue(corsConfigurations.containsKey("/**"));
  }
}

