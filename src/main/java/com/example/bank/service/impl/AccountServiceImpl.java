package com.example.bank.service.impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.AccountDto;
import com.example.bank.entity.AccountMapper;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto getAccountById(Long id)
    {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists!"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount)
    {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists!"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, double amount)
    {
        Account account = accountRepository.
                findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exists!"));

        if(account.getBalance()<amount) {
            throw new RuntimeException("Insufficient Balance!");
        }

        double balance = account.getBalance() - amount;
        account.setBalance(balance);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts()
    {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account)))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id)
    {
        Account account = accountRepository.
                findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exists!"));
        accountRepository.deleteById(id);
    }
}

