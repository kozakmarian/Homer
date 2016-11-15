package sk.upjs.paz1c.homer;

class Item {
    
    private Float amount;
    private Long commodity_id;
    private Long id;
    private Integer status;
    private String unit;

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
    public Long getCommodity_id() {
        return commodity_id;
    }

    /**
     * Set the value of commodity_id
     *
     * @param commodity_id new value of commodity_id
     */
    public void setCommodity_id(Long commodity_id) {
        this.commodity_id = commodity_id;
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
