package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.StudentCompetence;
import ma.uiz.observatoire.repository.StudentCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCompetenceService {
    private final StudentCompetenceRepository studentCompetenceRepository;

    public Page<StudentCompetence> showAllStudentCompetence(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentCompetenceRepository.findAll(pageable);
    }

    public StudentCompetence create(StudentCompetence studentCompetence) {
        if (studentCompetenceRepository.existsById(studentCompetence.getCompetenceId()))
            throw new EntityExistsException("StudentCompetence already stored in database - ID : "+studentCompetence.getCompetenceId()) {};
        return studentCompetenceRepository.save(studentCompetence);
    }

    public void delete(int id) {
        if (!studentCompetenceRepository.existsById(id))
            throw new EntityNotFoundException("StudentCompetence not found - ID : "+id) {};
        studentCompetenceRepository.deleteById(id);
    }

    public void update(StudentCompetence studentCompetence) {
        if (!studentCompetenceRepository.existsById(studentCompetence.getCompetenceId()))
            throw new EntityNotFoundException("StudentCompetence not found - ID : "+studentCompetence.getCompetenceId()) {};
        studentCompetenceRepository.save(studentCompetence);
    }

    public StudentCompetence find(int id) {
        return studentCompetenceRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("StudentCompetence not found - ID : "+id) {});
    }

    public long count() {
        return studentCompetenceRepository.count();
    }
}
