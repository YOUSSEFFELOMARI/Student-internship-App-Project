package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class StudentExperience extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int ExperienceId;

    private String experienceDescription;

    private Date startDate;

    private Date endDate;
}
