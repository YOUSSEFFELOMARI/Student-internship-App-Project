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
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Domain extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int domainId;

    private String domainName;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "domain_speciality",
            joinColumns = {@JoinColumn(name = "domain_id", referencedColumnName = "domainId")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id", referencedColumnName = "specialityId")}
    )
    private Set<Speciality> specialities = new HashSet<>();

}
