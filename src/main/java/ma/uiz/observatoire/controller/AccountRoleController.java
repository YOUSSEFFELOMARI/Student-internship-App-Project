package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.AccountRole;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/accountRoles")
@RequiredArgsConstructor
public class AccountRoleController {

    private final AccountRoleService accountRoleService;

    @GetMapping("/page/{pageNum}")
    public List<AccountRole> displayAllAccountRole(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<AccountRole> accountRolePage = accountRoleService.showAllAccountRole(pageNum, pageSize);
        return accountRolePage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountRole> displayAccountRole(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountRoleService.find(id));
    }

    @PostMapping
    public ResponseEntity<AccountRole> saveAccountRole(@Valid @RequestBody AccountRole accountRole) {
        accountRoleService.create(accountRole);
        return ResponseEntity.status(HttpStatus.OK).body(accountRole);
    }

    @PutMapping
    public ResponseEntity<Response> updateAccountRole(@Valid @RequestBody AccountRole accountRole) {
        accountRoleService.update(accountRole);
        return response("AccountRole successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAccountRole(@PathVariable int id) {
        accountRoleService.delete(id);
        return response("AccountRole successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAccountRole(){
        return ResponseEntity.status(HttpStatus.OK).body(accountRoleService.count());
    }


}
