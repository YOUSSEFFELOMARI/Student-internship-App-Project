package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class StudentDiploma extends BaseEntity {
    @Data
    @Embeddable
    public static class StudentDiplomaPk implements Serializable {
        @Cascade(MERGE)
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "student_id")
        @JsonIgnoreProperties("studentDiplomas")
        private Student student;

        @Cascade(MERGE)
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "diploma_id")
        @JsonIgnoreProperties("studentDiplomas")
        private Diploma diploma;
    }
    @EmbeddedId
    @JsonProperty("key")
    private StudentDiplomaPk studentDiplomaId=new StudentDiplomaPk();

    private LocalDate currentYear;
    private LocalDate startYear;
    private LocalDate endYear;

}
