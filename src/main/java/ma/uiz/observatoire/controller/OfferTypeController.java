package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.OfferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/offerType")
@RequiredArgsConstructor
public class OfferTypeController {

    private final OfferTypeService offerTypeService;

    @GetMapping("/page/{pageNum}")
    public ResponseEntity<List<OfferType>> displayAllOfferType(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<OfferType> offerTypePage = offerTypeService.showAllOfferType(pageNum, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(offerTypePage.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferType> displayOfferType(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<OfferType>> displayAllOfferType() {
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countOfferType(){
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.count());
    }

    @PostMapping
    public ResponseEntity<OfferType> saveOfferType(@Valid @RequestBody OfferType offerType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(offerTypeService.create(offerType));
    }

    @PutMapping
    public ResponseEntity<OfferType> updateOfferType(@Valid @RequestBody OfferType offerType) {
        return ResponseEntity.status(HttpStatus.OK).body(offerTypeService.update(offerType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOfferType(@PathVariable int id) {
        offerTypeService.delete(id);
        return response("OfferType successfully deleted", HttpStatus.NO_CONTENT);
    }
}
