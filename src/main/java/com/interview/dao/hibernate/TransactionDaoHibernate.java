/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.dao.hibernate;

import com.interview.dao.TransactionDao;
import com.interview.model.Transaction;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leonardo Pavone
 */
@Repository("transactionDao")
public class TransactionDaoHibernate extends GenericDaoHibernate<Transaction, Long> implements TransactionDao{

    
    public TransactionDaoHibernate() {
        super(Transaction.class);
    }
    
    @Override
    public List<Transaction> findByNamedQuery(String queryName, Map<String, Object> queryParams, Integer limit) {
        Session sess = getSession();
        Query namedQuery = sess.getNamedQuery(queryName);

        for (String s : queryParams.keySet()) {
            namedQuery.setParameter(s, queryParams.get(s));
        }

        return (limit != null) ? namedQuery.setMaxResults(limit.intValue()).list() : namedQuery.list();
    }
}
