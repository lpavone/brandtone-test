/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.dao.hibernate;

import com.interview.dao.AccountDao;
import com.interview.model.Account;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leonardo Pavone
 */
@Repository("accountDao")
public class AccountDaoHibernate extends GenericDaoHibernate<Account, Long> implements AccountDao{

    public AccountDaoHibernate() {
        super(Account.class);
    }

    @Override
    public Account findByAccountNumber(Long accountNumber) {
        
       return (Account) getSession().createCriteria(Account.class)
               .add(Restrictions.eq("accountNumber", accountNumber)).uniqueResult();

    }
}

