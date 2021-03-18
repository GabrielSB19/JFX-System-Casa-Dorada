package model;

public class Admin extends Employee{
    
    private String username;
    private String password;

    public Admin(String username, String password, int numOrder, boolean eState, String name, String lastName, int ID) {
        super(numOrder, eState, name, lastName, ID);
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
