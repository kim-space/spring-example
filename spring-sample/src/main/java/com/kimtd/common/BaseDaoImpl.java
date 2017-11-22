package com.kimtd.common;

import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;


public abstract class BaseDaoImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseDao<T, ID> {

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        ResolvableType resolvableType = ResolvableType.forType(getClass());
        entityClass = (Class<T>) resolvableType.getSuperType().getGeneric().resolve();
    }

    @Override
    public T find(ID id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(entityClass, id);
    }

    @Override
    public void persist(T entity) {
        Assert.notNull(entity);

        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public boolean isManaged(T entity) {
        Assert.notNull(entity);

        return entityManager.contains(entity);
    }

    @Override
    public void refresh(T entity) {
        if (entity != null) {
            entityManager.refresh(entity);
        }
    }

    @Override
    public T merge(T entity) {
        Assert.notNull(entity);

        return entityManager.merge(entity);
    }

    @Override
    public List<T> findList() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
        query.select(query.from(entityClass));
        return entityManager.createQuery(query).getResultList();
    }
}
