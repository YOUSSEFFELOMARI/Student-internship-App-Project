package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CompanyResponsible extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int responsibleId;

    private String name;

    private String lastName;

    private String position;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "companyId")
    private Company company;

    @Cascade(MERGE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

}
