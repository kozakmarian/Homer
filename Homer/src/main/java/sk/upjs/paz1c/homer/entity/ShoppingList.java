package sk.upjs.paz1c.homer.entity;

import java.util.Date;
import java.util.List;


public class ShoppingList extends Entity {
    
    private Date expiry;
    private Long id;
    private List<Item> list;
    private String name;
    private Integer status;


    
    public Date getExpiry() {
        return expiry;
    }

    
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
    
    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    public List<Item> getList() {
        return list;
    }

    
    public void setList(List<Item> list) {
        this.list = list;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
}
