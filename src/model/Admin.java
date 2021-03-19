package model;

public class Admin extends Employee {

    private String username;
    private String password;

    public Admin(String userName, String password, int numOrder, boolean eState, Admin mAdmin,
            String name, String lastName, int ID, Admin cAdmin) {
        
        super(numOrder, eState,  mAdmin, name, lastName, ID, cAdmin);
        this.username = userName;
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
