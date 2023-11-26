package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.service.DiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DiplomaController.class})
@ExtendWith(SpringExtension.class)
class DiplomaControllerTest {
  @Autowired
  private DiplomaController diplomaController;

  @MockBean
  private DiplomaService diplomaService;
  /**
  * Method under test: {@link DiplomaController#countDiploma()}
  */
  @Test
  void testCountDiploma() throws Exception {
    // Arrange
    when(diplomaService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomas/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link DiplomaController#displayAllDiploma(int, int)}
   */
  @Test
  void testDisplayAllDiploma() throws Exception {
    // Arrange
    when(diplomaService.showAllDiploma(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/diplomas/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DiplomaController#displayDiploma(int)}
   */
  @Test
  void testDisplayDiploma() throws Exception {
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

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");
    when(diplomaService.find(anyInt())).thenReturn(diploma);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomas/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "<Diploma><diplomaName>Diploma Name</diplomaName><establishment><establishmentTitle>Dr</establishmentTitle"
                    + "><establishmentPhone>6625550144</establishmentPhone><establishmentEmail>jane.doe@example.org<"
                    + "/establishmentEmail><establishmentWebSite>Establishment Web Site</establishmentWebSite><university>"
                    + "<address1>42 Main St</address1><address2>42 Main St</address2><city>Oxford</city><region>us-east-2<"
                    + "/region><zipCode>21654</zipCode><universityTitle>Dr</universityTitle><universityPhone>6625550144<"
                    + "/universityPhone><universityEmail>jane.doe@example.org</universityEmail><universityWebsite>University"
                    + " Website</universityWebsite><imageUrl>https://example.org/example</imageUrl><key>1</key></university"
                    + "><imageUrl>https://example.org/example</imageUrl><key>1</key></establishment><diplomaType><diplomaTypeName"
                    + ">Diploma Type Name</diplomaTypeName><diplomaLevel>1</diplomaLevel><diplomaAbbreviation>Diploma"
                    + " Abbreviation</diplomaAbbreviation><key>1</key></diplomaType><specialities/><key>1</key></Diploma>"));
  }

  /**
   * Method under test: {@link DiplomaController#saveDiploma(Diploma)}
   */
  @Test
  void testSaveDiploma() throws Exception {
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

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(diploma);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomas")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(diplomaController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link DiplomaController#updateDiploma(Diploma)}
   */
  @Test
  void testUpdateDiploma() throws Exception {
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

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(diploma);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomas")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(diplomaController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }
}

