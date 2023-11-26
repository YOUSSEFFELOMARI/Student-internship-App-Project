package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyResponsibleRepository extends JpaRepository<CompanyResponsible,Integer> {
    Optional<CompanyResponsible> findByAccount(Account account);
    Optional<CompanyResponsible> findByCompanyCompanyId(int id);
}
