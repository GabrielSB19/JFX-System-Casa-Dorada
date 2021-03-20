package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CasaDorada implements Serializable {

    private static final long serialVersionUID = 1;
    private CasaDorada cd;
    private String SAVE_PATH_FILE_PROGRAM = "/logs/Program.cgd";
    private ArrayList<Admin> listAdmins;
    private ArrayList<Client> listClients;
    private ArrayList<Employee> listEmployees;
    private ArrayList<Ingredient> listIngredients;
    private ArrayList<Order> listOrders;
    private ArrayList<Product> listProducts;
    private ArrayList<TypeProduct> listTypeProducts;
    
    public CasaDorada() {

    }

    //LOAD INFO
    public void loadData() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_PROGRAM)));
            CasaDorada cd = (CasaDorada) ois.readObject();
            this.cd = cd;
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SAVE INFO
    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PROGRAM));
        oos.writeObject(cd);
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
}
