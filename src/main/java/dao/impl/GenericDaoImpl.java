package dao.impl;

import dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by Evgeny.Zemchenok@sibel.by on 11.04.2016.
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public GenericDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public GenericDaoImpl(Class<T> persistentClass, SessionFactory sessionFactory) {
        this(persistentClass);
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public ID create(Object entity) {
        return (ID) sessionFactory.getCurrentSession().save(entity);
    }

    public void update(Object entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Object entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void createOrUpdate(Object entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public T get(ID id) {
        return (T) sessionFactory.getCurrentSession().get(persistentClass, id);
    }
}
