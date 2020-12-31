package search;

import java.util.ArrayList;

public class NoneSearch extends Search {


    protected NoneSearch(String path, String[]  values) {
        super(path, values);
    }
    /* method for none-type strategy
    If the strategy is NONE,
    the program should print lines that do not contain words from the query at all:
    */
    @Override
    protected ArrayList<String> search() {
        ArrayList<String> array1 = new ArrayList<>(getArray());
        for (var data : getValues()) {
            for (var value: getArray()) {
                if (value.toLowerCase().strip().contains(data.toLowerCase().strip())) {
                    array1.remove(value);
                }
            }
        }
        return array1;
    }
}
