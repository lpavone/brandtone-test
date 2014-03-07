/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */
package com.interview.sequences;

/**
 * Singleton class to keep a sequence of account numbers and 
 * transaction IDs without duplicate values.
 * 
 * @author Leonardo Pavone
 */
public class SequenceGenerator {

    private static SequenceGenerator instance;
    private static Long accountNumberCurrentValue;
    private static Long transactionIDCurrentValue;
    private final static Object lock1 = new Object();
    private final static Object lock2 = new Object();

    /**
     * A random number to initialize, it represent the current value for new accounts.
     * 
     */
    static {
        accountNumberCurrentValue = new Long( 99898755);
        transactionIDCurrentValue = new Long( 22345999);
    }

    private SequenceGenerator() {}

    public static SequenceGenerator getInstance() {
        if (instance == null) {
            instance = new SequenceGenerator();
        }
        return instance;
    }
    
    public Long getNextValueAccountNumber(){
        Long value;
        /**
         * Lock in singleton object to allow
         * just one thread access at the same time to
         * update the value.
         */
        synchronized(lock1){
            value = ++accountNumberCurrentValue;
        }
        return value;
    }

    public Long getNextValueTransactionID(){
        Long value;

        synchronized(lock2){
            value = ++transactionIDCurrentValue;
        }
        return value;
    }
}
