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
    private ComboBox<TipoGestion> comb;

    @FXML
    void Seleccionar(ActionEvent event) throws IOException {
        TipoGestion operacionSeleccionada = comb.getSelectionModel().getSelectedItem();

        switch (operacionSeleccionada) {
            case ADMINISTRADOR:
                mostrarVentana("Administrador-view");
                break;
            case ENTRENADOR:
                mostrarVentana("Entrenador-view");
                break;
            case MIEMBRO:
                mostrarVentana("Miembro-view");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TipoGestion> tiposOperacion = FXCollections.observableArrayList(TipoGestion.values());
        comb.setItems(tiposOperacion);
        comb.getSelectionModel();
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
