package com.example.bankapp.repositories;

import com.example.bankapp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {}
