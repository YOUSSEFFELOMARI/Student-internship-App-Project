package ma.uiz.observatoire.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.Company;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  private String token;
  private AccountDTO user;
  private Company company;
  private StudentDTO student;
}
