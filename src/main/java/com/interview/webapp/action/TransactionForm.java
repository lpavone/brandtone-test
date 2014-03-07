/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */
package com.interview.webapp.action;

import com.interview.exception.AccountException;
import com.interview.model.Transaction;
import com.interview.service.TransactionAccountManager;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leonardo Pavone
 */
@ViewScoped
@Component("transactionForm")
public class TransactionForm extends BasePage implements Serializable {

    @Autowired
    @Qualifier("transactionAccountManager")
    private TransactionAccountManager transactionAccountManager;
    private List<Transaction> transactions;
    private Long accountNumber;
    private Long accountNumberTo;
    private Integer limit;
    
    private BigDecimal amount;

    public Long getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(Long accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    public TransactionAccountManager getTransactionAccountManager() {
        return transactionAccountManager;
    }

    public void setTransactionAccountManager(TransactionAccountManager transactionAccountManager) {
        this.transactionAccountManager = transactionAccountManager;
    }

    public List<Transaction> getTransactions() {
        try{
            return transactionAccountManager.getTransactions( accountNumber, limit);
        }catch(AccountException e){
            addError("Error retrieving transactions from database");
        }
        return Collections.EMPTY_LIST;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String search(){
        
        return "success";
    }
    
    public void deposit(){
        try {
            transactionAccountManager.makeLodgment(accountNumber, amount);
            addMessage("deposit.success");
        } catch (AccountException ex) {
            addError("deposit.error");
        }
    }
    
    public void transfer(){
        try {
            transactionAccountManager.makeTransfer(accountNumber, accountNumberTo, amount);
            addMessage("transfer.success");
        } catch (AccountException e) {
            addError("transfer.error");
        }
    }
}
