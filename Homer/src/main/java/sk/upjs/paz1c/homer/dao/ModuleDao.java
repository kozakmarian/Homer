package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.Module;
/**
 *
 * @author dyske
 */
public interface ModuleDao {
    public List<Module>         list();
    public Module               find(Long id);
    public void                 store(Module module);
    public void                 delete(Module module);
}
