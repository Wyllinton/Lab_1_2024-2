package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    void registrarAdministrador(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtNombreAdmin != null : "fx:id=\"txtNombreAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert txtIdAdmin != null : "fx:id=\"txtIdAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert txtAreaCombinatoria != null : "fx:id=\"txtAreaCombinatoria\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert tblAdmin != null : "fx:id=\"tblAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert clNombreAdmin != null : "fx:id=\"clNombreAdmin\" was not injected: check your FXML file 'AdministradorView.fxml'.";
        assert clNumeroId != null : "fx:id=\"clNumeroId\" was not injected: check your FXML file 'AdministradorView.fxml'.";

    }
}

