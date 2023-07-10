module com.example.chuyendoitiente {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chuyendoitiente to javafx.fxml;
    exports com.example.chuyendoitiente;
}