package model;

import java.io.Serializable;

public abstract class Person {

    private String name;
    private String lastName;
    private int ID;
    private Admin cAdmin;

    public Person(String name, String lastName, int ID, Admin cAdmin) {
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.cAdmin = cAdmin;
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
    
}
