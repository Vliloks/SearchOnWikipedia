import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {
    @SerializedName("query")
    private QueryS queryS;

    public QueryS getQueryS() {
        return queryS;
    }

}

class QueryS {
    private List<Search> search;

    public List<Search> getSearch() {
        return search;
    }

}

class Search {
    private String title;
    private String snippet;

    @Override
    public String toString() {
        return "'" + title + '\'' +
                "\n" + snippet.replaceAll("<.*?>", "");
    }
}

