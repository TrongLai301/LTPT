module com.example.ungdungkhaosatsinhvien {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ungdungkhaosatsinhvien to javafx.fxml;
    exports com.example.ungdungkhaosatsinhvien;
}