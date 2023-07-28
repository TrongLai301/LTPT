import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args){
        try {
            int portName = 8090;
            ServerSocket socketServer = new ServerSocket(portName);
            System.out.println("Server dang doi de ket noi");
            Socket socket = socketServer.accept();
            System.out.println("Ket noi thanh cong");
            InputStream inputStream = socket.getInputStream();
            byte[] number = inputStream.readAllBytes();
            System.out.println("So luong so nguyen to: " + Arrays.toString(number));
            int count = 0;
            int total = 0;
            while (count < number.length) {

                total += number[count++];
            }
            int totalInt = total;
            System.out.print("Tong: " + total);


            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(totalInt+" ");
            dataOutputStream.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}