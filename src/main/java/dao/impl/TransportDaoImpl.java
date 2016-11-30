package dao.impl;

import dao.TransportDao;
import model.Transport;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 27.11.16.
 */
@Repository
public class TransportDaoImpl extends GenericDaoImpl<Transport, Long> implements TransportDao {

    public TransportDaoImpl() {
        super(Transport.class);
    }
}
