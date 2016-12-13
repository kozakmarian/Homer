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

    public static final int COLUMN_INDEX_IMAGE = 0;
    public static final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_PREP = 2;
    public static final int COLUMN_INDEX_COOKING = 3;
    public static final int COLUMN_INDEX_PORTIONS = 4;
    public static final int COLUMN_INDEX_STATUS = 5;
    public static final int COLUMN_COUNT = 6;
    
    private static final String[] COLUMN_NAMES = {"", "Názov", "Príprava", "Varenie" , "Počet porcií", "Stav"};

    private final RecipeDao recipeDao = ObjectFactory.INSTANCE.getDao(Recipe.class);
    private final List<Recipe> recipes = new LinkedList<>();

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
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe recipe = recipes.get(rowIndex);
        switch (columnIndex) {
            case COLUMN_INDEX_NAME:
                return recipe.getName();
            case COLUMN_INDEX_IMAGE:
                return recipe;
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
    
    public void searchFor(String name) {
        recipes.clear();
        recipes.addAll(recipeDao.find(name));
        
        fireTableDataChanged();
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
