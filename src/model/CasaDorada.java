package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasaDorada implements Serializable {

    private static final long serialVersionUID = 1;
    private CasaDorada cd;
    private String SAVE_PATH_FILE_PROGRAM = "data/Program.cgd";
    private List<Admin> listAdmins;
    private List<Client> listClients;
    private List<Employee> listEmployees;
    private List<Ingredient> listIngredients;
    private List<Order> listOrders;
    private List<Product> listProducts;
    private List<TypeProduct> listTypeProducts;
    
    public CasaDorada() {
        listAdmins = new ArrayList<>();
    }

    //LOAD INFO
    public void loadData() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_PROGRAM)));
            listAdmins = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SAVE INFO
    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PROGRAM));
        oos.writeObject(listAdmins);
        oos.close();
    }

    //Agregar Admin
    public void addAdmin(String userName, String password, int numOrder, boolean eState, Admin mAdmin,
            String name, String lastName, int ID, Admin cAdmin) throws IOException {

        //Al crearse la primer vez, no hay modificador y nunca va a tener creador.
        Admin newAdmin = new Admin(userName, password, numOrder, eState, mAdmin,
                name, lastName, ID, cAdmin);
        listAdmins.add(newAdmin);
        saveData();
    }
    
    public void login(String username){
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i).getUsername().equals(username)) {
                System.out.println("si");
            }
        }
        System.out.println("no");
    }
}
