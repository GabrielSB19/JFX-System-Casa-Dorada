package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    
    private int oCode;
    private StatusOrder Status;
    private ArrayList<Integer> amountxProduct;
    private Date oDate;
    private Date oHour;
    private String observatinos;
    private boolean state;
    
    private ArrayList<Product> products;
    private Client rClient;
    private Employee rEmployee;
    private Admin coAdmin;
    private Admin moAdmin;

    public Order(int oCode, StatusOrder Status, ArrayList<Integer> amountxProduct, Date oDate, Date oHour, String observatinos, boolean state) {
        this.oCode = oCode;
        this.Status = Status;
        this.amountxProduct = amountxProduct;
        this.oDate = oDate;
        this.oHour = oHour;
        this.observatinos = observatinos;
        this.state = state;
        products = new ArrayList<>();
        this.rClient = rClient;
        this.rEmployee = rEmployee;
        this.coAdmin = coAdmin;
        this.moAdmin = moAdmin;
    }

    public int getoCode() {
        return oCode;
    }

    public void setoCode(int oCode) {
        this.oCode = oCode;
    }

    public StatusOrder getStatus() {
        return Status;
    }

    public void setStatus(StatusOrder Status) {
        this.Status = Status;
    }

    public ArrayList<Integer> getAmountxProduct() {
        return amountxProduct;
    }

    public void setAmountxProduct(ArrayList<Integer> amountxProduct) {
        this.amountxProduct = amountxProduct;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public Date getoHour() {
        return oHour;
    }

    public void setoHour(Date oHour) {
        this.oHour = oHour;
    }

    public String getObservatinos() {
        return observatinos;
    }

    public void setObservatinos(String observatinos) {
        this.observatinos = observatinos;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
}
