package sk.upjs.paz1c.homer;

import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.upjs.paz1c.homer.dao.mysql.MysqlGenericDao;
import sk.upjs.paz1c.homer.entity.Entity;

public enum ObjectFactory {

    INSTANCE;
    
    private final Map<String, MysqlGenericDao> cache = new HashMap<>();
    
    private JdbcTemplate jdbcTemplate;

    /**
     * Rýchle objasnenie tejto metódy:
     * Určite vštci začnú namietať, že java reflection je zlá. A majú pravdu.
     * No reflection je len nástroj, ktorý pri nesprávnom použití narobí škody
     * tým, že úplne ignoruje compile-time type checking a tak sa vysmieva
     * pevnému typovaniu v jave. No aj napriek tomu reflekcia je používaná
     * v dosť veľkej miere (Spring, JAXP, Hibernate,...). V tejto metóde si
     * ju môžem dovoliť použiť, pretože:
     *      1. entity nemôže byť null (lebo null nerozširuje Entity)
     *      2. Metóda vždy vráti triedu rozširujúcu MysqlGenericDao nakoľko
     *         DAO triedy už počas behu existujú a sú pevne viazané na entity (1.)
     * 
     * @param <T>
     * @param entity
     * @return
     */
    public <T extends MysqlGenericDao> T getDao(Class<? extends Entity> entity){
        String key = entity.getSimpleName();
        if (!cache.containsKey(key)) {
            try {
                Class<?> dao = Class.forName("sk.upjs.paz1c.homer.dao.mysql.Mysql" + key + "Dao");
                cache.put(key, (MysqlGenericDao) dao.getDeclaredConstructor(
                        JdbcTemplate.class).newInstance(getJdbcTemplate()));
            } catch (
                    // Java reflection aneb 2 riadky = 5 výnimiek
                    InstantiationException | 
                    NoSuchMethodException |
                    InvocationTargetException |
                    ClassNotFoundException |
                    IllegalAccessException ex
            ) {
                Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (T) cache.get(key);
    }

    public JdbcTemplate getJdbcTemplate() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://cfftw.ddns.net/homer");
        dataSource.setUser("homer");
        dataSource.setPort(3306);
        dataSource.setPassword("plate-watch-window");
        jdbcTemplate = new JdbcTemplate(dataSource);
        return this.jdbcTemplate;
    }

}
