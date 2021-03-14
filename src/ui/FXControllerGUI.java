package ui;

import com.jfoenix.controls.JFXSpinner;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class FXControllerGUI implements Initializable {

    public static ImageView imageView;

    private CasaDorada casaDorada;

    private static Timeline timeline;

    @FXML
    private static BorderPane bpMain;

    @FXML
    public JFXSpinner jfxSpinner;

    @FXML
    private ImageView ivLoginP;

    @FXML
    private ImageView ivWelcome;

    @FXML
    private BorderPane bpRegister;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

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

    public void setImageWelcome() {
        try {
            ivWelcome.setImage(new Image("image/CasaDorada.png"));
        } catch (Exception e) {
        }
    }

    public void setImageLogin() {
        try {
            ivLoginP.setImage(new Image("/image/61100.jpg"));
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
}
