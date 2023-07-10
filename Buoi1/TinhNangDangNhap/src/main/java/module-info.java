module com.example.tinhnangdangnhap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tinhnangdangnhap to javafx.fxml;
    exports com.example.tinhnangdangnhap;
}