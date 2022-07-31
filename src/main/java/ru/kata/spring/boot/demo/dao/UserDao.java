package ru.kata.spring.boot.demo.dao;

import ru.kata.spring.boot.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    void save(User user);

    User findById(int id);

    void update(User updatedUser);

    void delete (User id);
}
