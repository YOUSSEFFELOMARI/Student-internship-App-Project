package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {StudentExperience.class})
@ExtendWith(SpringExtension.class)
class StudentExperienceTest {
  @Autowired
  private StudentExperience studentExperience;

  /**
   * Method under test: {@link StudentExperience#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentExperience()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentExperience#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentExperience studentExperience2 = new StudentExperience();

    StudentExperience studentExperience3 = new StudentExperience();
    studentExperience3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience3
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience3.setExperienceDescription("Experience Description");
    studentExperience3.setExperienceId(1);
    studentExperience3
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentExperience2.canEqual(studentExperience3));
  }

  /**
   * Method under test: {@link StudentExperience#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertFalse(studentExperience2.canEqual("Other"));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentExperience}
  *   <li>{@link StudentExperience#setEndDate(Date)}
  *   <li>{@link StudentExperience#setExperienceDescription(String)}
  *   <li>{@link StudentExperience#setExperienceId(int)}
  *   <li>{@link StudentExperience#setStartDate(Date)}
  *   <li>{@link StudentExperience#toString()}
  *   <li>{@link StudentExperience#getEndDate()}
  *   <li>{@link StudentExperience#getExperienceDescription()}
  *   <li>{@link StudentExperience#getExperienceId()}
  *   <li>{@link StudentExperience#getStartDate()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentExperience actualStudentExperience = new StudentExperience();
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualStudentExperience.setEndDate(endDate);
    actualStudentExperience.setExperienceDescription("Experience Description");
    actualStudentExperience.setExperienceId(1);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualStudentExperience.setStartDate(startDate);
    actualStudentExperience.toString();
    Date actualEndDate = actualStudentExperience.getEndDate();
    String actualExperienceDescription = actualStudentExperience.getExperienceDescription();
    int actualExperienceId = actualStudentExperience.getExperienceId();

    // Assert that nothing has changed
    assertEquals("Experience Description", actualExperienceDescription);
    assertEquals(1, actualExperienceId);
    assertSame(endDate, actualEndDate);
    assertSame(startDate, actualStudentExperience.getStartDate());
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, null);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, "Different type to StudentExperience");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentExperience#equals(Object)}
   *   <li>{@link StudentExperience#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentExperience, studentExperience);
    int expectedHashCodeResult = studentExperience.hashCode();
    assertEquals(expectedHashCodeResult, studentExperience.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentExperience#equals(Object)}
   *   <li>{@link StudentExperience#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentExperience, studentExperience2);
    int expectedHashCodeResult = studentExperience.hashCode();
    assertEquals(expectedHashCodeResult, studentExperience2.hashCode());
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.now().atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(null);
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription(null);
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(2);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience.setStartDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }

  /**
   * Method under test: {@link StudentExperience#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience.setStartDate(null);
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience2
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    studentExperience2
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentExperience, studentExperience2);
  }
}

