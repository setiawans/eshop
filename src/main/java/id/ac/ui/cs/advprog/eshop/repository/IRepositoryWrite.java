package id.ac.ui.cs.advprog.eshop.repository;

public interface IRepositoryWrite<T> {
    T create(T item);
    T update(String id, T item);
    void delete(String id);
}
