package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.service.DomainService;
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

@ContextConfiguration(classes = {DomainController.class})
@ExtendWith(SpringExtension.class)
class DomainControllerTest {
  @Autowired
  private DomainController domainController;

  @MockBean
  private DomainService domainService;
  /**
  * Method under test: {@link DomainController#countDomain()}
  */
  @Test
  void testCountDomain() throws Exception {
    // Arrange
    when(domainService.count()).thenReturn(3L);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/domain/count");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Long>3</Long>"));
  }

  /**
   * Method under test: {@link DomainController#displayAllDomain()}
   */
  @Test
  void testDisplayAllDomain() throws Exception {
    // Arrange
    when(domainService.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/domain");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DomainController#displayAllDomain(int, int)}
   */
  @Test
  void testDisplayAllDomain2() throws Exception {
    // Arrange
    when(domainService.showAllDomain(anyInt(), anyInt())).thenReturn(new PageImpl<>(new ArrayList<>()));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/domain/page/{pageNum}", 10);
    MockHttpServletRequestBuilder requestBuilder = getResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DomainController#displayDomain(int)}
   */
  @Test
  void testDisplayDomain() throws Exception {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    when(domainService.find(anyInt())).thenReturn(domain);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/domain/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string("<Domain><domainName>Domain Name</domainName><specialities/><key>1</key></Domain>"));
  }

  /**
   * Method under test: {@link DomainController#saveDomain(Domain)}
   */
  @Test
  void testSaveDomain() throws Exception {
    // Arrange
    when(domainService.findAll()).thenReturn(new ArrayList<>());

    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(domain);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/domain")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }

  /**
   * Method under test: {@link DomainController#updateDomain(Domain)}
   */
  @Test
  void testUpdateDomain() throws Exception {
    // Arrange
    when(domainService.findAll()).thenReturn(new ArrayList<>());

    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    String content = (new ObjectMapper()).writeValueAsString(domain);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/domain")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }
}

