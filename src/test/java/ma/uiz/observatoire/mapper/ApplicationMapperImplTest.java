package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import ma.uiz.observatoire.dto.ApplicationDTO;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ApplicationMapperImpl.class})
@ExtendWith(SpringExtension.class)
class ApplicationMapperImplTest {
  @Autowired
  private ApplicationMapperImpl applicationMapperImpl;

  @MockBean
  private OfferMapper offerMapper;

  @MockBean
  private StudentMapper studentMapper;
  /**
  * Method under test: {@link ApplicationMapperImpl#mapToDto(Application)}
  */
  @Test
  void testMapToDto() {
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
    when(offerMapper.mapToDto(Mockito.<Offer>any())).thenReturn(offerDTO);

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenReturn(studentDTO);

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(new CompanyLegalForm());
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

    Offer offer = new Offer();
    offer.setApplications(new HashSet<>());
    offer.setAssignmentCity("Assignment City");
    offer.setCompany(company2);
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

    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

    Application.ApplicationPk applicationPk = new Application.ApplicationPk();
    applicationPk.setOffer(offer);
    applicationPk.setStudent(student);

    Application app = new Application();
    Date applicationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    app.setApplicationDate(applicationDate);
    app.setApplicationPk(applicationPk);
    app.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    app.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    app.setStatus(Application.AppStatus.VALIDATED);
    app.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    app.setUpdatedBy("2020-03-01");

    // Act
    ApplicationDTO actualMapToDtoResult = applicationMapperImpl.mapToDto(app);

    // Assert
    verify(offerMapper).mapToDto(Mockito.<Offer>any());
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    assertEquals(Application.AppStatus.VALIDATED, actualMapToDtoResult.getStatus());
    assertSame(offerDTO, actualMapToDtoResult.getOffer());
    assertSame(studentDTO, actualMapToDtoResult.getStudent());
    assertSame(applicationDate, actualMapToDtoResult.getApplicationDate());
  }
}

