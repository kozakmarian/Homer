package sk.upjs.paz1c.homer.entity;

/**
 *
 * @author dyske
 */
public class Product extends Entity {
    
    private String image;

    @Override
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
