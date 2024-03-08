package com.example.bankapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

  @Id
  private Long customerId;

  private String password;
  private String accountNumber;
  private String accountType;
  private double balance;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getPassword() {
    return password;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getAccountType() {
    return accountType;
  }

  public double getBalance() {
    return balance;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
