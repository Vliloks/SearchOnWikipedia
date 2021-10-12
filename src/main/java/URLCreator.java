import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class URLCreator {

    public static URL createURL (String search){

        try {
            search = URLEncoder.encode(search, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String urlString = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="+search;

        URL urlObject = null;
        try {
            urlObject = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return urlObject;

    }

}
