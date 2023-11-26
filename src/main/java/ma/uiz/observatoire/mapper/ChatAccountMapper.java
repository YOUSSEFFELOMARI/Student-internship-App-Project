package ma.uiz.observatoire.mapper;

import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.ChatAccountDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.*;
import ma.uiz.observatoire.utils.ImgUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class ChatAccountMapper {
    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CompanyResponsibleRepository companyResponsibleRepository;


    public abstract ChatAccountDTO mapToDto(Account account);

    @AfterMapping
    public void afterMapping(@MappingTarget ChatAccountDTO chatAccountDTO,Account account) {
        Account sessionAccount= (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Conversation> conversation=conversationRepository.findConversationIdByParticipantIds(chatAccountDTO.
                        getAccountId(), sessionAccount.getAccountId());
        Optional<Student> student=studentRepository.findByAccount(account);
        Optional<CompanyResponsible> companyResponsible=companyResponsibleRepository.findByAccount(account);
        conversation.ifPresent(c-> {
            List<Message> messages = messageRepository.findMessageByConversationConversationId(c.getConversationId(),
                    PageRequest.of(0, 1, Sort.Direction.DESC, "messageId"));
            if (!messages.isEmpty())
                chatAccountDTO.setLastMessage(messages.get(0).getContent());
            chatAccountDTO.setConversationId(c.getConversationId());
        });
        student.ifPresent(s->{
            if(s.getImageUrl()!=null) chatAccountDTO.setImageUrl(s.getImageUrl());
            if(s.getName()!=null) chatAccountDTO.setUserName(s.getName());
        });
        companyResponsible.ifPresent(c->{
            if(c.getCompany().getImageUrl()!=null) chatAccountDTO.setImageUrl(c.getCompany().getImageUrl());
            if(c.getCompany().getCompanyName()!=null) chatAccountDTO.setUserName(c.getCompany().getCompanyName());
        });
    }

}
