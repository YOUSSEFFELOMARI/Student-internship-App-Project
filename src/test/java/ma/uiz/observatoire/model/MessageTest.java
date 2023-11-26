package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Message.class})
@ExtendWith(SpringExtension.class)
class MessageTest {
  @Autowired
  private Message message;

  /**
   * Method under test: {@link Message#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Message()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Message#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Message message2 = new Message();

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

    Message message3 = new Message();
    message3.setContent("Not all who wander are lost");
    message3.setConversation(conversation);
    message3.setMessageId(1);
    message3.setSender(sender);
    message3.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message3.setStatus("Status");

    // Act and Assert
    assertTrue(message2.canEqual(message3));
  }

  /**
   * Method under test: {@link Message#canEqual(Object)}
   */
  @Test
  void testCanEqual3() {
    // Arrange
    Message message2 = new Message();
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
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

    Message message3 = new Message();
    message3.setContent("Not all who wander are lost");
    message3.setConversation(conversation);
    message3.setMessageId(1);
    message3.setSender(sender);
    message3.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message3.setStatus("Status");

    // Act
    boolean actualCanEqualResult = message2.canEqual(message3);

    // Assert
    verify(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    verify(conversation).setCreatedBy(Mockito.<String>any());
    verify(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    verify(conversation).setUpdatedBy(Mockito.<String>any());
    verify(conversation).setConversationId(anyInt());
    verify(conversation).setMessages(Mockito.<Set<Message>>any());
    verify(conversation).setParticipants(Mockito.<Set<Account>>any());
    assertTrue(actualCanEqualResult);
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Message}
  *   <li>{@link Message#setContent(String)}
  *   <li>{@link Message#setConversation(Conversation)}
  *   <li>{@link Message#setMessageId(int)}
  *   <li>{@link Message#setSender(Account)}
  *   <li>{@link Message#setSentAt(Date)}
  *   <li>{@link Message#setStatus(String)}
  *   <li>{@link Message#toString()}
  *   <li>{@link Message#getContent()}
  *   <li>{@link Message#getConversation()}
  *   <li>{@link Message#getMessageId()}
  *   <li>{@link Message#getSender()}
  *   <li>{@link Message#getSentAt()}
  *   <li>{@link Message#getStatus()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Message actualMessage = new Message();
    actualMessage.setContent("Not all who wander are lost");
    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    actualMessage.setConversation(conversation);
    actualMessage.setMessageId(1);
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
    actualMessage.setSender(sender);
    Date sentAt = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualMessage.setSentAt(sentAt);
    actualMessage.setStatus("Status");
    actualMessage.toString();
    String actualContent = actualMessage.getContent();
    Conversation actualConversation = actualMessage.getConversation();
    int actualMessageId = actualMessage.getMessageId();
    Account actualSender = actualMessage.getSender();
    Date actualSentAt = actualMessage.getSentAt();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualContent);
    assertEquals("Status", actualMessage.getStatus());
    assertEquals(1, actualMessageId);
    assertSame(sender, actualSender);
    assertSame(conversation, actualConversation);
    assertSame(sentAt, actualSentAt);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals() {
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

    // Act and Assert
    assertNotEquals(message, null);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals2() {
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

    // Act and Assert
    assertNotEquals(message, "Different type to Message");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Message#equals(Object)}
   *   <li>{@link Message#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
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

    // Act and Assert
    assertEquals(message, message);
    int expectedHashCodeResult = message.hashCode();
    assertEquals(expectedHashCodeResult, message.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Message#equals(Object)}
   *   <li>{@link Message#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
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

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertEquals(message, message2);
    int expectedHashCodeResult = message.hashCode();
    assertEquals(expectedHashCodeResult, message2.hashCode());
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals5() {
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
    message.setContent("Status");
    message.setConversation(conversation);
    message.setMessageId(1);
    message.setSender(sender);
    message.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals6() {
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
    message.setContent(null);
    message.setConversation(conversation);
    message.setMessageId(1);
    message.setSender(sender);
    message.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals7() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
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

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals8() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
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
    message.setMessageId(2);
    message.setSender(sender);
    message.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals9() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Account sender = mock(Account.class);
    doNothing().when(sender).setAccountId(anyInt());
    doNothing().when(sender).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(sender).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(sender).setEmail(Mockito.<String>any());
    doNothing().when(sender).setEnabled(anyBoolean());
    doNothing().when(sender).setMobileNumber(Mockito.<String>any());
    doNothing().when(sender).setPassword(Mockito.<String>any());
    doNothing().when(sender).setUserName(Mockito.<String>any());
    doNothing().when(sender).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setCreatedBy(Mockito.<String>any());
    doNothing().when(sender).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setUpdatedBy(Mockito.<String>any());
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

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals10() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Account sender = mock(Account.class);
    doNothing().when(sender).setAccountId(anyInt());
    doNothing().when(sender).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(sender).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(sender).setEmail(Mockito.<String>any());
    doNothing().when(sender).setEnabled(anyBoolean());
    doNothing().when(sender).setMobileNumber(Mockito.<String>any());
    doNothing().when(sender).setPassword(Mockito.<String>any());
    doNothing().when(sender).setUserName(Mockito.<String>any());
    doNothing().when(sender).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setCreatedBy(Mockito.<String>any());
    doNothing().when(sender).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setUpdatedBy(Mockito.<String>any());
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
    message.setSentAt(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message.setStatus("Status");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals11() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Account sender = mock(Account.class);
    doNothing().when(sender).setAccountId(anyInt());
    doNothing().when(sender).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(sender).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(sender).setEmail(Mockito.<String>any());
    doNothing().when(sender).setEnabled(anyBoolean());
    doNothing().when(sender).setMobileNumber(Mockito.<String>any());
    doNothing().when(sender).setPassword(Mockito.<String>any());
    doNothing().when(sender).setUserName(Mockito.<String>any());
    doNothing().when(sender).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setCreatedBy(Mockito.<String>any());
    doNothing().when(sender).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setUpdatedBy(Mockito.<String>any());
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
    message.setSentAt(null);
    message.setStatus("Status");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals12() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Account sender = mock(Account.class);
    doNothing().when(sender).setAccountId(anyInt());
    doNothing().when(sender).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(sender).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(sender).setEmail(Mockito.<String>any());
    doNothing().when(sender).setEnabled(anyBoolean());
    doNothing().when(sender).setMobileNumber(Mockito.<String>any());
    doNothing().when(sender).setPassword(Mockito.<String>any());
    doNothing().when(sender).setUserName(Mockito.<String>any());
    doNothing().when(sender).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setCreatedBy(Mockito.<String>any());
    doNothing().when(sender).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setUpdatedBy(Mockito.<String>any());
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
    message.setStatus("Not all who wander are lost");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  void testEquals13() {
    // Arrange
    Conversation conversation = mock(Conversation.class);
    doNothing().when(conversation).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setCreatedBy(Mockito.<String>any());
    doNothing().when(conversation).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(conversation).setUpdatedBy(Mockito.<String>any());
    doNothing().when(conversation).setConversationId(anyInt());
    doNothing().when(conversation).setMessages(Mockito.<Set<Message>>any());
    doNothing().when(conversation).setParticipants(Mockito.<Set<Account>>any());
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");
    Account sender = mock(Account.class);
    doNothing().when(sender).setAccountId(anyInt());
    doNothing().when(sender).setAccountRoles(Mockito.<Set<AccountRole>>any());
    doNothing().when(sender).setConversations(Mockito.<Set<Conversation>>any());
    doNothing().when(sender).setEmail(Mockito.<String>any());
    doNothing().when(sender).setEnabled(anyBoolean());
    doNothing().when(sender).setMobileNumber(Mockito.<String>any());
    doNothing().when(sender).setPassword(Mockito.<String>any());
    doNothing().when(sender).setUserName(Mockito.<String>any());
    doNothing().when(sender).setCreatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setCreatedBy(Mockito.<String>any());
    doNothing().when(sender).setUpdatedAt(Mockito.<LocalDateTime>any());
    doNothing().when(sender).setUpdatedBy(Mockito.<String>any());
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
    message.setStatus(null);

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Account sender2 = new Account();
    sender2.setAccountId(1);
    sender2.setAccountRoles(new HashSet<>());
    sender2.setConversations(new HashSet<>());
    sender2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sender2.setEmail("jane.doe@example.org");
    sender2.setEnabled(true);
    sender2.setMobileNumber("42");
    sender2.setPassword("iloveyou");
    sender2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    sender2.setUpdatedBy("2020-03-01");
    sender2.setUserName("janedoe");

    Message message2 = new Message();
    message2.setContent("Not all who wander are lost");
    message2.setConversation(conversation2);
    message2.setMessageId(1);
    message2.setSender(sender2);
    message2.setSentAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    message2.setStatus("Status");

    // Act and Assert
    assertNotEquals(message, message2);
  }
}

