package ru.kata.spring.boot.demo.service;

import ru.kata.spring.boot.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    void save(User user);

    User findById(int id);

    void update(User updatedUser);

    void delete (int id);


}
