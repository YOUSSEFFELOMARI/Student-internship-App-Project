package ma.uiz.observatoire.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Conversation.class})
@ExtendWith(SpringExtension.class)
class ConversationTest {
  @Autowired
  private Conversation conversation;

  /**
   * Method under test: {@link Conversation#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Conversation()).canEqual("Other"));
  }

  /**
   * Method under test: {@link Conversation#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Conversation conversation2 = new Conversation();

    Conversation conversation3 = new Conversation();
    conversation3.setConversationId(1);
    conversation3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation3.setMessages(new HashSet<>());
    conversation3.setParticipants(new HashSet<>());
    conversation3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertTrue(conversation2.canEqual(conversation3));
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Conversation}
  *   <li>{@link Conversation#setConversationId(int)}
  *   <li>{@link Conversation#setMessages(Set)}
  *   <li>{@link Conversation#setParticipants(Set)}
  *   <li>{@link Conversation#toString()}
  *   <li>{@link Conversation#getConversationId()}
  *   <li>{@link Conversation#getMessages()}
  *   <li>{@link Conversation#getParticipants()}
  * </ul>
  */
  @Test
  void testConstructor() {
    // Arrange and Act
    Conversation actualConversation = new Conversation();
    actualConversation.setConversationId(1);
    HashSet<Message> messages = new HashSet<>();
    actualConversation.setMessages(messages);
    HashSet<Account> participants = new HashSet<>();
    actualConversation.setParticipants(participants);
    String actualToStringResult = actualConversation.toString();
    int actualConversationId = actualConversation.getConversationId();
    Set<Message> actualMessages = actualConversation.getMessages();

    // Assert that nothing has changed
    assertEquals("Conversation(conversationId=1, participants=[], messages=[])", actualToStringResult);
    assertEquals(1, actualConversationId);
    assertSame(messages, actualMessages);
    assertSame(participants, actualConversation.getParticipants());
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
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

    // Act and Assert
    assertNotEquals(conversation, null);
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
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

    // Act and Assert
    assertNotEquals(conversation, "Different type to Conversation");
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Conversation#equals(Object)}
   *   <li>{@link Conversation#hashCode()}
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

    // Act and Assert
    assertEquals(conversation, conversation);
    int expectedHashCodeResult = conversation.hashCode();
    assertEquals(expectedHashCodeResult, conversation.hashCode());
  }

  /**
   * Methods under test: 
   * 
   * <ul>
   *   <li>{@link Conversation#equals(Object)}
   *   <li>{@link Conversation#hashCode()}
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

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(conversation, conversation2);
    int expectedHashCodeResult = conversation.hashCode();
    assertEquals(expectedHashCodeResult, conversation2.hashCode());
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Conversation conversation = new Conversation();
    conversation.setConversationId(2);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(conversation, conversation2);
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
   */
  @Test
  void testEquals6() {
    // Arrange
    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.now().atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(new HashSet<>());
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(conversation, conversation2);
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
   */
  @Test
  void testEquals7() {
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
    message.setStatus("Jan 1, 2020 8:00am GMT+0100");

    HashSet<Message> messages = new HashSet<>();
    messages.add(message);

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(messages);
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    Conversation conversation3 = new Conversation();
    conversation3.setConversationId(1);
    conversation3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation3.setMessages(new HashSet<>());
    conversation3.setParticipants(new HashSet<>());
    conversation3.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation3.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(conversation2, conversation3);
  }

  /**
   * Method under test: {@link Conversation#equals(Object)}
   */
  @Test
  void testEquals8() {
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

    HashSet<Account> participants = new HashSet<>();
    participants.add(account);

    Conversation conversation = new Conversation();
    conversation.setConversationId(1);
    conversation.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation.setMessages(new HashSet<>());
    conversation.setParticipants(participants);
    conversation.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation.setUpdatedBy("2020-03-01");

    Conversation conversation2 = new Conversation();
    conversation2.setConversationId(1);
    conversation2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    conversation2.setMessages(new HashSet<>());
    conversation2.setParticipants(new HashSet<>());
    conversation2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    conversation2.setUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(conversation, conversation2);
  }
}

