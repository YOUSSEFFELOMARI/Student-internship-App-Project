package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.AccountRole;
import ma.uiz.observatoire.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountRoleService {
    private final AccountRoleRepository accountRoleRepository;

    public Page<AccountRole> showAllAccountRole(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return accountRoleRepository.findAll(pageable);
    }

    public void create(AccountRole accountRole) {
        if (accountRoleRepository.existsById(accountRole.getAccountRoleId()))
            throw new EntityExistsException("AccountRole already stored in database - ID : "+accountRole.getAccountRoleId()) {};
        accountRoleRepository.save(accountRole);
    }

    public void delete(int id) {
        if (!accountRoleRepository.existsById(id))
            throw new EntityNotFoundException("AccountRole not found - ID : "+id) {};
        accountRoleRepository.deleteById(id);
    }

    public void update(AccountRole accountRole) {
        if (!accountRoleRepository.existsById(accountRole.getAccountRoleId()))
            throw new EntityNotFoundException("AccountRole not found - ID : "+accountRole.getAccountRoleId()) {};
        accountRoleRepository.save(accountRole);
    }

    public AccountRole find(int id) {
        return accountRoleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("AccountRole not found - ID : "+id) {});
    }

    public long count() {
        return accountRoleRepository.count();
    }
}
