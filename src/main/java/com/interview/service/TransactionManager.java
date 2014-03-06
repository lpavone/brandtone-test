/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service;

import com.interview.exception.AccountException;
import com.interview.model.Transaction;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Services to manage account transactions.
 * 
 * @author Leonardo Pavone
 */
public interface TransactionManager {

    /**
     * Deposit an amount of money into an account.
     * 
     * @param accountNumber Destination account
     * @param amount Amount of money
     * @throws AccountException 
     */
    public void makeLodgment(BigInteger accountNumber, BigDecimal amount) throws AccountException;
    
    /**
     * Transfer an amount of money between two accounts.
     * 
     * @param accountNumberFrom Debit Account
     * @param accountNumberTo Deposit Account
     * @param amount Amount of money
     * 
     * @throws AccountException 
     */
    public void makeTransfer(BigInteger accountNumberFrom, 
            BigInteger accountNumberTo, BigDecimal amount) throws AccountException;
    
    /**
     * Get last 10 account transactions 
     * @param accountNumber Account 
     * @return
     * @throws AccountException 
     */
    public List<Transaction> getRecentTransactions(BigInteger accountNumber) throws AccountException;
    
    
    /**
     * Get all account transactions 
     * @param accountNumber Account 
     * @return
     * @throws AccountException 
     */
    public List<Transaction> getAllTransactions(BigInteger accountNumber) throws AccountException;

}