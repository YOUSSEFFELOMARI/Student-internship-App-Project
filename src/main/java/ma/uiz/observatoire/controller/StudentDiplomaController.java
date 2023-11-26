package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentDiploma;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentDiplomas")
@RequiredArgsConstructor
public class StudentDiplomaController {

    private final StudentDiplomaService studentDiplomeService;

    @GetMapping("/page/{pageNum}")
    public List<StudentDiploma> displayAllStudentDiploma(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentDiploma> studentDiplomePage = studentDiplomeService.showAllStudentDiploma(pageNum, pageSize);
        return studentDiplomePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDiploma> displayStudentDiploma(@PathVariable(name = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentDiplomeService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentDiploma> saveStudentDiploma(@Valid @RequestBody StudentDiploma studentDiplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDiplomeService.create(studentDiplome));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentDiploma(@Valid @RequestBody StudentDiploma studentDiplome) {
        studentDiplomeService.update(studentDiplome);
        return response("StudentDiploma successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentDiploma(@PathVariable String id) {
        studentDiplomeService.delete(id);
        return response("StudentDiploma successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentDiploma(){
        return ResponseEntity.status(HttpStatus.OK).body(studentDiplomeService.count());
    }
}
