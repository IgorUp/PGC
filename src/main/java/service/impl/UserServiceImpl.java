package service.impl;

import dao.RoleDao;
import dao.UserDao;
import dao.impl.GenericDaoImpl;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RoleService;
import service.UserService;

import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Transactional
    @Override
    public Long create(User user) {
        Role role = roleDao.get(user.getRoleId());
        user.setRole(role);
        return userDao.create(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        Role role = roleDao.get(user.getRoleId());
        user.setRole(role);
        userDao.update(user);
    }

    @Transactional
    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User getByName(String name) {
        return null;
    }
}