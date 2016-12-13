package sk.upjs.paz1c.homer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class RecipeRowMapper implements RowMapper<Recipe> {

    /**
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Recipe mapRow(ResultSet rs, int i) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(rs.getLong("id"));
        recipe.setName(rs.getString("name"));
        recipe.setPreparation(rs.getInt("preparation"));
        recipe.setCooking(rs.getInt("cooking"));
        recipe.setPortions(rs.getInt("portions"));
        recipe.setImage(rs.getString("image"));
        recipe.setInstructions(rs.getString("instructions"));
        recipe.setUrl(rs.getString("url"));
        recipe.setStatus(Status.fromInt(rs.getInt("status")));

        return recipe;
    }
}
