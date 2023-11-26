package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.StudentCompetence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCompetenceRepository extends JpaRepository<StudentCompetence,Integer> {

    Page<StudentCompetence> findAll(Pageable pageable);

}
