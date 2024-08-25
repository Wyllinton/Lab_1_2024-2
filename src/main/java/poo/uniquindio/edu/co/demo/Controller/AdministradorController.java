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

public class AdministradorController implements Initializable{
        @FXML
    private ComboBox<TipoOperacion> comb;

    @FXML
    void Seleccionar(ActionEvent event) throws IOException {
        TipoOperacion operacionSeleccionada = comb.getSelectionModel().getSelectedItem();

        switch (operacionSeleccionada) {
            case PERMUTACION:
                mostrarVentana("Permutacion");        
                break;
            case VARIACIONES:
                mostrarVentana("Variaciones");
                break;
            case COMBINATORIA:
                mostrarVentana("Combinatoria");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TipoOperacion> tiposOperacion = FXCollections.observableArrayList(TipoOperacion.values());
        comb.setItems(tiposOperacion);
        comb.getSelectionModel();
    }

    private void mostrarVentana(String tituloVentana) throws IOException {
        App.setRoot(tituloVentana);
    }
    

    public enum TipoOperacion {
        PERMUTACION,
        VARIACIONES,
        COMBINATORIA
    }

}
