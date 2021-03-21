package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class FXControllerGUI implements Initializable {

    //Atributos para el funcionamiento de SplashScreen
    
    public static ImageView imageView;

    private CasaDorada casaDorada;

    public static Timeline timeline;

    @FXML
    public JFXSpinner jfxSpinner;

    @FXML
    private ImageView ivWelcome;

    //Pantalla para las advertencias
    
    @FXML
    private StackPane stackPane;

    //Primera Pantalla (Login)
    
    @FXML
    private BorderPane bpMain;

    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;

    //Pantalla de registrarse
    
    @FXML
    private JFXTextField txtRegisterName;

    @FXML
    private JFXTextField txtRegisterLastName;

    @FXML
    private JFXTextField txtRegisterID;

    @FXML
    private JFXTextField txtRegisterUserName;

    @FXML
    private JFXPasswordField txtRegisterPassword;

    //Atribtuos del Menu
    
        //Atribtuos generales
    
    @FXML
    private ImageView ivGoldHouse;

    @FXML
    private BorderPane bpMenu;

    @FXML
    private Pane pNewOption;
    
        //Atributos para gestionar los Admin
    
     @FXML
    private JFXTextField txtNameAdmin;

    @FXML
    private JFXTextField txtLastNameAdmin;

    @FXML
    private JFXTextField txtIDAdmin;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;
    
    @FXML
    private JFXToggleButton tbStateUserName;
    
    @FXML
    private TableView<Admin> tblAdmin;

    @FXML
    private TableColumn<Admin, String> tblAdminName;

    @FXML
    private TableColumn<Admin, String> tblAdminLastName;

    @FXML
    private TableColumn<Admin, Integer> tblAdminID;

    @FXML
    private TableColumn<Admin, String> tblAdminUserName;

    @FXML
    private TableColumn<Admin, Boolean> tblAdminState;
    
        //Atributos para gestionar los Empleados
    
    @FXML
    private JFXTextField txtEmpName;

    @FXML
    private JFXTextField txtEmpLastName;

    @FXML
    private JFXTextField txtEmpID;

    @FXML
    private JFXToggleButton tbStateEmployee;
    
    @FXML
    private JFXButton btnAddEmployee;
    
    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TableColumn<Employee, String> tblEmployeeName;

    @FXML
    private TableColumn<Employee, String> tblEmployeeLastName;

    @FXML
    private TableColumn<Employee, Integer> tblEmployeeID;

    @FXML
    private TableColumn<Employee, Boolean> tblEmployeeState;

         //Atributos para gestionar los ingredients
    
    @FXML
    private JFXTextField txtIngName;
    
    @FXML
    private JFXToggleButton tbStateIngredients;
    
    @FXML
    private JFXButton btnAddIngredient;

    @FXML
    private TableView<Ingredient> tblIngredient;

    @FXML
    private TableColumn<Ingredient, String> tblIngredientNameGestion;

    @FXML
    private TableColumn<Ingredient, Boolean> tblIngredientState;
    

         //Atribtuos para gestionar los tipo de ingrediente
    
    @FXML
    private JFXTextField txtTpName;
    
    @FXML
    private JFXToggleButton tbStateTypeProduct;
    
    @FXML
    private JFXButton btnAddTypeProduct;
    
     @FXML
    private TableView<TypeProduct> tblTypeProduct;

    @FXML
    private TableColumn<TypeProduct, String> tblTypeProductNameGestion;

    @FXML
    private TableColumn<TypeProduct, Boolean> tblTypeProductState;

        //Atributos para gestionar los productos

    
    @FXML
    private Pane pChooseIng;
    
    @FXML
    private TableView<Ingredient> tblChooseIngredient;

    @FXML
    private TableColumn<Ingredient, String> tblIngName;

    @FXML
    private TableView<TypeProduct> tblChooseTypeProduct;

    @FXML
    private TableColumn<TypeProduct, String> tblTypeProductName;

    @FXML
    private Pane pChooseType;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtProductSize;

    @FXML
    private JFXTextField txtProductPrice;
    
    @FXML
    private JFXToggleButton tbStateProduct;
    
    
    @FXML
    private TableView<Product> tblProduct;

    @FXML
    private TableColumn<Product, String> tblProductName;

    @FXML
    private TableColumn<Product, String> tblProductIng;

    @FXML
    private TableColumn<Product, String> tblProductTp;

    @FXML
    private TableColumn<Product, String> tblProductSize;
    
    @FXML
    private TableColumn<Product, Double> tblProductPrice;
    
    @FXML
    private TableColumn<Product, Boolean> tblProductState;

    
        //Atributos para gestionar los clientes
    
    @FXML
    private JFXTextField txtCName;

    @FXML
    private JFXTextField txtCLastName;

    @FXML
    private JFXTextField txtCID;

    @FXML
    private JFXTextField txtCPhone;

    @FXML
    private JFXTextField txtCAddress;

    @FXML
    private JFXTextField txtCObser;
        
    @FXML
    private JFXToggleButton tbStateClient;
    
    @FXML
    private JFXButton btnAddClient;
    
    @FXML
    private TableView<Client> tblClients;

    @FXML
    private TableColumn<Client, String> tblClientNameGestion;

    @FXML
    private TableColumn<Client, String> tblClientLNGestion;

    @FXML
    private TableColumn<Client, Integer> tblClientIDGestion;

    @FXML
    private TableColumn<Client, Integer> tblClientPhoneGestion;

    @FXML
    private TableColumn<Client, String> tblClientAddressGestion;

    @FXML
    private TableColumn<Client, String> tblClientObservationsGestion;
        
    @FXML
    private TableColumn<Client, Boolean> tblClientStateGestion;

        //Atributos para gestionar los pedidos
    
    @FXML
    private Pane pChooseProduct;

    //Atributos para listar
    
        //Atributos Ingredientes
    
    @FXML
    private TableView<Ingredient> tblIngredientDisp;

    @FXML
    private TableColumn<Ingredient, String> tblIngredientNameDisp;
    
        //Atributos tipo de producto
        
    @FXML
    private TableView<TypeProduct> tblDispTP;

    @FXML
    private TableColumn<TypeProduct, String> tblDispNameTP;
    
        //Atributos cliente

    @FXML
    private TableView<Client> tblDispClient;

    @FXML
    private TableColumn<Client, String> tblDispNameClient;

    @FXML
    private TableColumn<Client, String> tblDispLNClient;

    @FXML
    private TableColumn<Client, Integer> tblDispIDClient;

    @FXML
    private TableColumn<Client, String> tblDispAddressClient;

    @FXML
    private TableColumn<Client, Integer> tblDispPhoneClient;

    @FXML
    private TableColumn<Client, String> tblDispObserClient;
    
        //Atributos empleado
        
    @FXML
    private TableView<Employee> tblEmployeeDisp;

    @FXML
    private TableColumn<Employee, String> tblEmployeeNameDisp;

    @FXML
    private TableColumn<Employee, String> tblEmployeeLNDisp;

    @FXML
    private TableColumn<Employee, Integer> tblEmployeeIDDisp;
    
    //Buscar cliente para los pedidos
    @FXML
    private Pane pSearchClient;

    //Generar reportes
    @FXML
    private Pane pSelectDate;

    //Inicializable y concstructos de la clase
    public FXControllerGUI(CasaDorada casaDorada) throws IOException {
        this.casaDorada = casaDorada;
        casaDorada.loadDataAdmin();
        casaDorada.loadDataEMmployee();
        casaDorada.loadDataClient();
        casaDorada.loadDataIngredient();
        casaDorada.loadDatTypeProduct();
        casaDorada.loadDataClient();
        casaDorada.loadDataProduct();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView = ivWelcome;
        if (!FXMain.loaded) {
            try {
                timeline = new Timeline(
                        new KeyFrame(
                                Duration.ZERO,
                                new KeyValue(jfxSpinner.progressProperty(), 0)
                        ),
                        new KeyFrame(
                                Duration.seconds(2),
                                new KeyValue(jfxSpinner.progressProperty(), 1)
                        )
                );
            } catch (Exception e) {
            }
            timeline.setCycleCount(1);
            timeline.play();
            setImageWelcome();
            FXMain.loaded = true;
        }
    }

    //Cambios de Scene
    public void newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("Casa Dorada");
        newStage.setResizable(false);
        newStage.show();
    }

    public void closeStage() {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    //Metodos relacionados para que el splash screen funcione Correctamente
    public void setImageWelcome() {
        try {
            ivWelcome.setImage(new Image("image/CasaDoradaNew.png"));
        } catch (Exception e) {
        }
    }

    public void changeScreen() {
        try {
            closeStage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            newStage(root);
        } catch (IOException e) {
        }
    }

    /*
    Botones primera pantalla
    Login
     */
    
    @FXML
    public void onCreateAccount(ActionEvent event) throws IOException {
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    @FXML
    public void onLogIn(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        if (casaDorada.login(txtUserLogin.getText(), txtPassWordLogin.getText())) {
            closeStage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            ivGoldHouse.setImage(new Image("image/CasaDoradaNew.png"));
            newStage(root);
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("El usuario no fue encontrado en la base de datos."));
            dialog.show();
        }
    }

    /*
    Botones para la pantalla de
    Register
     */
    
    @FXML
    public void onIhaveAccount(ActionEvent event) throws IOException {
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    @FXML
    public void onRegister(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        try {
            if (!txtRegisterName.getText().equals("") && !txtRegisterLastName.getText().equals("")
                    && !txtRegisterID.getText().equals("") && !txtRegisterUserName.getText().equals("")
                    && !txtRegisterPassword.getText().equals("")) {

                casaDorada.addAdmin(txtRegisterUserName.getText(), txtRegisterPassword.getText(),
                        0, true, null, txtRegisterName.getText(),
                        txtRegisterLastName.getText(), Integer.parseInt(txtRegisterID.getText()), null);

                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El usuario fue creado exitosamente."));
                dialog.show();

                closeStage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                newStage(root);
            } else {
                content.setHeading(new Text("¡Error!"));
                content.setBody(new Text("Debes llenar todos los datos para crear el usuario."));
                dialog.show();
            }
        } catch (Exception e) {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("No puedes poner letras en la identificacion."));
            dialog.show();
        }
    }

    /*
    Funciones de los botones del
    MenuBar
     */
        /*
        Salir del programa y cuenta
        */
    @FXML
    public void onExitProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void onLogOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) bpMenu.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    /*
        Gestion de los objetos 
     */
    
    @FXML
    public void onGestionUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/UsernameGestion.fxml"));

        fxmlLoader.setController(this);
        Parent usernameGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(usernameGestion);
        onTableAdmin();
    }

    @FXML
    public void onGestionClients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ClientsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent clientsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(clientsGestion);
        onTableClient();
    }

    @FXML
    public void onGestionEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/EmployeesGestion.fxml"));

        fxmlLoader.setController(this);
        Parent employeesGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(employeesGestion);
        onTableEmployee();
    }

    @FXML
    public void onGestionIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/IngredientsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent ingredientsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(ingredientsGestion);
        onTableIngredient();
    }

    @FXML
    public void onGestionProducts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ProductsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent productsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(productsGestion);
        onTableProduct();
    }

    @FXML
    public void onGestionTypeProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/TypeProductsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent typeProductsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(typeProductsGestion);
        onTableTypeProduct();
    }

    @FXML
    public void onGestionOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/OrderGestion.fxml"));

        fxmlLoader.setController(this);
        Parent orderGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(orderGestion);
    }

    /*
        Listar los objetos
     */
    
    @FXML
    public void onLIstClients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListClients.fxml"));

        fxmlLoader.setController(this);
        Parent listClients = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listClients);
        showListClient();
    }

    @FXML
    public void onLIstEmployees(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListEmployees.fxml"));

        fxmlLoader.setController(this);
        Parent listEmployees = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listEmployees);
        showListEmployee();
    }

    @FXML
    public void onLIstIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListIngredients.fxml"));

        fxmlLoader.setController(this);
        Parent listIngredients = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listIngredients);
        showListIngredient();
    }

    @FXML
    public void onLIstProducts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListProducts.fxml"));

        fxmlLoader.setController(this);
        Parent listProducts = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listProducts);
    }

    @FXML
    public void onLIstTypeProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListTypeProducts.fxml"));

        fxmlLoader.setController(this);
        Parent listTypeProducts = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listTypeProducts);
        showListTypeProduct();
    }

    @FXML
    public void onListOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListOrder.fxml"));

        fxmlLoader.setController(this);
        Parent listOrder = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listOrder);
    }

        /*
        Metodo para generar los reportes
        Solo muestra la pantalla
        */
    
    public void openSelectDate() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SelectDate.fxml"));

        fxmlLoader.setController(this);
        Parent selectDate = fxmlLoader.load();
        newStage(selectDate);
    }

    //Gestion del producto
    
    @FXML
    public void onAddIngredientsToProduct (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseIngredients.fxml"));

        fxmlLoader.setController(this);
        Parent chooseIngredient = fxmlLoader.load();
        newStage(chooseIngredient);
        onTableChooseIngredient();
        showIngredientsDisp();
        
    }
    
    @FXML
    void onExitChooseIngredient(ActionEvent event) {
        
        Stage stage= (Stage) pChooseIng.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void onAddTypeToProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseTypeProducts.fxml"));

        fxmlLoader.setController(this);
        Parent chooseTypeProduct = fxmlLoader.load();
        newStage(chooseTypeProduct);
        onTableChooseTypeProduct();
        showTPDisp();
        
    }

    @FXML
    public void onExitChooseType(ActionEvent event) {
        Stage stage = (Stage) pChooseType.getScene().getWindow();
        stage.close();
    }

    //Gestion de los pedidos
    @FXML
    public void onChooseClient(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SearchClient.fxml"));

        fxmlLoader.setController(this);
        Parent searchClient = fxmlLoader.load();
        newStage(searchClient);
    }

    @FXML
    public void onChooseProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseProducts.fxml"));

        fxmlLoader.setController(this);
        Parent chooseProduct = fxmlLoader.load();
        newStage(chooseProduct);
    }

    @FXML
    public void onExitSearchClient(ActionEvent event) {
        Stage stage = (Stage) pSearchClient.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onExitChooseProduct(ActionEvent event) {
        Stage stage = (Stage) pChooseProduct.getScene().getWindow();
        stage.close();
    }

    /*
    Seleccionar el reporte que se desea generar
     */
    
    @FXML
    public void onReportEmployee(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    public void onReportIngredients(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    public void onReportOrder(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    public void onReportProducts(ActionEvent event) throws IOException {
        openSelectDate();
    }

    /*
        Salir de la pantalla de generar reportes
     */
    
    @FXML
    public void onExitSelectDate(ActionEvent event) {
        Stage stage = (Stage) pSelectDate.getScene().getWindow();
        stage.close();
    }

    /*
    Gestionar Ingredientes
     */
        /*
        Agregar Ingrediente
        */
    @FXML
    public void addIngredient(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        if (!(txtIngName.getText().equals(""))) {

            //ingCode++;
            String ingredientsName = txtIngName.getText();
            casaDorada.addIngredient(0, ingredientsName, tbStateIngredients.isSelected(), casaDorada.getAdminActive(), null);

            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text("El ingrediente fue creado exitosamente."));
            txtIngName.clear();
            dialog.show();
            onTableIngredient();
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al ingrediente que deseas crear."));
            dialog.show();
        }
    }
    
    public void onTableIngredient(){
        List<Ingredient> ingredients = casaDorada.getIngredient();
        ObservableList<Ingredient> newTableIngredient;
        newTableIngredient = FXCollections.observableArrayList(ingredients);
        
        tblIngredient.setItems(newTableIngredient);
        tblIngredientNameGestion.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
        tblIngredientState.setCellValueFactory(new PropertyValueFactory<>("ingredientsState"));
    }
    
        /*
        Eliminar Ingrediente
        */
    
    @FXML
    public void onRemoveIngredient(ActionEvent event) throws IOException {
        int index = casaDorada.getIngredientIndex();
        casaDorada.removeIngredient(index);
        btnAddIngredient.setVisible(true);
        DialogEliminated();
        onTableIngredient();
        txtIngName.clear();
    }
        /*
        Actualizar Ingrediente
        */
     
    
    @FXML
    private JFXButton btnRemoveIngredient;

    @FXML
    private JFXButton btnUptadeIngredient;

    
    @FXML
    public void onSelectIngredient(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        Ingredient ingredientSelected;
        if(event.getClickCount() == 2){
            ingredientSelected = tblIngredient.getSelectionModel().getSelectedItem();
            if(ingredientSelected != null){
                btnAddIngredient.setVisible(false);
                btnRemoveIngredient.setVisible(true);
                btnUptadeIngredient.setVisible(true);
                casaDorada.selectedIngredient(ingredientSelected);
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El ingrediente "+ingredientSelected.getIngredientsName()+" fue seleccionado exitosamente."));
                dialog.show();
                txtIngName.setText(ingredientSelected.getIngredientsName());
            }
        } else if (event.getClickCount() == 1){
            btnRemoveIngredient.setVisible(false);
            btnUptadeIngredient.setVisible(false);
        }
    }
    
    public Admin adminCreaterIngredient(){
        int index = casaDorada.getIngredientIndex();
        return casaDorada.getIngredient().get(index).getCiAdmin();
    }

    @FXML
    public void onUptadeIngredient(ActionEvent event) throws IOException {
        Ingredient newIngredient = new Ingredient(0, txtIngName.getText(), tbStateIngredients.isSelected(), 
                adminCreaterIngredient(), casaDorada.getAdminActive());
        casaDorada.setNewIngredient(newIngredient);
        btnAddIngredient.setVisible(true);
        DialogUptade();
        onTableIngredient();

    }
    
    /*
    Gestionar tipo de productos
    */
        /*
        Agregar tipo de producto
        */
    
    @FXML
    public void addTypeProduct(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        if (!(txtTpName.getText().equals(""))) {
            //tpCode++;

            String typeName = txtTpName.getText();
            casaDorada.addTypeProduct(0, typeName, tbStateTypeProduct.isSelected(), casaDorada.getAdminActive(), null);
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text("El tipo de producto fue creado exitosamente."));
            txtTpName.clear();
            dialog.show();
            onTableTypeProduct();
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al tipo de producto que deseas crear."));
            dialog.show();
        }
    }
    
    public void onTableTypeProduct(){
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(typeProducts);
        
        tblTypeProduct.setItems(newTableTypeProduct);
        tblTypeProductNameGestion.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        tblTypeProductState.setCellValueFactory(new PropertyValueFactory<>("typeState"));
    }
        
        /*
        Eliminar tipo de producto
        */
    
    @FXML
    public void onRemoveTypeProduct(ActionEvent event) throws IOException {
        int index = casaDorada.getTypeProductIndex();
        casaDorada.removeTypeProduct(index);
        btnAddTypeProduct.setVisible(true);
        DialogEliminated();
        onTableTypeProduct();
        txtTpName.clear();
    }
    
        /*
        Actualizar tipo de producto
        */
    
    
    @FXML
    private JFXButton btnRemoveType;

    @FXML
    private JFXButton btnUptadeType;
       
    @FXML
    public void onSelectType(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        TypeProduct typeProductSelected;
        if(event.getClickCount() == 2){
            typeProductSelected = tblTypeProduct.getSelectionModel().getSelectedItem();
            if(typeProductSelected != null){
                btnAddTypeProduct.setVisible(false);
                casaDorada.selectedTypeIngredient(typeProductSelected);
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El tipo de producto "+typeProductSelected.getTypeName()+" fue seleccionado exitosamente."));
                dialog.show();
                txtTpName.setText(typeProductSelected.getTypeName());
            }
        } else if (event.getClickCount() == 1){
            btnRemoveType.setVisible(false);
            btnUptadeType.setVisible(false);
        }
    }
    
    public Admin adminCreaterTP(){
        int index = casaDorada.getTypeProductIndex();
        return casaDorada.getTypeProduc().get(index).getCtpAdmin();
    }

    @FXML
    public void onUptadeType(ActionEvent event) throws IOException {
        TypeProduct newTypeProduct = new TypeProduct(0, txtTpName.getText(), tbStateTypeProduct.isSelected(),
                adminCreaterTP(), casaDorada.getAdminActive());
        casaDorada.setNewTypeProduct(newTypeProduct);
        btnAddTypeProduct.setVisible(true);
        DialogUptade();
        onTableTypeProduct();
    }
    
    /*
    Gestionar Producto
     */
        /*
        Agregar producto
        */
    @FXML
    public void onAddProduct(ActionEvent event) throws IOException{
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        if (!(txtProductName.getText().equals("")) && !(txtProductSize.getText().equals(""))
                && !(txtProductPrice.getText().equals(""))) {

            String productName = txtProductName.getText();
            String productSize = txtProductSize.getText();
            double productPrice = Double.parseDouble(txtProductPrice.getText());

            casaDorada.addProduct(0, productName, productSize, productPrice, tbStateProduct.isSelected(), 0, 
                    casaDorada.getAdminActive(), null);
            casaDorada.addIngredientToProductArray(ingredientsInP);
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text("El producto se ha agregado exitosamente"));
            dialog.show();
            onTableProduct();
            ingredientsInP = new ArrayList<>();
            
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al tipo de producto que deseas crear."));
            dialog.show();
        }
    }
    
    private Ingredient ingredientSelect;
    
    @FXML
    public void onAddIngredientToP(ActionEvent event) {
        if(cbxIngDisp.getValue() != null){
            ingredientSelect = cbxIngDisp.getValue();
            ingredientsInP.add(ingredientSelect);
        }
        System.out.println(ingredientsInP.size());
        onTableChooseIngredient();
    }
    
    
    
    private TypeProduct typeProductSelect;
    
    @FXML
    public void onAddTypeToP(ActionEvent event) {
        typeProductSelect = cbxTypeDisp.getValue();
    }
    /*
    private ArrayList<TypeProduct> typeProductsInP = new ArrayList<>();
    
    @FXML
    public void onAddTypeToP(ActionEvent event) {
        if(cbxTypeDisp.getValue() != null){
            typeProductSelect = cbxTypeProduct.getValue();
            typeProudtsInP.add(typeProductSelect);
        }
        onTableChooseTypeIngredient();
    }
    */


            /*
            Listar los ingredientes disponibles
            */
    
    
    @FXML
    private JFXComboBox<Ingredient> cbxIngDisp;
    
    public void showIngredientsDisp(){
        ArrayList<Ingredient> ingredientToProduct = new ArrayList<>();
        List<Ingredient> ingredients = casaDorada.getIngredient();
        for(int i = 0; i<ingredients.size(); i++){
            if(ingredients.get(i).getIngredientsState()){
                ingredientToProduct.add(ingredients.get(i));
            }
        }
        ObservableList<Ingredient> obs;
        obs = FXCollections.observableArrayList(ingredientToProduct);
        
        cbxIngDisp.setItems(obs);
    }
    
    private ArrayList<Ingredient> ingredientsInP = new ArrayList<>();
    
    public void onTableChooseIngredient() {
        ObservableList<Ingredient> newTableIngredient;
        newTableIngredient = FXCollections.observableArrayList(ingredientsInP);

        tblChooseIngredient.setItems(newTableIngredient);
        tblIngName.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
    }
    
            /*
            Listar los tipos de producto disponibles
            */
    
    @FXML
    private JFXComboBox<TypeProduct> cbxTypeDisp;
    
    public void showTPDisp(){
        ArrayList<TypeProduct> typeProductToProduct = new ArrayList<>();
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        for(int i = 0; i<typeProducts.size(); i++){
            if(typeProducts.get(i).getTypeState()){
                typeProductToProduct.add(typeProducts.get(i));
            }
        }
        ObservableList<TypeProduct> obs;
        obs = FXCollections.observableArrayList(typeProductToProduct);
        
        cbxTypeDisp.setItems(obs);
    }

    public void onTableChooseTypeProduct() {
        ArrayList<TypeProduct> dispChooseTypeProduct = new ArrayList<>();
        List<TypeProduct> chooseTypeProduct = casaDorada.getTypeProduc();
        for(int i = 0; i<chooseTypeProduct.size(); i++){
            if(chooseTypeProduct.get(i) == cbxTypeDisp.getValue()){
                dispChooseTypeProduct.add(chooseTypeProduct.get(i));
            }
        }
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(dispChooseTypeProduct);

        tblChooseTypeProduct.setItems(newTableTypeProduct);
        tblTypeProductName.setCellValueFactory(new PropertyValueFactory<>("typeName"));
    }
    
    public void onTableProduct() {
        List<Product> products = casaDorada.getProduct();
        ObservableList<Product> newTableProduct;
        newTableProduct = FXCollections.observableArrayList(products);

        tblProduct.setItems(newTableProduct);
        tblProductName.setCellValueFactory(new PropertyValueFactory<>("prName"));
        tblProductSize.setCellValueFactory(new PropertyValueFactory<>("prSize"));
        tblProductPrice.setCellValueFactory(new PropertyValueFactory<>("prPrice"));
        tblProductState.setCellValueFactory(new PropertyValueFactory<>("prState"));
    }
    
    /*
    public void onTableChooseTypeProduc() {
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(tyeProductsInP);

        tblChooseTypeProduct.setItems(newTableIngredient);
        tblTypeProductName.setCellValueFactory(new PropertyValueFactory<>("typeName"));
    }
    */
      

        /*
        Eliminar producto
        */
        /*
        Actualizar producto
        */
        /*
        Deshabiliatar producto
        */
    
    /*
    Gestionar Admin
    */
        /*
        Agregar Admin
        */
    
    public void onTableAdmin(){
        List<Admin> admin = casaDorada.getAdmin();
        ObservableList<Admin> newTableAdmin;
        newTableAdmin = FXCollections.observableArrayList(admin);

        tblAdmin.setItems(newTableAdmin);
        tblAdminName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAdminLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblAdminID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblAdminUserName.setCellValueFactory(new PropertyValueFactory<>("username"));
        tblAdminState.setCellValueFactory(new PropertyValueFactory<>("eState"));
       }
    
        /*
        Actualizar Admin
        */
    
    
    @FXML
    private JFXButton btnRemoveUsername;

    @FXML
    private JFXButton btnUptadeUsername;
    
    @FXML
    public void onSelectAdmin (MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        Admin adminSelected;
        if(event.getClickCount() == 2){
            adminSelected = tblAdmin.getSelectionModel().getSelectedItem();
            if(adminSelected != null){
                casaDorada.selectedAdmin(adminSelected);
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El usuario "+adminSelected.getName()+" fue seleccionado exitosamente."));
                dialog.show();
                txtNameAdmin.setText(adminSelected.getName());
                txtLastNameAdmin.setText(adminSelected.getLastName());
                txtIDAdmin.setText(adminSelected.getID()+"");
                txtUsername.setText(adminSelected.getUsername());
                txtPassword.setText(adminSelected.getPassword());
                txtConfirmPassword.setText(adminSelected.getPassword());
            }
        } else if (event.getClickCount() == 1){
            btnRemoveUsername.setVisible(false);
            btnUptadeUsername.setVisible(false);
        }
    }
    
    @FXML
    public void onUptadeAdmin(ActionEvent event) throws IOException {
        Admin newAdmin = new Admin(txtUsername.getText(), txtPassword.getText(), 0, tbStateUserName.isSelected(), 
                casaDorada.getAdminActive(), txtNameAdmin.getText(),
                        txtLastNameAdmin.getText(), Integer.parseInt(txtIDAdmin.getText()) , null);
        casaDorada.setNewAdmin(newAdmin);
        DialogUptade();
        onTableAdmin(); 
    }
    
        /*
        Eliminar Admin
        */
    @FXML
    public void onRemoveAdmin(ActionEvent event) throws IOException {
        int index = casaDorada.getAdminIndex();
        casaDorada.removeAdmin(index);
        DialogEliminated();
        onTableAdmin();
        txtNameAdmin.clear();
        txtLastNameAdmin.clear();
        txtIDAdmin.clear();
        txtUsername.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }

     /*
     Gestionar Empleado
     */
    
        /*
        Agregar empleado
        */
       
      @FXML
    public void addEmployee(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        try{
           if (!txtEmpName.getText().equals("") && !txtEmpLastName.getText().equals("")
                && !txtEmpID.getText().equals("")) {

                casaDorada.addEmployee(0, tbStateEmployee.isSelected(), null, txtEmpName.getText(),
                    txtEmpLastName.getText(), Integer.parseInt(txtEmpID.getText()),casaDorada.getAdminActive());
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El empleado fue creado exitosamente."));
                dialog.show();
                txtEmpName.clear();
                txtEmpLastName.clear();
                txtEmpID.clear();
                onTableEmployee();
            } else {
                content.setHeading(new Text("¡Error!"));
                content.setBody(new Text("Debes llenar todos los campos."));
                dialog.show();
            }     
        } catch (Exception e){
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("No puedes ingresar letras en la identificación."));
            dialog.show();
        }
        
    }
    
    public void onTableEmployee() {
        List<Employee> employee = casaDorada.getEmployee();
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(employee);

        tblEmployee.setItems(newTableEmployee);
        tblEmployeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployeeLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblEmployeeID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblEmployeeState.setCellValueFactory(new PropertyValueFactory<>("eState"));
    }
       
        /*
        Eliminar empleado
        */
    
    @FXML
    public void onRemoveEmployee(ActionEvent event) throws IOException {
        int index = casaDorada.getEmployeeIndex();
        casaDorada.removeEmployee(index);
        btnAddEmployee.setVisible(true);
        DialogEliminated();
        onTableEmployee();
        txtEmpName.clear();
        txtEmpLastName.clear();
        txtEmpID.clear();
    }
    
        /*
        Actualizar empleado
        */
    
    @FXML
    private JFXButton btnUpatedEmployee;

    @FXML
    private JFXButton btnRemoveEmployee;
    
    @FXML
    public void onSelecetEmployee(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        Employee employeeSelected;
        if(event.getClickCount() == 2){
            employeeSelected = tblEmployee.getSelectionModel().getSelectedItem();
            if(employeeSelected != null){
                btnAddEmployee.setVisible(false);
                casaDorada.selectedEmployee(employeeSelected);
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El empleado "+employeeSelected.getName()+" fue seleccionado exitosamente."));
                dialog.show();
                txtEmpName.setText(employeeSelected.getName());
                txtEmpLastName.setText(employeeSelected.getLastName());
                txtEmpID.setText(employeeSelected.getID()+"");
            }
        } else if (event.getClickCount() == 1){
             btnUpatedEmployee.setVisible(false);
             btnRemoveEmployee.setVisible(false);
        }
    }
    
    public Admin adminCreaterEmployee(){
        int index = casaDorada.getEmployeeIndex();
        return casaDorada.getEmployee().get(index).getCAdmin();
    }

    @FXML
    public void onUptadeEmployee(ActionEvent event) throws IOException {
        Employee newEmployee = new Employee(0, tbStateEmployee.isSelected(), casaDorada.getAdminActive(), 
                txtEmpName.getText(), txtEmpLastName.getText(), Integer.parseInt(txtEmpID.getText()), adminCreaterEmployee());
        casaDorada.setNewEmployee(newEmployee);
        btnAddEmployee.setVisible(true);
        DialogUptade();
        onTableEmployee();
    }
       
     /*
     Gestionar Cliente
     */
        /*
        Agregar Cliente
        */

    @FXML
    public void addClient(ActionEvent event) throws IOException {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        try{
           if(!(txtCName.getText().equals("")) && !(txtCLastName.getText().equals("")) && !(txtCID.getText().equals(""))
                && !(txtCPhone.getText().equals("")) && !(txtCAddress.getText().equals(""))){
            
                String cName = txtCName.getText();
                String cLastName = txtCLastName.getText();
                int cID = Integer.parseInt(txtCID.getText());
                int cPhone = Integer.parseInt(txtCPhone.getText());
                String cAddress = txtCAddress.getText();
                String cObser = txtCObser.getText();
            
                casaDorada.addClient(cAddress, cPhone, cObser, tbStateClient.isSelected(), null,
                    cName, cLastName, cID, casaDorada.getAdminActive());
            
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El Cliente fue creado exitosamente."));
                dialog.show();
                onTableClient();
                txtCName.clear();
                txtCLastName.clear();
                txtCID.clear();
                txtCPhone.clear();
                txtCAddress.clear();
                txtCObser.clear();
            } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Todos los campos son obligatorios, menos las observaciones."));
            dialog.show();  
            } 
        } catch (Exception e){
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("No puedes ingresar letras en la identificación o el numero de telefono."));
            dialog.show();
                txtCID.clear();
                txtCPhone.clear();
        }
        
    }
    
    public  void onTableClient(){
        List<Client> clients = casaDorada.getClient();
        ObservableList<Client> newTableClient;
        newTableClient = FXCollections.observableArrayList(clients);
        
        tblClients.setItems(newTableClient);
        tblClientNameGestion.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblClientLNGestion.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblClientIDGestion.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblClientAddressGestion.setCellValueFactory(new PropertyValueFactory<>("cAddress"));
        tblClientPhoneGestion.setCellValueFactory(new PropertyValueFactory<>("cPhone"));
        tblClientObservationsGestion.setCellValueFactory(new PropertyValueFactory<>("cObservations"));
        tblClientStateGestion.setCellValueFactory(new PropertyValueFactory<>("cState"));
    }
    
        /*
        Eliminar Cliente
        */
        
    @FXML
    public void onRemoveClient(ActionEvent event) throws IOException {
        int index = casaDorada.getClientIndex();
        casaDorada.removeClient(index);
        btnAddClient.setVisible(true);
        DialogEliminated();
        onTableClient();
        txtCName.clear();
        txtCLastName.clear();
        txtCID.clear();
        txtCPhone.clear();
        txtCAddress.clear();
        txtCObser.clear();
    }
    
        /*
        Actualizar Cliente
        */    
    
    @FXML
    private JFXButton btnRemoveClient;

    @FXML
    private JFXButton btnUptadeClient;
    
    @FXML
    public void onSelectClient(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        Client clientSelected;
        if(event.getClickCount() == 2){
            clientSelected = tblClients.getSelectionModel().getSelectedItem();
            if(clientSelected != null){
                btnAddClient.setVisible(false);
                casaDorada.selectedClient(clientSelected);
                content.setHeading(new Text("¡Listo!"));
                content.setBody(new Text("El cliente "+clientSelected.getName()+" fue seleccionado exitosamente."));
                dialog.show();
                txtCName.setText(clientSelected.getName());
                txtCLastName.setText(clientSelected.getLastName());
                txtCID.setText(clientSelected.getID()+"");
                txtCPhone.setText(clientSelected.getCPhone()+"");
                txtCAddress.setText(clientSelected.getCAddress());
                txtCObser.setText(clientSelected.getCObservations());
            }
        } else if (event.getClickCount() == 1){
            btnUptadeClient.setVisible(false);
            btnRemoveClient.setVisible(false);
        }
    }
        
    public Admin adminCreaterClient(){
        int index = casaDorada.getClientIndex();
        return casaDorada.getClient().get(index).getCAdmin();
    }

    @FXML
    public void onUptadeClient(ActionEvent event) throws IOException {
        Client newClient = new Client(txtCAddress.getText(), Integer.parseInt(txtCPhone.getText()), txtCObser.getText(), 
                tbStateClient.isSelected(), casaDorada.getAdminActive(), txtCName.getText(), txtCLastName.getText(),
                Integer.parseInt(txtCID.getText()), adminCreaterClient());
        casaDorada.setNewClient(newClient);
        btnAddClient.setVisible(true);
        DialogUptade();
        onTableClient();
    }

    
    /*
    Listar las arrayList de los objetos
    */
        /*
        Listar ingredientes
        */
    
    public void showListIngredient(){
        ArrayList<Ingredient> dispIngredients = new ArrayList<>();
        List<Ingredient> ingredients = casaDorada.getIngredient();
        for(int i = 0; i<ingredients.size(); i++){
            if(ingredients.get(i).getIngredientsState()){
                dispIngredients.add(ingredients.get(i));
            }
        }
        ObservableList<Ingredient> newTableIngredient;
        newTableIngredient = FXCollections.observableArrayList(dispIngredients);
        
        tblIngredientDisp.setItems(newTableIngredient);
        tblIngredientNameDisp.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
    }
    
        /*
        Listar tipo de productos
        */

    
    public void showListTypeProduct(){
        ArrayList<TypeProduct> dispTypeProduct = new ArrayList<>();
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        for(int i = 0; i<typeProducts.size(); i++){
            if(typeProducts.get(i).getTypeState()){
                dispTypeProduct.add(typeProducts.get(i));
            }
        }
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(dispTypeProduct);
        
        tblDispTP.setItems(newTableTypeProduct);
        tblDispNameTP.setCellValueFactory(new PropertyValueFactory<>("typeName"));
    }
    
        /*
        Listar empleados
        */

    
    public void showListEmployee(){
        ArrayList<Employee> dispEmployees = new ArrayList<>();
        List<Employee> employees = casaDorada.getEmployee();
        for(int i = 0; i<employees.size(); i++){
            if(employees.get(i).getEState()){
                dispEmployees.add(employees.get(i));
            }
        }
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(dispEmployees);
        
        tblEmployeeDisp.setItems(newTableEmployee);
        tblEmployeeNameDisp.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployeeLNDisp.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tblEmployeeIDDisp.setCellValueFactory(new PropertyValueFactory<>("ID"));
    }
        
        /*
        Listar clientes
        */

    
    public void showListClient(){
        ArrayList<Client> dispClient = new ArrayList<>();
        List<Client> clients = casaDorada.getClient();
        for(int i = 0; i<clients.size(); i++){
            if(clients.get(i).getCState()){
                dispClient.add(clients.get(i));
            }
        }
        ObservableList<Client> newTableClient;
        newTableClient = FXCollections.observableArrayList(dispClient);
        
        tblDispClient.setItems(newTableClient);
        tblDispNameClient.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDispLNClient.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblDispIDClient.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblDispAddressClient.setCellValueFactory(new PropertyValueFactory<>("cAddress"));
        tblDispPhoneClient.setCellValueFactory(new PropertyValueFactory<>("cPhone"));
        tblDispObserClient.setCellValueFactory(new PropertyValueFactory<>("cObservations"));
    }

        /*
        Listar productos
        */

    public void DialogUptade(){
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        content.setHeading(new Text("¡Listo!"));
        content.setBody(new Text("Se ha actualizado este elemento correctamente"));
        dialog.show();
    }
    
    public void DialogEliminated(){
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        content.setHeading(new Text("¡Listo!"));
        content.setBody(new Text("Se ha eliminaod este elemento correctamente"));
        dialog.show();
    }
}
