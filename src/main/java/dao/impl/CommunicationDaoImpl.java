package dao.impl;

import dao.CommunicationDao;
import dao.GenericDao;
import model.Communication;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 14.12.16.
 */
@Service
public class CommunicationDaoImpl extends GenericDaoImpl<Communication, Long> implements CommunicationDao {


    public CommunicationDaoImpl() {
        super(Communication.class);
    }
}
