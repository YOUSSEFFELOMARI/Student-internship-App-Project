package ma.uiz.observatoire.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.model.Token;
import ma.uiz.observatoire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/page/{pageNum}")
    public List<Account> displayAllAccount(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Account> accountPage = accountService.showAllAccount(pageNum, pageSize);
        return accountPage.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> displayAccount(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.find(id));
    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account) {
        accountService.create(account);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PutMapping
    public ResponseEntity<Response> updateAccount(@Valid @RequestBody Account account) {
        accountService.update(account);
        return response("Account successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAccount(@PathVariable int id) {
        accountService.delete(id);
        return response("Account successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAccount(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.count());
    }
}
