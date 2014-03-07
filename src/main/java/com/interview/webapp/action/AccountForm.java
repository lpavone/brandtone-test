/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */
package com.interview.webapp.action;

import com.interview.exception.AccountException;
import com.interview.model.Account;
import com.interview.service.AccountManager;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leonardo Pavone
 */
@RequestScoped
@Component("accountForm")
public class AccountForm extends BasePage implements Serializable {

    @Autowired
    @Qualifier("accountManager")
    private AccountManager accountManager;
    private String name;
    private String phoneNumber;
    private String address;

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void save() {
        try {
            accountManager.createAccount(name, address, phoneNumber);

            addMessage("account.created");
            
            name = null;
            address = null;
            phoneNumber = null;
            
        } catch(AccountException e){
            addMessage("Error creating account");
        } 
    }
    
    public List<Account> getAccounts(){
        return accountManager.getAll();
    }
}
