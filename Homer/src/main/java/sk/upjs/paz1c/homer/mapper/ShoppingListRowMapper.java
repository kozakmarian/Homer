package sk.upjs.paz1c.homer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author dyske
 */
public class ShoppingListRowMapper implements RowMapper<ShoppingList> {

    /**
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public ShoppingList mapRow(ResultSet rs, int i) throws SQLException {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setId(rs.getLong("id"));
        shoppingList.setName(rs.getString("name"));
        shoppingList.setExpiry(rs.getDate("expiry"));
        shoppingList.setStatus(rs.getInt("status"));
        return shoppingList;
    }
}
