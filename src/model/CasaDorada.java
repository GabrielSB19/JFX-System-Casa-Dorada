package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
    private final String SAVE_PATH_FILE_ORDER = "data/Order.cgd";

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
        listOrders = new ArrayList<>();
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
    
    public void loadDataOrder(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_ORDER)));
            listOrders = (List) ois.readObject();
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
    
    public void saveDataOrder() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ORDER));
        oos.writeObject(listOrders);
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

    public void addAdmin(String username, String password, int numOrder, boolean eState, Admin mAdmin, int pCode, String name, String lastName, long ID, Admin cAdmin) throws IOException {
        Admin newAdmin = new Admin(username, password, numOrder, true, null, 0, code++, name, lastName, ID, cAdmin);
        listAdmins.add(newAdmin);
        saveDataCode();
        saveDataAdmin();
    }

    public boolean updateAdmin(int code, String username, String password, boolean eState, Admin mAdmin, String name, String lastName, long ID) throws IOException {
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

    public boolean addEmployee(int numOrder, boolean eState, Admin mAdmin, int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) throws IOException {
        boolean out = false;
        Employee newEmployee = new Employee(0, eState, null, 0, code++, name, lastName, ID, cAdmin);
        if (listEmployees.isEmpty() && !out) {
            listEmployees.add(newEmployee);
            out = true;
        } else {
            for (int i = 0; i < listEmployees.size() && !out; i++) {
                if (listEmployees.get(i).getID() != ID) {
                    listEmployees.add(newEmployee);
                    out = true;
                }
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataEmployee();
        return out;
    }

    public boolean uptadeEmployee(int code, boolean eState, Admin mAdmin, String name, String lastName, long ID) throws IOException {
        boolean out = false;
        boolean test = false;
        int xd = 0;
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listClients.get(i).getID() != ID) {
                xd++;
            }
        }
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getPCode() == code) {
                if (listEmployees.get(i).getID() == ID) {
                    test = true;
                }
                if (xd == listEmployees.size() || test) {
                    listEmployees.get(i).setEState(eState);
                    listEmployees.get(i).setName(name);
                    listEmployees.get(i).setLastName(lastName);
                    listEmployees.get(i).setID(ID);
                    for (int k = 0; k < listAdmins.size(); k++) {
                        if (listEmployees.get(i).getMAdmin() == listAdmins.get(k)) {
                            listAdmins.get(k).setPRef(listAdmins.get(k).getPRef() - 1);
                        }
                    }
                    listEmployees.get(i).setMAdmin(mAdmin);
                    out = true;
                }
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataEmployee();
        saveDataAdmin();
        return out;
    }

    public boolean removeEmployee(int code) throws IOException {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getPCode() == code && listEmployees.get(i).getPRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
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
    public List<Client> getClient() {
        return listClients;
    }

    public boolean addClient(String cAddress, long cPhone, String cObservations, boolean cState, Admin mcAdmin, int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) throws IOException {
        boolean out = false;
        Client newClient = new Client(cAddress, cPhone, cObservations, cState, null, 0, code++, name, lastName, ID, cAdmin);
        if (listClients.isEmpty() && !out) {
            listClients.add(newClient);
            out = true;
        } else {
            for (int i = 0; i < listClients.size() && !out; i++) {
                if (listClients.get(i).getID() != ID) {
                    int x = 0;
                    while (x<listClients.size() && newClient.compareTo(listClients.get(x))>0) {
                        x++;
                    }
                    listClients.add(x, newClient);
                    out = true;
                }
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataCode();
        saveDataClient();
        return out;
    }
    
    public void sortByName(){
        Collections.sort(listClients);
    }
    
    public boolean updateClient(int code, String cAddress, long cPhone, String cObservations, boolean cState, Admin mcAdmin, String name, String lastName, long ID) throws IOException {
        boolean out = false;
        boolean test = false;
        int xd = 0;
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getID() != ID) {
                xd++;
            }
        }
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getPCode() == code) {
                if (listClients.get(i).getID() == ID) {
                    test = true;
                }
                if (xd == listClients.size() || test) {
                    listClients.get(i).setCAddress(cAddress);
                    listClients.get(i).setCPhone(cPhone);
                    listClients.get(i).setCObservations(cObservations);
                    listClients.get(i).setCState(cState);
                    listClients.get(i).setName(name);
                    listClients.get(i).setLastName(lastName);
                    listClients.get(i).setID(ID);
                    for (int k = 0; k < listAdmins.size(); k++) {
                        if (listClients.get(i).getMcAdmin() == listAdmins.get(k)) {
                            listAdmins.get(k).setPRef(listAdmins.get(k).getPRef() - 1);
                        }
                    }
                    listClients.get(i).setMcAdmin(mcAdmin);
                    out = true;
                }

            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataClient();
        return out;
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
                return true;
            }
        }
        return false;
    }

    //Metodos relacionados con los ingredientes
    public List<Ingredient> getIngredient() {
        return listIngredients;
    }

    public void addIngredient(int iRef, int IngCode, String ingredientsName, boolean ingredientsState, Admin ciAdmin, Admin miAdmin) throws IOException {
        Ingredient newIngredient = new Ingredient(0, code++, ingredientsName, ingredientsState, ciAdmin, null);
        listIngredients.add(newIngredient);
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataIngredient();
    }

    public void updateIngredient(int code, String ingredientsName, boolean ingredientsState, Admin miAdmin) throws IOException {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngCode() == code) {
                listIngredients.get(i).setIngredientsName(ingredientsName);
                listIngredients.get(i).setIngredientsState(ingredientsState);
                for (int j = 0; j < listAdmins.size(); j++) {
                    if (listIngredients.get(i).getMiAdmin() == listAdmins.get(j)) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                    }
                }
                listIngredients.get(i).setMiAdmin(miAdmin);
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataIngredient();
    }

    public boolean removeIngredient(int code) throws IOException {
        boolean exit = false;
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngCode() == code && listIngredients.get(i).getIRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listIngredients.get(i).getCiAdmin() == listAdmins.get(j) && !out) {
                        System.out.println("Creador antes:" + listAdmins.get(j).getPRef());
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        System.out.println("Creador despues:" + listAdmins.get(j).getPRef());
                        out = true;
                    }
                    try {
                        if (listIngredients.get(i).getMiAdmin() == listAdmins.get(j) && !out1) {
                            System.out.println("Modificador antes:" + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador despues:" + listAdmins.get(j).getPRef());
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listIngredients.remove(i);
                exit = true;
            }
        }
        saveDataAdmin();
        saveDataIngredient();
        return exit;
    }

    /*
    Metodos relacionados con los tipo de productos
     */
    public List<TypeProduct> getTypeProduc() {
        return listTypeProducts;
    }

    public void addTypeProduct(int tpRef, int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) throws IOException {
        TypeProduct newTypeProduct = new TypeProduct(0, code++, typeName, typeState, ctpAdmin, mtpAdmin);
        listTypeProducts.add(newTypeProduct);
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataTypeProduct();
    }

    public void updateTypeProduct(int code, String ingredientsName, boolean ingredientsState, Admin miAdmin) throws IOException {
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == code) {
                listTypeProducts.get(i).setTypeName(ingredientsName);
                listTypeProducts.get(i).setTypeState(ingredientsState);
                for (int j = 0; j < listAdmins.size(); j++) {
                    if (listTypeProducts.get(i).getMtpAdmin() == listAdmins.get(i)) {
                        listAdmins.get(j).setPRef(listAdmins.get(i).getPRef() - 1);
                    }
                }
                listTypeProducts.get(i).setMtpAdmin(miAdmin);
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataTypeProduct();
    }

    public boolean removeTypeProduct(int code) throws IOException {
        boolean exit = false;
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == code && listTypeProducts.get(i).getTpRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listTypeProducts.get(i).getCtpAdmin() == listAdmins.get(j) && !out) {
                        System.out.println("Creador antes:" + listAdmins.get(j).getPRef());
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        System.out.println("Creador despues:" + listAdmins.get(j).getPRef());
                        out = true;
                    }
                    try {
                        if (listTypeProducts.get(i).getMtpAdmin() == listAdmins.get(j) && !out1) {
                            System.out.println("Modificador antes:" + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador despues:" + listAdmins.get(j).getPRef());
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listTypeProducts.remove(i);
                exit = true;
            }
        }
        saveDataAdmin();
        saveDataTypeProduct();
        return exit;
    }

    /*
    Metodos relacionados con los productos
     */
    public List<Product> getProduct() {
        return listProducts;
    }

    public void addProduct(int prCode, int prRef, String prName, String prSize, double prPrice, boolean prState, int prNumOrder, Admin cpAdmin, Admin mpAdmin) throws IOException {
        Product newProduct = new Product(code++, 0, prName, prSize, prPrice, prState, 0, cpAdmin, mpAdmin);
        listProducts.add(newProduct);
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataProduct();
    }

    public void updateProduct(int code, String prName, String prSize, double prPrice, boolean prState, Admin mpAdmin) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                listProducts.get(i).setpName(prName);
                listProducts.get(i).setPrSize(prSize);
                listProducts.get(i).setpPrPrice(prPrice);
                listProducts.get(i).setPrState(prState);
                for (int j = 0; j < listAdmins.size(); j++) {
                    if (listProducts.get(i).getMpAdmin() == listAdmins.get(j)) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                    }
                }
                listProducts.get(i).setMpAdmin(mpAdmin);
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        saveDataAdmin();
        saveDataProduct();
    }

    public boolean removeProduct(int code) throws IOException {
        boolean exit = false;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code && listProducts.get(i).getPrRef() == 0) {
                for (int j = 0; j < listIngredients.size(); j++) {
                    for (int k = 0; k < listProducts.get(i).getIngredientInProduct().size(); k++) {
                        if (listIngredients.get(j) == listProducts.get(i).getIngredientInProduct().get(k)) {
                            listIngredients.get(j).setIRef(listIngredients.get(j).getIRef() - 1);
                        }
                    }
                }
                for (int j = 0; j < listTypeProducts.size(); j++) {
                    for (int k = 0; k < listProducts.get(i).getTypeProductInProduct().size(); k++) {
                        if (listTypeProducts.get(j) == listProducts.get(i).getTypeProductInProduct().get(k)) {
                            listTypeProducts.get(j).setTpRef(listTypeProducts.get(j).getTpRef()-1);
                        }
                    }
                }
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listProducts.get(i).getCpAdmin() == listAdmins.get(j) && !out) {
                        System.out.println("Creador antes:" + listAdmins.get(j).getPRef());
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        System.out.println("Creador despues:" + listAdmins.get(j).getPRef());
                        out = true;
                    }
                    try {
                        if (listProducts.get(i).getMpAdmin() == listAdmins.get(j) && !out1) {
                            System.out.println("Modificador antes:" + listAdmins.get(j).getPRef());
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            System.out.println("Modificador despues:" + listAdmins.get(j).getPRef());
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listProducts.remove(i);
                exit = true;
            }
        }
        saveDataAdmin();
        saveDataIngredient();
        saveDataTypeProduct();
        saveDataProduct();
        return exit;
    }

    public void addIngredientToProduct(int code, Ingredient newIngredient) throws IOException {
        for(int i = 0; i<listProducts.size(); i++){
            if(listProducts.get(i).getPrCode() == code){
                for (int j = 0; j < listIngredients.size(); j++) {
                    if(listIngredients.get(j) == newIngredient){
                        listProducts.get(i).addIngredientInProduct(listIngredients.get(j));
                        plusIngRef(listIngredients.get(j));
                    }
                }
            }
        }
        saveDataProduct();
        saveDataIngredient();
    }
    
    public ArrayList<Ingredient> getIngredientInTheArrays(int code){
        for (int i = 0; i < listProducts.size(); i++) {
            if(listProducts.get(i).getPrCode() == code);
            return listProducts.get(i).getIngredientInProduct();
        }
        return null;
    }
    
    public void removeIngredientInP(int code, int codeI) throws IOException{
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                for (int j = 0; j < listProducts.get(i).getIngredientInProduct().size(); j++) {
                    if (listProducts.get(i).getIngredientInProduct().get(j).getIngCode() == codeI){
                        listProducts.get(i).getIngredientInProduct().remove(j);
                    }
                }
            }
        }
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngCode() == codeI) {
                listIngredients.get(i).setIRef(listIngredients.get(i).getIRef() - 1);
            }
        }
        saveDataProduct();
        saveDataIngredient();
    }
    
    public void plusIngRef(Ingredient newIngredient) throws IOException {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i) == newIngredient) {
                listIngredients.get(i).setIRef(listIngredients.get(i).getIRef() + 1);
            }
        }
        saveDataIngredient();
    }

    public void addTypeProductToProduct(int code, TypeProduct newTypeProduct) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code){
                for (int j = 0; j < listTypeProducts.size(); j++) {
                    if (listTypeProducts.get(j) == newTypeProduct){
                        listProducts.get(i).addTypeProductInProduct(listTypeProducts.get(j));
                        plusTPRef(listTypeProducts.get(j));
                    }
                }
            }
        }
        saveDataProduct();
        saveDataTypeProduct();
    }
    
    public ArrayList<TypeProduct> getTypeProductsInTheArrays(int code){
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code){
                return listProducts.get(i).getTypeProductInProduct();
            }
        }
        return null;
    }
    
    public void removeTypeProductInP(int code, int codeTP) throws IOException{
        for (int i = 0; i < listProducts.size(); i++) {
            if(listProducts.get(i).getPrCode() == code){
                for (int j = 0; j < listProducts.get(i).getTypeProductInProduct().size(); j++) {
                    if (listProducts.get(i).getTypeProductInProduct().get(j).getTpCode() == codeTP) {
                        listProducts.get(i).getTypeProductInProduct().remove(j);
                    }
                }
            }
        }
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == codeTP) {
                listTypeProducts.get(i).setTpRef(listTypeProducts.get(i).getTpRef()-1);
            }
        }
        saveDataProduct();
        saveDataIngredient();
    }
    
    public void plusTPRef(TypeProduct newTypeProduct) throws IOException{
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i) == newTypeProduct) {
                listTypeProducts.get(i).setTpRef(listTypeProducts.get(i).getTpRef()+1);
            }
        }
        saveDataTypeProduct();
    }
    
   /*
    Metodos relacionados con crear ordenes
    */
    
    public List<Order> getOrders(){
        return listOrders;
    }
    
    public void addOrder(int oCode, StatusOrder Status, Date oDate, String observatinos, boolean state, Client rClient, Employee rEmployee, Admin coAdmin, Admin moAdmin) throws IOException{
        Order newOrder = new Order(code++, Status, oDate, observatinos, state, rClient, rEmployee, coAdmin, null);
        listOrders.add(newOrder);
        for (int i = 0; i < listAdmins.size(); i++) {
            if(listAdmins.get(i) == coAdmin){
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef()+1);
            }
        }
        saveDataCode();
        saveDataAdmin();
        saveDataOrder();
    }
    
}
