package dao;

import model.Role;

/**
 * Created by igor on 20.11.16.
 */
public interface RoleDao {
    Role get(String id);
    String create (Role role);
}
