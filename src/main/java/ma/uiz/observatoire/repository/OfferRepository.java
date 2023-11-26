package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
    @Override
    Page<Offer> findAll(Pageable pageable);

    List<OfferDTO> findAllByCompanyCompanyId(int companyId);

}

