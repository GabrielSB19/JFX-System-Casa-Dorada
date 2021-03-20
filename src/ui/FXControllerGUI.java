package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class FXControllerGUI implements Initializable {

    /*
    Atributos para el funcionamiento de SplashScreen
    */
    
    public static ImageView imageView;

    private CasaDorada casaDorada;

    public static Timeline timeline;

    @FXML
    public JFXSpinner jfxSpinner;

    @FXML
    private ImageView ivWelcome;
    
    /*
    Pantalla para las advertencias
    */
    
    @FXML
    private StackPane stackPane;

    /*
    Primera Pantalla (Login)
    */
    
    @FXML
    private BorderPane bpMain;

    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;

    /*
    Pantalla de registrarse
    */

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

    /*
    Atribtuos del Menu
    */
    
        /*
        Atribtuos generales
        */
    
    @FXML
    private ImageView ivGoldHouse;

    @FXML
    private BorderPane bpMenu;

    @FXML
    private Pane pNewOption;
    
        /*
        Atributos para gestionar los ingredients
        */
    
    @FXML
    private JFXTextField txtIngName;
    
        /*
        Atribtuos para gestionar los tipo de ingrediente
        */
    
    @FXML
    private JFXTextField txtTpName;
    
        /*
        Atributos para gestionar los productos
        */
    
    @FXML
    private Pane pChooseIngredients;

    @FXML
    private Pane pChooseType;
    
    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtProductSize;

    @FXML
    private JFXTextField txtProductPrice;

        /*
        Atributos para gestionar los pedidos
        */
    
    @FXML
    private Pane pChooseProduct;
    
            /*
            Buscar cliente para los pedidos
            */
    
    @FXML
    private Pane pSearchClient;
    
        /*
        Generar reportes
        */
    
    @FXML
    private Pane pSelectDate;
    
    /*
    Inicializable y concstructos de la clase
    */


    public FXControllerGUI(CasaDorada casaDorada) throws IOException {
        this.casaDorada = casaDorada;
        casaDorada.loadDataAdmin();
        casaDorada.loadDataIngredient();
        casaDorada.loadDatTypeProduct();;
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

    /*
    Cambios de Scene
    */
    
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

    /*
    Metodos relacionados para que el splash screen funcione
    Correctamente
    */
    
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
        casaDorada.login(txtUserLogin.getText());
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        ivGoldHouse.setImage(new Image("image/CasaDoradaNew.png"));
        newStage(root);
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
        if (!txtRegisterName.getText().equals("") && !txtRegisterLastName.getText().equals("")
                && !txtRegisterID.getText().equals("") && !txtRegisterUserName.getText().equals("")
                && !txtRegisterPassword.getText().equals("")) {

            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text("El usuario fue creado exitosamente."));

            casaDorada.addAdmin(txtRegisterUserName.getText(), txtRegisterPassword.getText(),
                    Integer.parseInt(txtRegisterID.getText()), true, null, txtRegisterName.getText(),
                    txtRegisterLastName.getText(), 0, null);

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
    }

    
    @FXML
    public void onGestionClients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ClientsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent clientsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(clientsGestion);
    }

    @FXML
    public void onGestionEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/EmployeesGestion.fxml"));

        fxmlLoader.setController(this);
        Parent employeesGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(employeesGestion);
    }

    @FXML
    public void onGestionIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/IngredientsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent ingredientsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(ingredientsGestion);
    }

    @FXML
    public void onGestionProducts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ProductsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent productsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(productsGestion);
    }

    @FXML
    public void onGestionTypeProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/TypeProductsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent typeProductsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(typeProductsGestion);
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
    }

    @FXML
    public void onLIstEmployees(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListEmployees.fxml"));

        fxmlLoader.setController(this);
        Parent listEmployees = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listEmployees);
    }

    @FXML
    public void onLIstIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListIngredients.fxml"));

        fxmlLoader.setController(this);
        Parent listIngredients = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listIngredients);
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
    public void onAddIngredientsToProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseIngredients.fxml"));

        fxmlLoader.setController(this);
        Parent chooseIngredient = fxmlLoader.load();
        newStage(chooseIngredient);
    }

    @FXML
    public void onExitChooseIngredient(ActionEvent event) {
        Stage stage = (Stage) pChooseIngredients.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onAddTypeToProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseTypeProducts.fxml"));

        fxmlLoader.setController(this);
        Parent chooseTypeProduct = fxmlLoader.load();
        newStage(chooseTypeProduct);
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
        if(!(txtIngName.getText().equals(""))){
            
            //ingCode++;
            
            String ingredientsName = txtIngName.getText();
            casaDorada.addIngredient(0, ingredientsName, true, null, null);
            
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text("El ingrediente fue creado exitosamente."));
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al ingrediente que deseas crear."));
            dialog.show();
        }
    }
    
        /*
        Eliminar Ingrediente
        */
        /*
        Actualizar Ingrediente
        */
        /*
        Deshabiliatar Ingrediente
        */
    
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
        if(!(txtTpName.getText().equals(""))){
            //tpCode++;
            
            String typeName = txtTpName.getText();
            casaDorada.addTypeProduct(0, typeName, true, null, null);
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al tipo de producto que deseas crear."));
            dialog.show();  
        }
    }
        
        /*
        Eliminar tipo de producto
        */
        /*
        Actualizar tipo de producto
        */
        /*
        Deshabiliatar tipo de producto
        */
    
    /*
    Gestionar Producto
    */
        /*
        Agregar tipo de producto
        */
    
    @FXML
    void onAddProduct(ActionEvent event) {
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
        if(!(txtProductName.getText().equals("")) && !(txtProductSize.getText().equals(""))
                && !(txtProductPrice.getText().equals(""))){
            
            String productName = txtProductName.getText();
            String productSize = txtProductSize.getText();
            double productPrice = Double.parseDouble(txtProductPrice.getText());
            
            casaDorada.addProduct(0, productName, productSize, productPrice, true, 0, null, null);
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text("Debes colocarle un nombre al tipo de producto que deseas crear."));
            dialog.show(); 
        }
    }
        /*
        Eliminar tipo de producto
        */
        /*
        Actualizar tipo de producto
        */
        /*
        Deshabiliatar tipo de producto
        */
    
}
