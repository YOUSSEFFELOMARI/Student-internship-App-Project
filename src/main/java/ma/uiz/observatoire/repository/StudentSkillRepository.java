package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.StudentSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSkillRepository extends JpaRepository<StudentSkill,Integer> {
}
