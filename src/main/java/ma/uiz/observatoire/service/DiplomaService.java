package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiplomaService {
    private final DiplomaRepository diplomaRepository;

    public Page<Diploma> showAllDiploma(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return diplomaRepository.findAll(pageable);
    }

    public void create(Diploma diploma) {
        if (diplomaRepository.existsById(diploma.getDiplomaId()))
            throw new EntityExistsException("Diploma already stored in database - ID : "+diploma.getDiplomaId()) {};
        diplomaRepository.save(diploma);
    }

    public void delete(int id) {
        if (!diplomaRepository.existsById(id))
            throw new EntityNotFoundException("Diploma not found - ID : "+id) {};
        diplomaRepository.deleteById(id);
    }

    public void update(Diploma diploma) {
        if (!diplomaRepository.existsById(diploma.getDiplomaId()))
            throw new EntityNotFoundException("Diploma not found - ID : "+diploma.getDiplomaId()) {};
        diplomaRepository.save(diploma);
    }

    public Diploma find(int id) {
        return diplomaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Diploma not found - ID : "+id) {});
    }

    public long count() {
        return diplomaRepository.count();
    }
}
