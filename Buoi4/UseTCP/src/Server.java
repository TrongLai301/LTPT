import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPort = 8080;
        ServerSocket serverSocket;

        {
            try {
                serverSocket = new ServerSocket(serverPort);
                System.out.println("Server is running and waiting for connections...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message from client "+message);
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
