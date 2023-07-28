import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "192.168.0.1";
        int serverPort = 8080;
        try {
            Socket socket = new Socket(serverAddress,serverPort);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            output.write("Hello, Server!".getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            String response = new String(buffer,0,bytesRead);
            System.out.println("Server response: "+response);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}