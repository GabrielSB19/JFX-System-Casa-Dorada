package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CasaDorada implements Serializable {

    private static final long serialVersionUID = 1;

    private final String SAVE_PATH_FILE_ADMIN = "data/Admin.cgd";
    private final String SAVE_PATH_FILE_CLIENT = "data/Client.cgd";
    private final String SAVE_PATH_FILE_EMPLOYEE = "data/Employee.cgd";
    private final String SAVE_PATH_FILE_INGREDIENT = "data/Ingredient.cgd";
    private final String SAVE_PATH_FILE_TYPEPRODUCT = "data/TypeProduct.cgd";
    private final String SAVE_PATH_FILE_PRODUCT = "data/Product.cgd";
    private final String SAVE_PATH_FILE_CODE = "data/Code.cgd";

    private int code;
    private List<Admin> listAdmins;
    private List<Client> listClients;
    private List<Employee> listEmployees;
    private List<Ingredient> listIngredients;
    private List<Order> listOrders;
    private List<Product> listProducts;
    private List<TypeProduct> listTypeProducts;
    private Admin adminActive;

    public CasaDorada() {
        listAdmins = new ArrayList<>();
        listClients = new ArrayList<>();
        listEmployees = new ArrayList<>();
        listIngredients = new ArrayList<>();
        listTypeProducts = new ArrayList<>();
        listProducts = new ArrayList<>();
        code = 0;
    }

    public void loadDataAdmin() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_ADMIN)));
            listAdmins = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataClient() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_CLIENT)));
            listClients = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataEMmployee() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_EMPLOYEE)));
            listEmployees = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataIngredient() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_INGREDIENT)));
            listIngredients = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDatTypeProduct() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_TYPEPRODUCT)));
            listTypeProducts = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataProduct() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_PRODUCT)));
            listProducts = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataCode() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_CODE)));
            code = (int) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDataAdmin() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ADMIN));
        oos.writeObject(listAdmins);
        oos.close();
    }

    public void saveDataClient() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENT));
        oos.writeObject(listClients);
        oos.close();
    }

    public void saveDataEmployee() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_EMPLOYEE));
        oos.writeObject(listEmployees);
        oos.close();
    }

    public void saveDataIngredient() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_INGREDIENT));
        oos.writeObject(listIngredients);
        oos.close();
    }

    public void saveDataTypeProduct() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_TYPEPRODUCT));
        oos.writeObject(listTypeProducts);
        oos.close();
    }

    public void saveDataProduct() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCT));
        oos.writeObject(listProducts);
        oos.close();
    }

    public void saveDataCode() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CODE));
        oos.writeObject(code);
        oos.close();
    }

    public boolean login(String username, String password) {
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i).getUsername().equals(username) && listAdmins.get(i).getPassword().equals(password) && listAdmins.get(i).getEState()) {
                adminActive = listAdmins.get(i);
                return true;
            }
        }
        return false;
    }

    public int getCode() {
        return code;
    }

    /*
    Metodos relacionados con los admin
     */
    
    public Admin getAdminActive() {
        return adminActive;
    }
    
    public List<Admin> getListAdmins() {
        return listAdmins;
    }

    public void addAdmin(String username, String password, int numOrder, boolean eState, Admin mAdmin, int pCode, String name, String lastName, int ID, Admin cAdmin) throws IOException {
        Admin newAdmin = new Admin(username, password, numOrder, true, null, 0, code++, name, lastName, ID, cAdmin);
        listAdmins.add(newAdmin);
        saveDataCode();
        saveDataAdmin();
    }

    public boolean updateAdmin(int code, String username, String password, boolean eState, Admin mAdmin, String name, String lastName, int ID) throws IOException {
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i).getPCode() == code) {
                listAdmins.get(i).setUsername(username);
                listAdmins.get(i).setPassword(password);
                listAdmins.get(i).setEState(eState);
                listAdmins.get(i).setMAdmin(mAdmin);
                listAdmins.get(i).setName(name);
                listAdmins.get(i).setLastName(lastName);
                listAdmins.get(i).setID(ID);
                saveDataAdmin();
                System.out.println(adminActive.getName());
                System.out.println(listAdmins.get(i).getName());
                System.out.println(listAdmins.get(i).getEState());
                if (!listAdmins.get(i).getEState() && listAdmins.get(i) == adminActive) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public boolean removeAdmin(int code) throws IOException {
        for (int i = 0; i < listAdmins.size(); i++) {
            System.out.println(listAdmins.get(i).getName());
            System.out.println(listAdmins.get(i).getPRef());
            if (listAdmins.get(i).getPCode() == code && listAdmins.get(i).getPRef() == 0) {
                listAdmins.remove(i);
                saveDataAdmin();
                return true;
            }
        }
        return false;
    }

    public boolean verifyAdmin(int code) throws IOException {
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i).getPCode() == code && listAdmins.get(i) == adminActive) {
                return true;
            }
        }
        return false;
    }

    /*
    Metodos relacionados con los Empleados
     */
    
    public List<Employee> getEmployee() {
        return listEmployees;
    }

    public void addEmployee(int numOrder, boolean eState, Admin mAdmin, int pRef, int pCode, String name, String lastName, int ID, Admin cAdmin) throws IOException {
        Employee newEmployee = new Employee(0, true, null, 0, code++, name, lastName, ID, cAdmin);
        listEmployees.add(newEmployee);
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                System.out.println(listAdmins.get(i).getName() + " antes: " + listAdmins.get(i).getPRef());
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
                System.out.println(listAdmins.get(i).getName() + " despues: " + listAdmins.get(i).getPRef());
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataEmployee();
    }

    public void uptadeEmployee(int code, boolean eState, Admin mAdmin, String name, String lastName, int ID) throws IOException {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getPCode() == code) {
                listEmployees.get(i).setEState(eState);
                listEmployees.get(i).setName(name);
                listEmployees.get(i).setLastName(lastName);
                listEmployees.get(i).setID(ID);
                if (listEmployees.get(i).getMAdmin() != null) {
                    boolean aux = false;
                    for (int j = 0; j < listAdmins.size() && !aux; j++) {
                        if (listAdmins.get(j) == listEmployees.get(i).getMAdmin()) {
                            System.out.println("---");
                            System.out.println("Modificador viejo " + listAdmins.get(j).getName() + " antes: " + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador viejo " + listAdmins.get(j).getName() + " despues: " + listAdmins.get(j).getPRef());
                            System.out.println("---");
                            listEmployees.get(i).setMAdmin(mAdmin);
                            for (int k = 0; k < listAdmins.size() && !aux; k++) {
                                if (listAdmins.get(k) == listEmployees.get(i).getMAdmin()) {
                                    System.out.println("---");
                                    System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " antes: " + listAdmins.get(k).getPRef());
                                    listAdmins.get(k).setPRef(listAdmins.get(k).getPRef() + 1);
                                    System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " despues: " + listAdmins.get(k).getPRef());
                                    System.out.println("-----");
                                    aux = true;
                                }
                            }
                        }
                    }
                } else {
                    listEmployees.get(i).setMAdmin(mAdmin);
                    boolean aux = false;
                    for (int k = 0; k < listAdmins.size() && !aux; k++) {
                        if (listAdmins.get(k) == listEmployees.get(i).getMAdmin()) {
                            System.out.println("---");
                            System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " antes: " + listAdmins.get(k).getPRef());
                            listAdmins.get(k).setPRef(listAdmins.get(k).getPRef() + 1);
                            System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " despues: " + listAdmins.get(k).getPRef());
                            System.out.println("-----");
                            aux = true;
                        }
                    }
                }

                /*
                if (listEmployees.get(i).getMAdmin() != adminActive) {
                    for (int j = 0; j < listAdmins.size(); j++) {
                        if (listAdmins.get(j).getPCode() == mAdmin.getPCode()) {
                            if (listEmployees.get(i).getMAdmin() != null) {
                                System.out.println("---");
                                System.out.println("Modificador viejo " + listEmployees.get(j).getMAdmin().getName() + " antes: " + listAdmins.get(j).getPRef());
                                listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                                System.out.println("Modificador viejo " + listEmployees.get(j).getMAdmin().getName() + " despues: " + listAdmins.get(j).getPRef());
                                System.out.println("---");
                            }
                            listEmployees.get(i).setMAdmin(mAdmin);
                            for (int k = 0; k < listAdmins.size(); k++) {
                                if (listAdmins.get(k) == mAdmin) {
                                    System.out.println("---");
                                    System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " antes: " + listAdmins.get(k).getPRef());
                                    listAdmins.get(k).setPRef(listAdmins.get(k).getPRef() + 1);
                                    System.out.println("Modificador nuevo " + listAdmins.get(k).getName() + " despues: " + listAdmins.get(k).getPRef());
                                    System.out.println("-----");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                break;
                 */
            }
            
        }
        
        saveDataEmployee();
        saveDataAdmin();
        
    }

    public boolean removeEmployee(int code) throws IOException {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getPCode() == code && listEmployees.get(i).getPRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && (!out && !out1); j++) {
                    if (listEmployees.get(i).getCAdmin() == listAdmins.get(j) && !out) {
                        System.out.println("Creador antes:" + listAdmins.get(j).getPRef());
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        System.out.println("Creador despues:" + listAdmins.get(j).getPRef());
                        out = true;
                    }
                    try {
                        if (listEmployees.get(i).getMAdmin() == listAdmins.get(j) && !out1) {
                            System.out.println("Modificador antes:" + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador despues:" + listAdmins.get(j).getPRef());
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listEmployees.remove(i);
                saveDataAdmin();
                saveDataEmployee();
                return true;
            }
        }
        return false;
    }

    /*
    Metodos relacionados con los clientes
     */
    
    private Admin test;
    private int countAdmins;
    
    public List<Client> getClient() {
        return listClients;
    }
     
    public boolean addClient(String cAddress, int cPhone, String cObservations, boolean cState, Admin mcAdmin, int pRef, int pCode, String name, String lastName, int ID, Admin cAdmin) throws IOException {
        boolean out = false;
        Client newClient = new Client(cAddress, cPhone, cObservations, cState, null, 0, code++, name, lastName, ID, cAdmin);
        if (listClients.isEmpty()) {
            listClients.add(newClient);
            saveDataAdmin();
            saveDataCode();
            saveDataClient();
            out = true;
        } else {
            for (int i = 0; i < listClients.size(); i++) {
                if(listClients.get(i).getID() != ID){
                    listClients.add(newClient);
                    saveDataAdmin();
                    saveDataCode();
                    saveDataClient();
                    out = true;
                } else {
                    out = false;
                }
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if(listAdmins.get(i) == adminActive){
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef()+1);
            }
        }
        return out;
    }

    public boolean updateClient(int code, String cAddress, int cPhone, String cObservations, boolean cState, Admin mcAdmin, String name, String lastName, int ID) throws IOException {
        boolean exit = false;
        if (countAdmins != 0) {
            boolean out = false;
            for (int i = 0; i < listAdmins.size() && !out; i++) {
                if (test == listAdmins.get(i)) {
                    listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() - 1);
                    out = true;
                }
            }
        }
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getPCode() == code) {
                for (int j = 0; j < listClients.size(); j++) {
                    if (listClients.get(i).getID() != listClients.get(j).getID() && listClients.get(i).getID() != ID || listClients.size() == 1) {
                        listClients.get(i).setCAddress(cAddress);
                        listClients.get(i).setCPhone(cPhone);
                        listClients.get(i).setCObservations(cObservations);
                        listClients.get(i).setCState(cState);
                        listClients.get(i).setMcAdmin(mcAdmin);
                        listClients.get(i).setName(name);
                        listClients.get(i).setLastName(lastName);
                        listClients.get(i).setID(ID);
                        test = mcAdmin;
                        countAdmins++;
                        exit = true;
                    }
                }

            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (mcAdmin == listAdmins.get(i)) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataClient();
        return exit;
    }
    
    public boolean removeClient(int code) throws IOException {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getPCode() == code && listClients.get(i).getPRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {

                    if (listClients.get(i).getCAdmin() == listAdmins.get(j) && !out) {
                        System.out.println("Creador antes:" + listAdmins.get(j).getPRef());
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        System.out.println("Creador despues:" + listAdmins.get(j).getPRef());
                        out = true;
                    }
                    try {
                        if (listClients.get(i).getMcAdmin() == listAdmins.get(j) && !out1) {
                            System.out.println("Modificador antes:" + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador despues:" + listAdmins.get(j).getPRef());
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
            listClients.remove(i);
            saveDataAdmin();
            saveDataClient();
            test = null;
            return true;
            }
        }
        return false;
    }

    


/*
     
    */

    /*
    Metodos relacionados con los ingredientes
     */
    private int ingredientIndex;

    public void addIngredient(int ingCode, String ingredientsName, boolean ingredientsState, Admin ciAdmin, Admin miAdmin) throws IOException {
        Ingredient newIngredient = new Ingredient(ingCode, ingredientsName, ingredientsState, ciAdmin, miAdmin);
        listIngredients.add(newIngredient);
        saveDataIngredient();
    }

    public List<Ingredient> getIngredient() {
        return listIngredients;
    }

    public int getIngredientIndex() {
        return ingredientIndex;
    }

    public void selectedIngredient(Ingredient ingredientNew) {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i) == ingredientNew) {
                ingredientIndex = i;
            }
        }
    }

    public void setNewIngredient(Ingredient newIngredient) throws IOException {
        listIngredients.set(ingredientIndex, newIngredient);
        saveDataIngredient();
    }

    public void removeIngredient(int indexIngredient) throws IOException {
        listIngredients.remove(indexIngredient);
        saveDataIngredient();
    }

    /*
    Metodos relacionados con los tipo de productos
     */
    private int typeProductIndex;

    public void addTypeProduct(int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) throws IOException {
        TypeProduct newTypeProduct = new TypeProduct(tpCode, typeName, typeState, ctpAdmin, mtpAdmin);
        listTypeProducts.add(newTypeProduct);
        saveDataTypeProduct();
    }

    public List<TypeProduct> getTypeProduc() {
        return listTypeProducts;
    }

    public int getTypeProductIndex() {
        return typeProductIndex;
    }

    public void selectedProduct(Product productNew) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i) == productNew) {
                productIndex = i;
            }
        }
    }

    public void selectedTypeIngredient(TypeProduct typeProductNew) {
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i) == typeProductNew) {
                typeProductIndex = i;
            }
        }
    }

    public void setNewTypeProduct(TypeProduct newTypeProduct) throws IOException {
        listTypeProducts.set(typeProductIndex, newTypeProduct);
        saveDataTypeProduct();
    }

    public void removeTypeProduct(int indexTypeProduct) throws IOException {
        listTypeProducts.remove(indexTypeProduct);
        saveDataTypeProduct();
    }

    /*
    Metodos relacionados con los productos
     */
    private Ingredient ingredientInProduct;
    private TypeProduct typeProductInProduct;
    private int productIndex;

    public void addProduct(int pCode, String pName, String pSize, double pPrice, boolean pState, int pNumOrder, Admin cpAdmin, Admin mpAdmin) throws IOException {
        Product newProduct = new Product(pCode, pName, pSize, pPrice, pState, pNumOrder, cpAdmin, mpAdmin);
        listProducts.add(newProduct);
        saveDataProduct();
    }

    public List<Product> getProduct() {
        return listProducts;
    }

    public Ingredient addIngredientToProduct(Ingredient ingredientSelect) {
        if (ingredientSelect != null) {
            ingredientInProduct = ingredientSelect;
            return ingredientInProduct;
        } else {
            return null;
        }
    }

    public TypeProduct addTypeProductToProduct(TypeProduct typeProductSelect) {
        if (typeProductSelect != null) {
            typeProductInProduct = typeProductSelect;
            return typeProductInProduct;
        } else {
            return null;
        }
    }

    public void addIngredientToProductArray(ArrayList<Ingredient> ingredients) {
        int index = listProducts.size() - 1;
        listProducts.get(index).setIngredientInProduct(ingredients);
    }

    public void addTypeProductToProductArray(ArrayList<TypeProduct> typeProducts) {
        int index = listProducts.size() - 1;
        listProducts.get(index).setTypeProductInProduct(typeProducts);
    }
}
