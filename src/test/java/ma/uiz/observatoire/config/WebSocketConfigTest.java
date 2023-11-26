package ma.uiz.observatoire.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ma.uiz.observatoire.repository.AccountRoleRepository;
import ma.uiz.observatoire.repository.TokenRepository;
import ma.uiz.observatoire.service.AccountRoleService;
import ma.uiz.observatoire.service.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebMvcStompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebMvcStompWebSocketEndpointRegistration;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@ContextConfiguration(classes = {WebSocketConfig.class, JwtService.class, AccountRoleService.class})
@ExtendWith(SpringExtension.class)
class WebSocketConfigTest {
  @MockBean
  private AccountRoleRepository accountRoleRepository;

  @MockBean
  private TokenRepository tokenRepository;

  @MockBean
  private UserDetailsService userDetailsService;

  @Autowired
  private WebSocketConfig webSocketConfig;
  /**
   * Method under test: {@link WebSocketConfig#registerStompEndpoints(StompEndpointRegistry)}
   */
  @Test
  void testRegisterStompEndpoints() {
    // Arrange
    WebMvcStompEndpointRegistry registry = mock(WebMvcStompEndpointRegistry.class);
    BinaryWebSocketHandler webSocketHandler = new BinaryWebSocketHandler();
    when(registry.addEndpoint((String[]) any())).thenReturn(new WebMvcStompWebSocketEndpointRegistration(
        new String[]{"Paths"}, webSocketHandler, new ConcurrentTaskScheduler()));

    // Act
    webSocketConfig.registerStompEndpoints(registry);

    // Assert
    verify(registry).addEndpoint((String[]) any());
  }

  /**
  * Method under test: {@link WebSocketConfig#configureClientInboundChannel(ChannelRegistration)}
  */
  @Test
  void testConfigureClientInboundChannel() {
    // Arrange
    ChannelRegistration registration = mock(ChannelRegistration.class);
    when(registration.interceptors((ChannelInterceptor[]) any())).thenReturn(new ChannelRegistration());

    // Act
    webSocketConfig.configureClientInboundChannel(registration);

    // Assert
    verify(registration).interceptors((ChannelInterceptor[]) any());
  }

  /**
   * Method under test: {@link WebSocketConfig#rmeSessionChannelInterceptor()}
   */
  @Test
  void testRmeSessionChannelInterceptor() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R002 Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     RmeSessionChannelInterceptor.jwtService
    //     RmeSessionChannelInterceptor.tokenRepository
    //     RmeSessionChannelInterceptor.userDetailsService

    // Arrange, Act and Assert
    assertTrue((new WebSocketConfig()).rmeSessionChannelInterceptor().preReceive(null));
  }
}

