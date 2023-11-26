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
@ContextConfiguration(classes = {StudentHobby.class})
@ExtendWith(SpringExtension.class)
class StudentHobbyTest {
  @Autowired
  private StudentHobby studentHobby;

  /**
   * Method under test: {@link StudentHobby#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentHobby()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentHobby#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentHobby studentHobby2 = new StudentHobby();

    StudentHobby studentHobby3 = new StudentHobby();
    studentHobby3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby3.setHobbiesName("Hobbies Name");
    studentHobby3.setHobbyId(1);
    studentHobby3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentHobby2.canEqual(studentHobby3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentHobby}
  *   <li>{@link StudentHobby#setHobbiesName(String)}
  *   <li>{@link StudentHobby#setHobbyId(int)}
  *   <li>{@link StudentHobby#toString()}
  *   <li>{@link StudentHobby#getHobbiesName()}
  *   <li>{@link StudentHobby#getHobbyId()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentHobby actualStudentHobby = new StudentHobby();
    actualStudentHobby.setHobbiesName("Hobbies Name");
    actualStudentHobby.setHobbyId(1);
    String actualToStringResult = actualStudentHobby.toString();
    String actualHobbiesName = actualStudentHobby.getHobbiesName();

    // Assert that nothing has changed
    assertEquals("Hobbies Name", actualHobbiesName);
    assertEquals("StudentHobby(hobbyId=1, hobbiesName=Hobbies Name)", actualToStringResult);
    assertEquals(1, actualStudentHobby.getHobbyId());
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, null);
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, "Different type to StudentHobby");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentHobby#equals(Object)}
   *   <li>{@link StudentHobby#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentHobby, studentHobby);
    int expectedHashCodeResult = studentHobby.hashCode();
    assertEquals(expectedHashCodeResult, studentHobby.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentHobby#equals(Object)}
   *   <li>{@link StudentHobby#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentHobby, studentHobby2);
    int expectedHashCodeResult = studentHobby.hashCode();
    assertEquals(expectedHashCodeResult, studentHobby2.hashCode());
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.now().atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, studentHobby2);
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, studentHobby2);
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName(null);
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, studentHobby2);
  }

  /**
   * Method under test: {@link StudentHobby#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(2);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentHobby, studentHobby2);
  }
}

