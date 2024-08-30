package poo.uniquindio.edu.co.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import poo.uniquindio.edu.co.demo.Model.Miembro;

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
        String nombre = this.txtNombre.getText();
        String numeroId = this.txtNumeroId.getText();
        TipoMiembro tipoMiembro = this.Seleccionar(event);
        Miembro miembro = new Miembro(nombre, numeroId, tipoMiembro);
        if (!this.miembros.contains(miembro)){
            this.miembros.add(miembro);
            this.tblMiembros.setItems(miembros);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El miembro ya se encuentra registrado");
        }
    }


    @FXML
TipoMiembro Seleccionar(ActionEvent event) {
    return seleccionar_comboBox.getSelectionModel().getSelectedItem();
}

    @FXML
    void initialize() {
        ObservableList<TipoMiembro> tiposOperacion = FXCollections.observableArrayList(TipoMiembro.values());
        seleccionar_comboBox.setItems(tiposOperacion);
        seleccionar_comboBox.getSelectionModel();
        miembros = FXCollections.observableArrayList();
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colNumeroId.setCellValueFactory(new PropertyValueFactory<>("numeroId"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoMiembro"));
        assert txtNombre != null : "fx:id=\"txtNVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtNumeroId != null : "fx:id=\"txtKVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnCalcularVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
        assert txtAraeVariaciones != null : "fx:id=\"txtAraeVariaciones\" was not injected: check your FXML file 'MiembroView.fxml'.";
    }


    public enum TipoMiembro {
        JUVENIL,
        ADULTO
    }
}
