package com.example.thitracnghiem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    RadioButton firstA;
    @FXML
    RadioButton secondB;

    @FXML
    VBox start;
    @FXML
    VBox end;
    @FXML
    Button button;
    @FXML
    Label result;
    @FXML
    public void onHelloButtonClick(){
        button.setVisible(false);
        start.setVisible(true);
    }

    @FXML
    public void end(){

        int total =0;
        start.setVisible(false);
        end.setVisible(true);
        if (firstA.isSelected()){
            total+= 5;
        }
        if (secondB.isSelected()){
            total+=5;
        }
        result.setText("your score: "+total);
    }
}