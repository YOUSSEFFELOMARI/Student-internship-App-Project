package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentCompetence;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentCompetences")
@RequiredArgsConstructor
public class StudentCompetenceController {

    private final StudentCompetenceService studentCompetenceService;

    @GetMapping("/page/{pageNum}")
    public List<StudentCompetence> displayAllStudentCompetence(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentCompetence> studentCompetencePage = studentCompetenceService.showAllStudentCompetence(pageNum, pageSize);
        return studentCompetencePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCompetence> displayStudentCompetence(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentCompetenceService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentCompetence> saveStudentCompetence(@Valid @RequestBody StudentCompetence studentCompetence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCompetenceService.create(studentCompetence));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentCompetence(@Valid @RequestBody StudentCompetence studentCompetence) {
        studentCompetenceService.update(studentCompetence);
        return response("StudentCompetence successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentCompetence(@PathVariable int id) {
        studentCompetenceService.delete(id);
        return response("StudentCompetence successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentCompetence(){
        return ResponseEntity.status(HttpStatus.OK).body(studentCompetenceService.count());
    }
}
