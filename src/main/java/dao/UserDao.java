package dao;

import model.User;

/**
 * Created by igor on 20.11.16.
 */
public interface UserDao extends GenericDao<User, Long> {

    User getByName(String name);

}
