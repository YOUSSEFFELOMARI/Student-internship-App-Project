package ma.uiz.observatoire.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Domain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationResponse.class})
@ExtendWith(SpringExtension.class)
class AuthenticationResponseTest {
  @Autowired
  private AuthenticationResponse authenticationResponse;

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationResponse.AuthenticationResponseBuilder#build()}
   *   <li>{@link AuthenticationResponse.AuthenticationResponseBuilder#company(Company)}
   *   <li>{@link AuthenticationResponse.AuthenticationResponseBuilder#student(StudentDTO)}
   *   <li>{@link AuthenticationResponse.AuthenticationResponseBuilder#token(String)}
   *   <li>{@link AuthenticationResponse.AuthenticationResponseBuilder#user(AccountDTO)}
   * </ul>
   */
  @Test
  void testAuthenticationResponseBuilderBuild() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    companyLegalForm.setCreatedAt(ofResult.atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    companyLegalForm.setUpdatedAt(ofResult2.atStartOfDay());
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
    HashSet<CompanyResponsible> companyResponsibles = new HashSet<>();
    company.setCompanyResponsibles(companyResponsibles);
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    company.setCreatedAt(ofResult3.atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    HashSet<Domain> domains = new HashSet<>();
    company.setDomains(domains);
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    company.setUpdatedAt(ofResult4.atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult = AuthenticationResponse.builder()
        .company(company);

    StudentDTO student = new StudentDTO();
    student.setAccount(3);
    HashSet<Integer> certificates = new HashSet<>();
    student.setCertificates(certificates);
    HashSet<Integer> experiences = new HashSet<>();
    student.setExperiences(experiences);
    HashSet<Integer> hobbies = new HashSet<>();
    student.setHobbies(hobbies);
    HashSet<Integer> languages = new HashSet<>();
    student.setLanguages(languages);
    student.setLastName("Doe");
    HashSet<Integer> licences = new HashSet<>();
    student.setLicences(licences);
    student.setName("Name");
    HashSet<Integer> skills = new HashSet<>();
    student.setSkills(skills);
    HashSet<Integer> studentDiplomas = new HashSet<>();
    student.setStudentDiplomas(studentDiplomas);
    student.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder studentResult = companyResult.student(student);

    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    HashSet<String> roles = new HashSet<>();
    user.setRoles(roles);
    user.setUserName("janedoe");

    // Act
    AuthenticationResponse actualBuildResult = studentResult.token("ABC123").user(user).build();

    // Assert
    Company company2 = actualBuildResult.getCompany();
    LocalDateTime createdAt = company2.getCreatedAt();
    assertEquals("00:00", createdAt.toLocalTime().toString());
    CompanyLegalForm companyLegalForm2 = company2.getCompanyLegalForm();
    LocalDateTime createdAt2 = companyLegalForm2.getCreatedAt();
    assertEquals("00:00", createdAt2.toLocalTime().toString());
    LocalDateTime updatedAt = company2.getUpdatedAt();
    assertEquals("00:00", updatedAt.toLocalTime().toString());
    LocalDateTime updatedAt2 = companyLegalForm2.getUpdatedAt();
    assertEquals("00:00", updatedAt2.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = createdAt2.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate toLocalDateResult3 = updatedAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult3.toString());
    LocalDate toLocalDateResult4 = updatedAt2.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult4.toString());
    assertEquals("2020-03-01", company2.getUpdatedBy());
    assertEquals("2020-03-01", companyLegalForm2.getUpdatedBy());
    assertEquals("21654", company2.getZipCode());
    assertEquals("42 Main St", company2.getAddress1());
    assertEquals("42 Main St", company2.getAddress2());
    assertEquals("6625550144", company2.getCompanyPhone());
    assertEquals("ABC123", actualBuildResult.getToken());
    assertEquals("Company Name", company2.getCompanyName());
    assertEquals("Company Siret", company2.getCompanySiret());
    assertEquals("Company Website", company2.getCompanyWebsite());
    StudentDTO student2 = actualBuildResult.getStudent();
    assertEquals("Doe", student2.getLastName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", company2.getCreatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", companyLegalForm2.getCreatedBy());
    assertEquals("Legal Form Name", companyLegalForm2.getLegalFormName());
    assertEquals("Name", student2.getName());
    assertEquals("Oxford", company2.getCity());
    AccountDTO user2 = actualBuildResult.getUser();
    assertEquals("https://example.org/example", user2.getImageUrl());
    assertEquals("https://example.org/example", company2.getImageUrl());
    assertEquals("jane.doe@example.org", company2.getCompanyEmail());
    assertEquals("janedoe", user2.getUserName());
    assertEquals("us-east-2", company2.getRegion());
    assertEquals(1, user2.getAccountId());
    assertEquals(1, student2.getStudentId());
    assertEquals(1, company2.getCompanyId());
    assertEquals(1, companyLegalForm2.getLegalFormId());
    assertEquals(3, student2.getAccount().intValue());
    Set<String> roles2 = user2.getRoles();
    assertTrue(roles2.isEmpty());
    Set<Integer> certificates2 = student2.getCertificates();
    assertTrue(certificates2.isEmpty());
    Set<Integer> experiences2 = student2.getExperiences();
    assertTrue(experiences2.isEmpty());
    Set<Integer> hobbies2 = student2.getHobbies();
    assertTrue(hobbies2.isEmpty());
    Set<Integer> languages2 = student2.getLanguages();
    assertTrue(languages2.isEmpty());
    Set<Integer> licences2 = student2.getLicences();
    assertTrue(licences2.isEmpty());
    Set<Integer> skills2 = student2.getSkills();
    assertTrue(skills2.isEmpty());
    Set<Integer> studentDiplomas2 = student2.getStudentDiplomas();
    assertTrue(studentDiplomas2.isEmpty());
    Set<CompanyResponsible> companyResponsibles2 = company2.getCompanyResponsibles();
    assertTrue(companyResponsibles2.isEmpty());
    Set<Domain> domains2 = company2.getDomains();
    assertTrue(domains2.isEmpty());
    assertSame(roles, roles2);
    assertSame(certificates, certificates2);
    assertSame(experiences, experiences2);
    assertSame(hobbies, hobbies2);
    assertSame(languages, languages2);
    assertSame(licences, licences2);
    assertSame(skills, skills2);
    assertSame(studentDiplomas, studentDiplomas2);
    assertSame(companyResponsibles, companyResponsibles2);
    assertSame(domains, domains2);
    assertSame(user, user2);
    assertSame(student, student2);
    assertSame(company, company2);
    assertSame(companyLegalForm, companyLegalForm2);
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
    assertSame(ofResult4, toLocalDateResult3);
    assertSame(ofResult2, toLocalDateResult4);
  }

  /**
   * Method under test: {@link AuthenticationResponse#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse(authenticationResponse.canEqual("Other"));
    assertTrue(authenticationResponse.canEqual(authenticationResponse));
  }

  /**
   * Method under test: {@link AuthenticationResponse#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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

    // Act
    boolean actualCanEqualResult = authenticationResponse.canEqual(tokenResult.user(user).build());

    // Assert
    verify(company).setAddress1(Mockito.<String>any());
    verify(company).setAddress2(Mockito.<String>any());
    verify(company).setCity(Mockito.<String>any());
    verify(company).setRegion(Mockito.<String>any());
    verify(company).setZipCode(Mockito.<String>any());
    verify(company).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(company).setCreatedBy(Mockito.<String>any());
    verify(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(company).setUpdatedBy(Mockito.<String>any());
    verify(company).setCompanyEmail(Mockito.<String>any());
    verify(company).setCompanyId(anyInt());
    verify(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    verify(company).setCompanyName(Mockito.<String>any());
    verify(company).setCompanyPhone(Mockito.<String>any());
    verify(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    verify(company).setCompanySiret(Mockito.<String>any());
    verify(company).setCompanyWebsite(Mockito.<String>any());
    verify(company).setDomains(Mockito.<Set<Domain>>any());
    verify(company).setImageUrl(Mockito.<String>any());
    assertTrue(actualCanEqualResult);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link AuthenticationResponse#AuthenticationResponse()}
  *   <li>{@link AuthenticationResponse#setCompany(Company)}
  *   <li>{@link AuthenticationResponse#setStudent(StudentDTO)}
  *   <li>{@link AuthenticationResponse#setToken(String)}
  *   <li>{@link AuthenticationResponse#setUser(AccountDTO)}
  *   <li>{@link AuthenticationResponse#toString()}
  *   <li>{@link AuthenticationResponse#getCompany()}
  *   <li>{@link AuthenticationResponse#getStudent()}
  *   <li>{@link AuthenticationResponse#getToken()}
  *   <li>{@link AuthenticationResponse#getUser()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse();
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
    actualAuthenticationResponse.setCompany(company);
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
    actualAuthenticationResponse.setStudent(student);
    actualAuthenticationResponse.setToken("ABC123");
    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    actualAuthenticationResponse.setUser(user);
    String actualToStringResult = actualAuthenticationResponse.toString();
    Company actualCompany = actualAuthenticationResponse.getCompany();
    StudentDTO actualStudent = actualAuthenticationResponse.getStudent();
    String actualToken = actualAuthenticationResponse.getToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("AuthenticationResponse(token=ABC123, user=AccountDTO(accountId=1, userName=janedoe, roles=[],"
        + " imageUrl=https://example.org/example), company=Company(companyId=1, companySiret=Company Siret,"
        + " companyName=Company Name, companyPhone=6625550144, companyEmail=jane.doe@example.org, companyWebsite=Company"
        + " Website, domains=[], companyLegalForm=CompanyLegalForm(legalFormId=1, legalFormName=Legal Form Name),"
        + " companyResponsibles=[], imageUrl=https://example.org/example), student=StudentDTO(studentId=1,"
        + " name=Name, lastName=Doe, account=3, studentDiplomas=[], certificates=[], experiences=[], hobbies=[],"
        + " languages=[], skills=[], licences=[]))", actualToStringResult);
    assertSame(user, actualAuthenticationResponse.getUser());
    assertSame(student, actualStudent);
    assertSame(company, actualCompany);
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationResponse#AuthenticationResponse(String, AccountDTO, Company, StudentDTO)}
   *   <li>{@link AuthenticationResponse#setCompany(Company)}
   *   <li>{@link AuthenticationResponse#setStudent(StudentDTO)}
   *   <li>{@link AuthenticationResponse#setToken(String)}
   *   <li>{@link AuthenticationResponse#setUser(AccountDTO)}
   *   <li>{@link AuthenticationResponse#toString()}
   *   <li>{@link AuthenticationResponse#getCompany()}
   *   <li>{@link AuthenticationResponse#getStudent()}
   *   <li>{@link AuthenticationResponse#getToken()}
   *   <li>{@link AuthenticationResponse#getUser()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange
    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");

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

    // Act
    AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse("ABC123", user, company, student);
    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");
    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    actualAuthenticationResponse.setCompany(company2);
    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    actualAuthenticationResponse.setStudent(student2);
    actualAuthenticationResponse.setToken("ABC123");
    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");
    actualAuthenticationResponse.setUser(user2);
    String actualToStringResult = actualAuthenticationResponse.toString();
    Company actualCompany = actualAuthenticationResponse.getCompany();
    StudentDTO actualStudent = actualAuthenticationResponse.getStudent();
    String actualToken = actualAuthenticationResponse.getToken();
    AccountDTO actualUser = actualAuthenticationResponse.getUser();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("AuthenticationResponse(token=ABC123, user=AccountDTO(accountId=1, userName=janedoe, roles=[],"
        + " imageUrl=https://example.org/example), company=Company(companyId=1, companySiret=Company Siret,"
        + " companyName=Company Name, companyPhone=6625550144, companyEmail=jane.doe@example.org, companyWebsite=Company"
        + " Website, domains=[], companyLegalForm=CompanyLegalForm(legalFormId=1, legalFormName=Legal Form Name),"
        + " companyResponsibles=[], imageUrl=https://example.org/example), student=StudentDTO(studentId=1,"
        + " name=Name, lastName=Doe, account=3, studentDiplomas=[], certificates=[], experiences=[], hobbies=[],"
        + " languages=[], skills=[], licences=[]))", actualToStringResult);
    assertEquals(user, actualUser);
    assertEquals(student, actualStudent);
    assertEquals(company, actualCompany);
    assertSame(user2, actualUser);
    assertSame(student2, actualStudent);
    assertSame(company2, actualCompany);
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals() {
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

    // Act and Assert
    assertNotEquals(tokenResult.user(user).build(), null);
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals2() {
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

    // Act and Assert
    assertNotEquals(tokenResult.user(user).build(), "Different type to AuthenticationResponse");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationResponse#equals(Object)}
   *   <li>{@link AuthenticationResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
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

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link AuthenticationResponse#equals(Object)}
   *   <li>{@link AuthenticationResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
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

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult2 = AuthenticationResponse.builder()
        .company(company2);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult2 = companyResult2.student(student2)
        .token("ABC123");

    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");
    AuthenticationResponse buildResult2 = tokenResult2.user(user2).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult2 = AuthenticationResponse.builder()
        .company(company2);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult2 = companyResult2.student(student2)
        .token("ABC123");

    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(buildResult, tokenResult2.user(user2).build());
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult = companyResult.student(student).token("janedoe");

    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    AuthenticationResponse buildResult = tokenResult.user(user).build();

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult2 = AuthenticationResponse.builder()
        .company(company2);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult2 = companyResult2.student(student2)
        .token("ABC123");

    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(buildResult, tokenResult2.user(user2).build());
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult = companyResult.student(student).token(null);

    AccountDTO user = new AccountDTO();
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    AuthenticationResponse buildResult = tokenResult.user(user).build();

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult2 = AuthenticationResponse.builder()
        .company(company2);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult2 = companyResult2.student(student2)
        .token("ABC123");

    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(buildResult, tokenResult2.user(user2).build());
  }

  /**
   * Method under test: {@link AuthenticationResponse#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");
    Company company = mock(Company.class);
    doNothing().when(company).setAddress1(Mockito.<String>any());
    doNothing().when(company).setAddress2(Mockito.<String>any());
    doNothing().when(company).setCity(Mockito.<String>any());
    doNothing().when(company).setRegion(Mockito.<String>any());
    doNothing().when(company).setZipCode(Mockito.<String>any());
    doNothing().when(company).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setCreatedBy(Mockito.<String>any());
    doNothing().when(company).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(company).setUpdatedBy(Mockito.<String>any());
    doNothing().when(company).setCompanyEmail(Mockito.<String>any());
    doNothing().when(company).setCompanyId(anyInt());
    doNothing().when(company).setCompanyLegalForm(Mockito.<CompanyLegalForm>any());
    doNothing().when(company).setCompanyName(Mockito.<String>any());
    doNothing().when(company).setCompanyPhone(Mockito.<String>any());
    doNothing().when(company).setCompanyResponsibles(Mockito.<Set<CompanyResponsible>>any());
    doNothing().when(company).setCompanySiret(Mockito.<String>any());
    doNothing().when(company).setCompanyWebsite(Mockito.<String>any());
    doNothing().when(company).setDomains(Mockito.<Set<Domain>>any());
    doNothing().when(company).setImageUrl(Mockito.<String>any());
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
    AccountDTO user = mock(AccountDTO.class);
    doNothing().when(user).setAccountId(anyInt());
    doNothing().when(user).setImageUrl(Mockito.<String>any());
    doNothing().when(user).setRoles(Mockito.<Set<String>>any());
    doNothing().when(user).setUserName(Mockito.<String>any());
    user.setAccountId(1);
    user.setImageUrl("https://example.org/example");
    user.setRoles(new HashSet<>());
    user.setUserName("janedoe");
    AuthenticationResponse buildResult = tokenResult.user(user).build();

    CompanyLegalForm companyLegalForm2 = new CompanyLegalForm();
    companyLegalForm2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm2.setLegalFormId(1);
    companyLegalForm2.setLegalFormName("Legal Form Name");
    companyLegalForm2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm2.setUpdatedBy("2020-03-01");

    Company company2 = new Company();
    company2.setAddress1("42 Main St");
    company2.setAddress2("42 Main St");
    company2.setCity("Oxford");
    company2.setCompanyEmail("jane.doe@example.org");
    company2.setCompanyId(1);
    company2.setCompanyLegalForm(companyLegalForm2);
    company2.setCompanyName("Company Name");
    company2.setCompanyPhone("6625550144");
    company2.setCompanyResponsibles(new HashSet<>());
    company2.setCompanySiret("Company Siret");
    company2.setCompanyWebsite("Company Website");
    company2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company2.setDomains(new HashSet<>());
    company2.setImageUrl("https://example.org/example");
    company2.setRegion("us-east-2");
    company2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company2.setUpdatedBy("2020-03-01");
    company2.setZipCode("21654");
    AuthenticationResponse.AuthenticationResponseBuilder companyResult2 = AuthenticationResponse.builder()
        .company(company2);

    StudentDTO student2 = new StudentDTO();
    student2.setAccount(3);
    student2.setCertificates(new HashSet<>());
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    AuthenticationResponse.AuthenticationResponseBuilder tokenResult2 = companyResult2.student(student2)
        .token("ABC123");

    AccountDTO user2 = new AccountDTO();
    user2.setAccountId(1);
    user2.setImageUrl("https://example.org/example");
    user2.setRoles(new HashSet<>());
    user2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(buildResult, tokenResult2.user(user2).build());
  }
}

