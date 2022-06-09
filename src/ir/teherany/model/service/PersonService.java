package ir.teherany.model.service;

import ir.teherany.entity.Person;

import java.util.List;

public interface PersonService {
    void save(Person person) throws Exception;

    void update(Person person) throws Exception;

    void remove(long id) throws Exception;

    Person findOne(long id) throws Exception;
    List<Person> findAll() throws Exception;
}
