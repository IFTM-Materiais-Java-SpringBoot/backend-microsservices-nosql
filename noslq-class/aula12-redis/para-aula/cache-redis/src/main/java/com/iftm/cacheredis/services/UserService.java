package com.iftm.cacheredis.services;

import com.iftm.cacheredis.models.User;
import com.iftm.cacheredis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        var users = repository.findAll();
        System.out.println("Resposta sem cache...");
        return users;
    }

    public User findById(String id) {
        System.out.println("Resposta sem cache...");
        return repository.findById(id).get();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(User user) {

        var dbUser = repository.findById(user.getId());
        var curUser = dbUser.get();
        curUser.setName(user.getName());
        curUser.setAge(user.getAge());
        curUser.setEmail(user.getEmail());
        return repository.save(curUser);
    }

    public User delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).get();
    }
}
