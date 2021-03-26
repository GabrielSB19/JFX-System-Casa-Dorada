package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1;
    
    private int numOrder;
    private boolean eState;
    private Admin mAdmin;

    public Employee(int numOrder, boolean eState, Admin mAdmin, int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) {
        super(pRef, pCode, name, lastName, ID, cAdmin);
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

    public Admin getMAdmin() {
        return mAdmin;
    }

    public void setMAdmin(Admin mAdmin) {
        this.mAdmin = mAdmin;
    }
    
    public String getNameLN(){
        String nameLN = getName()+" "+getLastName();
        return nameLN;
    }
    
    

}
