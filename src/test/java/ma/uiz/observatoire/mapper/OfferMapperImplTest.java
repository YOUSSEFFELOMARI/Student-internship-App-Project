package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.repository.DiplomaTypeRepository;
import ma.uiz.observatoire.repository.DomainRepository;
import ma.uiz.observatoire.repository.StudentDiplomaRepository;
import ma.uiz.observatoire.repository.StudentLanguageRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OfferMapperImpl.class})
@ExtendWith(SpringExtension.class)
class OfferMapperImplTest {
  @MockBean
  private ApplicationRepository applicationRepository;

  @MockBean
  private CompanyRepository companyRepository;

  @MockBean
  private DiplomaTypeRepository diplomaTypeRepository;

  @MockBean
  private DomainRepository domainRepository;

  @Autowired
  private OfferMapperImpl offerMapperImpl;

  @MockBean
  private StudentDiplomaRepository studentDiplomaRepository;

  @MockBean
  private StudentLanguageRepository studentLanguageRepository;

  @MockBean
  private StudentRepository studentRepository;
  /**
  * Method under test: {@link OfferMapperImpl#companyToCompanyDTO(Company)}
  */
  @Test
  void testCompanyToCompanyDTO() {
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

    // Act
    CompanyDTO actualCompanyToCompanyDTOResult = offerMapperImpl.companyToCompanyDTO(company);

    // Assert
    assertEquals("Company Name", actualCompanyToCompanyDTOResult.getCompanyName());
    assertEquals(1, actualCompanyToCompanyDTOResult.getCompanyId());
  }

  /**
   * Method under test: {@link OfferMapperImpl#companyToCompanyDTO(Company)}
   */
  @Test
  void testCompanyToCompanyDTO2() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    when(company.getCompanyId()).thenReturn(1);
    when(company.getCompanyName()).thenReturn("Company Name");
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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

    // Act
    CompanyDTO actualCompanyToCompanyDTOResult = offerMapperImpl.companyToCompanyDTO(company);

    // Assert
    verify(company).setAddress1(Mockito.<String>any());
    verify(company).setAddress2(Mockito.<String>any());
    verify(company).setCity(Mockito.<String>any());
    verify(company).setRegion(Mockito.<String>any());
    verify(company).setZipCode(Mockito.<String>any());
    verify(company).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(company).setCreatedBy(Mockito.<String>any());
    verify(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(company).setUpdatedBy(Mockito.<String>any());
    verify(company).getCompanyId();
    verify(company).getCompanyName();
    verify(company).setCompanyEmail(Mockito.<String>any());
    verify(company).setCompanyId(anyInt());
    verify(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    verify(company).setCompanyName(Mockito.<String>any());
    verify(company).setCompanyPhone(Mockito.<String>any());
    verify(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    verify(company).setCompanySiret(Mockito.<String>any());
    verify(company).setCompanyWebsite(Mockito.<String>any());
    verify(company).setDomains(Mockito.<Set<Domain>>any());
    verify(company).setImageUrl(Mockito.<String>any());
    assertEquals("Company Name", actualCompanyToCompanyDTOResult.getCompanyName());
    assertEquals(1, actualCompanyToCompanyDTOResult.getCompanyId());
  }

  /**
   * Method under test: {@link OfferMapperImpl#diplomaTypeSetToStringSet(Set)}
   */
  @Test
  void testDiplomaTypeSetToStringSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.diplomaTypeSetToStringSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#diplomaTypeSetToStringSet(Set)}
   */
  @Test
  void testDiplomaTypeSetToStringSet2() {
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

    HashSet<DiplomaType> set = new HashSet<>();
    set.add(diplomaType);

    // Act
    Set<String> actualDiplomaTypeSetToStringSetResult = offerMapperImpl.diplomaTypeSetToStringSet(set);

    // Assert
    assertEquals(1, actualDiplomaTypeSetToStringSetResult.size());
    assertTrue(actualDiplomaTypeSetToStringSetResult.contains("Diploma Type Name"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#diplomaTypeSetToStringSet(Set)}
   */
  @Test
  void testDiplomaTypeSetToStringSet3() {
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

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Created By");
    diplomaType2.setDiplomaAbbreviation("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setDiplomaLevel(Short.SIZE);
    diplomaType2.setDiplomaTypeId(2);
    diplomaType2.setDiplomaTypeName("ma.uiz.observatoire.model.DiplomaType");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020/03/01");

    HashSet<DiplomaType> set = new HashSet<>();
    set.add(diplomaType2);
    set.add(diplomaType);

    // Act
    Set<String> actualDiplomaTypeSetToStringSetResult = offerMapperImpl.diplomaTypeSetToStringSet(set);

    // Assert
    assertEquals(2, actualDiplomaTypeSetToStringSetResult.size());
    assertTrue(actualDiplomaTypeSetToStringSetResult.contains("Diploma Type Name"));
    assertTrue(actualDiplomaTypeSetToStringSetResult.contains("ma.uiz.observatoire.model.DiplomaType"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#diplomaTypeSetToStringSet(Set)}
   */
  @Test
  void testDiplomaTypeSetToStringSet4() {
    // Arrange
    DiplomaType diplomaType = mock(DiplomaType.class);
    when(diplomaType.getDiplomaTypeName()).thenReturn("Diploma Type Name");
    doNothing().when(diplomaType).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diplomaType).setCreatedBy(Mockito.<String>any());
    doNothing().when(diplomaType).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(diplomaType).setUpdatedBy(Mockito.<String>any());
    doNothing().when(diplomaType).setDiplomaAbbreviation(Mockito.<String>any());
    doNothing().when(diplomaType).setDiplomaLevel(anyInt());
    doNothing().when(diplomaType).setDiplomaTypeId(anyInt());
    doNothing().when(diplomaType).setDiplomaTypeName(Mockito.<String>any());
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

    HashSet<DiplomaType> set = new HashSet<>();
    set.add(diplomaType);

    // Act
    Set<String> actualDiplomaTypeSetToStringSetResult = offerMapperImpl.diplomaTypeSetToStringSet(set);

    // Assert
    verify(diplomaType).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(diplomaType).setCreatedBy(Mockito.<String>any());
    verify(diplomaType).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(diplomaType).setUpdatedBy(Mockito.<String>any());
    verify(diplomaType).getDiplomaTypeName();
    verify(diplomaType).setDiplomaAbbreviation(Mockito.<String>any());
    verify(diplomaType).setDiplomaLevel(anyInt());
    verify(diplomaType).setDiplomaTypeId(anyInt());
    verify(diplomaType).setDiplomaTypeName(Mockito.<String>any());
    assertEquals(1, actualDiplomaTypeSetToStringSetResult.size());
    assertTrue(actualDiplomaTypeSetToStringSetResult.contains("Diploma Type Name"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#domainSetToStringSet(Set)}
   */
  @Test
  void testDomainSetToStringSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.domainSetToStringSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#domainSetToStringSet(Set)}
   */
  @Test
  void testDomainSetToStringSet2() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    HashSet<Domain> set = new HashSet<>();
    set.add(domain);

    // Act
    Set<String> actualDomainSetToStringSetResult = offerMapperImpl.domainSetToStringSet(set);

    // Assert
    assertEquals(1, actualDomainSetToStringSetResult.size());
    assertTrue(actualDomainSetToStringSetResult.contains("Domain Name"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#domainSetToStringSet(Set)}
   */
  @Test
  void testDomainSetToStringSet3() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Created By");
    domain2.setDomainId(2);
    domain2.setDomainName("ma.uiz.observatoire.model.Domain");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020/03/01");

    HashSet<Domain> set = new HashSet<>();
    set.add(domain2);
    set.add(domain);

    // Act
    Set<String> actualDomainSetToStringSetResult = offerMapperImpl.domainSetToStringSet(set);

    // Assert
    assertEquals(2, actualDomainSetToStringSetResult.size());
    assertTrue(actualDomainSetToStringSetResult.contains("Domain Name"));
    assertTrue(actualDomainSetToStringSetResult.contains("ma.uiz.observatoire.model.Domain"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#domainSetToStringSet(Set)}
   */
  @Test
  void testDomainSetToStringSet4() {
    // Arrange
    Domain domain = mock(Domain.class);
    when(domain.getDomainName()).thenReturn("Domain Name");
    doNothing().when(domain).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(domain).setCreatedBy(Mockito.<String>any());
    doNothing().when(domain).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(domain).setUpdatedBy(Mockito.<String>any());
    doNothing().when(domain).setDomainId(anyInt());
    doNothing().when(domain).setDomainName(Mockito.<String>any());
    doNothing().when(domain).setSpecialities(Mockito.<Set<Speciality>>any());
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");

    HashSet<Domain> set = new HashSet<>();
    set.add(domain);

    // Act
    Set<String> actualDomainSetToStringSetResult = offerMapperImpl.domainSetToStringSet(set);

    // Assert
    verify(domain).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(domain).setCreatedBy(Mockito.<String>any());
    verify(domain).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(domain).setUpdatedBy(Mockito.<String>any());
    verify(domain).getDomainName();
    verify(domain).setDomainId(anyInt());
    verify(domain).setDomainName(Mockito.<String>any());
    verify(domain).setSpecialities(Mockito.<Set<Speciality>>any());
    assertEquals(1, actualDomainSetToStringSetResult.size());
    assertTrue(actualDomainSetToStringSetResult.contains("Domain Name"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#mapToDto(Offer)}
   */
  @Test
  void testMapToDto() {
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

    // Act
    OfferDTO actualMapToDtoResult = offerMapperImpl.mapToDto(offer);

    // Assert
    assertEquals("Assignment City", actualMapToDtoResult.getAssignmentCity());
    CompanyDTO company2 = actualMapToDtoResult.getCompany();
    assertEquals("Company Name", company2.getCompanyName());
    assertEquals("Offer Name", actualMapToDtoResult.getOfferName());
    assertEquals("The characteristics of someone or something", actualMapToDtoResult.getDescription());
    assertEquals(1, company2.getCompanyId());
    assertEquals(1, actualMapToDtoResult.getOfferId());
    assertEquals(10.0d, actualMapToDtoResult.getSalaryMax());
    assertEquals(10.0d, actualMapToDtoResult.getSalaryMin());
    assertTrue(actualMapToDtoResult.getDiplomaTypes().isEmpty());
    assertTrue(actualMapToDtoResult.getDomains().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#mapToDto(Offer)}
   */
  @Test
  void testMapToDto2() {
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
    Offer offer = mock(Offer.class);
    when(offer.getSalaryMax()).thenReturn(10.0d);
    when(offer.getSalaryMin()).thenReturn(10.0d);
    when(offer.getOfferId()).thenReturn(1);
    when(offer.getAssignmentCity()).thenReturn("Assignment City");
    when(offer.getDescription()).thenReturn("The characteristics of someone or something");
    when(offer.getOfferName()).thenReturn("Offer Name");
    when(offer.getExpirationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offer.getPublicationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offer.getApplications()).thenReturn(new HashSet<>());
    when(offer.getDiplomaTypes()).thenReturn(new HashSet<>());
    when(offer.getDomains()).thenReturn(new HashSet<>());
    when(offer.getStudentLanguages()).thenReturn(new HashSet<>());
    when(offer.getCompany()).thenReturn(company2);
    doNothing().when(offer).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer).setCreatedBy(Mockito.<String>any());
    doNothing().when(offer).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(offer).setUpdatedBy(Mockito.<String>any());
    doNothing().when(offer).setApplications(Mockito.<Set<Application>>any());
    doNothing().when(offer).setAssignmentCity(Mockito.<String>any());
    doNothing().when(offer).setCompany(Mockito.<Company>any());
    doNothing().when(offer).setDescription(Mockito.<String>any());
    doNothing().when(offer).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    doNothing().when(offer).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(offer).setExpirationDate(Mockito.<Date>any());
    doNothing().when(offer).setOfferId(anyInt());
    doNothing().when(offer).setOfferName(Mockito.<String>any());
    doNothing().when(offer).setPublicationDate(Mockito.<Date>any());
    doNothing().when(offer).setSalaryMax(anyDouble());
    doNothing().when(offer).setSalaryMin(anyDouble());
    doNothing().when(offer).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
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

    // Act
    OfferDTO actualMapToDtoResult = offerMapperImpl.mapToDto(offer);

    // Assert
    verify(offer).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(offer).setCreatedBy(Mockito.<String>any());
    verify(offer).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(offer).setUpdatedBy(Mockito.<String>any());
    verify(offer).getApplications();
    verify(offer).getAssignmentCity();
    verify(offer).getCompany();
    verify(offer).getDescription();
    verify(offer).getDiplomaTypes();
    verify(offer).getDomains();
    verify(offer).getExpirationDate();
    verify(offer).getOfferId();
    verify(offer).getOfferName();
    verify(offer).getPublicationDate();
    verify(offer).getSalaryMax();
    verify(offer).getSalaryMin();
    verify(offer).getStudentLanguages();
    verify(offer).setApplications(Mockito.<Set<Application>>any());
    verify(offer).setAssignmentCity(Mockito.<String>any());
    verify(offer).setCompany(Mockito.<Company>any());
    verify(offer).setDescription(Mockito.<String>any());
    verify(offer).setDiplomaTypes(Mockito.<Set<DiplomaType>>any());
    verify(offer).setDomains(Mockito.<Set<Domain>>any());
    verify(offer).setExpirationDate(Mockito.<Date>any());
    verify(offer).setOfferId(anyInt());
    verify(offer).setOfferName(Mockito.<String>any());
    verify(offer).setPublicationDate(Mockito.<Date>any());
    verify(offer).setSalaryMax(anyDouble());
    verify(offer).setSalaryMin(anyDouble());
    verify(offer).setStudentLanguages(Mockito.<Set<StudentLanguage>>any());
    assertEquals("Assignment City", actualMapToDtoResult.getAssignmentCity());
    CompanyDTO company3 = actualMapToDtoResult.getCompany();
    assertEquals("Company Name", company3.getCompanyName());
    assertEquals("Offer Name", actualMapToDtoResult.getOfferName());
    assertEquals("The characteristics of someone or something", actualMapToDtoResult.getDescription());
    assertEquals(1, company3.getCompanyId());
    assertEquals(1, actualMapToDtoResult.getOfferId());
    assertEquals(10.0d, actualMapToDtoResult.getSalaryMax());
    assertEquals(10.0d, actualMapToDtoResult.getSalaryMin());
    assertTrue(actualMapToDtoResult.getDiplomaTypes().isEmpty());
    assertTrue(actualMapToDtoResult.getDomains().isEmpty());
    assertTrue(actualMapToDtoResult.getLanguages().isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#mapToModel(OfferDTO)}
   */
  @Test
  void testMapToModel() {
    // Arrange
    CompanyDTO company = new CompanyDTO();
    company.setCompanyId(1);
    company.setCompanyName("Company Name");

    OfferDTO offerDTO = new OfferDTO();
    offerDTO.setAssignmentCity("Assignment City");
    offerDTO.setCompany(company);
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

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerMapperImpl.mapToModel(offerDTO));
  }

  /**
   * Method under test: {@link OfferMapperImpl#mapToModel(OfferDTO)}
   */
  @Test
  void testMapToModel2() {
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
    when(studentLanguageRepository.findByLanguageName(Mockito.<String>any())).thenReturn(ofResult);

    CompanyDTO company = new CompanyDTO();
    company.setCompanyId(1);
    company.setCompanyName("Company Name");

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("yyyy-MM-dd HH:mm");
    OfferDTO offerDTO = mock(OfferDTO.class);
    when(offerDTO.getSalaryMax()).thenReturn(10.0d);
    when(offerDTO.getSalaryMin()).thenReturn(10.0d);
    when(offerDTO.getOfferId()).thenReturn(1);
    when(offerDTO.getAssignmentCity()).thenReturn("Assignment City");
    when(offerDTO.getDescription()).thenReturn("The characteristics of someone or something");
    when(offerDTO.getOfferName()).thenReturn("Offer Name");
    when(offerDTO.getPublicationDate()).thenReturn("2020-03-01");
    when(offerDTO.getLanguages()).thenReturn(stringSet);
    doNothing().when(offerDTO).setAssignmentCity(Mockito.<String>any());
    doNothing().when(offerDTO).setCompany(Mockito.<CompanyDTO>any());
    doNothing().when(offerDTO).setDescription(Mockito.<String>any());
    doNothing().when(offerDTO).setDiplomaTypes(Mockito.<Set<String>>any());
    doNothing().when(offerDTO).setDomains(Mockito.<Set<String>>any());
    doNothing().when(offerDTO).setExpirationDate(Mockito.<String>any());
    doNothing().when(offerDTO).setLanguages(Mockito.<Set<String>>any());
    doNothing().when(offerDTO).setOfferId(anyInt());
    doNothing().when(offerDTO).setOfferName(Mockito.<String>any());
    doNothing().when(offerDTO).setPublicationDate(Mockito.<String>any());
    doNothing().when(offerDTO).setSalaryMax(anyDouble());
    doNothing().when(offerDTO).setSalaryMin(anyDouble());
    offerDTO.setAssignmentCity("Assignment City");
    offerDTO.setCompany(company);
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

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerMapperImpl.mapToModel(offerDTO));
    verify(offerDTO).getAssignmentCity();
    verify(offerDTO).getDescription();
    verify(offerDTO).getLanguages();
    verify(offerDTO).getOfferId();
    verify(offerDTO).getOfferName();
    verify(offerDTO).getPublicationDate();
    verify(offerDTO).getSalaryMax();
    verify(offerDTO).getSalaryMin();
    verify(offerDTO).setAssignmentCity(Mockito.<String>any());
    verify(offerDTO).setCompany(Mockito.<CompanyDTO>any());
    verify(offerDTO).setDescription(Mockito.<String>any());
    verify(offerDTO).setDiplomaTypes(Mockito.<Set<String>>any());
    verify(offerDTO).setDomains(Mockito.<Set<String>>any());
    verify(offerDTO).setExpirationDate(Mockito.<String>any());
    verify(offerDTO).setLanguages(Mockito.<Set<String>>any());
    verify(offerDTO).setOfferId(anyInt());
    verify(offerDTO).setOfferName(Mockito.<String>any());
    verify(offerDTO).setPublicationDate(Mockito.<String>any());
    verify(offerDTO).setSalaryMax(anyDouble());
    verify(offerDTO).setSalaryMin(anyDouble());
    verify(studentLanguageRepository).findByLanguageName(Mockito.<String>any());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDiplomaTypeSet(Set)}
   */
  @Test
  void testStringSetToDiplomaTypeSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.stringSetToDiplomaTypeSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDiplomaTypeSet(Set)}
   */
  @Test
  void testStringSetToDiplomaTypeSet2() {
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
    when(diplomaTypeRepository.findByDiplomaTypeName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("foo");

    // Act
    Set<DiplomaType> actualStringSetToDiplomaTypeSetResult = offerMapperImpl.stringSetToDiplomaTypeSet(set);

    // Assert
    verify(diplomaTypeRepository).findByDiplomaTypeName(Mockito.<String>any());
    assertEquals(1, actualStringSetToDiplomaTypeSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDiplomaTypeSet(Set)}
   */
  @Test
  void testStringSetToDiplomaTypeSet3() {
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
    when(diplomaTypeRepository.findByDiplomaTypeName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("42");
    set.add("foo");

    // Act
    Set<DiplomaType> actualStringSetToDiplomaTypeSetResult = offerMapperImpl.stringSetToDiplomaTypeSet(set);

    // Assert
    verify(diplomaTypeRepository, atLeast(1)).findByDiplomaTypeName(Mockito.<String>any());
    assertEquals(1, actualStringSetToDiplomaTypeSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDomainSet(Set)}
   */
  @Test
  void testStringSetToDomainSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.stringSetToDomainSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDomainSet(Set)}
   */
  @Test
  void testStringSetToDomainSet2() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    Optional<Domain> ofResult = Optional.of(domain);
    when(domainRepository.findByDomainName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("foo");

    // Act
    Set<Domain> actualStringSetToDomainSetResult = offerMapperImpl.stringSetToDomainSet(set);

    // Assert
    verify(domainRepository).findByDomainName(Mockito.<String>any());
    assertEquals(1, actualStringSetToDomainSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToDomainSet(Set)}
   */
  @Test
  void testStringSetToDomainSet3() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    Optional<Domain> ofResult = Optional.of(domain);
    when(domainRepository.findByDomainName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("42");
    set.add("foo");

    // Act
    Set<Domain> actualStringSetToDomainSetResult = offerMapperImpl.stringSetToDomainSet(set);

    // Assert
    verify(domainRepository, atLeast(1)).findByDomainName(Mockito.<String>any());
    assertEquals(1, actualStringSetToDomainSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToStudentLanguageSet(Set)}
   */
  @Test
  void testStringSetToStudentLanguageSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.stringSetToStudentLanguageSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToStudentLanguageSet(Set)}
   */
  @Test
  void testStringSetToStudentLanguageSet2() {
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
    when(studentLanguageRepository.findByLanguageName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("foo");

    // Act
    Set<StudentLanguage> actualStringSetToStudentLanguageSetResult = offerMapperImpl.stringSetToStudentLanguageSet(set);

    // Assert
    verify(studentLanguageRepository).findByLanguageName(Mockito.<String>any());
    assertEquals(1, actualStringSetToStudentLanguageSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#stringSetToStudentLanguageSet(Set)}
   */
  @Test
  void testStringSetToStudentLanguageSet3() {
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
    when(studentLanguageRepository.findByLanguageName(Mockito.<String>any())).thenReturn(ofResult);

    HashSet<String> set = new HashSet<>();
    set.add("42");
    set.add("foo");

    // Act
    Set<StudentLanguage> actualStringSetToStudentLanguageSetResult = offerMapperImpl.stringSetToStudentLanguageSet(set);

    // Assert
    verify(studentLanguageRepository, atLeast(1)).findByLanguageName(Mockito.<String>any());
    assertEquals(1, actualStringSetToStudentLanguageSetResult.size());
  }

  /**
   * Method under test: {@link OfferMapperImpl#studentLanguageSetToStringSet(Set)}
   */
  @Test
  void testStudentLanguageSetToStringSet() {
    // Arrange, Act and Assert
    assertTrue(offerMapperImpl.studentLanguageSetToStringSet(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link OfferMapperImpl#studentLanguageSetToStringSet(Set)}
   */
  @Test
  void testStudentLanguageSetToStringSet2() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage);

    // Act
    Set<String> actualStudentLanguageSetToStringSetResult = offerMapperImpl.studentLanguageSetToStringSet(set);

    // Assert
    assertEquals(1, actualStudentLanguageSetToStringSetResult.size());
    assertTrue(actualStudentLanguageSetToStringSetResult.contains("en"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#studentLanguageSetToStringSet(Set)}
   */
  @Test
  void testStudentLanguageSetToStringSet3() {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    StudentLanguage studentLanguage2 = new StudentLanguage();
    studentLanguage2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setCreatedBy("Created By");
    studentLanguage2.setLanguageId(2);
    studentLanguage2.setLanguageLevel(Short.SIZE);
    studentLanguage2.setLanguageName("eng");
    studentLanguage2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage2.setUpdatedBy("2020/03/01");

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage2);
    set.add(studentLanguage);

    // Act
    Set<String> actualStudentLanguageSetToStringSetResult = offerMapperImpl.studentLanguageSetToStringSet(set);

    // Assert
    assertEquals(2, actualStudentLanguageSetToStringSetResult.size());
    assertTrue(actualStudentLanguageSetToStringSetResult.contains("en"));
    assertTrue(actualStudentLanguageSetToStringSetResult.contains("eng"));
  }

  /**
   * Method under test: {@link OfferMapperImpl#studentLanguageSetToStringSet(Set)}
   */
  @Test
  void testStudentLanguageSetToStringSet4() {
    // Arrange
    StudentLanguage studentLanguage = mock(StudentLanguage.class);
    when(studentLanguage.getLanguageName()).thenReturn("en");
    doNothing().when(studentLanguage).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLanguage).setCreatedBy(Mockito.<String>any());
    doNothing().when(studentLanguage).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(studentLanguage).setUpdatedBy(Mockito.<String>any());
    doNothing().when(studentLanguage).setLanguageId(anyInt());
    doNothing().when(studentLanguage).setLanguageLevel(anyInt());
    doNothing().when(studentLanguage).setLanguageName(Mockito.<String>any());
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");

    HashSet<StudentLanguage> set = new HashSet<>();
    set.add(studentLanguage);

    // Act
    Set<String> actualStudentLanguageSetToStringSetResult = offerMapperImpl.studentLanguageSetToStringSet(set);

    // Assert
    verify(studentLanguage).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setCreatedBy(Mockito.<String>any());
    verify(studentLanguage).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(studentLanguage).setUpdatedBy(Mockito.<String>any());
    verify(studentLanguage).getLanguageName();
    verify(studentLanguage).setLanguageId(anyInt());
    verify(studentLanguage).setLanguageLevel(anyInt());
    verify(studentLanguage).setLanguageName(Mockito.<String>any());
    assertEquals(1, actualStudentLanguageSetToStringSetResult.size());
    assertTrue(actualStudentLanguageSetToStringSetResult.contains("en"));
  }
}

