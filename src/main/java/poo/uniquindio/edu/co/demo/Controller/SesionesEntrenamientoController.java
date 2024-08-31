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
import poo.uniquindio.edu.co.demo.Model.NivelDificultad;
 
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
 
   @FXML
   private ComboBox<Deporte> deporte_ComboBox;
 
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
   void SeleccionarDeporte(ActionEvent event) {

   }

   @FXML
   void SeleccionarEstado(ActionEvent event) {

   }
   @FXML
   void VerSesionPorFecha(ActionEvent event) {
      LocalDate fecha = fechaSesion.getValue();
      sesionCreada_txt.setText(club.administrador.mostrarSesionesPorFecha(fecha));


      fechaSesion.setValue(null);
      txtDuracion.setText("");
      txtEntrenador.setText("");
      txtMiembro.setText("");
      estadoSesion_ComboBox.setValue(null);
      deporte_ComboBox.setValue(null);
      txtIdentificador.setText("");
   }
 
   @FXML
   void VerSesiones(ActionEvent event) {

      sesionCreada_txt.setText(club.administrador.gestionarInscripciones());


      fechaSesion.setValue(null);
      txtDuracion.setText("");
      txtEntrenador.setText("");
      txtMiembro.setText("");
      estadoSesion_ComboBox.setValue(null);
      deporte_ComboBox.setValue(null);
      txtIdentificador.setText("");
   }
 
   @FXML
   void eliminarSesion(ActionEvent event) {

      String identificador = txtIdentificador.getText();
      sesionCreada_txt.setText(club.administrador.eliminarSesion(identificador));

      fechaSesion.setValue(null);
      txtDuracion.setText("");
      txtEntrenador.setText("");
      txtMiembro.setText("");
      estadoSesion_ComboBox.setValue(null);
      deporte_ComboBox.setValue(null);
      txtIdentificador.setText("");
 
   }
 
   @FXML
   void programarSesion(ActionEvent event) {
        
      LocalDate fecha = fechaSesion.getValue();
      String duracionStr = txtDuracion.getText();
      float duracion = Float.parseFloat(duracionStr);
      String nomrbreEntrenador = txtEntrenador.getText();
      Entrenador entrenador = club.administrador.buscarEntrenadorPorNombre(nomrbreEntrenador);
      String idMiembro = txtMiembro.getText();
      Miembro miembro = club.administrador.buscarMiembroPorId(idMiembro);
      Deporte deporte = deporte_ComboBox.getSelectionModel().getSelectedItem();
      String estadoSesion = estadoSesion_ComboBox.getSelectionModel().getSelectedItem().toString();
      String identificador = txtIdentificador.getText();

      
      sesionCreada_txt.setText(club.administrador.programarSesion(fecha, duracion, entrenador, miembro, deporte, estadoSesion, identificador));
        

       
      fechaSesion.setValue(null);
      txtDuracion.setText("");
      txtEntrenador.setText("");
      txtMiembro.setText("");
      estadoSesion_ComboBox.setValue(null);
      deporte_ComboBox.setValue(null);
      txtIdentificador.setText("");
   }
 
   @FXML // This method is called by the FXMLLoader when initialization is complete
   void initialize() {
      assert eliminarSesion_btn != null : "fx:id=\"eliminarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert estadoSesion_ComboBox != null : "fx:id=\"estadoSesion_ComboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert fechaSesion != null : "fx:id=\"fechaSesion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert programarSesion_btn != null : "fx:id=\"programarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert sesionCreada_txt != null : "fx:id=\"sesionCreada_txt\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert deporte_ComboBox != null : "fx:id=\"deporte_ComboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert txtDuracion != null : "fx:id=\"txtDuracion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert txtEntrenador != null : "fx:id=\"txtEntrenador\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert txtMiembro != null : "fx:id=\"txtMiembro\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert verSesionFecha_btn != null : "fx:id=\"verSesionFecha_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      assert verSesiones_btn != null : "fx:id=\"verSesiones_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
      ObservableList<EstadoSesion> estadoSesion = FXCollections.observableArrayList(EstadoSesion.values());
      estadoSesion_ComboBox.setItems(estadoSesion);
      estadoSesion_ComboBox.getSelectionModel();
     
      ObservableList<Deporte> deportes = FXCollections.observableArrayList(
         new Deporte("Fútbol", "Deporte de contacto", null, NivelDificultad.BAJO),
         new Deporte("Baloncesto", "Deporte de contacto", null, NivelDificultad.MEDIO),
         new Deporte("Tenis", "Deporte de habilidad", null, NivelDificultad.ALTO));
         deporte_ComboBox.setItems(deportes);


      

   }
 
}
 