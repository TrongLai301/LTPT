module com.example.usefilechooser {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.usefilechooser to javafx.fxml;
    exports com.example.usefilechooser;
}