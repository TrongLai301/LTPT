package com.example.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    protected TableView<Person> tableView;
    @FXML
    protected TableColumn<Person, String> name;
    @FXML
    protected TableColumn<Person, Integer> age;

    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person ("John",21)
            , new Person ("John",22)
            , new Person ("John",23)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));

        tableView.getItems().addAll(data);
    }

}