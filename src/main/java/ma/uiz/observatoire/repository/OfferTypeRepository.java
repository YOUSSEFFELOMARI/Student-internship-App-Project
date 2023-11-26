package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferTypeRepository extends JpaRepository<OfferType,Integer> {
    @Override
    Page<OfferType> findAll(Pageable pageable);

    @Override
    long count();
}
