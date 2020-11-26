package org.hyperskill;

import java.util.Scanner;

public class Table {
    static Scanner scanner = new Scanner(System.in);
    private static int c1 = 0;
    private static int c2 = 0;
    protected static char[][] array = new char[3][3];
    private static int numberOfX = 0;
    private static int numberOfO = 0;
    private static int numberOfSpace = 0;

    public static int getC1() {
        return c1;
    }

    public static void setC1(int c1) {
        Table.c1 = c1;
    }

    public static int getC2() {
        return c2;
    }

    public static void setC2(int c2) {
        Table.c2 = c2;
    }

    public static int getNumberOfX() {
        return numberOfX;
    }

    public static void setNumberOfX(int numberOfX) {
        Table.numberOfX = numberOfX;
    }

    public static int getNumberOfO() {
        return numberOfO;
    }

    public static void setNumberOfO(int numberOfO) {
        Table.numberOfO = numberOfO;
    }

    public static int getNumberOfSpace() {
        return numberOfSpace;
    }

    public static void setNumberOfSpace(int numberOfSpace) {
        Table.numberOfSpace = numberOfSpace;
    }

    public static void createTableForGame() {
        char[] stringForArray = new char[9];
        for (int q = 0; q < 9; q++) {
            stringForArray[q] = ' ';
            numberOfSpace++;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0) {
                    array[i][j] = stringForArray[j];
                } else {
                    array[i][j] = stringForArray[j + (array.length * i)];
                }
            }
        }
    }

    static public int coordinates() {
        System.out.println("Enter the coordinates:");
        int status = 0;
        try {
            String str = scanner.nextLine();
            String[] arrayStr = str.split(" ");
            setC1(Integer.parseInt(arrayStr[0]));
            setC2(Integer.parseInt(arrayStr[1]));
            char  checker = array[c1 - 1][c2 - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Coordinates should be from 1 to 3!");
            status = 6;
        }
        catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            System.out.println(e.getMessage());
            status = 5;
        }
        return status;
    }
    static public String[] input() {
        try {
            System.out.println("Input command:");
            String scannerStr = scanner.nextLine();
            boolean exit = scannerStr.equals("exit");
            if (exit) {
                return new String[]{"exit"};
            } else {
                String[] scannerStr1 = scannerStr.split(" ");
                boolean result = scannerStr1[2].equals("easy") || scannerStr1[2].equals("user")
                        || scannerStr1[2].equals("medium") || scannerStr1[2].equals("hard");
                boolean result2 = scannerStr1[1].equals("easy") || scannerStr1[1].equals("user")
                        || scannerStr1[1].equals("medium") || scannerStr1[1].equals("hard");
                if (result && result2) {
                    return scannerStr1;
                } else {
                    return new String[]{"Bad"};
                }
            }
        } catch (Exception e) {
            return new String[]{"Bad"};
        }
    }

    static public int occupied() {
        int status = 0;
        try {
            if (c2 == 2 && array[c2 - 1][c1 - 1] != 32)
            {
                System.out.println("This cell is occupied! Choose another one!");
                status++;
            } else if (c2 == 1 && array[c2 + 1][c1 - 1] != 32)
            {
                status++;
                System.out.println("This cell is occupied! Choose another one!");
            } else if (c2 == 3 && array[c2 - 3][c1 - 1] != 32)
            {
                status++;
                System.out.println("This cell is occupied! Choose another one!");
            }

        } catch(ArrayIndexOutOfBoundsException ignored){

        }
        return status;
    }
    static public void typeOfActions(String commandName1, String commandName2) {
        if (commandName1.equals("medium") && commandName2.equals("medium")) {
            MediumBot.randomBotMedium();
            printing();
        }
        if (commandName1.equals("medium") && commandName2.equals("easy")) {
            MediumBot.randomBotMedium();
            printing();
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                printing(EasyBot.randomBotEasy());
                printing();
            }
        }
        if (commandName1.equals("easy") && commandName2.equals("medium")) {
            printing(EasyBot.randomBotEasy());
            printing();
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                MediumBot.randomBotMedium();
                printing();
            }
        }
        if (commandName1.equals("easy") && commandName2.equals("easy")) {
            printing(EasyBot.randomBotEasy());
            printing();
        } else if (commandName1.equals("user") && commandName2.equals("user")) {
            int number = coordinates();
            if (number == 0) {
                if (occupied() == 0) {
                    Human.realHuman();
                    printing();
                }
            }
        } else if (commandName1.equals("medium") && commandName2.equals("user")) {
            MediumBot.randomBotMedium();
            printing();
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                int stop = 0;
                while (stop == 0) {
                    int number = coordinates();
                    if (number == 0) {
                        if (occupied() == 0) {
                            Human.realHuman();
                            stop++;
                            printing();
                        }
                    }
                }
            }
        } else if (commandName1.equals("easy") && commandName2.equals("user")) {
            printing(EasyBot.randomBotEasy());
            printing();
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                int stop = 0;
                while (stop == 0) {
                    int number = coordinates();
                    if (number == 0) {
                        if (occupied() == 0) {
                            Human.realHuman();
                            stop++;
                            printing();
                        }
                    }
                }
            }
        } else if (commandName1.equals("user") && commandName2.equals("medium")) {
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                int stop = 0;
                while (stop == 0) {
                    int number = coordinates();
                    if (number == 0) {
                        if (occupied() == 0) {
                            Human.realHuman();
                            stop++;
                            printing();
                        }
                    }
                }
            }
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                MediumBot.randomBotMedium();
                printing();
            }
        } else if (commandName1.equals("user") && commandName2.equals("easy")) {
            int stop = 0;
            while (stop == 0) {
                int number = coordinates();
                if (number == 0) {
                    if (occupied() == 0) {
                        Human.realHuman();
                        stop++;
                        printing();
                    }
                }
            }
            if (Draw.draw() != 4 && WinState.winStates(array) < 20) {
                printing(EasyBot.randomBotEasy());
                printing();
            }
        }
    }

    static public void printing() {
        System.out.println("---------");
        for (char[] chars : array) {
            for (int e = 0; e < array.length; e++) {
                if (e == 0) {
                    System.out.print("|" + " ");
                }
                System.out.print(chars[e] + " ");
                if (e == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
    static public void printing(String data) {
        System.out.println(data);
    }
    public static boolean checkerOfMoving() {
        return numberOfO == numberOfX;
    }
    public static void printing (int res) {
        switch (res) {
            case 21:
                System.out.println("X wins");
                break;
            case 22:
                System.out.println("O wins");
                break;
            case 3:
                System.out.println("Game not finished");
                break;
            case 4:
                System.out.println("Draw");
                break;
        }
    }
}
