package ma.uiz.observatoire.mapper;

import jakarta.persistence.EntityNotFoundException;
import ma.uiz.observatoire.dto.MessageDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Conversation;
import ma.uiz.observatoire.model.Message;
import ma.uiz.observatoire.repository.AccountRepository;
import ma.uiz.observatoire.repository.ConversationRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


@Mapper(componentModel = "spring")
public abstract class MessageMapper {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Mapping(source = "sender.accountId",target = "sender")
    @Mapping(source = "conversation.conversationId",target = "conversation")
    public abstract MessageDTO mapToDto(Message message);

    public abstract Message mapToModel(MessageDTO message);

    @AfterMapping
    public void afterMapping(@MappingTarget Message message) {
        message.setSentAt(new Date());
    }
    protected Account mapIdToAccount(int id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Account not found - ID : "+id) {});
    }

    protected Conversation mapIdToConversation(int id) {
        return conversationRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Conversation not found - ID : "+id) {});
    }

    protected String mapDateToFormattedDate(Date date){
        if(date==null) return "";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }
}
