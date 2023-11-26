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
@ContextConfiguration(classes = {DiplomaType.class})
@ExtendWith(SpringExtension.class)
class DiplomaTypeTest {
  @Autowired
  private DiplomaType diplomaType;

  /**
   * Method under test: {@link DiplomaType#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new DiplomaType()).canEqual("Other"));
  }

  /**
   * Method under test: {@link DiplomaType#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    DiplomaType diplomaType2 = new DiplomaType();

    DiplomaType diplomaType3 = new DiplomaType();
    diplomaType3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType3.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType3.setDiplomaLevel(3);
    diplomaType3.setDiplomaTypeId(1);
    diplomaType3.setDiplomaTypeName("Diploma Type Name");
    diplomaType3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(diplomaType2.canEqual(diplomaType3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link DiplomaType}
  *   <li>{@link DiplomaType#setDiplomaAbbreviation(String)}
  *   <li>{@link DiplomaType#setDiplomaLevel(int)}
  *   <li>{@link DiplomaType#setDiplomaTypeId(int)}
  *   <li>{@link DiplomaType#setDiplomaTypeName(String)}
  *   <li>{@link DiplomaType#toString()}
  *   <li>{@link DiplomaType#getDiplomaAbbreviation()}
  *   <li>{@link DiplomaType#getDiplomaLevel()}
  *   <li>{@link DiplomaType#getDiplomaTypeId()}
  *   <li>{@link DiplomaType#getDiplomaTypeName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    DiplomaType actualDiplomaType = new DiplomaType();
    actualDiplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    actualDiplomaType.setDiplomaLevel(1);
    actualDiplomaType.setDiplomaTypeId(1);
    actualDiplomaType.setDiplomaTypeName("Diploma Type Name");
    String actualToStringResult = actualDiplomaType.toString();
    String actualDiplomaAbbreviation = actualDiplomaType.getDiplomaAbbreviation();
    int actualDiplomaLevel = actualDiplomaType.getDiplomaLevel();
    int actualDiplomaTypeId = actualDiplomaType.getDiplomaTypeId();

    // Assert that nothing has changed
    assertEquals("Diploma Abbreviation", actualDiplomaAbbreviation);
    assertEquals("Diploma Type Name", actualDiplomaType.getDiplomaTypeName());
    assertEquals(
        "DiplomaType(diplomaTypeId=1, diplomaTypeName=Diploma Type Name, diplomaLevel=1, diplomaAbbreviation=Diploma"
            + " Abbreviation)",
        actualToStringResult);
    assertEquals(1, actualDiplomaLevel);
    assertEquals(1, actualDiplomaTypeId);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, null);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, "Different type to DiplomaType");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link DiplomaType#equals(Object)}
   *   <li>{@link DiplomaType#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(diplomaType, diplomaType);
    int expectedHashCodeResult = diplomaType.hashCode();
    assertEquals(expectedHashCodeResult, diplomaType.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link DiplomaType#equals(Object)}
   *   <li>{@link DiplomaType#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(diplomaType, diplomaType2);
    int expectedHashCodeResult = diplomaType.hashCode();
    assertEquals(expectedHashCodeResult, diplomaType2.hashCode());
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.now().atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation(null);
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(3);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(2);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }

  /**
   * Method under test: {@link DiplomaType#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName(null);
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(diplomaType, diplomaType2);
  }
}

