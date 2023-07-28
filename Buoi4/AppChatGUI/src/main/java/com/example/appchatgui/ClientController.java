package com.example.appchatgui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class ClientController implements Runnable {
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    private String property = "Connecting to Server";
    private String IP = "127.0.0.1";

    Socket socket;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textAreaChat;

    @FXML
    private TextField portName;

    @FXML
    public void start() {
        try {
            socket = new Socket(IP, Integer.parseInt(portName.getText()));
            textArea.appendText(this.property);
            Thread thread = new Thread(ClientController.this);
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
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(textAreaChat.getText());
            dataOutputStream.flush();
            textArea.appendText("\n" + "Server: " + textAreaChat.getText());
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
                textArea.appendText("\n" + "Client: " + dataInputStream.readUTF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
