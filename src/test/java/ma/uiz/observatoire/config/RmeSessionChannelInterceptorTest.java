package ma.uiz.observatoire.config;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import ma.uiz.observatoire.repository.TokenRepository;
import ma.uiz.observatoire.service.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@ContextConfiguration(classes = {RmeSessionChannelInterceptor.class})
@ExtendWith(SpringExtension.class)
class RmeSessionChannelInterceptorTest {
  @MockBean
  private JwtService jwtService;

  @Autowired
  private RmeSessionChannelInterceptor rmeSessionChannelInterceptor;

  @MockBean
  private TokenRepository tokenRepository;

  @MockBean
  private UserDetailsService userDetailsService;
  /**
  * Method under test: {@link RmeSessionChannelInterceptor#preSend(Message, MessageChannel)}
  */
  @Test
  void testPreSend() {
    // Arrange
    ErrorMessage message = new ErrorMessage(new Throwable());

    // Act and Assert
    assertSame(message, rmeSessionChannelInterceptor.preSend(message, mock(MessageChannel.class)));
  }

  /**
   * Method under test: {@link RmeSessionChannelInterceptor#preSend(Message, MessageChannel)}
   */
  @Test
  void testPreSend2() {
    // Arrange
    MessageHeaders messageHeaders = mock(MessageHeaders.class);
    when(messageHeaders.entrySet()).thenReturn(new HashSet<>());
    when(messageHeaders.size()).thenReturn(3);
    when(messageHeaders.get(Mockito.<Object>any(), Mockito.<Class<MultiValueMap<Object, Object>>>any()))
        .thenReturn(new LinkedMultiValueMap<>());
    Message<?> message = mock(Message.class);
    when(message.getHeaders()).thenReturn(messageHeaders);

    // Act
    Message<?> actualPreSendResult = rmeSessionChannelInterceptor.preSend(message, mock(MessageChannel.class));

    // Assert
    verify(message, atLeast(1)).getHeaders();
    verify(messageHeaders).entrySet();
    verify(messageHeaders).get(Mockito.<Object>any(), Mockito.<Class<MultiValueMap<Object, Object>>>any());
    verify(messageHeaders).size();
    assertSame(message, actualPreSendResult);
  }
}

