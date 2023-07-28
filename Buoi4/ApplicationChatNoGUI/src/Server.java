import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            int portName = 8080;
            System.out.println("Connecting to Client");
            ServerSocket serverSocket = new ServerSocket(portName);
            Socket socket = serverSocket.accept();
            System.out.println("Completed to connecting");
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int bytesRead = inputStream.read(bytes);
            String message = new String(bytes,0,bytesRead);
            System.out.println("Client say: "+message);
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
