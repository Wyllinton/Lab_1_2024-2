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

public class EntrenadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label txtAreaPermutacion;

    @FXML
    private TextField txtNombreEntrenador;

    @FXML
    private TextField txtDeporte;

    @FXML
    private TableView<?> tblEntrenador;

    @FXML
    private TableColumn<?, ?> clNombreEntrenador;

    @FXML
    private TableColumn<?, ?> clDeporte;

    @FXML
    private TableColumn<?, ?> clDescripcion;

    @FXML
    void registrarEntrenador(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert txtAreaPermutacion != null : "fx:id=\"txtAreaPermutacion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert txtNombreEntrenador != null : "fx:id=\"txtNombreEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert txtDeporte != null : "fx:id=\"txtDeporte\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert tblEntrenador != null : "fx:id=\"tblEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clNombreEntrenador != null : "fx:id=\"clNombreEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clDeporte != null : "fx:id=\"clDeporte\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clDescripcion != null : "fx:id=\"clDescripcion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";

    }
}



