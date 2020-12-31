package search;

import java.util.ArrayList;
import java.util.TreeMap;

public class AllSearch extends Search {

    protected AllSearch(String path, String[]  values) {
        super(path, values);
    }
    protected AllSearch() {
    }
/* method for all-type strategy
 "If the strategy is ALL,
 the program should print lines containing all words from the query." */
    @Override
    protected ArrayList<String> search() {
        // map for storing key (Integer - amount of repetitions) value (String -name)
        TreeMap<Integer, String> map = new TreeMap<>();
        for (var d : getArray()) {
            Integer index1 = 0;
            String[] separatedArray = d.split(" ");
            for (var v: separatedArray) {
                for (var data : getValues()) {
                    if (v.equalsIgnoreCase(data)) {
                        index1++;
                    }
                }
            }
            map.put(index1, d);
        }
        // find max amount of repetitions and add values to ArrayList
        ArrayList<String> str = new ArrayList<>();
        for (var i : map.entrySet()) {
            if (i.getKey().equals(map.lastKey())) {
                str.add(i.getValue());
            }
        }
        return str;
    }

}
