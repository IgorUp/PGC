package service.impl;

import dao.ClientDao;
import dao.RoleDao;
import model.Client;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ClientService;

import java.util.List;

/**
 * Created by igor on 5.12.16.
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public Client get(Long id) {
        return clientDao.get(id);
    }

    @Transactional
    @Override
    public Long create(Client client) {
        if (client.getRole() != null) {
            Role role = roleDao.get(client.getRole().getId());
            client.setRole(role);
        }
        return clientDao.create(client);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Transactional
    @Override
    public void update(Client client) {
        if (client.getRole() != null) {
            Role role = roleDao.get(client.getRole().getId());
            client.setRole(role);
        }
        clientDao.update(client);
    }

    @Transactional
    @Override
    public List<Client> list() {
        return clientDao.findAll();
    }
}
