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
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.repository.CompanyLegalFormRepository;
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

@ContextConfiguration(classes = {CompanyLegalFormService.class})
@ExtendWith(SpringExtension.class)
class CompanyLegalFormServiceTest {
  @MockBean
  private CompanyLegalFormRepository companyLegalFormRepository;

  @Autowired
  private CompanyLegalFormService companyLegalFormService;
  /**
   * Method under test: {@link CompanyLegalFormService#showAllCompanyLegalForm(int, int)}
   */
  @Test
  void testShowAllCompanyLegalForm() {
    // Arrange
    PageImpl<CompanyLegalForm> pageImpl = new PageImpl<>(new ArrayList<>());
    when(companyLegalFormRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<CompanyLegalForm> actualShowAllCompanyLegalFormResult = companyLegalFormService.showAllCompanyLegalForm(10, 3);

    // Assert
    verify(companyLegalFormRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllCompanyLegalFormResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllCompanyLegalFormResult);
  }

  /**
   * Method under test: {@link CompanyLegalFormService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(companyLegalFormRepository).deleteById(Mockito.<Integer>any());
    when(companyLegalFormRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    companyLegalFormService.delete(1);

    // Assert that nothing has changed
    verify(companyLegalFormRepository).deleteById(Mockito.<Integer>any());
    verify(companyLegalFormRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link CompanyLegalFormService#update(CompanyLegalForm)}
   */
  @Test
  void testUpdate() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    when(companyLegalFormRepository.save(Mockito.<CompanyLegalForm>any())).thenReturn(companyLegalForm);
    when(companyLegalFormRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    // Act
    companyLegalFormService.update(companyLegalForm2);

    // Assert that nothing has changed
    verify(companyLegalFormRepository).existsById(Mockito.<Integer>any());
    verify(companyLegalFormRepository).save(Mockito.<CompanyLegalForm>any());
    assertEquals("00:00", companyLegalForm2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", companyLegalForm2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", companyLegalForm2.getUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", companyLegalForm2.getCreatedBy());
    assertEquals("Legal Form Name", companyLegalForm2.getLegalFormName());
    assertEquals(1, companyLegalForm2.getLegalFormId());
  }

  /**
   * Method under test: {@link CompanyLegalFormService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Optional<CompanyLegalForm> ofResult = Optional.of(companyLegalForm);
    when(companyLegalFormRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    CompanyLegalForm actualFindResult = companyLegalFormService.find(1);

    // Assert
    verify(companyLegalFormRepository).findById(Mockito.<Integer>any());
    assertSame(companyLegalForm, actualFindResult);
  }

  /**
  * Method under test: {@link CompanyLegalFormService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(companyLegalFormRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = companyLegalFormService.count();

    // Assert
    verify(companyLegalFormRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

