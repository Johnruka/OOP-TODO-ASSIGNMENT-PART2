package se.lexicon.impl;

import se.lexicon.Dao.PersonDao;
import se.lexicon.Sequencer.PersonSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private final List<Person> people;


    private static PersonDaoImpl instance;


    private PersonDaoImpl() {
        people = new ArrayList<>();
    }


    public static PersonDaoImpl getInstance() {
        if (instance == null) instance = new PersonDaoImpl();
        return instance;
    }

    @Override
    public Person persist(Person person) {
        if (person.getId() != 0) throw new IllegalStateException("Invalid state person.id was not 0 or null");
        if (findByEmail(person.getEmail()) != null) {
            throw new IllegalStateException("Email " + person.getEmail() + " is taken");
        }
        person.setId(PersonSequencer.nextId());
        people.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : people) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findUsername(String username) {
        for (Person person : people) {
            if (person.getCredentials().getUsername().equalsIgnoreCase(username)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    @Override
    public void remove(int id) {
        Person person = findById(id);
        if (person != null) people.remove(person);
    }
}
