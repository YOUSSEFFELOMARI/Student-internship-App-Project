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
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.repository.StudentHobbyRepository;
import ma.uiz.observatoire.service.StudentHobbyService;
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

@ContextConfiguration(classes = {StudentHobbyController.class})
@ExtendWith(SpringExtension.class)
class StudentHobbyControllerTest {
  @Autowired
  private StudentHobbyController studentHobbyController;

  @MockBean
  private StudentHobbyService studentHobbyService;
  /**
  * Method under test: {@link StudentHobbyController#countStudentHobby()}
  */
  @Test
  void testCountStudentHobby() throws Exception {
    // Arrange
    when(studentHobbyService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentHobbies/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentHobbyController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link StudentHobbyController#deleteStudentHobby(int)}
   */
  @Test
  void testDeleteStudentHobby() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    StudentHobbyRepository studentHobbyRepository = mock(StudentHobbyRepository.class);
    doNothing().when(studentHobbyRepository).deleteById(Mockito.<Integer>any());
    when(studentHobbyRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    ResponseEntity<Response> actualDeleteStudentHobbyResult = (new StudentHobbyController(
        new StudentHobbyService(studentHobbyRepository))).deleteStudentHobby(1);

    // Assert
    verify(studentHobbyRepository).deleteById(Mockito.<Integer>any());
    verify(studentHobbyRepository).existsById(Mockito.<Integer>any());
    Response body = actualDeleteStudentHobbyResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("StudentHobby successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteStudentHobbyResult.getStatusCodeValue());
    assertTrue(actualDeleteStudentHobbyResult.hasBody());
    assertTrue(actualDeleteStudentHobbyResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link StudentHobbyController#deleteStudentHobby(int)}
   */
  @Test
  void testDeleteStudentHobby2() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    StudentHobbyService studentHobbyService = mock(StudentHobbyService.class);
    doNothing().when(studentHobbyService).delete(anyInt());

    // Act
    ResponseEntity<Response> actualDeleteStudentHobbyResult = (new StudentHobbyController(studentHobbyService))
        .deleteStudentHobby(1);

    // Assert
    verify(studentHobbyService).delete(anyInt());
    Response body = actualDeleteStudentHobbyResult.getBody();
    assertEquals("204", body.getStatusCode());
    assertEquals("StudentHobby successfully deleted", body.getStatusMsg());
    assertEquals(204, actualDeleteStudentHobbyResult.getStatusCodeValue());
    assertTrue(actualDeleteStudentHobbyResult.hasBody());
    assertTrue(actualDeleteStudentHobbyResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link StudentHobbyController#displayAllStudentHobby(int, int)}
   */
  @Test
  void testDisplayAllStudentHobby() throws Exception {
    // Arrange
    when(studentHobbyService.showAllStudentHobby(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/studentHobbies/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentHobbyController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link StudentHobbyController#displayStudentHobby(int)}
   */
  @Test
  void testDisplayStudentHobby() throws Exception {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");
    when(studentHobbyService.find(anyInt())).thenReturn(studentHobby);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentHobbies/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentHobbyController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<StudentHobby><hobbiesName>Hobbies Name</hobbiesName><key>1</key></StudentHobby>"));
  }

  /**
   * Method under test: {@link StudentHobbyController#saveStudentHobby(StudentHobby)}
   */
  @Test
  void testSaveStudentHobby() throws Exception {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentHobby);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentHobbies")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentHobbyController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link StudentHobbyController#updateStudentHobby(StudentHobby)}
   */
  @Test
  void testUpdateStudentHobby() throws Exception {
    // Arrange
    StudentHobby studentHobby = new StudentHobby();
    studentHobby.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentHobby.setHobbiesName("Hobbies Name");
    studentHobby.setHobbyId(1);
    studentHobby.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentHobby.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentHobby);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentHobbies")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentHobbyController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }
}

