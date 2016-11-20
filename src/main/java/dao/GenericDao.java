package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
public interface GenericDao<T, ID extends Serializable> {

    ID create(Object entity);

    void update(Object entity);

    void delete(Object entity);

    void createOrUpdate(Object entity);

    T get(ID id);

    List<T> findAll();
}
