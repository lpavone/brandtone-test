/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class Account {
    
    private static BigInteger accountNumberSequence;
    
    private final BigInteger accountNumber;
    private String name;    
    private String address;
    private String phoneNumber;
    private BigDecimal balance;
    
    /**
     * A random number to initialize, it represent the current quantity of bank accounts created at any moment.
     */
    static{
        accountNumberSequence = new BigInteger(40, new Random());
    }

    
    public Account(BigInteger accountNumber){
        this.accountNumber = accountNumber;
    }
        
    
    public BigInteger getAccountNumber() {
        return accountNumber;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    
    
}
