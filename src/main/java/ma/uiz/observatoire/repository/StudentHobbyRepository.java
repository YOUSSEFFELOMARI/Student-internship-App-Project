package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.StudentHobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHobbyRepository extends JpaRepository<StudentHobby,Integer> {
}
