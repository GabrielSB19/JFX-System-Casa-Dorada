package ui;

import com.sun.javafx.application.LauncherImpl;
import java.io.IOException;
import javafx.application.Preloader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class FXMain extends Application {

    public static boolean loaded = false;
    private CasaDorada casaDorada;
    private FXControllerGUI fxControllerGUI;

    private static final int COUNT_LIMIT = 30000;

    public FXMain() throws IOException {
        casaDorada = new CasaDorada();
        fxControllerGUI = new FXControllerGUI(casaDorada);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(fxControllerGUI);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Casa Dorada");
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        for (int i = 0; i < COUNT_LIMIT; i++) {
            double progress = (100 * i) / COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(FXMain.class, FXSplashScreen.class, args);
    }
}
