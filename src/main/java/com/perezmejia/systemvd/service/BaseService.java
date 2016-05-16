package com.perezmejia.systemvd.service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */
public interface BaseService<T> {
    public List<T> findAll();
    public T findById(Long id);
    public void save(T t);
    public void delete(Long id);
}
