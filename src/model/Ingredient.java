package model;

public class Ingredient {
    
    private int ingCode;
    private String ingredientsName;
    private boolean ingredientsState;
    private Admin ciAdmin;
    private Admin miAdmin;

    public Ingredient(int ingCode, String ingredientsName, boolean ingredientsState, Admin ciAdmin, Admin miAdmin) {
        this.ingCode = ingCode;
        this.ingredientsName = ingredientsName;
        this.ingredientsState = ingredientsState;
        this.ciAdmin = ciAdmin;
        this.miAdmin = miAdmin;
    }

    public int getIngCode() {
        return ingCode;
    }

    public void setIngCode(int ingCode) {
        this.ingCode = ingCode;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public boolean isIngredientsState() {
        return ingredientsState;
    }

    public void setIngredientsState(boolean ingredientsState) {
        this.ingredientsState = ingredientsState;
    }

    public Admin getCiAdmin() {
        return ciAdmin;
    }

    public void setCiAdmin(Admin ciAdmin) {
        this.ciAdmin = ciAdmin;
    }

    public Admin getMiAdmin() {
        return miAdmin;
    }

    public void setMiAdmin(Admin miAdmin) {
        this.miAdmin = miAdmin;
    }
    
    
}
