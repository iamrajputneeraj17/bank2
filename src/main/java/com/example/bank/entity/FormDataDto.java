package com.example.bank.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDataDto {

    private Long id;
    private String name;
    private String email;
    private String paragraph;
    private Long mobile;


    public FormDataDto(Long id, String name, Long mobile, String email, String paragraph ) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.paragraph = paragraph;
    }
}
