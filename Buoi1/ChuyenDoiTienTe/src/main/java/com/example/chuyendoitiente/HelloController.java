package com.example.chuyendoitiente;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField money;
    @FXML
    public void check(){
        final int numVND = 23000;
        double money = Double.parseDouble(this.money.getText());
        double result =  money*numVND;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Result is: "+result +" VND");
        alert.show();
    }
}