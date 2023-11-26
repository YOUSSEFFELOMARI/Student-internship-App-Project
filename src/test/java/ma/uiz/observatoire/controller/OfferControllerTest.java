package ma.uiz.observatoire.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashSet;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.mapper.OfferMapperImpl;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.repository.OfferRepository;
import ma.uiz.observatoire.service.OfferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OfferController.class})
@ExtendWith(SpringExtension.class)
class OfferControllerTest {
  @Autowired
  private OfferController offerController;

  @MockBean
  private OfferService offerService;
  /**
  * Method under test: {@link OfferController#countOffer()}
  */
  @Test
  void testCountOffer() throws Exception {
    // Arrange
    when(offerService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/offers/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link OfferController#deleteOffer(int)}
   */
  @Test
  void testDeleteOffer() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    OfferRepository offerRepository = mock(OfferRepository.class);
    doNothing().when(offerRepository).deleteById(Mockito.<Integer>any());
    when(offerRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    ResponseEntity<Response> actualDeleteOfferResult = (new OfferController(
        new OfferService(offerRepository, new OfferMapperImpl()))).deleteOffer(1);

    // Assert
    verify(offerRepository).deleteById(Mockito.<Integer>any());
    verify(offerRepository).existsById(Mockito.<Integer>any());
    Response body = actualDeleteOfferResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("Offer successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteOfferResult.getStatusCodeValue());
    assertTrue(actualDeleteOfferResult.hasBody());
    assertTrue(actualDeleteOfferResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link OfferController#deleteOffer(int)}
   */
  @Test
  void testDeleteOffer2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    OfferService offerService = mock(OfferService.class);
    doNothing().when(offerService).delete(anyInt());

    // Act
    ResponseEntity<Response> actualDeleteOfferResult = (new OfferController(offerService)).deleteOffer(1);

    // Assert
    verify(offerService).delete(anyInt());
    Response body = actualDeleteOfferResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("Offer successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteOfferResult.getStatusCodeValue());
    assertTrue(actualDeleteOfferResult.hasBody());
    assertTrue(actualDeleteOfferResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link OfferController#displayAllOffer(int, int)}
   */
  @Test
  void testDisplayAllOffer() throws Exception {
    // Arrange
    when(offerService.showAllOffer(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/offers/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link OfferController#displayAllOffers()}
   */
  @Test
  void testDisplayAllOffers() throws Exception {
    // Arrange
    when(offerService.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/offers");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link OfferController#displayOffer(int)}
   */
  @Test
  void testDisplayOffer() throws Exception {
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
    when(offerService.find(anyInt())).thenReturn(offerDTO);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/offers/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<OfferDTO><offerId>1</offerId><offerName>Offer Name</offerName><description>The characteristics of"
                + " someone or something</description><assignmentCity>Assignment City</assignmentCity><salaryMin>10.0<"
                + "/salaryMin><salaryMax>10.0</salaryMax><publicationDate>2020-03-01</publicationDate><expirationDate"
                + ">2020-03-01</expirationDate><company><companyId>1</companyId><companyName>Company Name</companyName>"
                + "</company><diplomaTypes/><languages/><domains/></OfferDTO>"));
  }

  /**
   * Method under test: {@link OfferController#displayOffersOfCompany(int)}
   */
  @Test
  void testDisplayOffersOfCompany() throws Exception {
    // Arrange
    when(offerService.findByCompanyId(anyInt())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/offers/");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("companyId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link OfferController#saveOffer(OfferDTO)}
   */
  @Test
  void testSaveOffer() throws Exception {
    // Arrange
    when(offerService.findAll()).thenReturn(new ArrayList<>());

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
    String content = (new ObjectMapper()).writeValueAsString(offerDTO);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link OfferController#updateOffer(OfferDTO)}
   */
  @Test
  void testUpdateOffer() throws Exception {
    // Arrange
    when(offerService.findAll()).thenReturn(new ArrayList<>());

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
    String content = (new ObjectMapper()).writeValueAsString(offerDTO);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(offerController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }
}

