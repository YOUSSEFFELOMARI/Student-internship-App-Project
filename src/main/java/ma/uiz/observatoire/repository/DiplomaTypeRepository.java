package ma.uiz.observatoire.repository;

import jakarta.transaction.Transactional;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiplomaTypeRepository extends JpaRepository<DiplomaType,Integer> {
        Page<DiplomaType> findAll(Pageable pageable);

    Optional<DiplomaType> findByDiplomaTypeName(String s);
}
