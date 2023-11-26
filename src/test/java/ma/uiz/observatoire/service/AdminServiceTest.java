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
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Admin;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.AdminRepository;
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

@ContextConfiguration(classes = {AdminService.class})
@ExtendWith(SpringExtension.class)
class AdminServiceTest {
  @MockBean
  private AdminRepository adminRepository;

  @Autowired
  private AdminService adminService;
  /**
   * Method under test: {@link AdminService#showAllAdmin(int, int)}
   */
  @Test
  void testShowAllAdmin() {
    // Arrange
    PageImpl<Admin> pageImpl = new PageImpl<>(new ArrayList<>());
    when(adminRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    Page<Admin> actualShowAllAdminResult = adminService.showAllAdmin(10, 3);

    // Assert
    verify(adminRepository).findAll(Mockito.<Pageable>any());
    assertTrue(actualShowAllAdminResult.toList().isEmpty());
    assertSame(pageImpl, actualShowAllAdminResult);
  }

  /**
  * Method under test: {@link AdminService#delete(int)}
  */
  @Test
  void testDelete() {
    // Arrange
    doNothing().when(adminRepository).deleteById(Mockito.<Integer>any());
    when(adminRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

    // Act
    adminService.delete(1);

    // Assert that nothing has changed
    verify(adminRepository).deleteById(Mockito.<Integer>any());
    verify(adminRepository).existsById(Mockito.<Integer>any());
  }

  /**
   * Method under test: {@link AdminService#update(Admin)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");
    when(adminRepository.save(Mockito.<Admin>any())).thenReturn(admin);
    when(adminRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

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

    Admin admin2 = new Admin();
    admin2.setAccount(account2);
    admin2.setAdminId(1);
    admin2.setAdminLastname("Doe");
    admin2.setAdminName("Admin Name");
    admin2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin2.setUniversity(university2);
    admin2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin2.setUpdatedBy("2020-03-01");

    // Act
    adminService.update(admin2);

    // Assert that nothing has changed
    verify(adminRepository).existsById(Mockito.<Integer>any());
    verify(adminRepository).save(Mockito.<Admin>any());
    assertEquals("1970-01-01", admin2.getCreatedAt().toLocalDate().toString());
    assertEquals("1970-01-01", admin2.getUpdatedAt().toLocalDate().toString());
    assertEquals("2020-03-01", admin2.getUpdatedBy());
    assertEquals("Admin Name", admin2.getAdminName());
    assertEquals("Doe", admin2.getAdminLastname());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", admin2.getCreatedBy());
    assertEquals(1, admin2.getAdminId());
    assertEquals(account, admin2.getAccount());
    assertEquals(university, admin2.getUniversity());
  }

  /**
   * Method under test: {@link AdminService#find(int)}
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

    Admin admin = new Admin();
    admin.setAccount(account);
    admin.setAdminId(1);
    admin.setAdminLastname("Doe");
    admin.setAdminName("Admin Name");
    admin.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    admin.setUniversity(university);
    admin.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    admin.setUpdatedBy("2020-03-01");
    Optional<Admin> ofResult = Optional.of(admin);
    when(adminRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Admin actualFindResult = adminService.find(1);

    // Assert
    verify(adminRepository).findById(Mockito.<Integer>any());
    assertSame(admin, actualFindResult);
  }
}

