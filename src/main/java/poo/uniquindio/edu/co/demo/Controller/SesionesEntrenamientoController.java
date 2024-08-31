package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import poo.uniquindio.edu.co.demo.Model.ClubDeportivo;
import poo.uniquindio.edu.co.demo.Model.Deporte;
import poo.uniquindio.edu.co.demo.Model.Entrenador;
import poo.uniquindio.edu.co.demo.Model.EstadoSesion;
import poo.uniquindio.edu.co.demo.Model.Miembro;
 
 public class SesionesEntrenamientoController {
 
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
 
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
 
    @FXML // fx:id="eliminarSesion_btn"
    private Button eliminarSesion_btn; // Value injected by FXMLLoader
 
    @FXML // fx:id="estadoSesion_ComboBox"
    private ComboBox<EstadoSesion> estadoSesion_ComboBox; // Value injected by FXMLLoader
 
    @FXML // fx:id="fechaSesion"
    private DatePicker fechaSesion; // Value injected by FXMLLoader
 
    @FXML // fx:id="programarSesion_btn"
    private Button programarSesion_btn; // Value injected by FXMLLoader
 
    @FXML // fx:id="sesionCreada_txt"
    private Text sesionCreada_txt; // Value injected by FXMLLoader
 
    @FXML // fx:id="txtDeporte"
    private TextField txtDeporte; // Value injected by FXMLLoader
 
    @FXML // fx:id="txtDuracion"
    private TextField txtDuracion; // Value injected by FXMLLoader
 
    @FXML // fx:id="txtEntrenador"
    private TextField txtEntrenador; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdentificador"
    private TextField txtIdentificador; // Value injected by FXMLLoader
 
    @FXML // fx:id="txtMiembro"
    private TextField txtMiembro; // Value injected by FXMLLoader
 
    @FXML // fx:id="verSesionFecha_btn"
    private Button verSesionFecha_btn; // Value injected by FXMLLoader
 
    @FXML // fx:id="verSesiones_btn"
    private Button verSesiones_btn; // Value injected by FXMLLoader


    ClubDeportivo club = new ClubDeportivo("");
 
    @FXML
    void Seleccionar(ActionEvent event) {
 
    }
 
    @FXML
    void VerSesionPorFecha(ActionEvent event) {
 
    }
 
    @FXML
    void VerSesiones(ActionEvent event) {
 
    }
 
    @FXML
    void eliminarSesion(ActionEvent event) {
 
    }
 
    @FXML
    void programarSesion(ActionEvent event) {
        
        LocalDate fecha = fechaSesion.getValue();
        float duracion = txtDuracion.getText();
        Entrenador entrenador = txtEntrenador.getText();
        Miembro miembro = txtMiembro.getText();
        Deporte deporte = txtDeporte.getText();
        String estadoSesion = estadoSesion_ComboBox.getSelectionModel().getSelectedItem().toString();
        String identificador = txtIdentificador.getText();
        
        sesionCreada_txt.setText(club.administrador.programarSesion(fecha, duracion, entrenador, miembro, deporte, estadoSesion, identificador));
        

       
        fecha.setValue(null);
        txtDuracion.setText("");
        txtEntrenador.setText("");
        txtMiembro.setText("");
        estadoSesion_ComboBox.setValue(null);
        txtDeporte.setText("");
        txtIdentificador.setText("");
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
        assert eliminarSesion_btn != null : "fx:id=\"eliminarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert estadoSesion_ComboBox != null : "fx:id=\"estadoSesion_ComboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert fechaSesion != null : "fx:id=\"fechaSesion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert programarSesion_btn != null : "fx:id=\"programarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert sesionCreada_txt != null : "fx:id=\"sesionCreada_txt\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert txtDeporte != null : "fx:id=\"txtDeporte\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert txtDuracion != null : "fx:id=\"txtDuracion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert txtEntrenador != null : "fx:id=\"txtEntrenador\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert txtMiembro != null : "fx:id=\"txtMiembro\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert verSesionFecha_btn != null : "fx:id=\"verSesionFecha_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        assert verSesiones_btn != null : "fx:id=\"verSesiones_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
        ObservableList<EstadoSesion> estadoSesion = FXCollections.observableArrayList(EstadoSesion.values());
        estadoSesion_ComboBox.setItems(estadoSesion);
        estadoSesion_ComboBox.getSelectionModel();
     }
 
 }
 