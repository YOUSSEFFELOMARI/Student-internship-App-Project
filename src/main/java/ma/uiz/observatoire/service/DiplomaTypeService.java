package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.repository.DiplomaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiplomaTypeService {
    private final DiplomaTypeRepository diplomaTypeRepository;

    public Page<DiplomaType> showAllDiplomaType(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return diplomaTypeRepository.findAll(pageable);
    }

    public List<DiplomaType> findAll() {
        return diplomaTypeRepository.findAll();
    }

    public long count() {
        return diplomaTypeRepository.count();
    }

    public DiplomaType create(DiplomaType diplomaType) {
        if (diplomaTypeRepository.existsById(diplomaType.getDiplomaTypeId()))
            throw new EntityExistsException("DiplomaType already stored in database - ID : " +
                    diplomaType.getDiplomaTypeId()) {};
        return diplomaTypeRepository.save(diplomaType);
    }

    public DiplomaType update(DiplomaType diplomaType) {
        if (!diplomaTypeRepository.existsById(diplomaType.getDiplomaTypeId()))
            throw new EntityNotFoundException("DiplomaType not found - ID : " +
                    diplomaType.getDiplomaTypeId()) {};
        return diplomaTypeRepository.save(diplomaType);
    }

    public void delete(int id) {
        if (!diplomaTypeRepository.existsById(id))
            throw new EntityNotFoundException("DiplomaType not found - ID : "+id) {};
        diplomaTypeRepository.deleteById(id);
    }

    public DiplomaType find(int id) {
        return diplomaTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("DiplomaType not found - ID : "+id) {});
    }
}
