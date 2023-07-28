import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String IP = "127.0.0.1";
        int portName = 8080;
        try {
            Socket socket = new Socket(IP,portName);
            System.out.print("Message: ");
            Scanner scanner = new Scanner(System.in);
            String megs = scanner.nextLine();

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(megs.getBytes());

            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
