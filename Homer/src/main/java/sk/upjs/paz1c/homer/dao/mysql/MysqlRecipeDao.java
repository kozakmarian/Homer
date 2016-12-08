package sk.upjs.paz1c.homer.dao.mysql;

import java.util.HashMap;
import sk.upjs.paz1c.homer.mapper.RecipeRowMapper;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.homer.dao.RecipeDao;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class MysqlRecipeDao extends MysqlGenericDao<Recipe> implements RecipeDao {

    /**
     * @see MysqlGenericDao#tableName
     */
    public static final String TABLE_NAME = "recipes";

    /**
     * @see MysqlGenericDao#storeMap
     */
    protected Map<String, Object> storeMap = new HashMap<>();
    
    /**
     * @see MysqlGenericDao#this
     * @param jdbcTemplate
     */
    public MysqlRecipeDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new RecipeRowMapper(), TABLE_NAME);
    }

    /**
     * {@inheritDoc}
     * @param recipe
     */
    @Override
    public void store(Recipe recipe) {
        storeMap.put("id", recipe.getId());
        storeMap.put("name", recipe.getName());
        storeMap.put("preparation", recipe.getPreparation());
        storeMap.put("cooking", recipe.getCooking());
        storeMap.put("portions", recipe.getPortions());
        storeMap.put("image", recipe.getImage());
        storeMap.put("instructions", recipe.getInstructions());
        storeMap.put("url", recipe.getUrl());
        storeMap.put("status", recipe.getStatus());
        super.store(recipe);
    }

    /**
     * {@inheritDoc}
     * @param name
     * @return
     */
    @Override
    public List<Recipe> find(String name) {
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME + " WHERE name = " + name, rowMapper);
    }    
}
