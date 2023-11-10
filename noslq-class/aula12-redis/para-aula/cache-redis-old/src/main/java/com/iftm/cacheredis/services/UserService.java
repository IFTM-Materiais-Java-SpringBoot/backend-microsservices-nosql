package com.iftm.cacheredis.services;

import com.iftm.cacheredis.models.User;
import com.iftm.cacheredis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<List<User>> findAll() {
        var users = repository.findAll();
        if(users.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> findById(String id) {
        var user = repository.findById(id);
        if(user.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    public ResponseEntity<User> create(User user) {
        if(user == null)
            return ResponseEntity.badRequest().build();
        var dbUser = repository.save(user);
        return ResponseEntity.ok(dbUser);
    }

    public ResponseEntity<User> update(User user) {
        if(user.getId().toString().isBlank())
            return ResponseEntity.badRequest().build();

        var dbUser = repository.findById(user.getId());
        if(dbUser.isEmpty())
            return ResponseEntity.badRequest().build();

        var curUser = dbUser.get();
        curUser.setName(user.getName());
        curUser.setAge(user.getAge());
        curUser.setEmail(user.getEmail());
        var updatedUser = repository.save(curUser);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<?> delete(String id) {
        repository.deleteById(id);
        var dbUser = repository.findById(id);
        if(!dbUser.isEmpty())
            return ResponseEntity.internalServerError().build();
        return ResponseEntity.noContent().build();
    }
}
