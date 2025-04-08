package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "FormData")
@NoArgsConstructor
@AllArgsConstructor
public class FormData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    private String email;
    private String paragraph;
    private Long mobile;


    public FormData(Long id, String name, Long mobile, String email, String paragraph) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.paragraph = paragraph;

    }
}
