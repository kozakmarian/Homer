package sk.upjs.paz1c.homer;

public abstract class Module {
    protected String name;
    protected String prefix;
    protected String version;
    protected Integer status;
    
    public abstract boolean install();
    public abstract boolean uninstall();
    public abstract boolean activate();
    public abstract boolean deactivate();
    public abstract boolean check();
}
