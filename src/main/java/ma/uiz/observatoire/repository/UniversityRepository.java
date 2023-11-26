package ma.uiz.observatoire.repository;

import jakarta.transaction.Transactional;
import ma.uiz.observatoire.model.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {

    Page<University> findAll(Pageable pageable);


}
