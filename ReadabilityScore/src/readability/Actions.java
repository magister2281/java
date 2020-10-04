package readability;

import java.io.IOException;
import java.util.Scanner;

public class Actions {
    static double amountOfSentences = 0;
    static double amountOfWords = 0;
    static double amountOfCharacters = 0;
    static double amountOfSyllables = 0;
    static double amountOfPolysyllables = 0;
    static double amountOfCharactersWithoutSpaces = 0;
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;
    static int ceilFleshKincaid = 0;
    static int ceilSmogIndex = 0;
    static int ceilColemanLiauIndex = 0;
    static double scoreSum = 0;
    static double fleshKincaid = 0;
    static double smogIndex = 0;
    static double colemanLiauIndex = 0;
    public static void Countvalues (String input1) {
        int count = 0;
        String regex = "[a-zA-Z_0-9]+[?!.]+[a-zA-Z_0-9\\\\t\\\\n\\\\x0B\\\\f\\\\r]*";
        String syllables = "[ayeiou]+";
        String star = "";
        try {
            String[] array = input1.split(" ");
            for (int i = 0; i < input1.length(); i++) {
                amountOfCharacters++;
            }
            if (!array[array.length - 1].matches(regex)) {
                amountOfSentences++;
            }
            for (String s : array) {
                amountOfWords++;
                if (s.matches(regex)) {
                    amountOfSentences++;
                }
                String lowerCase = s.toLowerCase();
                for (int i = 0; i < lowerCase.length(); i++) {
                    String str = Character.toString(lowerCase.charAt(i));
                    if (str.matches(syllables)) {
                        amountOfSyllables++;
                        count++;
                        if (star.matches(syllables)) {
                            amountOfSyllables--;
                            count--;
                        }
                    }
                    star = str;
                }
                star = "";
                if (lowerCase.matches("[a-zA-Z_0-9]+[ayeiou][e][?!.]*")) {
                    amountOfSyllables++;
                    count++;
                }
                if (lowerCase.matches("[a-zA-Z_0-9]+[e][?!.]*") && count != 1) {
                    amountOfSyllables--;
                    count--;
                }
                if (count >= 3) {
                    amountOfPolysyllables++;
                }
                if (count == 0 && !lowerCase.matches("[a-zA-Z_0-9]+[e][?!.]*")) {
                    amountOfSyllables++;
                }
                count = 0;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        amountOfCharactersWithoutSpaces = (amountOfCharacters - amountOfWords) + 1;
        scoreSum = 4.71 *
                (amountOfCharactersWithoutSpaces / amountOfWords) + 0.5
                * (amountOfWords / amountOfSentences) - 21.43;
        fleshKincaid = 0.39 * (amountOfWords / amountOfSentences) + 11.8 * (amountOfSyllables / amountOfWords) - 15.59;
        smogIndex = 1.043 * Math.sqrt(amountOfPolysyllables * (30 / amountOfSentences)) + 3.1291;
        double L = (amountOfCharactersWithoutSpaces / amountOfWords) * 100;
        double S = (amountOfSentences / amountOfWords) * 100;
        colemanLiauIndex = (0.0588 * L) - (0.296 * S) - 15.8;
        score = (int) Math.round(scoreSum);
        ceilFleshKincaid = (int) Math.round(fleshKincaid);
        ceilSmogIndex = (int) Math.round(smogIndex);
        ceilColemanLiauIndex = (int) Math.round(colemanLiauIndex);
    }


    public static String years(int score) {
        String age = "";
        switch (score) {
            case 1:
                age = "6";
                break;
            case 2:
                age = "7";
                break;
            case 3:
                age = "9";
                break;
            case 4:
                age = "10";
                break;
            case 5:
                age = "11";
                break;
            case 6:
                age = "12";
                break;
            case 7:
                age = "13";
                break;
            case 8:
                age = "14";
                break;
            case 9:
                age = "15";
                break;
            case 10:
                age = "16";
                break;
            case 11:
                age = "17";
                break;
            case 12:
                age = "18";
                break;
            case 13:
                age = "24";
                break;
        }
        return age;
    }

    public static double age(int score, int ceilSmogIndex, int ceilFleshKincaid, int ceilColemanLiauIndex) {

        try {
            return (Double.parseDouble(years(score)) + Double.parseDouble(years(ceilSmogIndex)) + Double.parseDouble(years(ceilFleshKincaid))
                    + Double.parseDouble(years(ceilColemanLiauIndex))) / 4;
        } catch (Exception e) {
            return 0;
        }
    }
    public static void printing ( double words, double sentences, double characters, double syllables, double polysyllables) {
        String format = String.format("Words: %.0f%nSentences: %.0f%nCharacters: %.0f%nSyllables: %.0f%nPolysyllables: %.0f",
                words, sentences, characters, syllables, polysyllables );
        System.out.println(format);
    }
    public static void chooseAction () {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String input = scanner.nextLine();
        switch (input) {
            case "ARI": {
                System.out.printf("Automated Readability Index: %.2f (about %s year olds).", scoreSum, years(score));
                System.out.println();
                System.out.printf("This text should be understood in average by %s year olds.", years(score));
                break;
            }
            case "FK": {
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).", fleshKincaid, years(ceilFleshKincaid));
                System.out.println();
                System.out.printf("This text should be understood in average by %s year olds.", years(ceilFleshKincaid));
                break;
            }
            case "SMOG": {
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).", smogIndex, years(ceilSmogIndex));
                System.out.println();
                System.out.printf("This text should be understood in average by %s year olds.", years(ceilSmogIndex));
                break;
            }
            case "CL": {
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).", colemanLiauIndex, years(ceilColemanLiauIndex));
                System.out.println();
                System.out.printf("This text should be understood in average by %s year olds.", years(ceilColemanLiauIndex));
                break;
            }
            case "all": {
                System.out.printf("Automated Readability Index: %.2f (about %s year olds).%n", scoreSum, years(score));
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).%n", fleshKincaid, years(ceilFleshKincaid));
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).%n", smogIndex, years(ceilSmogIndex));
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).%n", colemanLiauIndex, years(ceilColemanLiauIndex));
                System.out.println();
                System.out.printf("This text should be understood in average by %.2f year olds.", age(score, ceilSmogIndex, ceilFleshKincaid, ceilColemanLiauIndex));
                break;
            }
        }
    }
    public static String convertingToString(String pathToFile) {
        String input1 = "";
        try {
            input1 = ReadingFileDemo.readFileAsString(pathToFile);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        return input1;
    }
}
