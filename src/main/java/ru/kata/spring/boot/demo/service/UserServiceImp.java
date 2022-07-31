package ru.kata.spring.boot.demo.service;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot.demo.dao.UserDao;
import ru.kata.spring.boot.demo.models.User;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Override
    public void delete(int id) {
        Optional<User> user = Optional.ofNullable ( userDao.findById ( id ) );
        if (user.isPresent()) {
            try {
                userDao.delete(user.get());
            } catch ( PersistenceException e) {
                e.printStackTrace();
            }
        }
    }
}

