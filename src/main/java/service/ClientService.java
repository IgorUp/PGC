package service;


import model.Client;

import java.util.List;

/**
 * Created by igor on 5.12.16.
 */
public interface ClientService {

    Client get(Long id);
    Long create(Client client);
    void delete(Client client);
    void update(Client client);
    List<Client> list();
}
