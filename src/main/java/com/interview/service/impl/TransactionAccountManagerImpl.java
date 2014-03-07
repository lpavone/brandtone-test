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
import com.interview.sequences.SequenceGenerator;
import com.interview.service.AccountManager;
import com.interview.service.TransactionAccountManager;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo Pavone
 */
@Service("transactionAccountManager")
public class TransactionAccountManagerImpl extends GenericManagerImpl<Transaction, Long> implements TransactionAccountManager{
    
    
    private TransactionDao transactionDao;
    @Autowired
    @Qualifier("accountManager")
    private AccountManager accountManager;


    @Autowired
    public TransactionAccountManagerImpl(TransactionDao transactionDao) {
        super(transactionDao);
        this.transactionDao = transactionDao;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public void makeLodgment(Long accountNumber, BigDecimal amount) throws AccountException {
        
        Account account = accountManager.findByAccountNumber(accountNumber);
        
        account.deposit(amount);
        accountManager.save(account);
        
        createTransaction(Transaction.Type.LODGEMENT, amount, accountNumber, null);
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
        
        Account accountFrom = accountManager.findByAccountNumber(accountNumberFrom);
        Account accountTo = accountManager.findByAccountNumber(accountNumberTo);
        
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
        
        accountManager.save(accountFrom);
        accountManager.save(accountTo);                
        
        createTransaction(Transaction.Type.TRANSFER, amount, accountNumberFrom, accountNumberTo);
    }

    @Override
    public List<Transaction> getTransactions(Long accountNumber, Integer limit) throws AccountException {
        
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber", accountNumber);
        
        return transactionDao.findByNamedQuery("Transaction.findAllOrderedByDate", params, limit);
        
    }
    
    private Transaction createTransaction(Transaction.Type type, BigDecimal amount,
            Long accountFrom, Long accountTo){
        
        Transaction transaction = new Transaction(
                SequenceGenerator.getInstance().getNextValueTransactionID(), 
                Calendar.getInstance().getTime(),
                type.getTextType(),
                amount,
                accountFrom,
                accountTo);
        
        return transactionDao.save(transaction);
    }

}
