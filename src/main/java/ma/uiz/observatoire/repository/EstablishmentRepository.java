package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment,Integer> {

    Page<Establishment> findAll(Pageable pageable);
    List<Establishment> findAllByUniversityUniversityId(Integer id);
}
