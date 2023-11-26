package ma.uiz.observatoire.repository;


import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Application.ApplicationPk> {

    Page<Application> findAll(Pageable pageable);

    List<Application> findByApplicationPkStudentStudentId(int studentId);
    List<Application> findByApplicationPkOfferOfferId(int offerId);



}
