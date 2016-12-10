package dao.impl;

import dao.ClientDao;
import dao.GenericDao;
import model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by igor on 5.12.16.
 */
@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {

    public ClientDaoImpl() {
        super(Client.class);
    }
}
