package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.repository.StudentLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLanguageService {
    private final StudentLanguageRepository studentLanguageRepository;

    public Page<StudentLanguage> showAllStudentLanguage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentLanguageRepository.findAll(pageable);
    }

    public StudentLanguage create(StudentLanguage studentLanguage) {
        if (studentLanguageRepository.existsById(studentLanguage.getLanguageId()))
            throw new EntityExistsException("StudentLanguage already stored in database - ID : "+studentLanguage.getLanguageId()) {};
        return studentLanguageRepository.save(studentLanguage);
    }

    public void delete(int id) {
        if (!studentLanguageRepository.existsById(id))
            throw new EntityNotFoundException("StudentLanguage not found - ID : "+id) {};
        studentLanguageRepository.deleteById(id);
    }

    public void update(StudentLanguage studentLanguage) {
        if (!studentLanguageRepository.existsById(studentLanguage.getLanguageId()))
            throw new EntityNotFoundException("StudentLanguage not found - ID : "+studentLanguage.getLanguageId()) {};
        studentLanguageRepository.save(studentLanguage);
    }

    public StudentLanguage find(int id) {
        return studentLanguageRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("StudentLanguage not found - ID : "+id) {});
    }

    public long count() {
        return studentLanguageRepository.count();
    }
}
