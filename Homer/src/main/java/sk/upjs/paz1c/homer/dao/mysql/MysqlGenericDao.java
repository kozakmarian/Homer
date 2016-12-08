package sk.upjs.paz1c.homer.dao.mysql;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.paz1c.homer.dao.GenericDao;
import sk.upjs.paz1c.homer.entity.Entity;

/**
 * Have it came to you as if all the DAOs looked the same? Well, it's because
 * they do. The only differences are in fields on which they operate. Generic 
 * DAO class was designed to serve as a base of all basic CRUD operations on 
 * MySQL database. This "One DAO to rule them all!" approach was taken to maximize
 * code reuse and improve maintainability of the project's persistent layer.
 * Additionally {@link sk.upjs.paz1c.homer.ObjectFactory} makes a good use of
 * this generalization.
 * 
 * @author dyske
 * @param <T>   Entity to operate with
 */
public abstract class MysqlGenericDao<T extends Entity> implements GenericDao<T>{
    
    /**
     *  Name of a table containing the entities, as represented in database.
     */
    protected String tableName;

    /**
     * Store Map is conceptually a complement to {@link RowMapper}. It contains
     * names of columns and values of the Entity's state. It is used for updates
     * and inserts alike. When storeMap is null a {@link NullPointerException}
     * is thrown. Be cautious as it will *not* check whether the fields in map
     * correlate with columns in table.
     */
    protected Map<String, Object> storeMap;
    
    /**
     * Yeah. We're using Spring JDBC. It is passed to DAO upon instantiation.
     */
    protected JdbcTemplate jdbcTemplate;

    /**
     * This one is used for {@link MysqlGenericDao#store(sk.upjs.paz1c.homer.entity.Entity) }
     * in conjuction with {@link MysqlGenericDao#storeMap}.
     */
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Row mapper is required to convert results returned by database driver
     * into meaningful Entities to be used by the application. It is passed
     * to superclass constructor, upon creation of subclass.
     */
    protected RowMapper<T> rowMapper;
    
    /**
     * Can this constructor get any more generic?
     * 
     * @param jdbcTemplate  Usually created by {@link sk.upjs.paz1c.homer.ObjectFactory}
     * @param rowMapper     Entity-specific mapper passed by subclass in its
     *                      constructor
     * @param tableName     Name of table containing given entities
     */
    public MysqlGenericDao(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, String tableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
        this.rowMapper = rowMapper;
        this.tableName = tableName;
    }
    
    private void performMemberChecks() {
        if (tableName == null) throw new NullPointerException("Field 'tableName' cannot be null");
        if (rowMapper == null) throw new NullPointerException("Field 'rowMapper' cannot be null");
    }
    
    /**
     * {@inheritDoc}
     * @param <T>
     * @param entity
     */
    @Override
    public <T extends Entity> void delete(T entity) {
        this.performMemberChecks();
        jdbcTemplate.update("DELETE FROM " + tableName + " WHERE id = ?", entity.getId());
    }

    /**
     * {@inheritDoc}
     * @param id
     * @return
     */
    @Override
    public T find(Long id) {
        this.performMemberChecks();
        Object[] params = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM " + tableName + " WHERE id = ?", params, rowMapper);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<T> list() {
        this.performMemberChecks();
        return jdbcTemplate.query("SELECT * FROM " + tableName, rowMapper);
    }

    /**
     * {@inheritDoc}
     * @param entity
     */
    @Override
    public void store(T entity) {
        this.performMemberChecks();
        if (entity.getId() != 0) {
            String fields = storeMap.keySet()
                    .stream()
                    .map(s -> s + " = :" + s)
                    .collect(Collectors.joining(", "));
            namedParameterJdbcTemplate.update("UPDATE " + tableName + " SET " + fields +
                        " WHERE id = " + entity.getId(),
                    storeMap
            );
        } else {
            String fields = storeMap.keySet()
                    .stream()
                    .map(s -> ":" + s)
                    .collect(Collectors.joining(", "));
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO " + tableName + " VALUES(" + fields + ")",
                    new MapSqlParameterSource(storeMap),
                    keyHolder
            );
            Long id = keyHolder.getKey().longValue();
            entity.setId(id);
        }
    }
}
