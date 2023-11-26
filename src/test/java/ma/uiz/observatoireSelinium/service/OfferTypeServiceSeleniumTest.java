package ma.uiz.observatoireSelinium.service;

import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OfferTypeServiceSeleniumTest {

    @Test
    public void testShowAllOfferType() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eloma\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        String baseUrl = "http://localhost:8080";
        String endpoint = "/api/v1/offerType";
        driver.get(baseUrl + endpoint);
        String responseBody = driver.getPageSource();
        assertTrue(responseBody.contains("<key>1</key>"));
        driver.quit();
    }

    @Test
    public void testFindOfferTypeById() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eloma\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        String baseUrl = "http://localhost:8080";
        int offerTypeId = 1;
        String endpoint = "/api/v1/offerType/" + offerTypeId;
        driver.get(baseUrl + endpoint);
        String responseBody = driver.getPageSource();
        assertTrue(responseBody.contains("<key>" + offerTypeId + "</key>"));
        driver.quit();
    }

    @Test
    public void testFindOfferTypeByName() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eloma\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        String baseUrl = "http://localhost:8080";
        String endpoint = "/api/v1/offerType";
        driver.get(baseUrl + endpoint);
        String responseBody = driver.getPageSource();
        assertTrue(responseBody.contains("<offerTypeName>hooo</offerTypeName>"));
        driver.quit();
    }

    @Test
    public void testCreateOfferType() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eloma\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        String baseUrl = "http://localhost:8080";
        String endpoint = "/api/v1/offerType";
        String OfferType="test";
        String requestBody = "{\"offerTypeName\":\""+OfferType+"\"}";
        HttpPost request = new HttpPost(baseUrl + endpoint);
        request.setHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;
        try {
            response = httpclient.execute(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(201, statusCode);
        driver.quit();
    }

    @Test
    public void testDeleteOfferType() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eloma\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        String baseUrl = "http://localhost:8080";
        int offerTypeIdToDelete = 8;

        String endpoint = "/api/v1/offerType/" + offerTypeIdToDelete;

        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete request = new HttpDelete(baseUrl + endpoint );

        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            assertEquals(204, statusCode);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        driver.quit();
    }

}