package sk.upjs.paz1c.homer.dao.mysql;

import sk.upjs.paz1c.homer.mapper.ShoppingListRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.homer.dao.ShoppingListDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author dyske
 */
public class MysqlShoppingListDao extends MysqlGenericDao<ShoppingList> implements ShoppingListDao {

    /**
     * @see MysqlGenericDao#tableName
     */
    public static final String TABLE_NAME = "shoppingLists";

    /**
     * @see MysqlGenericDao#this
     * @param jdbcTemplate
     */
    public MysqlShoppingListDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ShoppingListRowMapper(), TABLE_NAME);
    }

    /**
     * {@inheritDoc}
     * @param shoppingList
     */
    @Override
    public void store(ShoppingList shoppingList) {
        storeMap.put("id", shoppingList.getId());
        storeMap.put("name", shoppingList.getName());
        storeMap.put("expiry", shoppingList.getExpiry());
        storeMap.put("status", shoppingList.getStatus().toInt());
        super.store(shoppingList);
    }

    /**
     * {@inheritDoc}
     * @param item
     * @return
     */
    @Override
    public List<ShoppingList> findAll(Item item) {
        Object[] params = {item.getId()};
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME + " WHERE item_id = ?", params, rowMapper);
    }
    
}
