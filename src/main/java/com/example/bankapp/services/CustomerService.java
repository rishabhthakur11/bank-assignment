package com.example.bankapp.services;

import com.example.bankapp.models.Customer;
import com.example.bankapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public boolean login(long customerId, String password) {
    Customer customer = customerRepository.findByCustomerIdAndPassword(
      customerId,
      password
    );
    return customer != null;
  }

  @SuppressWarnings("null")
  public Customer register(Customer customer) {
    return customerRepository.save(customer);
  }

  public boolean changePassword(
    Long customerId,
    String oldPassword,
    String newPassword
  ) {
    Customer customer = customerRepository.findByCustomerIdAndPassword(
      customerId,
      oldPassword
    );
    if (customer != null) {
      customer.setPassword(newPassword);
      customerRepository.save(customer);
      return true;
    }
    return false;
  }
}
