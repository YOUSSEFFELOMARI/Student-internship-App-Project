package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.model.Speciality;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/specialities")
@RequiredArgsConstructor
public class SpecialityController {

    private final SpecialityService specialityService;

    @GetMapping("/page/{pageNum}")
    public List<Speciality> displayAllSpeciality(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Speciality> specialityPage = specialityService.showAllSpeciality(pageNum, pageSize);
        return specialityPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> displaySpeciality(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(specialityService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> displayAllSpeciality() {
        return ResponseEntity.status(HttpStatus.OK).body(specialityService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countSpeciality(){
        return ResponseEntity.status(HttpStatus.OK).body(specialityService.count());
    }

    @PostMapping
    public ResponseEntity<Speciality> saveSpeciality(@Valid @RequestBody Speciality speciality) {
        return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.create(speciality));
    }

    @PutMapping
    public ResponseEntity<Speciality> updateSpeciality(@Valid @RequestBody Speciality speciality) {
        return ResponseEntity.status(HttpStatus.OK).body(specialityService.update(speciality));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteSpeciality(@PathVariable int id) {
        specialityService.delete(id);
        return response("Speciality successfully deleted", HttpStatus.NO_CONTENT);
    }


}
