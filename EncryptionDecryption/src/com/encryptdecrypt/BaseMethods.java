package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class BaseMethods implements EncDecMethod {
    private String[] arguments;

    public BaseMethods(String[] arguments) {
        this.arguments = arguments;
    }

    public String writeFile(String out, String data) {
        File file = new File(out);
        if (data.length() > 0) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(data);
            } catch (IOException e) {
                return String.format("An exception occurs %s", e.getMessage());
            }
            return perfectPrint(out);
        } else {
            return "There wasn't any data, i did nothing";
        }
    }

    public String readFile(String in) {
        File file = new File(in);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                result.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + in);
        }
        return result.toString();
    }

    public String perfectPrint(String out) {
        return String.format("Done, your data is in this file '%s'", out);
    }


    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }


}
