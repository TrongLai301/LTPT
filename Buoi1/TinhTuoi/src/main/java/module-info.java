module com.example.tinhtuoi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.tinhtuoi to javafx.fxml;
    exports com.example.tinhtuoi;
}