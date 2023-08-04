import java.io.*;
import java.net.*;

public class UDPClient {
    private static final int PIECES_OF_FILE_SIZE = 1024 * 32;
    private DatagramSocket clientSocket;
    private int serverPort = 6677;
    private String serverHost = "localhost";

    public static void main(String[] args) {
        String sourcePath = "/home/trong/IdeaProjects/Buoi5/SendFileTextUDP/src/UDPClient.java";
        String destinationDirectory = "/home/trong/Downloads/UDPServer.zip";
        UDPClient udpClient = new UDPClient();
        udpClient.connectServer();
        udpClient.sendFile(sourcePath, destinationDirectory);
    }

    private void connectServer() {
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendFile(String sourcePath, String destinationDirectory) {
        InetAddress inetAddress;
        DatagramPacket sendPacket;
        try {
            File fileSend = new File(sourcePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    new FileInputStream(fileSend));
            inetAddress = InetAddress.getByName(serverHost);
            byte[] bytePath = new byte[PIECES_OF_FILE_SIZE];

            //get file size
            long fileLength = fileSend.length();
            int piecesOfFile = (int) (fileLength / PIECES_OF_FILE_SIZE);
            int lastByteLength = (int) (fileLength % PIECES_OF_FILE_SIZE);

            //check last bytes of file
            if (lastByteLength > 0) {
                piecesOfFile++;
            }
            System.out.println(piecesOfFile);
            //split file into pieces and assign of fileBytes
            byte[][] fileBytes = new byte[piecesOfFile][PIECES_OF_FILE_SIZE];
            int count = 0;
            while (bufferedInputStream.read(bytePath, 0, PIECES_OF_FILE_SIZE) > 0) {
                fileBytes[count++] = bytePath;
                bytePath = new byte[PIECES_OF_FILE_SIZE];
            }

            //read file info
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(fileSend.getName());
            fileInfo.setFileSize(fileSend.length());
            fileInfo.setPiecesOfFile(piecesOfFile);
            fileInfo.setLastByteLength(lastByteLength);
            fileInfo.setDestinationDirectory(destinationDirectory);

            //send file info
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(fileInfo);

            System.out.println(byteArrayOutputStream.toByteArray().length);
            sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(),byteArrayOutputStream.toByteArray().length , inetAddress, serverPort);
            clientSocket.send(sendPacket);

            //send file content
            System.out.println("Sending file...");
            //send pieces of file
            for (int i = 0; i < (count - 1); i++) {
                sendPacket = new DatagramPacket(fileBytes[i], PIECES_OF_FILE_SIZE, inetAddress, serverPort);
                clientSocket.send(sendPacket);
                waitt(40);
            }

            //send last bytes of file
            sendPacket = new DatagramPacket(fileBytes[count - 1], PIECES_OF_FILE_SIZE, inetAddress, serverPort);
            clientSocket.send(sendPacket);
            waitt(40);

            //close
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sent.");
    }

    public void waitt(double millisecond) {
        try {
            Thread.sleep((long) millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


