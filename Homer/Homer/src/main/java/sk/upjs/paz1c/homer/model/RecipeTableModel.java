package sk.upjs.paz1c.homer.model;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.homer.ObjectFactory;

import sk.upjs.paz1c.homer.dao.RecipeDao;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author ntb
 */
public class RecipeTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 4;
    private static final int COLUMN_INDEX_NAME = 0;
    private static final int COLUM_INDEX_CATEGORY = 1;
    private static final int COLUMN_INDEX_PORTIONS = 2;
    private static final int COLUMN_INDEX_STATUS = 3;

    private RecipeDao recipeDao = ObjectFactory.INSTANCE.getRecipeDao();
    private List<Recipe> recipes = new LinkedList<Recipe>();

    @Override
    public int getRowCount() {
        {
            return recipes.size();
        }

    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe recipe = recipes.get(rowIndex);
        switch (columnIndex) {
            case COLUMN_INDEX_NAME:
                return recipe.getName();
            case COLUM_INDEX_CATEGORY:
                return recipe.getCategory();
            case COLUMN_INDEX_PORTIONS:
                return recipe.getPortions();
            case COLUMN_INDEX_STATUS:
                return recipe.getStatus();
        }

        return "???";
    }

    public Recipe getValueAt(int rowIndex) {
        return recipes.get(rowIndex);
    }

    public void remove(int rowIndex) {
        recipeDao.delete(getValueAt(rowIndex));
        refresh();
    }

    public void refresh() {
        recipes.clear();
        recipes.addAll(recipeDao.list());

        fireTableDataChanged();
    }

}
