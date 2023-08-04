import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) {
        try {
            //creat object DatagramSocket to receive data through UPD (port 12344)
            DatagramSocket datagramSocket = new DatagramSocket(12348);

            //creat array byte, object DatagramPacket to send and receive
            byte[] buff;
            DatagramPacket datagramPacketSend;
            DatagramPacket datagramPacketReceive;

            //creat loop infinite
            while (true) {
                buff = new byte[65535];
                datagramPacketReceive = new DatagramPacket(buff, buff.length);

                datagramSocket.receive(datagramPacketReceive);

                //convert array byte to String to take operation from client
                String inp = new String(datagramPacketReceive.getData(), datagramPacketReceive.getOffset(), datagramPacketReceive.getLength());

                System.out.println("Operation receive: " + inp);
                if (inp.equals("bye")) {
                    InetAddress ipCheck = InetAddress.getLocalHost();
                    System.out.println(ipCheck);
                    System.out.println("Client gửi lệnh 'bye'.....ĐANG THOÁT");
                    break;
                }
                int result;
                StringTokenizer stringTokenizer = new StringTokenizer(inp);


                //split String operation through value1, operation, value2
                int operationND1 = Integer.parseInt(stringTokenizer.nextToken());
                String operation = stringTokenizer.nextToken();
                int operationND2 = Integer.parseInt(stringTokenizer.nextToken());

                //creat condition to calculation
                if (operation.equals("+"))
                    result = operationND1 + operationND2;
                else if (operation.equals("-"))
                    result = operationND1 - operationND2;
                else if (operation.equals("*"))
                    result = operationND1 * operationND2;
                else
                    result = operationND1 / operationND2;

                System.out.println("Server is sending result...");
                String res = Integer.toString(result);
                buff = res.getBytes();

                int port = datagramPacketReceive.getPort();
                datagramPacketSend = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), port);


                datagramSocket.send(datagramPacketSend);
            }
            datagramSocket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
