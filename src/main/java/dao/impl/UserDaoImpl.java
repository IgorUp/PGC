package dao.impl;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 20.11.16.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByName(String name) {
        return null;
    }
}
