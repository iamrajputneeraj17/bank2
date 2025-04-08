package com.example.bank.service;

import com.example.bank.entity.AccountDto;
import com.example.bank.entity.FormDataDto;

import java.util.List;

public interface FormService {

    FormDataDto createForm(FormDataDto formDataDto);

//    FormDataDto getAccountById(Long id);
//
//    AccountDto deposit(Long id, double amount);
//
//    AccountDto withdraw(Long id, double amount);

    List<FormDataDto> getAllUsers();

//    void deleteById(Long id);
}

