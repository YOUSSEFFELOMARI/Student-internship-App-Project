package ma.uiz.observatoire.repository;

import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByEmail(String email);
    List<Account> findAccountByConversationsConversationId(int id);
    @Query("SELECT c.company FROM CompanyResponsible c WHERE c.account= :account")
    Company findCompany(Account account);

    @Query("SELECT s FROM Student s WHERE s.account= :account")
    Student findStudent(Account account);
}
