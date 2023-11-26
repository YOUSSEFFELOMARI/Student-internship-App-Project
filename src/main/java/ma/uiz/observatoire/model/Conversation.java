package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Conversation extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int conversationId;

    @Cascade(MERGE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_conversation",
            joinColumns = {@JoinColumn(name = "conversation_id", referencedColumnName = "conversationId")},
            inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "accountId")}
    )
    private Set<Account> participants = new HashSet<>();

    @Cascade(MERGE)
    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages=new HashSet<>();
}
