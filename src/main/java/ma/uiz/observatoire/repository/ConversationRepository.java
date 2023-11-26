package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Conversation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    @Query("select a from Account a where a in (SELECT c.participants FROM Conversation c " +
            "left join c.participants p join p.conversations on p.accountId=:id " +
            "order by (select max(m.sentAt) from c.messages m)) " +
            "and a.accountId<>:id" )
    List<Account> findAccountByParticipantId(int id);

    @Query("select c2 from Conversation c2 where c2 in (SELECT c1 FROM Conversation c1 " +
            "left join c1.participants p join p.conversations on p.accountId=:id1) " +
            "and :id2 in (select x.accountId from c2.participants x)")
    Optional<Conversation> findConversationIdByParticipantIds(int id1, int id2);
}
