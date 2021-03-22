package model;

import java.io.Serializable;

public class Client extends Person implements Serializable {
    
    private static final long serialVersionUID = 1;

    private String cAddress;
    private int cPhone;
    private String cObservations;
    private boolean cState;
    private Admin mcAdmin;

    public Client(String cAddress, int cPhone, String cObservations, boolean cState, Admin mcAdmin, int pRef, int pCode, String name, String lastName, int ID, Admin cAdmin) {
        super(pRef, pCode, name, lastName, ID, cAdmin);
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cObservations = cObservations;
        this.cState = cState;
        this.mcAdmin = mcAdmin;
    }



    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public int getCPhone() {
        return cPhone;
    }

    public void setCPhone(int cPhone) {
        this.cPhone = cPhone;
    }

    public String getCObservations() {
        return cObservations;
    }

    public void setCObservations(String cObservations) {
        this.cObservations = cObservations;
    }

    public boolean getCState() {
        return cState;
    }

    public void setCState(boolean cState) {
        this.cState = cState;
    }

    public Admin getMcAdmin(){
        return mcAdmin;
    }
    
    public void setMcAdmin(Admin mcAdmin) {
        this.mcAdmin = mcAdmin;
    }
}
