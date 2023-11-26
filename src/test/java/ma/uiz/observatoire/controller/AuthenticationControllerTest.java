package ma.uiz.observatoire.controller;

import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import ma.uiz.observatoire.auth.AuthenticationRequest;
import ma.uiz.observatoire.auth.AuthenticationResponse;
import ma.uiz.observatoire.auth.RegisterRequest;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthenticationController.class})
@ExtendWith(SpringExtension.class)
class AuthenticationControllerTest {
  @Autowired
  private AuthenticationController authenticationController;

  @MockBean
  private AuthenticationService authenticationService;
  /**
   * Method under test: {@link AuthenticationController#register(RegisterRequest)}
   */
  @Test
  void testRegister() throws Exception {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult = AuthenticationResponse.builder()
        .company(company);

    StudentDTO student = new StudentDTO();
    student.setAccount(3);
    student.setCertificates(new HashSet<>());
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult = companyResult.student(student).token("ABC123");

    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    AuthenticationResponse buildResult = tokenResult.user(user).build();
    when(authenticationService.register(Mockito.<RegisterRequest>any())).thenReturn(buildResult);

    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setCompanySiret("Company Siret");
    registerRequest.setEmail("jane.doe@example.org");
    registerRequest.setPassword("iloveyou");
    registerRequest.setRoles(new ArrayList<>());
    registerRequest.setStudentCin("Student Cin");
    registerRequest.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(registerRequest);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authenticationController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "<AuthenticationResponse><token>ABC123</token><user><accountId>1</accountId><userName>janedoe</userName"
                    + "><roles/><imageUrl>https://example.org/example</imageUrl></user><company><address1>42 Main St</address1"
                    + "><address2>42 Main St</address2><city>Oxford</city><region>us-east-2</region><zipCode>21654</zipCode"
                    + "><companySiret>Company Siret</companySiret><companyName>Company Name</companyName><companyPhone"
                    + ">6625550144</companyPhone><companyEmail>jane.doe@example.org</companyEmail><companyWebsite>Company"
                    + " Website</companyWebsite><domains/><companyLegalForm><legalFormName>Legal Form Name</legalFormName>"
                    + "<key>1</key></companyLegalForm><companyResponsibles/><imageUrl>https://example.org/example</imageUrl"
                    + "><key>1</key></company><student><studentId>1</studentId><name>Name</name><lastName>Doe</lastName>"
                    + "<account>3</account><studentDiplomas/><certificates/><experiences/><hobbies/><languages/><skills/>"
                    + "<licences/></student></AuthenticationResponse>"));
  }

  /**
  * Method under test: {@link AuthenticationController#authenticate(AuthenticationRequest)}
  */
  @Test
  void testAuthenticate() throws Exception {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult = AuthenticationResponse.builder()
        .company(company);

    StudentDTO student = new StudentDTO();
    student.setAccount(3);
    student.setCertificates(new HashSet<>());
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult = companyResult.student(student).token("ABC123");

    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    AuthenticationResponse buildResult = tokenResult.user(user).build();
    when(authenticationService.authenticate(Mockito.<AuthenticationRequest>any())).thenReturn(buildResult);

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setEmail("jane.doe@example.org");
    authenticationRequest.setPassword("iloveyou");
    String content = (new ObjectMapper()).writeValueAsString(authenticationRequest);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/authenticate")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authenticationController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "<AuthenticationResponse><token>ABC123</token><user><accountId>1</accountId><userName>janedoe</userName"
                    + "><roles/><imageUrl>https://example.org/example</imageUrl></user><company><address1>42 Main St</address1"
                    + "><address2>42 Main St</address2><city>Oxford</city><region>us-east-2</region><zipCode>21654</zipCode"
                    + "><companySiret>Company Siret</companySiret><companyName>Company Name</companyName><companyPhone"
                    + ">6625550144</companyPhone><companyEmail>jane.doe@example.org</companyEmail><companyWebsite>Company"
                    + " Website</companyWebsite><domains/><companyLegalForm><legalFormName>Legal Form Name</legalFormName>"
                    + "<key>1</key></companyLegalForm><companyResponsibles/><imageUrl>https://example.org/example</imageUrl"
                    + "><key>1</key></company><student><studentId>1</studentId><name>Name</name><lastName>Doe</lastName>"
                    + "<account>3</account><studentDiplomas/><certificates/><experiences/><hobbies/><languages/><skills/>"
                    + "<licences/></student></AuthenticationResponse>"));
  }

  /**
   * Method under test: {@link AuthenticationController#displayCurrentAccount(String)}
   */
  @Test
  void testDisplayCurrentAccount() throws Exception {
    // Arrange
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(1);
    accountDTO.setImageUrl("https://example.org/example");
    accountDTO.setRoles(new HashSet<>());
    accountDTO.setUserName("janedoe");
    when(authenticationService.currentUser(Mockito.<String>any())).thenReturn(accountDTO);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/user")
        .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authenticationController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "<AccountDTO><accountId>1</accountId><userName>janedoe</userName><roles/><imageUrl>https://example.org"
                    + "/example</imageUrl></AccountDTO>"));
  }
}

