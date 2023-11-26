package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.DiplomaType;
import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.DiplomaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/diplomaType")
@RequiredArgsConstructor
public class DiplomaTypeController {

    private final DiplomaTypeService diplomaTypeService;

    @GetMapping("/page/{pageNum}")
    public List<DiplomaType> displayAllDiplomaType(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<DiplomaType> diplomaTypePage = diplomaTypeService.showAllDiplomaType(pageNum, pageSize);
        return diplomaTypePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomaType> displayDiplomaType(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomaTypeService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<DiplomaType>> displayAllDiplomaType() {
        return ResponseEntity.status(HttpStatus.OK).body(diplomaTypeService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countDiplomaType(){
        return ResponseEntity.status(HttpStatus.OK).body(diplomaTypeService.count());
    }

    @PostMapping
    public ResponseEntity<DiplomaType> saveDiplomaType(@Valid @RequestBody DiplomaType diplomaType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomaTypeService.create(diplomaType));
    }

    @PutMapping
    public ResponseEntity<DiplomaType> updateDiplomaType(@Valid @RequestBody DiplomaType diplomaType) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomaTypeService.update(diplomaType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDiplomaType(@PathVariable int id) {
        diplomaTypeService.delete(id);
        return response("DiplomaType successfully deleted", HttpStatus.NO_CONTENT);
    }
}
