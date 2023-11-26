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
@ContextConfiguration(classes = {StudentLicence.class})
@ExtendWith(SpringExtension.class)
class StudentLicenceTest {
  @Autowired
  private StudentLicence studentLicence;

  /**
   * Method under test: {@link StudentLicence#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentLicence()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentLicence#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentLicence studentLicence2 = new StudentLicence();

    StudentLicence studentLicence3 = new StudentLicence();
    studentLicence3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence3.setLicenceId(1);
    studentLicence3.setLicenceName("Licence Name");
    studentLicence3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentLicence2.canEqual(studentLicence3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentLicence}
  *   <li>{@link StudentLicence#setLicenceId(int)}
  *   <li>{@link StudentLicence#setLicenceName(String)}
  *   <li>{@link StudentLicence#toString()}
  *   <li>{@link StudentLicence#getLicenceId()}
  *   <li>{@link StudentLicence#getLicenceName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentLicence actualStudentLicence = new StudentLicence();
    actualStudentLicence.setLicenceId(1);
    actualStudentLicence.setLicenceName("Licence Name");
    String actualToStringResult = actualStudentLicence.toString();
    int actualLicenceId = actualStudentLicence.getLicenceId();

    // Assert that nothing has changed
    assertEquals("Licence Name", actualStudentLicence.getLicenceName());
    assertEquals("StudentLicence(licenceId=1, licenceName=Licence Name)", actualToStringResult);
    assertEquals(1, actualLicenceId);
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, null);
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, "Different type to StudentLicence");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentLicence#equals(Object)}
   *   <li>{@link StudentLicence#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentLicence, studentLicence);
    int expectedHashCodeResult = studentLicence.hashCode();
    assertEquals(expectedHashCodeResult, studentLicence.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentLicence#equals(Object)}
   *   <li>{@link StudentLicence#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence2.setLicenceId(1);
    studentLicence2.setLicenceName("Licence Name");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentLicence, studentLicence2);
    int expectedHashCodeResult = studentLicence.hashCode();
    assertEquals(expectedHashCodeResult, studentLicence2.hashCode());
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.now().atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence2.setLicenceId(1);
    studentLicence2.setLicenceName("Licence Name");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, studentLicence2);
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(2);
    studentLicence.setLicenceName("Licence Name");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence2.setLicenceId(1);
    studentLicence2.setLicenceName("Licence Name");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, studentLicence2);
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence2.setLicenceId(1);
    studentLicence2.setLicenceName("Licence Name");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, studentLicence2);
  }

  /**
   * Method under test: {@link StudentLicence#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentLicence studentLicence = new StudentLicence();
    studentLicence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence.setLicenceId(1);
    studentLicence.setLicenceName(null);
    studentLicence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence.setUpdatedBy("2020-03-01");

    StudentLicence studentLicence2 = new StudentLicence();
    studentLicence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLicence2.setLicenceId(1);
    studentLicence2.setLicenceName("Licence Name");
    studentLicence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLicence2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLicence, studentLicence2);
  }
}

