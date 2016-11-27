package service;

import model.User;

import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
public interface UserService {
    User get(Long id);
    Long create(User user);
    void delete(User user);
    void update(User user);
    List<User> list();
    User getByName(String name);
}
