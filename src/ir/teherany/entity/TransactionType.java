package ir.teherany.entity;

import java.io.Serializable;

public class TransactionType implements Serializable {
    private Long id;
    private String type;
    private Integer value;

    public Long getId() {
        return id;
    }

    public TransactionType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TransactionType setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public TransactionType setValue(Integer value) {
        this.value = value;
        return this;
    }
}
