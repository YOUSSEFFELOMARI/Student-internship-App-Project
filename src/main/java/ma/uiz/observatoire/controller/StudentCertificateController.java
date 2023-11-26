package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentCertificate;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentCertificates")
@RequiredArgsConstructor
public class StudentCertificateController {

    private final StudentCertificateService studentCertificateService;

    @GetMapping("/page/{pageNum}")
    public List<StudentCertificate> displayAllStudentCertificate(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentCertificate> studentCertificatePage = studentCertificateService.showAllStudentCertificate(pageNum, pageSize);
        return studentCertificatePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCertificate> displayStudentCertificate(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentCertificateService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentCertificate> saveStudentCertificate(@Valid @RequestBody StudentCertificate studentCertificate) {
        return ResponseEntity.status(HttpStatus.OK).body(studentCertificateService.create(studentCertificate));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentCertificate(@Valid @RequestBody StudentCertificate studentCertificate) {
        studentCertificateService.update(studentCertificate);
        return response("StudentCertificate successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentCertificate(@PathVariable int id) {
        studentCertificateService.delete(id);
        return response("StudentCertificate successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentCertificate(){
        return ResponseEntity.status(HttpStatus.OK).body(studentCertificateService.count());
    }
}
