package sk.upjs.paz1c.homer.entity;

/**
 * A logical/data representation of a Module. Nothing interesting here. Oh, and
 * those "action" methods at the end will be changed into annotations, someday.
 * 
 * @author dyske
 */
public abstract class Module extends Entity {

    /**
     * A name of a module. Displayed to an end-user.
     */
    protected String name;

    /**
     * Database table prefix, or in case of NoSQL db a name of an index 
     */
    protected String prefix;

    /**
     * If the module will be updated
     */
    protected String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * Method called during installation of a module
     * 
     * @return boolean success/fail
     */
    public abstract boolean install();

    /**
     * Method called during removal of a module
     * 
     * @return boolean success/fail
     */
    public abstract boolean uninstall();

    /**
     * Method called to activate module
     * 
     * @return boolean success/fail
     */
    public abstract boolean activate();

    /**
     * Method called to deactivate module
     * 
     * @return boolean success/fail
     */
    public abstract boolean deactivate();

    /**
     * Method called to check if a module is installed
     * 
     * @return  boolean true if installed
     */
    public abstract boolean check();
}
