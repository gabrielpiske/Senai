package controller;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserController {
    private UserDao userDao;

    public UserController() {
        this.userDao = new UserDaoImpl();
    }

    public void addUser(String name) {
        userDao.save(new User(name));
    }

    public void updateUser(int id, String newName) {
        userDao.update(id, newName);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public User getUserById(int id) {
        return userDao.findById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}