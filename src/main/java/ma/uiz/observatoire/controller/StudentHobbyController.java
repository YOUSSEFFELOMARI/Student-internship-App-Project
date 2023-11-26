package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.model.StudentHobby;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.StudentHobbyService;
import ma.uiz.observatoire.service.StudentHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/studentHobbies")
@RequiredArgsConstructor
public class StudentHobbyController {

    private final StudentHobbyService studentHobbyService;

    @GetMapping("/page/{pageNum}")
    public List<StudentHobby> displayAllStudentHobby(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentHobby> studentHobbyPage = studentHobbyService.showAllStudentHobby(pageNum, pageSize);
        return studentHobbyPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentHobby> displayStudentHobby(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentHobbyService.find(id));
    }

    @PostMapping
    public ResponseEntity<StudentHobby> saveStudentHobby(@Valid @RequestBody StudentHobby studentHobby) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentHobbyService.create(studentHobby));
    }

    @PutMapping
    public ResponseEntity<Response> updateStudentHobby(@Valid @RequestBody StudentHobby studentHobby) {
        studentHobbyService.update(studentHobby);
        return response("StudentHobby successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudentHobby(@PathVariable int id) {
        studentHobbyService.delete(id);
        return response("StudentHobby successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudentHobby(){
        return ResponseEntity.status(HttpStatus.OK).body(studentHobbyService.count());
    }
}
