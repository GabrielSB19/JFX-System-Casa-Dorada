package model;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private static final long serialVersionUID = 1;
    
    private int pRef;
    private int pCode;
    private String name;
    private String lastName;
    private long ID;
    private Admin cAdmin;

    public Person(int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) {
        this.pRef = pRef;
        this.pCode = pCode;
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.cAdmin = cAdmin;
    }
    
    public int getPRef() {
        return pRef;
    }
    
    public void setPRef(int pRef) {
        this.pRef = pRef;
    }
    
    public int getPCode() {
        return pCode;
    }

    public void setPCode(int pCode) {
        this.pCode = pCode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Admin getCAdmin() {
        return cAdmin;
    }

    public void setCAdmin(Admin cAdmin) {
        this.cAdmin = cAdmin;
    }
}
