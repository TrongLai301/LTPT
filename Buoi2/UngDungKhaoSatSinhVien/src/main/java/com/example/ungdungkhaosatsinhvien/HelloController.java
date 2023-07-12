package com.example.ungdungkhaosatsinhvien;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    @FXML
    Label test1;
    @FXML
    Label test2;
    @FXML
    ToggleGroup toggleGroup;
    @FXML
    ToggleGroup toggleGroup1;
    @FXML
    protected RadioButton trueInQuest1;
    @FXML
    protected RadioButton sometimeInQuest1;
    @FXML
    protected RadioButton noInQuest1;
    @FXML
    protected RadioButton trueInQuest2;
    @FXML
    protected RadioButton sometimeInQuest2;
    @FXML
    protected RadioButton noInQuest2;

    @FXML
    protected void submit() {
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cam on ban da tra loi cau hoi");
            alert.show();
            String fileName = "data.txt";
            File file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if (trueInQuest1.isSelected()){
                bufferedWriter.write(test1.getText()+": "+trueInQuest1.getText());
                System.out.println(test1.getText()+": "+trueInQuest1.getText());
            } else if(sometimeInQuest1.isSelected()){
                bufferedWriter.write(test1.getText()+": "+sometimeInQuest1.getText());
                System.out.println(test1.getText()+": "+sometimeInQuest1.getText());
            } else {
                bufferedWriter.write(test1.getText()+": "+noInQuest1.getText());
                System.out.println(test1.getText()+": "+noInQuest1.getText());
            }

            if (trueInQuest2.isSelected()){
                bufferedWriter.write(test2.getText()+": "+trueInQuest2.getText());
                System.out.println(test2.getText()+": "+trueInQuest2.getText());
            } else if(sometimeInQuest2.isSelected()){
                bufferedWriter.write(test2.getText()+": "+sometimeInQuest2.getText());
                System.out.println(test2.getText()+": "+sometimeInQuest2.getText());
            } else {
                bufferedWriter.write(test2.getText()+": "+noInQuest2.getText());
                System.out.println(test2.getText()+": "+noInQuest2.getText());
            }

            bufferedWriter.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}