package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Diploma extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int diplomaId;

    private String diplomaName;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diplomaType_id")
    private DiplomaType diplomaType;

    @Cascade(MERGE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "diploma_speciality",
            joinColumns = {@JoinColumn(name = "diploma_id", referencedColumnName = "diplomaId")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id", referencedColumnName = "specialityId")}
    )
    private Set<Speciality> specialities = new HashSet<>();

    @Cascade(MERGE)
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "studentDiplomaId.diploma")
    @JsonBackReference
    private List<StudentDiploma> studentDiplomas = new ArrayList<>();
}
