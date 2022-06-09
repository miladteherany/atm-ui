package ir.teherany.entity;

import java.io.Serializable;

public class TransactionStatus implements Serializable {
    private Long id;
    private String status;
    private Integer value;

    public Long getId() {
        return id;
    }

    public TransactionStatus setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TransactionStatus setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public TransactionStatus setValue(Integer value) {
        this.value = value;
        return this;
    }
}
