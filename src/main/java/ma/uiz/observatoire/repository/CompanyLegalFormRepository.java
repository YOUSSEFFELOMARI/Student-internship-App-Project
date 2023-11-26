package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.CompanyLegalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyLegalFormRepository extends JpaRepository<CompanyLegalForm,Integer> {
}
