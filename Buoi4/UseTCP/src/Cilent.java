import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cilent {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            Socket socket = new Socket(serverIP,serverPort);
            OutputStream outputStream = socket.getOutputStream();
//            String message = "Hello, server!";
            outputStream.write(message.getBytes());
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}