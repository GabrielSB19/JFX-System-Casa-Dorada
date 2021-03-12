package ui;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;


public class FXMain extends Application{

    private static final int COUNT_LIMIT = 100000;
    
    private CasaDorada casaDorada;
    private FXControllerGUI fxControllerGUI;
    
    public FXMain(){
        casaDorada = new CasaDorada();
        fxControllerGUI = new FXControllerGUI(casaDorada);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
	fxmlLoader.setController(fxControllerGUI);
		
	Parent root = fxmlLoader.load();
		
	Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/css/WelcomePane.css").toExternalForm());
	primaryStage.setScene(scene);
        primaryStage.setResizable(false);
	primaryStage.setTitle("Casa Dorada");
	primaryStage.show();
    }
    
    @Override
    public void init () throws Exception{
        for(int i = 0; i<COUNT_LIMIT; i++){
            double progress = (100*i)/COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }
        
    public static void main (String [] args){
        LauncherImpl.launchApplication(FXMain.class, FXSplashScreen.class, args);
    }
}
