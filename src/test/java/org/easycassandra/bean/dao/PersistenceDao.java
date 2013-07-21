package org.easycassandra.bean.dao;

import java.util.List;

import org.easycassandra.persistence.cassandra.EasyCassandraManager;
import org.easycassandra.persistence.cassandra.PersistenceCassandra;

public class PersistenceDao<T,K> {

    private static final String KEY_SPACE = "javabahia";
    private static final String HOST = "localhost";
    private PersistenceCassandra persistence;
    private Class<T> baseClass;
    

    public PersistenceDao(Class<T> baseClass) {
        this.baseClass = baseClass;
        persistence = EasyCassandraManager.INSTANCE.getPersistence(HOST, KEY_SPACE);
        EasyCassandraManager.INSTANCE.addFamilyObject(baseClass, KEY_SPACE);
        
    }

    public boolean insert(T bean) {
        return persistence.insert(bean);
    }

    public boolean remove(T bean) {
        return persistence.delete(bean);
    }

    public boolean removeFromRowKey(K rowKey) {
        return persistence.deleteByKey(rowKey, baseClass);
    }

    public boolean update(T bean) {
        return persistence.update(bean);
    }

    public T retrieve(Object id) {
    	
        return   persistence.findByKey(id, baseClass);
    }

    public List<T> listAll() {
        return persistence.findAll(baseClass);
    }

    public List<T> listByIndex(Object index) {
        return persistence.findByIndex(index, baseClass);
    }

    public Long count() {
        return persistence.count(baseClass);
    }

    public boolean executeUpdateCql(String string) {
        return persistence.executeUpdate(string);
    }

}
