package ma.uiz.observatoire.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class University extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @JsonProperty("key")
    private int universityId;

    private String universityTitle;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid Mobile number")
    private String universityPhone;

    @Email(message = "Please provide a valid email address")
    private String universityEmail;

    @URL(message = "Please provide a valid website address")
    private String universityWebsite;
    private String imageUrl;
}
