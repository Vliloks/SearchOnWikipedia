import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) {
        System.out.print("Поиск: ");
        String search = new Scanner(System.in).nextLine();

        URL urlObject = URLCreator.createURL(search);
        HttpURLConnection connection = Connector.getWikiConnection(urlObject);

        Reader reader = null;
        try {
            reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchResult searchResult = new Gson().fromJson(reader, SearchResult.class);

        List<Search> searchList = searchResult.getQueryS().getSearch();

        int count = 1;
        for (Search i : searchList){
            System.out.println(count + ") "+ i.toString());
            count += 1;
        }





    }
}
