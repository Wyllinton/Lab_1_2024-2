package poo.uniquindio.edu.co.demo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import poo.uniquindio.edu.co.demo.App;

public class AdministradorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNCombinatoria;

    @FXML
    private TextField txtKCombinatoria;

    @FXML
    private Button btnCalcularCombinatoria;

    @FXML
    private Label txtAreaCombinatoria;

    @FXML
    private Button btnAtrasCombinatoria;

    @FXML
    void atrasCombinatoria(ActionEvent event) throws IOException {
        App.setRoot("ClubDeportivoView");
    }

    @FXML
    void calcularCombinatoria(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtNCombinatoria != null
                : "fx:id=\"txtNCombinatoria\" was not injected: check your FXML file 'Administrador.fxml'.";
        assert txtKCombinatoria != null
                : "fx:id=\"txtKCombinatoria\" was not injected: check your FXML file 'Administrador.fxml'.";
        assert btnCalcularCombinatoria != null
                : "fx:id=\"btnCalcularCombinatoria\" was not injected: check your FXML file 'Administrador.fxml'.";
        assert txtAreaCombinatoria != null
                : "fx:id=\"txtAreaCombinatoria\" was not injected: check your FXML file 'Administrador.fxml'.";

    }
}
