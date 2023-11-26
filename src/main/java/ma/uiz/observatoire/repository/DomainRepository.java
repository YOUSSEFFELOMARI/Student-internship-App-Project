package ma.uiz.observatoire.repository;


import jakarta.transaction.Transactional;
import ma.uiz.observatoire.model.Domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<Domain,Integer> {

    Page<Domain> findAll(Pageable pageable);

    Optional<Domain> findByDomainName(String s);
}
