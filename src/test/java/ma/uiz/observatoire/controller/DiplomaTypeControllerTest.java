package ma.uiz.observatoire.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.repository.DiplomaTypeRepository;
import ma.uiz.observatoire.service.DiplomaTypeService;
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

@ContextConfiguration(classes = {DiplomaTypeController.class})
@ExtendWith(SpringExtension.class)
class DiplomaTypeControllerTest {
  @Autowired
  private DiplomaTypeController diplomaTypeController;

  @MockBean
  private DiplomaTypeService diplomaTypeService;
  /**
  * Method under test: {@link DiplomaTypeController#countDiplomaType()}
  */
  @Test
  void testCountDiplomaType() throws Exception {
    // Arrange
    when(diplomaTypeService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomaType/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link DiplomaTypeController#deleteDiplomaType(int)}
   */
  @Test
  void testDeleteDiplomaType() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    DiplomaTypeRepository diplomaTypeRepository = mock(DiplomaTypeRepository.class);
    doNothing().when(diplomaTypeRepository).deleteById(Mockito.<Integer>any());
    when(diplomaTypeRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    ResponseEntity<Response> actualDeleteDiplomaTypeResult = (new DiplomaTypeController(
        new DiplomaTypeService(diplomaTypeRepository))).deleteDiplomaType(1);

    // Assert
    verify(diplomaTypeRepository).deleteById(Mockito.<Integer>any());
    verify(diplomaTypeRepository).existsById(Mockito.<Integer>any());
    Response body = actualDeleteDiplomaTypeResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("DiplomaType successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteDiplomaTypeResult.getStatusCodeValue());
    assertTrue(actualDeleteDiplomaTypeResult.hasBody());
    assertTrue(actualDeleteDiplomaTypeResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link DiplomaTypeController#deleteDiplomaType(int)}
   */
  @Test
  void testDeleteDiplomaType2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    DiplomaTypeService diplomaTypeService = mock(DiplomaTypeService.class);
    doNothing().when(diplomaTypeService).delete(anyInt());

    // Act
    ResponseEntity<Response> actualDeleteDiplomaTypeResult = (new DiplomaTypeController(diplomaTypeService))
        .deleteDiplomaType(1);

    // Assert
    verify(diplomaTypeService).delete(anyInt());
    Response body = actualDeleteDiplomaTypeResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("DiplomaType successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteDiplomaTypeResult.getStatusCodeValue());
    assertTrue(actualDeleteDiplomaTypeResult.hasBody());
    assertTrue(actualDeleteDiplomaTypeResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link DiplomaTypeController#displayAllDiplomaType()}
   */
  @Test
  void testDisplayAllDiplomaType() throws Exception {
    // Arrange
    when(diplomaTypeService.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomaType");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DiplomaTypeController#displayAllDiplomaType(int, int)}
   */
  @Test
  void testDisplayAllDiplomaType2() throws Exception {
    // Arrange
    when(diplomaTypeService.showAllDiplomaType(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/diplomaType/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DiplomaTypeController#displayDiplomaType(int)}
   */
  @Test
  void testDisplayDiplomaType() throws Exception {
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
    when(diplomaTypeService.find(anyInt())).thenReturn(diplomaType);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomaType/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<DiplomaType><diplomaTypeName>Diploma Type Name</diplomaTypeName><diplomaLevel>1</diplomaLevel>"
                + "<diplomaAbbreviation>Diploma Abbreviation</diplomaAbbreviation><key>1</key></DiplomaType>"));
  }

  /**
   * Method under test: {@link DiplomaTypeController#saveDiplomaType(DiplomaType)}
   */
  @Test
  void testSaveDiplomaType() throws Exception {
    // Arrange
    when(diplomaTypeService.findAll()).thenReturn(new ArrayList<>());

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(diplomaType);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomaType")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DiplomaTypeController#updateDiplomaType(DiplomaType)}
   */
  @Test
  void testUpdateDiplomaType() throws Exception {
    // Arrange
    when(diplomaTypeService.findAll()).thenReturn(new ArrayList<>());

    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(diplomaType);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/diplomaType")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(diplomaTypeController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }
}

