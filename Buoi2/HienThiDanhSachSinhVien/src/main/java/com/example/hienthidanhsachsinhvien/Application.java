package com.example.hienthidanhsachsinhvien;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_list.fxml"));
        VBox root = loader.load();
        StudentListController studentListController = loader.getController();
        studentListController.getListView().getItems().addAll(
                new Student(1, "John Doe", 20),
                new Student(2, "Jane Smith", 22),
                new Student(3, "David Johnson", 19)
        );
        stage.setTitle("Student List");
        stage.setScene(new Scene(root,300,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}