package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.StudentLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentLanguageRepository extends JpaRepository<StudentLanguage,Integer> {
    Optional<StudentLanguage> findByLanguageName(String s);
}
