package ui;

import java.io.File;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class FXSplashScreen extends Preloader{
    
    private CasaDorada casaDorada;
    private FXControllerGUI fxControllerGUI;
    private Stage preloaderStage;
    private Scene scene;

    public FXSplashScreen() {
        casaDorada = new CasaDorada();
        fxControllerGUI = new FXControllerGUI(casaDorada);
    }  
    
    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/WelcomePane.fxml"));
        fxmlLoader.setController(fxControllerGUI);
        Parent root1 = fxmlLoader.load();
        scene = new Scene(root1);
        Image img = new Image("image/CasaDorada.png");
        FXControllerGUI.imageView.setImage(img);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preloaderStage = primaryStage;
        preloaderStage.setScene(scene);
        preloaderStage.setResizable(false);
        preloaderStage.setTitle("Casa Dorada");
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        if (info instanceof ProgressNotification) {
            FXControllerGUI.label.setText("Loading " + ((ProgressNotification) info).getProgress() + "%");
        }
    }
    
    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_START:
                preloaderStage.hide();
                break;
        }
    }
}
