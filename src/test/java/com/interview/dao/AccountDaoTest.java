package com.interview.dao;

import com.interview.model.Account;
import com.interview.sequences.SequenceGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.*;

public class AccountDaoTest extends BaseDaoTestCase {
    @Autowired
    private AccountDao dao;

    @Test
    public void testGetInvalidAccountNumber() throws Exception {
        Account account = dao.findByAccountNumber(Long.MIN_VALUE);
        assertNull(account);
    }

    @Test
    public void testGetAccountByNumber() throws Exception {
        Account account = dao.findByAccountNumber( 99896611L);
        assertNotNull(account);
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account = dao.get(-1L);
        account.setPhoneNumber("0877157922");
        dao.save(account);
        flush();
        
        account = dao.get(-1L);
        assertEquals("0877157922", account.getPhoneNumber());
    }

    @Test
    public void testAddAndRemoveAccount() throws Exception {
        Long newNumber = SequenceGenerator.getInstance().getNextValueAccountNumber();
        Account account = new Account();
        account.setAccountNumber(newNumber);
        account.setName("Merthin Builder");
        account.setAddress("Temple Bar, Dublin 2");
        account.setPhoneNumber("0887734234");
        account = dao.save( account);
        flush();
        
        dao.remove(account);
        flush();

        account = dao.findByAccountNumber(newNumber);
        assertNull(account);
    }

}
