package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.StudentCertificate;
import ma.uiz.observatoire.repository.StudentCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCertificateService {
    private final StudentCertificateRepository studentCertificateRepository;

    public Page<StudentCertificate> showAllStudentCertificate(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentCertificateRepository.findAll(pageable);
    }

    public StudentCertificate create(StudentCertificate studentCertificate) {
        if (studentCertificateRepository.existsById(studentCertificate.getCertificateId()))
            throw new EntityExistsException("StudentCertificate already stored in database - ID : "+studentCertificate.getCertificateId()) {};
        return studentCertificateRepository.save(studentCertificate);
    }

    public void delete(int id) {
        if (!studentCertificateRepository.existsById(id))
            throw new EntityNotFoundException("StudentCertificate not found - ID : "+id) {};
        studentCertificateRepository.deleteById(id);
    }

    public void update(StudentCertificate studentCertificate) {
        if (!studentCertificateRepository.existsById(studentCertificate.getCertificateId()))
            throw new EntityNotFoundException("StudentCertificate not found - ID : "+studentCertificate.getCertificateId()) {};
        studentCertificateRepository.save(studentCertificate);
    }

    public StudentCertificate find(int id) {
        return studentCertificateRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("StudentCertificate not found - ID : "+id) {});
    }

    public long count() {
        return studentCertificateRepository.count();
    }
}
