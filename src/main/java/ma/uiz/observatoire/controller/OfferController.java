package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/page/{pageNum}")
    public List<OfferDTO> displayAllOffer(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<OfferDTO> offerPage = offerService.showAllOffer(pageNum, pageSize);
        return offerPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> displayOffer(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.find(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<OfferDTO>> displayOffersOfCompany(@RequestParam("companyId") int companyId) {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.findByCompanyId(companyId));
    }

    @GetMapping
    public ResponseEntity<List<OfferDTO>> displayAllOffers() {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.findAll());
    }

    @PostMapping
    public ResponseEntity<OfferDTO> saveOffer(@Valid @RequestBody OfferDTO offerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.create(offerDTO));
        //dsqd
    }

    @PutMapping
    public ResponseEntity<Response> updateOffer(@Valid @RequestBody OfferDTO offerDTO) {
        offerService.update(offerDTO);
        return response("Offer successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOffer(@PathVariable int id) {
        offerService.delete(id);
        return response("Offer successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countOffer(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.count());
    }
}
