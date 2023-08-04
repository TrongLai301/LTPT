import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {

        try {
            //Creat IP address, PortServer and object DatagramSocket to connect with server
            String serverIP ="127.0.0.1";
            int serverPort = 12345;
            DatagramSocket clientSocket = new DatagramSocket();

            //Creat byte Array contain data mess need send
            String message = "Hello, server!";
            byte[] sendData = message.getBytes();

            //send package to server
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length,serverAddress,serverPort);
            clientSocket.send(datagramPacket);

            //prepare array byte to receive from server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            //receive packet from server
            String responseMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("Receive from server: " + responseMessage);
            clientSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
