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
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.EstablishmentRepository;
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

@ContextConfiguration(classes = {EstablishmentService.class})
@ExtendWith(SpringExtension.class)
class EstablishmentServiceTest {
  @MockBean
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private EstablishmentService establishmentService;

  @MockBean
  private ImgUtils imgUtils;
  /**
   * Method under test: {@link EstablishmentService#showAllEstablishment(int, int)}
   */
  @Test
  void testShowAllEstablishment() {
    // Arrange
    PageImpl<Establishment> pageImpl = new PageImpl<>(new ArrayList<>());
    when(establishmentRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Establishment> actualShowAllEstablishmentResult = establishmentService.showAllEstablishment(10, 3);

    // Assert
    verify(establishmentRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllEstablishmentResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllEstablishmentResult);
  }

  /**
   * Method under test: {@link EstablishmentService#showAllEstablishment(int, int)}
   */
  @Test
  void testShowAllEstablishment2() {
    // Arrange
    when(establishmentRepository.findAll(Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.showAllEstablishment(10, 3));
    verify(establishmentRepository).findAll(Mockito.<Pageable>any());
  }

  /**
   * Method under test: {@link EstablishmentService#findAll(Integer)}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<Establishment> establishmentList = new ArrayList<>();
    when(establishmentRepository.findAllByUniversityUniversityId(Mockito.<Integer>any())).thenReturn(establishmentList);

    // Act
    List<Establishment> actualFindAllResult = establishmentService.findAll(1);

    // Assert
    verify(establishmentRepository).findAllByUniversityUniversityId(Mockito.<Integer>any());
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(establishmentList, actualFindAllResult);
  }

  /**
   * Method under test: {@link EstablishmentService#findAll(Integer)}
   */
  @Test
  void testFindAll2() {
    // Arrange
    ArrayList<Establishment> establishmentList = new ArrayList<>();
    when(establishmentRepository.findAll()).thenReturn(establishmentList);

    // Act
    List<Establishment> actualFindAllResult = establishmentService.findAll(null);

    // Assert
    verify(establishmentRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(establishmentList, actualFindAllResult);
  }

  /**
   * Method under test: {@link EstablishmentService#findAll(Integer)}
   */
  @Test
  void testFindAll3() {
    // Arrange
    when(establishmentRepository.findAll()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.findAll(null));
    verify(establishmentRepository).findAll();
  }

  /**
   * Method under test: {@link EstablishmentService#count()}
   */
  @Test
  void testCount() {
    // Arrange
    when(establishmentRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = establishmentService.count();

    // Assert
    verify(establishmentRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link EstablishmentService#count()}
   */
  @Test
  void testCount2() {
    // Arrange
    when(establishmentRepository.count()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.count());
    verify(establishmentRepository).count();
  }

  /**
   * Method under test: {@link EstablishmentService#update(Establishment)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    when(establishmentRepository.save(Mockito.<Establishment>any())).thenReturn(establishment);
    when(establishmentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    Establishment establishment2 = new Establishment();
    establishment2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment2.setEstablishmentEmail("jane.doe@example.org");
    establishment2.setEstablishmentId(1);
    establishment2.setEstablishmentPhone("6625550144");
    establishment2.setEstablishmentTitle("Dr");
    establishment2.setEstablishmentWebSite("Establishment Web Site");
    establishment2.setImageUrl("https://example.org/example");
    establishment2.setUniversity(university2);
    establishment2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment2.setUpdatedBy("2020-03-01");

    // Act
    Establishment actualUpdateResult = establishmentService.update(establishment2);

    // Assert
    verify(establishmentRepository).existsById(Mockito.<Integer>any());
    verify(establishmentRepository).save(Mockito.<Establishment>any());
    assertSame(establishment, actualUpdateResult);
  }

  /**
   * Method under test: {@link EstablishmentService#update(Establishment)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    when(establishmentRepository.save(Mockito.<Establishment>any())).thenThrow(new RuntimeException("foo"));
    when(establishmentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.update(establishment));
    verify(establishmentRepository).existsById(Mockito.<Integer>any());
    verify(establishmentRepository).save(Mockito.<Establishment>any());
  }

  /**
   * Method under test: {@link EstablishmentService#delete(int)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    doNothing().when(establishmentRepository).deleteById(Mockito.<Integer>any());
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(establishmentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    establishmentService.delete(1);

    // Assert
    verify(imgUtils).getFileSystemFolder();
    verify(establishmentRepository).deleteById(Mockito.<Integer>any());
    verify(establishmentRepository).existsById(Mockito.<Integer>any());
    verify(establishmentRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link EstablishmentService#delete(int)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    doThrow(new RuntimeException("foo")).when(establishmentRepository).deleteById(Mockito.<Integer>any());
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
    when(establishmentRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.delete(1));
    verify(imgUtils).getFileSystemFolder();
    verify(establishmentRepository).deleteById(Mockito.<Integer>any());
    verify(establishmentRepository).existsById(Mockito.<Integer>any());
    verify(establishmentRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link EstablishmentService#find(int)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Establishment actualFindResult = establishmentService.find(1);

    // Assert
    verify(establishmentRepository).findById(Mockito.<Integer>any());
    assertSame(establishment, actualFindResult);
  }

  /**
  * Method under test: {@link EstablishmentService#addEstablishmentWithImg(Establishment, MultipartFile)}
  */
  @Test
  void testAddEstablishmentWithImg() throws IOException {
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

    Establishment e = new Establishment();
    e.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    e.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    e.setEstablishmentEmail("jane.doe@example.org");
    e.setEstablishmentId(1);
    e.setEstablishmentPhone("6625550144");
    e.setEstablishmentTitle("Dr");
    e.setEstablishmentWebSite("Establishment Web Site");
    e.setImageUrl("https://example.org/example");
    e.setUniversity(university);
    e.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    e.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.addEstablishmentWithImg(e,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils).getFileSystemFolder();
  }

  /**
   * Method under test: {@link EstablishmentService#updateImg(int, MultipartFile)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(establishmentRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link EstablishmentService#updateImg(int, MultipartFile)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileSystemFolder();
    verify(establishmentRepository).findById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link EstablishmentService#updateImg(int, MultipartFile)}
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

    Establishment establishment = new Establishment();
    establishment.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    establishment.setEstablishmentEmail("jane.doe@example.org");
    establishment.setEstablishmentId(1);
    establishment.setEstablishmentPhone("6625550144");
    establishment.setEstablishmentTitle("Dr");
    establishment.setEstablishmentWebSite("Establishment Web Site");
    establishment.setImageUrl("https://example.org/example");
    establishment.setUniversity(university);
    establishment.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    establishment.setUpdatedBy("2020-03-01");
    Optional<Establishment> ofResult = Optional.of(establishment);
    when(establishmentRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> establishmentService.updateImg(1,
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
    verify(imgUtils).getFileExtension(Mockito.<String>any());
    verify(imgUtils, atLeast(1)).getFileSystemFolder();
    verify(establishmentRepository).findById(Mockito.<Integer>any());
  }
}

