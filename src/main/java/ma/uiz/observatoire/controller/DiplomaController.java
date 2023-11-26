package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Diploma;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/diplomas")
@RequiredArgsConstructor
public class DiplomaController {

    private final DiplomaService diplomaService;

    @GetMapping("/page/{pageNum}")
    public List<Diploma> displayAllDiploma(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Diploma> diplomaPage = diplomaService.showAllDiploma(pageNum, pageSize);
        return diplomaPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diploma> displayDiploma(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomaService.find(id));
    }

    @PostMapping
    public ResponseEntity<Diploma> saveDiploma(@Valid @RequestBody Diploma diploma) {
        diplomaService.create(diploma);
        return ResponseEntity.status(HttpStatus.OK).body(diploma);
    }

    @PutMapping
    public ResponseEntity<Response> updateDiploma(@Valid @RequestBody Diploma diploma) {
        diplomaService.update(diploma);
        return response("Diploma successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDiploma(@PathVariable int id) {
        diplomaService.delete(id);
        return response("Diploma successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countDiploma(){
        return ResponseEntity.status(HttpStatus.OK).body(diplomaService.count());
    }
}
