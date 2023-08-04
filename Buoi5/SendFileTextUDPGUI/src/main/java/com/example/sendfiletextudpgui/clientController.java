package com.example.sendfiletextudpgui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.*;

public class clientController {
    private DatagramSocket socketClient;


    private final byte[] bytesText = new byte[246];
    private static final int PORT = 7070;
    private static final String serverHost = "127.0.0.1";
    @FXML
    TextArea textSend;
    @FXML
    TextArea textAreaClient;
    @FXML
    public void enter(){
        try {
            socketClient = new DatagramSocket();
            while (true){
                //send message
                String message = textSend.getText();
                byte [] sendMess = message.getBytes();
                InetAddress clientAddress = InetAddress.getByName(serverHost);
                DatagramPacket packetClient = new DatagramPacket(sendMess, sendMess.length, clientAddress, PORT);
                socketClient.send(packetClient);

                //receive message
                packetClient = new DatagramPacket(bytesText,bytesText.length);
                socketClient.receive(packetClient);
                String messReceive = new String(packetClient.getData(),
                        packetClient.getOffset(),
                        packetClient.getLength());
                textAreaClient.appendText("Server: " + messReceive);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void stop(){
        socketClient.close();
    }


}