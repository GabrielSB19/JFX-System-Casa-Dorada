package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    
    private static final long serialVersionUID = 1;

    private int pCode;
    private String pName;
    private String pSize;
    private double pPrice;
    private boolean pState;
    private int pNumOrder;
    private Admin cpAdmin;
    private Admin mpAdmin;

    private ArrayList<Ingredient> ingredients;
    private ArrayList<TypeProduct> typeProducts;

    public Product(int pCode, String pName, String pSize, double pPrice, boolean pState, int pNumOrder, Admin cpAdmin, Admin mpAdmin) {
        this.pCode = pCode;
        this.pName = pName;
        this.pSize = pSize;
        this.pPrice = pPrice;
        this.pState = pState;
        this.pNumOrder = pNumOrder;
        this.cpAdmin = cpAdmin;
        this.mpAdmin = mpAdmin;
        ingredients = new ArrayList<>();
        typeProducts = new ArrayList<>();

    }

    public int getpCode() {
        return pCode;
    }

    public void setpCode(int pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public boolean ispState() {
        return pState;
    }

    public void setpState(boolean pState) {
        this.pState = pState;
    }

    public int getpNumOrder() {
        return pNumOrder;
    }

    public void setpNumOrder(int pNumOrder) {
        this.pNumOrder = pNumOrder;
    }

    public Admin getCpAdmin() {
        return cpAdmin;
    }

    public void setCpAdmin(Admin cpAdmin) {
        this.cpAdmin = cpAdmin;
    }

    public Admin getMpAdmin() {
        return mpAdmin;
    }

    public void setMpAdmin(Admin mpAdmin) {
        this.mpAdmin = mpAdmin;
    } 
    
    public void addIngredientInProduct(Ingredient newIngredient){
        ingredients.add(newIngredient);
    }
    
    public void addTypeProductInProduct(TypeProduct newTypeProduct){
        typeProducts.add(newTypeProduct);
    }
    
    public ArrayList<Ingredient> getIngredientInProduct(){
        return ingredients;
    }
    
    public ArrayList<TypeProduct> getTypeProductInProduct(){
        return typeProducts;
    }
}
