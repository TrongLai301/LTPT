package com.example.appchatgui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController implements Runnable {
    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String property = "Connecting to Client";

    //    @FXML
//    private ListView<String> listView;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textAreaChat;
    @FXML
    private ObservableList<String> stringObservableList;

    public ServerController() {
    }

    @FXML
    private TextField portName;

    @FXML
    public void start() {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(portName.getText()));
            socket = serverSocket.accept();
            textArea.appendText(property);
            Thread thread = new Thread(ServerController.this);
            Thread.sleep(1000);
            thread.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void send() {
        try {
            textArea = new TextArea();
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(textAreaChat.getText());
            dataOutputStream.flush();
            textArea.appendText("\n" + "Client: " + textAreaChat.getText());
            textArea.setStyle("-fx-text-alignment: right;");
            textAreaChat.setText("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 1) {
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                textArea.appendText("\n" + "Server: " + dataInputStream.readUTF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
