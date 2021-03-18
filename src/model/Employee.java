package model;

public abstract class Employee extends Person{
    
    private int numOrder;
    private boolean eState;

    public Employee(int numOrder, boolean eState, String name, String lastName, int ID) {
        super(name, lastName, ID);
        this.numOrder = numOrder;
        this.eState = eState;
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
