package sk.upjs.paz1c.homer;

import java.util.Date;

public class Commodity {
    
    private Float amount;
    private Date date;
    private String ean;
    private Long id;
    private String name;
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
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the value of ean
     *
     * @return the value of ean
     */
    public String getEan() {
        return ean;
    }

    /**
     * Set the value of ean
     *
     * @param ean new value of ean
     */
    public void setEan(String ean) {
        this.ean = ean;
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
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
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
