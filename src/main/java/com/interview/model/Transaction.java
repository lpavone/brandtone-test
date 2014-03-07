/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */

package com.interview.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.hibernate.search.annotations.Indexed;

/**
 * Represent a transaction account (deposit, transfer, account created)
 * 
 * @author Leonardo Pavone
 */
@Entity
@Table(name = "transaction_")
@Indexed
@NamedQueries({
        @NamedQuery(name = "Transaction.findAllOrderedByDate",
                query = "select t from Transaction t where t.accountNumberFrom = :accountNumber or t.accountNumberTo = :accountNumber order by t.date desc"),
})
public class Transaction extends IdentityEntity{
    
    public static enum Type { LODGEMENT("lodgement"), TRANSFER("transfer");
  
        private final String textType;  
  
        private Type(String textType) {  
            this.textType = textType;  
        }  
  
        public String getTextType() {  
            return textType;  
        }  
    };  
       
    private Long transactionID;    
    private Date date;
    private String transactionType;
    private BigDecimal amount;
    private Long accountNumberFrom;
    private Long accountNumberTo;

    public Transaction() {
    }
    
    public Transaction( Long transactionID, Date date, String transactionType,
            BigDecimal amount, Long accountNumberFrom, Long accountNumberTo){
        
        this.transactionID = transactionID;
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
    }

    @Column(name="transactionID")
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }
    
    /**
     * Date of transaction.
     * @return
     */
    @Column(name = "date_")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name="account_number_from")
    public Long getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(Long accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    @Column(name="account_number_to")
    public Long getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(Long accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    @Column(name = "transaction_type")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.transactionID != null ? this.transactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (this.transactionID != other.transactionID && (this.transactionID == null || !this.transactionID.equals(other.transactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", date=" + date + ", transactionType=" + transactionType + ", amount=" + amount + ", accountNumberFrom=" + accountNumberFrom + ", accountNumberTo=" + accountNumberTo + '}';
    }
    
    
}
