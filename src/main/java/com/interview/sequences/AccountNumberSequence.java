/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */
package com.interview.sequences;

import java.util.Random;

/**
 * Singleton class to keep a sequence of account numbers.
 * 
 * @author Leonardo Pavone
 */
public class AccountNumberSequence {

    private static AccountNumberSequence instance;
    private static Long currentValue;
    private static final Object currentValueLock = new Object();

    /**
     * A random number to initialize, it represent the current quantity of bank
     * accounts created at any moment.
     */
    static {
        currentValue = new Long( new Random().nextLong());
    }

    private AccountNumberSequence() {
    }

    public static synchronized AccountNumberSequence getInstance() {
        if (instance == null) {
            instance = new AccountNumberSequence();
        }
        return instance;
    }
    
    public static Long getNextValue(){
        Long value;
        /**
         * Lock in currentValueLock object to allow
         * just one thread access at the same time.
         */
        synchronized(currentValueLock){
            value = ++currentValue;
        }
        return value;
    }
}