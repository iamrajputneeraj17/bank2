package com.example.bank.service.impl;

import com.example.bank.entity.*;
import com.example.bank.repository.FormRepository;
import com.example.bank.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FormSerImpl implements FormService {


    @Autowired
    private FormRepository formRepository;

    @Override
    public FormDataDto createForm(FormDataDto formDataDto) {
            FormData data = AccountMapper.mapToForm(formDataDto);
            FormData savedData = formRepository.save(data);
            return AccountMapper.mapToFormDTO(savedData);
    }

    @Override
    public List<FormDataDto> getAllUsers() {
        List<FormData> formData = formRepository.findAll();
        return formData.stream().map((Form -> AccountMapper.mapToFormDTO(Form)))
                .collect(Collectors.toList());
    }
}
