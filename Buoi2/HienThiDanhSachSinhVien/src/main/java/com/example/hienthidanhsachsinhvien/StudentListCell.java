package com.example.hienthidanhsachsinhvien;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class StudentListCell extends ListCell<Student> {
    private HBox content;
    private Label nameLabel;
    private Label ageLabel;

    public StudentListCell() {
        nameLabel = new Label();
        nameLabel.setFont(Font.font(14));

        ageLabel = new Label();
        ageLabel.setFont(Font.font(14));

        content = new HBox(10);
        content.getChildren().addAll(nameLabel, ageLabel);
    }

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {
            setText(null);
            setGraphic(null);
        } else {
            nameLabel.setText(student.getName());
            ageLabel.setText("Age: " + student.getAge());

            setText(null);
            setGraphic(content);
        }
    }
}
