package ma.uiz.observatoire.auth;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import org.apache.catalina.connector.CoyoteWriter;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {FilterChainExceptionHandler.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class FilterChainExceptionHandlerTest {
  @Autowired
  private FilterChainExceptionHandler filterChainExceptionHandler;

  @MockBean(name = "handlerExceptionResolver")
  private HandlerExceptionResolver handlerExceptionResolver;
  /**
  * Method under test: {@link FilterChainExceptionHandler#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
  */
  @Test
  void testDoFilterInternal() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    filterChainExceptionHandler.doFilterInternal(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
  }

  /**
   * Method under test: {@link FilterChainExceptionHandler#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternal2() throws ServletException, IOException {
    // Arrange
    when(handlerExceptionResolver.resolveException(Mockito.<HttpServletRequest>any(),
        Mockito.<HttpServletResponse>any(), Mockito.<Object>any(), Mockito.<Exception>any()))
            .thenReturn(new ModelAndView("View Name"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    CoyoteWriter coyoteWriter = mock(CoyoteWriter.class);
    doNothing().when(coyoteWriter).write(Mockito.<String>any());
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.getWriter()).thenReturn(coyoteWriter);
    doNothing().when(response).setCharacterEncoding(Mockito.<String>any());
    doNothing().when(response).setContentType(Mockito.<String>any());
    doNothing().when(response).setHeader(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(response).setStatus(anyInt());
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    filterChainExceptionHandler.doFilterInternal(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    verify(response).getWriter();
    verify(response).setCharacterEncoding(Mockito.<String>any());
    verify(response).setContentType(Mockito.<String>any());
    verify(response).setHeader(Mockito.<String>any(), Mockito.<String>any());
    verify(response).setStatus(anyInt());
    verify(coyoteWriter).write(Mockito.<String>any());
    verify(handlerExceptionResolver).resolveException(Mockito.<HttpServletRequest>any(),
        Mockito.<HttpServletResponse>any(), Mockito.<Object>any(), Mockito.<Exception>any());
  }

  /**
   * Method under test: {@link FilterChainExceptionHandler#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternal3() throws ServletException, IOException {
    // Arrange
    when(handlerExceptionResolver.resolveException(Mockito.<HttpServletRequest>any(),
        Mockito.<HttpServletResponse>any(), Mockito.<Object>any(), Mockito.<Exception>any()))
            .thenReturn(new ModelAndView("View Name"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    CoyoteWriter coyoteWriter = mock(CoyoteWriter.class);
    doNothing().when(coyoteWriter).write(Mockito.<String>any());
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.getWriter()).thenReturn(coyoteWriter);
    doNothing().when(response).setCharacterEncoding(Mockito.<String>any());
    doNothing().when(response).setContentType(Mockito.<String>any());
    doNothing().when(response).setHeader(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(response).setStatus(anyInt());
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("application/json")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    filterChainExceptionHandler.doFilterInternal(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    verify(response).getWriter();
    verify(response).setCharacterEncoding(Mockito.<String>any());
    verify(response).setContentType(Mockito.<String>any());
    verify(response).setHeader(Mockito.<String>any(), Mockito.<String>any());
    verify(response).setStatus(anyInt());
    verify(coyoteWriter).write(Mockito.<String>any());
    verify(handlerExceptionResolver).resolveException(Mockito.<HttpServletRequest>any(),
        Mockito.<HttpServletResponse>any(), Mockito.<Object>any(), Mockito.<Exception>any());
  }
}

