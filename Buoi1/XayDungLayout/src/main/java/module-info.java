module com.example.xaydunglayout {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.xaydunglayout to javafx.fxml;
    exports com.example.xaydunglayout;
}