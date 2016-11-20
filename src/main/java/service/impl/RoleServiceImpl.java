package service.impl;

import dao.RoleDao;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RoleService;

/**
 * Created by igor on 20.11.16.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Role get(String id) {
        return roleDao.get(id);
    }

    @Transactional
    public String create(Role role) {
        return roleDao.create(role);
    }
}
