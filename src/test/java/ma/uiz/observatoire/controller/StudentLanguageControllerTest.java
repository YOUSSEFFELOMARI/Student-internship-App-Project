package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.service.StudentLanguageService;
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

@ContextConfiguration(classes = {StudentLanguageController.class})
@ExtendWith(SpringExtension.class)
class StudentLanguageControllerTest {
  @Autowired
  private StudentLanguageController studentLanguageController;

  @MockBean
  private StudentLanguageService studentLanguageService;
  /**
  * Method under test: {@link StudentLanguageController#countStudentLanguage()}
  */
  @Test
  void testCountStudentLanguage() throws Exception {
    // Arrange
    when(studentLanguageService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentLanguages/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentLanguageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link StudentLanguageController#displayAllStudentLanguage(int, int)}
   */
  @Test
  void testDisplayAllStudentLanguage() throws Exception {
    // Arrange
    when(studentLanguageService.showAllStudentLanguage(anyInt(), anyInt()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/studentLanguages/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentLanguageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link StudentLanguageController#displayStudentLanguage(int)}
   */
  @Test
  void testDisplayStudentLanguage() throws Exception {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    when(studentLanguageService.find(anyInt())).thenReturn(studentLanguage);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentLanguages/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(studentLanguageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<StudentLanguage><languageName>en</languageName><languageLevel>1</languageLevel><key>1</key><"
                + "/StudentLanguage>"));
  }

  /**
   * Method under test: {@link StudentLanguageController#saveStudentLanguage(StudentLanguage)}
   */
  @Test
  void testSaveStudentLanguage() throws Exception {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentLanguage);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentLanguages")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentLanguageController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  /**
   * Method under test: {@link StudentLanguageController#updateStudentLanguage(StudentLanguage)}
   */
  @Test
  void testUpdateStudentLanguage() throws Exception {
    // Arrange
    StudentLanguage studentLanguage = new StudentLanguage();
    studentLanguage.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    studentLanguage.setLanguageId(1);
    studentLanguage.setLanguageLevel(1);
    studentLanguage.setLanguageName("en");
    studentLanguage.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    studentLanguage.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(studentLanguage);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/studentLanguages")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentLanguageController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }
}

