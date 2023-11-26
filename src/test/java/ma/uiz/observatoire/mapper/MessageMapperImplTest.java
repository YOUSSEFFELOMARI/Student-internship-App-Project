package ma.uiz.observatoire.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import ma.uiz.observatoire.dto.MessageDTO;
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
class MessageMapperImplTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private ConversationRepository conversationRepository;

  @Autowired
  private MessageMapperImpl messageMapperImpl;
  /**
  * Method under test: {@link MessageMapperImpl#mapToDto(Message)}
  */
  @Test
  void testMapToDto() {
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

    Message message = new Message();
    message.setContent("Not all who wander are lost");
    message.setConversation(conversation);
    message.setMessageId(1);
    message.setSender(sender);
    message.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    // Act
    MessageDTO actualMapToDtoResult = messageMapperImpl.mapToDto(message);

    // Assert
    assertEquals("Not all who wander are lost", actualMapToDtoResult.getContent());
    assertEquals("Status", actualMapToDtoResult.getStatus());
    assertEquals(1, actualMapToDtoResult.getConversation());
    assertEquals(1, actualMapToDtoResult.getMessageId());
    assertEquals(1, actualMapToDtoResult.getSender());
  }

  /**
   * Method under test: {@link MessageMapperImpl#mapToDto(Message)}
   */
  @Test
  void testMapToDto2() {
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

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");
    Message message = mock(Message.class);
    when(message.getMessageId()).thenReturn(1);
    when(message.getContent()).thenReturn("Not all who wander are lost");
    when(message.getStatus()).thenReturn("Status");
    when(message.getSentAt())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(message.getSender()).thenReturn(account);
    when(message.getConversation()).thenReturn(conversation2);
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
    MessageDTO actualMapToDtoResult = messageMapperImpl.mapToDto(message);

    // Assert
    verify(message).getContent();
    verify(message).getConversation();
    verify(message).getMessageId();
    verify(message).getSender();
    verify(message).getSentAt();
    verify(message).getStatus();
    verify(message).setContent(Mockito.<String>any());
    verify(message).setConversation(Mockito.<Conversation>any());
    verify(message).setMessageId(anyInt());
    verify(message).setSender(Mockito.<Account>any());
    verify(message).setSentAt(Mockito.<Date>any());
    verify(message).setStatus(Mockito.<String>any());
    assertEquals("Not all who wander are lost", actualMapToDtoResult.getContent());
    assertEquals("Status", actualMapToDtoResult.getStatus());
    assertEquals(1, actualMapToDtoResult.getConversation());
    assertEquals(1, actualMapToDtoResult.getMessageId());
    assertEquals(1, actualMapToDtoResult.getSender());
  }

  /**
   * Method under test: {@link MessageMapperImpl#mapToModel(MessageDTO)}
   */
  @Test
  void testMapToModel() {
    // Arrange
    MessageDTO message = new MessageDTO();
    message.setContent("Not all who wander are lost");
    message.setConversation(1);
    message.setMessageId(1);
    message.setSender(3);
    message.setSentAt("Sent At");
    message.setStatus("Status");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> messageMapperImpl.mapToModel(message));
  }
}

