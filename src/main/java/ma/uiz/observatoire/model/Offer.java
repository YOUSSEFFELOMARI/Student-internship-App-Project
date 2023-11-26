package ma.uiz.observatoire.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

import static org.hibernate.annotations.CascadeType.ALL;
import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Offer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int offerId;

    private String offerName;

    @Column( length = 5000)
    private String Description;

    private String assignmentCity;

    private double salaryMin;

    private double salaryMax;

    private Date publicationDate;

    private Date ExpirationDate;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "companyId")
    private Company company;

    @Cascade(ALL)
    @OneToMany(mappedBy = "applicationPk.offer")
    private Set<Application> applications = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "offer_diploma_type",
            joinColumns = {@JoinColumn(name = "offer_id", referencedColumnName = "offerId")},
            inverseJoinColumns = {@JoinColumn(name = "diploma_type_id", referencedColumnName = "diplomaTypeId")}
    )
    private Set<DiplomaType> diplomaTypes=new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "offer_student_language",
            joinColumns = {@JoinColumn(name = "offer_id", referencedColumnName = "offerId")},
            inverseJoinColumns = {@JoinColumn(name = "language_id", referencedColumnName = "languageId")}
    )
    private Set<StudentLanguage> studentLanguages=new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "offer_domain",
            joinColumns = {@JoinColumn(name = "offer_id", referencedColumnName = "offerId")},
            inverseJoinColumns = {@JoinColumn(name = "domain_id", referencedColumnName = "domainId")}
    )
    private Set<Domain> domains=new HashSet<>();


}
