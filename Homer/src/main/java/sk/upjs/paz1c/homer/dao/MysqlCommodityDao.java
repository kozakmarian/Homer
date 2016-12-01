package sk.upjs.paz1c.homer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.paz1c.homer.Product;
import sk.upjs.paz1c.homer.Recipe;

/**
 *
 * @author dyske
 */
public class MysqlCommodityDao implements CommodityDao {
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ProductRowMapper commodityRowMapper = new ProductRowMapper();

    public MysqlCommodityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }
    
    @Override
    public void delete(Product commodity) {
        jdbcTemplate.update("DELETE FROM commodities WHERE id = ?", commodity.getId());
    }

    @Override
    public Product find(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM commodities WHERE id = ?", commodityRowMapper, id);
    }

    @Override
    public List<Product> find(String name) {
        return jdbcTemplate.query("SELECT * FROM commodities WHERE name = ?", commodityRowMapper, name);
    }

    @Override
    public List<Product> find(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> list() {
        return jdbcTemplate.query("SELECT * FROM commodities;", commodityRowMapper);
    }

    @Override
    public void store(Product commodity) {
        throw new UnsupportedOperationException("Not supported yet.");
        /* // WORK IN PROGRESS
        Map<String, Object> storeMap = new HashMap();
        storeMap.put("name", commodity.getName());
        storeMap.put("ean", commodity.getEan());
        storeMap.put("date", commodity.getDate());
        storeMap.put("status", commodity.getStatus());
        storeMap.put("amount", commodity.getAmount());
        storeMap.put("unit", commodity.getUnit());
            
        if (commodity.getId() != null) {
            storeMap.put("id", commodity.getId());
            namedParameterJdbcTemplate.update(
                    "UPDATE commodities SET "
                            + "name = :name, "
                            + "ean = :ean, "
                            + "date = :date, "
                            + "status = :status, "
                            + "amount = :amount, "
                            + "unit = :unit "
                            + "WHERE id = :id",
                    storeMap);
        } else {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO commodities VALUES("
                    + "" // @ TODO finish this
                    + ")",
                    new MapSqlParameterSource(storeMap), keyHolder);
        }
        */
    }
    
}
