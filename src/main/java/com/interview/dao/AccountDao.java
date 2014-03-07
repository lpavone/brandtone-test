/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.dao;

import com.interview.exception.AccountException;
import com.interview.model.Account;

/**
 *  Account DAO 
 * 
 * @author Leonardo Pavone
 */
public interface AccountDao extends GenericDao<Account, Long> {

    public Account findByAccountNumber(Long accountNumber) throws AccountException;

}


