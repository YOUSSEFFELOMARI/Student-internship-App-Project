package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Conversation;
import ma.uiz.observatoire.model.Message;
import ma.uiz.observatoire.repository.AccountRepository;
import ma.uiz.observatoire.repository.ConversationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageMapperImpl.class})
@ExtendWith(SpringExtension.class)
class MessageMapperTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private ConversationRepository conversationRepository;

  @Autowired
  private MessageMapper messageMapper;
  /**
  * Method under test: {@link MessageMapper#afterMapping(Message)}
  */
  @Test
  void testAfterMapping() {
    // Arrange
    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");

    Account sender = new Account();
    sender.setAccountId(1);
    sender.setAccountRoles(new HashSet<>());
    sender.setConversations(new HashSet<>());
    sender.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender.setEmail("jane.doe@example.org");
    sender.setEnabled(true);
    sender.setMobileNumber("42");
    sender.setPassword("iloveyou");
    sender.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender.setUpdatedBy("2020-03-01");
    sender.setUserName("janedoe");
    Message message = mock(Message.class);
    doNothing().when(message).setContent(Mockito.<String>any());
    doNothing().when(message).setConversation(Mockito.<Conversation>any());
    doNothing().when(message).setMessageId(anyInt());
    doNothing().when(message).setSender(Mockito.<Account>any());
    doNothing().when(message).setSentAt(Mockito.<Date>any());
    doNothing().when(message).setStatus(Mockito.<String>any());
    message.setContent("Not all who wander are lost");
    message.setConversation(conversation);
    message.setMessageId(1);
    message.setSender(sender);
    message.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    // Act
    messageMapper.afterMapping(message);

    // Assert
    verify(message).setContent(Mockito.<String>any());
    verify(message).setConversation(Mockito.<Conversation>any());
    verify(message).setMessageId(anyInt());
    verify(message).setSender(Mockito.<Account>any());
    verify(message, atLeast(1)).setSentAt(Mockito.<Date>any());
    verify(message).setStatus(Mockito.<String>any());
  }

  /**
   * Method under test: {@link MessageMapper#mapIdToAccount(int)}
   */
  @Test
  void testMapIdToAccount() {
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
    Optional<Account> ofResult = Optional.of(account);
    when(accountRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Account actualMapIdToAccountResult = messageMapper.mapIdToAccount(1);

    // Assert
    verify(accountRepository).findById(Mockito.<Integer>any());
    assertSame(account, actualMapIdToAccountResult);
  }

  /**
   * Method under test: {@link MessageMapper#mapIdToConversation(int)}
   */
  @Test
  void testMapIdToConversation() {
    // Arrange
    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Optional<Conversation> ofResult = Optional.of(conversation);
    when(conversationRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Conversation actualMapIdToConversationResult = messageMapper.mapIdToConversation(1);

    // Assert
    verify(conversationRepository).findById(Mockito.<Integer>any());
    assertSame(conversation, actualMapIdToConversationResult);
  }

  /**
   * Method under test: {@link MessageMapper#mapDateToFormattedDate(java.util.Date)}
   */
  @Test
  void testMapDateToFormattedDate() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    messageMapper.mapDateToFormattedDate(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Method under test: {@link MessageMapper#mapDateToFormattedDate(Date)}
   */
  @Test
  void testMapDateToFormattedDate2() {
    // Arrange, Act and Assert
    assertEquals("", messageMapper.mapDateToFormattedDate(null));
  }
}

