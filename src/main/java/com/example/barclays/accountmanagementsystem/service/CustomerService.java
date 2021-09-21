package com.example.barclays.accountmanagementsystem.service;


import com.example.barclays.accountmanagementsystem.dto.TransactionDetails;
import com.example.barclays.accountmanagementsystem.entity.AccountTransactions;
import com.example.barclays.accountmanagementsystem.entity.Customer;
import com.example.barclays.accountmanagementsystem.entity.CustomerBankAccount;
import com.example.barclays.accountmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer customerDetails(int customerId)
    {
        return customerRepository.findById(customerId).orElse(null);
    }

    public AccountTransactions transactions(int accountNo, int customerId)
    {
          Customer customer=customerRepository.findById(customerId).orElse(null);
          List<CustomerBankAccount> cref=customer.getAccounts();
          if(cref.contains(accountNo))
          {
              for(int i=0;i<cref.size();i++)
              {
                  if(cref.get(i).getAccountNo()==accountNo)
                  {
                      List<AccountTransactions> transactionDetails=cref.get(i).getAccountTransactions();
                      return (AccountTransactions) transactionDetails;
                  }
              }
          }
           return null;




    }

}
