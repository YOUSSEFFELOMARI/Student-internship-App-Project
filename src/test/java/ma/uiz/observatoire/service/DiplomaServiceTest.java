package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.model.StudentDiploma;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.DiplomaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DiplomaService.class})
@ExtendWith(SpringExtension.class)
class DiplomaServiceTest {
  @MockBean
  private DiplomaRepository diplomaRepository;

  @Autowired
  private DiplomaService diplomaService;
  /**
   * Method under test: {@link DiplomaService#showAllDiploma(int, int)}
   */
  @Test
  void testShowAllDiploma() {
    // Arrange
    PageImpl<Diploma> pageImpl = new PageImpl<>(new ArrayList<>());
    when(diplomaRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Diploma> actualShowAllDiplomaResult = diplomaService.showAllDiploma(10, 3);

    // Assert
    verify(diplomaRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllDiplomaResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllDiplomaResult);
  }

  /**
   * Method under test: {@link DiplomaService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(diplomaRepository).deleteById(Mockito.<Integer>any());
    when(diplomaRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    diplomaService.delete(1);

    // Assert that nothing has changed
    verify(diplomaRepository).deleteById(Mockito.<Integer>any());
    verify(diplomaRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link DiplomaService#update(Diploma)}
   */
  @Test
  void testUpdate() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    ArrayList<StudentDiploma> studentDiplomas = new ArrayList<>();
    diploma.setStudentDiplomas(studentDiplomas);
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");
    when(diplomaRepository.save(Mockito.<Diploma>any())).thenReturn(diploma);
    when(diplomaRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    DiplomaType diplomaType2 = new DiplomaType();
    diplomaType2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType2.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType2.setDiplomaLevel(1);
    diplomaType2.setDiplomaTypeId(1);
    diplomaType2.setDiplomaTypeName("Diploma Type Name");
    diplomaType2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType2.setUpdatedBy("2020-03-01");

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

    Diploma diploma2 = new Diploma();
    diploma2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma2.setDiplomaId(1);
    diploma2.setDiplomaName("Diploma Name");
    diploma2.setDiplomaType(diplomaType2);
    diploma2.setEstablishment(establishment2);
    diploma2.setSpecialities(new HashSet<>());
    diploma2.setStudentDiplomas(new ArrayList<>());
    diploma2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma2.setUpdatedBy("2020-03-01");

    // Act
    diplomaService.update(diploma2);

    // Assert that nothing has changed
    verify(diplomaRepository).existsById(Mockito.<Integer>any());
    verify(diplomaRepository).save(Mockito.<Diploma>any());
    assertEquals("00:00", diploma2.getCreatedAt().toLocalTime().toString());
    assertEquals("00:00", diploma2.getUpdatedAt().toLocalTime().toString());
    assertEquals("2020-03-01", diploma2.getUpdatedBy());
    assertEquals("Diploma Name", diploma2.getDiplomaName());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", diploma2.getCreatedBy());
    assertEquals(1, diploma2.getDiplomaId());
    assertTrue(diploma2.getSpecialities().isEmpty());
    assertEquals(studentDiplomas, diploma2.getStudentDiplomas());
    assertEquals(diplomaType, diploma2.getDiplomaType());
    assertEquals(establishment, diploma2.getEstablishment());
  }

  /**
   * Method under test: {@link DiplomaService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    DiplomaType diplomaType = new DiplomaType();
    diplomaType.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diplomaType.setDiplomaAbbreviation("Diploma Abbreviation");
    diplomaType.setDiplomaLevel(1);
    diplomaType.setDiplomaTypeId(1);
    diplomaType.setDiplomaTypeName("Diploma Type Name");
    diplomaType.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diplomaType.setUpdatedBy("2020-03-01");

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

    Diploma diploma = new Diploma();
    diploma.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    diploma.setDiplomaId(1);
    diploma.setDiplomaName("Diploma Name");
    diploma.setDiplomaType(diplomaType);
    diploma.setEstablishment(establishment);
    diploma.setSpecialities(new HashSet<>());
    diploma.setStudentDiplomas(new ArrayList<>());
    diploma.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    diploma.setUpdatedBy("2020-03-01");
    Optional<Diploma> ofResult = Optional.of(diploma);
    when(diplomaRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Diploma actualFindResult = diplomaService.find(1);

    // Assert
    verify(diplomaRepository).findById(Mockito.<Integer>any());
    assertSame(diploma, actualFindResult);
  }

  /**
  * Method under test: {@link DiplomaService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(diplomaRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = diplomaService.count();

    // Assert
    verify(diplomaRepository).count();
    assertEquals(3L, actualCountResult);
  }
}

