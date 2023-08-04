module com.example.sendfiletextudpgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sendfiletextudpgui to javafx.fxml;
    exports com.example.sendfiletextudpgui;
}