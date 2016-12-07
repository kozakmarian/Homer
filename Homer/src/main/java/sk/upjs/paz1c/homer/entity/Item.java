package sk.upjs.paz1c.homer.entity;

/**
 *
 * @author dyske
 */
public class Item extends Entity{
    
    private Float amount;
    private Long product_id;
    private Long id;
    private Long list_id;
    private Integer status;
    private String unit;

    
    /**
     * Get the value of list_id
     *
     * @return the value of list_id
     */
    public Long getList_id() {
        return list_id;
    }

    /**
     * Set the value of list_id
     *
     * @param list_id new value of list_id
     */
    public void setList_id(Long list_id) {
        this.list_id = list_id;
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
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
