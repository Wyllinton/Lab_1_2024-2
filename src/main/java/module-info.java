module poo.uniquindio.edu.co.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens poo.uniquindio.edu.co.demo to javafx.fxml;
    exports poo.uniquindio.edu.co.demo;
}