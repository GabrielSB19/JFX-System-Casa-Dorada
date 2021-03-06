package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 1;
    private int oCode;
    private StatusOrder Status;
    private Date oDate;
    private String observatinos;
    private boolean state;
    private ArrayList<Product> products;
    private Client rClient;
    private Employee rEmployee;
    private Admin coAdmin;
    private Admin moAdmin;

    public Order(int oCode, StatusOrder Status, Date oDate, String observatinos, boolean state, Client rClient, Employee rEmployee, Admin coAdmin, Admin moAdmin) {
        this.oCode = oCode;
        this.Status = Status;
        this.oDate = oDate;
        this.observatinos = observatinos;
        this.state = state;
        products = new ArrayList<>();
        this.rClient = rClient;
        this.rEmployee = rEmployee;
        this.coAdmin = coAdmin;
        this.moAdmin = moAdmin;
    }

    public int getCode() {
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

    public Date getODate() {
        return oDate;
    }

    public void setODate(Date oDate) {
        this.oDate = oDate;
    }

    public String getObservatinos() {
        return observatinos;
    }

    public void setObservatinos(String observatinos) {
        this.observatinos = observatinos;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Client getrClient() {
        return rClient;
    }

    public void setrClient(Client rClient) {
        this.rClient = rClient;
    }

    public Employee getrEmployee() {
        return rEmployee;
    }

    public void setrEmployee(Employee rEmployee) {
        this.rEmployee = rEmployee;
    }

    public Admin getCoAdmin() {
        return coAdmin;
    }

    public void setCoAdmin(Admin coAdmin) {
        this.coAdmin = coAdmin;
    }

    public Admin getMoAdmin() {
        return moAdmin;
    }

    public void setMoAdmin(Admin moAdmin) {
        this.moAdmin = moAdmin;
    }

    public void addProductInOrder(Product newProduct) {
        products.add(newProduct);
    }

    public String getShowClientName() {
        String showClientName = "";
        if (rClient != null) {
            showClientName = rClient.getName() + " " + rClient.getLastName();
        }
        return showClientName;
    }

    public String getShowEmployeeName() {
        String showEmployeeName = "";
        if (rEmployee != null) {
            showEmployeeName = rEmployee.getNameLN();
        }
        return showEmployeeName;
    }

    public String getShowNamesProducts() {
        String showNamesProducts = "";
        String separator = "";
        for (int i = 0; i < products.size(); i++) {
            showNamesProducts += separator + products.get(i).getNameSP();
            separator = ", ";
        }
        return showNamesProducts;
    }

    public String getShowAmountProducts() {
        String showAmountProducts = "";
        String separator = "";
        for (int i = 0; i < products.size(); i++) {
            showAmountProducts += separator + products.get(i).getPrNumOrder();
            separator = ", ";
        }
        return showAmountProducts;
    }

    public String getValueOrder() {
        String valueOrder;
        double value = 0;
        if (Status == StatusOrder.ENTREGADO) {
            for (int i = 0; i < products.size(); i++) {
                value += (products.get(i).getPrPrice() * products.get(i).getPrNumOrder());
            }
            valueOrder = value + "";
        } else {
            valueOrder = "En Proceso";
        }
        return valueOrder;
    }
}
