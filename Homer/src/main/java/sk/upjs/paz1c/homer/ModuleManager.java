package sk.upjs.paz1c.homer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/*
    Trieda zodpovedna za nahravanie instalaciu a aktivaciu modulov
*/
public class ModuleManager {
    
    private static final String MODULES_PATH = "modules";
    private final List<ModuleEntry> availableModules = new ArrayList<>();
    private final List<Module> modules = new ArrayList<>();
    
    public void loadAll() throws NotDirectoryException {
        File moduleDirectory = new File(MODULES_PATH);
        if (!moduleDirectory.isDirectory())
            throw new NotDirectoryException("Given path is not a directory");
        
        for (File module : moduleDirectory.listFiles()) {
            try {
                this.load(module);
            } catch (IOException ex) {
                System.err.println("Module at " + module.getPath() + " could not be loaded");
                ex.printStackTrace();
            }
        }
    }

    private void load(File module) throws IOException {
        JarFile jarFile = new JarFile(module);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + module.getAbsolutePath() + "!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }

            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            Class c = null;
            try {
                c = cl.loadClass(className);
            } catch (ClassNotFoundException ex) {
                System.err.println("Module class " + className + " could not be found - not loading");
                ex.printStackTrace();
                return;
            }
            if (c != null && c.getGenericSuperclass().equals(Module.class)) {
                ModuleEntry me = new ModuleEntry();
                Attributes attributes =  jarFile.getManifest().getMainAttributes();
                me.className = c.getName();
                me.version = attributes.getValue("Specification-Version");
                me.name = attributes.getValue("Specification-Title");
                me.prefix = attributes.getValue("Specification-Vendor");
                this.availableModules.add(me);
                System.out.println("Loading...\n" + me);
                Module m;
                try {
                    m = (Module) c.getConstructor(void.class).newInstance();
                } catch (NoSuchMethodException | IllegalAccessException nsme) {
                    System.err.println("Module " + me.name + " does not implement constructor with required signature - not loading");
                    nsme.printStackTrace();
                    continue;
                } catch (InstantiationException | InvocationTargetException ie) {
                    System.err.println("Module " + me.name + " cannot be instantiated - not loading");
                    ie.printStackTrace();
                    continue;
                }
                if (m == null) {
                    System.err.println("Module " + me.name + " could not be loaded");
                    continue;
                }
                
                if (!m.check())
                    if (m.install())
                        this.modules.add(m);
                    else System.err.println("Module " + m.name + " failed to install");
            }
        }
    }
    
    private class ModuleEntry {
        String name;
        String className;
        String version;
        String prefix;
        boolean installed;
        boolean active;

        @Override
        public String toString() {
            return "Module:\n\t" + name + " " + version + "\n\t from: " + className + " on " + prefix; 
        }
    }
}
