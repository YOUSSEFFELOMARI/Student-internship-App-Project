package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import ma.uiz.observatoire.model.StudentExperience;
import ma.uiz.observatoire.repository.StudentExperienceRepository;
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

@ContextConfiguration(classes = {StudentExperienceService.class})
@ExtendWith(SpringExtension.class)
class StudentExperienceServiceTest {
  @MockBean
  private StudentExperienceRepository studentExperienceRepository;

  @Autowired
  private StudentExperienceService studentExperienceService;
  /**
   * Method under test: {@link StudentExperienceService#showAllStudentExperience(int, int)}
   */
  @Test
  void testShowAllStudentExperience() {
    // Arrange
    PageImpl<StudentExperience> pageImpl = new PageImpl<>(new ArrayList<>());
    when(studentExperienceRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<StudentExperience> actualShowAllStudentExperienceResult = studentExperienceService.showAllStudentExperience(10,
        3);

    // Assert
    verify(studentExperienceRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentExperienceResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllStudentExperienceResult);
  }

  /**
   * Method under test: {@link StudentExperienceService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(studentExperienceRepository).deleteById(Mockito.<Integer>any());
    when(studentExperienceRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    studentExperienceService.delete(1);

    // Assert that nothing has changed
    verify(studentExperienceRepository).deleteById(Mockito.<Integer>any());
    verify(studentExperienceRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentExperienceService#update(StudentExperience)}
   */
  @Test
  void testUpdate() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    when(studentExperienceRepository.save(Mockito.<StudentExperience>any())).thenReturn(studentExperience);
    when(studentExperienceRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    StudentExperience studentExperience2 = new StudentExperience();
    studentExperience2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    studentExperience2.setEndDate(endDate);
    studentExperience2.setExperienceDescription("Experience Description");
    studentExperience2.setExperienceId(1);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    studentExperience2.setStartDate(startDate);
    studentExperience2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience2.setUpdatedBy("2020-03-01");

    // Act
    studentExperienceService.update(studentExperience2);

    // Assert that nothing has changed
    verify(studentExperienceRepository).existsById(Mockito.<Integer>any());
    verify(studentExperienceRepository).save(Mockito.<StudentExperience>any());
    assertEquals("00:00", studentExperience2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", studentExperience2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", studentExperience2.getUpdatedBy());
    assertEquals("Experience Description", studentExperience2.getExperienceDescription());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", studentExperience2.getCreatedBy());
    assertEquals(1, studentExperience2.getExperienceId());
    assertSame(endDate, studentExperience2.getEndDate());
    assertSame(startDate, studentExperience2.getStartDate());
  }

  /**
   * Method under test: {@link StudentExperienceService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    Optional<StudentExperience> ofResult = Optional.of(studentExperience);
    when(studentExperienceRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    StudentExperience actualFindResult = studentExperienceService.find(1);

    // Assert
    verify(studentExperienceRepository).findById(Mockito.<Integer>any());
    assertSame(studentExperience, actualFindResult);
  }

  /**
  * Method under test: {@link StudentExperienceService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(studentExperienceRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentExperienceService.count();

    // Assert
    verify(studentExperienceRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

