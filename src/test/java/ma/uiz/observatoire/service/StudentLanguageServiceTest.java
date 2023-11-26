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
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.repository.StudentLanguageRepository;
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

@ContextConfiguration(classes = {StudentLanguageService.class})
@ExtendWith(SpringExtension.class)
class StudentLanguageServiceTest {
  @MockBean
  private StudentLanguageRepository studentLanguageRepository;

  @Autowired
  private StudentLanguageService studentLanguageService;
  /**
   * Method under test: {@link StudentLanguageService#showAllStudentLanguage(int, int)}
   */
  @Test
  void testShowAllStudentLanguage() {
    // Arrange
    PageImpl<StudentLanguage> pageImpl = new PageImpl<>(new ArrayList<>());
    when(studentLanguageRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<StudentLanguage> actualShowAllStudentLanguageResult = studentLanguageService.showAllStudentLanguage(10, 3);

    // Assert
    verify(studentLanguageRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentLanguageResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllStudentLanguageResult);
  }

  /**
   * Method under test: {@link StudentLanguageService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(studentLanguageRepository).deleteById(Mockito.<Integer>any());
    when(studentLanguageRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    studentLanguageService.delete(1);

    // Assert that nothing has changed
    verify(studentLanguageRepository).deleteById(Mockito.<Integer>any());
    verify(studentLanguageRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentLanguageService#update(StudentLanguage)}
   */
  @Test
  void testUpdate() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    when(studentLanguageRepository.save(Mockito.<StudentLanguage>any())).thenReturn(studentLanguage);
    when(studentLanguageRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage2.setLanguageId(1);
    studentLanguage2.setLanguageLevel(1);
    studentLanguage2.setLanguageName("en");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020-03-01");

    // Act
    studentLanguageService.update(studentLanguage2);

    // Assert that nothing has changed
    verify(studentLanguageRepository).existsById(Mockito.<Integer>any());
    verify(studentLanguageRepository).save(Mockito.<StudentLanguage>any());
    assertEquals("00:00", studentLanguage2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", studentLanguage2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", studentLanguage2.getUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", studentLanguage2.getCreatedBy());
    assertEquals("en", studentLanguage2.getLanguageName());
    assertEquals(1, studentLanguage2.getLanguageId());
    assertEquals(1, studentLanguage2.getLanguageLevel());
  }

  /**
   * Method under test: {@link StudentLanguageService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    Optional<StudentLanguage> ofResult = Optional.of(studentLanguage);
    when(studentLanguageRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    StudentLanguage actualFindResult = studentLanguageService.find(1);

    // Assert
    verify(studentLanguageRepository).findById(Mockito.<Integer>any());
    assertSame(studentLanguage, actualFindResult);
  }

  /**
  * Method under test: {@link StudentLanguageService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(studentLanguageRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentLanguageService.count();

    // Assert
    verify(studentLanguageRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

