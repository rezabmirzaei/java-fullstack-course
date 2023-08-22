package no.accelerate.postgrads.services;

import java.util.Collection;

/**
 * Generic service to act as a parent to all domain-specific services.
 * It encapsulates basic CRUD functionality to be reused.
 * It follows the same structure as JPA Repositories to ease integration.
 * 
 * @param <T>  Type of domain class of the service.
 * @param <ID> Primary key type for entity.
 */
public interface CrudService<T, ID> {

    T findById(ID id);

    Collection<T> findAll();

    T add(T entity);

    T update(T entity);

    void deleteById(ID id);

    boolean exists(ID id);

}
