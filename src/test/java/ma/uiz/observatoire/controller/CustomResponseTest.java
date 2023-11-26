package ma.uiz.observatoire.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ma.uiz.observatoire.model.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CustomResponseTest {
  /**
  * Method under test: {@link CustomResponse#response(String, HttpStatus)}
  */
  @Test
  void testResponse() {
    // Arrange and Act
    ResponseEntity<Response> actualResponseResult = CustomResponse.response("Not all who wander are lost",
        HttpStatus.CONTINUE);

    // Assert
    Response body = actualResponseResult.getBody();
    assertEquals("100", body.getStatusCode());
    assertEquals("Not all who wander are lost", body.getStatusMsg());
    assertEquals(100, actualResponseResult.getStatusCodeValue());
    assertTrue(actualResponseResult.hasBody());
    assertTrue(actualResponseResult.getHeaders().isEmpty());
  }
}

