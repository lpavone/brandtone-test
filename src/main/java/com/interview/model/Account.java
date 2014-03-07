/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Account class.
 * 
 * 
 * @author Leonardo
 */
@Entity
@Table(name = "account_")
@Indexed
@NamedQueries({
        @NamedQuery(name = "Account.findByAccountNumber",
                query = "select a from Account a where a.accountNumber = :accountNumber "),
})
public class Account extends IdentityEntity{    
    
    
    private Long accountNumber;
    private String name;    
    private String address;
    private String phoneNumber;
    private BigDecimal balance;
    
    public Account() {
    }

        
    @Column(name="account_number", unique = true)
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name="balance")
    public synchronized BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance){
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
        return "Account{" + "accountNumber=" + accountNumber + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", balance=" + balance + '}';
    }
    
    /**
     * Sync block to access the balance
     */
    public synchronized void deposit(BigDecimal amount){
        getBalance().add(amount);
        
    }
    
    public synchronized void withdraw(BigDecimal amount){
        getBalance().subtract(amount);
    }
    
}
