package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.StudentExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExperienceRepository extends JpaRepository<StudentExperience,Integer> {

    Page<StudentExperience> findAll(Pageable pageable);

}
