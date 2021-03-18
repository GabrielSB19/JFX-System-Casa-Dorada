package model;

import java.util.ArrayList;

public class Product {
    
    private String pName;
    private String pSize;
    private double pPrice;
    private boolean pState;
    private int pNumOrder;
    private Admin cpAdmin;
    private Admin mpAdmin;
    
    private ArrayList<Ingredient> ingredients;
    private ArrayList<TypeProduct> typeProducts;
    
    public Product(String pName, String pSize, double pPrice, boolean pState, int pNumOrder) {
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
}
