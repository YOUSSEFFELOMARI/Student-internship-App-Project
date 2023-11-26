package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import ma.uiz.observatoire.service.ImgService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ImageController.class})
@ExtendWith(SpringExtension.class)
class ImageControllerTest {
  @Autowired
  private ImageController imageController;

  @MockBean
  private ImgService imgService;
  /**
  * Method under test: {@link ImageController#displayImage(String, HttpServletResponse)}
  */
  @Test
  void testDisplayImage() throws Exception {
    // Arrange
    when(imgService.getImage(Mockito.<String>any())).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/images/{image}", "Image");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}

