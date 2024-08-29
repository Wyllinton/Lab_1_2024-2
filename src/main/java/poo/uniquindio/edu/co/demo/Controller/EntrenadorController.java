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

public class EntrenadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNPermutacion;

    @FXML
    private Button btnCalcularPermutacion;

    @FXML
    private Label txtAreaPermutacion;

    @FXML
    private Button btnAtrasPermutacion;

    @FXML
    void atrasPermutacion(ActionEvent event) throws IOException {
         App.setRoot("ClubDeportivoView");
    }

    @FXML
    void calcularPermutacion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtNPermutacion != null : "fx:id=\"txtNPermutacion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnCalcularPermutacion != null : "fx:id=\"btnCalcularPermutacion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert txtAreaPermutacion != null : "fx:id=\"txtAreaPermutacion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnAtrasPermutacion != null : "fx:id=\"btnAtrasPermutacion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";

    }
}


