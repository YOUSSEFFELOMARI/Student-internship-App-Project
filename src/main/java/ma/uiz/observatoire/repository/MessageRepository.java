package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Conversation;
import ma.uiz.observatoire.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findMessageByConversationConversationId(int id, Pageable pageable);
}
