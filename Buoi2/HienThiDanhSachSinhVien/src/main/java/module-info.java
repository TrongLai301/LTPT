module com.example.hienthidanhsachsinhvien {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hienthidanhsachsinhvien to javafx.fxml;
    exports com.example.hienthidanhsachsinhvien;
}