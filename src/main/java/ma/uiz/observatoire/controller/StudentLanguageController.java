package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentLanguage;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentLanguages")
@RequiredArgsConstructor
public class StudentLanguageController {

    private final StudentLanguageService studentLanguageService;

    @GetMapping("/page/{pageNum}")
    public List<StudentLanguage> displayAllStudentLanguage(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentLanguage> studentLanguagePage = studentLanguageService.showAllStudentLanguage(pageNum, pageSize);
        return studentLanguagePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentLanguage> displayStudentLanguage(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentLanguageService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentLanguage> saveStudentLanguage(@Valid @RequestBody StudentLanguage studentLanguage) {
        return ResponseEntity.status(HttpStatus.OK).body(studentLanguageService.create(studentLanguage));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentLanguage(@Valid @RequestBody StudentLanguage studentLanguage) {
        studentLanguageService.update(studentLanguage);
        return response("StudentLanguage successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentLanguage(@PathVariable int id) {
        studentLanguageService.delete(id);
        return response("StudentLanguage successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentLanguage(){
        return ResponseEntity.status(HttpStatus.OK).body(studentLanguageService.count());
    }

}
