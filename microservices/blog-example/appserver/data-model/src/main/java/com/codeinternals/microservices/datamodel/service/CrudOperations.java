package com.codeinternals.microservices.datamodel.service;

import java.util.List;

public interface CrudOperations<T> {
    T save(T t);
    T get(long id);
    List<T> getAll();
    void delete(long id);
}
