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
@ContextConfiguration(classes = {StudentLanguage.class})
@ExtendWith(SpringExtension.class)
class StudentLanguageTest {
  @Autowired
  private StudentLanguage studentLanguage;

  /**
   * Method under test: {@link StudentLanguage#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentLanguage()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentLanguage#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentLanguage studentLanguage2 = new StudentLanguage();

    StudentLanguage studentLanguage3 = new StudentLanguage();
    studentLanguage3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage3.setLanguageId(1);
    studentLanguage3.setLanguageLevel(3);
    studentLanguage3.setLanguageName("en");
    studentLanguage3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentLanguage2.canEqual(studentLanguage3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentLanguage}
  *   <li>{@link StudentLanguage#setLanguageId(int)}
  *   <li>{@link StudentLanguage#setLanguageLevel(int)}
  *   <li>{@link StudentLanguage#setLanguageName(String)}
  *   <li>{@link StudentLanguage#toString()}
  *   <li>{@link StudentLanguage#getLanguageId()}
  *   <li>{@link StudentLanguage#getLanguageLevel()}
  *   <li>{@link StudentLanguage#getLanguageName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentLanguage actualStudentLanguage = new StudentLanguage();
    actualStudentLanguage.setLanguageId(1);
    actualStudentLanguage.setLanguageLevel(1);
    actualStudentLanguage.setLanguageName("en");
    String actualToStringResult = actualStudentLanguage.toString();
    int actualLanguageId = actualStudentLanguage.getLanguageId();
    int actualLanguageLevel = actualStudentLanguage.getLanguageLevel();

    // Assert that nothing has changed
    assertEquals("StudentLanguage(languageId=1, languageName=en, languageLevel=1)", actualToStringResult);
    assertEquals("en", actualStudentLanguage.getLanguageName());
    assertEquals(1, actualLanguageId);
    assertEquals(1, actualLanguageLevel);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, null);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, "Different type to StudentLanguage");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentLanguage#equals(Object)}
   *   <li>{@link StudentLanguage#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentLanguage, studentLanguage);
    int expectedHashCodeResult = studentLanguage.hashCode();
    assertEquals(expectedHashCodeResult, studentLanguage.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentLanguage#equals(Object)}
   *   <li>{@link StudentLanguage#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentLanguage, studentLanguage2);
    int expectedHashCodeResult = studentLanguage.hashCode();
    assertEquals(expectedHashCodeResult, studentLanguage2.hashCode());
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.now().atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, studentLanguage2);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(2);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, studentLanguage2);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(3);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, studentLanguage2);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("eng");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, studentLanguage2);
  }

  /**
   * Method under test: {@link StudentLanguage#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName(null);
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentLanguage, studentLanguage2);
  }
}

