/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.service;

import com.interview.exception.AccountException;
import java.math.BigInteger;

/**
 *
 * @author Leonardo Pavone
 */
public interface AccountManager {
    
    /**
     * Create a new account.
     * 
     * @param accountNumber Number of the account.
     * 
     * @throws AccountException 
     */
    public void createAccount(BigInteger accountNumber) throws AccountException;
    
    
}
