/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Represent a transaction account (deposit, transfer, account created)
 * 
 * @author Leonardo Pavone
 */
public class Transaction {
    
    private static BigInteger transactionNumberSequence;

    private static enum type { LODGEMENT, TRANSFER };
    private BigInteger transactionID;
    private Date date;
    private final String transactionType;
    private BigDecimal amount;
    private BigInteger accountNumberFrom;
    private BigInteger accountNumberTo;
    
    public Transaction( BigInteger transactionID, Date date, String transactionType,
            BigDecimal amount, BigInteger accountNumberFrom, BigInteger accountNumberTo){
        
        this.transactionID = transactionID;
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
    }

    public static BigInteger getTransactionNumberSequence() {
        return transactionNumberSequence;
    }

    public static void setTransactionNumberSequence(BigInteger transactionNumberSequence) {
        Transaction.transactionNumberSequence = transactionNumberSequence;
    }

    public BigInteger getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(BigInteger transactionID) {
        this.transactionID = transactionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(BigInteger accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public BigInteger getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(BigInteger accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.transactionID != null ? this.transactionID.hashCode() : 0);
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
        final Transaction other = (Transaction) obj;
        if (this.transactionID != other.transactionID && (this.transactionID == null || !this.transactionID.equals(other.transactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", date=" + date + ", transactionType=" + transactionType + ", amount=" + amount + ", accountNumberFrom=" + accountNumberFrom + ", accountNumberTo=" + accountNumberTo + '}';
    }
    
    
    
    
}
