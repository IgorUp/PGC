package service.impl;

import dao.TransportDao;
import dao.TypeTransportDao;
import model.Transport;
import model.TypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TransportService;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportDao transportDao;
    @Autowired
    private TypeTransportDao typeTransportDao;

    @Transactional
    @Override
    public Transport get(Long id) {
        return transportDao.get(id);
    }

    @Transactional
    @Override
    public Long create(Transport transport) {
        TypeTransport typeTransport = typeTransportDao.get(transport.getIdTypeTransport());
        transport.setTypeTransport(typeTransport);
        return transportDao.create(transport);
    }

    @Transactional
    @Override
    public void delete(Transport transport) {
        transportDao.delete(transport);
    }

    @Transactional
    @Override
    public void update(Transport transport) {
        TypeTransport typeTransport = typeTransportDao.get(transport.getIdTypeTransport());
        transport.setTypeTransport(typeTransport);
        transportDao.update(transport);
    }

    @Transactional
    @Override
    public List<Transport> list() {
        return transportDao.findAll();
    }
}
