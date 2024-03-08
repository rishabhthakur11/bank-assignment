package com.example.bankapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
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

  public Long getTransactionId() {
    return transactionId;
  }

  public Long getFromAccount() {
    return fromAccount;
  }

  public Long getToAccount() {
    return toAccount;
  }

  public String getIfsc() {
    return ifsc;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public void setFromAccount(Long fromAccount) {
    this.fromAccount = fromAccount;
  }

  public void setToAccount(Long toAccount) {
    this.toAccount = toAccount;
  }

  public void setIfsc(String ifsc) {
    this.ifsc = ifsc;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
