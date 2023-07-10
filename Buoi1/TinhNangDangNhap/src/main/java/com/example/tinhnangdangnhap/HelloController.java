package com.example.tinhnangdangnhap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    protected void login() {
        String username = this.username.getText();
        String password = this.password.getText();

        if(username.equals("admin") && password.equals("password")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đăng nhập thành công");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đăng nhập thất bại");
            alert.show();
        }
    }

}