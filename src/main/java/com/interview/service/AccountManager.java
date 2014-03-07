/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service;

import com.interview.exception.AccountException;
import com.interview.model.Account;
import com.interview.model.Address;

/**
 *
 * @author Leonardo Pavone
 */
public interface AccountManager extends GenericManager<Account, Long> {
    
    /**
     * Create a new account.
     * 
     * @param name Person's name
     * @param address Person's address
     * @param phoneNumber Person's phone

     * 
     * @throws AccountException 
     */
    public Account createAccount(String name, String address, String phoneNumber) throws AccountException;
    
    public Account findByAccountNumber(Long AccountNumber) throws AccountException;
    
}
