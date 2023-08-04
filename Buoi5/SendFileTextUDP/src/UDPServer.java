import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    private static final int PIECES_OF_FILE_SIZE = 1024 * 32;
    private DatagramSocket serverSocket;
    private int port = 6677;


    //Main
    public static void main(String[] args) {
        UDPServer udpServer = new UDPServer();
        udpServer.openServer();
    }



    //Function openServer()
    private void openServer() {
        try {
            serverSocket = new DatagramSocket(port);
            System.out.println("Server is opened on port " + port);
            listening();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private void listening() {
        while (true) {
            receiveFile();
        }
    }

    public void receiveFile() {
        byte[] receiveData = new byte[PIECES_OF_FILE_SIZE];
        DatagramPacket receivePacket;

        try {
            //get file info
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress inetAddress = receivePacket.getAddress();
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new ByteArrayInputStream(receivePacket.getData()));
            FileInfo fileInfo = (FileInfo) objectInputStream.readObject();

            //Show file infor
            if (fileInfo != null) {
                System.out.println(
                        "File name: " + fileInfo.getFileName() +
                                "\n File size: " + fileInfo.getFileSize() +
                                "\n Pieces of file: " + fileInfo.getPiecesOfFile() +
                                "\n Last bytes length: " + fileInfo.getLastByteLength()
                );
            }
            //Get file content
            System.out.println(" Receiving file...");
            assert fileInfo != null;
            File fileReceive = new File(fileInfo.getDestinationDirectory()
                    + fileInfo.getFileName());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream(fileReceive));
            //write pieces of file
            for (int i = 0; i < (fileInfo.getPiecesOfFile() -1) ; i++) {
                receivePacket = new DatagramPacket(receiveData,receiveData.length,inetAddress,port);
                serverSocket.receive(receivePacket);
                bufferedOutputStream.write(receiveData,0,PIECES_OF_FILE_SIZE);
            }
            //write last bytes of file
            receivePacket = new DatagramPacket(receiveData,receiveData.length,inetAddress,port);
            serverSocket.receive(receivePacket);
            bufferedOutputStream.write(receiveData,0,fileInfo.getLastByteLength());
            bufferedOutputStream.flush();
            System.out.println("Done!");

            //close stream
            bufferedOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
