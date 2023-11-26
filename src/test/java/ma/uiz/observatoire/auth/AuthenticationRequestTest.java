package ma.uiz.observatoire.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationRequest.class})
@ExtendWith(SpringExtension.class)
class AuthenticationRequestTest {
  @Autowired
  private AuthenticationRequest authenticationRequest;

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest.AuthenticationRequestBuilder#build()}
   *   <li>{@link AuthenticationRequest.AuthenticationRequestBuilder#email(String)}
   *   <li>{@link AuthenticationRequest.AuthenticationRequestBuilder#password(String)}
   * </ul>
   */
  @Test
  void testAuthenticationRequestBuilderBuild() {
    // Arrange and Act
    AuthenticationRequest actualBuildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password("iloveyou")
        .build();

    // Assert
    assertEquals("iloveyou", actualBuildResult.getPassword());
    assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
  }

  /**
   * Method under test: {@link AuthenticationRequest#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse(authenticationRequest.canEqual("Other"));
    assertTrue(authenticationRequest.canEqual(authenticationRequest));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link AuthenticationRequest#AuthenticationRequest()}
  *   <li>{@link AuthenticationRequest#setEmail(String)}
  *   <li>{@link AuthenticationRequest#setPassword(String)}
  *   <li>{@link AuthenticationRequest#toString()}
  *   <li>{@link AuthenticationRequest#getEmail()}
  *   <li>{@link AuthenticationRequest#getPassword()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest();
    actualAuthenticationRequest.setEmail("jane.doe@example.org");
    actualAuthenticationRequest.setPassword("iloveyou");
    String actualToStringResult = actualAuthenticationRequest.toString();
    String actualEmail = actualAuthenticationRequest.getEmail();

    // Assert that nothing has changed
    assertEquals("AuthenticationRequest(email=jane.doe@example.org, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualAuthenticationRequest.getPassword());
    assertEquals("jane.doe@example.org", actualEmail);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest#AuthenticationRequest(String, String)}
   *   <li>{@link AuthenticationRequest#setEmail(String)}
   *   <li>{@link AuthenticationRequest#setPassword(String)}
   *   <li>{@link AuthenticationRequest#toString()}
   *   <li>{@link AuthenticationRequest#getEmail()}
   *   <li>{@link AuthenticationRequest#getPassword()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange and Act
    AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest("jane.doe@example.org", "iloveyou");
    actualAuthenticationRequest.setEmail("jane.doe@example.org");
    actualAuthenticationRequest.setPassword("iloveyou");
    String actualToStringResult = actualAuthenticationRequest.toString();
    String actualEmail = actualAuthenticationRequest.getEmail();

    // Assert that nothing has changed
    assertEquals("AuthenticationRequest(email=jane.doe@example.org, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualAuthenticationRequest.getPassword());
    assertEquals("jane.doe@example.org", actualEmail);
  }

  /**
   * Method under test: {@link AuthenticationRequest#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange, Act and Assert
    assertNotEquals(AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build(), null);
    assertNotEquals(AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build(),
        "Different type to AuthenticationRequest");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest#equals(Object)}
   *   <li>{@link AuthenticationRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password("iloveyou")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest#equals(Object)}
   *   <li>{@link AuthenticationRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password("iloveyou")
        .build();
    AuthenticationRequest buildResult2 = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password("iloveyou")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Method under test: {@link AuthenticationRequest#equals(Object)}
   */
  @Test
  void testEquals4() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("john.smith@example.org")
        .password("iloveyou")
        .build();

    // Act and Assert
    assertNotEquals(buildResult,
        AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build());
  }

  /**
   * Method under test: {@link AuthenticationRequest#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder().email(null).password("iloveyou").build();

    // Act and Assert
    assertNotEquals(buildResult,
        AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build());
  }

  /**
   * Method under test: {@link AuthenticationRequest#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password("jane.doe@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult,
        AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build());
  }

  /**
   * Method under test: {@link AuthenticationRequest#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult,
        AuthenticationRequest.builder().email("jane.doe@example.org").password("iloveyou").build());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest#equals(Object)}
   *   <li>{@link AuthenticationRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder().email(null).password("iloveyou").build();
    AuthenticationRequest buildResult2 = AuthenticationRequest.builder().email(null).password("iloveyou").build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationRequest#equals(Object)}
   *   <li>{@link AuthenticationRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals9() {
    // Arrange
    AuthenticationRequest buildResult = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password(null)
        .build();
    AuthenticationRequest buildResult2 = AuthenticationRequest.builder()
        .email("jane.doe@example.org")
        .password(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }
}

