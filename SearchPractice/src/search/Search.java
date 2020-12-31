package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Search {

    private List<String> array;
    private String[] values;

    public List<String> getArray() {
        return array;
    }

    public String[] getValues() {
        return values;
    }

    protected Search(String path, String[] values) {
        this.array = readFile(path);
        this.values = values;
    }

    protected Search() {
    }

    abstract ArrayList<String> search();

    protected List<String> readFile(String path) {
        File file = new File(path);
        List<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Path doesn't exists");
        }
        return result;
    }

    protected void printing(List<String> array) {
        System.out.println(array.size() + " persons found:");
        for (String str : array) {
            System.out.println(str);
        }
    }

}
