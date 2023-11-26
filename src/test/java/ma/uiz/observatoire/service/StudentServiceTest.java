package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.StudentMapper;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.repository.StudentRepository;
import ma.uiz.observatoire.utils.ImgUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
  @MockBean
  private ImgUtils imgUtils;

  @MockBean
  private StudentMapper studentMapper;

  @MockBean
  private StudentRepository studentRepository;

  @Autowired
  private StudentService studentService;
  /**
   * Method under test: {@link StudentService#showAllStudent(int, int)}
   */
  @Test
  void testShowAllStudent() {
    // Arrange
    when(studentRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    Page<StudentDTO> actualShowAllStudentResult = studentService.showAllStudent(10, 3);

    // Assert
    verify(studentRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllStudentResult.toList().isEmpty());
  }

  /**
   * Method under test: {@link StudentService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    when(studentRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<StudentDTO> actualFindAllResult = studentService.findAll();

    // Assert
    verify(studentRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link StudentService#count()}
   */
  @Test
  void testCount() {
    // Arrange
    when(studentRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = studentService.count();

    // Assert
    verify(studentRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link StudentService#count()}
   */
  @Test
  void testCount2() {
    // Arrange
    when(studentRepository.count()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.count());
    verify(studentRepository).count();
  }

  /**
   * Method under test: {@link StudentService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    doNothing().when(studentRepository).deleteById(Mockito.<Integer>any());
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student2);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    // Act
    studentService.delete(1);

    // Assert
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(imgUtils).getFileSystemFolder();
    verify(studentRepository).deleteById(Mockito.<Integer>any());
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
   * Method under test: {@link StudentService#delete(int)}
   */
  @Test
  void testDelete2() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student2);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);
    when(imgUtils.getFileSystemFolder()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.delete(1));
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(imgUtils).getFileSystemFolder();
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
   * Method under test: {@link StudentService#update(StudentDTO)}
   */
  @Test
  void testUpdate() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student);
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenReturn(studentDTO);
    when(studentMapper.mapToModel(Mockito.<StudentDTO>any())).thenReturn(student2);

    StudentDTO studentDTO2 = new StudentDTO();
    studentDTO2.setAccount(3);
    studentDTO2.setCertificates(new HashSet<>());
    studentDTO2.setExperiences(new HashSet<>());
    studentDTO2.setHobbies(new HashSet<>());
    studentDTO2.setLanguages(new HashSet<>());
    studentDTO2.setLastName("Doe");
    studentDTO2.setLicences(new HashSet<>());
    studentDTO2.setName("Name");
    studentDTO2.setSkills(new HashSet<>());
    studentDTO2.setStudentDiplomas(new HashSet<>());
    studentDTO2.setStudentId(1);

    // Act
    StudentDTO actualUpdateResult = studentService.update(studentDTO2);

    // Assert
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    verify(studentMapper).mapToModel(Mockito.<StudentDTO>any());
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
    assertSame(studentDTO, actualUpdateResult);
  }

  /**
   * Method under test: {@link StudentService#update(StudentDTO)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student);
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenThrow(new RuntimeException("foo"));
    when(studentMapper.mapToModel(Mockito.<StudentDTO>any())).thenReturn(student2);

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.update(studentDTO));
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    verify(studentMapper).mapToModel(Mockito.<StudentDTO>any());
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
   * Method under test: {@link StudentService#updateStd(Student)}
   */
  @Test
  void testUpdateStd() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student);
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");

    // Act
    Student actualUpdateStdResult = studentService.updateStd(student2);

    // Assert
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
    assertSame(student, actualUpdateStdResult);
  }

  /**
   * Method under test: {@link StudentService#updateStd(Student)}
   */
  @Test
  void testUpdateStd2() {
    // Arrange
    when(studentRepository.save(Mockito.<Student>any())).thenThrow(new RuntimeException("foo"));
    when(studentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.updateStd(student));
    verify(studentRepository).existsById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
   * Method under test: {@link StudentService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenReturn(studentDTO);

    // Act
    StudentDTO actualFindResult = studentService.find(1);

    // Assert
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    verify(studentRepository).findById(Mockito.<Integer>any());
    assertSame(studentDTO, actualFindResult);
  }

  /**
   * Method under test: {@link StudentService#find(int)}
   */
  @Test
  void testFind2() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(studentMapper.mapToDto(Mockito.<Student>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.find(1));
    verify(studentMapper).mapToDto(Mockito.<Student>any());
    verify(studentRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link StudentService#findStd(int)}
   */
  @Test
  void testFindStd() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student2);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Student actualFindStdResult = studentService.findStd(1);

    // Assert
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
    assertSame(student2, actualFindStdResult);
  }

  /**
   * Method under test: {@link StudentService#findStd(int)}
   */
  @Test
  void testFindStd2() {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);
    when(studentRepository.save(Mockito.<Student>any())).thenThrow(new RuntimeException("foo"));
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.findStd(1));
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
  * Method under test: {@link StudentService#addStudentWithImg(StudentDTO, MultipartFile)}
  */
  @Test
  void testAddStudentWithImg() throws IOException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(studentMapper.mapToModel(Mockito.<StudentDTO>any())).thenReturn(student);
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.addStudentWithImg(studentDTO,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(studentMapper).mapToModel(Mockito.<StudentDTO>any());
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils).getFileSystemFolder();
  }

  /**
   * Method under test: {@link StudentService#addStudentWithImg(StudentDTO, MultipartFile)}
   */
  @Test
  void testAddStudentWithImg2() throws IOException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    when(studentMapper.mapToModel(Mockito.<StudentDTO>any())).thenReturn(student);
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setAccount(3);
    studentDTO.setCertificates(new HashSet<>());
    studentDTO.setExperiences(new HashSet<>());
    studentDTO.setHobbies(new HashSet<>());
    studentDTO.setLanguages(new HashSet<>());
    studentDTO.setLastName("Doe");
    studentDTO.setLicences(new HashSet<>());
    studentDTO.setName("Name");
    studentDTO.setSkills(new HashSet<>());
    studentDTO.setStudentDiplomas(new HashSet<>());
    studentDTO.setStudentId(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.addStudentWithImg(studentDTO,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(studentMapper).mapToModel(Mockito.<StudentDTO>any());
    verify(imgUtils).getFileExtension(Mockito.<String>any());
  }

  /**
   * Method under test: {@link StudentService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg() throws IOException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student2);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(studentRepository).save(Mockito.<Student>any());
  }

  /**
   * Method under test: {@link StudentService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg2() throws IOException {
    // Arrange
    Account account = new Account();
    account.setAccountId(1);
    account.setAccountRoles(new HashSet<>());
    account.setConversations(new HashSet<>());
    account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account.setEmail("jane.doe@example.org");
    account.setEnabled(true);
    account.setMobileNumber("42");
    account.setPassword("iloveyou");
    account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account.setUpdatedBy("2020-03-01");
    account.setUserName("janedoe");

    Student student = new Student();
    student.setAccount(account);
    student.setAddress1("42 Main St");
    student.setAddress2("42 Main St");
    student.setApplications(new HashSet<>());
    student.setCIN("CIN");
    student.setCertificates(new HashSet<>());
    student.setCity("Oxford");
    student.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student.setExperiences(new HashSet<>());
    student.setHobbies(new HashSet<>());
    student.setImageUrl("https://example.org/example");
    student.setLanguages(new HashSet<>());
    student.setLastName("Doe");
    student.setLicences(new HashSet<>());
    student.setName("Name");
    student.setRegion("us-east-2");
    student.setSkills(new HashSet<>());
    student.setStudentDiplomas(new HashSet<>());
    student.setStudentId(1);
    student.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student.setUpdatedBy("2020-03-01");
    student.setZipCode("21654");
    Optional<Student> ofResult = Optional.of(student);

    Account account2 = new Account();
    account2.setAccountId(1);
    account2.setAccountRoles(new HashSet<>());
    account2.setConversations(new HashSet<>());
    account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    account2.setEmail("jane.doe@example.org");
    account2.setEnabled(true);
    account2.setMobileNumber("42");
    account2.setPassword("iloveyou");
    account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    account2.setUpdatedBy("2020-03-01");
    account2.setUserName("janedoe");

    Student student2 = new Student();
    student2.setAccount(account2);
    student2.setAddress1("42 Main St");
    student2.setAddress2("42 Main St");
    student2.setApplications(new HashSet<>());
    student2.setCIN("CIN");
    student2.setCertificates(new HashSet<>());
    student2.setCity("Oxford");
    student2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    student2.setExperiences(new HashSet<>());
    student2.setHobbies(new HashSet<>());
    student2.setImageUrl("https://example.org/example");
    student2.setLanguages(new HashSet<>());
    student2.setLastName("Doe");
    student2.setLicences(new HashSet<>());
    student2.setName("Name");
    student2.setRegion("us-east-2");
    student2.setSkills(new HashSet<>());
    student2.setStudentDiplomas(new HashSet<>());
    student2.setStudentId(1);
    student2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    student2.setUpdatedBy("2020-03-01");
    student2.setZipCode("21654");
    when(studentRepository.save(Mockito.<Student>any())).thenReturn(student2);
    when(studentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(imgUtils.getFileSystemFolder()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> studentService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(studentRepository).findById(Mockito.<Integer>any());
    verify(imgUtils).getFileSystemFolder();
    verify(studentRepository).save(Mockito.<Student>any());
  }
}

