package ma.uiz.observatoire.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.model.Domain;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/domain")
@RequiredArgsConstructor
public class DomainController {

    private final DomainService domainService;

    @GetMapping("/page/{pageNum}")
    public List<Domain> displayAllDomain(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Domain> domainPage = domainService.showAllDomain(pageNum, pageSize);
        return domainPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domain> displayDomain(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(domainService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Domain>> displayAllDomain() {
        return ResponseEntity.status(HttpStatus.OK).body(domainService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countDomain(){
        return ResponseEntity.status(HttpStatus.OK).body(domainService.count());
    }

    @PostMapping
    public ResponseEntity<Domain> saveDomain(@Valid @RequestBody Domain domain) {
        return ResponseEntity.status(HttpStatus.CREATED).body(domainService.create(domain));
    }

    @PutMapping
    public ResponseEntity<Domain> updateDomain(@Valid @RequestBody Domain domain) {
        return ResponseEntity.status(HttpStatus.OK).body(domainService.update(domain));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDomain(@PathVariable int id) {
        domainService.delete(id);
        return response("Domain successfully deleted", HttpStatus.NO_CONTENT);
    }
}
