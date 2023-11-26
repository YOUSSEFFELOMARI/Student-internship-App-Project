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
@ContextConfiguration(classes = {OfferType.class})
@ExtendWith(SpringExtension.class)
class OfferTypeTest {
  @Autowired
  private OfferType offerType;

  /**
   * Method under test: {@link OfferType#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new OfferType()).canEqual("Other"));
  }

  /**
   * Method under test: {@link OfferType#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    OfferType offerType2 = new OfferType();

    OfferType offerType3 = new OfferType();
    offerType3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType3.setOfferTypeId(1);
    offerType3.setOfferTypeName("Offer Type Name");
    offerType3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(offerType2.canEqual(offerType3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link OfferType}
  *   <li>{@link OfferType#setOfferTypeId(int)}
  *   <li>{@link OfferType#setOfferTypeName(String)}
  *   <li>{@link OfferType#toString()}
  *   <li>{@link OfferType#getOfferTypeId()}
  *   <li>{@link OfferType#getOfferTypeName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    OfferType actualOfferType = new OfferType();
    actualOfferType.setOfferTypeId(1);
    actualOfferType.setOfferTypeName("Offer Type Name");
    String actualToStringResult = actualOfferType.toString();
    int actualOfferTypeId = actualOfferType.getOfferTypeId();

    // Assert that nothing has changed
    assertEquals("Offer Type Name", actualOfferType.getOfferTypeName());
    assertEquals("OfferType(offerTypeId=1, offerTypeName=Offer Type Name)", actualToStringResult);
    assertEquals(1, actualOfferTypeId);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offerType, null);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offerType, "Different type to OfferType");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(offerType, offerType);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName("Offer Type Name");
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(offerType, offerType2);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType2.hashCode());
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(2);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName("Offer Type Name");
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offerType, offerType2);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName(null);
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName("Offer Type Name");
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offerType, offerType2);
  }

  /**
   * Method under test: {@link OfferType#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("ma.uiz.observatoire.model.OfferType");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName("Offer Type Name");
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(offerType, offerType2);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link OfferType#equals(Object)}
   *   <li>{@link OfferType#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName(null);
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName(null);
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(offerType, offerType2);
    int expectedHashCodeResult = offerType.hashCode();
    assertEquals(expectedHashCodeResult, offerType2.hashCode());
  }
}

