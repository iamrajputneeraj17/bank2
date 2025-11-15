package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.entity.AccountDto;
import com.example.bank.entity.FormDataDto;
import com.example.bank.service.AccountService;
import com.example.bank.service.impl.FormSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://127.0.0.1:5500/Test.html"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    private FormSerImpl formservice;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

        @GetMapping("/getBy")
    public String getAccountById()
    {
       return "Working";
    }


    @PostMapping("/createForm")
    public ResponseEntity<FormDataDto> addForm(@RequestBody FormDataDto accountDto)
    {
        return new ResponseEntity<>(formservice.createForm(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/getAllForm")
    public ResponseEntity<List<FormDataDto>> getAllForm()
    {
        List<FormDataDto> account = formservice.getAllUsers();
        return ResponseEntity.ok(account);
    }


    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //    Deposit REST Api
    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String , Double> request)
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //    Withdraw REST Api
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request)
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);

    }

    //    GETAll Accounts REST Api
    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAll()
    {
        List<AccountDto> account = accountService.getAllAccounts();
        return ResponseEntity.ok(account);
    }

    //    DeleteById
    @DeleteMapping("/deleleById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)
    {
        accountService.deleteById(id);
        return ResponseEntity.ok("Account Deleted Successfully!");
    }

}

