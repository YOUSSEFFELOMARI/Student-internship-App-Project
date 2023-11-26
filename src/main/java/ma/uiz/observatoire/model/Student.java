package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int studentId;

    private String name;

    private String lastName;

    private String CIN;

    @Cascade(MERGE)
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @Cascade(MERGE)
    @OneToMany(mappedBy = "studentDiplomaId.student")
    private Set<StudentDiploma> studentDiplomas = new HashSet<>();

//    @Cascade(ALL)
    @OneToMany(mappedBy = "applicationPk.student", cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "certificate_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "certificate_id", referencedColumnName = "certificateId")}
    )
    private Set<StudentCertificate> certificates = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "experience_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "experience_id", referencedColumnName = "experienceId")}
    )
    private Set<StudentExperience> experiences = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "hobby_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "hobby_id", referencedColumnName = "hobbyId")}
    )
    private Set<StudentHobby> hobbies = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "language_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "language_id", referencedColumnName = "languageId")}
    )
    private Set<StudentLanguage> languages = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "skill_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "skillId")}
    )
    private Set<StudentSkill> skills = new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany
    @JoinTable(name = "licences_student",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "licence_id", referencedColumnName = "licenceId")}
    )
    private Set<StudentLicence> licences = new HashSet<>();
    private String imageUrl;
}
