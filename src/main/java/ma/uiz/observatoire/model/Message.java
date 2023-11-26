package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

import static org.hibernate.annotations.CascadeType.MERGE;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int messageId;

    private String content;

    private String status;

    @Column(updatable = false)
    private Date sentAt;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId",updatable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Account sender;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conversation_id", referencedColumnName = "conversationId",updatable = false)
    private Conversation conversation;
}
