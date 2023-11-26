package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.repository.CompanyLegalFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyLegalFormService {
    private final CompanyLegalFormRepository companyLegalFormRepository;

    public Page<CompanyLegalForm> showAllCompanyLegalForm(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return companyLegalFormRepository.findAll(pageable);
    }

    public void create(CompanyLegalForm companyLegalForm) {
        if (companyLegalFormRepository.existsById(companyLegalForm.getLegalFormId()))
            throw new EntityExistsException("CompanyLegalForm already stored in database - ID : "+companyLegalForm.getLegalFormId()) {};
        companyLegalFormRepository.save(companyLegalForm);
    }

    public void delete(int id) {
        if (!companyLegalFormRepository.existsById(id))
            throw new EntityNotFoundException("CompanyLegalForm not found - ID : "+id) {};
        companyLegalFormRepository.deleteById(id);
    }

    public void update(CompanyLegalForm companyLegalForm) {
        if (!companyLegalFormRepository.existsById(companyLegalForm.getLegalFormId()))
            throw new EntityNotFoundException("CompanyLegalForm not found - ID : "+companyLegalForm.getLegalFormId()) {};
        companyLegalFormRepository.save(companyLegalForm);
    }

    public CompanyLegalForm find(int id) {
        return companyLegalFormRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("CompanyLegalForm not found - ID : "+id) {});
    }

    public long count() {
        return companyLegalFormRepository.count();
    }
}
