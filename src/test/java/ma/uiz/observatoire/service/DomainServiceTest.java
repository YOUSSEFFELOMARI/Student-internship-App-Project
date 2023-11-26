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
import java.util.List;
import java.util.Optional;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.repository.DomainRepository;
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

@ContextConfiguration(classes = {DomainService.class})
@ExtendWith(SpringExtension.class)
class DomainServiceTest {
  @MockBean
  private DomainRepository domainRepository;

  @Autowired
  private DomainService domainService;
  /**
   * Method under test: {@link DomainService#showAllDomain(int, int)}
   */
  @Test
  void testShowAllDomain() {
    // Arrange
    PageImpl<Domain> pageImpl = new PageImpl<>(new ArrayList<>());
    when(domainRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Domain> actualShowAllDomainResult = domainService.showAllDomain(10, 3);

    // Assert
    verify(domainRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllDomainResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllDomainResult);
  }

  /**
   * Method under test: {@link DomainService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ArrayList<Domain> domainList = new ArrayList<>();
    when(domainRepository.findAll()).thenReturn(domainList);

    // Act
    List<Domain> actualFindAllResult = domainService.findAll();

    // Assert
    verify(domainRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(domainList, actualFindAllResult);
  }

  /**
  * Method under test: {@link DomainService#count()}
  */
  @Test
  void testCount() {
    // Arrange
    when(domainRepository.count()).thenReturn(3L);

    // Act
    long actualCountResult = domainService.count();

    // Assert
    verify(domainRepository).count();
    assertEquals(3L, actualCountResult);
  }

  /**
   * Method under test: {@link DomainService#update(Domain)}
   */
  @Test
  void testUpdate() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    when(domainRepository.save(Mockito.<Domain>any())).thenReturn(domain);
    when(domainRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    Domain domain2 = new Domain();
    domain2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain2.setDomainId(1);
    domain2.setDomainName("Domain Name");
    domain2.setSpecialities(new HashSet<>());
    domain2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain2.setUpdatedBy("2020-03-01");

    // Act
    Domain actualUpdateResult = domainService.update(domain2);

    // Assert
    verify(domainRepository).existsById(Mockito.<Integer>any());
    verify(domainRepository).save(Mockito.<Domain>any());
    assertSame(domain, actualUpdateResult);
  }

  /**
   * Method under test: {@link DomainService#delete(int)}
   */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(domainRepository).deleteById(Mockito.<Integer>any());
    when(domainRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    domainService.delete(1);

    // Assert that nothing has changed
    verify(domainRepository).deleteById(Mockito.<Integer>any());
    verify(domainRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link DomainService#find(int)}
   */
  @Test
  void testFind() {
    // Arrange
    Domain domain = new Domain();
    domain.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    domain.setDomainId(1);
    domain.setDomainName("Domain Name");
    domain.setSpecialities(new HashSet<>());
    domain.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    domain.setUpdatedBy("2020-03-01");
    Optional<Domain> ofResult = Optional.of(domain);
    when(domainRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Domain actualFindResult = domainService.find(1);

    // Assert
    verify(domainRepository).findById(Mockito.<Integer>any());
    assertSame(domain, actualFindResult);
  }
}

