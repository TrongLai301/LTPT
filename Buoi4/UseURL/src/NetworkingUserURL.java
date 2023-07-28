import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingUserURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.youtube.com/watch?v=ETaIKhfTXwo");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}