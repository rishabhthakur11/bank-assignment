package com.example.bankapp.controllers;

import com.example.bankapp.models.Customer;
import com.example.bankapp.services.BankingService;
import com.example.bankapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banking")
public class CustomerControllers {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private BankingService bankingService;

  @PostMapping("/login")
  public boolean login(
    @RequestBody Long customerId,
    @RequestBody String password
  ) {
    return customerService.login(customerId, password);
  }

  @PostMapping("/register")
  public Customer register(@RequestBody Customer customer) {
    return customerService.register(customer);
  }

  @PostMapping("/changepwd/{customerId}/{oldPassword}/{newPassword}")
  public boolean changePassword(
    @PathVariable Long customerId,
    @PathVariable String oldPassword,
    @PathVariable String newPassword
  ) {
    return customerService.changePassword(customerId, oldPassword, newPassword);
  }

  @PostMapping("/transfer")
  public String transferAmount(
    @RequestParam Long fromAccount,
    @RequestParam Long toAccount,
    @RequestParam String ifsc,
    @RequestParam double amount
  ) {
    boolean success = bankingService.transferAmount(
      fromAccount,
      toAccount,
      ifsc,
      amount
    );

    if (success) {
      return "Transfer successful!";
    } else {
      return "Transfer failed. Please check your details and try again.";
    }
  }

  @GetMapping("/balance")
  public double getBalanceByAccountNumber(@RequestParam Long accountNo) {
    return bankingService.getBalanceByAccountNumber(accountNo);
  }

  @GetMapping("/account/above")
  public List<Customer> getAccountsAboveBalance(@RequestParam double amount) {
    return bankingService.getAccountsAboveBalance(amount);
  }

  @GetMapping("/account/below")
  public List<Customer> getAccountsBelowBalance(@RequestParam double amount) {
    return bankingService.getAccountsBelowBalance(amount);
  }
}
