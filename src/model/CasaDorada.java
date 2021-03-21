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
    private final String SAVE_PATH_FILE_TYPEPRODUCT = "data/TypeProduc.cgd";
    private final String SAVE_PATH_FILE_PRODUCT = "data/Product.cgd";
    
    private List<Admin> listAdmins;
    private List<Client> listClients;
    private List<Employee> listEmployees;
    private List<Ingredient> listIngredients;
    private List<Order> listOrders;
    private List<Product> listProducts;
    private List<TypeProduct> listTypeProducts;
    private Admin adminActive;
    //private Admin adminSelected;
    //private Ingredient ingredientSelected;
    //private TypeProduct typeProductSelected;
    //private Client clientSelected;
    //private Employee employeeSelected;
    
    public CasaDorada() {
        listAdmins = new ArrayList<>();
        listClients = new ArrayList<>();
        listEmployees = new ArrayList<>();
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
    
    //Cargar lista de Cliente
    
    public void loadDataClient() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_CLIENT)));
            listClients = (List) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Cargar lista de Empleado
    public void loadDataEMmployee() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE_EMPLOYEE)));
            listEmployees = (List) ois.readObject();
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
    
    //Guardar lista de Clientes
    
    public void saveDataClient() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENT));
        oos.writeObject(listClients);
        oos.close();
    }
    
    //Guardar lista de Empleados
    
    public void saveDataEmployee() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_EMPLOYEE));
        oos.writeObject(listEmployees);
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
        oos.writeObject(listProducts);
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
    
    public List<Admin> getAdmin(){
        return listAdmins;
    }
    
            /*
        Metodos relacionados con los clientes
        */
    public void addClient(String cAddress, int cPhone, String cObservations, boolean cState, Admin mcAdmin,
            String name, String lastName, int ID, Admin cAdmin) throws IOException{
        
        Client newClient = new Client(cAddress, cPhone, cObservations, cState, mcAdmin,
            name, lastName, ID, cAdmin);
        
        listClients.add(newClient);
        saveDataClient();
    }
    
    public List<Client> getClient(){
        return listClients;
    }
    
            /*
        Metodos relacionados con los Empleados
        */
    
    public void addEmployee(int numOrder, boolean eState, Admin mAdmin, String name, String lastName,
            int ID, Admin cAdmin) throws IOException{
        
        Employee newEmployee = new Employee(numOrder, eState, mAdmin, name, lastName,
            ID, cAdmin);
        
        listEmployees.add(newEmployee);
        saveDataEmployee();
    }
    
    public List<Employee> getEmployee(){
        return listEmployees;
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
    
    public List<Ingredient> getIngredient(){
        return listIngredients;
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
    
    public List<TypeProduct> getTypeProduc(){
        return listTypeProducts;
    }
    
        /*
        Metodos relacionados con los productos
        */
    
            //Agregar Producto
    
    public void addProduct(int pCode, String pName, String pSize, double pPrice, boolean pState, int pNumOrder, Admin cpAdmin, Admin mpAdmin) throws IOException{
        Product newProduct = new Product(pCode, pName, pSize, pPrice, pState, pNumOrder, cpAdmin, mpAdmin);
        listProducts.add(newProduct);
        saveDataProduct();
    }
    
    Ingredient ingredientInProduct;
    
    public Ingredient addIngredientToProduct(Ingredient ingredientSelect){
        if(ingredientSelect != null){
            ingredientInProduct = ingredientSelect;
            return ingredientInProduct;
        } else {
            return null;    
        }
    }
    
    public void addIngredientToProductArray(ArrayList<Ingredient> ingredients){
        int index = listProducts.size()-1;
        listProducts.get(index).setIngredientInProduct(ingredients);
    }
    
    public List<Product> getProduct(){
        return listProducts;
    }
    
        
    public boolean login(String username, String password){
        for (int i = 0; i < listAdmins.size(); i++) {
            if (listAdmins.get(i).getUsername().equals(username) && listAdmins.get(i).getPassword().equals(password)) {
                adminActive = listAdmins.get(i);
                return true;
            }
        }
        return false;
    }
    
    public Admin getAdminActive(){
        return adminActive;
    }
    
    private int adminIndex;
    
    public int getAdminIndex(){
        return adminIndex;
    }
    
    public void selectedAdmin(Admin adminNew){
        for(int i = 0; i<listAdmins.size(); i++){
            if(listAdmins.get(i) == adminNew){
                adminIndex = i; 
                //adminSelected = adminNew;
            }
        }
    }

    public void setNewAdmin(Admin newAdmin) throws IOException{
        listAdmins.set(adminIndex, newAdmin);
        saveDataAdmin();
    }
            
    public void removeAdmin(int indexAdmin) throws IOException{
        listAdmins.remove(indexAdmin);
        saveDataAdmin();
    }
    
    private int ingredientIndex;
    
    public int getIngredientIndex(){
        return ingredientIndex;
    }
    
    public void selectedIngredient(Ingredient ingredientNew){
        for(int i = 0; i<listIngredients.size(); i++){
            if(listIngredients.get(i) == ingredientNew){
                ingredientIndex = i;
                //ingredientSelected = ingredientNew;
            }
        }
    }
    
    public void setNewIngredient(Ingredient newIngredient) throws IOException{
        listIngredients.set(ingredientIndex, newIngredient);
        saveDataIngredient();
    }
    
                
    public void removeIngredient(int indexIngredient) throws IOException{
        listIngredients.remove(indexIngredient);
        saveDataIngredient();
    }
    
    private int typeProductIndex;
    
    public int getTypeProductIndex(){
        return typeProductIndex;
    }
    
    private int productIndex;
    public void selectedProduct(Product productNew) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i) == productNew) {
                productIndex = i;
            }
        }
    }
    
    public void selectedTypeIngredient(TypeProduct typeProductNew){
        for(int i = 0; i<listTypeProducts.size(); i++){
            if(listTypeProducts.get(i) == typeProductNew){
                typeProductIndex = i;
                //typeProductSelected = typeProductNew;
            }
        }
    }
    
    public void setNewTypeProduct(TypeProduct newTypeProduct) throws IOException{
        listTypeProducts.set(typeProductIndex, newTypeProduct);
        saveDataTypeProduct();
    }
                
    public void removeTypeProduct(int indexTypeProduct) throws IOException{
        listTypeProducts.remove(indexTypeProduct);
        saveDataTypeProduct();
    }
    
    private int employeeIndex;
    
    public int getEmployeeIndex(){
        return employeeIndex;
    }
    
    public void selectedEmployee(Employee employeeNew){
        for(int i = 0; i<listEmployees.size(); i++){
            if(listEmployees.get(i) == employeeNew){
                employeeIndex = i;
            }
        }
    }
    
    public void setNewEmployee(Employee newEmployee) throws IOException{
        listEmployees.set(employeeIndex, newEmployee);
        saveDataEmployee();
    }
                
    public void removeEmployee(int indexEmployee) throws IOException{
        listEmployees.remove(indexEmployee);
        saveDataEmployee();
    }
    
    private int clientIndex;
    
    public int getClientIndex(){
        return clientIndex;
    }
    
    public void selectedClient(Client clientNew){
        for(int i = 0; i<listClients.size(); i++){
            if(listClients.get(i) == clientNew){
                clientIndex = i;
            }
        }
    }
    
    public void setNewClient(Client newClient) throws IOException{
        listClients.set(clientIndex, newClient);
        saveDataClient();
    }
    
    public void removeClient(int indexClient) throws IOException{
        listClients.remove(indexClient);
        saveDataClient();
    }
    
    private TypeProduct typeProductInProduct;

    public TypeProduct addTypeProductToProduct(TypeProduct typeProductSelect) {
        if (typeProductSelect != null) {
            typeProductInProduct = typeProductSelect;
            return typeProductInProduct;
        } else {
            return null;
        }
    }

    public void addTypeProductToProductArray(ArrayList<TypeProduct> typeProducts) {
        int index = listProducts.size() - 1;
        listProducts.get(index).setTypeProductInProduct(typeProducts);
    }
}
