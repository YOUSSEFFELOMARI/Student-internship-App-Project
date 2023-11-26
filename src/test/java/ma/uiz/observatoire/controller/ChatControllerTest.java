package ma.uiz.observatoire.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import ma.uiz.observatoire.dto.MessageDTO;
import ma.uiz.observatoire.mapper.ChatAccountMapper;
import ma.uiz.observatoire.mapper.MessageMapper;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Conversation;
import ma.uiz.observatoire.model.Message;
import ma.uiz.observatoire.repository.AccountRepository;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import ma.uiz.observatoire.repository.ConversationRepository;
import ma.uiz.observatoire.repository.MessageRepository;
import org.apache.catalina.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.users.MemoryUserDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ChatController.class})
@ExtendWith(SpringExtension.class)
class ChatControllerTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private ChatAccountMapper chatAccountMapper;

  @Autowired
  private ChatController chatController;

  @MockBean
  private CompanyResponsibleRepository companyResponsibleRepository;

  @MockBean
  private ConversationRepository conversationRepository;

  @MockBean
  private MessageMapper messageMapper;

  @MockBean
  private MessageRepository messageRepository;

  @MockBean
  private SimpMessagingTemplate simpMessagingTemplate;
  /**
  * Method under test: {@link ChatController#getCompanyConversation(int)}
  */
  @Test
  void testGetCompanyConversation() throws Exception {
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

    CompanyLegalForm companyLegalForm = new CompanyLegalForm();
    companyLegalForm.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyLegalForm.setLegalFormId(1);
    companyLegalForm.setLegalFormName("Legal Form Name");
    companyLegalForm.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyLegalForm.setUpdatedBy("2020-03-01");

    Company company = new Company();
    company.setAddress1("42 Main St");
    company.setAddress2("42 Main St");
    company.setCity("Oxford");
    company.setCompanyEmail("jane.doe@example.org");
    company.setCompanyId(1);
    company.setCompanyLegalForm(companyLegalForm);
    company.setCompanyName("Company Name");
    company.setCompanyPhone("6625550144");
    company.setCompanyResponsibles(new HashSet<>());
    company.setCompanySiret("Company Siret");
    company.setCompanyWebsite("Company Website");
    company.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    company.setDomains(new HashSet<>());
    company.setImageUrl("https://example.org/example");
    company.setRegion("us-east-2");
    company.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    company.setUpdatedBy("2020-03-01");
    company.setZipCode("21654");

    CompanyResponsible companyResponsible = new CompanyResponsible();
    companyResponsible.setAccount(account);
    companyResponsible.setCompany(company);
    companyResponsible.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    companyResponsible.setLastName("Doe");
    companyResponsible.setName("Name");
    companyResponsible.setPosition("Position");
    companyResponsible.setResponsibleId(1);
    companyResponsible.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    companyResponsible.setUpdatedBy("2020-03-01");
    Optional<CompanyResponsible> ofResult = Optional.of(companyResponsible);
    when(companyResponsibleRepository.findByCompanyCompanyId(anyInt())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/api/v1/chat/conversations/company/{id}", "Uri Variables", "Uri Variables");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(chatController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test: {@link ChatController#recMessage(MessageDTO)}
   */
  @Test
  void testRecMessage() {
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
    when(messageRepository.save(Mockito.<Message>any())).thenReturn(message);

    MessageDTO messageDTO = new MessageDTO();
    messageDTO.setContent("Not all who wander are lost");
    messageDTO.setConversation(1);
    messageDTO.setMessageId(1);
    messageDTO.setSender(3);
    messageDTO.setSentAt("Sent At");
    messageDTO.setStatus("Status");

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
    when(messageMapper.mapToDto(Mockito.<Message>any())).thenReturn(messageDTO);
    when(messageMapper.mapToModel(Mockito.<MessageDTO>any())).thenReturn(message2);
    when(accountRepository.findAccountByConversationsConversationId(anyInt())).thenReturn(new ArrayList<>());

    MessageDTO messageDTO2 = new MessageDTO();
    messageDTO2.setContent("Not all who wander are lost");
    messageDTO2.setConversation(1);
    messageDTO2.setMessageId(1);
    messageDTO2.setSender(3);
    messageDTO2.setSentAt("Sent At");
    messageDTO2.setStatus("Status");

    // Act
    MessageDTO actualRecMessageResult = chatController.recMessage(messageDTO2);

    // Assert
    verify(messageMapper).mapToDto(Mockito.<Message>any());
    verify(messageMapper).mapToModel(Mockito.<MessageDTO>any());
    verify(accountRepository).findAccountByConversationsConversationId(anyInt());
    verify(messageRepository).save(Mockito.<Message>any());
    assertSame(messageDTO, actualRecMessageResult);
  }

  /**
   * Method under test: {@link ChatController#getConversation(int)}
   */
  @Test
  void testGetConversation() throws Exception {
    // Arrange
    User user = mock(User.class);
    when(user.getName()).thenReturn("Name");
    UserDatabaseRealm.UserDatabasePrincipal principal = new UserDatabaseRealm.UserDatabasePrincipal(user,
        new MemoryUserDatabase());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/chat/conversations/{id}",
        "Uri Variables", "Uri Variables");
    requestBuilder.principal(principal);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(chatController).build().perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Method under test: {@link ChatController#getUserMessages(int)}
   */
  @Test
  void testGetUserMessages() throws Exception {
    // Arrange
    when(messageRepository.findMessageByConversationConversationId(anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/chat/messages/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(chatController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<List/>"));
  }
}

