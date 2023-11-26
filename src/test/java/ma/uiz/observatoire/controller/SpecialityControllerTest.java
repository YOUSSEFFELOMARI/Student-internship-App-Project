package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.service.SpecialityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SpecialityController.class})
@ExtendWith(SpringExtension.class)
class SpecialityControllerTest {
  @Autowired
  private SpecialityController specialityController;

  @MockBean
  private SpecialityService specialityService;
  /**
  * Method under test: {@link SpecialityController#countSpeciality()}
  */
  @Test
  void testCountSpeciality() throws Exception {
    // Arrange
    when(specialityService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/specialities/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link SpecialityController#displayAllSpeciality()}
   */
  @Test
  void testDisplayAllSpeciality() throws Exception {
    // Arrange
    when(specialityService.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/specialities");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link SpecialityController#displayAllSpeciality(int, int)}
   */
  @Test
  void testDisplayAllSpeciality2() throws Exception {
    // Arrange
    when(specialityService.showAllSpeciality(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/specialities/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link SpecialityController#displaySpeciality(int)}
   */
  @Test
  void testDisplaySpeciality() throws Exception {
    // Arrange
    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");
    when(specialityService.find(anyInt())).thenReturn(speciality);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/specialities/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<Speciality><specialityName>Speciality Name</specialityName><key>1</key></Speciality>"));
  }

  /**
   * Method under test: {@link SpecialityController#saveSpeciality(Speciality)}
   */
  @Test
  void testSaveSpeciality() throws Exception {
    // Arrange
    when(specialityService.findAll()).thenReturn(new ArrayList<>());

    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(speciality);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/specialities")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link SpecialityController#updateSpeciality(Speciality)}
   */
  @Test
  void testUpdateSpeciality() throws Exception {
    // Arrange
    when(specialityService.findAll()).thenReturn(new ArrayList<>());

    Speciality speciality = new Speciality();
    speciality.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    speciality.setSpecialityId(1);
    speciality.setSpecialityName("Speciality Name");
    speciality.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    speciality.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(speciality);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/specialities")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(specialityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }
}

