package ir.teherany.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Withdraw implements Serializable {
    private Long id;
    private Double amount;
    private Timestamp createdDate;
    private Account account;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    public Long getId() {
        return id;
    }

    public Withdraw setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Withdraw setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Withdraw setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Withdraw setAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Withdraw setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Withdraw setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
