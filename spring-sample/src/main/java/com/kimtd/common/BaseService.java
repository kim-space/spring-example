package com.kimtd.common;

import java.io.Serializable;
import java.util.List;


public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T entity);

    T update(T entity);

    void delete(ID id);

    void delete(T entity);

    T find(ID id);

    List<T> findList();
}
