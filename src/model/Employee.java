package model;

public class Employee extends Person {

    private int numOrder;
    private boolean eState;
    private Admin mAdmin;
    
    public Employee(int numOrder, boolean eState, Admin mAdmin, String name, String lastName,
            int ID, Admin cAdmin) {
        
        super(name, lastName, ID, cAdmin);
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

    public boolean iseState() {
        return eState;
    }

    public void seteState(boolean eState) {
        this.eState = eState;
    }

}
