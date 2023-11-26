package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Page<Account> showAllAccount(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return accountRepository.findAll(pageable);
    }

    public void create(Account account) {
        if (accountRepository.existsById(account.getAccountId()))
            throw new EntityExistsException("Account already stored in database - ID : "+account.getAccountId()) {};
        accountRepository.save(account);
    }

    public void delete(int id) {
        if (!accountRepository.existsById(id))
            throw new EntityNotFoundException("Account not found - ID : "+id) {};
        accountRepository.deleteById(id);
    }

    public void update(Account account) {
        if (!accountRepository.existsById(account.getAccountId()))
            throw new EntityNotFoundException("Account not found - ID : "+account.getAccountId()) {};
        accountRepository.save(account);
    }

    public Account find(int id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Account not found - ID : "+id) {});
    }

    public long count() {
        return accountRepository.count();
    }
}
