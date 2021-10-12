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
        //считываем пользовательский запрос
        String search = new Scanner(System.in).nextLine();

        //создаём URL объект, с помощью которого будем делать запрос к серверу
        URL urlObject = URLCreator.createURL(search);
        //создаём соединение с API Википедии
        HttpURLConnection connection = Connector.getWikiConnection(urlObject);

        Reader reader = null;
        try {
            //получаем ответ от сервера и преобразуем его в класс Reader
            reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //с помощью библиотеки Gson преобразуем полученный JSON ответ в Java класс
        SearchResult searchResult = new Gson().fromJson(reader, SearchResult.class);
        //из полученого Java класса достаем список элементов интересующих нас
        List<Search> searchList = searchResult.getQueryS().getSearch();

        //полученный список выводим в понятном для пользователя формате
        int count = 1;
        for (Search i : searchList){
            System.out.println(count + ") "+ i.toString());
            count += 1;
        }
    }
}
