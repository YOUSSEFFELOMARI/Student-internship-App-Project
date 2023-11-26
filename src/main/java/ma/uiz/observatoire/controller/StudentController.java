package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.StudentMapper;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/page/{pageNum}")
    public List<StudentDTO> displayAllStudent(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<StudentDTO> studentPage = studentService.showAllStudent(pageNum, pageSize);
        return studentPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> displayStudent(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> displayAllStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.count());
    }

    /*@PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(studentDTO));
    }*/

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(studentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return response("Student successfully deleted", HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> saveStudentWithImg(@Valid @RequestPart StudentDTO student,
                                                      @RequestPart MultipartFile img) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudentWithImg(student,img));
    }
    @PutMapping("/{id}/image")
    public ResponseEntity<Response> updateStudentImg(@RequestBody MultipartFile img,@PathVariable int id) {
        studentService.updateImg(id,img);
        return response("Student image successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/image")
    public ResponseEntity<Response> deleteStudentImg(@PathVariable int id) {
        studentService.deleteImg(id);
        return response("Student image successfully deleted", HttpStatus.NO_CONTENT);
    }
}
