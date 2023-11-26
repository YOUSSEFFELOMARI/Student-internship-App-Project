package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.StudentCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCertificateRepository extends JpaRepository<StudentCertificate,Integer> {
}
