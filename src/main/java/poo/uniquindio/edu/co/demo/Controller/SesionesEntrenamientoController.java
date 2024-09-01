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
import poo.uniquindio.edu.co.demo.Model.TipoMiembro;

public class SesionesEntrenamientoController{

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

      @FXML
      private ComboBox<Entrenador> entrenador_comboBox;

      @FXML // fx:id="txtIdentificador"
      private TextField txtIdentificador; // Value injected by FXMLLoader

      @FXML
      private ComboBox<Miembro> miembro_comboBox;

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
            entrenador_comboBox.setValue(null);
            miembro_comboBox.setValue(null);
            estadoSesion_ComboBox.setValue(null);
            deporte_ComboBox.setValue(null);
            txtIdentificador.setText("");
      }

      @FXML
      void VerSesiones(ActionEvent event) {

            sesionCreada_txt.setText(club.administrador.gestionarInscripciones());

            fechaSesion.setValue(null);
            txtDuracion.setText("");
            entrenador_comboBox.setValue(null);
            miembro_comboBox.setValue(null);
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
            entrenador_comboBox.setValue(null);
            miembro_comboBox.setValue(null);
            estadoSesion_ComboBox.setValue(null);
            deporte_ComboBox.setValue(null);
            txtIdentificador.setText("");

      }

      @FXML
      void programarSesion(ActionEvent event) {

            LocalDate fecha = fechaSesion.getValue();
            String duracionStr = txtDuracion.getText();
            float duracion = Float.parseFloat(duracionStr);
            // String nomrbreEntrenador = txtEntrenador.getText();
            // Entrenador entrenador =
            // club.administrador.buscarEntrenadorPorNombre(nomrbreEntrenador);
            // String idMiembro = txtMiembro.getText();
            // Miembro miembro = club.administrador.buscarMiembroPorId(idMiembro);
            Deporte deporte = deporte_ComboBox.getSelectionModel().getSelectedItem();
            Entrenador entrenador = entrenador_comboBox.getSelectionModel().getSelectedItem();
            Miembro miembro = miembro_comboBox.getSelectionModel().getSelectedItem();
            // club.administrador.comprobarMiembroDeporte(miembro, deporte);
            String estadoSesion = estadoSesion_ComboBox.getSelectionModel().getSelectedItem().toString();
            String identificador = txtIdentificador.getText();

            sesionCreada_txt.setText(club.administrador.programarSesion(fecha, duracion, entrenador, miembro, deporte,
                        estadoSesion, identificador));

            fechaSesion.setValue(null);
            txtDuracion.setText("");
            entrenador_comboBox.setValue(null);
            miembro_comboBox.setValue(null);
            estadoSesion_ComboBox.setValue(null);
            deporte_ComboBox.setValue(null);
            txtIdentificador.setText("");
      }

      @FXML // This method is called by the FXMLLoader when initialization is complete
      void initialize() {
            ObservableList<EstadoSesion> estadoSesion = FXCollections.observableArrayList(EstadoSesion.values());
            estadoSesion_ComboBox.setItems(estadoSesion);
            estadoSesion_ComboBox.getSelectionModel();

            ObservableList<Deporte> deportes = FXCollections.observableArrayList(
                  new Deporte("Fútbol", "Deporte de contacto", null, NivelDificultad.BAJO),
                  new Deporte("Baloncesto", "Deporte de contacto", null, NivelDificultad.MEDIO),
                  new Deporte("Tenis", "Deporte de habilidad", null, NivelDificultad.ALTO));
            deporte_ComboBox.setItems(deportes);

            ObservableList<Miembro> miembros = FXCollections.observableArrayList(
                  new Miembro("Juan", "0001", TipoMiembro.JUVENIL, "juan.perez@correo.com"),
                  new Miembro("Pedro", "0002", TipoMiembro.JUVENIL, "pedro@ans.com"),
                  new Miembro("Milena", "0003", TipoMiembro.ADULTO, "mile@ans.com"),
                  new Miembro("Andrea", "0004", TipoMiembro.JUVENIL, "andrea@ans.com"),
                  new Miembro("Marlon", "0005", TipoMiembro.ADULTO, "marlo@ans.com"));
            miembro_comboBox.setItems(miembros);

            ObservableList<Entrenador> entrenadores = FXCollections.observableArrayList(
                  new Entrenador("","",new Deporte("Fútbol", "Deporte de contacto", null, NivelDificultad.BAJO)),
                  new Entrenador("","", new Deporte("Baloncesto", "Deporte de contacto", null, NivelDificultad.MEDIO)),
                  new Entrenador("","", new Deporte("Tenis", "Deporte de habilidad", null, NivelDificultad.ALTO)),
                  new Entrenador("","",new Deporte("Fútbol", "Deporte de contacto", null, NivelDificultad.BAJO))
                        );
            entrenador_comboBox.setItems(entrenadores);
            assert eliminarSesion_btn != null
                        : "fx:id=\"eliminarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert estadoSesion_ComboBox != null
                        : "fx:id=\"estadoSesion_ComboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert fechaSesion != null
                        : "fx:id=\"fechaSesion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert programarSesion_btn != null
                        : "fx:id=\"programarSesion_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert sesionCreada_txt != null
                        : "fx:id=\"sesionCreada_txt\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert deporte_ComboBox != null
                        : "fx:id=\"deporte_ComboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert txtDuracion != null
                        : "fx:id=\"txtDuracion\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert entrenador_comboBox != null
                        : "fx:id=\"entrenador_comboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert miembro_comboBox != null
                        : "fx:id=\"miembro_comboBox\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert verSesionFecha_btn != null
                        : "fx:id=\"verSesionFecha_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";
            assert verSesiones_btn != null
                        : "fx:id=\"verSesiones_btn\" was not injected: check your FXML file 'SesionesEntrenamientoView.fxml'.";

      }

}
