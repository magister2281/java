package search;

import java.util.ArrayList;

public class AnySearch extends Search {

    protected AnySearch(String path, String[] values) {
        super(path, values);
    }
    /* method for any-type strategy
     "If the strategy is ANY,
     the program should print lines containing at least one word from the query." */
    @Override
    protected ArrayList<String> search() {
        ArrayList<String> index = new ArrayList<>();
        for (var data : getValues()) {
            for (String s : getArray()) {
                if (s.toLowerCase().contains(data.toLowerCase())) {
                    index.add(s);
                }
            }
        }
        return index;

    }
}
