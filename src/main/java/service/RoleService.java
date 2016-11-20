package service;

import model.Role;

import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
public interface RoleService {
    Role get(String id);
    String create(Role role);
    void delete(Role role);
    void update(Role role);
    List<Role> list();
}
