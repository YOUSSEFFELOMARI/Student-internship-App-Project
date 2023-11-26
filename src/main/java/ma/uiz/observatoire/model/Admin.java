package ma.uiz.observatoire.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int adminId;

    private String adminName;

    private String adminLastname;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", referencedColumnName = "universityId")
    private University university;

    @Cascade(MERGE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;
}
