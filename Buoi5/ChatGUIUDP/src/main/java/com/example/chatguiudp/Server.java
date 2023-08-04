package com.example.chatguiudp;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    private DatagramSocket socketServer;
    private DatagramPacket packetServer;
    public Server(DatagramSocket datagramSocket) {
        this.socketServer = datagramSocket;
    }
    public void receiveMess(VBox vboxMessage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!socketServer.isClosed()){
                    try {
                        byte[] bytes = new byte[1024];
                        packetServer = new DatagramPacket(bytes, bytes.length);
                        socketServer.receive(packetServer);
                        String message = new String(packetServer.getData(),0, packetServer.getLength());
                        ServerController.addLabel(message,vboxMessage);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void sendMess(String messageToSend) {
        try {
            byte[] data = messageToSend.getBytes();
            packetServer =
                    new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"),8888);
            socketServer.send(packetServer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
