package me.syus.ticketservice.repository;

import java.util.List;

public interface CRUDRepository<T, ID> {
    T save(T t);
    List<T> findAll();
    T findById(ID id);
    T update(T t);

}
