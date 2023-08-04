package com.example.chatguiudp;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    //khoi tao doi tuong datagramPacket va datagramSocket
    private DatagramSocket socketClient;
    private DatagramPacket packetClient;
    private int PORT = 7000;
    private String serverIp = "127.0.0.1";
    public Client(DatagramSocket datagramSocket){
        this.socketClient = datagramSocket;
    }

    public void receiveMessage (VBox messageSend){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!socketClient.isClosed()){
                    try {
                        byte[] data = new byte[1024];
                        packetClient = new DatagramPacket(data,data.length);
                        socketClient.receive(packetClient);
                        String mess = new String(packetClient.getData(),0,packetClient.getLength());
                        ClientController.addLabel(mess,messageSend);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }


    public void sendMessage(String message){
        try{
            byte[] data = message.getBytes();
            InetAddress inetAddress = InetAddress.getByName(serverIp);
            packetClient = new DatagramPacket(data,data.length,inetAddress,PORT);
            socketClient.send(packetClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


