package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.repository.SpecialityRepository;
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

@ContextConfiguration(classes = {SpecialityService.class})
@ExtendWith(SpringExtension.class)
class SpecialityServiceTest {
  @MockBean
  private SpecialityRepository specialityRepository;

  @Autowired
  private SpecialityService specialityService;
  /**
   * Method under test: {@link SpecialityService#showAllSpeciality(int, int)}
   */
  @Test
  void testShowAllSpeciality() {
    // Arrange
    PageImpl<Speciality> pageImpl = new PageImpl<>(new ArrayList<>());
    when(specialityRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Speciality> actualShowAllSpecialityResult = specialityService.showAllSpeciality(10, 3);

    // Assert
    verify(specialityRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllSpecialityResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllSpecialityResult);
  }

  /**
   * Method under test: {@link SpecialityService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<Speciality> specialityList = new ArrayList<>();
    when(specialityRepository.findAll()).thenReturn(specialityList);

    // Act
    List<Speciality> actualFindAllResult = specialityService.findAll();

    // Assert
    verify(specialityRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(specialityList, actualFindAllResult);
  }

  /**
  * Method under test: {@link SpecialityService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(specialityRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = specialityService.count();

    // Assert
    verify(specialityRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link SpecialityService#update(Speciality)}
   */
  @Test
  void testUpdate() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");
    when(specialityRepository.save(Mockito.<Speciality>any())).thenReturn(speciality);
    when(specialityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Speciality speciality2 = new Speciality();
    speciality2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality2.setSpecialityId(1);
    speciality2.setSpecialityName("Speciality Name");
    speciality2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality2.setUpdatedBy("2020-03-01");

    // Act
    Speciality actualUpdateResult = specialityService.update(speciality2);

    // Assert
    verify(specialityRepository).existsById(Mockito.<Integer>any());
    verify(specialityRepository).save(Mockito.<Speciality>any());
    assertSame(speciality, actualUpdateResult);
  }

  /**
   * Method under test: {@link SpecialityService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(specialityRepository).deleteById(Mockito.<Integer>any());
    when(specialityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    specialityService.delete(1);

    // Assert that nothing has changed
    verify(specialityRepository).deleteById(Mockito.<Integer>any());
    verify(specialityRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link SpecialityService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");
    Optional<Speciality> ofResult = Optional.of(speciality);
    when(specialityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Speciality actualFindResult = specialityService.find(1);

    // Assert
    verify(specialityRepository).findById(Mockito.<Integer>any());
    assertSame(speciality, actualFindResult);
  }
}

