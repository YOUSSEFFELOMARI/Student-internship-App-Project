package ma.uiz.observatoire.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ma.uiz.observatoire.model.*;

import java.util.HashSet;
import java.util.Set;
@Data
public class StudentDTO {


    private int studentId;
    private String name;
    private String lastName;
    private Integer account;
    private Set<Integer> studentDiplomas = new HashSet<>();
//    private Set<Integer> Application = new HashSet<>();
    private Set<Integer> certificates = new HashSet<>();
    private Set<Integer> experiences = new HashSet<>();
    private Set<Integer> hobbies = new HashSet<>();
    private Set<Integer> languages = new HashSet<>();
    private Set<Integer> skills = new HashSet<>();
    private Set<Integer> licences = new HashSet<>();
}
