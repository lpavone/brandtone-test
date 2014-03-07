/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service.impl;

import com.interview.dao.GenericDao;
import com.interview.exception.AccountException;
import com.interview.model.Account;
import com.interview.model.Address;
import com.interview.sequences.SequenceGenerator;
import com.interview.service.AccountManager;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo Pavone
 */
@Service("accountManager")
public class AccountManagerImpl extends GenericManagerImpl<Account, Long> implements AccountManager{
    
    private GenericDao<Account, Long> accountDao;

    @Autowired
    public AccountManagerImpl(GenericDao<Account,Long> accountDao) {
        super(accountDao);
        this.accountDao = accountDao;
    }

    @Override
    public Account createAccount(String name, String address, String phoneNumber) throws AccountException {
        
        Long accountNumber = SequenceGenerator.getInstance().getNextValueAccountNumber();
        Account newAccount = new Account();
        newAccount.setAccountNumber(accountNumber);
        newAccount.setBalance(BigDecimal.ZERO);
        newAccount.setName(name);
        newAccount.setAddress(address);
        newAccount.setPhoneNumber(phoneNumber);
                
        return accountDao.save(newAccount); 
        
    }

    @Override
    public Account findByAccountNumber(Long accountNumber) throws AccountException {
        
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber", accountNumber);
        
        return accountDao.findByNamedQuery("Account.findByAccountNumber", params).get(0);//Simplified, but not good practice
    }
    
    


}
