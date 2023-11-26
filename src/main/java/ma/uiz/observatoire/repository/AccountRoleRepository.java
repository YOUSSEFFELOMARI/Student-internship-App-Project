package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRoleRepository extends JpaRepository<AccountRole,Integer> {
    Optional<AccountRole> findByRoleName(String roleName);
}