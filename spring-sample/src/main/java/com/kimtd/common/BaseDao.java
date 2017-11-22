package com.kimtd.common;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends BaseEntity<ID>, ID extends Serializable> {

    void persist(T entity);

    void refresh(T entity);

    void remove(T entity);

    boolean isManaged(T entity);

    T merge(T entity);

    T find(ID id);

    List<T> findList();


}
