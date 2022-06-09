package ir.teherany.entity;

public class AccountType {
    private Long id;
    private String type;
    private Integer value;

    public Long getId() {
        return id;
    }

    public AccountType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public AccountType setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public AccountType setValue(Integer value) {
        this.value = value;
        return this;
    }
}
