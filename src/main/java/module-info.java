module poo.uniquindio.edu.co.demo {


    requires javafx.controls;
    requires javafx.fxml;


    opens poo.uniquindio.edu.co.demo to javafx.fxml;
    exports poo.uniquindio.edu.co.demo;

    opens poo.uniquindio.edu.co.demo.Controller;
    exports poo.uniquindio.edu.co.demo.Controller;

    opens poo.uniquindio.edu.co.demo.Model;
    exports poo.uniquindio.edu.co.demo.Model;
}