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
    
    private static enum type { CHECKING_ACCOUNT, SAVING_ACCOUNT, CERTIFICATE_OF_DEPOSIT,
                MONEY_MARKET_ACCOUNT, INDIVIDUAL_RETIREMENT_ACCOUNTS };
    
    private final BigInteger accountNumber;
    private String name;    
    private String address;
    private String phoneNumber;
    private BigDecimal balance;
    private String accountType;
    
    
    public Account(BigInteger accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.accountNumber != null ? this.accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.accountNumber != other.accountNumber && (this.accountNumber == null || !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", balance=" + balance + ", accountType=" + accountType + '}';
    }
    
    
}
