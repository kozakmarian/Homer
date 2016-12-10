package sk.upjs.paz1c.homer.entity;

/**
 *
 * @author dyske
 */
public class Item extends Entity{
    
    private Float amount;
    private Long product_id;
    private Long list_id;
    private Long recipe_id;
    private String unit;

    
    /**
     * Get the value of list_id
     *
     * @return the value of list_id
     */
    public Long getListId() {
        return list_id;
    }

    /**
     * Set the value of list_id
     *
     * @param list_id new value of list_id
     */
    public void setListId(Long list_id) {
        this.list_id = list_id;
    }

    /**
     * Get the value of recipe_id
     *
     * @returns the value of recipe_id
     */
    public Long getRecipeId() {
        return recipe_id;
    }

    /**
     * Set the value of recipe_id
     *
     * @param recipe_id new value of recipe_id
     */
    public void setRecipeId(Long recipe_id) {
        this.recipe_id = recipe_id;
    }
    
    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * Get the value of commodity_id
     *
     * @return the value of commodity_id
     */
    public Long getProductId() {
        return product_id;
    }

    /**
     * Set the value of commodity_id
     *
     * @param product_id new value of commodity_id
     */
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    /**
     * Get the value of unit
     *
     * @return the value of unit
     */
    public String getUnit() {
        return unit;
    }
    
    /**
     * Set the value of unit
     *
     * @param unit new value of unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
