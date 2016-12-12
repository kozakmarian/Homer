package sk.upjs.paz1c.homer.dao.mysql;

import sk.upjs.paz1c.homer.mapper.ProductRowMapper;
import java.util.List;
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
    public static final String TABLE_NAME = "products";

    /**
     * @see MysqlGenericDao#this
     * @param jdbcTemplate
     */
    public MysqlProductDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ProductRowMapper(), TABLE_NAME);
    }
    
    /**
     * {@inheritDoc}
     * @param name
     * @return
     */
    @Override
    public List<Product> find(String name) {
        Object[] params = {name};
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME + " WHERE name = ?", params, rowMapper);
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
        storeMap.put("status", product.getStatus().toInt());
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
