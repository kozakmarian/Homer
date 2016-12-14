package sk.upjs.paz1c.homer.dao.mysql;

import sk.upjs.paz1c.homer.mapper.ItemRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author dyske
 */
public class MysqlItemDao extends MysqlGenericDao<Item> implements ItemDao {

    /**
     * @see MysqlGenericDao#tableName
     */
    public static final String TABLE_NAME = "items";
 
    /**
     * @see MysqlGenericDao
     * @param jdbcTemplate
     */
    public MysqlItemDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ItemRowMapper(), TABLE_NAME);
    }

    @Override
    public List<Item> findAll(Recipe recipe) {
        Object[] params = {recipe.getId()};
        return jdbcTemplate.query(
                "SELECT i.*, p.name FROM " + TABLE_NAME + " AS i LEFT JOIN "
                + MysqlProductDao.TABLE_NAME + " AS p ON i.product_id = p.id WHERE i.recipe_id = ?;", params, rowMapper);
    }

    /**
     * {@inheritDoc}
     * @param name
     */
    @Override
    public List<Item> findAllByProductName(String name) {
        Object[] params = {name};
        return jdbcTemplate.query(
                "SELECT i.*, p.name FROM " + TABLE_NAME + " AS i LEFT JOIN "
                + MysqlProductDao.TABLE_NAME + " AS p ON i.product_id = p.id WHERE p.name = ?;", params, rowMapper);
    }

    /**
     * {@inheritDoc}
     * @param item
     */
    @Override
    public void store(Item item) {
        storeMap.put("id", item.getId());
        storeMap.put("list_id", item.getListId());
        storeMap.put("product_id", item.getProductId());
        storeMap.put("recipe_id", item.getRecipeId());
        storeMap.put("amount", item.getAmount());
        storeMap.put("unit", item.getUnit());
        storeMap.put("status", item.getStatus().toInt());
        super.store(item);
    }

    /**
     * {@inheritDoc}
     * @param item
     */
    @Override
    public void done(Item item) {
        jdbcTemplate.update("UPDATE " + TABLE_NAME + " SET status = ? WHERE id = ?", Status.DONE, item.getId());
    }

    /**
     * {@inheritDoc}
     * @param shoppingList
     * @return
     */
    @Override
    public List<Item> findAll(ShoppingList shoppingList) {
        Object[] params = {shoppingList.getId()};
        return jdbcTemplate.query("SELECT i.*, p.name FROM " + TABLE_NAME + " AS i LEFT JOIN "
                + MysqlProductDao.TABLE_NAME + " AS p ON i.product_id = p.id WHERE i.list_id = ?;", params, rowMapper);
    }
    
}
