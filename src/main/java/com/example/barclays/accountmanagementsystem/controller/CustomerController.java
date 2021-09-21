package com.example.barclays.accountmanagementsystem.controller;


import com.example.barclays.accountmanagementsystem.entity.AccountTransactions;
import com.example.barclays.accountmanagementsystem.entity.Customer;
import com.example.barclays.accountmanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/accounts/{customerId}")
    public Customer customerDetails(@PathVariable int customerId)
    {
        return customerService.customerDetails(customerId);
    }


    @GetMapping("/mini-statements/{accountNo}/{customerId}")
    public AccountTransactions accountTransactions(@PathVariable int accountNo,int customerId)
    {
          return customerService.transactions(accountNo,customerId);
    }
}
