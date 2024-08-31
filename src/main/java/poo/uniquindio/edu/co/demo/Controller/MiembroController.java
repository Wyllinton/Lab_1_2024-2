package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.util.StringConverter;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import poo.uniquindio.edu.co.demo.Model.Miembro;
import poo.uniquindio.edu.co.demo.Model.TipoMiembro;

public class MiembroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumeroId;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label txtAraeVariaciones;

    @FXML
    private TableView<Miembro> tblMiembros;

    @FXML
    private TableColumn<Miembro, String> colNombre;

    @FXML
    private TableColumn<Miembro, String> colNumeroId;

    @FXML
    private TableColumn<Miembro, TipoMiembro> colTipo;

    private ObservableList<Miembro> miembros;

    @FXML
    private ComboBox<TipoMiembro> seleccionar_comboBox;

    @FXML
    void registrarMiembro(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        String nombre = txtNombre.getText().trim();
        String numeroId = txtNumeroId.getText().trim();
        TipoMiembro tipoMiembro = seleccionar_comboBox.getValue();

        if (nombre.isEmpty() || numeroId.isEmpty() || tipoMiembro == null) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos son requeridos");
            alert.showAndWait();
            return;
        }

        Miembro miembro = new Miembro(nombre, numeroId, tipoMiembro);

        if (miembroYaExiste(miembro)) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El miembro ya se encuentra registrado");
            alert.showAndWait();
        } else {
            this.miembros.add(miembro);
            this.tblMiembros.setItems(miembros); // Actualizar los items de la TableView
            this.tblMiembros.refresh(); // Refrescar la TableView
            limpiarCampos();

            // Mostrar alerta de éxito
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Éxito");
            successAlert.setContentText("Miembro registrado correctamente");
            successAlert.showAndWait();
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtNumeroId.clear();
        seleccionar_comboBox.getSelectionModel().clearSelection();
    }

    private boolean miembroYaExiste(Miembro nuevoMiembro) {
        if (miembros == null) {
            miembros = FXCollections.observableArrayList();
        }
        for (Miembro miembro : miembros) {
            if (miembro.getNumeroId().equals(nuevoMiembro.getNumeroId())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    TipoMiembro Seleccionar(ActionEvent event) {
        return seleccionar_comboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void initialize() {
        ObservableList<TipoMiembro> tiposOperacion = FXCollections.observableArrayList(TipoMiembro.values());
        seleccionar_comboBox.setItems(tiposOperacion);
        seleccionar_comboBox.setConverter(new StringConverter<TipoMiembro>() {
            @Override
            public String toString(TipoMiembro object) {
                return object == null ? "" : object.toString();
            }

            @Override
            public TipoMiembro fromString(String string) {
                return string == null ? null : TipoMiembro.valueOf(string);
            }
        });
        miembros = FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colNumeroId.setCellValueFactory(new PropertyValueFactory<>("numeroId"));
        this.colTipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoMiembro()));
        this.colTipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoMiembro()));
        this.colTipo.setCellFactory(column -> new TableCell<Miembro, TipoMiembro>() {
            @Override
            protected void updateItem(TipoMiembro item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.toString());
            }
        });

        tblMiembros.setItems(miembros);

        assert txtNombre != null
                : "fx:id=\"txtNVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtNumeroId != null
                : "fx:id=\"txtKVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert btnRegistrar != null
                : "fx:id=\"btnCalcularVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtAraeVariaciones != null
                : "fx:id=\"txtAraeVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
    }
}
