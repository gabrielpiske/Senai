package dao;

import java.util.List;

import model.User;

public interface UserDao {
    void save(User user);

    void update(int id, String newName);

    void delete(int id);

    User findById(int id);

    List<User> findAll();
}
