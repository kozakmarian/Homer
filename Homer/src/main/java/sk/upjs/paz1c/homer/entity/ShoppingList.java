package sk.upjs.paz1c.homer.entity;

import java.util.Date;
import java.util.List;


public class ShoppingList extends Entity {
    
    private Date expiry;
    private List<Item> list;

    public Date getExpiry() {
        return expiry;
    }
    
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
    
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
