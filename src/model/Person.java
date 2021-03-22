package model;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private static final long serialVersionUID = 1;
    
    private int pCode;
    private String name;
    private String lastName;
    private int ID;
    private Admin cAdmin;

    public Person(int pCode, String name, String lastName, int ID, Admin cAdmin) {
        this.pCode = pCode;
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.cAdmin = cAdmin;
    }

    public int getpCode() {
        return pCode;
    }

    public void setpCode(int pCode) {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Admin getcAdmin() {
        return cAdmin;
    }

    public void setcAdmin(Admin cAdmin) {
        this.cAdmin = cAdmin;
    }
}
