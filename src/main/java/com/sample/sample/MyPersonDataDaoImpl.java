package com.sample.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MyPersonDataDaoImpl<MyPersonData> implements MyPersonDataDao<MyPersonData> {
    private EntityManager manager;

    MyPersonDataDaoImpl(EntityManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public List<MyPersonData> getAllEntity() {
        Query query = manager.createQuery("from MyPersonData");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<MyPersonData> findByField(String field, String find) {
        Query query = manager.createQuery("from MyPersonData where " + field + " = '" +  find + "'");
        return query.getResultList();
    }

    @Override
    public void addEntity(MyPersonData entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(entity);
        manager.flush();
        transaction.commit();
    }

    @Override
    public void updateEntity(MyPersonData entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(entity);
        manager.flush();
        transaction.commit();
    }

    @Override
    public void removeEntity(MyPersonData data) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(data);
        manager.flush();
        transaction.commit();
    }

    @Override
    public void removeEntity(Long id) {
        MyPersonData entity = (MyPersonData) manager.find(com.sample.sample.MyPersonData.class, id);
        removeEntity(entity);
    }
}
