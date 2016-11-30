package service;

import model.Transport;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
public interface TransportService {
    Transport get(Long id);
    Long create(Transport transport);
    void delete(Transport transport);
    void update(Transport transport);
    List<Transport> list();
}
