package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1;
    
    private int numOrder;
    private boolean eState;
    private Admin mAdmin;

    public Employee(int numOrder, boolean eState, Admin mAdmin, int pCode, String name, String lastName, int ID, Admin cAdmin) {
        super(pCode, name, lastName, ID, cAdmin);
        this.numOrder = numOrder;
        this.eState = eState;
        this.mAdmin = mAdmin;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public boolean getEState() {
        return eState;
    }

    public void setEState(boolean eState) {
        this.eState = eState;
    }

    public Admin getmAdmin() {
        return mAdmin;
    }

    public void setmAdmin(Admin mAdmin) {
        this.mAdmin = mAdmin;
    }
    
    

}
