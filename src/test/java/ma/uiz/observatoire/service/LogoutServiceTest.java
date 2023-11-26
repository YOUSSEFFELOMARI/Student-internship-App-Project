package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Token;
import ma.uiz.observatoire.repository.TokenRepository;
import org.apache.catalina.connector.Response;
import org.apache.catalina.connector.ResponseFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletMapping;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LogoutService.class})
@ExtendWith(SpringExtension.class)
class LogoutServiceTest {
  @Autowired
  private LogoutService logoutService;

  @MockBean
  private TokenRepository tokenRepository;
  /**
  * Method under test: {@link LogoutService#logout(HttpServletRequest, HttpServletResponse, Authentication)}
  */
  @Test
  void testLogout() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    TestingAuthenticationToken authentication = new TestingAuthenticationToken("Principal", "Credentials");

    // Act
    logoutService.logout(request, response, authentication);

    // Assert that nothing has changed
    HttpServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof ResponseFacade);
    assertTrue(request.getInputStream() instanceof DelegatingServletInputStream);
    assertTrue(request.getHttpServletMapping() instanceof MockHttpServletMapping);
    assertTrue(request.getSession() instanceof MockHttpSession);
    assertEquals("", request.getContextPath());
    assertEquals("", request.getMethod());
    assertEquals("", request.getRequestURI());
    assertEquals("", request.getServletPath());
    assertEquals("HTTP/1.1", request.getProtocol());
    assertEquals("http", request.getScheme());
    assertEquals("localhost", request.getLocalName());
    assertEquals("localhost", request.getRemoteHost());
    assertEquals("localhost", request.getServerName());
    assertEquals(80, request.getLocalPort());
    assertEquals(80, request.getRemotePort());
    assertEquals(80, request.getServerPort());
    assertEquals(DispatcherType.REQUEST, request.getDispatcherType());
    assertFalse(request.isAsyncStarted());
    assertFalse(request.isAsyncSupported());
    assertFalse(request.isRequestedSessionIdFromURL());
    assertFalse(authentication.isAuthenticated());
    assertTrue(request.isActive());
    assertTrue(request.isRequestedSessionIdFromCookie());
    assertTrue(request.isRequestedSessionIdValid());
    assertSame(response.getOutputStream(), response2.getOutputStream());
  }

  /**
   * Method under test: {@link LogoutService#logout(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  void testLogout2() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    Response response = new Response();

    // Act
    logoutService.logout(request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getHeader(Mockito.<String>any());
  }

  /**
   * Method under test: {@link LogoutService#logout(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  void testLogout3() {
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
    Optional<Token> ofResult = Optional.of(token);

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
    when(tokenRepository.save(Mockito.<Token>any())).thenReturn(token2);
    when(tokenRepository.findByToken(Mockito.<String>any())).thenReturn(ofResult);
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Bearer ");
    Response response = new Response();

    // Act
    logoutService.logout(request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getHeader(Mockito.<String>any());
    verify(tokenRepository).findByToken(Mockito.<String>any());
    verify(tokenRepository).save(Mockito.<Token>any());
  }
}

