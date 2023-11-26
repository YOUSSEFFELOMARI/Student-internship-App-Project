package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityService {
    private final SpecialityRepository specialityRepository;

    public Page<Speciality> showAllSpeciality(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return specialityRepository.findAll(pageable);
    }

    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    public long count() {
        return specialityRepository.count();
    }

    public Speciality create(Speciality speciality) {
        if (specialityRepository.existsById(speciality.getSpecialityId()))
            throw new EntityExistsException("Speciality already stored in database - ID : " +
                    speciality.getSpecialityId()) {};
        return specialityRepository.save(speciality);
    }

    public Speciality update(Speciality speciality) {
        if (!specialityRepository.existsById(speciality.getSpecialityId()))
            throw new EntityNotFoundException("Speciality not found - ID : " +
                    speciality.getSpecialityId()) {};
        return specialityRepository.save(speciality);
    }

    public void delete(int id) {
        if (!specialityRepository.existsById(id))
            throw new EntityNotFoundException("Speciality not found - ID : "+id) {};
        specialityRepository.deleteById(id);
    }

    public Speciality find(int id) {
        return specialityRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Speciality not found - ID : "+id) {});
    }


}
