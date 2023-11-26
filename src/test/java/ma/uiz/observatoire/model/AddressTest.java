package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Address.class})
@ExtendWith(SpringExtension.class)
class AddressTest {
  @Autowired
  private Address address;

  /**
   * Method under test: {@link Address#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Address()).canEqual("Other"));
    assertTrue((new Address()).canEqual(mock(Company.class)));
  }

  /**
   * Method under test: {@link Address#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Address address2 = new Address();

    Address address3 = new Address();
    address3.setAddress1("42 Main St");
    address3.setAddress2("42 Main St");
    address3.setCity("Oxford");
    address3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address3.setRegion("us-east-2");
    address3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address3.setUpdatedBy("2020-03-01");
    address3.setZipCode("21654");

    // Act and Assert
    assertTrue(address2.canEqual(address3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Address}
  *   <li>{@link Address#setAddress1(String)}
  *   <li>{@link Address#setAddress2(String)}
  *   <li>{@link Address#setCity(String)}
  *   <li>{@link Address#setRegion(String)}
  *   <li>{@link Address#setZipCode(String)}
  *   <li>{@link Address#toString()}
  *   <li>{@link Address#getAddress1()}
  *   <li>{@link Address#getAddress2()}
  *   <li>{@link Address#getCity()}
  *   <li>{@link Address#getRegion()}
  *   <li>{@link Address#getZipCode()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Address actualAddress = new Address();
    actualAddress.setAddress1("42 Main St");
    actualAddress.setAddress2("42 Main St");
    actualAddress.setCity("Oxford");
    actualAddress.setRegion("us-east-2");
    actualAddress.setZipCode("21654");
    String actualToStringResult = actualAddress.toString();
    String actualAddress1 = actualAddress.getAddress1();
    String actualAddress2 = actualAddress.getAddress2();
    String actualCity = actualAddress.getCity();
    String actualRegion = actualAddress.getRegion();

    // Assert that nothing has changed
    assertEquals("21654", actualAddress.getZipCode());
    assertEquals("42 Main St", actualAddress1);
    assertEquals("42 Main St", actualAddress2);
    assertEquals("Address(address1=42 Main St, address2=42 Main St, city=Oxford, region=us-east-2, zipCode=21654)",
        actualToStringResult);
    assertEquals("Oxford", actualCity);
    assertEquals("us-east-2", actualRegion);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, null);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, "Different type to Address");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Address#equals(Object)}
   *   <li>{@link Address#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    // Act and Assert
    assertEquals(address, address);
    int expectedHashCodeResult = address.hashCode();
    assertEquals(expectedHashCodeResult, address.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Address#equals(Object)}
   *   <li>{@link Address#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertEquals(address, address2);
    int expectedHashCodeResult = address.hashCode();
    assertEquals(expectedHashCodeResult, address2.hashCode());
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyWebsite("Jan 1, 2020 8:00am GMT+0100");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    // Act and Assert
    assertNotEquals(company, address);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Address address = new Address();
    address.setAddress1("17 High St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Address address = new Address();
    address.setAddress1(null);
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("17 High St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2(null);
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("London");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity(null);
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.now().atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("Jan 1, 2020 8:00am GMT+0100");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals14() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion(null);
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals15() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("OX1 1PT");

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals16() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode(null);

    Address address2 = new Address();
    address2.setAddress1("42 Main St");
    address2.setAddress2("42 Main St");
    address2.setCity("Oxford");
    address2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address2.setRegion("us-east-2");
    address2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address2.setUpdatedBy("2020-03-01");
    address2.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, address2);
  }

  /**
   * Method under test: {@link Address#equals(Object)}
   */
  @Test
  void testEquals17() {
    // Arrange
    Address address = new Address();
    address.setAddress1("42 Main St");
    address.setAddress2("42 Main St");
    address.setCity("Oxford");
    address.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    address.setRegion("us-east-2");
    address.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    address.setUpdatedBy("2020-03-01");
    address.setZipCode("21654");

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Jan 1, 2020 8:00am GMT+0100");
    company.setCompanyWebsite("Jan 1, 2020 8:00am GMT+0100");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    // Act and Assert
    assertNotEquals(address, company);
  }
}

