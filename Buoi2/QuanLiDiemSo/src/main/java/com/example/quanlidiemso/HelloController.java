package com.example.quanlidiemso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //TableView
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> nameClassColumn;
    @FXML
    private TableColumn<Student, String> genderColumn;
    @FXML
    private TableColumn<Student, String> gmailColumn;
    @FXML
    private TableColumn<Student, Integer> scoreColumn;


    //TextField
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField nameClassField;
    @FXML
    private TextField genderFiled;
    @FXML
    private TextField gmailField;
    @FXML
    private TextField scoreField;


    //remove,edit
    @FXML
    private TextField hideField;



    @FXML
    private ObservableList<Student> studentObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentObservableList = FXCollections.observableArrayList(
                new Student(1,"Trong","IBSK1D1","Male","tronglai301@gmail.com",10),
                new Student(2,"hoang","IBSK1D1","Female","hoangho301@gmail.com",1)
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        nameClassColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("nameClass"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        gmailColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("gmail"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<Student,Integer>("score"));
        tableView.setItems(studentObservableList);
    }

    public void push(Student student){
        student.setId(Integer.parseInt(idField.getText()));
        student.setName(nameField.getText());
        student.setNameClass(nameClassField.getText());
        student.setGender(genderFiled.getText());
        student.setGmail(gmailField.getText());
        student.setScore(Integer.parseInt(scoreField.getText()));
    }

    @FXML
    public void submit(){
        Student newStudent = new Student();
        push(newStudent);
        studentObservableList.add(newStudent);
    }

    @FXML
    public void fix(){
        hideField.setVisible(true);
    }
    @FXML
    public void remove(){
        int numRows = tableView.getItems().size();
        for (int numRemove = 0; numRemove < numRows ; numRemove++) {
            if(numRemove == (Integer.parseInt(hideField.getText()))){
                studentObservableList.remove(numRemove);
            }
        }
        tableView.refresh();
    }

    @FXML
    public void edit(){
        int numRows = tableView.getItems().size();
        for (int numEdit = 0; numEdit < numRows ; numEdit++) {
            if(numEdit == (Integer.parseInt(hideField.getText()))){
                Student studentEdit = studentObservableList.get(numEdit);
                push(studentEdit);
            }
            tableView.refresh();
        }
    }
}