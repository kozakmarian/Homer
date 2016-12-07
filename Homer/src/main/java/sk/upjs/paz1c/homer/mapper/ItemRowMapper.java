package sk.upjs.paz1c.homer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.homer.entity.Item;

/**
 *
 * @author dyske
 */
public class ItemRowMapper implements RowMapper<Item> {

    /**
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Item mapRow(ResultSet rs, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
