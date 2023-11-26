package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.repository.StudentHobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentHobbyService {
    private final StudentHobbyRepository studentHobbyRepository;

    public Page<StudentHobby> showAllStudentHobby(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentHobbyRepository.findAll(pageable);
    }

    public StudentHobby create(StudentHobby studentHobby) {
        if (studentHobbyRepository.existsById(studentHobby.getHobbyId()))
            throw new EntityExistsException("StudentHobby already stored in database - ID : "+studentHobby.getHobbyId()) {};
        return studentHobbyRepository.save(studentHobby);
    }

    public void delete(int id) {
        if (!studentHobbyRepository.existsById(id))
            throw new EntityNotFoundException("StudentHobby not found - ID : "+id) {};
        studentHobbyRepository.deleteById(id);
    }

    public void update(StudentHobby studentHobby) {
        if (!studentHobbyRepository.existsById(studentHobby.getHobbyId()))
            throw new EntityNotFoundException("StudentHobby not found - ID : "+studentHobby.getHobbyId()) {};
        studentHobbyRepository.save(studentHobby);
    }

    public StudentHobby find(int id) {
        return studentHobbyRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("StudentHobby not found - ID : "+id) {});
    }

    public long count() {
        return studentHobbyRepository.count();
    }
}
