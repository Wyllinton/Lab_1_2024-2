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

public class MiembroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNVariaciones;

    @FXML
    private TextField txtKVariaciones;

    @FXML
    private Button btnCalcularVariaciones;

    @FXML
    private Label txtAraeVariaciones;

    @FXML
    private Button btnAtrasVariacion;

    @FXML
    void atrasVariaciones(ActionEvent event) throws IOException {
         App.setRoot("ClubDeportivoView");
    }

    @FXML
    void calcularVariaciones(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtNVariaciones != null : "fx:id=\"txtNVariaciones\" was not injected: check your FXML file 'Miembro-view.fxml'.";
        assert txtKVariaciones != null : "fx:id=\"txtKVariaciones\" was not injected: check your FXML file 'Miembro-view.fxml'.";
        assert btnCalcularVariaciones != null : "fx:id=\"btnCalcularVariaciones\" was not injected: check your FXML file 'Miembro-view.fxml'.";
        assert txtAraeVariaciones != null : "fx:id=\"txtAraeVariaciones\" was not injected: check your FXML file 'Miembro-view.fxml'.";
        assert btnAtrasVariacion != null : "fx:id=\"btnAtrasVariacion\" was not injected: check your FXML file 'Miembro-view.fxml'.";

    }
}

