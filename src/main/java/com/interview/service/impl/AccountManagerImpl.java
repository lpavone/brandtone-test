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

//    @Autowired
//    public GenericDao<Account, Long> getAccountDao() {
//        return accountDao;
//    }
//
//    public void setAccountDao(GenericDao<Account, Long> accountDao) {
//        this.accountDao = accountDao;
//    }

    @Override
    public void createAccount(String name, Address address, String phoneNumber) throws AccountException {
        
        Account newAccount = new Account( 
                SequenceGenerator.getInstance().getNextValueAccountNumber() );
        newAccount.setName(name);
        newAccount.setAddress(address);
        newAccount.setPhoneNumber(phoneNumber);
        
        
        accountDao.save(newAccount);
    }


}
