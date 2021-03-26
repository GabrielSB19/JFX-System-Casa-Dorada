package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.scene.input.KeyEvent;
import model.*;

public class FXControllerGUI implements Initializable {

    /*
    Atributos y metodos y constructor que son generales de la GUI.
     */
      
    private final String SAVE_PATH_FILE = "data/CasaDorada.cgd";
    
    public void loadData() throws IOException, FileNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE)));
            casaDorada = (CasaDorada) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
        oos.writeObject(this.casaDorada);
        oos.close();
    }

    
    public static ImageView imageView;

    private  CasaDorada casaDorada;

    public static Timeline timeline;

    @FXML
    public JFXSpinner jfxSpinner;

    @FXML
    private ImageView ivWelcome;

    @FXML
    private StackPane stackPane;
    
    @FXML
    private StackPane stackPane2;

    public FXControllerGUI(CasaDorada casaDorada) throws IOException {
        this.casaDorada = casaDorada;
        casaDorada.loadDataAdmin();
        casaDorada.loadDataEMmployee();
        casaDorada.loadDataClient();
        casaDorada.loadDataIngredient();
        casaDorada.loadDatTypeProduct();
        casaDorada.loadDataClient();
        casaDorada.loadDataProduct();
        casaDorada.loadDataOrder();
        casaDorada.loadDataCode();
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
            try {
                loadData();
            } catch (IOException ex) {
                Logger.getLogger(FXControllerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public void openSelectDate() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SelectDate.fxml"));

        fxmlLoader.setController(this);
        Parent selectDate = fxmlLoader.load();
        newStage(selectDate);
    }

    public void showAlert(boolean success, String msg) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction((ActionEvent event) -> {
            dialog.close();
        });
        content.setActions(button);
        if (success) {
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text(msg));
            dialog.show();
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text(msg));
            dialog.show();
        }
    }
    
    public void showAlert2(boolean success, String msg) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane2, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction((ActionEvent event) -> {
            dialog.close();
        });
        content.setActions(button);
        if (success) {
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text(msg));
            dialog.show();
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text(msg));
            dialog.show();
        }
    }

    //Atributos y metodos que solo se usan en el Login
    @FXML
    private BorderPane bpMain;

    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;

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
        if (casaDorada.login(txtUserLogin.getText(), txtPassWordLogin.getText())) {
            closeStage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            ivGoldHouse.setImage(new Image("image/CasaDoradaNew.png"));
            newStage(root);
        } else {
            showAlert(false, "El usuario no existe en nuestra base de datos,\nvuelve a comprobar los datos ingresado");
        }
    }

    //Atributos y metodos que solo se usan en el Register
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

    @FXML
    public void onRegister(ActionEvent event) throws IOException {
        try {
            if (!txtRegisterName.getText().equals("") && !txtRegisterLastName.getText().equals("")
                    && !txtRegisterID.getText().equals("") && !txtRegisterUserName.getText().equals("")
                    && !txtRegisterPassword.getText().equals("")) {

                casaDorada.addAdmin(txtRegisterUserName.getText(), txtRegisterPassword.getText(), 0, true, null, casaDorada.getCode(),
                        txtRegisterName.getText(), txtRegisterLastName.getText(), Long.parseLong(txtRegisterID.getText()), null);

                showAlert(true, "El usuario fue agregado correctamente");
                closeStage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                newStage(root);
            } else {
                showAlert(false, "El usuario debe de tener todos los campos llenos");
            }
        } catch (Exception e) {
            showAlert(false, "La Identificación debe ser un numero y no letras");
        }
    }

    @FXML
    public void onIhaveAccount(ActionEvent event) throws IOException {
        closeStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    //Atributos del menu y metodos
    @FXML
    private ImageView ivGoldHouse;

    @FXML
    private BorderPane bpMenu;

    @FXML
    private Pane pNewOption;

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

    //Gestionar Administradores
    @FXML
    private JFXButton btnRemoveUsername;

    @FXML
    private JFXButton btnUptadeUsername;

    @FXML
    public void onGestionUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/UsernameGestion.fxml"));

        fxmlLoader.setController(this);
        Parent usernameGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(usernameGestion);
        onTableAdmin();
    }

    private int code;
    
    @FXML
    public void onSelectAdmin(MouseEvent event) {
        Admin adminSelected;
        if (event.getClickCount() == 2) {
            adminSelected = tblAdmin.getSelectionModel().getSelectedItem();
            if (adminSelected != null) {
                code = adminSelected.getPCode();
                btnRemoveUsername.setVisible(true);
                btnUptadeUsername.setVisible(true);
                showAlert(true, "Se ha seleccionado el administrador correctamente");
                txtNameAdmin.setText(adminSelected.getName());
                txtLastNameAdmin.setText(adminSelected.getLastName());
                txtIDAdmin.setText(adminSelected.getID() + "");
                txtUsername.setText(adminSelected.getUsername());
                txtPassword.setText(adminSelected.getPassword());
                tbStateUserName.setSelected(adminSelected.getEState());
            }
        } else if (event.getClickCount() == 1) {
            btnRemoveUsername.setVisible(false);
            btnUptadeUsername.setVisible(false);
        }
    }

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
    private JFXToggleButton tbStateUserName;

    @FXML
    public void onUptadeAdmin(ActionEvent event) throws IOException {
        boolean isActive = casaDorada.updateAdmin(code, txtUsername.getText(), txtPassword.getText(), tbStateUserName.isSelected(), casaDorada.getAdminActive(),
                txtNameAdmin.getText(), txtLastNameAdmin.getText(), Long.parseLong(txtIDAdmin.getText()));
        if (!isActive) {
            showAlert(true, "Se ha actualizado este elemento correctamente");
            tblAdmin.refresh();
        } else {
            onLogOut(event);
        }
    }

    @FXML
    public void onRemoveAdmin(ActionEvent event) throws IOException {
        boolean isActive = casaDorada.verifyAdmin(code);
        if (casaDorada.removeAdmin(code)) {
            showAlert(true, "Se ha eliminado este elemento correctamente");
            if (casaDorada.getListAdmins().isEmpty() || isActive) {
                onLogOut(event);
            } else {
                onTableAdmin();
                txtNameAdmin.clear();
                txtLastNameAdmin.clear();
                txtIDAdmin.clear();
                txtUsername.clear();
                txtPassword.clear();
            }
        } else {
            showAlert(false, "No se ha podido eliminar,\nAdmin se encuentra referenciado");
        }
    }

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

    public void onTableAdmin() {
        List<Admin> admin = casaDorada.getListAdmins();
        ObservableList<Admin> newTableAdmin;
        newTableAdmin = FXCollections.observableArrayList(admin);

        tblAdmin.setItems(newTableAdmin);
        tblAdminName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAdminLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblAdminID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblAdminUserName.setCellValueFactory(new PropertyValueFactory<>("username"));
        tblAdminState.setCellValueFactory(new PropertyValueFactory<>("eState"));
    }

    //Gestionar Empleado
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
    private JFXButton btnAddEmployee;

    @FXML
    private JFXButton btnUpatedEmployee;

    @FXML
    private JFXButton btnRemoveEmployee;

    @FXML
    public void onSelecetEmployee(MouseEvent event) {
        Employee employeeSelected;
        if (event.getClickCount() == 2) {
            employeeSelected = tblEmployee.getSelectionModel().getSelectedItem();
            if (employeeSelected != null) {
                code = employeeSelected.getPCode();
                btnAddEmployee.setVisible(false);
                btnUpatedEmployee.setVisible(true);
                btnRemoveEmployee.setVisible(true);
                showAlert(true, "Se ha seleccionado el empleado correctamente");
                txtEmpName.setText(employeeSelected.getName());
                txtEmpLastName.setText(employeeSelected.getLastName());
                txtEmpID.setText(employeeSelected.getID() + "");
                tbStateEmployee.setSelected(employeeSelected.getEState());
            }
        } else if (event.getClickCount() == 1) {
            btnAddEmployee.setVisible(true);
            btnUpatedEmployee.setVisible(false);
            btnRemoveEmployee.setVisible(false);
        }
    }

    @FXML
    private JFXTextField txtEmpName;

    @FXML
    private JFXTextField txtEmpLastName;

    @FXML
    private JFXTextField txtEmpID;

    @FXML
    private JFXToggleButton tbStateEmployee;

    @FXML
    public void addEmployee(ActionEvent event) throws IOException {
        try {
            if (!txtEmpName.getText().equals("") && !txtEmpLastName.getText().equals("")
                    && !txtEmpID.getText().equals("")) {

                casaDorada.addEmployee(0, tbStateEmployee.isSelected(), null, 0, casaDorada.getCode(), txtEmpName.getText(), 
                                       txtEmpLastName.getText(), Long.parseLong(txtEmpID.getText()), casaDorada.getAdminActive());

                showAlert(true, "El empleado ha sido agregado correctamente");
                txtEmpName.clear();
                txtEmpLastName.clear();
                txtEmpID.clear();
                onTableEmployee();
            } else {
                showAlert(false, "Debes de llenar todos los campos");
            }
        } catch (Exception e) {
            showAlert(false, "Ingresaste una letra en una casilla numerica, revisa tus datos");
        }
    }
    
    @FXML
    public void onUpdateEmployee(ActionEvent event) throws IOException {
        if(casaDorada.uptadeEmployee(code, tbStateEmployee.isSelected(), casaDorada.getAdminActive(), txtEmpName.getText(),
           txtEmpLastName.getText(), Long.parseLong(txtEmpID.getText()))){
            btnAddEmployee.setVisible(true);
            showAlert(true, "Se ha actualizado este elemento correctamente");
            tblEmployee.refresh();
        } else {
            showAlert(true, "No se ha acutalizado el empleado \notro empleado tiene la misma identificación");
        }
        btnAddEmployee.setVisible(true);
        tblEmployee.refresh();
    }
 
    @FXML
    public void onRemoveEmployee(ActionEvent event) throws IOException {
        if(casaDorada.removeEmployee(code)){
            showAlert(true, "Se ha eliminado este elemento correctamente");
            txtEmpLastName.clear();
            txtEmpName.clear();
            txtEmpID.clear();
            onTableEmployee();
        } else {
            showAlert(false, "No se ha podido eliminar,\nel empleado se encuentra referenciado");
        }
    }
  
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
    public void onReportEmployee(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    private TableView<Employee> tblEmployeeDisp;

    @FXML
    private TableColumn<Employee, String> tblEmployeeNameDisp;

    @FXML
    private TableColumn<Employee, String> tblEmployeeLNDisp;

    @FXML
    private TableColumn<Employee, Integer> tblEmployeeIDDisp;

    public void showListEmployee() {
        ArrayList<Employee> dispEmployees = new ArrayList<>();
        List<Employee> employees = casaDorada.getEmployee();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEState()) {
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
    
    //Gestionar Clientes
    
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
    private JFXButton btnAddClient;
   
    @FXML
    private JFXButton btnRemoveClient;

    @FXML
    private JFXButton btnUptadeClient;
    
    @FXML
    public void onSelectClient(MouseEvent event) {
        Client clientSelected;
        if (event.getClickCount() == 2) {
            clientSelected = tblClients.getSelectionModel().getSelectedItem();
            if (clientSelected != null) {
                code = clientSelected.getPCode();
                btnAddClient.setVisible(false);
                btnUptadeClient.setVisible(true);
                btnRemoveClient.setVisible(true);
                showAlert(true, "Se ha seleccionado correctamente al cliente");
                txtCName.setText(clientSelected.getName());
                txtCLastName.setText(clientSelected.getLastName());
                txtCID.setText(clientSelected.getID() + "");
                txtCPhone.setText(clientSelected.getCPhone() + "");
                txtCAddress.setText(clientSelected.getCAddress());
                txtCObser.setText(clientSelected.getCObservations());
                tbStateClient.setSelected(clientSelected.getCState());
            }
        } else if (event.getClickCount() == 1) {
            btnAddClient.setVisible(true);
            btnUptadeClient.setVisible(false);
            btnRemoveClient.setVisible(false);
        }
    }
    
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
    public void addClient(ActionEvent event) throws IOException {
        try {
            if (!(txtCName.getText().equals("")) && !(txtCLastName.getText().equals("")) && !(txtCID.getText().equals(""))
                    && !(txtCPhone.getText().equals("")) && !(txtCAddress.getText().equals(""))) {
                if(casaDorada.addClient(txtCAddress.getText(), Long.parseLong(txtCPhone.getText()), txtCObser.getText(), tbStateClient.isSelected(), null,
                   0, casaDorada.getCode(), txtCName.getText(), txtCLastName.getText(), Long.parseLong(txtCID.getText()), casaDorada.getAdminActive())) {
                   showAlert(true, "Se ha agregado correctamente el cliente"); 
                } else {
                    showAlert(false, "No se ha agregado el cliente debido a que ya existe otro con la misma Identificación");
                }

                txtCName.clear();
                txtCLastName.clear();
                txtCID.clear();
                txtCPhone.clear();
                txtCAddress.clear();
                txtCObser.clear();
                onTableClient();
            } else {
                showAlert(false, "Debes de llenar todos los campos");
            }
        } catch (Exception e) {
            showAlert(false, "Ingresaste letras en un campo que son para valores numericos");
            txtCID.clear();
            txtCPhone.clear();
        }

    }
    
    @FXML
    public void onUptadeClient(ActionEvent event) throws IOException {
        if (casaDorada.updateClient(code, txtCAddress.getText(), Long.parseLong(txtCPhone.getText()), txtCObser.getText(), tbStateClient.isSelected(),
                casaDorada.getAdminActive(), txtCName.getText(), txtCLastName.getText(), Long.parseLong(txtCID.getText()))){
            showAlert(true, "Se ha actualizodo correctamente el cliente");
            txtCName.clear();
            txtCLastName.clear();
            txtCID.clear();
            txtCPhone.clear();
            txtCAddress.clear();
            txtCObser.clear();
        } else {
            showAlert(false, "Ingresaste una identificación que ya le pertenece a otro usuario, no se actualizo");
            txtCID.clear();
        }
        btnAddClient.setVisible(true);
        tblClients.refresh();
    }
    
    @FXML
    public void onRemoveClient(ActionEvent event) throws IOException {
        if (casaDorada.removeClient(code)) {
            showAlert(true, "Se ha eliminado el cliente seleccionado");
            txtCName.clear();
            txtCLastName.clear();
            txtCID.clear();
            txtCPhone.clear();
            txtCAddress.clear();
            txtCObser.clear();
            onTableClient();
        } else {
            showAlert(false, "No se ha podido eliminar, \nel cliente esta referenciado");
        }
    }
    
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
    
    public void onTableClient() {
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

    public void showListClient() {
        ArrayList<Client> dispClient = new ArrayList<>();
        List<Client> clients = casaDorada.getClient();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCState()) {
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

    //Gestionar Ingrediente
    
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
    private JFXButton btnAddIngredient;

    @FXML
    private JFXButton btnRemoveIngredient;

    @FXML
    private JFXButton btnUptadeIngredient;

    @FXML
    public void onSelectIngredient(MouseEvent event) {
        Ingredient ingredientSelected;
        if (event.getClickCount() == 2) {
            ingredientSelected = tblIngredient.getSelectionModel().getSelectedItem();
            if (ingredientSelected != null) {
                code = ingredientSelected.getIngCode();
                btnAddIngredient.setVisible(false);
                btnRemoveIngredient.setVisible(true);
                btnUptadeIngredient.setVisible(true);
                showAlert(true, "Se ha seleccionado correctamente el ingrediente");
                txtIngName.setText(ingredientSelected.getIngredientsName());
                tbStateIngredients.setSelected(ingredientSelected.getIngredientsState());
            }
        } else if (event.getClickCount() == 1) {
            btnAddIngredient.setVisible(true);
            btnRemoveIngredient.setVisible(false);
            btnUptadeIngredient.setVisible(false);
        }
    }

    @FXML
    private JFXTextField txtIngName;

    @FXML
    private JFXToggleButton tbStateIngredients;

    @FXML
    public void addIngredient(ActionEvent event) throws IOException {
        if (!(txtIngName.getText().equals(""))) {
            casaDorada.addIngredient(0, casaDorada.getCode(), txtIngName.getText(), tbStateIngredients.isSelected(), casaDorada.getAdminActive(), null);
            showAlert(true, "El ingrediente se ha agregado correctamente");
            System.out.println(casaDorada.getCode());
            txtIngName.clear();
            onTableIngredient();
        } else {
            showAlert(false, "No puede agregar un ingrediente sin el nombre");
        }
    }
    
    @FXML
    public void onUptadeIngredient(ActionEvent event) throws IOException {
        casaDorada.updateIngredient(code, txtIngName.getText(), tbStateIngredients.isSelected(), casaDorada.getAdminActive());
        showAlert(true, "Se ha actualizado el ingrediente con exito");
        btnAddIngredient.setVisible(true);
        tblIngredient.refresh();
    }

    @FXML
    public void onRemoveIngredient(ActionEvent event) throws IOException {
        if(casaDorada.removeIngredient(code)){
            showAlert(true, "Se ha eliminado el ingrediente correctamnet");
            onTableIngredient();
            txtIngName.clear();
        } else {
            showAlert(false, "No se ha eliminado el ingrediente,\n el ingrediente se encuntra referenciado");
        }
    }

    @FXML
    private TableView<Ingredient> tblIngredient;

    @FXML
    private TableColumn<Ingredient, String> tblIngredientNameGestion;

    @FXML
    private TableColumn<Ingredient, Boolean> tblIngredientState;

    public void onTableIngredient() {
        List<Ingredient> ingredients = casaDorada.getIngredient();
        ObservableList<Ingredient> newTableIngredient;
        newTableIngredient = FXCollections.observableArrayList(ingredients);

        tblIngredient.setItems(newTableIngredient);
        tblIngredientNameGestion.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
        tblIngredientState.setCellValueFactory(new PropertyValueFactory<>("ingredientsState"));
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
    public void onReportIngredients(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    private TableView<Ingredient> tblIngredientDisp;

    @FXML
    private TableColumn<Ingredient, String> tblIngredientNameDisp;

    public void showListIngredient() {
        ArrayList<Ingredient> dispIngredients = new ArrayList<>();
        List<Ingredient> ingredients = casaDorada.getIngredient();
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getIngredientsState()) {
                dispIngredients.add(ingredients.get(i));
            }
        }
        ObservableList<Ingredient> newTableIngredient;
        newTableIngredient = FXCollections.observableArrayList(dispIngredients);

        tblIngredientDisp.setItems(newTableIngredient);
        tblIngredientNameDisp.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
    }
    
    /*
    Gestionar Tipo de producto
     */
    
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
    private JFXButton btnAddTypeProduct;
    
    @FXML
    private JFXButton btnRemoveType;

    @FXML
    private JFXButton btnUptadeType;
    
    
    @FXML
    public void onSelectType(MouseEvent event) {
        TypeProduct typeProductSelected;
        if (event.getClickCount() == 2) {
            typeProductSelected = tblTypeProduct.getSelectionModel().getSelectedItem();
            if (typeProductSelected != null) {
                code = typeProductSelected.getTpCode();
                btnAddTypeProduct.setVisible(false);
                btnRemoveType.setVisible(true);
                btnUptadeType.setVisible(true);
                showAlert(true, "Se ha seleccionado el tipo de producto correctamente");
                txtTpName.setText(typeProductSelected.getTypeName());
                tbStateTypeProduct.setSelected(typeProductSelected.getTypeState());
            }
        } else if (event.getClickCount() == 1) {
            btnAddTypeProduct.setVisible(true);
            btnRemoveType.setVisible(false);
            btnUptadeType.setVisible(false);
        }
    }
    
    @FXML
    private JFXTextField txtTpName;

    @FXML
    private JFXToggleButton tbStateTypeProduct;
            
    @FXML
    public void addTypeProduct(ActionEvent event) throws IOException {
        if (!(txtTpName.getText().equals(""))) {
            casaDorada.addTypeProduct(0, casaDorada.getCode(), txtTpName.getText(), tbStateTypeProduct.isSelected(), casaDorada.getAdminActive(), null);
            showAlert(true, "Se ha agregado el producto correctamente");
            txtTpName.clear();
            onTableTypeProduct();
        } else {
            showAlert(false, "Debes de ingresarle un nombre al tipo de producto");
        }
    }
    
    @FXML
    public void onUptadeType(ActionEvent event) throws IOException {
        casaDorada.updateTypeProduct(code, txtTpName.getText(), tbStateTypeProduct.isSelected(), casaDorada.getAdminActive());
        showAlert(true, "Se ha actualizado el tipo de producto correctamente");
        btnAddTypeProduct.setVisible(true);
        tblTypeProduct.refresh();
    }
    
    @FXML
    public void onRemoveTypeProduct(ActionEvent event) throws IOException {
        if (casaDorada.removeTypeProduct(code)){
            showAlert(true, "Se ha eliminado el tipo de producto correctamente");
            onTableTypeProduct();
        } else {
            showAlert(false, "No se ha eliminado el tipo de producto,\nel tipo de producto esta referenciado");
        }
    }

    @FXML
    private TableView<TypeProduct> tblTypeProduct;

    @FXML
    private TableColumn<TypeProduct, String> tblTypeProductNameGestion;

    @FXML
    private TableColumn<TypeProduct, Boolean> tblTypeProductState;


    public void onTableTypeProduct() {
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(typeProducts);

        tblTypeProduct.setItems(newTableTypeProduct);
        tblTypeProductNameGestion.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        tblTypeProductState.setCellValueFactory(new PropertyValueFactory<>("typeState"));
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
    private TableView<TypeProduct> tblDispTP;

    @FXML
    private TableColumn<TypeProduct, String> tblDispNameTP;

    public void showListTypeProduct() {
        ArrayList<TypeProduct> dispTypeProduct = new ArrayList<>();
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        for (int i = 0; i < typeProducts.size(); i++) {
            if (typeProducts.get(i).getTypeState()) {
                dispTypeProduct.add(typeProducts.get(i));
            }
        }
        ObservableList<TypeProduct> newTableTypeProduct;
        newTableTypeProduct = FXCollections.observableArrayList(dispTypeProduct);

        tblDispTP.setItems(newTableTypeProduct);
        tblDispNameTP.setCellValueFactory(new PropertyValueFactory<>("typeName"));
    }

    /*
    Gestionar Productos
     */
    @FXML
    private Pane pChooseIng;
    
    @FXML
    private Pane pChooseType;
    
    @FXML
    public void onGestionProducts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ProductsGestion.fxml"));

        fxmlLoader.setController(this);
        Parent productsGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(productsGestion);
        showEmployeeDisp();
        onTableProduct();
    }
    
    @FXML
    private JFXButton btnAddProduct;

    @FXML
    private JFXButton btnRemoveProduct;

    @FXML
    private JFXButton btnUpdateProduct;

    @FXML
    public void onSelectedProduct(MouseEvent event) {
        Product productSelected;
        if (event.getClickCount() == 2) {
            productSelected = tblProduct.getSelectionModel().getSelectedItem();
            if (productSelected != null) {
                code = productSelected.getPrCode();
                btnAddProduct.setVisible(false);
                btnRemoveProduct.setVisible(true);
                btnUpdateProduct.setVisible(true);
                showAlert(true, "Se ha seleccionado el producto correctamente");
                onTableChooseIngredient(showTableActualize(code));
                onTableChooseTypeProduct(showTableActualizeTp(code));
                txtProductName.setText(productSelected.getPrName());
                txtProductSize.setText(productSelected.getPrSize());
                txtProductPrice.setText(String.valueOf(productSelected.getPrPrice()));
                tbStateProduct.setSelected(productSelected.getPrState());
                firstTime = false;
            }
        } else if (event.getClickCount() == 1) {
            code = 0;
            btnAddProduct.setVisible(true);
            btnRemoveProduct.setVisible(false);
            btnUpdateProduct.setVisible(false);
        }
    }

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtProductSize;

    @FXML
    private JFXTextField txtProductPrice;

    @FXML
    private JFXToggleButton tbStateProduct;
    
    @FXML
    public void onAddProduct(ActionEvent event) throws IOException {
        try{
            if (!(txtProductName.getText().equals("")) && !(txtProductSize.getText().equals("")) && !(txtProductPrice.getText().equals(""))) {
                casaDorada.addProduct(casaDorada.getCode(), 0, txtProductName.getText(), txtProductSize.getText(), Double.parseDouble(txtProductPrice.getText()),
                        tbStateProduct.isSelected(), 0, casaDorada.getAdminActive(), null);
                txtProductName.clear();
                txtProductSize.clear();
                txtProductPrice.clear();
                onTableProduct();
                onAddIngredientsToProduct(0);
                showAlert(true, "El producto se ha añadido correctamente");
                firstTime = true;
            } else {
                showAlert(false, "Debes de ingresar todos los campos");
            }
        }catch (NumberFormatException e) {
            showAlert(false, "Has ingresado letras en el campo de precios");
        } catch (Exception e){
        }
    }
    
    public void onAddIngredientsToProduct(int code) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseIngredients.fxml"));

        fxmlLoader.setController(this);
        Parent chooseIngredient = fxmlLoader.load();
        newStage(chooseIngredient);
        showIngredientsDisp();
        onTableChooseIngredient(showTableActualize(code));
    }

    public void onAddTypeToProduct(int code) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseTypeProducts.fxml"));

        fxmlLoader.setController(this);
        Parent chooseTypeProduct = fxmlLoader.load();
        newStage(chooseTypeProduct);
        showTPDisp();
        onTableChooseTypeProduct(showTableActualizeTp(code));
    }
    
    @FXML
    public void onUpdateProduct(ActionEvent event) throws IOException {
        try {
            casaDorada.updateProduct(code, txtProductName.getText(), txtProductSize.getText(), Double.parseDouble(txtProductPrice.getText()),
                    tbStateProduct.isSelected(), casaDorada.getAdminActive());
            btnAddProduct.setVisible(true);
            tblProduct.refresh();
            onAddIngredientsToProduct(code);
            showAlert(true, "Se ha actualizado el producto correctamenta");
        } catch (NumberFormatException e) {
            showAlert(false, "No debes ingresar letras en el precio");
        } catch (Exception e) {
        }
    }
    
    @FXML
    public void onRemoveProduct(ActionEvent event) throws IOException {
        if(casaDorada.removeProduct(code)){
            showAlert(true, "Se ha eliminado correctamente el producto");
            onTableProduct();
        } else {
            showAlert(false, "No se ha eliminado el producto,\nel producto se encuentra referenciado");
        }
    }
    
    @FXML
    private TableView<Product> tblProduct;

    @FXML
    private TableColumn<Product, String> tblProductName;

    @FXML
    private TableColumn<Product, Ingredient> tblProductIng;

    @FXML
    private TableColumn<Product, String> tblProductTp;

    @FXML
    private TableColumn<Product, String> tblProductSize;

    @FXML
    private TableColumn<Product, Double> tblProductPrice;

    @FXML
    private TableColumn<Product, Boolean> tblProductState;
    
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

    @FXML
    private JFXComboBox<Ingredient> cbxIngDisp;
    
    @FXML
    private TableView<Ingredient> tblChooseIngredient;

    @FXML
    private TableColumn<Ingredient, String> tblIngName;
    
    @FXML
    private JFXComboBox<TypeProduct> cbxTypeDisp;

    @FXML
    private TableView<TypeProduct> tblChooseTypeProduct;

    @FXML
    private TableColumn<TypeProduct, String> tblTypeProductName;
    
    private int codeI;
    private int codeTP;
    private boolean firstTime = false;

    public void showIngredientsDisp() {
        ArrayList<Ingredient> ingredientToProduct = new ArrayList<>();
        List<Ingredient> ingredients = casaDorada.getIngredient();
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getIngredientsState()) {
                ingredientToProduct.add(ingredients.get(i));
            }
        }
        ObservableList<Ingredient> obs;
        obs = FXCollections.observableArrayList(ingredientToProduct);

        cbxIngDisp.setItems(obs);
    }
    
    public void showTPDisp() {
        ArrayList<TypeProduct> typeProductToProduct = new ArrayList<>();
        List<TypeProduct> typeProducts = casaDorada.getTypeProduc();
        for (int i = 0; i < typeProducts.size(); i++) {
            if (typeProducts.get(i).getTypeState()) {
                typeProductToProduct.add(typeProducts.get(i));
            }
        }
        ObservableList<TypeProduct> obs;
        obs = FXCollections.observableArrayList(typeProductToProduct);

        cbxTypeDisp.setItems(obs);
    }
    
    @FXML
    public void onSelectIngredientInP(MouseEvent event) {
        Ingredient ingredientInPSelected;
        if (event.getClickCount() == 2) {
            ingredientInPSelected = tblChooseIngredient.getSelectionModel().getSelectedItem();
            if (ingredientInPSelected != null) {
                codeI = ingredientInPSelected.getIngCode();
                showAlert2(true, "Se ha seleccionado el ingrediente correctamente");
            }
        } 
    }
    
    @FXML
    public void onSelectTypeInP(MouseEvent event) {
        TypeProduct typeProductInPSelected;
        if (event.getClickCount() == 2){
            typeProductInPSelected = tblChooseTypeProduct.getSelectionModel().getSelectedItem();
            if (typeProductInPSelected != null) {
                codeTP = typeProductInPSelected.getTpCode();
                showAlert2(true, "Se ha seleccionado correctamente el ingrediente");
            }
        }
    }
        
    @FXML
    public void onAddIngredientToP(ActionEvent event) throws IOException {
        int option;
        if (firstTime) {
            option = casaDorada.getCode()-1;
            firstTime = true;
        } else {
            option = code;
            firstTime = false;
        }
        if (cbxIngDisp.getValue() != null) {
            casaDorada.addIngredientToProduct(option, cbxIngDisp.getValue());
            showAlert2(true, "Se ha agregado el producto");
            onTableChooseIngredient(showTableActualize(option));
        } else {
            showAlert2(true, "No se ha seleccionado un producto");
        }
    }
        
    @FXML
    public void onAddTypeToP(ActionEvent event) throws IOException {
        int option;
        if (firstTime) {
            option = casaDorada.getCode()-1;
        } else {
            option = code;
            firstTime = false;
        }
        if (cbxTypeDisp.getValue() != null) {
            casaDorada.addTypeProductToProduct(option, cbxTypeDisp.getValue());
            showAlert2(true, "Se ha agregado el tipo de producto");
            onTableChooseTypeProduct(showTableActualizeTp(option));
        } else {
            showAlert2(true, "No se ha seleccionado un tipo de producto");
        }
    }
        
    @FXML
    public void onRemoveIngredientInP(ActionEvent event) throws IOException {
        casaDorada.removeIngredientInP(code, codeI);
        showAlert2(true, "El ingrediente ha sido eliminado del producto correctamente");
        onTableChooseIngredient(showTableActualize(code));
    }
    
    @FXML
    public void onRemoveTypeInP(ActionEvent event) throws IOException {
        casaDorada.removeTypeProductInP(code, codeTP);
        showAlert2(true, "El tipo de producto ha sido eliminado");
        onTableChooseTypeProduct(showTableActualizeTp(code));
    }
    
    public ArrayList<Ingredient> showTableActualize(int code){
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < casaDorada.getProduct().size(); i++) {
            if(casaDorada.getProduct().get(i).getPrCode() == code){
                ingredients = casaDorada.getProduct().get(i).getIngredientInProduct();
            }
        }
        return ingredients;
    }
    
    public ArrayList<TypeProduct> showTableActualizeTp(int code){
        ArrayList<TypeProduct> typeProducts = new ArrayList<>();
        for (int i = 0; i < casaDorada.getProduct().size(); i++) {
            if (casaDorada.getProduct().get(i).getPrCode() == code) {
                typeProducts = casaDorada.getProduct().get(i).getTypeProductInProduct();
            }
        }
        return typeProducts;
    }
    
    public void onTableChooseIngredient(ArrayList<Ingredient> ingredients) {
        try{
            ObservableList<Ingredient> newTableIngredient;
            newTableIngredient = FXCollections.observableArrayList(ingredients);

            tblChooseIngredient.setItems(newTableIngredient);
            tblIngName.setCellValueFactory(new PropertyValueFactory<>("ingredientsName"));
        } catch (NullPointerException e){
            
        }

    }
    
    public void onTableChooseTypeProduct(ArrayList<TypeProduct> typeProducts) {
        try {
            ObservableList<TypeProduct> newTableTypeProduct;
            newTableTypeProduct = FXCollections.observableArrayList(typeProducts);
            
            tblChooseTypeProduct.setItems(newTableTypeProduct);
            tblTypeProductName.setCellValueFactory(new PropertyValueFactory<>("typeName"));
        } catch (NullPointerException e) {

        }
    }

    @FXML
    public void onNextChooseTypeIngredients(ActionEvent event) throws IOException {
        Stage stage = (Stage) pChooseIng.getScene().getWindow();
        stage.close();
        
        if(firstTime){
            onAddTypeToProduct(casaDorada.getCode()-1);
        } else {
            onAddTypeToProduct(code);
        }
        
    }

    @FXML
    public void onFinishAddProduct(ActionEvent event) {
        Stage stage = (Stage) pChooseType.getScene().getWindow();
        stage.close();
    }
        
    @FXML
    public void onLIstProducts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListProducts.fxml"));

        fxmlLoader.setController(this);
        Parent listProducts = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listProducts);
    }
    
    /*
    Gestionar Ordenes
    */
    
    @FXML
    private Pane pSearchClient;

    @FXML
    private Pane pChooseProduct;

    public Date convertToHour(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
    
    @FXML
    public void onGestionOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/OrderGestion.fxml"));

        fxmlLoader.setController(this);
        Parent orderGestion = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(orderGestion);
        showEmployeeDisp();
        onTableOrder();
    }
        
    @FXML
    private JFXButton btnAddOrder;

    @FXML
    private JFXButton onRemoveOrder;

    @FXML
    private JFXButton btnUpdateOrder;
    
    @FXML
    public void onSelectOrder(MouseEvent event) {

    }

    @FXML
    private ToggleGroup statusOrder;

    @FXML
    private JFXRadioButton rbSolited;

    @FXML
    private JFXRadioButton rbProccess;

    @FXML
    private JFXRadioButton rbSent;

    @FXML
    private JFXRadioButton rbRecieved;
    
    
    @FXML
    private JFXToggleButton tbStateOrder;


    @FXML
    private JFXTextField txtObserOrder;

    @FXML
    private JFXComboBox<String> cbxEmployeeOrder;

    public boolean firstTimeOrder = false;
    
    @FXML
    public void onAddOrder(ActionEvent event) throws IOException {
        try {
            if(cbxEmployeeOrder.getValue() != null){
                casaDorada.addOrder(casaDorada.getCode(), statusSelected(getStatusOrder()), convertToHour(LocalDateTime.now()), 
                                    txtObserOrder.getText(), tbStateOrder.isSelected(), null, getEmployeeSelected(cbxEmployeeOrder.getValue()), casaDorada.getAdminActive(), null);
                txtObserOrder.clear();
                onTableOrder();
                onChooseClient();
                showAlert(true, "Se ha agregado correctamente el pedido");
                firstTimeOrder = true;
            } else {
                showAlert(false, "No puedes crear una orden sin asignar a un empleado encargado");
            }
        } catch (NumberFormatException e) {
            showAlert(false, "Ingresa los valores bien");
        } catch (Exception e) {
        }
        
    }
    
    public int getStatusOrder(){
        int option = 1;
        if (rbSolited.isSelected()) {
            option = 1;
        } else if (rbProccess.isSelected()){
            option = 2;
        } else if (rbSent.isSelected()){
            option = 3;
        } else if (rbRecieved.isSelected()){
            option = 4;
        }
        return option;
    }
    
    public StatusOrder statusSelected(int option){
        StatusOrder status = StatusOrder.SOLICITADO;
        switch(option){
            case 1:
                status = StatusOrder.SOLICITADO;
                break;
            case 2:
                status = StatusOrder.EN_PROCESO;
                break;
            case 3:
                status = StatusOrder.ENVIADO;
                break;
            case 4:
                status = StatusOrder.ENTREGADO;
                break;
        }
        return status;
    }
    
    public void showEmployeeDisp(){
        try{
            ArrayList<Employee> employeeToOrder = new ArrayList<>();
            List<Employee> employees = casaDorada.getEmployee();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEState()) {
                    employeeToOrder.add(employees.get(i));
                }
            }
            ArrayList<String> nameEmployees = new ArrayList<>();
            for (int i = 0; i < employeeToOrder.size(); i++) {
                nameEmployees.add(employeeToOrder.get(i).getNameLN());
            }
            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(nameEmployees);
            cbxEmployeeOrder.setItems(obs);
        } catch (NullPointerException e){ 
        }
    }
    
    public Employee getEmployeeSelected(String name){
        String [] nameSplit = name.split(" ");
        for (int i = 0; i < casaDorada.getEmployee().size(); i++) {
            if (casaDorada.getEmployee().get(i).getName().equals(nameSplit[0]) && casaDorada.getEmployee().get(i).getLastName().equals(nameSplit[1])) {
                return casaDorada.getEmployee().get(i);
            }
        }
        return null;
    }
    
    @FXML
    private TableView<Order> tblOrder;

    @FXML
    private TableColumn<Order, StatusOrder> tblStatusOrder;

    @FXML
    private TableColumn<Order, String> tblProductsOrder;

    @FXML
    private TableColumn<Order, String> tblAmounxProducts;

    @FXML
    private TableColumn<Order, String> tblClientOrder;

    @FXML
    private TableColumn<Order, String> tblEmployeeOrder;

    @FXML
    private TableColumn<Order, String> tblObserOrder;
    
    public void onTableOrder(){
        List<Order> orders = casaDorada.getOrders();
        ObservableList<Order> newTableOrder;
        newTableOrder = FXCollections.observableArrayList(orders);
        
        tblOrder.setItems(newTableOrder);
        tblStatusOrder.setCellValueFactory(new PropertyValueFactory<>("Status"));
        tblObserOrder.setCellValueFactory(new PropertyValueFactory<>("observatinos"));
    }
    
    public void onChooseClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SearchClient.fxml"));

        fxmlLoader.setController(this);
        Parent searchClient = fxmlLoader.load();
        newStage(searchClient);
        onLoadTableFilter(null);
    }
        
    @FXML
    private TableView<Client> tblClientDisp;

    @FXML
    private TableColumn<Client, String> tblNameClientDisp;

    @FXML
    private TableColumn<Client, String> tblLNClientDisp;

    @FXML
    private TableColumn<Client, Long> tblIDClientDisp;
    
    public void onLoadTableFilter(List<Client> selected){
        List<Client> clients = new ArrayList<>();
        if (selected == null){
            for (int i = 0; i < casaDorada.getClient().size(); i++) {
                if (casaDorada.getClient().get(i).getCState()) {
                    clients = casaDorada.getClient();
                }
            }
        } else {
            for (int i = 0; i < selected.size(); i++) {
                clients.add(selected.get(i));
            }
        }
        ObservableList<Client> newTableSearchClient;
        newTableSearchClient = FXCollections.observableArrayList(clients);

        tblClientDisp.setItems(newTableSearchClient);
        tblNameClientDisp.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblLNClientDisp.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblIDClientDisp.setCellValueFactory(new PropertyValueFactory<>("ID"));
    }

    @FXML
    private JFXTextField txtSearchClient;
 
    
    @FXML
    public void onSearchClient(ActionEvent event) {
        if(!txtSearchClient.getText().equals("")){
            onLoadTableFilter(casaDorada.binaryClient(casaDorada.getClient(), txtSearchClient.getText()));
            showAlert2(true, "Se ha buscado el cliente");
        } else {
            showAlert2(false, "Debes ingresar un nombre para buscar");
        }
    }
    
    int codeCO;
    
    @FXML
    public void onSelectClientToOrder(MouseEvent event) {
        Client clientInOrder;
        if (event.getClickCount() == 2) {
            clientInOrder = tblClientDisp.getSelectionModel().getSelectedItem();
            if (clientInOrder != null) {
               codeCO = clientInOrder.getPCode();
               showAlert2(true, "se ha seleccionado el empleado\nSi deseas agregarlo presiona el boton agregar");
            }
        }
    }
    
    @FXML
    public void onAddClientToOrder(ActionEvent event) {
        for (int i = 0; i < casaDorada.getClient().size(); i++) {
            if(casaDorada.getClient().get(i).getPCode() == codeCO){
                if(casaDorada.getOrders().get(casaDorada.getCode()-1).getrClient() == null){
                    //casaDorada.getOrders.get(casaDorada.getCode() - 1).setrClient(casaDorada.getClient().get(i));
                    showAlert2(true, "Se ha agregado el cliente");
                }
                showAlert2(false, "No se ha seleccionado un producto");
            } else 
                showAlert2(false, "No se ha seleccionado un producto");
        }
    }
    
    @FXML
    public void onExitSearchClient(ActionEvent event) throws IOException {
        Stage stage = (Stage) pSearchClient.getScene().getWindow();
        stage.close();
        onChooseProduct();
    }
    
    public void onChooseProduct() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ChooseProducts.fxml"));

        fxmlLoader.setController(this);
        Parent chooseProduct = fxmlLoader.load();
        newStage(chooseProduct);
    }
    
    @FXML
    public void onFinishOrder(ActionEvent event) {
        Stage stage = (Stage) pChooseProduct.getScene().getWindow();
        stage.close();
    }
    

    @FXML
    public void onRemoveOrder(ActionEvent event) {

    }

    @FXML
    public void onUpdateOrder(ActionEvent event) {

    }

    @FXML
    public void onListOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListOrder.fxml"));

        fxmlLoader.setController(this);
        Parent listOrder = fxmlLoader.load();

        pNewOption.getChildren().clear();
        pNewOption.getChildren().setAll(listOrder);
    }


    @FXML
    void onRemoveClientInOrder(ActionEvent event) {

    }

    @FXML
    void onSelectClientSearch(MouseEvent event) {

    }

    @FXML
    void onSelectClientInOrder(MouseEvent event) {

    }
    
    @FXML
    void onRemoveProductInOrder(ActionEvent event) {

    }

    @FXML
    void onSelectProductInOrder(MouseEvent event) {

    }
    
    @FXML
    void onAddProductInOrder(ActionEvent event) {

    }










    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Generar reportes
    @FXML
    private Pane pSelectDate;
    
        @FXML
    public void onReportOrder(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    public void onReportProducts(ActionEvent event) throws IOException {
        openSelectDate();
    }

    @FXML
    public void onExitSelectDate(ActionEvent event) {
        Stage stage = (Stage) pSelectDate.getScene().getWindow();
        stage.close();
    }
}
