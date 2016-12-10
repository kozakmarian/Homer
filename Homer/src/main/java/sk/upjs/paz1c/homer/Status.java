package sk.upjs.paz1c.homer;

import java.util.EnumSet;

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
    
    private final Integer value;
    
    private Status(Integer value) {
        this.value = value;
    }
    
    /**
     * Creates {@link Status} from given integer if such a {@link Status} exists
     * 
     * @param i     Integer value of Status
     * @return      Corresponding status
     */
    public static Status fromInt(int i) {
        return EnumSet.allOf(Status.class)
                      .stream()
                      .filter(s -> s.value == i)
                      .findFirst().get();
    }
    
    /**
     * Returns integer value of a {@link Status}.
     * @return  Integer value, never null
     */
    public Integer toInt() {
        return this.value;
    }
}
