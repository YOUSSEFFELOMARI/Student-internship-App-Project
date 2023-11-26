package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    @Override
    Page<Company> findAll(Pageable pageable);

    Optional<Company> findByCompanyName(String s);
    Optional<Company> findByCompanySiret(String s);

    @Query("SELECT c FROM Company c WHERE c.companyName LIKE %?1%"
            + " OR c.companyEmail LIKE %?2%"
            + " OR c.companyPhone LIKE %?3%"
            + " OR c.companyWebsite LIKE %?4%")
    List<Company> searchAll(String name,String email,String phone,String website);


}
