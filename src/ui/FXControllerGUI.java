package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;

public class FXControllerGUI implements Initializable{
    
    private CasaDorada casaDorada;
    
    public static Label label;

    public static ImageView imageView;
    
    @FXML
    private ImageView ivLoginP;

    @FXML
    private ImageView ivWelcome;

    @FXML
    private Label lblProgress;

    @FXML
    private BorderPane bpMain;

    @FXML
    private BorderPane bpRegister;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    public FXControllerGUI(CasaDorada casaDorada){
        this.casaDorada = casaDorada;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label = lblProgress;
        imageView = ivWelcome;
        setImageLogin();
    }
    
    @FXML
    public void onLogIn(ActionEvent event) {

    }

    @FXML
    public void onCreateAccount(ActionEvent event) {

    }

    @FXML
    public void onSingGo(ActionEvent event) throws IOException {
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    @FXML
    public void onIhaveAccount(ActionEvent event) throws IOException {
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void setImageLogin() {
        try {
            ivLoginP.setImage(new Image("/image/61100.jpg"));
        } catch (Exception e) {
        }
    }

    public void newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/css/WelcomePane.css").toExternalForm());
        newStage.setScene(scene);
        newStage.setTitle("Casa Dorada");
        newStage.setResizable(false);
        newStage.show();
    }

    public void closeStage() {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }
}
