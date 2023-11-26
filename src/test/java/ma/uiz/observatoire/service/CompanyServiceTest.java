package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.utils.ImgUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {CompanyService.class})
@ExtendWith(SpringExtension.class)
class CompanyServiceTest {
  @MockBean
  private CompanyRepository companyRepository;

  @Autowired
  private CompanyService companyService;

  @MockBean
  private ImgUtils imgUtils;
  /**
   * Method under test: {@link CompanyService#showAllCompany(int, int)}
   */
  @Test
  void testShowAllCompany() {
    // Arrange
    PageImpl<Company> pageImpl = new PageImpl<>(new ArrayList<>());
    when(companyRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Company> actualShowAllCompanyResult = companyService.showAllCompany(10, 3);

    // Assert
    verify(companyRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllCompanyResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllCompanyResult);
  }

  /**
   * Method under test: {@link CompanyService#showAllCompany(int, int)}
   */
  @Test
  void testShowAllCompany2() {
    // Arrange
    when(companyRepository.findAll(Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.showAllCompany(10, 3));
    verify(companyRepository).findAll(Mockito.<Pageable>any());
  }

  /**
   * Method under test: {@link CompanyService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    doNothing().when(companyRepository).deleteById(Mockito.<Integer>any());
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(companyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    // Act
    companyService.delete(1);

    // Assert
    verify(imgUtils).getFileSystemFolder();
    verify(companyRepository).deleteById(Mockito.<Integer>any());
    verify(companyRepository).existsById(Mockito.<Integer>any());
    verify(companyRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link CompanyService#delete(int)}
   */
  @Test
  void testDelete2() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(companyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);
    when(imgUtils.getFileSystemFolder()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.delete(1));
    verify(imgUtils).getFileSystemFolder();
    verify(companyRepository).existsById(Mockito.<Integer>any());
    verify(companyRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link CompanyService#update(Company)}
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

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    when(companyRepository.save(Mockito.<Company>any())).thenReturn(company);
    when(companyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");

    // Act
    companyService.update(company2);

    // Assert that nothing has changed
    verify(companyRepository).existsById(Mockito.<Integer>any());
    verify(companyRepository).save(Mockito.<Company>any());
    assertEquals("00:00", company2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", company2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", company2.getUpdatedBy());
    assertEquals("21654", company2.getZipCode());
    assertEquals("42 Main St", company2.getAddress1());
    assertEquals("42 Main St", company2.getAddress2());
    assertEquals("6625550144", company2.getCompanyPhone());
    assertEquals("Company Name", company2.getCompanyName());
    assertEquals("Company Siret", company2.getCompanySiret());
    assertEquals("Company Website", company2.getCompanyWebsite());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", company2.getCreatedBy());
    assertEquals("Oxford", company2.getCity());
    assertEquals("https://example.org/example", company2.getImageUrl());
    assertEquals("jane.doe@example.org", company2.getCompanyEmail());
    assertEquals("us-east-2", company2.getRegion());
    assertEquals(1, company2.getCompanyId());
    assertTrue(company2.getCompanyResponsibles().isEmpty());
    assertTrue(company2.getDomains().isEmpty());
    assertEquals(companyLegalForm, company2.getCompanyLegalForm());
  }

  /**
   * Method under test: {@link CompanyService#update(Company)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    when(companyRepository.save(Mockito.<Company>any())).thenThrow(new RuntimeException("foo"));
    when(companyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.update(company));
    verify(companyRepository).existsById(Mockito.<Integer>any());
    verify(companyRepository).save(Mockito.<Company>any());
  }

  /**
   * Method under test: {@link CompanyService#find(int)}
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

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Company actualFindResult = companyService.find(1);

    // Assert
    verify(companyRepository).findById(Mockito.<Integer>any());
    assertSame(company, actualFindResult);
  }

  /**
   * Method under test: {@link CompanyService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<Company> companyList = new ArrayList<>();
    when(companyRepository.findAll()).thenReturn(companyList);

    // Act
    List<Company> actualFindAllResult = companyService.findAll();

    // Assert
    verify(companyRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(companyList, actualFindAllResult);
  }

  /**
   * Method under test: {@link CompanyService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    when(companyRepository.findAll()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.findAll());
    verify(companyRepository).findAll();
  }

  /**
  * Method under test: {@link CompanyService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(companyRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = companyService.count();

    // Assert
    verify(companyRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link CompanyService#count()}
   */
  @Test
  void testCount2() {
    // Arrange
    when(companyRepository.count()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.count());
    verify(companyRepository).count();
  }

  /**
   * Method under test: {@link CompanyService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg() throws IOException {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(companyRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link CompanyService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg2() throws IOException {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    Optional<Company> ofResult = Optional.of(company);
    when(companyRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(imgUtils.getFileSystemFolder()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> companyService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileSystemFolder();
    verify(companyRepository).findById(Mockito.<Integer>any());
  }
}

