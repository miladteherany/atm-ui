package ir.teherany.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String nationalCode;
    private Integer deletedDate;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Person setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public Integer getDeletedDate() {
        return deletedDate;
    }

    public Person setDeletedDate(Integer deletedDate) {
        this.deletedDate = deletedDate;
        return this;
    }
}
