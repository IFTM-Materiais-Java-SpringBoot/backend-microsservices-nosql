package com.iftm.securityex.services;

import com.iftm.securityex.entities.Person;
import com.iftm.securityex.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    
    public ResponseEntity<List<Person>> findAll() {
        var dbPersons = repository.findAll();
        if(dbPersons.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dbPersons);
    }
    
    public ResponseEntity<Person> findById(String id) {
        var dbPerson = repository.findById(id);
        if(dbPerson.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dbPerson.get());
    }
    
    public ResponseEntity<Person> save(Person person) {
        return ResponseEntity.ok(repository.save(person));
    }
    
    public ResponseEntity<Person> update(Person person) {
        if(person.getId() == null)
            return ResponseEntity.badRequest().build();

        var dbPerson = repository.findById(person.getId());
        var curPerson = dbPerson.get();

        curPerson.setFirstName(person.getFirstName());
        curPerson.setLastName(person.getLastName());

        return ResponseEntity.ok(repository.save(curPerson));
    }
    
    public ResponseEntity<?> delete(String id) {
        repository.deleteById(id);
        if(!repository.findById(id).isEmpty())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.noContent().build();
    }
}
