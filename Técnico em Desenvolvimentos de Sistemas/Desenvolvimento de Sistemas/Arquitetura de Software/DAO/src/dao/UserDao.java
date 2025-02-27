package dao;

import java.util.List;

import model.User;

public interface UserDao {
    void saveUser(User user);

    void updateUser(int id, String newName);

    void deleteUser(int id);

    User findUserById(int id);

    List<User> findAllUsers();
}
