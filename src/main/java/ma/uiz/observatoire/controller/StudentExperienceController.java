package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentExperience;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentExperiences")
@RequiredArgsConstructor
public class StudentExperienceController {

    private final StudentExperienceService studentExperienceService;

    @GetMapping("/page/{pageNum}")
    public List<StudentExperience> displayAllStudentExperience(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentExperience> studentExperiencePage = studentExperienceService.showAllStudentExperience(pageNum, pageSize);
        return studentExperiencePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentExperience> displayStudentExperience(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentExperienceService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentExperience> saveStudentExperience(@Valid @RequestBody StudentExperience studentExperience) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentExperienceService.create(studentExperience));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentExperience(@Valid @RequestBody StudentExperience studentExperience) {
        studentExperienceService.update(studentExperience);
        return response("StudentExperience successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentExperience(@PathVariable int id) {
        studentExperienceService.delete(id);
        return response("StudentExperience successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentExperience(){
        return ResponseEntity.status(HttpStatus.OK).body(studentExperienceService.count());
    }
}
