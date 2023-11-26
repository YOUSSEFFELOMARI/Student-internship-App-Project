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
@ContextConfiguration(classes = {University.class})
@ExtendWith(SpringExtension.class)
class UniversityTest {
  @Autowired
  private University university;

  /**
   * Method under test: {@link University#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new University()).canEqual("Other"));
  }

  /**
   * Method under test: {@link University#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    University university2 = new University();

    University university3 = new University();
    university3.setAddress1("42 Main St");
    university3.setAddress2("42 Main St");
    university3.setCity("Oxford");
    university3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university3.setImageUrl("https://example.org/example");
    university3.setRegion("us-east-2");
    university3.setUniversityEmail("jane.doe@example.org");
    university3.setUniversityId(1);
    university3.setUniversityPhone("6625550144");
    university3.setUniversityTitle("Dr");
    university3.setUniversityWebsite("University Website");
    university3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university3.setUpdatedBy("2020-03-01");
    university3.setZipCode("21654");

    // Act and Assert
    assertTrue(university2.canEqual(university3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link University}
  *   <li>{@link University#setImageUrl(String)}
  *   <li>{@link University#setUniversityEmail(String)}
  *   <li>{@link University#setUniversityId(int)}
  *   <li>{@link University#setUniversityPhone(String)}
  *   <li>{@link University#setUniversityTitle(String)}
  *   <li>{@link University#setUniversityWebsite(String)}
  *   <li>{@link University#toString()}
  *   <li>{@link University#getImageUrl()}
  *   <li>{@link University#getUniversityEmail()}
  *   <li>{@link University#getUniversityId()}
  *   <li>{@link University#getUniversityPhone()}
  *   <li>{@link University#getUniversityTitle()}
  *   <li>{@link University#getUniversityWebsite()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    University actualUniversity = new University();
    actualUniversity.setImageUrl("https://example.org/example");
    actualUniversity.setUniversityEmail("jane.doe@example.org");
    actualUniversity.setUniversityId(1);
    actualUniversity.setUniversityPhone("6625550144");
    actualUniversity.setUniversityTitle("Dr");
    actualUniversity.setUniversityWebsite("University Website");
    String actualToStringResult = actualUniversity.toString();
    String actualImageUrl = actualUniversity.getImageUrl();
    String actualUniversityEmail = actualUniversity.getUniversityEmail();
    int actualUniversityId = actualUniversity.getUniversityId();
    String actualUniversityPhone = actualUniversity.getUniversityPhone();
    String actualUniversityTitle = actualUniversity.getUniversityTitle();

    // Assert that nothing has changed
    assertEquals("6625550144", actualUniversityPhone);
    assertEquals("Dr", actualUniversityTitle);
    assertEquals("University Website", actualUniversity.getUniversityWebsite());
    assertEquals(
        "University(universityId=1, universityTitle=Dr, universityPhone=6625550144, universityEmail=jane.doe"
            + "@example.org, universityWebsite=University Website, imageUrl=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualImageUrl);
    assertEquals("jane.doe@example.org", actualUniversityEmail);
    assertEquals(1, actualUniversityId);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, null);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, "Different type to University");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link University#equals(Object)}
   *   <li>{@link University#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    // Act and Assert
    assertEquals(university, university);
    int expectedHashCodeResult = university.hashCode();
    assertEquals(expectedHashCodeResult, university.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link University#equals(Object)}
   *   <li>{@link University#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertEquals(university, university2);
    int expectedHashCodeResult = university.hashCode();
    assertEquals(expectedHashCodeResult, university2.hashCode());
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    University university = new University();
    university.setAddress1("17 High St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("Jan 1, 2020 8:00am GMT+0100");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl(null);
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("john.smith@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail(null);
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(2);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("8605550118");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone(null);
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Mr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle(null);
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals15() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("Jan 1, 2020 8:00am GMT+0100");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }

  /**
   * Method under test: {@link University#equals(Object)}
   */
  @Test
  void testEquals16() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite(null);
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(university, university2);
  }
}

