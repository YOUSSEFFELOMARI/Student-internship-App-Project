package ma.uiz.observatoire.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ChatAccountDTO {
    private int accountId;
    private String userName;
    private int conversationId;
    private String lastMessage;
    private String imageUrl="images/Unknown_person.jpg";
}
