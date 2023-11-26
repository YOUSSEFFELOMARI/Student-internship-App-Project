package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.mapper.OfferMapper;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.repository.OfferRepository;
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

@ContextConfiguration(classes = {OfferService.class})
@ExtendWith(SpringExtension.class)
class OfferServiceTest {
  @MockBean
  private OfferMapper offerMapper;

  @MockBean
  private OfferRepository offerRepository;

  @Autowired
  private OfferService offerService;
  /**
   * Method under test: {@link OfferService#showAllOffer(int, int)}
   */
  @Test
  void testShowAllOffer() {
    // Arrange
    when(offerRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    Page<OfferDTO> actualShowAllOfferResult = offerService.showAllOffer(10, 3);

    // Assert
    verify(offerRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllOfferResult.toList().isEmpty());
  }

  /**
   * Method under test: {@link OfferService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    when(offerRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OfferDTO> actualFindAllResult = offerService.findAll();

    // Assert
    verify(offerRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link OfferService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(offerRepository).deleteById(Mockito.<Integer>any());
    when(offerRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    offerService.delete(1);

    // Assert that nothing has changed
    verify(offerRepository).deleteById(Mockito.<Integer>any());
    verify(offerRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link OfferService#update(OfferDTO)}
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");
    when(offerRepository.save(Mockito.<Offer>any())).thenReturn(offer);
    when(offerRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    offer2.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    offer2.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");
    when(offerMapper.mapToModel(Mockito.<OfferDTO>any())).thenReturn(offer2);

    CompanyDTO company3 = new CompanyDTO();
    company3.setCompanyId(1);
    company3.setCompanyName("Company Name");

    OfferDTO offerDTO = new OfferDTO();
    offerDTO.setAssignmentCity("Assignment City");
    offerDTO.setCompany(company3);
    offerDTO.setDescription("The characteristics of someone or something");
    offerDTO.setDiplomaTypes(new HashSet<>());
    offerDTO.setDomains(new HashSet<>());
    offerDTO.setExpirationDate("2020-03-01");
    offerDTO.setLanguages(new HashSet<>());
    offerDTO.setOfferId(1);
    offerDTO.setOfferName("Offer Name");
    offerDTO.setPublicationDate("2020-03-01");
    offerDTO.setSalaryMax(10.0d);
    offerDTO.setSalaryMin(10.0d);

    // Act
    offerService.update(offerDTO);

    // Assert
    verify(offerMapper).mapToModel(Mockito.<OfferDTO>any());
    verify(offerRepository).existsById(Mockito.<Integer>any());
    verify(offerRepository).save(Mockito.<Offer>any());
  }

  /**
   * Method under test: {@link OfferService#updateOffer(Offer)}
   */
  @Test
  void testUpdateOffer() {
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");
    when(offerRepository.save(Mockito.<Offer>any())).thenReturn(offer);
    when(offerRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    Offer offer2 = new Offer();
    offer2.setApplications(new HashSet<>());
    offer2.setAssignmentCity("Assignment City");
    offer2.setCompany(company2);
    offer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer2.setDescription("The characteristics of someone or something");
    offer2.setDiplomaTypes(new HashSet<>());
    offer2.setDomains(new HashSet<>());
    Date ExpirationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offer2.setExpirationDate(ExpirationDate);
    offer2.setOfferId(1);
    offer2.setOfferName("Offer Name");
    Date publicationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offer2.setPublicationDate(publicationDate);
    offer2.setSalaryMax(10.0d);
    offer2.setSalaryMin(10.0d);
    offer2.setStudentLanguages(new HashSet<>());
    offer2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer2.setUpdatedBy("2020-03-01");

    // Act
    offerService.updateOffer(offer2);

    // Assert that nothing has changed
    verify(offerRepository).existsById(Mockito.<Integer>any());
    verify(offerRepository).save(Mockito.<Offer>any());
    assertEquals("00:00", offer2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", offer2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", offer2.getUpdatedBy());
    assertEquals("Assignment City", offer2.getAssignmentCity());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", offer2.getCreatedBy());
    assertEquals("Offer Name", offer2.getOfferName());
    assertEquals("The characteristics of someone or something", offer2.getDescription());
    assertEquals(1, offer2.getOfferId());
    assertEquals(10.0d, offer2.getSalaryMax());
    assertEquals(10.0d, offer2.getSalaryMin());
    assertTrue(offer2.getApplications().isEmpty());
    assertTrue(offer2.getDiplomaTypes().isEmpty());
    assertTrue(offer2.getDomains().isEmpty());
    assertTrue(offer2.getStudentLanguages().isEmpty());
    assertEquals(company, offer2.getCompany());
    assertSame(ExpirationDate, offer2.getExpirationDate());
    assertSame(publicationDate, offer2.getPublicationDate());
  }

  /**
   * Method under test: {@link OfferService#find(int)}
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");
    Optional<Offer> ofResult = Optional.of(offer);
    when(offerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    CompanyDTO company2 = new CompanyDTO();
    company2.setCompanyId(1);
    company2.setCompanyName("Company Name");

    OfferDTO offerDTO = new OfferDTO();
    offerDTO.setAssignmentCity("Assignment City");
    offerDTO.setCompany(company2);
    offerDTO.setDescription("The characteristics of someone or something");
    offerDTO.setDiplomaTypes(new HashSet<>());
    offerDTO.setDomains(new HashSet<>());
    offerDTO.setExpirationDate("2020-03-01");
    offerDTO.setLanguages(new HashSet<>());
    offerDTO.setOfferId(1);
    offerDTO.setOfferName("Offer Name");
    offerDTO.setPublicationDate("2020-03-01");
    offerDTO.setSalaryMax(10.0d);
    offerDTO.setSalaryMin(10.0d);
    when(offerMapper.mapToDto(Mockito.<Offer>any())).thenReturn(offerDTO);

    // Act
    OfferDTO actualFindResult = offerService.find(1);

    // Assert
    verify(offerMapper).mapToDto(Mockito.<Offer>any());
    verify(offerRepository).findById(Mockito.<Integer>any());
    assertSame(offerDTO, actualFindResult);
  }

  /**
  * Method under test: {@link OfferService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(offerRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = offerService.count();

    // Assert
    verify(offerRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link OfferService#findOffer(int)}
   */
  @Test
  void testFindOffer() {
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company);
    offer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    offer.setDescription("The characteristics of someone or something");
    offer.setDiplomaTypes(new HashSet<>());
    offer.setDomains(new HashSet<>());
    offer.setExpirationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setOfferId(1);
    offer.setOfferName("Offer Name");
    offer.setPublicationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setSalaryMax(10.0d);
    offer.setSalaryMin(10.0d);
    offer.setStudentLanguages(new HashSet<>());
    offer.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    offer.setUpdatedBy("2020-03-01");
    Optional<Offer> ofResult = Optional.of(offer);
    when(offerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Offer actualFindOfferResult = offerService.findOffer(1);

    // Assert
    verify(offerRepository).findById(Mockito.<Integer>any());
    assertSame(offer, actualFindOfferResult);
  }

  /**
   * Method under test: {@link OfferService#findByCompanyId(int)}
   */
  @Test
  void testFindByCompanyId() {
    // Arrange
    ArrayList<OfferDTO> offerDTOList = new ArrayList<>();
    when(offerRepository.findAllByCompanyCompanyId(anyInt())).thenReturn(offerDTOList);

    // Act
    List<OfferDTO> actualFindByCompanyIdResult = offerService.findByCompanyId(1);

    // Assert
    verify(offerRepository).findAllByCompanyCompanyId(anyInt());
    assertTrue(actualFindByCompanyIdResult.isEmpty());
    assertSame(offerDTOList, actualFindByCompanyIdResult);
  }
}

