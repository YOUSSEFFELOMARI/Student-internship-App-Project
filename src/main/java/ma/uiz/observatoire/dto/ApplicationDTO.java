package ma.uiz.observatoire.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ma.uiz.observatoire.model.Application;

import java.util.Date;

@Data
public class ApplicationDTO {
    private OfferDTO offer;
    private StudentDTO student;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date applicationDate;
    private Application.AppStatus status;
}
