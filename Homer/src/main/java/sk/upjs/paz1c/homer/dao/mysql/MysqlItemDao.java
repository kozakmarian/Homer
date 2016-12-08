package sk.upjs.paz1c.homer.dao.mysql;

import java.util.HashMap;
import sk.upjs.paz1c.homer.mapper.ItemRowMapper;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.entity.Item;
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
     * @see MysqlGenericDao#storeMap
     */
    public static final Map<String, Object> STORE_MAP = new HashMap<>();
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ItemRowMapper itemRowMapper = new ItemRowMapper();

   
    
    /**
     * @see MysqlGenericDao
     * @param jdbcTemplate
     */
    public MysqlItemDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ItemRowMapper(), TABLE_NAME);
    }

    /**
     * {@inheritDoc}
     * @param item
     */
    @Override
    public void store(Item item) {
        STORE_MAP.put("id", item.getId());
        STORE_MAP.put("list_id", item.getList_id());
        STORE_MAP.put("product_id", item.getProductId());
        STORE_MAP.put("amount", item.getAmount());
        STORE_MAP.put("unit", item.getUnit());
        STORE_MAP.put("status", item.getStatus());
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
