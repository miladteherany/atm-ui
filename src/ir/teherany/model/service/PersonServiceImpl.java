package ir.teherany.model.service;

import ir.teherany.entity.Person;
import ir.teherany.model.repository.PersonDA;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private static final PersonServiceImpl personService = new PersonServiceImpl();

    private PersonServiceImpl() {
    }

    public static PersonServiceImpl getInstance() {
        return personService;
    }

    @Override
    public void save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.insert(person);
        }
    }

    @Override
    public void update(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.update(person);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.delete(id);
        }
    }

    @Override
    public Person findOne(long id) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            return personDA.selectOne(id);
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            List<Person> personList = personDA.selectAll();
            return personList;
        }
    }
}
