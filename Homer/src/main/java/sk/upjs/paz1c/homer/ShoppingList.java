package sk.upjs.paz1c.homer;

import java.util.Date;
import java.util.List;

public class ShoppingList {
    
    private Date dateCreated;
    private Long id;
    private List<Item> list;
    private String name;
    private Integer status;


    /**
     * Get the value of dateCreated
     *
     * @return the value of dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Set the value of dateCreated
     *
     * @param dateCreated new value of dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
     * Get the value of list
     *
     * @return the value of list
     */
    public List<Item> getList() {
        return list;
    }

    /**
     * Set the value of list
     *
     * @param list new value of list
     */
    public void setList(List<Item> list) {
        this.list = list;
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
}
