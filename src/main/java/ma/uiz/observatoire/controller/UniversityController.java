package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/page/{pageNum}")
    public List<University> displayAllUniversity(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<University> universityPage = universityService.showAllUniversity(pageNum, pageSize);
        return universityPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> displayUniversity(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(universityService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<University>> displayAllUniversity() {
        return ResponseEntity.status(HttpStatus.OK).body(universityService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countUniversity(){
        return ResponseEntity.status(HttpStatus.OK).body(universityService.count());
    }

/*    @PostMapping
    public ResponseEntity<University> saveUniversity(@Valid @RequestBody University university) {
        return ResponseEntity.status(HttpStatus.CREATED).body(universityService.create(university));
    }*/

    @PutMapping
    public ResponseEntity<University> updateUniversity(@Valid @RequestBody University university) {
        return ResponseEntity.status(HttpStatus.OK).body(universityService.update(university));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUniversity(@PathVariable int id) {
        universityService.delete(id);
        return response("University successfully deleted", HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<University> saveUniversityWithImg(@Valid @RequestPart University university,
                                                      @RequestPart MultipartFile img) {
        universityService.addUniversityWithImg(university,img);
        return ResponseEntity.status(HttpStatus.OK).body(university);
    }

    @PutMapping("/{id}/image")
    public ResponseEntity<Response> updateUniversityImg(@RequestBody MultipartFile img,@PathVariable int id) {
        universityService.updateImg(id,img);
        return response("University image successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/image")
    public ResponseEntity<Response> deleteUniversityImg(@PathVariable int id) {
        universityService.deleteImg(id);
        return response("University image successfully deleted", HttpStatus.NO_CONTENT);
    }
}
