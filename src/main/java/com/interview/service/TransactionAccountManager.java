/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service;

import com.interview.exception.AccountException;
import com.interview.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

/**
 * Services to manage account transactions.
 * 
 * @author Leonardo Pavone
 */
public interface TransactionAccountManager {

    /**
     * Deposit an amount of money into an account.
     * 
     * @param accountNumber Destination account
     * @param amount Amount of money
     * @throws AccountException 
     */
    public void makeLodgment(Long accountNumber, BigDecimal amount) throws AccountException;
    
    /**
     * Transfer an amount of money between two accounts.
     * 
     * @param accountNumberFrom Debit Account
     * @param accountNumberTo Deposit Account
     * @param amount Amount of money
     * 
     * @throws AccountException 
     */
    public void makeTransfer(Long accountNumberFrom, 
            Long accountNumberTo, BigDecimal amount) throws AccountException;
        
    
    /**
     * Get account transactions.
     * @param accountNumber Account 
     * @param limit Max data results
     * @return
     * @throws AccountException 
     */
    public List<Transaction> getTransactions(Long accountNumber, Integer limit) throws AccountException;

}