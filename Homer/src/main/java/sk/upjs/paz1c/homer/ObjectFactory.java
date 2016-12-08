package sk.upjs.paz1c.homer;

import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlDataSource;
import sk.upjs.paz1c.homer.dao.*;
import sk.upjs.paz1c.homer.dao.mysql.MysqlItemDao;
import sk.upjs.paz1c.homer.dao.mysql.MysqlProductDao;
import sk.upjs.paz1c.homer.dao.mysql.MysqlRecipeDao;
import sk.upjs.paz1c.homer.dao.mysql.MysqlShoppingListDao;

public enum ObjectFactory {

    INSTANCE;

    private ProductDao commodityDao;
    private ItemDao itemDao;
    private ModuleDao moduleDao;
    private RecipeDao recipeDao;
    private ShoppingListDao shoppingListDao;

    private JdbcTemplate jdbcTemplate;

    public ProductDao getProductDao() {
        if (this.commodityDao == null) {
            this.commodityDao = new MysqlProductDao(jdbcTemplate);

        }

        return this.commodityDao;
    }

    public ItemDao getItemDao() {
        if (this.itemDao == null) {
            this.itemDao = new MysqlItemDao(jdbcTemplate);
        }
        return this.itemDao;
    }

    public RecipeDao getRecipeDao() {
        if (this.recipeDao == null) {
            this.recipeDao = new MysqlRecipeDao(jdbcTemplate);
        }
        return this.recipeDao;
    }

    public ShoppingListDao getShoppingListDao() {
        if (this.shoppingListDao == null) {
            this.shoppingListDao = new MysqlShoppingListDao(jdbcTemplate);
        }
        return this.shoppingListDao;
    }

    public JdbcTemplate getJdbcTemplate() {
        //to do
        MysqlDataSource dataSource = new MysqlDataSource() {
        };
        //dataSource.setUrl("cffw.ddns.net");
        dataSource.setUser("homer");
        dataSource.setPassword("plate-watch-window");
        jdbcTemplate = new JdbcTemplate(dataSource);
        return this.jdbcTemplate;
    }

}
