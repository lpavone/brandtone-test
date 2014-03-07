package com.interview.dao;

import com.interview.model.Account;
import com.interview.model.Transaction;
import com.interview.sequences.SequenceGenerator;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.*;

public class TransactionDaoTest extends BaseDaoTestCase {
    @Autowired
    private TransactionDao dao;

    @Test
    public void testGetTransactions() throws Exception {
        
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber", 99896611L);
        
        List<Transaction> transactions = dao.findByNamedQuery("Transaction.findAllOrderedByDate", 
                params, 10);

        assertNotNull(transactions);
    }


    @Test
    public void testCreateTransaction() throws Exception {

        Transaction transaction = new Transaction(
                SequenceGenerator.getInstance().getNextValueTransactionID(), 
                Calendar.getInstance().getTime(), 
                Transaction.Type.TRANSFER.getTextType(), 
                BigDecimal.valueOf(300L), 
                92344755L, 
                99898755L);
        transaction = dao.save(transaction);        
        flush();

        assertNotNull(transaction);
    }

}
