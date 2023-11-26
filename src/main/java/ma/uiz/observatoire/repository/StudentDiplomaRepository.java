package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.StudentDiploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDiplomaRepository extends JpaRepository<StudentDiploma, StudentDiploma.StudentDiplomaPk> {

    List<StudentDiploma> findByStudentDiplomaIdStudentStudentId(int studentId);
}
