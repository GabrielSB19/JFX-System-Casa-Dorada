package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javafx.stage.FileChooser;

public class CasaDorada implements Serializable {

    private static final long serialVersionUID = 1;
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

    public Admin getAdminActive() {
        return adminActive;
    }

    public List<Admin> getListAdmins() {
        return listAdmins;
    }

    public void addAdmin(String username, String password, int numOrder, boolean eState, Admin mAdmin, int pCode, String name, String lastName, long ID, Admin cAdmin) throws IOException {
        Admin newAdmin = new Admin(username, password, numOrder, true, null, 0, code++, name, lastName, ID, cAdmin);
        listAdmins.add(newAdmin);
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
            int x = 0;
            for (int i = 0; i < listEmployees.size(); i++) {
                if (listEmployees.get(i).getID() == ID) {
                    x++;
                }
            }
            if (x == 0) {
                listEmployees.add(newEmployee);
                out = true;
            } else {
                return false;
            }
            for (int i = 0; i < listAdmins.size(); i++) {
                if (listAdmins.get(i) == adminActive) {
                    listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
                }
            }
            sortNameEmployee();
        }
        return out;
    }

    public boolean uptadeEmployee(int code, boolean eState, Admin mAdmin, String name, String lastName, long ID) throws IOException {
        boolean out = false;
        boolean test = false;
        int xd = 0;
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getID() != ID) {
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
                    sortNameEmployee();
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
        return out;
    }

    public boolean removeEmployee(int code) throws IOException {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getPCode() == code && listEmployees.get(i).getPRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listEmployees.get(i).getCAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listEmployees.get(i).getMAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listEmployees.remove(i);
                return true;
            }
        }
        return false;
    }

    public void sortNameEmployee() {
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getNameLN().compareTo(e2.getNameLN());
            }
        };
        Collections.sort(listEmployees, employeeComparator);
    }

    public List<Client> getClient() {
        return listClients;
    }

    public boolean addClient(String cAddress, long cPhone, String cObservations, boolean cState, Admin mcAdmin, int pRef, int pCode, String name, String lastName, long ID, Admin cAdmin) throws IOException {
        boolean out = false;
        int n = 0;
        Client newClient = new Client(cAddress, cPhone, cObservations, cState, null, 0, code++, name, lastName, ID, cAdmin);
        if (listClients.isEmpty() && !out) {
            listClients.add(newClient);
            out = true;
        } else {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getID() == ID) {
                    n++;
                }
            }
            if (n == 0) {
                int x = 0;
                while (x < listClients.size() && newClient.compareTo(listClients.get(x)) > 0) {
                    x++;
                }
                listClients.add(x, newClient);
                out = true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        return out;
    }

    public void sortByName() {
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
        return out;
    }

    public boolean removeClient(int code) throws IOException {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getPCode() == code && listClients.get(i).getPRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listClients.get(i).getCAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listClients.get(i).getMcAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listClients.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Ingredient> getIngredient() {
        return listIngredients;
    }

    public void addIngredient(int iRef, int IngCode, String ingredientsName, boolean ingredientsState, Admin ciAdmin, Admin miAdmin) throws IOException {
        Ingredient newIngredient = new Ingredient(0, code++, ingredientsName, ingredientsState, ciAdmin, null);
        listIngredients.add(newIngredient);
        sortNameIngredient();
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
    }

    public void updateIngredient(int code, String ingredientsName, boolean ingredientsState, Admin miAdmin) throws IOException {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngCode() == code) {
                listIngredients.get(i).setIngredientsName(ingredientsName);
                sortNameIngredient();
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
    }

    public boolean removeIngredient(int code) throws IOException {
        boolean exit = false;
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngCode() == code && listIngredients.get(i).getIRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listIngredients.get(i).getCiAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listIngredients.get(i).getMiAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
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
        return exit;
    }

    public void sortNameIngredient() {
        Comparator<Ingredient> ingredientComparator = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return i1.getIngredientsName().compareTo(i2.getIngredientsName());
            }
        };
        Collections.sort(listIngredients, ingredientComparator);
    }

    public List<TypeProduct> getTypeProduc() {
        return listTypeProducts;
    }

    public void addTypeProduct(int tpRef, int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) throws IOException {
        TypeProduct newTypeProduct = new TypeProduct(0, code++, typeName, typeState, ctpAdmin, mtpAdmin);
        listTypeProducts.add(newTypeProduct);
        sortNameTP();
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
    }

    public void updateTypeProduct(int code, String tpName, boolean tpState, Admin miAdmin) throws IOException {
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == code) {
                listTypeProducts.get(i).setTypeName(tpName);
                sortNameTP();
                listTypeProducts.get(i).setTypeState(tpState);
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
    }

    public boolean removeTypeProduct(int code) throws IOException {
        boolean exit = false;
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == code && listTypeProducts.get(i).getTpRef() == 0) {
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listTypeProducts.get(i).getCtpAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listTypeProducts.get(i).getMtpAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
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
        return exit;
    }

    public void sortNameTP() {
        Comparator<TypeProduct> tpComparator = new Comparator<TypeProduct>() {
            @Override
            public int compare(TypeProduct tp1, TypeProduct tp2) {
                return tp1.getTypeName().compareTo(tp2.getTypeName());
            }
        };
        Collections.sort(listTypeProducts, tpComparator);
    }

    public List<Product> getProduct() {
        return listProducts;
    }

    public void addProduct(int prCode, int prRef, String prName, String prSize, double prPrice, boolean prState, int prNumOrder, Admin cpAdmin, Admin mpAdmin) throws IOException {
        Product newProduct = new Product(code++, 0, prName, prSize, prPrice, prState, 0, cpAdmin, mpAdmin);
        listProducts.add(newProduct);
        sortPriceProduct();
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
    }

    public void sortPriceProduct() {
        for (int i = 1; i < listProducts.size(); i++) {
            for (int j = 0; j < listProducts.size() - i; j++) {
                if (listProducts.get(j).getPrPrice() > listProducts.get(j + 1).getPrPrice()) {
                    Product temp = listProducts.get(j);
                    listProducts.set(j, listProducts.get(j + 1));
                    listProducts.set(j + 1, temp);
                }
            }
        }
    }

    public void updateProduct(int code, String prName, String prSize, double prPrice, boolean prState, Admin mpAdmin) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                listProducts.get(i).setpName(prName);
                listProducts.get(i).setPrSize(prSize);
                listProducts.get(i).setpPrPrice(prPrice);
                sortPriceProduct();
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
                            listTypeProducts.get(j).setTpRef(listTypeProducts.get(j).getTpRef() - 1);
                        }
                    }
                }
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listProducts.get(i).getCpAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listProducts.get(i).getMpAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
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
        return exit;
    }

    public void addIngredientToProduct(int code, Ingredient newIngredient) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                for (int j = 0; j < listIngredients.size(); j++) {
                    if (listIngredients.get(j).getIngCode() == newIngredient.getIngCode()) {
                        listProducts.get(i).addIngredientInProduct(listIngredients.get(j));
                        plusIngRef(listIngredients.get(j));
                    }
                }
            }
        }
    }

    public void removeIngredientInP(int code, int codeI) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                for (int j = 0; j < listProducts.get(i).getIngredientInProduct().size(); j++) {
                    if (listProducts.get(i).getIngredientInProduct().get(j).getIngCode() == codeI) {
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
    }

    public void plusIngRef(Ingredient newIngredient) throws IOException {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i) == newIngredient) {
                listIngredients.get(i).setIRef(listIngredients.get(i).getIRef() + 1);
            }
        }
    }

    public void addTypeProductToProduct(int code, TypeProduct newTypeProduct) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                for (int j = 0; j < listTypeProducts.size(); j++) {
                    if (listTypeProducts.get(j) == newTypeProduct) {
                        listProducts.get(i).addTypeProductInProduct(listTypeProducts.get(j));
                        plusTPRef(listTypeProducts.get(j));
                    }
                }
            }
        }
    }
    
    public void removeTypeProductInP(int code, int codeTP) throws IOException {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == code) {
                for (int j = 0; j < listProducts.get(i).getTypeProductInProduct().size(); j++) {
                    if (listProducts.get(i).getTypeProductInProduct().get(j).getTpCode() == codeTP) {
                        listProducts.get(i).getTypeProductInProduct().remove(j);
                    }
                }
            }
        }
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTpCode() == codeTP) {
                listTypeProducts.get(i).setTpRef(listTypeProducts.get(i).getTpRef() - 1);
            }
        }
    }

    public void plusTPRef(TypeProduct newTypeProduct) throws IOException {
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i) == newTypeProduct) {
                listTypeProducts.get(i).setTpRef(listTypeProducts.get(i).getTpRef() + 1);
            }
        }
    }

    public List<Order> getOrders() {
        return listOrders;
    }

    public void addOrder(int oCode, StatusOrder Status, Date oDate, String observatinos, boolean state, Client rClient, Employee rEmployee, Admin coAdmin, Admin moAdmin) throws IOException {
        Order newOrder = new Order(code++, Status, oDate, observatinos, state, null, rEmployee, coAdmin, null);
        listOrders.add(newOrder);
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == coAdmin) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i) == rEmployee) {
                listEmployees.get(i).setPRef(listEmployees.get(i).getPRef() + 1);
            }
        }

    }

    @SuppressWarnings("null")
    public List<Client> binaryClient(List<Client> preSelect, boolean out, String name) {
        sortByName();
        List<Client> selectedClient = new ArrayList<>();
        if (out) {
            for (int i = 0; i < preSelect.size(); i++) {
                if (preSelect.get(i).getName().equalsIgnoreCase(name)) {
                    selectedClient.add(preSelect.get(i));
                }
            }
        } else {
            sortID(preSelect);
            long Id = Long.parseLong(name);
            int pos = -1;
            int i = 0;
            int j = preSelect.size() - 1;
            while (i <= j && pos < 0) {
                int m = (i + j) / 2;
                if (preSelect.get(m).getID() == Id) {
                    selectedClient.add(preSelect.get(m));
                    pos = m;
                } else if (preSelect.get(m).getID() > Id) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return selectedClient;
    }

    public void sortID(List<Client> preSelect) {
        for (int i = 1; i < preSelect.size(); i++) {
            for (int j = i; j > 0 && preSelect.get(j - 1).getID() > preSelect.get(j).getID(); j--) {
                Client temp = preSelect.get(i);
                preSelect.set(j, preSelect.get(j - 1));
                preSelect.set(j - 1, temp);

            }
        }
    }

    public List<Client> removeDeshabiltyClient(List<Client> listClients) {
        ArrayList<Client> removeClientD = new ArrayList<>();
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCState()) {
                removeClientD.add(listClients.get(i));
            }
        }
        return removeClientD;
    }

    public void plusInClient(Client client) {
        for (int i = 0; i < listClients.size(); i++) {
            if (client == listClients.get(i)) {
                listClients.get(i).setPRef(listClients.get(i).getPRef() + 1);
            }
        }
    }

    public void removeClientInOrder(int code, int codeCOS) {
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getCode() == code) {
                if (listOrders.get(i).getrClient().getPCode() == codeCOS) {
                    listOrders.get(i).setrClient(null);
                }
            }
        }
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getPCode() == codeCOS) {
                listClients.get(i).setPRef(listClients.get(i).getPRef() - 1);
            }
        }
    }

    public void addProductInOrder(int code, int newProductCode, int amount) {
        Product productSelected = null;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == newProductCode) {
                productSelected = new Product(listProducts.get(i).getPrCode(), 0, listProducts.get(i).getPrName(), listProducts.get(i).getPrSize(), listProducts.get(i).getPrPrice(),
                        listProducts.get(i).getPrState(), 0, listProducts.get(i).getCpAdmin(), listProducts.get(i).getMpAdmin());
            }
        }
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getCode() == code) {
                for (int j = 0; j < listProducts.size(); j++) {
                    if (listProducts.get(j).getPrCode() == productSelected.getPrCode()) {
                        int x = 0;
                        for (int k = 0; k < listOrders.get(i).getProducts().size(); k++) {
                            if (listOrders.get(i).getProducts().get(k).getPrCode() == productSelected.getPrCode()) {
                                x++;
                            }
                        }
                        if (x == 0) {
                            listOrders.get(i).addProductInOrder(productSelected);
                        }
                        for (int k = 0; k < listOrders.get(i).getProducts().size(); k++) {
                            if (listOrders.get(i).getProducts().get(k).getPrCode() == productSelected.getPrCode()) {
                                listOrders.get(i).getProducts().get(k).setPrNumOrder(amount);
                            }
                        }
                        plusProductToOrder(listProducts.get(j));
                    }
                }
            }
        }
    }

    public void plusProductToOrder(Product plusProduct) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i) == plusProduct) {
                listProducts.get(i).setPrRef(listProducts.get(i).getPrRef() + 1);
            }
        }
    }

    public void removeProductInOrder(int code, int codePO) {
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getCode() == code) {
                for (int j = 0; j < listOrders.get(i).getProducts().size(); j++) {
                    if (listOrders.get(i).getProducts().get(j).getPrCode() == codePO) {
                        listOrders.get(i).getProducts().remove(j);
                    }
                }
            }
        }
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrCode() == codePO) {
                listProducts.get(i).setPrRef(listProducts.get(i).getPrRef() - 1);
            }
        }
    }

    public void updateOrder(int code, StatusOrder status, String observations, boolean state, Employee rEmployee, Admin coAdmin) {
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getCode() == code) {
                listOrders.get(i).setStatus(status);
                listOrders.get(i).setObservatinos(observations);
                listOrders.get(i).setState(state);
                for (int j = 0; j < listEmployees.size(); j++) {
                    if (listEmployees.get(j) == listOrders.get(i).getrEmployee()) {
                        listEmployees.get(j).setPRef(listEmployees.get(j).getPRef() - 1);
                    }
                }
                listOrders.get(i).setrEmployee(rEmployee);
                for (int j = 0; j < listEmployees.size(); j++) {
                    if (listOrders.get(i).getrEmployee() == listEmployees.get(j)) {
                        listEmployees.get(j).setPRef(listEmployees.get(j).getPRef() + 1);
                    }
                }
                for (int j = 0; j < listAdmins.size(); j++) {
                    if (listOrders.get(i).getCoAdmin() == listAdmins.get(j)) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                    }
                }
                listOrders.get(i).setMoAdmin(coAdmin);
            }
        }
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i) == adminActive) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
            }
        }
    }

    public void removeOrder(int code) {
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getCode() == code) {
                for (int j = 0; j < listProducts.size(); j++) {
                    for (int k = 0; k < listOrders.get(i).getProducts().size(); k++) {
                        if (listProducts.get(j) == listOrders.get(i).getProducts().get(k)) {
                            listProducts.get(j).setPrRef(listProducts.get(j).getPrRef() - 1);
                        }
                    }
                }
                try {
                    for (int j = 0; j < listClients.size(); j++) {
                        if (listOrders.get(i).getrClient().getPCode() == listClients.get(j).getPCode()) {
                            listClients.get(j).setPRef(listClients.get(j).getPRef() - 1);
                        }
                    }
                } catch (NullPointerException e) {
                }
                for (int j = 0; j < listEmployees.size(); j++) {
                    if (listOrders.get(i).getrEmployee().getPCode() == listEmployees.get(j).getPCode()) {
                        listEmployees.get(j).setPRef(listEmployees.get(j).getPRef() - 1);
                    }
                }
                boolean out = false;
                boolean out1 = false;
                for (int j = 0; j < listAdmins.size() && !(out && out1); j++) {
                    if (listOrders.get(i).getCoAdmin() == listAdmins.get(j) && !out) {
                        listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                        out = true;
                    }
                    try {
                        if (listOrders.get(i).getMoAdmin() == listAdmins.get(j) && !out1) {
                            listAdmins.get(j).setPRef(listAdmins.get(j).getPRef() - 1);
                            out1 = true;
                        }
                    } catch (Exception e) {
                        out1 = true;
                    }
                }
                listOrders.remove(i);
            }
        }
    }

    public File fileChooser() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open File Client");
        File file = fc.showOpenDialog(null);
        return file;
    }

    public boolean importClient() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                addClient(parts[3], Long.parseLong(parts[4]), parts[5], true, null, 0, code, parts[0], parts[1], Long.parseLong(parts[2]), adminActive);
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Date convertToHour(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    public StatusOrder checkStatus(String msg) {
        switch (msg) {
            case "SOLICITADO":
                return StatusOrder.SOLICITADO;
            case "EN_PROCESO":
                return StatusOrder.EN_PROCESO;
            case "ENTREGADO":
                return StatusOrder.ENTREGADO;
            case "ENVIADO":
                return StatusOrder.ENVIADO;
            default:
                //Nunca entra
                return StatusOrder.EN_PROCESO;
        }
    }

    private int indexExistClient;
    private int indexExistEmployee;

    public boolean checkClient(long id) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getID() == id) {
                listClients.get(i).setPRef(listClients.get(i).getPRef() + 1);
                indexExistClient = i;
                return true;
            }
        }
        return false;
    }

    public boolean checkEmployee(long id) {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getID() == id) {
                listEmployees.get(i).setPRef(listEmployees.get(i).getPRef() + 1);
                listEmployees.get(i).setNumOrder(listEmployees.get(i).getNumOrder() + 1);
                indexExistEmployee = i;
                return true;
            }
        }
        return false;
    }

    private int indexExistProduct;

    public boolean checkProduct(String msg) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrName().equalsIgnoreCase(msg)) {
                listProducts.get(i).setPrRef(listProducts.get(i).getPrRef() + 1);
                listProducts.get(i).setPrNumOrder(listProducts.get(i).getPrNumOrder() + 1);
                indexExistProduct = i;
                return true;
            }
        }
        return false;
    }

    public boolean importPedido() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                boolean clientCheck = checkClient(Long.parseLong(parts[4]));
                boolean employeeCheck = checkEmployee(Long.parseLong(parts[10]));
                boolean productCheck = checkProduct(parts[11]);
                listOrders.add(new Order(code++, checkStatus(parts[0]), convertToHour(LocalDateTime.now()),
                        parts[1], true, null, null, adminActive, null));
                plusAdminRef();
                //client, employee
                if (clientCheck && employeeCheck) {
                    listOrders.get(listOrders.size() - 1).setrClient(listClients.get(indexExistClient));
                    listOrders.get(listOrders.size() - 1).setrEmployee(listEmployees.get(indexExistEmployee));
                    if (productCheck) {
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(indexExistProduct));
                    } else {
                        listProducts.add(new Product(code++, 1, parts[11], parts[12], Double.parseDouble(parts[13]), true, 1, adminActive, null));
                        plusAdminRef();
                        listIngredients.add(new Ingredient(1, code++, parts[14], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addIngredientInProduct(listIngredients.get(listIngredients.size() - 1));
                        listTypeProducts.add(new TypeProduct(1, code++, parts[15], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addTypeProductInProduct(listTypeProducts.get(listTypeProducts.size() - 1));
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(listProducts.size() - 1));
                    }
                } else if (clientCheck && !employeeCheck) {
                    listOrders.get(listOrders.size() - 1).setrClient(listClients.get(indexExistClient));
                    listEmployees.add(new Employee(1, true, null, 1, code++, parts[8], parts[9], Long.parseLong(parts[10]), adminActive));
                    plusAdminRef();
                    listOrders.get(listOrders.size() - 1).setrEmployee(listEmployees.get(listEmployees.size() - 1));
                    if (productCheck) {
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(indexExistProduct));
                    } else {
                        listProducts.add(new Product(code++, 1, parts[11], parts[12], Double.parseDouble(parts[13]), true, 1, adminActive, null));
                        plusAdminRef();
                        listIngredients.add(new Ingredient(1, code++, parts[14], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addIngredientInProduct(listIngredients.get(listIngredients.size() - 1));
                        listTypeProducts.add(new TypeProduct(1, code++, parts[15], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addTypeProductInProduct(listTypeProducts.get(listTypeProducts.size() - 1));
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(listProducts.size() - 1));
                    }
                } else if (!clientCheck && employeeCheck) {
                    listClients.add(new Client(parts[5], Long.parseLong(parts[6]), parts[7], true, null, 1, code++, parts[2], parts[3], Long.parseLong(parts[4]), adminActive));
                    plusAdminRef();
                    listOrders.get(listOrders.size() - 1).setrClient(listClients.get(listClients.size() - 1));
                    listOrders.get(listOrders.size() - 1).setrEmployee(listEmployees.get(indexExistEmployee));
                    if (productCheck) {
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(indexExistProduct));
                    } else {
                        listProducts.add(new Product(code++, 1, parts[11], parts[12], Double.parseDouble(parts[13]), true, 1, adminActive, null));
                        plusAdminRef();
                        listIngredients.add(new Ingredient(1, code++, parts[14], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addIngredientInProduct(listIngredients.get(listIngredients.size() - 1));
                        listTypeProducts.add(new TypeProduct(1, code++, parts[15], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addTypeProductInProduct(listTypeProducts.get(listTypeProducts.size() - 1));
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(listProducts.size() - 1));
                    }
                } else {
                    listClients.add(new Client(parts[5], Long.parseLong(parts[6]), parts[7], true, null, 1, code++, parts[2], parts[3], Long.parseLong(parts[4]), adminActive));
                    plusAdminRef();
                    listOrders.get(listOrders.size() - 1).setrClient(listClients.get(listClients.size() - 1));
                    listEmployees.add(new Employee(1, true, null, 1, code++, parts[8], parts[9], Long.parseLong(parts[10]), adminActive));
                    plusAdminRef();
                    listOrders.get(listOrders.size() - 1).setrEmployee(listEmployees.get(listEmployees.size() - 1));
                    if (productCheck) {
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(indexExistProduct));
                    } else {
                        listProducts.add(new Product(code++, 1, parts[11], parts[12], Double.parseDouble(parts[13]), true, 1, adminActive, null));
                        plusAdminRef();
                        listIngredients.add(new Ingredient(1, code++, parts[14], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addIngredientInProduct(listIngredients.get(listIngredients.size() - 1));
                        listTypeProducts.add(new TypeProduct(1, code++, parts[15], true, adminActive, null));
                        plusAdminRef();
                        listProducts.get(listProducts.size() - 1).addTypeProductInProduct(listTypeProducts.get(listTypeProducts.size() - 1));
                        listOrders.get(listOrders.size() - 1).getProducts().add(listProducts.get(listProducts.size() - 1));
                    }
                }
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void plusAdminRef() {
        boolean out = false;
        for (int i = 0; i < listAdmins.size() && !out; i++) {
            if (listAdmins.get(i).getPCode() == adminActive.getPCode()) {
                listAdmins.get(i).setPRef(listAdmins.get(i).getPRef() + 1);
                out = true;
            }
        }
    }

    private int indexExistIngredient;
    private int indexExistTypeIngredient;

    public boolean checkIngredient(String msg) {
        for (int i = 0; i < listIngredients.size(); i++) {
            if (listIngredients.get(i).getIngredientsName().equalsIgnoreCase(msg)) {
                listIngredients.get(i).setIRef(listIngredients.get(i).getIRef() + 1);
                indexExistIngredient = i;
                return true;
            }
        }
        return false;
    }

    public boolean checkTypeIngredient(String msg) {
        for (int i = 0; i < listTypeProducts.size(); i++) {
            if (listTypeProducts.get(i).getTypeName().equalsIgnoreCase(msg)) {
                listTypeProducts.get(i).setTpRef(listTypeProducts.get(i).getTpRef() + 1);
                indexExistTypeIngredient = i;
                return true;
            }
        }
        return false;
    }

    public boolean importProduct() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                boolean ingredientCheck = checkIngredient(parts[3]);
                boolean typeCheck = checkTypeIngredient(parts[2]);
                listProducts.add(new Product(code++, 0, parts[1], parts[4],
                        Double.parseDouble(parts[0]), true, 0, adminActive, null));
                plusAdminRef();
                if (ingredientCheck && typeCheck) {
                    listProducts.get(listProducts.size() - 1).getIngredientInProduct().add(listIngredients.get(indexExistIngredient));
                    listProducts.get(listProducts.size() - 1).getTypeProductInProduct().add(listTypeProducts.get(indexExistTypeIngredient));
                } else if (!ingredientCheck && typeCheck) {
                    listIngredients.add(new Ingredient(1, code++, parts[3], true, adminActive, null));
                    plusAdminRef();
                    listProducts.get(listProducts.size() - 1).getIngredientInProduct().add(listIngredients.get(listIngredients.size() - 1));
                    listProducts.get(listProducts.size() - 1).getTypeProductInProduct().add(listTypeProducts.get(indexExistTypeIngredient));
                } else if (ingredientCheck && !typeCheck) {
                    listTypeProducts.add(new TypeProduct(1, code++, parts[2], true, adminActive, null));
                    plusAdminRef();
                    listProducts.get(listProducts.size() - 1).getIngredientInProduct().add(listIngredients.get(indexExistIngredient));
                    listProducts.get(listProducts.size() - 1).getTypeProductInProduct().add(listTypeProducts.get(listTypeProducts.size() - 1));
                } else {
                    listIngredients.add(new Ingredient(1, code++, parts[3], true, adminActive, null));
                    plusAdminRef();
                    listTypeProducts.add(new TypeProduct(1, code++, parts[2], true, adminActive, null));
                    plusAdminRef();
                    listProducts.get(listProducts.size() - 1).getIngredientInProduct().add(listIngredients.get(listIngredients.size() - 1));
                    listProducts.get(listProducts.size() - 1).getTypeProductInProduct().add(listTypeProducts.get(listTypeProducts.size() - 1));
                }
                line = br.readLine();
            }
            sortPriceProduct();
            sortNameIngredient();
            sortNameTP();
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void exportDataOrder(String filename, Date initial, Date end, String sep) throws FileNotFoundException {
        String test = "";
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Fecha" + sep + "Estado" + sep + "Nombre del cliente" + sep + "Direccion" + sep + "Telefono" + sep + "Empleado" + sep + "Observaciones" + sep + "Valor total" + sep + "Producto");
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getState()) {
                if (listOrders.get(i).getODate().compareTo(initial) >= 0 && listOrders.get(i).getODate().compareTo(end) <= 0) {
                    for (int j = 0; j < listOrders.get(i).getProducts().size(); j++) {
                        test += listOrders.get(i).getProducts().get(j).getPrName() + " " + listOrders.get(i).getProducts().get(j).getPrNumOrder() + " " + listOrders.get(i).getProducts().get(j).getPrPrice();
                    }
                    pw.println(listOrders.get(i).getODate() + sep + listOrders.get(i).getStatus() + sep + listOrders.get(i).getrClient().getNameLN() + sep
                            + listOrders.get(i).getrClient().getCAddress() + sep + listOrders.get(i).getrClient().getCPhone() + sep + listOrders.get(i).getrEmployee().getNameLN()
                            + sep + listOrders.get(i).getObservatinos() + sep + listOrders.get(i).getValueOrder() + sep + test);
                    test = "";
                }
            }
        }
        pw.close();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void exportDataProduct(String filename, Date initial, Date end, String sep) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Nombre del producto" + sep + "Tamanio" + sep + "Precio" + sep + "Cantidad pedida" + sep + "PagoTotal");
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getState()) {
                if (listOrders.get(i).getStatus() == StatusOrder.ENTREGADO) {
                    if (listOrders.get(i).getODate().compareTo(initial) >= 0 && listOrders.get(i).getODate().compareTo(end) <= 0) {
                        for (int j = 0; j < listOrders.get(i).getProducts().size(); j++) {
                            pw.println(listOrders.get(i).getProducts().get(j).getPrName() + sep + listOrders.get(i).getProducts().get(j).getPrSize() + sep
                                    + listOrders.get(i).getProducts().get(j).getPrPrice() + sep + listOrders.get(i).getProducts().get(j).getPrNumOrder() + sep
                                    + (listOrders.get(i).getProducts().get(j).getPrNumOrder() * listOrders.get(i).getProducts().get(j).getPrPrice()));
                        }
                    }
                }

            }
        }
        pw.print(3);
        pw.close();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void exportEmployee(String filename, Date initial, Date end, String sep) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Nombre" + sep + "Apellido" + sep + "Identificiacion" + sep + "Numero de pedidos" + sep + "Valor pedidos");
        ArrayList<Order> ordersExport = new ArrayList<>();
        for (int i = 0; i < listOrders.size(); i++) {
            if (listOrders.get(i).getState()) {
                if (listOrders.get(i).getStatus() == StatusOrder.ENTREGADO) {
                    if (listOrders.get(i).getODate().compareTo(initial) >= 0 && listOrders.get(i).getODate().compareTo(end) <= 0) {
                        ordersExport.add(listOrders.get(i));
                    }
                }
            }
        }
        ArrayList<Employee> employeesDisp = new ArrayList<>();
        for (int i = 0; i < ordersExport.size(); i++) {
            employeesDisp.add(ordersExport.get(i).getrEmployee());
        }
        HashSet hs = new HashSet();
        hs.addAll(employeesDisp);
        employeesDisp.clear();
        employeesDisp.addAll(hs);
        int[] newAmount = new int[employeesDisp.size()];
        double[] newPrice = new double[employeesDisp.size()];
        int x = 0;
        double c = 0;
        for (int i = 0; i < employeesDisp.size(); i++) {
            for (int j = 0; j < ordersExport.size(); j++) {
                if (employeesDisp.get(i) == ordersExport.get(j).getrEmployee()) {
                    x++;
                    c += Double.parseDouble(ordersExport.get(j).getValueOrder());
                }
            }
            newAmount[i] = x;
            newPrice[i] = c;
            c = 0;
            x = 0;
        }
        for (int i = 0; i < employeesDisp.size(); i++) {
            pw.println(employeesDisp.get(i).getName() + sep + employeesDisp.get(i).getLastName() + sep + employeesDisp.get(i).getID()
                    + sep + newAmount[i] + sep + newPrice[i]);
        }
        pw.print(2);
        pw.close();
    }
}
