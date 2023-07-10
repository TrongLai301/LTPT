package com.example.doanso;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField num;

    @FXML
    protected void check(){
        int numRandom = (int) (Math.random()*100+1);
        int num = Integer.parseInt(this.num.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (numRandom == num){
            alert.setContentText("correct, this random number is: "+ numRandom);
        }else {
            alert.setContentText("incorrect, this random number is: "+ numRandom);
        }
        alert.show();
    }
}