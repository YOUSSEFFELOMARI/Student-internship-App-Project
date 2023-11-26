package ma.uiz.observatoire.dto;

import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class MessageDTO {
    private int messageId;

    private String content;

    private String status;

    private String sentAt;

    private int conversation;

    private int sender;
}
