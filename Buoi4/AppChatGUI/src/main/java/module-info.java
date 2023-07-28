module com.example.appchatgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appchatgui to javafx.fxml;
    exports com.example.appchatgui;
}