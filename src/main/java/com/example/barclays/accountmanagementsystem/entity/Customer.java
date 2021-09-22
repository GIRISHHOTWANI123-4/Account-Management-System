package com.example.barclays.accountmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String name;
    private Date dob;
    private String email;
    private String address;
    private String PanCardNo;
    private int AadharNo;


    @OneToMany
    @JoinColumn(name="customerId",referencedColumnName = "customerId")
    private List<CustomerBankAccount> accounts;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPanCardNo() {
        return PanCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        PanCardNo = panCardNo;
    }

    public int getAadharNo() {
        return AadharNo;
    }

    public void setAadharNo(int aadharNo) {
        AadharNo = aadharNo;
    }

    public List<CustomerBankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CustomerBankAccount> accounts) {
        this.accounts = accounts;
    }
}
