package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Date;

import static org.hibernate.annotations.CascadeType.ALL;
import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Application extends BaseEntity {

    @Data
    @Embeddable
    public static class ApplicationPk implements Serializable {
//        @Cascade(ALL)
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id")
        @JsonIgnoreProperties("applications")
        private Student student;

//        @Cascade(ALL)
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "offer_id")
        @JsonIgnoreProperties("applications")
        private Offer offer;
    }
    @Cascade(ALL)
    @EmbeddedId
    @JsonProperty("key")
    ApplicationPk applicationPk = new ApplicationPk();

    @Cascade(ALL)
    private Date applicationDate;

    @Cascade(ALL)
    @Enumerated(EnumType.STRING)
    private AppStatus status;

    public enum AppStatus{
        VALIDATED,REFUSED,PENDING
    }

}
