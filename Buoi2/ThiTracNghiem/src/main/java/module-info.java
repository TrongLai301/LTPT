module com.example.thitracnghiem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thitracnghiem to javafx.fxml;
    exports com.example.thitracnghiem;
}