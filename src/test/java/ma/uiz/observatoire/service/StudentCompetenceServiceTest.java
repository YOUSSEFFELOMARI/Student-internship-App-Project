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
import ma.uiz.observatoire.model.StudentCompetence;
import ma.uiz.observatoire.repository.StudentCompetenceRepository;
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

@ContextConfiguration(classes = {StudentCompetenceService.class})
@ExtendWith(SpringExtension.class)
class StudentCompetenceServiceTest {
  @MockBean
  private StudentCompetenceRepository studentCompetenceRepository;

  @Autowired
  private StudentCompetenceService studentCompetenceService;
  /**
   * Method under test: {@link StudentCompetenceService#showAllStudentCompetence(int, int)}
   */
  @Test
  void testShowAllStudentCompetence() {
    // Arrange
    PageImpl<StudentCompetence> pageImpl = new PageImpl<>(new ArrayList<>());
    when(studentCompetenceRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<StudentCompetence> actualShowAllStudentCompetenceResult = studentCompetenceService.showAllStudentCompetence(10,
        3);

    // Assert
    verify(studentCompetenceRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentCompetenceResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllStudentCompetenceResult);
  }

  /**
   * Method under test: {@link StudentCompetenceService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(studentCompetenceRepository).deleteById(Mockito.<Integer>any());
    when(studentCompetenceRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    studentCompetenceService.delete(1);

    // Assert that nothing has changed
    verify(studentCompetenceRepository).deleteById(Mockito.<Integer>any());
    verify(studentCompetenceRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentCompetenceService#update(StudentCompetence)}
   */
  @Test
  void testUpdate() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");
    when(studentCompetenceRepository.save(Mockito.<StudentCompetence>any())).thenReturn(studentCompetence);
    when(studentCompetenceRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    StudentCompetence studentCompetence2 = new StudentCompetence();
    studentCompetence2.setCompetenceId(1);
    studentCompetence2.setCompetenceName("Bella");
    studentCompetence2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence2.setUpdatedBy("2020-03-01");

    // Act
    studentCompetenceService.update(studentCompetence2);

    // Assert that nothing has changed
    verify(studentCompetenceRepository).existsById(Mockito.<Integer>any());
    verify(studentCompetenceRepository).save(Mockito.<StudentCompetence>any());
    assertEquals("00:00", studentCompetence2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", studentCompetence2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", studentCompetence2.getUpdatedBy());
    assertEquals("Bella", studentCompetence2.getCompetenceName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", studentCompetence2.getCreatedBy());
    assertEquals(1, studentCompetence2.getCompetenceId());
  }

  /**
   * Method under test: {@link StudentCompetenceService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    StudentCompetence studentCompetence = new StudentCompetence();
    studentCompetence.setCompetenceId(1);
    studentCompetence.setCompetenceName("Bella");
    studentCompetence.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentCompetence.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentCompetence.setUpdatedBy("2020-03-01");
    Optional<StudentCompetence> ofResult = Optional.of(studentCompetence);
    when(studentCompetenceRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    StudentCompetence actualFindResult = studentCompetenceService.find(1);

    // Assert
    verify(studentCompetenceRepository).findById(Mockito.<Integer>any());
    assertSame(studentCompetence, actualFindResult);
  }

  /**
  * Method under test: {@link StudentCompetenceService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(studentCompetenceRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentCompetenceService.count();

    // Assert
    verify(studentCompetenceRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

