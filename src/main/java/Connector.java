import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {
    public static HttpURLConnection getWikiConnection(URL urlObject){
        HttpURLConnection connection = null;
        int responseCode = 0;
        try {
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (responseCode == 404) {
            throw new IllegalArgumentException();
        }

        return connection;

    }
}
