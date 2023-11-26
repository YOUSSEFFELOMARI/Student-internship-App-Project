package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Company extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int companyId;

    private String companySiret;

    private String companyName;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid Mobile number")
    private String companyPhone;

    @Email(message = "Please provide a valid email address")
    private String companyEmail;

    @URL(message = "Please provide a valid website address")
    private String companyWebsite;

    @Cascade(MERGE)
    @ManyToMany( cascade = CascadeType.PERSIST)
    @JoinTable(name = "company_domain",
            joinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "companyId")},
            inverseJoinColumns = {@JoinColumn(name = "domain_id", referencedColumnName = "domainId")}
    )
    private Set<Domain> domains = new HashSet<>();

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_form_id", referencedColumnName = "legalFormId")
    private CompanyLegalForm companyLegalForm;

    @Cascade(MERGE)
    @OneToMany(mappedBy = "company")
    private Set<CompanyResponsible> companyResponsibles = new HashSet<>();

    private String imageUrl;

}
