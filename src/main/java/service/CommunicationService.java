package service;


import model.Communication;

import java.util.List;

/**
 * Created by igor on 14.12.16.
 */
public interface CommunicationService {
    Communication get(Long id);
    Long create(Communication communication);
    void delete(Communication communication);
    void update(Communication communication);
    List<Communication> list();
}
