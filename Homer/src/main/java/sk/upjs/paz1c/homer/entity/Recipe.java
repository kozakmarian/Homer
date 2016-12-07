package sk.upjs.paz1c.homer.entity;

import java.util.List;

public class Recipe extends Entity {
    
    private Long id;
    private String name;
    private Integer preparation;
    private Integer cooking;
    private Integer portions;
    private String image;
    private String instructions;
    private String url;
    private Integer status;
    private List<Item> ingredients;
    private String category;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
