import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP: ");
        String iPCheck = scanner.nextLine();
        if (!isValidIP(iPCheck)) {
            System.out.println("IP isn't valid");
        }

        // Phân tích địa chỉ IP
        String[] ipAddressParts = iPCheck.split("\\.");
        int[] ipAddressInts = new int[4];
        for (int i = 0; i < 4; i++) {
            ipAddressInts[i] = Integer.parseInt(ipAddressParts[i]);
        }

        // Hiển thị thông tin phân tích địa chỉ IP
        System.out.println("Địa chỉ IP: " + iPCheck);
        System.out.println("Mạng: " + ipAddressInts[0] + "." + ipAddressInts[1] + "." + ipAddressInts[2] + ".0");
        System.out.println("Địa chỉ Broadcast: " + ipAddressInts[0] + "." + ipAddressInts[1] + "." + ipAddressInts[2] + ".255");
        System.out.println("Địa chỉ đầu mạng: " + ipAddressInts[0] + "." + ipAddressInts[1] + "." + ipAddressInts[2] + ".1");
        System.out.println("Địa chỉ cuối mạng: " + ipAddressInts[0] + "." + ipAddressInts[1] + "." + ipAddressInts[2] + ".254");
}


    public static boolean isValidIP(String IPAddress) {
        String[] iPAddressArrs = IPAddress.split("\\.");
        if (iPAddressArrs.length != 4) {
            return false;
        }
        for (String iPAddressArr : iPAddressArrs
        ) {
            int iPAddressInt = Integer.parseInt(iPAddressArr);
            if (iPAddressInt < 0 || iPAddressInt > 255) {
                return false;
            }
        }
        return true;
    }
}