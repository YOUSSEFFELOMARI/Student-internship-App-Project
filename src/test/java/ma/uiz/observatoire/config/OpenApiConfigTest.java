package ma.uiz.observatoire.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;

class OpenApiConfigTest {
  /**
  * Method under test: {@link OpenApiConfig#usersMicroserviceOpenAPI()}
  */
  @Test
  void testUsersMicroserviceOpenAPI() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    OpenAPI actualUsersMicroserviceOpenAPIResult = (new OpenApiConfig()).usersMicroserviceOpenAPI();

    // Assert
    Info info = actualUsersMicroserviceOpenAPIResult.getInfo();
    assertEquals("1.0", info.getVersion());
    assertEquals("3.0.1", actualUsersMicroserviceOpenAPIResult.getOpenapi());
    assertEquals("API Description", info.getDescription());
    assertEquals("Observatoire UIZ", info.getTitle());
    assertNull(actualUsersMicroserviceOpenAPIResult.getComponents());
    assertNull(actualUsersMicroserviceOpenAPIResult.getExternalDocs());
    assertNull(actualUsersMicroserviceOpenAPIResult.getPaths());
    assertNull(info.getContact());
    assertNull(info.getLicense());
    assertNull(info.getSummary());
    assertNull(info.getTermsOfService());
    assertNull(actualUsersMicroserviceOpenAPIResult.getSecurity());
    assertNull(actualUsersMicroserviceOpenAPIResult.getServers());
    assertNull(actualUsersMicroserviceOpenAPIResult.getTags());
    assertNull(actualUsersMicroserviceOpenAPIResult.getWebhooks());
    assertNull(actualUsersMicroserviceOpenAPIResult.getExtensions());
    assertNull(info.getExtensions());
    assertEquals(SpecVersion.V30, actualUsersMicroserviceOpenAPIResult.getSpecVersion());
  }
}

