package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.repository.CompanyResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyResponsibleService {
    private final CompanyResponsibleRepository companyresponsibleRepository;

    public Page<CompanyResponsible> showAllCompanyResponsible(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return companyresponsibleRepository.findAll(pageable);
    }

    public void create(CompanyResponsible companyresponsible) {
        if (companyresponsibleRepository.existsById(companyresponsible.getResponsibleId()))
            throw new EntityExistsException("CompanyResponsible already stored in database - ID : "+companyresponsible.getResponsibleId()) {};
        companyresponsibleRepository.save(companyresponsible);
    }

    public void delete(int id) {
        if (!companyresponsibleRepository.existsById(id))
            throw new EntityNotFoundException("CompanyResponsible not found - ID : "+id) {};
        companyresponsibleRepository.deleteById(id);
    }

    public void update(CompanyResponsible companyresponsible) {
        if (!companyresponsibleRepository.existsById(companyresponsible.getResponsibleId()))
            throw new EntityNotFoundException("CompanyResponsible not found - ID : "+companyresponsible.getResponsibleId()) {};
        companyresponsibleRepository.save(companyresponsible);
    }

    public CompanyResponsible find(int id) {
        return companyresponsibleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("CompanyResponsible not found - ID : "+id) {});
    }
    public long count() {
        return companyresponsibleRepository.count();
    }
}
