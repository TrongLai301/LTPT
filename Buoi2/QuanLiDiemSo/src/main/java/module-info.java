module com.example.quanlidiemso {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quanlidiemso to javafx.fxml;
    exports com.example.quanlidiemso;
}