package ma.uiz.observatoire.model;


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

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Establishment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int establishmentId;

    private String establishmentTitle;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid Mobile number")
    private String establishmentPhone;

    @Email(message = "Please provide a valid email address")
    private String establishmentEmail;

    @URL(message = "Please provide a valid website address")
    private String establishmentWebSite;

    @Cascade(MERGE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id", referencedColumnName = "universityId")
    private University university;
    private String imageUrl;
}
