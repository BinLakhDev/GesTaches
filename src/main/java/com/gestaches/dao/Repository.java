package com.gestaches.dao;
import java.util.List;

public interface Repository <T>{
    public int add(T t);
    public int delete(int id,T t);
    public int update(T t);
    public List<T> getAll(T t);
    public T findById(int id,T t);

}
