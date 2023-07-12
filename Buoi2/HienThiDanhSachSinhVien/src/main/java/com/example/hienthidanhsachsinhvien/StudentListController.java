package com.example.hienthidanhsachsinhvien;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    @FXML
    private ListView<Student> listView;

    public ListView<Student> getListView(){
        return listView;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        listView.setCellFactory(param -> new StudentListCell());
    }
}
