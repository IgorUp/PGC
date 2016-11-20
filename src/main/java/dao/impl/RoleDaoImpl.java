package dao.impl;

import dao.RoleDao;
import model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 20.11.16.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role get(String id) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public String create(Role role) {
        return (String) sessionFactory.getCurrentSession().save(role);
    }
}
