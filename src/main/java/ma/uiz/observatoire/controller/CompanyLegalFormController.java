package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.CompanyLegalForm;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.CompanyLegalFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/companyLegalForms")
@RequiredArgsConstructor
public class CompanyLegalFormController {

    private final CompanyLegalFormService companyLegalFormService;

    @GetMapping("/page/{pageNum}")
    public List<CompanyLegalForm> displayAllCompanyLegalForm(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<CompanyLegalForm> companyLegalFormPage = companyLegalFormService.showAllCompanyLegalForm(pageNum, pageSize);
        return companyLegalFormPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyLegalForm> displayCompanyLegalForm(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyLegalFormService.find(id));
    }

    @PostMapping
    public ResponseEntity<CompanyLegalForm> saveCompanyLegalForm(@Valid @RequestBody CompanyLegalForm companyLegalForm) {
        companyLegalFormService.create(companyLegalForm);
        return ResponseEntity.status(HttpStatus.OK).body(companyLegalForm);
    }

    @PutMapping
    public ResponseEntity<Response> updateCompanyLegalForm(@Valid @RequestBody CompanyLegalForm companyLegalForm) {
        companyLegalFormService.update(companyLegalForm);
        return response("CompanyLegalForm successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCompanyLegalForm(@PathVariable int id) {
        companyLegalFormService.delete(id);
        return response("CompanyLegalForm successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCompanyLegalForm(){
        return ResponseEntity.status(HttpStatus.OK).body(companyLegalFormService.count());
    }
}
