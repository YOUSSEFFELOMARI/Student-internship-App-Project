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
@ContextConfiguration(classes = {CompanyLegalForm.class})
@ExtendWith(SpringExtension.class)
class CompanyLegalFormTest {
  @Autowired
  private CompanyLegalForm companyLegalForm;

  /**
   * Method under test: {@link CompanyLegalForm#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new CompanyLegalForm()).canEqual("Other"));
  }

  /**
   * Method under test: {@link CompanyLegalForm#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();

    CompanyLegalForm companyLegalForm3 = new CompanyLegalForm();
    companyLegalForm3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm3.setLegalFormId(1);
    companyLegalForm3.setLegalFormName("Legal Form Name");
    companyLegalForm3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(companyLegalForm2.canEqual(companyLegalForm3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link CompanyLegalForm}
  *   <li>{@link CompanyLegalForm#setLegalFormId(int)}
  *   <li>{@link CompanyLegalForm#setLegalFormName(String)}
  *   <li>{@link CompanyLegalForm#toString()}
  *   <li>{@link CompanyLegalForm#getLegalFormId()}
  *   <li>{@link CompanyLegalForm#getLegalFormName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    CompanyLegalForm actualCompanyLegalForm = new CompanyLegalForm();
    actualCompanyLegalForm.setLegalFormId(1);
    actualCompanyLegalForm.setLegalFormName("Legal Form Name");
    String actualToStringResult = actualCompanyLegalForm.toString();
    int actualLegalFormId = actualCompanyLegalForm.getLegalFormId();

    // Assert that nothing has changed
    assertEquals("CompanyLegalForm(legalFormId=1, legalFormName=Legal Form Name)", actualToStringResult);
    assertEquals("Legal Form Name", actualCompanyLegalForm.getLegalFormName());
    assertEquals(1, actualLegalFormId);
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, null);
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, "Different type to CompanyLegalForm");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link CompanyLegalForm#equals(Object)}
   *   <li>{@link CompanyLegalForm#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(companyLegalForm, companyLegalForm);
    int expectedHashCodeResult = companyLegalForm.hashCode();
    assertEquals(expectedHashCodeResult, companyLegalForm.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link CompanyLegalForm#equals(Object)}
   *   <li>{@link CompanyLegalForm#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(companyLegalForm, companyLegalForm2);
    int expectedHashCodeResult = companyLegalForm.hashCode();
    assertEquals(expectedHashCodeResult, companyLegalForm2.hashCode());
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.now().atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, companyLegalForm2);
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(2);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, companyLegalForm2);
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, companyLegalForm2);
  }

  /**
   * Method under test: {@link CompanyLegalForm#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName(null);
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(companyLegalForm, companyLegalForm2);
  }
}

