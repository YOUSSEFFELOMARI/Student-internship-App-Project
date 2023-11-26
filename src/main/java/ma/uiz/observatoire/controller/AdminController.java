package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Admin;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/page/{pageNum}")
    public List<Admin> displayAllAdmin(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Admin> adminPage = adminService.showAllAdmin(pageNum, pageSize);
        return adminPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> displayAdmin(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.find(id));
    }

    @PostMapping
    public ResponseEntity<Response> saveAdmin(@Valid @RequestBody Admin admin) {
        adminService.create(admin);
        return response("Admin successfully saved", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Response> updateAdmin(@Valid @RequestBody Admin admin) {
        adminService.update(admin);
        return response("Admin successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAdmin(@PathVariable int id) {
        adminService.delete(id);
        return response("Admin successfully deleted", HttpStatus.NO_CONTENT);
    }


}
