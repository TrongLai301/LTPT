package com.example.sendfiletextudpgui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class serverController {
    private static final int PORT = 7070;
    private DatagramSocket socketClient;

    @FXML
    TextArea textReceive;
    @FXML
    TextArea textAreaServer;

    @FXML
    public void enter(){
        try {
            socketClient = new DatagramSocket(PORT);
            while (true){
                //send
                String message = textReceive.getText();
                byte [] sendMess = message.getBytes();
                InetAddress inetAddress = InetAddress.getLocalHost();
                DatagramPacket packetServer = new DatagramPacket(sendMess, sendMess.length, inetAddress, PORT);
                socketClient.send(packetServer);



                //receive
                byte[] bytes = new byte[256];
                packetServer = new DatagramPacket(bytes, bytes.length);
                socketClient.receive(packetServer);
                String messReceive = new String(packetServer.getData(),
                        packetServer.getOffset(),
                        packetServer.getLength());
                textAreaServer.appendText("Server: " + messReceive);
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
