package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOfferRepository extends JpaRepository<Application,Integer> {
}
