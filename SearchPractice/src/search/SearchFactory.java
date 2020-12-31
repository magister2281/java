package search;

public class SearchFactory {

    public Search searchFactory (String strategy, String path, String[] values) {
        switch (strategy) {
            case "all":
                return new AllSearch(path, values);
            case "any":
                return new AnySearch(path, values);
            case "none":
                return new NoneSearch(path, values);
            default:
                return null;
        }


    }
}
