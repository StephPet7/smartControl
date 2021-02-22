package com.example.backend.Services.ServicesI;

import java.util.List;

public interface DefaultServices<E,T> {

    public E save(E entity);
    public E update(E entity);
    public void delete(T id);
    public E findById(T id);
    public List<E> findAll();


}
