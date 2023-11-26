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
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.repository.DiplomaTypeRepository;
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

@ContextConfiguration(classes = {DiplomaTypeService.class})
@ExtendWith(SpringExtension.class)
class DiplomaTypeServiceTest {
  @MockBean
  private DiplomaTypeRepository diplomaTypeRepository;

  @Autowired
  private DiplomaTypeService diplomaTypeService;
  /**
   * Method under test: {@link DiplomaTypeService#showAllDiplomaType(int, int)}
   */
  @Test
  void testShowAllDiplomaType() {
    // Arrange
    PageImpl<DiplomaType> pageImpl = new PageImpl<>(new ArrayList<>());
    when(diplomaTypeRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<DiplomaType> actualShowAllDiplomaTypeResult = diplomaTypeService.showAllDiplomaType(10, 3);

    // Assert
    verify(diplomaTypeRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllDiplomaTypeResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllDiplomaTypeResult);
  }

  /**
   * Method under test: {@link DiplomaTypeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<DiplomaType> diplomaTypeList = new ArrayList<>();
    when(diplomaTypeRepository.findAll()).thenReturn(diplomaTypeList);

    // Act
    List<DiplomaType> actualFindAllResult = diplomaTypeService.findAll();

    // Assert
    verify(diplomaTypeRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(diplomaTypeList, actualFindAllResult);
  }

  /**
  * Method under test: {@link DiplomaTypeService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(diplomaTypeRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = diplomaTypeService.count();

    // Assert
    verify(diplomaTypeRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link DiplomaTypeService#update(DiplomaType)}
   */
  @Test
  void testUpdate() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
    when(diplomaTypeRepository.save(Mockito.<DiplomaType>any())).thenReturn(diplomaType);
    when(diplomaTypeRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

    // Act
    DiplomaType actualUpdateResult = diplomaTypeService.update(diplomaType2);

    // Assert
    verify(diplomaTypeRepository).existsById(Mockito.<Integer>any());
    verify(diplomaTypeRepository).save(Mockito.<DiplomaType>any());
    assertSame(diplomaType, actualUpdateResult);
  }

  /**
   * Method under test: {@link DiplomaTypeService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(diplomaTypeRepository).deleteById(Mockito.<Integer>any());
    when(diplomaTypeRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    diplomaTypeService.delete(1);

    // Assert that nothing has changed
    verify(diplomaTypeRepository).deleteById(Mockito.<Integer>any());
    verify(diplomaTypeRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link DiplomaTypeService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
    Optional<DiplomaType> ofResult = Optional.of(diplomaType);
    when(diplomaTypeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    DiplomaType actualFindResult = diplomaTypeService.find(1);

    // Assert
    verify(diplomaTypeRepository).findById(Mockito.<Integer>any());
    assertSame(diplomaType, actualFindResult);
  }
}

