package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
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
    private ComboBox<TipoMiembro> cbTipo;

    @FXML
    private TableView<Miembro> tblMiembros;

    @FXML
    private TableColumn<Miembro, String> colNombre;

    @FXML
    private TableColumn<Miembro, String> colNumeroId;

    @FXML
    private TableColumn<Miembro, TipoMiembro> colTipo;

    @FXML
    private TableColumn<Miembro, String> colCorreo;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtCorreo;

    private ObservableList<Miembro> miembros;

    ClubDeportivo club = new ClubDeportivo("");

    private void limpiarCampos() {
        txtNombre.clear();
        txtNumeroId.clear();
        txtCorreo.clear();
        cbTipo.getSelectionModel().clearSelection();
    }

    private boolean miembroYaExiste(Miembro miembro) {
        if (miembros == null) {
            miembros = FXCollections.observableArrayList();
        }
        for (Miembro miembro2 : miembros) {
            if (miembro.getNombre().equals(miembro2.getNombre())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    void seleccionarMiembro(MouseEvent event) {
        Miembro miembroSeleccionado = this.tblMiembros.getSelectionModel().getSelectedItem();
            if(miembroSeleccionado != null){
            txtNombre.setText(miembroSeleccionado.getNombre());
            txtNumeroId.setText(miembroSeleccionado.getNumeroId());
            txtCorreo.setText(miembroSeleccionado.getCorreoElectronico());
            cbTipo.getSelectionModel().select(miembroSeleccionado.getTipoMiembro());
        }
    }

    @FXML
    void actualizarMiembro(ActionEvent event) {
        Miembro miembroSeleccionado = this.tblMiembros.getSelectionModel().getSelectedItem();
        club.administrador.actualizarMiembro(miembroSeleccionado);

        if (miembroSeleccionado == null) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Error");
            successAlert.setContentText("Se debe seleccionar un miembro");
            successAlert.showAndWait();
        } else {
            try {
                String nombre = this.txtNombre.getText();
                String numeroId = this.txtNumeroId.getText();
                String correo = this.txtCorreo.getText();
                TipoMiembro tipoMiembro = this.cbTipo.getSelectionModel().getSelectedItem();

                Miembro miembro1 = new Miembro(nombre, numeroId, tipoMiembro, correo);
                club.administrador.actualizarMiembro(miembro1);

                if (!this.miembros.contains(miembro1)) {
                    miembroSeleccionado.setNombre(miembro1.getNombre());
                    miembroSeleccionado.setNumeroId(miembro1.getNumeroId());
                    miembroSeleccionado.setCorreoElectronico(miembro1.getCorreoElectronico());
                    miembroSeleccionado.setTipoMiembro(miembro1.getTipoMiembro());
                    tblMiembros.refresh();

                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setHeaderText(null);
                    successAlert.setTitle("Éxito");
                    successAlert.setContentText("El miembro ha sido modificado");
                    successAlert.showAndWait();
                    limpiarCampos();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.ERROR);
                    successAlert.setHeaderText(null);
                    successAlert.setTitle("Error");
                    successAlert.setContentText("Modifique la información del miembro");
                    successAlert.showAndWait();
                }
            } catch (IllegalArgumentException e) {
                Alert successAlert = new Alert(Alert.AlertType.ERROR);
                successAlert.setHeaderText(null);
                successAlert.setTitle("Error");
                successAlert.setContentText("El miembro no puede ser nulo");
                successAlert.showAndWait();

            }
        }
    }

    @FXML
    void eliminarMiembro(ActionEvent event) {
        Miembro miembroSeleccionado = this.tblMiembros.getSelectionModel().getSelectedItem();

        club.administrador.eliminarMiembro(miembroSeleccionado);

        if (miembroSeleccionado == null) {
            Alert successAlert = new Alert(Alert.AlertType.ERROR);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Error");
            successAlert.setContentText("Se debe seleccionar un miembro");
            successAlert.showAndWait();
        } else {
            this.miembros.remove(miembroSeleccionado);
            this.tblMiembros.refresh();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Éxito");
            successAlert.setContentText("El miembro ha sido eliminado");
            successAlert.showAndWait();
            limpiarCampos();
        }
    }

    @FXML
    void registrarMiembro(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        String nombre = txtNombre.getText().trim();
        String numeroId = txtNumeroId.getText().trim();
        String correo = txtCorreo.getText().trim();
        TipoMiembro tipo = cbTipo.getSelectionModel().getSelectedItem();

        if (nombre.isEmpty() || cbTipo == null || numeroId.isEmpty() || correo.isEmpty()) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos son requeridos");
            alert.showAndWait();
        }
        Miembro miembro = new Miembro(nombre, numeroId, tipo, correo);

        club.administrador.registrarMiembro(miembro);

        if (miembroYaExiste(miembro)) {
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El miembro ya se encuentra registrado");
            alert.showAndWait();
        } else {
            this.miembros.add(miembro);
            this.tblMiembros.setItems(miembros); // Actualizar los items de la TableView
            // this.tblMiembros.refresh(); Refrescar la TableView
            limpiarCampos();

            // Mostrar alerta de éxito
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(null);
            successAlert.setTitle("Éxito");
            successAlert.setContentText("Miembro registrado correctamente");
            successAlert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        miembros = FXCollections.observableArrayList();
        cbTipo.getItems().addAll(TipoMiembro.values());

        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colNumeroId.setCellValueFactory(new PropertyValueFactory<>("numeroId"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        this.colTipo.setCellValueFactory(cellData -> {
            return new SimpleObjectProperty<>(cellData.getValue().getTipoMiembro());
        });

        cbTipo.setCellFactory(listView -> new ListCell<TipoMiembro>() {
            @Override
            protected void updateItem(TipoMiembro item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.name().charAt(0) + item.name().substring(1).toLowerCase());
                }
            }
        });
        // Configurar el convertidor para el botón del ComboBox
        cbTipo.setConverter(new StringConverter<TipoMiembro>() {
            @Override
            public String toString(TipoMiembro tipo) {
                if (tipo == null)
                    return "";
                return tipo.name().charAt(0) + tipo.name().substring(1).toLowerCase();
            }

            @Override
            public TipoMiembro fromString(String string) {
                return null; // No es necesario para este caso
            }
        });
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtNumeroId != null : "fx:id=\"txtNumeroId\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert btnRegistrar != null
                : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert cbTipo != null
                : "fx:id=\"seleccionar_comboBox\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert tblMiembros != null : "fx:id=\"tblMiembros\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert colNumeroId != null : "fx:id=\"colNumeroId\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert colTipo != null : "fx:id=\"colTipo\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert colCorreo != null : "fx:id=\"colCorreo\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert btnActualizar != null
                : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'MiembroView.fxml'.";

    }
}
