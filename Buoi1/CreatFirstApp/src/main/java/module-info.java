module com.example.creatfirstapp {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.creatfirstapp to javafx.fxml;
    exports com.example.creatfirstapp;
}