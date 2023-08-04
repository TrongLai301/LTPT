import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SimpleCalculatorUDP {
    public static void main(String[] args) {
        try {
            //Creat object Scanner to import data from user
            Scanner scanner = new Scanner(System.in);

            //Creat object DatagramSocket to send and receive through UDP protocol
            DatagramSocket datagramSocket = new DatagramSocket();

            //take IP address localhost
            InetAddress ip = InetAddress.getLocalHost();
//            int portName = 12344;

            //creat byte Array
            byte[] buff;

            //use loop infinite
            while (true){
                System.out.print("import calculation by format:");
                System.out.println("'value1 operator value 2'");
                //read calculation from user
                String inp = scanner.nextLine();

                //convert String calculation into byte array to send
                buff = inp.getBytes();

                //creat object DatagramPacket to send data to server (port 12344)
                DatagramPacket datagramPacketSend = new DatagramPacket(buff, buff.length,ip,12348);

                //send package
                datagramSocket.send(datagramPacketSend);

                //creat condition when user enter "bye" then the loop is break
                if (inp.equals("bye"))
                    break;

                //creat size for var buff to receive new data
                buff = new byte[65525];

                //creat object datagramPacket to receive from server
                DatagramPacket datagramPacketReceive = new DatagramPacket(buff, buff.length);

                //receive package
                datagramSocket.receive(datagramPacketReceive);

                //show result calculation to server
                String result = new String(datagramPacketReceive.getData(),datagramPacketReceive.getOffset(),datagramPacketReceive.getLength());
                System.out.println("Result: "+result);
            }
            datagramSocket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
