package service;

import model.TypeTransport;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
public interface TypeTransportService {
    TypeTransport get(Long id);
    Long create(TypeTransport typeTransport);
    void delete(TypeTransport typeTransport);
    void update(TypeTransport typeTransport);
    List<TypeTransport> list();
}
