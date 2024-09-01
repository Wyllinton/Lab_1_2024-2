package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import poo.uniquindio.edu.co.demo.Model.ClubDeportivo;
import poo.uniquindio.edu.co.demo.Model.Deporte;
import poo.uniquindio.edu.co.demo.Model.Entrenador;
import poo.uniquindio.edu.co.demo.Model.NivelDificultad;

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
    private TextField txtNombreEntrenador;

    @FXML
    private ComboBox<Deporte> cbDeporte;

    @FXML
    private TableView<Entrenador> tblEntrenador;

    @FXML
    private TableColumn<Entrenador, String> clNombreEntrenador;

    @FXML
    private TableColumn<Entrenador, String> clDeporte;

    @FXML
    private TableColumn<Entrenador, String> clDescripcion;

    private ObservableList<Entrenador> entrenadores;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    ClubDeportivo club = new ClubDeportivo("");

    @FXML
    void registrarEntrenador(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        String nombre = txtNombreEntrenador.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        if (nombre.isEmpty() || cbDeporte == null || descripcion.isEmpty()) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos son requeridos");
            alert.showAndWait();
        }
        Entrenador entrenador = new Entrenador(nombre, descripcion, cbDeporte.getSelectionModel().getSelectedItem());

        club.administrador.registrarEntrenador(entrenador);

        if (entrenadorYaExiste(entrenador)) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El Entrenador ya se encuentra registrado");
            alert.showAndWait();
        } else {
            this.entrenadores.add(entrenador);
            this.tblEntrenador.setItems(entrenadores); // Actualizar los items de la TableView
            // this.tblMiembros.refresh(); Refrescar la TableView
            limpiarCampos();

            // Mostrar alerta de éxito
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Éxito");
            successAlert.setContentText("Entrenador registrado correctamente");
            successAlert.showAndWait();
        }
    }

    private void limpiarCampos() {
        txtNombreEntrenador.clear();
        txtDescripcion.clear();
        cbDeporte.getSelectionModel().clearSelection();
    }

    private boolean entrenadorYaExiste(Entrenador entrenador) {
        if (entrenadores == null) {
            entrenadores = FXCollections.observableArrayList();
        }
        for (Entrenador entrenador2 : entrenadores) {
            if (entrenador.getNombre().equals(entrenador2.getNombre())) {
                return true;
            }
        }
        return false;
    }
    @FXML
    void eliminarEntrenador(ActionEvent event) {
        Entrenador entrenadorSeleccionado = this.tblEntrenador.getSelectionModel().getSelectedItem();

        club.administrador.eliminarEntrenador(entrenadorSeleccionado);

        if (entrenadorSeleccionado == null){
            Alert successAlert = new Alert(Alert.AlertType.ERROR);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Error");
            successAlert.setContentText("Se debe seleccionar un entrenador");
            successAlert.showAndWait();
        }else{
            this.entrenadores.remove(entrenadorSeleccionado);
            this.tblEntrenador.refresh();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Éxito");
            successAlert.setContentText("El entrenador ha sido eliminado");
            successAlert.showAndWait();
            limpiarCampos();
        }

    }

    @FXML
    void actualizarEntrenador(ActionEvent event) {
        Entrenador entrenadorSeleccionado = this.tblEntrenador.getSelectionModel().getSelectedItem();

        club.administrador.actualizarEntrenador(entrenadorSeleccionado);

        if (entrenadorSeleccionado == null){
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Error");
            successAlert.setContentText("Se debe seleccionar un entrenador");
            successAlert.showAndWait();
        }
        else{
            try{
                String nombre = this.txtNombreEntrenador.getText();
                String descripcion = this.txtDescripcion.getText();
                Deporte deporte = this.cbDeporte.getSelectionModel().getSelectedItem();

                Entrenador entrenador1 = new Entrenador(nombre, descripcion, deporte);

                if(!this.entrenadores.contains(entrenador1)){
                    entrenadorSeleccionado.setNombre(entrenador1.getNombre());
                    entrenadorSeleccionado.setDescripcion(entrenador1.getDescripcion());
                    entrenadorSeleccionado.setDeporte(entrenador1.getDeporte());
                    tblEntrenador.refresh();
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setHeaderText(null);
                    successAlert.setTitle("Éxito");
                    successAlert.setContentText("El entrenador ha sido modificado");
                    successAlert.showAndWait();
                    limpiarCampos();
                }
                else{
                    Alert successAlert = new Alert(Alert.AlertType.ERROR);
                    successAlert.setHeaderText(null);
                    successAlert.setTitle("Error");
                    successAlert.setContentText("Modifique la información del entrenador");
                    successAlert.showAndWait();
                }
            } catch(IllegalArgumentException e){
                Alert successAlert = new Alert(Alert.AlertType.ERROR);
                    successAlert.setHeaderText(null);
                    successAlert.setTitle("Error");
                    successAlert.setContentText("El entrenador no puede ser nulo");
                    successAlert.showAndWait();

            }
        }

    }

    @FXML
    void seleccionarEntrenador(MouseEvent event) {
        Entrenador entrenadorSeleccionado = this.tblEntrenador.getSelectionModel().getSelectedItem();

        if (entrenadorSeleccionado != null){
            this.txtDescripcion.setText(entrenadorSeleccionado.getDescripcion());
            this.txtNombreEntrenador.setText(entrenadorSeleccionado.getNombre());
            this.cbDeporte.getSelectionModel().select(entrenadorSeleccionado.getDeporte());
        }

    }
    
    @FXML
    void initialize() {
        entrenadores = FXCollections.observableArrayList();
        ObservableList<Deporte> deportes = FXCollections.observableArrayList(
                new Deporte("Fútbol", "Deporte de contacto", null, NivelDificultad.BAJO),
                new Deporte("Baloncesto", "Deporte de contacto", null, NivelDificultad.MEDIO),
                new Deporte("Tenis", "Deporte de habilidad", null, NivelDificultad.ALTO));

        cbDeporte.setItems(deportes);

        this.clNombreEntrenador.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.clDeporte.setCellValueFactory(cellData -> {
            Deporte deporte = cellData.getValue().getDeporte(); // Asume que tu objeto tiene un método getDeporte()
            return new SimpleStringProperty(deporte.getNombre()); // Asume que Deporte tiene un método getNombre()
        });
        cbDeporte.setCellFactory((comboBox) -> {
            return new ListCell<Deporte>() {
                @Override
                protected void updateItem(Deporte deporte, boolean empty) {
                    super.updateItem(deporte, empty);
                    if (deporte == null || empty) {
                        setText(null);
                    } else {
                        setText(deporte.getNombre());

                    }
                }
            };
        });

        cbDeporte.setConverter(new StringConverter<Deporte>() {
            @Override
            public String toString(Deporte deporte) {
                return deporte == null ? null : deporte.getNombre();
            }

            @Override
            public Deporte fromString(String string) {
                return null; // No es necesario implementar esto para un ComboBox de solo lectura
            }
        });

        assert txtDescripcion != null
                : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnRegistrar != null
                : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert txtNombreEntrenador != null
                : "fx:id=\"txtNombreEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert cbDeporte != null
                : "fx:id=\"txtDeporte\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert tblEntrenador != null
                : "fx:id=\"tblEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clNombreEntrenador != null
                : "fx:id=\"clNombreEntrenador\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clDeporte != null : "fx:id=\"clDeporte\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert clDescripcion != null
                : "fx:id=\"clDescripcion\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'EntrenadorView.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'EntrenadorView.fxml'.";

    }
}
