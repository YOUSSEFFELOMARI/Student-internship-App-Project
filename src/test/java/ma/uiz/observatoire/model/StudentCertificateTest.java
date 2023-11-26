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
@ContextConfiguration(classes = {StudentCertificate.class})
@ExtendWith(SpringExtension.class)
class StudentCertificateTest {
  @Autowired
  private StudentCertificate studentCertificate;

  /**
   * Method under test: {@link StudentCertificate#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new StudentCertificate()).canEqual("Other"));
  }

  /**
   * Method under test: {@link StudentCertificate#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    StudentCertificate studentCertificate2 = new StudentCertificate();

    StudentCertificate studentCertificate3 = new StudentCertificate();
    studentCertificate3.setCertificateId(1);
    studentCertificate3.setCertificateName("Certificate Name");
    studentCertificate3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(studentCertificate2.canEqual(studentCertificate3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link StudentCertificate}
  *   <li>{@link StudentCertificate#setCertificateId(int)}
  *   <li>{@link StudentCertificate#setCertificateName(String)}
  *   <li>{@link StudentCertificate#toString()}
  *   <li>{@link StudentCertificate#getCertificateId()}
  *   <li>{@link StudentCertificate#getCertificateName()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    StudentCertificate actualStudentCertificate = new StudentCertificate();
    actualStudentCertificate.setCertificateId(1);
    actualStudentCertificate.setCertificateName("Certificate Name");
    String actualToStringResult = actualStudentCertificate.toString();
    int actualCertificateId = actualStudentCertificate.getCertificateId();

    // Assert that nothing has changed
    assertEquals("Certificate Name", actualStudentCertificate.getCertificateName());
    assertEquals("StudentCertificate(certificateId=1, certificateName=Certificate Name)", actualToStringResult);
    assertEquals(1, actualCertificateId);
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, null);
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals2() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, "Different type to StudentCertificate");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentCertificate#equals(Object)}
   *   <li>{@link StudentCertificate#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentCertificate, studentCertificate);
    int expectedHashCodeResult = studentCertificate.hashCode();
    assertEquals(expectedHashCodeResult, studentCertificate.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link StudentCertificate#equals(Object)}
   *   <li>{@link StudentCertificate#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(studentCertificate, studentCertificate2);
    int expectedHashCodeResult = studentCertificate.hashCode();
    assertEquals(expectedHashCodeResult, studentCertificate2.hashCode());
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(2);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, studentCertificate2);
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, studentCertificate2);
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName(null);
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, studentCertificate2);
  }

  /**
   * Method under test: {@link StudentCertificate#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.now().atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(studentCertificate, studentCertificate2);
  }
}

