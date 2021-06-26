package com.valtx.backend.service;

import java.util.List;

public interface CrudService<T> {

    T insert(T t);

    T update(String id, T t);

    T findById(String id);

    List<T> findAll();

    Boolean delete(String id);
}
