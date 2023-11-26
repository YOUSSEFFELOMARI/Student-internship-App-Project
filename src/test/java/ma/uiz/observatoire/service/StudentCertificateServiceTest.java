package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import ma.uiz.observatoire.model.StudentCertificate;
import ma.uiz.observatoire.repository.StudentCertificateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentCertificateService.class})
@ExtendWith(SpringExtension.class)
class StudentCertificateServiceTest {
  @MockBean
  private StudentCertificateRepository studentCertificateRepository;

  @Autowired
  private StudentCertificateService studentCertificateService;
  /**
   * Method under test: {@link StudentCertificateService#showAllStudentCertificate(int, int)}
   */
  @Test
  void testShowAllStudentCertificate() {
    // Arrange
    PageImpl<StudentCertificate> pageImpl = new PageImpl<>(new ArrayList<>());
    when(studentCertificateRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<StudentCertificate> actualShowAllStudentCertificateResult = studentCertificateService
        .showAllStudentCertificate(10, 3);

    // Assert
    verify(studentCertificateRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentCertificateResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllStudentCertificateResult);
  }

  /**
   * Method under test: {@link StudentCertificateService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(studentCertificateRepository).deleteById(Mockito.<Integer>any());
    when(studentCertificateRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    studentCertificateService.delete(1);

    // Assert that nothing has changed
    verify(studentCertificateRepository).deleteById(Mockito.<Integer>any());
    verify(studentCertificateRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentCertificateService#update(StudentCertificate)}
   */
  @Test
  void testUpdate() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");
    when(studentCertificateRepository.save(Mockito.<StudentCertificate>any())).thenReturn(studentCertificate);
    when(studentCertificateRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    StudentCertificate studentCertificate2 = new StudentCertificate();
    studentCertificate2.setCertificateId(1);
    studentCertificate2.setCertificateName("Certificate Name");
    studentCertificate2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate2.setUpdatedBy("2020-03-01");

    // Act
    studentCertificateService.update(studentCertificate2);

    // Assert that nothing has changed
    verify(studentCertificateRepository).existsById(Mockito.<Integer>any());
    verify(studentCertificateRepository).save(Mockito.<StudentCertificate>any());
    assertEquals("00:00", studentCertificate2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", studentCertificate2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", studentCertificate2.getUpdatedBy());
    assertEquals("Certificate Name", studentCertificate2.getCertificateName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", studentCertificate2.getCreatedBy());
    assertEquals(1, studentCertificate2.getCertificateId());
  }

  /**
   * Method under test: {@link StudentCertificateService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    StudentCertificate studentCertificate = new StudentCertificate();
    studentCertificate.setCertificateId(1);
    studentCertificate.setCertificateName("Certificate Name");
    studentCertificate.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCertificate.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCertificate.setUpdatedBy("2020-03-01");
    Optional<StudentCertificate> ofResult = Optional.of(studentCertificate);
    when(studentCertificateRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    StudentCertificate actualFindResult = studentCertificateService.find(1);

    // Assert
    verify(studentCertificateRepository).findById(Mockito.<Integer>any());
    assertSame(studentCertificate, actualFindResult);
  }

  /**
  * Method under test: {@link StudentCertificateService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(studentCertificateRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentCertificateService.count();

    // Assert
    verify(studentCertificateRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

