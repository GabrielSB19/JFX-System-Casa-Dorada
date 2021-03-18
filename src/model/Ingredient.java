package model;

public class Ingredient {
    
    private String ingredientsName;
    private Boolean ingredientsState;
    private Admin ciAdmin;
    private Admin miAdmin;

    public Ingredient(String ingredientsName, Boolean ingredientsState) {
        this.ingredientsName = ingredientsName;
        this.ingredientsState = ingredientsState;
        this.ciAdmin = ciAdmin;
        this.miAdmin = miAdmin;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public Boolean getIngredientsState() {
        return ingredientsState;
    }

    public void setIngredientsState(Boolean ingredientsState) {
        this.ingredientsState = ingredientsState;
    }
    
    
}
