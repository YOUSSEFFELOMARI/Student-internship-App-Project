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
@ContextConfiguration(classes = {Speciality.class})
@ExtendWith(SpringExtension.class)
class SpecialityTest {
  @Autowired
  private Speciality speciality;

  /**
   * Method under test: {@link Speciality#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Speciality()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Speciality#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Speciality speciality2 = new Speciality();

    Speciality speciality3 = new Speciality();
    speciality3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality3.setSpecialityId(1);
    speciality3.setSpecialityName("Speciality Name");
    speciality3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(speciality2.canEqual(speciality3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Speciality}
  *   <li>{@link Speciality#setSpecialityId(int)}
  *   <li>{@link Speciality#setSpecialityName(String)}
  *   <li>{@link Speciality#toString()}
  *   <li>{@link Speciality#getSpecialityId()}
  *   <li>{@link Speciality#getSpecialityName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Speciality actualSpeciality = new Speciality();
    actualSpeciality.setSpecialityId(1);
    actualSpeciality.setSpecialityName("Speciality Name");
    String actualToStringResult = actualSpeciality.toString();
    int actualSpecialityId = actualSpeciality.getSpecialityId();

    // Assert that nothing has changed
    assertEquals("Speciality Name", actualSpeciality.getSpecialityName());
    assertEquals("Speciality(specialityId=1, specialityName=Speciality Name)", actualToStringResult);
    assertEquals(1, actualSpecialityId);
  }

  /**
   * Method under test: {@link Speciality#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(speciality, null);
  }

  /**
   * Method under test: {@link Speciality#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(speciality, "Different type to Speciality");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Speciality#equals(Object)}
   *   <li>{@link Speciality#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(speciality, speciality);
    int expectedHashCodeResult = speciality.hashCode();
    assertEquals(expectedHashCodeResult, speciality.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Speciality#equals(Object)}
   *   <li>{@link Speciality#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName("Speciality Name");
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(speciality, speciality2);
    int expectedHashCodeResult = speciality.hashCode();
    assertEquals(expectedHashCodeResult, speciality2.hashCode());
  }

  /**
   * Method under test: {@link Speciality#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(2);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName("Speciality Name");
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(speciality, speciality2);
  }

  /**
   * Method under test: {@link Speciality#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName(null);
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName("Speciality Name");
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(speciality, speciality2);
  }

  /**
   * Method under test: {@link Speciality#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("ma.uiz.observatoire.model.Speciality");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName("Speciality Name");
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(speciality, speciality2);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Speciality#equals(Object)}
   *   <li>{@link Speciality#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName(null);
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName(null);
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(speciality, speciality2);
    int expectedHashCodeResult = speciality.hashCode();
    assertEquals(expectedHashCodeResult, speciality2.hashCode());
  }
}

