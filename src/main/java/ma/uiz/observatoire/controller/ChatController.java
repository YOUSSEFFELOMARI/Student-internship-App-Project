package ma.uiz.observatoire.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.ChatAccountDTO;
import ma.uiz.observatoire.dto.MessageDTO;
import ma.uiz.observatoire.mapper.AccountMapper;
import ma.uiz.observatoire.mapper.ChatAccountMapper;
import ma.uiz.observatoire.mapper.MessageMapper;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    final private SimpMessagingTemplate simpMessagingTemplate;
    final private ConversationRepository conversationRepository;
    final private MessageRepository messageRepository;
    final private ChatAccountMapper accountMapper;
    final private MessageMapper messageMapper;
    final private AccountRepository accountRepository;
    final private CompanyResponsibleRepository companyResponsibleRepository;

    @MessageMapping("/private-message")
    public MessageDTO recMessage(@Payload MessageDTO messageDTO){
        Message message=messageMapper.mapToModel(messageDTO);
        message=messageRepository.save(message);
        messageDTO=messageMapper.mapToDto(message);
        List<Account> accounts = accountRepository.findAccountByConversationsConversationId(messageDTO.getConversation());
        for (Account m : accounts){
            simpMessagingTemplate.convertAndSendToUser(String.valueOf(m.getAccountId()), "/private", messageDTO);
        };
        return messageDTO;
    }

    @GetMapping("/conversations")
    public ResponseEntity<Set<ChatAccountDTO>> getUserConversations() {
        Account user= (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Account> accounts=conversationRepository.findAccountByParticipantId(user.getAccountId());
        Set<ChatAccountDTO> contacts=accounts.stream().map(accountMapper::mapToDto).collect(Collectors.toSet());
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<List<MessageDTO>> getUserMessages(@PathVariable(name = "id") int id) {
        List<Message> messages=messageRepository.findMessageByConversationConversationId(id, Pageable.unpaged());
        return ResponseEntity.ok(messages.stream().map(messageMapper::mapToDto).collect(Collectors.toList()));
    }

    @GetMapping("/conversations/{id}")
    public ResponseEntity<ChatAccountDTO> getConversation(@PathVariable(name = "id") int id) {
        Account user= (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Conversation> conversation=conversationRepository.findConversationIdByParticipantIds(
                user.getAccountId(),id);
        if(conversation.isPresent())
            for (Account a:accountRepository.findAccountByConversationsConversationId(conversation.get()
                    .getConversationId()))
            {
                if(user.getAccountId()!=a.getAccountId())
                    return ResponseEntity.ok(accountMapper.mapToDto(a));
            };
        Optional<Account> otherUser=accountRepository.findById(id);
        Set<Account> participants= new HashSet<>();
        if (otherUser.isPresent()) {
            participants.add(user);
            participants.add(otherUser.get());
            Conversation newConversation = new Conversation();
            newConversation.setParticipants(participants);
            conversationRepository.save(newConversation);
            return ResponseEntity.ok(accountMapper.mapToDto(otherUser.get()));
        }
        else throw new EntityNotFoundException("Entity not found - ID : "+id) {};
    }

    @PostMapping("/conversations/company/{id}")
    public ResponseEntity<ChatAccountDTO> getCompanyConversation(@PathVariable(name = "id") int id){
        Optional<CompanyResponsible> responsible= companyResponsibleRepository.findByCompanyCompanyId(id);
        if(responsible.isPresent()){
            return getConversation(responsible.get().getAccount().getAccountId());
        }
        else throw new EntityNotFoundException("Company not found - ID : "+id) {};
    }
}
