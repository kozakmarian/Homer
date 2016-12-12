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

    private static final int COLUMN_COUNT = 6;
    private static final int COLUMN_INDEX_NAME = 0;
    private static final int COLUMN_INDEX_CATEGORY = 1;
    private static final int COLUMN_INDEX_PREP = 2;
    private static final int COLUMN_INDEX_COOKING = 3;
    private static final int COLUMN_INDEX_PORTIONS = 4;
    private static final int COLUMN_INDEX_STATUS = 5;
    
    private static final String[] COLUMN_NAMES = {"Názov", "Kategória", "Príprava", "Varenie" , "Počet porcií", "Stav"};

    private RecipeDao recipeDao = ObjectFactory.INSTANCE.getDao(Recipe.class);
    private List<Recipe> recipes = new LinkedList<>();

    @Override
    public int getRowCount() {
            return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe recipe = recipes.get(rowIndex);
        switch (columnIndex) {
            case COLUMN_INDEX_NAME:
                return recipe.getName();
            case COLUMN_INDEX_CATEGORY:
                return recipe.getCategory();
            case COLUMN_INDEX_PORTIONS:
                return recipe.getPortions();
            case COLUMN_INDEX_STATUS:
                return recipe.getStatus();
            case COLUMN_INDEX_PREP:
                return recipe.getPreparation();
            case COLUMN_INDEX_COOKING:
                return recipe.getCooking();
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
    
    public Recipe getRecipeAt(int row){
        return recipes.get(row);
    }
}
