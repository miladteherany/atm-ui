package ir.teherany.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public sealed class Transaction implements Serializable permits Deposit, Withdraw {
    private Long id;
    private Double amount;
    private Timestamp createdDate;
    private Account account;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    public Long getId() {
        return id;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Transaction setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Transaction setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Transaction setAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Transaction setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
