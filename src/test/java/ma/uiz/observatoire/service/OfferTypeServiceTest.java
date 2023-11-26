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
import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.repository.OfferTypeRepository;
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

@ContextConfiguration(classes = {OfferTypeService.class})
@ExtendWith(SpringExtension.class)
class OfferTypeServiceTest {
  @MockBean
  private OfferTypeRepository offerTypeRepository;

  @Autowired
  private OfferTypeService offerTypeService;
  /**
   * Method under test: {@link OfferTypeService#showAllOfferType(int, int)}
   */
  @Test
  void testShowAllOfferType() {
    // Arrange
    PageImpl<OfferType> pageImpl = new PageImpl<>(new ArrayList<>());
    when(offerTypeRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<OfferType> actualShowAllOfferTypeResult = offerTypeService.showAllOfferType(10, 3);

    // Assert
    verify(offerTypeRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllOfferTypeResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllOfferTypeResult);
  }

  /**
   * Method under test: {@link OfferTypeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<OfferType> offerTypeList = new ArrayList<>();
    when(offerTypeRepository.findAll()).thenReturn(offerTypeList);

    // Act
    List<OfferType> actualFindAllResult = offerTypeService.findAll();

    // Assert
    verify(offerTypeRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(offerTypeList, actualFindAllResult);
  }

  /**
  * Method under test: {@link OfferTypeService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(offerTypeRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = offerTypeService.count();

    // Assert
    verify(offerTypeRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link OfferTypeService#update(OfferType)}
   */
  @Test
  void testUpdate() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");
    when(offerTypeRepository.save(Mockito.<OfferType>any())).thenReturn(offerType);
    when(offerTypeRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    OfferType offerType2 = new OfferType();
    offerType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType2.setOfferTypeId(1);
    offerType2.setOfferTypeName("Offer Type Name");
    offerType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType2.setUpdatedBy("2020-03-01");

    // Act
    OfferType actualUpdateResult = offerTypeService.update(offerType2);

    // Assert
    verify(offerTypeRepository).existsById(Mockito.<Integer>any());
    verify(offerTypeRepository).save(Mockito.<OfferType>any());
    assertSame(offerType, actualUpdateResult);
  }

  /**
   * Method under test: {@link OfferTypeService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(offerTypeRepository).deleteById(Mockito.<Integer>any());
    when(offerTypeRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    offerTypeService.delete(1);

    // Assert that nothing has changed
    verify(offerTypeRepository).deleteById(Mockito.<Integer>any());
    verify(offerTypeRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link OfferTypeService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    OfferType offerType = new OfferType();
    offerType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offerType.setOfferTypeId(1);
    offerType.setOfferTypeName("Offer Type Name");
    offerType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offerType.setUpdatedBy("2020-03-01");
    Optional<OfferType> ofResult = Optional.of(offerType);
    when(offerTypeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    OfferType actualFindResult = offerTypeService.find(1);

    // Assert
    verify(offerTypeRepository).findById(Mockito.<Integer>any());
    assertSame(offerType, actualFindResult);
  }
}

