package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.UniversityRepository;
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

@ContextConfiguration(classes = {UniversityService.class})
@ExtendWith(SpringExtension.class)
class UniversityServiceTest {
  @MockBean
  private ImgUtils imgUtils;

  @MockBean
  private UniversityRepository universityRepository;

  @Autowired
  private UniversityService universityService;
  /**
   * Method under test: {@link UniversityService#showAllUniversity(int, int)}
   */
  @Test
  void testShowAllUniversity() {
    // Arrange
    PageImpl<University> pageImpl = new PageImpl<>(new ArrayList<>());
    when(universityRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<University> actualShowAllUniversityResult = universityService.showAllUniversity(10, 3);

    // Assert
    verify(universityRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllUniversityResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllUniversityResult);
  }

  /**
   * Method under test: {@link UniversityService#showAllUniversity(int, int)}
   */
  @Test
  void testShowAllUniversity2() {
    // Arrange
    when(universityRepository.findAll(Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.showAllUniversity(10, 3));
    verify(universityRepository).findAll(Mockito.<Pageable>any());
  }

  /**
   * Method under test: {@link UniversityService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<University> universityList = new ArrayList<>();
    when(universityRepository.findAll()).thenReturn(universityList);

    // Act
    List<University> actualFindAllResult = universityService.findAll();

    // Assert
    verify(universityRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(universityList, actualFindAllResult);
  }

  /**
   * Method under test: {@link UniversityService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    when(universityRepository.findAll()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.findAll());
    verify(universityRepository).findAll();
  }

  /**
   * Method under test: {@link UniversityService#count()}
   */
  @Test
  void testCount() {
    // Arrange
    when(universityRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = universityService.count();

    // Assert
    verify(universityRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link UniversityService#count()}
   */
  @Test
  void testCount2() {
    // Arrange
    when(universityRepository.count()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.count());
    verify(universityRepository).count();
  }

  /**
   * Method under test: {@link UniversityService#update(University)}
   */
  @Test
  void testUpdate() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    when(universityRepository.save(Mockito.<University>any())).thenReturn(university);
    when(universityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    University university2 = new University();
    university2.setAddress1("42 Main St");
    university2.setAddress2("42 Main St");
    university2.setCity("Oxford");
    university2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university2.setImageUrl("https://example.org/example");
    university2.setRegion("us-east-2");
    university2.setUniversityEmail("jane.doe@example.org");
    university2.setUniversityId(1);
    university2.setUniversityPhone("6625550144");
    university2.setUniversityTitle("Dr");
    university2.setUniversityWebsite("University Website");
    university2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university2.setUpdatedBy("2020-03-01");
    university2.setZipCode("21654");

    // Act
    University actualUpdateResult = universityService.update(university2);

    // Assert
    verify(universityRepository).existsById(Mockito.<Integer>any());
    verify(universityRepository).save(Mockito.<University>any());
    assertSame(university, actualUpdateResult);
  }

  /**
   * Method under test: {@link UniversityService#update(University)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    when(universityRepository.save(Mockito.<University>any())).thenThrow(new RuntimeException("foo"));
    when(universityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.update(university));
    verify(universityRepository).existsById(Mockito.<Integer>any());
    verify(universityRepository).save(Mockito.<University>any());
  }

  /**
   * Method under test: {@link UniversityService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    doNothing().when(universityRepository).deleteById(Mockito.<Integer>any());
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(universityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    universityService.delete(1);

    // Assert
    verify(imgUtils).getFileSystemFolder();
    verify(universityRepository).deleteById(Mockito.<Integer>any());
    verify(universityRepository).existsById(Mockito.<Integer>any());
    verify(universityRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link UniversityService#delete(int)}
   */
  @Test
  void testDelete2() {
    // Arrange
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    doThrow(new RuntimeException("foo")).when(universityRepository).deleteById(Mockito.<Integer>any());
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(universityRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.delete(1));
    verify(imgUtils).getFileSystemFolder();
    verify(universityRepository).deleteById(Mockito.<Integer>any());
    verify(universityRepository).existsById(Mockito.<Integer>any());
    verify(universityRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link UniversityService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    University actualFindResult = universityService.find(1);

    // Assert
    verify(universityRepository).findById(Mockito.<Integer>any());
    assertSame(university, actualFindResult);
  }

  /**
  * Method under test: {@link UniversityService#addUniversityWithImg(University, MultipartFile)}
  */
  @Test
  void testAddUniversityWithImg() throws IOException {
    // Arrange
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    University e = new University();
    e.setAddress1("42 Main St");
    e.setAddress2("42 Main St");
    e.setCity("Oxford");
    e.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    e.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    e.setImageUrl("https://example.org/example");
    e.setRegion("us-east-2");
    e.setUniversityEmail("jane.doe@example.org");
    e.setUniversityId(1);
    e.setUniversityPhone("6625550144");
    e.setUniversityTitle("Dr");
    e.setUniversityWebsite("University Website");
    e.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    e.setUpdatedBy("2020-03-01");
    e.setZipCode("21654");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.addUniversityWithImg(e,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils).getFileSystemFolder();
  }

  /**
   * Method under test: {@link UniversityService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg() throws IOException {
    // Arrange
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(universityRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link UniversityService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg2() throws IOException {
    // Arrange
    when(imgUtils.getFileSystemFolder()).thenThrow(new RuntimeException("foo"));

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileSystemFolder();
    verify(universityRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link UniversityService#updateImg(int, MultipartFile)}
   */
  @Test
  void testUpdateImg3() throws IOException {
    // Arrange
    when(imgUtils.getFileExtension(Mockito.<String>any())).thenReturn("File Extension");
    when(imgUtils.getFileSystemFolder()).thenReturn(null);

    University university = new University();
    university.setAddress1("42 Main St");
    university.setAddress2("42 Main St");
    university.setCity("Oxford");
    university.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    university.setImageUrl("https://example.org/example");
    university.setRegion("us-east-2");
    university.setUniversityEmail("jane.doe@example.org");
    university.setUniversityId(1);
    university.setUniversityPhone("6625550144");
    university.setUniversityTitle("Dr");
    university.setUniversityWebsite("University Website");
    university.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    university.setUpdatedBy("2020-03-01");
    university.setZipCode("21654");
    Optional<University> ofResult = Optional.of(university);
    when(universityRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> universityService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(universityRepository).findById(Mockito.<Integer>any());
  }
}

