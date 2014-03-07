/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.dao;

import com.interview.model.Transaction;
import java.util.List;
import java.util.Map;

/**
 *  New DAO to redefine findByNamedQuery to add limit value
 * @author Leonardo Pavone
 */
public interface TransactionDao extends GenericDao<Transaction, Long> {

    public List<Transaction> findByNamedQuery(String queryName, Map<String, Object> queryParams, Integer limit);

}


