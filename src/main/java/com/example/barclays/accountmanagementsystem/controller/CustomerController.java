package com.example.barclays.accountmanagementsystem.controller;

import com.example.barclays.accountmanagementsystem.entity.AccountTransactions;
import com.example.barclays.accountmanagementsystem.entity.Customer;
import com.example.barclays.accountmanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/accounts/{customerId}")
    public Customer customerDetails(@PathVariable int customerId) {
        return customerService.customerDetails(customerId);
    }


    @GetMapping("/mini-statements/{accountNo}/{customerId}")

    public List<AccountTransactions> accountTransactions(@PathVariable int accountNo, @PathVariable int customerId) {
//          System.out.println("Account No "+accountNo +"Customer Id ="+customerId);
        return customerService.transactions(accountNo, customerId);
    }

    @PostMapping("/cash-withdrawl/{accountNo}")
    public boolean withdrawl(@RequestBody AccountTransactions accountTransactions, @PathVariable Integer accountNo) {
        System.out.println("Account  = "+ accountNo);
        System.out.println(accountTransactions.getType());
//        System.out.println(accountNo);
        //using accounttransactions repo save the accountTransactions object
        //add this accounttransactions in customer-bank account
        customerService.cashWithDrawl(accountNo, accountTransactions);
        return true;
    }

    @PostMapping("/cash-deposit/{accountNo}")
    public boolean deposit(@RequestBody AccountTransactions accountTransactions, @PathVariable Integer accountNo) {

        customerService.cashDeposit(accountNo, accountTransactions);
        return true;
    }


    @PostMapping("/amount-transfer/{accountNo}")
    public boolean transferAmount(@RequestBody AccountTransactions accountTransactions, @PathVariable Integer accountNo) {
        customerService.transferAmount(accountNo, accountTransactions);
        return true;
    }

    @GetMapping("/active-accounts/{customerId}")
    public int activeAccounts(@PathVariable int customerId) {
        return customerService.activeAccounts(customerId);
    }

    @GetMapping("/last-debit-amount/{accountNo}/{customerId}")
    public int latestDebitAmount(@PathVariable int accountNo,@PathVariable int customerId) {
        return customerService.latestDebitAmount(accountNo,customerId);
    }

    @GetMapping("/last-credit-amount/{accountNo}/{customerId}")
    public int latestCreditAmount(@PathVariable int accountNo,@PathVariable int customerId) {
        return customerService.latestCreditAmount(accountNo,customerId);
    }
     @GetMapping("/balance-amount/{accountNo}")
    public double balanceAmount(@PathVariable int accountNo)
    {

        return customerService.balanceAmount(accountNo);
    }

    @GetMapping("/getaccountnumbers/{customerId}")
    public List<Integer> getAccountNumbers(@PathVariable int customerId) {
        return customerService.getAccountNumbers(customerId);
    }

    @GetMapping("/getaccountnumbersfrompan/{pancardid}")
    public List<Integer> getAccountNumbers(@PathVariable String pancardid) {
        return customerService.getAccountNumbers(pancardid);
    }
}
