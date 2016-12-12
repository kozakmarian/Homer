package sk.upjs.paz1c.homer.entity;

import java.util.List;

public class Recipe extends Entity {
    
    private Integer preparation;
    private Integer cooking;
    private Integer portions;
    private String image;
    private String instructions;
    private String url;
    private List<Item> ingredients;
    private String category;

    public Integer getPreparation() {
        return preparation;
    }

    public void setPreparation(Integer preparation) {
        this.preparation = preparation;
    }

    public Integer getCooking() {
        return cooking;
    }

    public void setCooking(Integer cooking) {
        this.cooking = cooking;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Item> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    
}
