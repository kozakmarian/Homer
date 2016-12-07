package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.entity.Entity;

/**
 * GenericDao is base interface for other DAO interfaces. Methods defined in
 * this interface provide common storage-agnostic CRUD functionality.
 * 
 * @author dyske
 * @param <T>   Entity representing single record in storage
 */
public interface GenericDao<T extends Entity> {

    /**
     * Returns list of all available entities. Use with caution.
     * 
     * @return List<T>  List of all records in storage
     */
    List<T>         list();

    /**
     * Performs a search for specific uniquely identifying numeric value and
     * returns corresponding entity assigned to/possessing this value.
     * 
     * @param id    Seriously?
     * @return  T   Entity of a given type if found, null if there is no such
     *              entity exists
     */
    T               find(Long id);

    /**
     * Executes actions required to either save the entity in the storage, or
     * to create a new record on it. If a new record is created, its id is
     * assigned to the corresponding entity in application.
     * 
     * @param entity    An entity of which state has to be preserved in storage
     */
    void            store(final T entity);

    /**
     * Performs actions required to remove an entity from persistent layer.
     * Even though an entity is removed from storage, references to it still
     * may exist during runtime.
     * 
     * @param <T>       Required in order to have access to {@link Entity#getId()}
     * @param entity    Entity of which record has to be removed
     */
    <T extends Entity> void            delete(final T entity);
}
