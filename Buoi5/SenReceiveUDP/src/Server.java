import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {

        {
            try {
                int serverPort = 12345;
                //Creat a new DatagramSocket to connect to a Port in Server
                DatagramSocket serverSocket = new DatagramSocket(serverPort);
                System.out.println("Server is running and waiting for client...");

                //Creat a byte Array to receive data by package
                byte[] receiveData = new byte[1024];

                //Creat a object DatagramPacket to receive package from client
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                serverSocket.receive(receivePacket);

                //take IP address and port from the client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                //change data to String type
                String message = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println(message);

                //prepare package to send
                String responseMessage = "Hello, client";
                byte[] sendData = responseMessage.getBytes();

                //creat datapackage to send package to client
                DatagramPacket sendPackage = new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
                serverSocket.send(sendPackage);

            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
