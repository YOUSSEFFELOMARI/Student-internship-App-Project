package ma.uiz.observatoire.service;

import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.AccountRole;
import ma.uiz.observatoire.model.Conversation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtService.class})
@ExtendWith(SpringExtension.class)
class JwtServiceTest {
  @MockBean
  private AccountRoleService accountRoleService;

  @Autowired
  private JwtService jwtService;
  /**
  * Method under test: {@link JwtService#generateToken(Map, UserDetails)}
  */
  @Test
  void testGenerateToken() {
    // Arrange
    HashMap<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("foo", "42");
    extraClaims.put("404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970", "42");
    Account userDetails = mock(Account.class);
    when(userDetails.getUsername()).thenReturn("janedoe");

    // Act
    jwtService.generateToken(extraClaims, userDetails);

    // Assert
    verify(userDetails).getUsername();
  }

  /**
   * Method under test: {@link JwtService#generateToken(Account)}
   */
  @Test
  void testGenerateToken2() {
    // Arrange
    Account account = mock(Account.class);
    when(account.getUsername()).thenReturn("janedoe");
    doNothing().when(account).setAccountId(anyInt());
    doNothing().when(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(account).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(account).setEmail(Mockito.<String>any());
    doNothing().when(account).setEnabled(anyBoolean());
    doNothing().when(account).setMobileNumber(Mockito.<String>any());
    doNothing().when(account).setPassword(Mockito.<String>any());
    doNothing().when(account).setUserName(Mockito.<String>any());
    doNothing().when(account).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setCreatedBy(Mockito.<String>any());
    doNothing().when(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(account).setUpdatedBy(Mockito.<String>any());
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

    // Act
    jwtService.generateToken(account);

    // Assert
    verify(account).getUsername();
    verify(account).setAccountId(anyInt());
    verify(account).setAccountRoles(Mockito.<Set<AccountRole>>any());
    verify(account).setConversations(Mockito.<Set<Conversation>>any());
    verify(account).setEmail(Mockito.<String>any());
    verify(account).setEnabled(anyBoolean());
    verify(account).setMobileNumber(Mockito.<String>any());
    verify(account).setPassword(Mockito.<String>any());
    verify(account).setUserName(Mockito.<String>any());
    verify(account).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(account).setCreatedBy(Mockito.<String>any());
    verify(account).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(account).setUpdatedBy(Mockito.<String>any());
  }
}

