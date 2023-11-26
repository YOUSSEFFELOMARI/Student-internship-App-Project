package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Establishment.class})
@ExtendWith(SpringExtension.class)
class EstablishmentTest {
  @Autowired
  private Establishment establishment;

  /**
   * Method under test: {@link Establishment#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Establishment()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Establishment#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Establishment establishment2 = new Establishment();

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

    Establishment establishment3 = new Establishment();
    establishment3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment3.setEstablishmentEmail("jane.doe@example.org");
    establishment3.setEstablishmentId(1);
    establishment3.setEstablishmentPhone("6625550144");
    establishment3.setEstablishmentTitle("Dr");
    establishment3.setEstablishmentWebSite("Establishment Web Site");
    establishment3.setImageUrl("https://example.org/example");
    establishment3.setUniversity(university);
    establishment3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(establishment2.canEqual(establishment3));
  }

  /**
   * Method under test: {@link Establishment#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    Establishment establishment2 = new Establishment();
    University university = mock(University.class);
    doNothing().when(university).setAddress1(Mockito.<String>any());
    doNothing().when(university).setAddress2(Mockito.<String>any());
    doNothing().when(university).setCity(Mockito.<String>any());
    doNothing().when(university).setRegion(Mockito.<String>any());
    doNothing().when(university).setZipCode(Mockito.<String>any());
    doNothing().when(university).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setCreatedBy(Mockito.<String>any());
    doNothing().when(university).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setUpdatedBy(Mockito.<String>any());
    doNothing().when(university).setImageUrl(Mockito.<String>any());
    doNothing().when(university).setUniversityEmail(Mockito.<String>any());
    doNothing().when(university).setUniversityId(anyInt());
    doNothing().when(university).setUniversityPhone(Mockito.<String>any());
    doNothing().when(university).setUniversityTitle(Mockito.<String>any());
    doNothing().when(university).setUniversityWebsite(Mockito.<String>any());
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

    Establishment establishment3 = new Establishment();
    establishment3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment3.setEstablishmentEmail("jane.doe@example.org");
    establishment3.setEstablishmentId(1);
    establishment3.setEstablishmentPhone("6625550144");
    establishment3.setEstablishmentTitle("Dr");
    establishment3.setEstablishmentWebSite("Establishment Web Site");
    establishment3.setImageUrl("https://example.org/example");
    establishment3.setUniversity(university);
    establishment3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment3.setUpdatedBy("2020-03-01");

    // Act
    boolean actualCanEqualResult = establishment2.canEqual(establishment3);

    // Assert
    verify(university).setAddress1(Mockito.<String>any());
    verify(university).setAddress2(Mockito.<String>any());
    verify(university).setCity(Mockito.<String>any());
    verify(university).setRegion(Mockito.<String>any());
    verify(university).setZipCode(Mockito.<String>any());
    verify(university).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(university).setCreatedBy(Mockito.<String>any());
    verify(university).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(university).setUpdatedBy(Mockito.<String>any());
    verify(university).setImageUrl(Mockito.<String>any());
    verify(university).setUniversityEmail(Mockito.<String>any());
    verify(university).setUniversityId(anyInt());
    verify(university).setUniversityPhone(Mockito.<String>any());
    verify(university).setUniversityTitle(Mockito.<String>any());
    verify(university).setUniversityWebsite(Mockito.<String>any());
    assertTrue(actualCanEqualResult);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Establishment}
  *   <li>{@link Establishment#setEstablishmentEmail(String)}
  *   <li>{@link Establishment#setEstablishmentId(int)}
  *   <li>{@link Establishment#setEstablishmentPhone(String)}
  *   <li>{@link Establishment#setEstablishmentTitle(String)}
  *   <li>{@link Establishment#setEstablishmentWebSite(String)}
  *   <li>{@link Establishment#setImageUrl(String)}
  *   <li>{@link Establishment#setUniversity(University)}
  *   <li>{@link Establishment#toString()}
  *   <li>{@link Establishment#getEstablishmentEmail()}
  *   <li>{@link Establishment#getEstablishmentId()}
  *   <li>{@link Establishment#getEstablishmentPhone()}
  *   <li>{@link Establishment#getEstablishmentTitle()}
  *   <li>{@link Establishment#getEstablishmentWebSite()}
  *   <li>{@link Establishment#getImageUrl()}
  *   <li>{@link Establishment#getUniversity()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Establishment actualEstablishment = new Establishment();
    actualEstablishment.setEstablishmentEmail("jane.doe@example.org");
    actualEstablishment.setEstablishmentId(1);
    actualEstablishment.setEstablishmentPhone("6625550144");
    actualEstablishment.setEstablishmentTitle("Dr");
    actualEstablishment.setEstablishmentWebSite("Establishment Web Site");
    actualEstablishment.setImageUrl("https://example.org/example");
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
    actualEstablishment.setUniversity(university);
    String actualToStringResult = actualEstablishment.toString();
    String actualEstablishmentEmail = actualEstablishment.getEstablishmentEmail();
    int actualEstablishmentId = actualEstablishment.getEstablishmentId();
    String actualEstablishmentPhone = actualEstablishment.getEstablishmentPhone();
    String actualEstablishmentTitle = actualEstablishment.getEstablishmentTitle();
    String actualEstablishmentWebSite = actualEstablishment.getEstablishmentWebSite();
    String actualImageUrl = actualEstablishment.getImageUrl();

    // Assert that nothing has changed
    assertEquals("6625550144", actualEstablishmentPhone);
    assertEquals("Dr", actualEstablishmentTitle);
    assertEquals("Establishment Web Site", actualEstablishmentWebSite);
    assertEquals(
        "Establishment(establishmentId=1, establishmentTitle=Dr, establishmentPhone=6625550144, establishmentEmail"
            + "=jane.doe@example.org, establishmentWebSite=Establishment Web Site, university=University(universityId=1,"
            + " universityTitle=Dr, universityPhone=6625550144, universityEmail=jane.doe@example.org, universityWebsite"
            + "=University Website, imageUrl=https://example.org/example), imageUrl=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualImageUrl);
    assertEquals("jane.doe@example.org", actualEstablishmentEmail);
    assertEquals(1, actualEstablishmentId);
    assertSame(university, actualEstablishment.getUniversity());
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, null);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, "Different type to Establishment");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Establishment#equals(Object)}
   *   <li>{@link Establishment#hashCode()}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(establishment, establishment);
    int expectedHashCodeResult = establishment.hashCode();
    assertEquals(expectedHashCodeResult, establishment.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Establishment#equals(Object)}
   *   <li>{@link Establishment#hashCode()}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(establishment, establishment2);
    int expectedHashCodeResult = establishment.hashCode();
    assertEquals(expectedHashCodeResult, establishment2.hashCode());
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
   */
  @Test
  void testEquals5() {
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.now().atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("john.smith@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail(null);
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(2);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("8605550118");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone(null);
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Mr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle(null);
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Jan 1, 2020 8:00am GMT+0100");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite(null);
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("Jan 1, 2020 8:00am GMT+0100");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
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
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl(null);
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }

  /**
   * Method under test: {@link Establishment#equals(Object)}
   */
  @Test
  void testEquals17() {
    // Arrange
    University university = mock(University.class);
    doNothing().when(university).setAddress1(Mockito.<String>any());
    doNothing().when(university).setAddress2(Mockito.<String>any());
    doNothing().when(university).setCity(Mockito.<String>any());
    doNothing().when(university).setRegion(Mockito.<String>any());
    doNothing().when(university).setZipCode(Mockito.<String>any());
    doNothing().when(university).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setCreatedBy(Mockito.<String>any());
    doNothing().when(university).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(university).setUpdatedBy(Mockito.<String>any());
    doNothing().when(university).setImageUrl(Mockito.<String>any());
    doNothing().when(university).setUniversityEmail(Mockito.<String>any());
    doNothing().when(university).setUniversityId(anyInt());
    doNothing().when(university).setUniversityPhone(Mockito.<String>any());
    doNothing().when(university).setUniversityTitle(Mockito.<String>any());
    doNothing().when(university).setUniversityWebsite(Mockito.<String>any());
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(establishment, establishment2);
  }
}

