package model;

import java.io.Serializable;

public class Admin extends Employee implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String username;
    private String password;

    public Admin(String username, String password, int numOrder, boolean eState, Admin mAdmin, int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) {
        super(numOrder, eState, mAdmin, pRef, pCode, name, lastName, ID, cAdmin);
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
