package sk.upjs.paz1c.homer.dao.mysql;

import java.util.HashMap;
import sk.upjs.paz1c.homer.mapper.ShoppingListRowMapper;
import java.util.List;
import java.util.Map;
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
    protected String tableName = "shoppingLists";

    /**
     * @see MysqlGenericDao#storeMap
     */
    protected Map<String, Object> storeMap = new HashMap<>();
    
    /**
     * @see MysqlGenericDao#this
     * @param jdbcTemplate
     */
    public MysqlShoppingListDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ShoppingListRowMapper());
    }

    /**
     * {@inheritDoc}
     * @param shoppingList
     */
    @Override
    public void store(ShoppingList shoppingList) {
        storeMap.put("id", shoppingList.getId());
        storeMap.put("name", shoppingList.getName());
        storeMap.put("date_created", shoppingList.getDateCreated());
        storeMap.put("status", shoppingList.getStatus());
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
        return jdbcTemplate.query("SELECT * FROM " + tableName + " WHERE item_id = ?", params, rowMapper);
    }
    
}
