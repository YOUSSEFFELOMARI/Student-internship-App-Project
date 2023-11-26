package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping("/page/{pageNum}")
    public List<Company> displayAllCompany(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Company> companyPage = companyService.showAllCompany(pageNum, pageSize);
        return companyPage.getContent();
    }
    @GetMapping
    public ResponseEntity<List<Company>> displayAllCompany() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> displayCompany(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.find(id));
    }

/*    @PostMapping
    public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company) {
        companyService.create(company);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }*/

    @PostMapping
    public ResponseEntity<Company> saveCompanyWithImg(@Valid @RequestPart Company company,
                                                  @RequestPart MultipartFile img) throws IOException {
        companyService.addCompanyWithImg(company,img);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }
    @PutMapping("/{id}/image")
    public ResponseEntity<Response> updateCompanyImg(@RequestBody MultipartFile img,@PathVariable int id) {
        companyService.updateImg(id,img);
        return response("Company image successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}/image")
    public ResponseEntity<Response> deleteCompanyImg(@PathVariable int id) {
        companyService.deleteImg(id);
        return response("Company image successfully deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Response> updateCompany(@Valid @RequestBody Company company) {
        companyService.update(company);
        return response("Company successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCompany(@PathVariable int id) {
        companyService.delete(id);
        return response("Company successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCompany(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.count());
    }
}
