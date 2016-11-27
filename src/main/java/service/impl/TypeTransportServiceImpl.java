package service.impl;

import dao.TypeTransportDao;
import model.TypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TypeTransportService;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Service
public class TypeTransportServiceImpl implements TypeTransportService {

    @Autowired
    private TypeTransportDao typeTransportDao;

    @Transactional
    @Override
    public TypeTransport get(Long id) {
        return typeTransportDao.get(id);
    }

    @Transactional
    @Override
    public Long create(TypeTransport typeTransport) {
        return typeTransportDao.create(typeTransport);
    }

    @Transactional
    @Override
    public void delete(TypeTransport typeTransport) {
        typeTransportDao.delete(typeTransport);
    }

    @Transactional
    @Override
    public void update(TypeTransport typeTransport) {
        typeTransportDao.update(typeTransport);
    }

    @Transactional
    @Override
    public List<TypeTransport> list() {
        return typeTransportDao.findAll();
    }
}
