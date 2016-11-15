package sk.upjs.paz1c.homer;

import java.util.List;

public class Recipe {
    
    private String description;
    private Long id;
    private List<Commodity> ingredients;
    private String instructions;
    private String name;
    private Integer status;
    private String url;
    
    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Get the value of ingredients
     *
     * @return the value of ingredients
     */
    public List<Commodity> getIngredients() {
        return ingredients;
    }
    /**
     * Set the value of ingredients
     *
     * @param ingredients new value of ingredients
     */
    public void setIngredients(List<Commodity> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     * Get the value of instructions
     *
     * @return the value of instructions
     */
    public String getInstructions() {
        return instructions;
    }
    /**
     * Set the value of instructions
     *
     * @param instructions new value of instructions
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
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
     * Get the value of url
     *
     * @return the value of url
     */
    public String getUrl() {
        return url;
    }
    /**
     * Set the value of url
     *
     * @param url new value of url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
