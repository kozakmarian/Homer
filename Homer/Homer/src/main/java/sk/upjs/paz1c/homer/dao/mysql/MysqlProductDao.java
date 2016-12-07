package sk.upjs.paz1c.homer.dao.mysql;

import java.util.HashMap;
import sk.upjs.paz1c.homer.mapper.ProductRowMapper;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.entity.Product;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class MysqlProductDao extends MysqlGenericDao<Product> implements ProductDao {

    /**
     * @see MysqlGenericDao#tableName
     */
    protected String tableName = "products";

    /**
     * @see MysqlGenericDao#storeMap
     */
    protected Map<String, Object> storeMap = new HashMap<>();

    /**
     * @see MysqlGenericDao#this
     * @param jdbcTemplate
     */
    public MysqlProductDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ProductRowMapper());
    }
    
    /**
     * {@inheritDoc}
     * @param name
     * @return
     */
    public List<Product> find(String name) {
        return jdbcTemplate.query("SELECT * FROM " + tableName + " WHERE name = " + name, rowMapper);
    }

    /**
     * {@inheritDoc}
     * @param product
     */
    @Override
    public void store(Product product) {
        storeMap.put("id", product.getId());
        storeMap.put("name", product.getName());
        storeMap.put("image", product.getImage());
        storeMap.put("status", product.getStatus());
        super.store(product);
    }

    /**
     * {@inheritDoc}
     * @param recipe
     * @return
     */
    @Override
    public List<Product> find(Recipe recipe) {
        throw new UnsupportedOperationException("Work in progress");
        // @todo: select through intermediate table
        //return jdbcTemplate.query("SELECT * FROM " + tableName + " WHERE recipe_id = " + recipe.getId(), rowMapper);
    }
}