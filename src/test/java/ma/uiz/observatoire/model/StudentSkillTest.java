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
@ContextConfiguration(classes = {StudentSkill.class})
@ExtendWith(SpringExtension.class)
class StudentSkillTest {
  @Autowired
  private StudentSkill studentSkill;

  /**
   * Method under test: {@link StudentSkill#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentSkill()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentSkill#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentSkill studentSkill2 = new StudentSkill();

    StudentSkill studentSkill3 = new StudentSkill();
    studentSkill3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill3.setSkillId(1);
    studentSkill3.setSkillName("Skill Name");
    studentSkill3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentSkill2.canEqual(studentSkill3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentSkill}
  *   <li>{@link StudentSkill#setSkillId(int)}
  *   <li>{@link StudentSkill#setSkillName(String)}
  *   <li>{@link StudentSkill#toString()}
  *   <li>{@link StudentSkill#getSkillId()}
  *   <li>{@link StudentSkill#getSkillName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentSkill actualStudentSkill = new StudentSkill();
    actualStudentSkill.setSkillId(1);
    actualStudentSkill.setSkillName("Skill Name");
    String actualToStringResult = actualStudentSkill.toString();
    int actualSkillId = actualStudentSkill.getSkillId();

    // Assert that nothing has changed
    assertEquals("Skill Name", actualStudentSkill.getSkillName());
    assertEquals("StudentSkill(skillId=1, skillName=Skill Name)", actualToStringResult);
    assertEquals(1, actualSkillId);
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, null);
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, "Different type to StudentSkill");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentSkill#equals(Object)}
   *   <li>{@link StudentSkill#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentSkill, studentSkill);
    int expectedHashCodeResult = studentSkill.hashCode();
    assertEquals(expectedHashCodeResult, studentSkill.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentSkill#equals(Object)}
   *   <li>{@link StudentSkill#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill2.setSkillId(1);
    studentSkill2.setSkillName("Skill Name");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentSkill, studentSkill2);
    int expectedHashCodeResult = studentSkill.hashCode();
    assertEquals(expectedHashCodeResult, studentSkill2.hashCode());
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.now().atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill2.setSkillId(1);
    studentSkill2.setSkillName("Skill Name");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, studentSkill2);
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(2);
    studentSkill.setSkillName("Skill Name");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill2.setSkillId(1);
    studentSkill2.setSkillName("Skill Name");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, studentSkill2);
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill2.setSkillId(1);
    studentSkill2.setSkillName("Skill Name");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, studentSkill2);
  }

  /**
   * Method under test: {@link StudentSkill#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentSkill studentSkill = new StudentSkill();
    studentSkill.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill.setSkillId(1);
    studentSkill.setSkillName(null);
    studentSkill.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill.setUpdatedBy("2020-03-01");

    StudentSkill studentSkill2 = new StudentSkill();
    studentSkill2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentSkill2.setSkillId(1);
    studentSkill2.setSkillName("Skill Name");
    studentSkill2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentSkill2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentSkill, studentSkill2);
  }
}

