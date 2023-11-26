package ma.uiz.observatoire.dto;
import lombok.Data;
import java.util.Set;

@Data
public class    AccountDTO {
    private int accountId;
    private String userName;
    private Set<String> roles;
    private String imageUrl="images/Unknown_person.jpg";
}
