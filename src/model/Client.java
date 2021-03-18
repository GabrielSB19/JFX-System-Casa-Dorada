package model;

public class Client extends Person {
    
    private String cAddress;
    private int cPhone;
    private String cObservations;
    private boolean cState;
    private Admin mcAdmin;

    public Client(String cAddress, int cPhone, String cObservations, boolean cState, String name, String lastName, int ID) {
        super(name, lastName, ID);
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cObservations = cObservations;
        this.cState = cState;
        this.mcAdmin = mcAdmin;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public int getcPhone() {
        return cPhone;
    }

    public void setcPhone(int cPhone) {
        this.cPhone = cPhone;
    }

    public String getcObservations() {
        return cObservations;
    }

    public void setcObservations(String cObservations) {
        this.cObservations = cObservations;
    }

    public boolean iscState() {
        return cState;
    }

    public void setcState(boolean cState) {
        this.cState = cState;
    }
    
    

}
