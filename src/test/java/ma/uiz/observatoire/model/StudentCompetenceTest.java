package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {StudentCompetence.class})
@ExtendWith(SpringExtension.class)
class StudentCompetenceTest {
  @Autowired
  private StudentCompetence studentCompetence;

  /**
   * Method under test: {@link StudentCompetence#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentCompetence()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentCompetence#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentCompetence studentCompetence2 = new StudentCompetence();

    StudentCompetence studentCompetence3 = new StudentCompetence();
    studentCompetence3.setCompetenceId(1);
    studentCompetence3.setCompetenceName("Bella");
    studentCompetence3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentCompetence2.canEqual(studentCompetence3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentCompetence}
  *   <li>{@link StudentCompetence#setCompetenceId(int)}
  *   <li>{@link StudentCompetence#setCompetenceName(String)}
  *   <li>{@link StudentCompetence#toString()}
  *   <li>{@link StudentCompetence#getCompetenceId()}
  *   <li>{@link StudentCompetence#getCompetenceName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentCompetence actualStudentCompetence = new StudentCompetence();
    actualStudentCompetence.setCompetenceId(1);
    actualStudentCompetence.setCompetenceName("Bella");
    String actualToStringResult = actualStudentCompetence.toString();
    int actualCompetenceId = actualStudentCompetence.getCompetenceId();

    // Assert that nothing has changed
    assertEquals("Bella", actualStudentCompetence.getCompetenceName());
    assertEquals("StudentCompetence(competenceId=1, competenceName=Bella)", actualToStringResult);
    assertEquals(1, actualCompetenceId);
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, null);
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, "Different type to StudentCompetence");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentCompetence#equals(Object)}
   *   <li>{@link StudentCompetence#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentCompetence, studentCompetence);
    int expectedHashCodeResult = studentCompetence.hashCode();
    assertEquals(expectedHashCodeResult, studentCompetence.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentCompetence#equals(Object)}
   *   <li>{@link StudentCompetence#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentCompetence, studentCompetence2);
    int expectedHashCodeResult = studentCompetence.hashCode();
    assertEquals(expectedHashCodeResult, studentCompetence2.hashCode());
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(2);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, studentCompetence2);
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, studentCompetence2);
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName(null);
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, studentCompetence2);
  }

  /**
   * Method under test: {@link StudentCompetence#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.now().atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCompetence, studentCompetence2);
  }
}

