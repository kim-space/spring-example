package com.kimtd.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;


public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T,ID>{

    @Autowired
    private BaseDao<T,ID> baseDao;

    @Override
    @Transactional(readOnly = true)
    public T find(ID id) {
        return baseDao.find(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findList() {
        return baseDao.findList();
    }

    @Override
    @Transactional
    public T save(T entity) {
        Assert.notNull(entity);
        Assert.isTrue(entity.isNew());
        baseDao.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(ID id) {
        delete(baseDao.find(id));
    }

    @Override
    @Transactional
    public void delete(T entity) {
        if (entity != null) {
            baseDao.remove(baseDao.isManaged(entity) ? entity : baseDao.merge(entity));
        }
    }

    @Override
    public T update(T entity) {
        return baseDao.merge(entity);
    }
}
