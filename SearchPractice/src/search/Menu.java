package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Search searchClass;
    Scanner scanner = new Scanner(System.in);

    public void menu(String path) {
        SearchFactory searchFactory = new SearchFactory();
        label:
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    final String constant = "No matching people found.";
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner.nextLine().toLowerCase();
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    String[] dataForSearching = scanner.nextLine().split(" ");
                    searchClass = searchFactory.searchFactory(strategy, path, dataForSearching);
                    if (searchClass != null) {
                        List<String> allFindingData = new ArrayList<>(searchClass.search());
                        if (!allFindingData.isEmpty()) {
                            searchClass.printing(allFindingData);
                        } else {
                            System.out.println(constant);
                        }
                    } else {
                        System.out.println("Invalid strategy");
                    }
                    break;
                case "2":
                    System.out.println("=== List of people ===");
                    AllSearch allSearch = new AllSearch();
                    allSearch.printing(allSearch.readFile(path));
                    break;
                case "0":
                    System.out.println("\nBye!");
                    break label;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }
        }
    }
}
