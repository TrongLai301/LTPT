import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String IPAddress = "127.0.0.1";
        int portName = 8090;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            int[] numArr= new int[quantity];
            int count = 0;
            Socket socket = new Socket(IPAddress, portName);
            OutputStream outputStream = socket.getOutputStream();
            while (count < quantity){
                System.out.print("Enter Number "+ (count+1)+ ": ");
                numArr[count] = scanner.nextInt();
                outputStream.write(numArr[count]);
                count++;
            }


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataInputStream.readUTF();
            System.out.println("Da doc");

//            InputStream inputStream = socket.getInputStream();
//            byte [] bytes = new byte[100];
//            int byteRead = inputStream.read(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
