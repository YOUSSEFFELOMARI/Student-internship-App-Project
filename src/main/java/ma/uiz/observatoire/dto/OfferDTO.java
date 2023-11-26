package ma.uiz.observatoire.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ma.uiz.observatoire.model.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class OfferDTO {

    private int offerId;
    private String offerName;
    private String description;
    private String assignmentCity;
    private double salaryMin;
    private double salaryMax;
    private String publicationDate;
    private String expirationDate;
    private CompanyDTO company;
   // private Set<Integer> applications = new HashSet<>();
    private Set<String> diplomaTypes=new HashSet<>();
    private Set<String> languages=new HashSet<>();
    private Set<String> domains=new HashSet<>();

}
