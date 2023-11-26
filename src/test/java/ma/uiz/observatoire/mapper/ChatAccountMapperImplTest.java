package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;
import ma.uiz.observatoire.model.Account;
import org.junit.jupiter.api.Test;

class ChatAccountMapperImplTest {
  /**
  * Method under test: {@link ChatAccountMapperImpl#mapToDto(Account)}
  */
  @Test
  void testMapToDto() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getPrincipal()" because the return value of "org.springframework.security.core.context.SecurityContext.getAuthentication()" is null
    //       at ma.uiz.observatoire.mapper.ChatAccountMapper.afterMapping(ChatAccountMapper.java:41)
    //       at ma.uiz.observatoire.mapper.ChatAccountMapperImpl.mapToDto(ChatAccountMapperImpl.java:27)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange, Act and Assert
    assertNull((new ChatAccountMapperImpl()).mapToDto(null));
  }
}

