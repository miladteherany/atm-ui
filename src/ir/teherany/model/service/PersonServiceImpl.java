package ir.teherany.model.service;

import ir.teherany.entity.Person;
import ir.teherany.model.repository.PersonDA;

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
}
