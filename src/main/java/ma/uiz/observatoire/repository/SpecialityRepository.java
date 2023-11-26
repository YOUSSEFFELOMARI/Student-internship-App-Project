package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {
}
