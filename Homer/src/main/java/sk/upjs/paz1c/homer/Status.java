package sk.upjs.paz1c.homer;

/**
 * Status is an enumeration containing numerical statuses used across
 * the application. They serve primarily for logging and notifications.
 * 
 * @author dyske
 */
public enum Status {

    /**
     * Entity is in invalid state i.e. something went wrong and we have no idea
     * about the cause of the problem. This is also a default status value. So
     * there may be an issue with value initialization.
     * 
     * @see sk.upjs.paz1c.homer.entity.StorableEntity
     */
    INVALID(-1),

    /**
     * Everything is as it is supposed to be. Nothing special here.
     */
    NORMAL(0),

    /**
     * Used in {@link sk.upjs.paz1c.homer.dao.mysql.MysqlShoppingListDao} to
     * indicate, that all of the items on the list were purchased and/or are
     * available in storage.
     */
    DONE(3);
    
    private Integer value;
    
    private Status(Integer value) {
        this.value = value;
    } 
}
