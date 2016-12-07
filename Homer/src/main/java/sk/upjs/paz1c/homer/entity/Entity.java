package sk.upjs.paz1c.homer.entity;

/**
 * Base Entity class to be derived from. It has to be a separate class, in order
 * to perform type-checking in DAO superclasses. Other than that, this is an
 * ordinary "data-holding" class. *Check out Kotlin if you want to get rid of em*
 * 
 * @author dyske
 */
public abstract class Entity implements StorableEntity {

    /**
     * Unique numeric identifier, mostly used as primary key in persistent layer
     */
    protected Long id;

    /**
     * @see sk.upjs.paz1c.homer.Status
     */
    protected Integer status;

    /**
     * {@inheritDoc}
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     * @param status
     */
    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }
}
