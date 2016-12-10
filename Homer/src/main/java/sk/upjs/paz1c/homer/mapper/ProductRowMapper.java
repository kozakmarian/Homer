package sk.upjs.paz1c.homer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.entity.Product;

/**
 *
 * @author dyske
 */
public class ProductRowMapper implements RowMapper<Product>{

    /**
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        Product p = new Product();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("name"));
        p.setStatus(Status.fromInt(rs.getInt("status")));
        p.setImage(rs.getString("image"));
        return p;
    }
    
}
