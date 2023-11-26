package ma.uiz.observatoire.repository;

import jakarta.transaction.Transactional;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Override
    Page<Student> findAll(Pageable pageable);

    @Override
    Optional<Student> findById(Integer integer);

    Optional<Student> findByAccount(Account account);
    Optional<Student> findByCIN(String cin);
}
