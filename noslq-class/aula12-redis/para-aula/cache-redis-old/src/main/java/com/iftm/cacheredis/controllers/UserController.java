package com.iftm.cacheredis.controllers;

import com.iftm.cacheredis.models.User;
import com.iftm.cacheredis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id)  {
        return service.delete(id);
    }
}
