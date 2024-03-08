package com.example.bankapp.repositories;

import com.example.bankapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Customer findByCustomerIdAndPassword(Long customerId, String password);
  Customer findByAccountNumber(String accountNumber);
  
}
