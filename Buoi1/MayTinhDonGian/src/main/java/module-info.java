module com.example.maytinhdongian {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maytinhdongian to javafx.fxml;
    exports com.example.maytinhdongian;
}