module com.example.doanso {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.doanso to javafx.fxml;
    exports com.example.doanso;
}