package ma.uiz.observatoire.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegisterRequest.class})
@ExtendWith(SpringExtension.class)
class RegisterRequestTest {
  @Autowired
  private RegisterRequest registerRequest;

  /**
   * Method under test: {@link RegisterRequest#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse(registerRequest.canEqual("Other"));
    assertTrue(registerRequest.canEqual(registerRequest));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link RegisterRequest#RegisterRequest()}
  *   <li>{@link RegisterRequest#setCompanySiret(String)}
  *   <li>{@link RegisterRequest#setEmail(String)}
  *   <li>{@link RegisterRequest#setPassword(String)}
  *   <li>{@link RegisterRequest#setRoles(List)}
  *   <li>{@link RegisterRequest#setStudentCin(String)}
  *   <li>{@link RegisterRequest#setUsername(String)}
  *   <li>{@link RegisterRequest#toString()}
  *   <li>{@link RegisterRequest#getCompanySiret()}
  *   <li>{@link RegisterRequest#getEmail()}
  *   <li>{@link RegisterRequest#getPassword()}
  *   <li>{@link RegisterRequest#getRoles()}
  *   <li>{@link RegisterRequest#getStudentCin()}
  *   <li>{@link RegisterRequest#getUsername()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    RegisterRequest actualRegisterRequest = new RegisterRequest();
    actualRegisterRequest.setCompanySiret("Company Siret");
    actualRegisterRequest.setEmail("jane.doe@example.org");
    actualRegisterRequest.setPassword("iloveyou");
    ArrayList<String> roles = new ArrayList<>();
    actualRegisterRequest.setRoles(roles);
    actualRegisterRequest.setStudentCin("Student Cin");
    actualRegisterRequest.setUsername("janedoe");
    String actualToStringResult = actualRegisterRequest.toString();
    String actualCompanySiret = actualRegisterRequest.getCompanySiret();
    String actualEmail = actualRegisterRequest.getEmail();
    String actualPassword = actualRegisterRequest.getPassword();
    List<String> actualRoles = actualRegisterRequest.getRoles();
    String actualStudentCin = actualRegisterRequest.getStudentCin();

    // Assert that nothing has changed
    assertEquals("Company Siret", actualCompanySiret);
    assertEquals(
        "RegisterRequest(username=janedoe, email=jane.doe@example.org, password=iloveyou, roles=[], companySiret"
            + "=Company Siret, studentCin=Student Cin)",
        actualToStringResult);
    assertEquals("Student Cin", actualStudentCin);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualRegisterRequest.getUsername());
    assertSame(roles, actualRoles);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest#RegisterRequest(String, String, String, List, String, String)}
   *   <li>{@link RegisterRequest#setCompanySiret(String)}
   *   <li>{@link RegisterRequest#setEmail(String)}
   *   <li>{@link RegisterRequest#setPassword(String)}
   *   <li>{@link RegisterRequest#setRoles(List)}
   *   <li>{@link RegisterRequest#setStudentCin(String)}
   *   <li>{@link RegisterRequest#setUsername(String)}
   *   <li>{@link RegisterRequest#toString()}
   *   <li>{@link RegisterRequest#getCompanySiret()}
   *   <li>{@link RegisterRequest#getEmail()}
   *   <li>{@link RegisterRequest#getPassword()}
   *   <li>{@link RegisterRequest#getRoles()}
   *   <li>{@link RegisterRequest#getStudentCin()}
   *   <li>{@link RegisterRequest#getUsername()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange
    ArrayList<String> roles = new ArrayList<>();

    // Act
    RegisterRequest actualRegisterRequest = new RegisterRequest("janedoe", "jane.doe@example.org", "iloveyou", roles,
        "Company Siret", "Student Cin");
    actualRegisterRequest.setCompanySiret("Company Siret");
    actualRegisterRequest.setEmail("jane.doe@example.org");
    actualRegisterRequest.setPassword("iloveyou");
    ArrayList<String> roles2 = new ArrayList<>();
    actualRegisterRequest.setRoles(roles2);
    actualRegisterRequest.setStudentCin("Student Cin");
    actualRegisterRequest.setUsername("janedoe");
    String actualToStringResult = actualRegisterRequest.toString();
    String actualCompanySiret = actualRegisterRequest.getCompanySiret();
    String actualEmail = actualRegisterRequest.getEmail();
    String actualPassword = actualRegisterRequest.getPassword();
    List<String> actualRoles = actualRegisterRequest.getRoles();
    String actualStudentCin = actualRegisterRequest.getStudentCin();

    // Assert that nothing has changed
    assertEquals("Company Siret", actualCompanySiret);
    assertEquals(
        "RegisterRequest(username=janedoe, email=jane.doe@example.org, password=iloveyou, roles=[], companySiret"
            + "=Company Siret, studentCin=Student Cin)",
        actualToStringResult);
    assertEquals("Student Cin", actualStudentCin);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualRegisterRequest.getUsername());
    assertEquals(roles, actualRoles);
    assertSame(roles2, actualRoles);
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(passwordResult.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build(),
        null);
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(passwordResult.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build(),
        "Different type to RegisterRequest");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest#equals(Object)}
   *   <li>{@link RegisterRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
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
   *   <li>{@link RegisterRequest#equals(Object)}
   *   <li>{@link RegisterRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult2 = passwordResult2.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("janedoe")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret(null)
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("john.smith@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email(null)
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("janedoe");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password(null);
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    ArrayList<String> roles = new ArrayList<>();
    roles.add("janedoe");
    RegisterRequest buildResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou")
        .roles(roles)
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("janedoe")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>()).studentCin(null).username("janedoe").build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("jane.doe@example.org")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Method under test: {@link RegisterRequest#equals(Object)}
   */
  @Test
  void testEquals15() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username(null)
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");

    // Act and Assert
    assertNotEquals(buildResult,
        passwordResult2.roles(new ArrayList<>()).studentCin("Student Cin").username("janedoe").build());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest#equals(Object)}
   *   <li>{@link RegisterRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals16() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret(null)
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret(null)
        .email("jane.doe@example.org")
        .password("iloveyou");
    RegisterRequest buildResult2 = passwordResult2.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest#equals(Object)}
   *   <li>{@link RegisterRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals17() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email(null)
        .password("iloveyou");
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email(null)
        .password("iloveyou");
    RegisterRequest buildResult2 = passwordResult2.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest#equals(Object)}
   *   <li>{@link RegisterRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals18() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password(null);
    RegisterRequest buildResult = passwordResult.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();
    RegisterRequest.RegisterRequestBuilder passwordResult2 = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password(null);
    RegisterRequest buildResult2 = passwordResult2.roles(new ArrayList<>())
        .studentCin("Student Cin")
        .username("janedoe")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#build()}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#companySiret(String)}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#email(String)}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#password(String)}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#roles(List)}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#studentCin(String)}
   *   <li>{@link RegisterRequest.RegisterRequestBuilder#username(String)}
   * </ul>
   */
  @Test
  void testRegisterRequestBuilderBuild() {
    // Arrange
    RegisterRequest.RegisterRequestBuilder passwordResult = RegisterRequest.builder()
        .companySiret("Company Siret")
        .email("jane.doe@example.org")
        .password("iloveyou");
    ArrayList<String> roles = new ArrayList<>();

    // Act
    RegisterRequest actualBuildResult = passwordResult.roles(roles)
        .studentCin("Student Cin")
        .username("janedoe")
        .build();

    // Assert
    assertEquals("Company Siret", actualBuildResult.getCompanySiret());
    assertEquals("Student Cin", actualBuildResult.getStudentCin());
    assertEquals("iloveyou", actualBuildResult.getPassword());
    assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
    assertEquals("janedoe", actualBuildResult.getUsername());
    List<String> roles2 = actualBuildResult.getRoles();
    assertTrue(roles2.isEmpty());
    assertSame(roles, roles2);
  }
}

