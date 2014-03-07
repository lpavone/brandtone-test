/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service.impl;

import com.interview.dao.AccountDao;
import com.interview.dao.TransactionDao;
import com.interview.exception.AccountException;
import com.interview.model.Account;
import com.interview.model.Transaction;
import com.interview.service.TransactionAccountManager;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo Pavone
 */
@Service("transactionManager")
public class TransactionAccountManagerImpl extends GenericManagerImpl<Transaction, Long> implements TransactionAccountManager{
    
    private TransactionDao transactionDao;
    private AccountDao accountDao;


    @Autowired
    public TransactionAccountManagerImpl(TransactionDao transactionDao) {
        super(transactionDao);
        this.transactionDao = transactionDao;
    }

    @Autowired
    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void makeLodgment(Long accountNumber, BigDecimal amount) throws AccountException {
        
        Account account = accountDao.findByAccountNumber(accountNumber);
        
        account.deposit(amount);
        accountDao.save(account);
        
        
    }

    /**
     * Transaction method managed by Spring container.
     * 
     * @param accountNumberFrom
     * @param accountNumberTo
     * @param amount
     * @throws AccountException 
     */
    @Override
    public void makeTransfer(Long accountNumberFrom, Long accountNumberTo, BigDecimal amount) throws AccountException {
        
        Account accountFrom = accountDao.findByAccountNumber(accountNumberFrom);
        Account accountTo = accountDao.findByAccountNumber(accountNumberTo);
        
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
        
        accountDao.save(accountFrom);
        accountDao.save(accountTo);                
        
    }

    @Override
    public List<Transaction> getTransactions(Long accountNumber, Integer limit) throws AccountException {
        
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber", accountNumber);
        
        return transactionDao.findByNamedQuery("Transaction.findAllOrderedByDate", params, limit);
        
    }
    
    private Transaction createTransaction(){
        Transaction transaction = new Transaction(Long.MIN_VALUE, 
                null, null, BigDecimal.ZERO, Long.MIN_VALUE, Long.MIN_VALUE);
        
        return transactionDao.save(transaction);
    }

}
