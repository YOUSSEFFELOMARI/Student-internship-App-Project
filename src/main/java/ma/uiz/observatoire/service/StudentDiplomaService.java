package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.StudentDiploma;
import ma.uiz.observatoire.repository.DiplomaRepository;
import ma.uiz.observatoire.repository.StudentDiplomaRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentDiplomaService {
    private final StudentDiplomaRepository studentDiplomaRepository;
    private final StudentRepository studentRepository;
    private final DiplomaRepository DiplomaRepository;

    public Page<StudentDiploma> showAllStudentDiploma(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentDiplomaRepository.findAll(pageable);
    }

    public StudentDiploma create(StudentDiploma studentDiploma) {
        if (studentDiplomaRepository.existsById(studentDiploma.getStudentDiplomaId()))
            throw new EntityExistsException("StudentDiploma already stored in database - ID : "+studentDiploma.getStudentDiplomaId()) {};
        return studentDiplomaRepository.save(studentDiploma);
    }

    public void delete(String id) {
        StudentDiploma.StudentDiplomaPk pk=getPkfromStr(id);
        if (!studentDiplomaRepository.existsById(pk))
            throw new EntityNotFoundException("StudentDiploma not found - ID : "+id) {};
        studentDiplomaRepository.deleteById(pk);
    }

    public void update(StudentDiploma studentDiploma) {
        if (!studentDiplomaRepository.existsById(studentDiploma.getStudentDiplomaId()))
            throw new EntityNotFoundException("StudentDiploma not found - ID : "+studentDiploma.getStudentDiplomaId()) {};
        studentDiplomaRepository.save(studentDiploma);
    }

    public StudentDiploma find(String id) {
        StudentDiploma.StudentDiplomaPk pk=getPkfromStr(id);
        return studentDiplomaRepository.findById(pk).orElseThrow(() ->
                new EntityNotFoundException("StudentDiploma not found - ID : "+id) {});
    }

    public StudentDiploma.StudentDiplomaPk getPkfromStr(String id){
        String[] spt = id.split(",", 2);
        StudentDiploma.StudentDiplomaPk pk=new StudentDiploma.StudentDiplomaPk();
        Student student=studentRepository.findById(Integer.parseInt(spt[0])).orElseThrow(() ->
                new EntityNotFoundException("Student not found - ID : "+id) {});
        Diploma diploma=DiplomaRepository.findById(Integer.parseInt(spt[0])).orElseThrow(() ->
                new EntityNotFoundException("Diploma not found - ID : "+id) {});
        pk.setDiploma(diploma);
        pk.setStudent(student);
        return pk;
    }
    public long count() {
        return studentRepository.count();
    }
}
