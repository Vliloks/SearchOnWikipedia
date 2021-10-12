import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {
    public static HttpURLConnection getWikiConnection(URL urlObject){
        HttpURLConnection connection = null;
        try {
            //открываем соединение
            connection = (HttpURLConnection) urlObject.openConnection();
            //выбираем тип запроса (GET)
            connection.setRequestMethod("GET");
            //задаем свойства запроса
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
