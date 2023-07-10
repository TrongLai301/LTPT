package com.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField height;
    @FXML
    TextField weight;
    @FXML
    public void result(){
        double height = Double.parseDouble(this.height.getText());
        double weight = Double.parseDouble(this.weight.getText());
        double result = weight / (Math.pow(height,2));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (result < 18.5){
            alert.setContentText("Gay");
        }else if(result< 24.9) {
            alert.setContentText("Binh Thuong");
        } else if (result ==25) {
            alert.setContentText("Thua can");
        } else if (result< 29.9) {
            alert.setContentText("Tien beo phi");
        } else if (result <34.9) {
            alert.setContentText("Beo 1");
        }else if (result <39.9) {
            alert.setContentText("Beo 2");
        }else if (result >=40) {
            alert.setContentText("Beo 3");
        }
        alert.show();
    }
}