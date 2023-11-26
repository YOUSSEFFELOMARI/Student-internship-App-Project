package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Response.class})
@ExtendWith(SpringExtension.class)
class ResponseTest {
  @Autowired
  private Response response;

  /**
   * Method under test: {@link Response#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse(response.canEqual("Other"));
    assertTrue(response.canEqual(response));
  }

  /**
   * Method under test: {@link Response#Response()}
   */
  @Test
  void testConstructor() {
    // Arrange and Act
    Response actualResponse = new Response();

    // Assert
    assertNull(actualResponse.getStatusCode());
    assertNull(actualResponse.getStatusMsg());
  }

  /**
   * Method under test: {@link Response#Response(String, String)}
   */
  @Test
  void testConstructor2() {
    // Arrange and Act
    Response actualResponse = new Response("Status Code", "Status Msg");

    // Assert
    assertEquals("Status Code", actualResponse.getStatusCode());
    assertEquals("Status Msg", actualResponse.getStatusMsg());
  }

  /**
   * Method under test: {@link Response#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange, Act and Assert
    assertNotEquals(new Response(), null);
    assertNotEquals(new Response(), "Different type to Response");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Response#equals(Object)}
   *   <li>{@link Response#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    // Arrange
    Response response = new Response();

    // Act and Assert
    assertEquals(response, response);
    int expectedHashCodeResult = response.hashCode();
    assertEquals(expectedHashCodeResult, response.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Response#equals(Object)}
   *   <li>{@link Response#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    Response response = new Response();
    Response response2 = new Response();

    // Act and Assert
    assertEquals(response, response2);
    int expectedHashCodeResult = response.hashCode();
    assertEquals(expectedHashCodeResult, response2.hashCode());
  }

  /**
   * Method under test: {@link Response#equals(Object)}
   */
  @Test
  void testEquals4() {
    // Arrange
    Response response = new Response("19/11/2023 17:44:53", "19/11/2023 17:44:53");

    // Act and Assert
    assertNotEquals(response, new Response());
  }

  /**
   * Method under test: {@link Response#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Response response = new Response();

    // Act and Assert
    assertNotEquals(response, new Response("19/11/2023 17:44:53", "19/11/2023 17:44:53"));
  }

  /**
   * Method under test: {@link Response#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Response response = new Response();
    response.setStatusMsg("19/11/2023 17:44:53");

    // Act and Assert
    assertNotEquals(response, new Response());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Response#equals(Object)}
   *   <li>{@link Response#hashCode()}
   * </ul>
   */
  @Test
  void testEquals7() {
    // Arrange
    Response response = new Response("19/11/2023 17:44:53", "19/11/2023 17:44:53");
    Response response2 = new Response("19/11/2023 17:44:53", "19/11/2023 17:44:53");

    // Act and Assert
    assertEquals(response, response2);
    int expectedHashCodeResult = response.hashCode();
    assertEquals(expectedHashCodeResult, response2.hashCode());
  }

  /**
   * Method under test: {@link Response#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Response response = new Response();

    Response response2 = new Response();
    response2.setStatusMsg("19/11/2023 17:44:53");

    // Act and Assert
    assertNotEquals(response, response2);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Response#setStatusCode(String)}
  *   <li>{@link Response#setStatusMsg(String)}
  *   <li>{@link Response#toString()}
  *   <li>{@link Response#getStatusCode()}
  *   <li>{@link Response#getStatusMsg()}
  *   <li>{@link Response#getTimestamp()}
  * </ul>
  */
  @Test
  void testSetStatusCode() {
    // Arrange
    Response response = new Response();

    // Act
    response.setStatusCode("Status Code");
    response.setStatusMsg("Status Msg");
    response.toString();
    String actualStatusCode = response.getStatusCode();
    String actualStatusMsg = response.getStatusMsg();
    response.getTimestamp();

    // Assert that nothing has changed
    assertEquals("Status Code", actualStatusCode);
    assertEquals("Status Msg", actualStatusMsg);
  }
}

