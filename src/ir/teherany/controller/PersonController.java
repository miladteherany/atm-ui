package ir.teherany.controller;

import ir.teherany.entity.Person;
import ir.teherany.model.service.PersonServiceImpl;

public class PersonController {
    public void save(String name, String family, Integer age, String nationalCode) {
        try {
            Person person = null;
            if (name.length() != 0 && family.length() != 0) {
                person = new Person(name, family, age, nationalCode);
            }
            PersonServiceImpl.getInstance().save(person);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
