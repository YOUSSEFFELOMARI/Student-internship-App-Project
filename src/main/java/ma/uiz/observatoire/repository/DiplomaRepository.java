package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma,Integer> {
}
