/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service;

import com.interview.exception.AccountException;
import com.interview.model.Address;

/**
 *
 * @author Leonardo Pavone
 */
public interface AccountManager {
    
    /**
     * Create a new account.
     * 
     * @param name Person's name
     * @param address Person's address
     * @param phoneNumber Person's phone
     * @param accountType Type of account
     * 
     * @throws AccountException 
     */
    public void createAccount(String name, Address address, String phoneNumber) throws AccountException;
    
    
}
