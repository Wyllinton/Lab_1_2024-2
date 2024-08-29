package poo.uniquindio.edu.co.demo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import poo.uniquindio.edu.co.demo.App;

public class ClubDeportivoController implements Initializable {

    @FXML
    private ComboBox<TipoGestion> seleccionar_comboBox;

    @FXML
    void Seleccionar(ActionEvent event) throws IOException {
        TipoGestion operacionSeleccionada = seleccionar_comboBox.getSelectionModel().getSelectedItem();

        switch (operacionSeleccionada) {
            case ADMINISTRADOR:
                mostrarVentana("AdministradorView");
                break;
            case ENTRENADOR:
                mostrarVentana("EntrenadorView");
                break;
            case MIEMBRO:
                mostrarVentana("MiembroView");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TipoGestion> tiposOperacion = FXCollections.observableArrayList(TipoGestion.values());
        seleccionar_comboBox.setItems(tiposOperacion);
        seleccionar_comboBox.getSelectionModel();
    }

    private void mostrarVentana(String tituloVentana) throws IOException {
        App.setRoot(tituloVentana);
    }
    
    public enum TipoGestion {
        ADMINISTRADOR,
        ENTRENADOR,
        MIEMBRO
    }

}
