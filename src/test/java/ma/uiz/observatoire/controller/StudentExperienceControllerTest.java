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
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.StudentExperience;
import ma.uiz.observatoire.repository.StudentExperienceRepository;
import ma.uiz.observatoire.service.StudentExperienceService;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentExperienceController.class})
@ExtendWith(SpringExtension.class)
class StudentExperienceControllerTest {
  @Autowired
  private StudentExperienceController studentExperienceController;

  @MockBean
  private StudentExperienceService studentExperienceService;
  /**
  * Method under test: {@link StudentExperienceController#countStudentExperience()}
  */
  @Test
  void testCountStudentExperience() throws Exception {
    // Arrange
    when(studentExperienceService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link StudentExperienceController#deleteStudentExperience(int)}
   */
  @Test
  void testDeleteStudentExperience() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    StudentExperienceRepository studentExperienceRepository = mock(StudentExperienceRepository.class);
    doNothing().when(studentExperienceRepository).deleteById(Mockito.<Integer>any());
    when(studentExperienceRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    ResponseEntity<Response> actualDeleteStudentExperienceResult = (new StudentExperienceController(
        new StudentExperienceService(studentExperienceRepository))).deleteStudentExperience(1);

    // Assert
    verify(studentExperienceRepository).deleteById(Mockito.<Integer>any());
    verify(studentExperienceRepository).existsById(Mockito.<Integer>any());
    Response body = actualDeleteStudentExperienceResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("StudentExperience successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteStudentExperienceResult.getStatusCodeValue());
    assertTrue(actualDeleteStudentExperienceResult.hasBody());
    assertTrue(actualDeleteStudentExperienceResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link StudentExperienceController#deleteStudentExperience(int)}
   */
  @Test
  void testDeleteStudentExperience2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    StudentExperienceService studentExperienceService = mock(StudentExperienceService.class);
    doNothing().when(studentExperienceService).delete(anyInt());

    // Act
    ResponseEntity<Response> actualDeleteStudentExperienceResult = (new StudentExperienceController(
        studentExperienceService)).deleteStudentExperience(1);

    // Assert
    verify(studentExperienceService).delete(anyInt());
    Response body = actualDeleteStudentExperienceResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("StudentExperience successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteStudentExperienceResult.getStatusCodeValue());
    assertTrue(actualDeleteStudentExperienceResult.hasBody());
    assertTrue(actualDeleteStudentExperienceResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link StudentExperienceController#displayAllStudentExperience(int, int)}
   */
  @Test
  void testDisplayAllStudentExperience() throws Exception {
    // Arrange
    when(studentExperienceService.showAllStudentExperience(anyInt(), anyInt()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/studentExperiences/page/{pageNum}",
        10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link StudentExperienceController#displayStudentExperience(int)}
   */
  @Test
  void testDisplayStudentExperience() throws Exception {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    when(studentExperienceService.find(anyInt())).thenReturn(studentExperience);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "<StudentExperience><experienceDescription>Experience Description</experienceDescription><startDate>0"
                    + "</startDate><endDate>0</endDate><key>1</key></StudentExperience>"));
  }

  /**
   * Method under test: {@link StudentExperienceController#saveStudentExperience(StudentExperience)}
   */
  @Test
  void testSaveStudentExperience() throws Exception {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentExperience);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link StudentExperienceController#saveStudentExperience(StudentExperience)}
   */
  @Test
  void testSaveStudentExperience2() throws Exception {
    // Arrange
    java.sql.Date endDate = mock(java.sql.Date.class);
    when(endDate.getTime()).thenReturn(10L);

    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(endDate);
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentExperience);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link StudentExperienceController#updateStudentExperience(StudentExperience)}
   */
  @Test
  void testUpdateStudentExperience() throws Exception {
    // Arrange
    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentExperience);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link StudentExperienceController#updateStudentExperience(StudentExperience)}
   */
  @Test
  void testUpdateStudentExperience2() throws Exception {
    // Arrange
    java.sql.Date endDate = mock(java.sql.Date.class);
    when(endDate.getTime()).thenReturn(10L);

    StudentExperience studentExperience = new StudentExperience();
    studentExperience.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentExperience.setEndDate(endDate);
    studentExperience.setExperienceDescription("Experience Description");
    studentExperience.setExperienceId(1);
    studentExperience
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    studentExperience.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentExperience.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentExperience);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentExperiences")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentExperienceController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }
}

