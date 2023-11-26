package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.CompanyResponsible;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.CompanyResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/companyResponsibles")
@RequiredArgsConstructor
public class CompanyResponsibleController {

    private final CompanyResponsibleService companyResponsibleService;

    @GetMapping("/page/{pageNum}")
    public List<CompanyResponsible> displayAllCompanyResponsible(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<CompanyResponsible> companyResponsiblePage = companyResponsibleService.showAllCompanyResponsible(pageNum, pageSize);
        return companyResponsiblePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponsible> displayCompanyResponsible(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyResponsibleService.find(id));
    }

    @PostMapping
    public ResponseEntity<CompanyResponsible> saveCompanyResponsible(@Valid @RequestBody CompanyResponsible companyResponsible) {
        companyResponsibleService.create(companyResponsible);
        return ResponseEntity.status(HttpStatus.OK).body(companyResponsible);
    }

    @PutMapping
    public ResponseEntity<Response> updateCompanyResponsible(@Valid @RequestBody CompanyResponsible companyResponsible) {
        companyResponsibleService.update(companyResponsible);
        return response("CompanyResponsible successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCompanyResponsible(@PathVariable int id) {
        companyResponsibleService.delete(id);
        return response("CompanyResponsible successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCompanyResponsible(){
        return ResponseEntity.status(HttpStatus.OK).body(companyResponsibleService.count());
    }
}
