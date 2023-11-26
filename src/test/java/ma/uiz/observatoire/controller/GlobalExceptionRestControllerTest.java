package ma.uiz.observatoire.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ma.uiz.observatoire.model.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GlobalExceptionRestController.class})
@ExtendWith(SpringExtension.class)
class GlobalExceptionRestControllerTest {
  @Autowired
  private GlobalExceptionRestController globalExceptionRestController;
  /**
   * Method under test: {@link GlobalExceptionRestController#findExceptionHandler(Exception)}
   */
  @Test
  void testFindExceptionHandler() {
    // Arrange and Act
    ResponseEntity<Response> actualFindExceptionHandlerResult = globalExceptionRestController
        .findExceptionHandler(new Exception("foo"));

    // Assert
    Response body = actualFindExceptionHandlerResult.getBody();
    assertEquals("404", body.getStatusCode());
    assertEquals("foo", body.getStatusMsg());
    assertEquals(404, actualFindExceptionHandlerResult.getStatusCodeValue());
    assertTrue(actualFindExceptionHandlerResult.hasBody());
    assertTrue(actualFindExceptionHandlerResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link GlobalExceptionRestController#saveExceptionHandler(Exception)}
   */
  @Test
  void testSaveExceptionHandler() {
    // Arrange and Act
    ResponseEntity<Response> actualSaveExceptionHandlerResult = globalExceptionRestController
        .saveExceptionHandler(new Exception("foo"));

    // Assert
    Response body = actualSaveExceptionHandlerResult.getBody();
    assertEquals("409", body.getStatusCode());
    assertEquals("foo", body.getStatusMsg());
    assertEquals(409, actualSaveExceptionHandlerResult.getStatusCodeValue());
    assertTrue(actualSaveExceptionHandlerResult.hasBody());
    assertTrue(actualSaveExceptionHandlerResult.getHeaders().isEmpty());
  }

  /**
  * Method under test: {@link GlobalExceptionRestController#authExceptionHandler(Exception)}
  */
  @Test
  void testAuthExceptionHandler() {
    // Arrange and Act
    ResponseEntity<Response> actualAuthExceptionHandlerResult = globalExceptionRestController
        .authExceptionHandler(new Exception("foo"));

    // Assert
    Response body = actualAuthExceptionHandlerResult.getBody();
    assertEquals("401", body.getStatusCode());
    assertEquals("foo", body.getStatusMsg());
    assertEquals(401, actualAuthExceptionHandlerResult.getStatusCodeValue());
    assertTrue(actualAuthExceptionHandlerResult.hasBody());
    assertTrue(actualAuthExceptionHandlerResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link GlobalExceptionRestController#generalExceptionHandler(Exception)}
   */
  @Test
  void testGeneralExceptionHandler() {
    // Arrange and Act
    ResponseEntity<Response> actualGeneralExceptionHandlerResult = globalExceptionRestController
        .generalExceptionHandler(new Exception("foo"));

    // Assert
    Response body = actualGeneralExceptionHandlerResult.getBody();
    assertEquals("500", body.getStatusCode());
    assertEquals("foo", body.getStatusMsg());
    assertEquals(500, actualGeneralExceptionHandlerResult.getStatusCodeValue());
    assertTrue(actualGeneralExceptionHandlerResult.hasBody());
    assertTrue(actualGeneralExceptionHandlerResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link GlobalExceptionRestController#processRuntimeException(RuntimeException)}
   */
  @Test
  void testProcessRuntimeException() {
    // Arrange and Act
    ResponseEntity<Response> actualProcessRuntimeExceptionResult = globalExceptionRestController
        .processRuntimeException(new RuntimeException("foo"));

    // Assert
    Response body = actualProcessRuntimeExceptionResult.getBody();
    assertEquals("500", body.getStatusCode());
    assertEquals("foo", body.getStatusMsg());
    assertEquals(500, actualProcessRuntimeExceptionResult.getStatusCodeValue());
    assertTrue(actualProcessRuntimeExceptionResult.hasBody());
    assertTrue(actualProcessRuntimeExceptionResult.getHeaders().isEmpty());
  }
}

