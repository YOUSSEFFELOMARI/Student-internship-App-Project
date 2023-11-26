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
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.repository.StudentHobbyRepository;
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

@ContextConfiguration(classes = {StudentHobbyService.class})
@ExtendWith(SpringExtension.class)
class StudentHobbyServiceTest {
  @MockBean
  private StudentHobbyRepository studentHobbyRepository;

  @Autowired
  private StudentHobbyService studentHobbyService;
  /**
   * Method under test: {@link StudentHobbyService#showAllStudentHobby(int, int)}
   */
  @Test
  void testShowAllStudentHobby() {
    // Arrange
    PageImpl<StudentHobby> pageImpl = new PageImpl<>(new ArrayList<>());
    when(studentHobbyRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<StudentHobby> actualShowAllStudentHobbyResult = studentHobbyService.showAllStudentHobby(10, 3);

    // Assert
    verify(studentHobbyRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentHobbyResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllStudentHobbyResult);
  }

  /**
   * Method under test: {@link StudentHobbyService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(studentHobbyRepository).deleteById(Mockito.<Integer>any());
    when(studentHobbyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    studentHobbyService.delete(1);

    // Assert that nothing has changed
    verify(studentHobbyRepository).deleteById(Mockito.<Integer>any());
    verify(studentHobbyRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentHobbyService#update(StudentHobby)}
   */
  @Test
  void testUpdate() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");
    when(studentHobbyRepository.save(Mockito.<StudentHobby>any())).thenReturn(studentHobby);
    when(studentHobbyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    StudentHobby studentHobby2 = new StudentHobby();
    studentHobby2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby2.setHobbiesName("Hobbies Name");
    studentHobby2.setHobbyId(1);
    studentHobby2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby2.setUpdatedBy("2020-03-01");

    // Act
    studentHobbyService.update(studentHobby2);

    // Assert that nothing has changed
    verify(studentHobbyRepository).existsById(Mockito.<Integer>any());
    verify(studentHobbyRepository).save(Mockito.<StudentHobby>any());
    assertEquals("00:00", studentHobby2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", studentHobby2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", studentHobby2.getUpdatedBy());
    assertEquals("Hobbies Name", studentHobby2.getHobbiesName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", studentHobby2.getCreatedBy());
    assertEquals(1, studentHobby2.getHobbyId());
  }

  /**
   * Method under test: {@link StudentHobbyService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");
    Optional<StudentHobby> ofResult = Optional.of(studentHobby);
    when(studentHobbyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    StudentHobby actualFindResult = studentHobbyService.find(1);

    // Assert
    verify(studentHobbyRepository).findById(Mockito.<Integer>any());
    assertSame(studentHobby, actualFindResult);
  }

  /**
  * Method under test: {@link StudentHobbyService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(studentHobbyRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentHobbyService.count();

    // Assert
    verify(studentHobbyRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

