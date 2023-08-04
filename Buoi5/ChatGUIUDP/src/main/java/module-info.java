module com.example.chatguiudp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatguiudp to javafx.fxml;
    exports com.example.chatguiudp;
}