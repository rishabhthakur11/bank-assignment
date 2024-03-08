package com.example.bankapp.services;

import com.example.bankapp.models.Customer;
import com.example.bankapp.models.Transaction;
import com.example.bankapp.repositories.CustomerRepository;
import com.example.bankapp.repositories.TransactionRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class BankingService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private TransactionRepo transactionRepository;

  public boolean transferAmount(
    Long fromAccount,
    Long toAccount,
    String ifsc,
    double amount
  ) {
    Customer sender = customerRepository.findByAccountNumber(
      fromAccount.toString()
    );
    Customer receiver = customerRepository.findByAccountNumber(
      toAccount.toString()
    );

    if (
      sender != null &&
      receiver != null &&
      sender.getAccountNumber() != null &&
      receiver.getAccountNumber() != null
    ) {
      if (sender.getAccountNumber().equals(receiver.getAccountNumber())) {
        return false; // Same account transfer not allowed
      }

      if (
        sender.getAccountNumber().equals(fromAccount.toString()) &&
        receiver.getAccountNumber().equals(toAccount.toString())
      ) {
        if (sender.getBalance() >= amount) {
          // Update sender's balance
          sender.setBalance(sender.getBalance() - amount);
          customerRepository.save(sender);

          // Update receiver's balance
          receiver.setBalance(receiver.getBalance() + amount);
          customerRepository.save(receiver);

          // Save transaction details
          Transaction transaction = new Transaction();
          transaction.setFromAccount(fromAccount);
          transaction.setToAccount(toAccount);
          transaction.setIfsc(ifsc);
          transaction.setAmount(amount);
          transactionRepository.save(transaction);

          return true;
        }
      }
    }
    return false;
  }

  public double getBalanceByAccountNumber(Long accountNumber) {
    Customer customer = customerRepository.findByAccountNumber(
      accountNumber.toString()
    );
    return (customer != null) ? customer.getBalance() : 0.0;
  }

  public List<Customer> getAccountsAboveBalance(double amount) {
    List<Customer> allCustomers = customerRepository.findAll();

    return allCustomers
      .stream()
      .filter(customer -> customer.getBalance() > amount)
      .collect(Collectors.toList());
  }

  public List<Customer> getAccountsBelowBalance(double amount) {
    List<Customer> allCustomers = customerRepository.findAll();

    return allCustomers
      .stream()
      .filter(customer -> customer.getBalance() < amount)
      .collect(Collectors.toList());
  }
}
