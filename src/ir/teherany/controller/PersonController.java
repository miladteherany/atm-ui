package ir.teherany.controller;

import ir.teherany.entity.Person;
import ir.teherany.model.service.PersonServiceImpl;

public class PersonController {
    public void save() {
        try {
            Person person = new Person()
                    .setFirstName("FirstName")
                    .setLastName("LastName")
                    .setAge(Integer.parseInt("Age"));
            PersonServiceImpl.getInstance().save(person);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
