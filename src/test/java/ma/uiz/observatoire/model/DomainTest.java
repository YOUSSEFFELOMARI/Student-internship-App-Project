package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Domain.class})
@ExtendWith(SpringExtension.class)
class DomainTest {
  @Autowired
  private Domain domain;

  /**
   * Method under test: {@link Domain#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Domain()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Domain#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Domain domain2 = new Domain();

    Domain domain3 = new Domain();
    domain3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain3.setDomainId(1);
    domain3.setDomainName("Domain Name");
    domain3.setSpecialities(new HashSet<>());
    domain3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(domain2.canEqual(domain3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Domain}
  *   <li>{@link Domain#setDomainId(int)}
  *   <li>{@link Domain#setDomainName(String)}
  *   <li>{@link Domain#setSpecialities(Set)}
  *   <li>{@link Domain#toString()}
  *   <li>{@link Domain#getDomainId()}
  *   <li>{@link Domain#getDomainName()}
  *   <li>{@link Domain#getSpecialities()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Domain actualDomain = new Domain();
    actualDomain.setDomainId(1);
    actualDomain.setDomainName("Domain Name");
    HashSet<Speciality> specialities = new HashSet<>();
    actualDomain.setSpecialities(specialities);
    String actualToStringResult = actualDomain.toString();
    int actualDomainId = actualDomain.getDomainId();
    String actualDomainName = actualDomain.getDomainName();

    // Assert that nothing has changed
    assertEquals("Domain Name", actualDomainName);
    assertEquals("Domain(domainId=1, domainName=Domain Name, specialities=[])", actualToStringResult);
    assertEquals(1, actualDomainId);
    assertSame(specialities, actualDomain.getSpecialities());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, null);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, "Different type to Domain");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(domain, domain);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.now().atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(2);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Jan 1, 2020 8:00am GMT+0100");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName(null);
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }

  /**
   * Method under test: {@link Domain#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Jan 1, 2020 8:00am GMT+0100");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");

    HashSet<Speciality> specialities = new HashSet<>();
    specialities.add(speciality);

    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(specialities);
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(domain, domain2);
  }
}

