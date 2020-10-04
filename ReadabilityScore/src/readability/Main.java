package readability;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\ReadabilityScore\\src\\readability\\text.txt";
        Actions.convertingToString(path);
        Actions.Countvalues(Actions.convertingToString(path));
        Actions.printing(Actions.amountOfWords, Actions.amountOfSentences,
                Actions.amountOfCharactersWithoutSpaces, Actions.amountOfSyllables, Actions.amountOfPolysyllables);
        Actions.chooseAction();
    }
}







