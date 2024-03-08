package com.example.bankapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {

  @Id
  private Long transactionId;

  private Long fromAccount;
  private Long toAccount;
  private String ifsc;
  private double amount;
  private LocalDateTime timestamp = LocalDateTime.now();
}
