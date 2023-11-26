package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.StudentExperience;
import ma.uiz.observatoire.repository.StudentExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentExperienceService {
    private final StudentExperienceRepository studentExperienceRepository;

    public Page<StudentExperience> showAllStudentExperience(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentExperienceRepository.findAll(pageable);
    }

    public StudentExperience create(StudentExperience studentExperience) {
        if (studentExperienceRepository.existsById(studentExperience.getExperienceId()))
            throw new EntityExistsException("StudentExperience already stored in database - ID : "+studentExperience.getExperienceId()) {};
        return studentExperienceRepository.save(studentExperience);
    }

    public void delete(int id) {
        if (!studentExperienceRepository.existsById(id))
            throw new EntityNotFoundException("StudentExperience not found - ID : "+id) {};
        studentExperienceRepository.deleteById(id);
    }

    public void update(StudentExperience studentExperience) {
        if (!studentExperienceRepository.existsById(studentExperience.getExperienceId()))
            throw new EntityNotFoundException("StudentExperience not found - ID : "+studentExperience.getExperienceId()) {};
        studentExperienceRepository.save(studentExperience);
    }

    public StudentExperience find(int id) {
        return studentExperienceRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("StudentExperience not found - ID : "+id) {});
    }

    public long count() {
        return studentExperienceRepository.count();
    }
}
