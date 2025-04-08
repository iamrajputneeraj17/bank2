package com.example.bank.repository;

import com.example.bank.entity.Account;
import com.example.bank.entity.FormData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<FormData, Long> {
}

