package service.impl;

import dao.CommunicationDao;
import model.Communication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CommunicationService;

import java.util.List;

/**
 * Created by igor on 14.12.16.
 */
@Service
public class CommunicationServiceImpl implements CommunicationService {

    @Autowired
    private CommunicationDao communicationDao;

    @Transactional
    @Override
    public Communication get(Long id) {
        return communicationDao.get(id);
    }

    @Transactional
    @Override
    public Long create(Communication communication) {
        return communicationDao.create(communication);
    }

    @Transactional
    @Override
    public void delete(Communication communication) {
        communicationDao.delete(communication);
    }

    @Transactional
    @Override
    public void update(Communication communication) {
        communicationDao.update(communication);
    }

    @Transactional
    @Override
    public List<Communication> list() {
        return communicationDao.findAll();
    }
}
