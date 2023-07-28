import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkingUserInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.example.com");
            String ipAddress = address.getHostAddress();
            System.out.println("IP address: "+ ipAddress);

            String hostName = address.getHostName();
            System.out.println("Host name: "+hostName);

            boolean reachable = address.isReachable(8080);
            System.out.println("Reachable: "+reachable);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}