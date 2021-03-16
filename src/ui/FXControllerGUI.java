package ui;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class FXControllerGUI implements Initializable {
    
    //SplashScreen

    public static ImageView imageView;

    private CasaDorada casaDorada;

    public static Timeline timeline;

    @FXML
    public JFXSpinner jfxSpinner;


    @FXML
    private ImageView ivWelcome;
    
    //Login
    
    @FXML
    private BorderPane bpMain;
    
    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;
    
    //Register
    
    @FXML
    private BorderPane bpRegister;
    
    //Menu
    
    @FXML
    private ImageView ivGoldHouse;
    
    @FXML
    private BorderPane bpMenu;
    
    @FXML
    private Pane pNewOption;
    /*
    @FXML
    private ImageView ivTest;
    */

    public FXControllerGUI(CasaDorada casaDorada) {
        this.casaDorada = casaDorada;
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
    
    public void setImageWelcome() {
        try {
            ivWelcome.setImage(new Image("image/CasaDoradaNew.png"));
        } catch (Exception e) {
        }
    }
    
    //Login
    
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
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        ivGoldHouse.setImage(new Image("image/CasaDoradaNew.png"));
        newStage(root);
    }
    
    //Register

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
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        ivGoldHouse.setImage(new Image("image/CasaDoradaNew.png"));
        newStage(root);
    }
    
    //Menu
    
    //Salir
    
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
    
    //Gestion
    
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
    
    //Listas
    
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
    	Parent listProducts= fxmlLoader.load();
    	
    	pNewOption.getChildren().clear();
    	pNewOption.getChildren().setAll(listProducts);
    }

    @FXML
    void onLIstTypeProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListTypeProducts.fxml"));
    	
    	fxmlLoader.setController(this);
    	Parent listTypeProducts = fxmlLoader.load();
    	
    	pNewOption.getChildren().clear();
    	pNewOption.getChildren().setAll(listTypeProducts);
    }

    
    /*
    public void setImageBanner(){
        try{
            ivTest.setImage(new Image("image/BannerCasaDoradaNew.png"));
        } catch (Exception e){
            
        }
    }
    */

}
