package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainService {
    private final DomainRepository domainRepository;

    public Page<Domain> showAllDomain(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return domainRepository.findAll(pageable);
    }

    public List<Domain> findAll() {
        return domainRepository.findAll();
    }

    public long count() {
        return domainRepository.count();
    }

    public Domain create(Domain domain) {
        if (domainRepository.existsById(domain.getDomainId()))
            throw new EntityExistsException("Domain already stored in database - ID : " +
                    domain.getDomainId()) {};
        return domainRepository.save(domain);
    }

    public Domain update(Domain domain) {
        if (!domainRepository.existsById(domain.getDomainId()))
            throw new EntityNotFoundException("Domain not found - ID : " +
                    domain.getDomainId()) {};
        return domainRepository.save(domain);
    }

    public void delete(int id) {
        if (!domainRepository.existsById(id))
            throw new EntityNotFoundException("Domain not found - ID : "+id) {};
        domainRepository.deleteById(id);
    }

    public Domain find(int id) {
        return domainRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Domain not found - ID : "+id) {});
    }
}
