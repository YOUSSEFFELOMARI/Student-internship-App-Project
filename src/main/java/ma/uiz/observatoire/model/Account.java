package ma.uiz.observatoire.model;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static org.hibernate.annotations.CascadeType.MERGE;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @JsonProperty("key")
    private int accountId;

    @Column(unique = true)
    private String userName;

    private String password;

    @Email(message = "Please provide a valid email address")
    @Column(unique = true)
    @JsonKey
    private String email;

    private boolean enabled;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid Mobile number")
    private String mobileNumber;

    @Cascade(MERGE)
    @ManyToMany(mappedBy="participants",fetch = FetchType.EAGER)
    private Set<Conversation> conversations=new HashSet<>();

    @Cascade(MERGE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Role_AccountRole",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "accountId")},
            inverseJoinColumns = {@JoinColumn(name = "accountRole_id", referencedColumnName = "accountRoleId")}
    )
    private Set<AccountRole> accountRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountRoles;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
