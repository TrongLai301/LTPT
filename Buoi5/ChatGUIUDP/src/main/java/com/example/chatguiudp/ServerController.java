package com.example.chatguiudp;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {
    @FXML
    Button send;
    @FXML
    TextField message;
    @FXML
    ScrollPane display;
    @FXML
    VBox messageSend_Vbox;

    private Server server;
    private int serverPort = 7000;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            server = new Server(new DatagramSocket(serverPort));
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        messageSend_Vbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                display.setVvalue((double) t1);
            }
        });
        server.receiveMess(messageSend_Vbox);

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String messSend = message.getText();
                if (!messSend.isEmpty()) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5, 5, 5, 10));

                    Text text = new Text(messSend);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(239,242,255); -fx-background-color: rgb(15,125,242); -fx-background-radius: 20px");

                    textFlow.setPadding(new Insets(5, 10, 5, 10));
                    text.setFill(Color.color(0.934, 0.945, 0.996));

                    hBox.getChildren().add(textFlow);
                    messageSend_Vbox.getChildren().add(hBox);

                    server.sendMess(messSend);
                    message.clear();
                }
            }
        });
    }
        public static void addLabel(String messageRecei,VBox vBox){
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(5,5,5,10));

            Text text = new Text(messageRecei);
            TextFlow textFlow = new TextFlow(text);

            textFlow.setStyle("-fx-background-color: rgb(233,233,235); -fx-background-radius: 20px");
            textFlow.setPadding(new Insets(5,10,5,10));
            hBox.getChildren().add(textFlow);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    vBox.getChildren().add(hBox);
                }
            });
    }
}
