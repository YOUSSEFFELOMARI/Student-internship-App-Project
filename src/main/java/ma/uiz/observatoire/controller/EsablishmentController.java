package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/establishments")
@RequiredArgsConstructor
public class EsablishmentController {

    private final EstablishmentService establishmentService;

    @GetMapping("/page/{pageNum}")
    public List<Establishment> pageEstablishment(@PathVariable(name = "pageNum") int pageNum, @RequestParam int pageSize) {
        Page<Establishment> establishmentPage = establishmentService.showAllEstablishment(pageNum, pageSize);
        return establishmentPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Establishment> displayEstablishment(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(establishmentService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> displayAllEstablishment(@RequestParam(required = false) Integer universityId) {
        return ResponseEntity.status(HttpStatus.OK).body(establishmentService.findAll(universityId));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countEstablishment(){
        return ResponseEntity.status(HttpStatus.OK).body(establishmentService.count());
    }

/*    @PostMapping
    public ResponseEntity<Establishment> saveEstablishment(@Valid @RequestBody Establishment establishment) {
        return ResponseEntity.status(HttpStatus.OK).body(establishmentService.create(establishment));
    }*/

    @PutMapping
    public ResponseEntity<Establishment> updateEstablishment(@Valid @RequestBody Establishment establishment) {
        return ResponseEntity.status(HttpStatus.OK).body(establishmentService.update(establishment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEstablishment(@PathVariable int id) {
        establishmentService.delete(id);
        return response("Establishment successfully deleted", HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Establishment> saveEstablishmentWithImg(@Valid @RequestPart Establishment establishment, @RequestPart MultipartFile img) {
        establishmentService.addEstablishmentWithImg(establishment,img);
        return ResponseEntity.status(HttpStatus.OK).body(establishment);
    }
    @PutMapping("/{id}/image")
    public ResponseEntity<Response> updateEstablishmentImg(@RequestBody MultipartFile img,@PathVariable int id) {
        establishmentService.updateImg(id,img);
        return response("Establishment image successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}/image")
    public ResponseEntity<Response> deleteEstablishmentImg(@PathVariable int id) {
        establishmentService.deleteImg(id);
        return response("Establishment image successfully deleted", HttpStatus.NO_CONTENT);
    }

}
