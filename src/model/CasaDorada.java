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
    
    private final String SAVE_PATH_FILE_ADMIN = "data/Admin.cgd";
    private final String SAVE_PATH_FILE_INGREDIENT = "data/Ingredient.cgd";
    private final String SAVE_PATH_FILE_TYPEPRODUCT = "data/TypeProduc.cgd";
    private final String SAVE_PATH_FILE_PRODUCT = "data/Product.cgd";
    
    
    private List<Admin> listAdmins;
    private List<Client> listClients;
    private List<Employee> listEmployees;
    private List<Ingredient> listIngredients;
    private List<Order> listOrders;
    private List<Product> listProducts;
    private List<TypeProduct> listTypeProducts;
    
    public CasaDorada() {
        listAdmins = new ArrayList<>();
        listIngredients = new ArrayList<>();
        listTypeProducts = new ArrayList<>();
        listProducts = new ArrayList<>();
    }

    /*
    Metodos relacionados con cargar la informacion
    Desserializar la informacion
    */
    
    //Cargar lista de Admins
    
    public void loadDataAdmin() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_ADMIN)));
            listAdmins = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Cargar lista de ingredientes
        
    public void loadDataIngredient() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_INGREDIENT)));
            listIngredients = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Cargar lista de tipo de producto
            
    public void loadDatTypeProduct() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_TYPEPRODUCT)));
            listTypeProducts = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Cargar lista de productos
    
    public void loadDataProduct() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_PRODUCT)));
            listProducts = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    Metodos relacionados  con guardar la informacion
    Serializacion de la informacion
    */
    
    //Guardar lista de admin
    
    public void saveDataAdmin() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ADMIN));
        oos.writeObject(listAdmins);
        oos.close();
    }
    
    //Guardar lista de ingredientes
    
    public void saveDataIngredient() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_INGREDIENT));
        oos.writeObject(listIngredients);
        oos.close();
    }
    
    //Guardar lista de productos
        
    public void saveDataTypeProduct() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_TYPEPRODUCT));
        oos.writeObject(listTypeProducts);
        oos.close();
    }
    
    //Guardar lista de productos
    
    public void saveDataProduct() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCT));
        oos.writeObject(listTypeProducts);
        oos.close();
    }
    
    /*
    Metodos para gestionar los  objetos
    */

        /*
        Metodos relacionados con los admin
        */
    
            //Agregar admin
    
    public void addAdmin(String userName, String password, int numOrder, boolean eState, Admin mAdmin,
            String name, String lastName, int ID, Admin cAdmin) throws IOException {

        //Al crearse la primer vez, no hay modificador y nunca va a tener creador.
        Admin newAdmin = new Admin(userName, password, numOrder, eState, mAdmin,
                name, lastName, ID, cAdmin);
        listAdmins.add(newAdmin);
        saveDataAdmin();
    }

    
        /*
        Metodos relacionados con los ingredientes
        */
    
            //Agregar ingrediente
    
    public void addIngredient(int ingCode, String ingredientsName, boolean ingredientsState, Admin ciAdmin, Admin miAdmin) throws IOException{
        Ingredient newIngredient = new Ingredient(ingCode, ingredientsName, ingredientsState, ciAdmin, miAdmin);
        listIngredients.add(newIngredient);
        saveDataIngredient();
    }
    
        
        /*
        Metodos relacionados con los tipo de productos
        */
    
            //Agregar tipo de producto
    public void addTypeProduct(int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) throws IOException{
        TypeProduct newTypeProduct = new TypeProduct(tpCode, typeName, typeState, ctpAdmin, mtpAdmin);
        listTypeProducts.add(newTypeProduct);
        saveDataTypeProduct();
    }
    
        /*
        Metodos relacionados con los productos
        */
    
            //Agregar Producto
    
    public void addProduct(int pCode, String pName, String pSize, double pPrice, boolean pState, int pNumOrder, Admin cpAdmin, Admin mpAdmin){
        Product newProduct = new Product(pCode, pName, pSize, pPrice, pState, pNumOrder, cpAdmin, mpAdmin);
        listProducts.add(newProduct);
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
