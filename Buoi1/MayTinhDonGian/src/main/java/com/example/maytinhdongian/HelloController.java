package com.example.maytinhdongian;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField num1;
    @FXML
    TextField num2;
    double result;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    public void plus() {
        double numOne = Double.parseDouble(this.num1.getText());
        double numTwo = Double.parseDouble(this.num2.getText());
        result = numOne + numTwo;
        alert.setContentText("plus: " + result);
        alert.show();
    }

    @FXML
    public void subtraction() {
        double numOne = Double.parseDouble(this.num1.getText());
        double numTwo = Double.parseDouble(this.num2.getText());
        result = numOne - numTwo;
        alert.setContentText("subtraction: " + result);
        alert.show();
    }

    @FXML
    public void multiplication() {
        double numOne = Double.parseDouble(this.num1.getText());
        double numTwo = Double.parseDouble(this.num2.getText());
        result = numOne * numTwo;
        alert.setContentText("multiplication: " + result);
        alert.show();
    }

    @FXML
    public void div() {
        double numOne = Double.parseDouble(this.num1.getText());
        double numTwo = Double.parseDouble(this.num2.getText());
        result = numOne / numTwo;
        alert.setContentText("div: " + result);
        alert.show();
    }

}