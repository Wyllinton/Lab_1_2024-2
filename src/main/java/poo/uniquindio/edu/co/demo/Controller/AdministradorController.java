package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import poo.uniquindio.edu.co.demo.Model.Administrador;

public class AdministradorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombreAdmin;

    @FXML
    private TextField txtIdAdmin;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label txtAreaCombinatoria;

    @FXML
    private TableView<Administrador> tblAdmin;

    @FXML
    private TableColumn<Administrador, String> clNombreAdmin;

    @FXML
    private TableColumn<Administrador, String> clNumeroId;

    @FXML
    private TableColumn<Administrador, String> clCorreo;

    @FXML
    private TextField txtCorreo;

    private ObservableList<Administrador> admins;

    @FXML
    void registrarAdministrador(ActionEvent event) {
        String nombre = this.txtNombreAdmin.getText();
        String numeroId = this.txtNombreAdmin.getText();
        String correo = this.txtCorreo.getText();

        Administrador admin = new Administrador(nombre, numeroId, correo);

        if (!this.admins.contains(admin) && !(nombre != null && numeroId != null)) {
            this.admins.add(admin);
            this.tblAdmin.setItems(admins);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El miembro ya se encuentra registrado");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        admins = FXCollections.observableArrayList();
        this.clNombreAdmin.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clNumeroId.setCellValueFactory(new PropertyValueFactory<>("numeroId"));
        this.clCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        assert txtNombreAdmin != null : "fx:id=\"txtNombreAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert txtIdAdmin != null : "fx:id=\"txtIdAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert txtAreaCombinatoria != null : "fx:id=\"txtAreaCombinatoria\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert tblAdmin != null : "fx:id=\"tblAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert clNombreAdmin != null : "fx:id=\"clNombreAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert clNumeroId != null : "fx:id=\"clNumeroId\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert clCorreo != null : "fx:id=\"clCorreo\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'AdministradorView.fxml'.";

    }
}
