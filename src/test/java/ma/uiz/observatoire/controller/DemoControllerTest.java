package ma.uiz.observatoire.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DemoController.class})
@ExtendWith(SpringExtension.class)
class DemoControllerTest {
  @Autowired
  private DemoController demoController;
  /**
  * Method under test: {@link DemoController#sayHello()}
  */
  @Test
  void testSayHello() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/demo-controller");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(demoController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Hello from secured endpoint"));
  }

  /**
   * Method under test: {@link DemoController#sayHello()}
   */
  @Test
  void testSayHello2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/demo-controller");
    requestBuilder.contentType("https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(demoController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Hello from secured endpoint"));
  }
}

