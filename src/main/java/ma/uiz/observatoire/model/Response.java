package ma.uiz.observatoire.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Response {
    private final String timestamp ;
    private String statusCode;
    private String statusMsg;

    public Response( String statusCode, String statusMsg) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.timestamp = formatter.format(new Date());
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;

    }
    public Response( ) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.timestamp = formatter.format(new Date());
    }
}
