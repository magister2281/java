package org.hyperskill;

public class Main {
    public static void main(String[] args) {
        int stopFirst = 0;
        while (stopFirst == 0) {
            Table.setNumberOfO(0);
            Table.setNumberOfX(0);
            Table.setNumberOfSpace(0);
            int stopSecond = 0;
            String[] inputChecker = Table.input();
            if (inputChecker[0].equals("exit")) {
                stopFirst++;
            } else if (inputChecker[0].equals("start") && inputChecker.length == 3 ) {
                Table.createTableForGame();
                Table.printing();
                while (stopSecond == 0) {
                    if (WinState.winStates(Table.array) == 21 || WinState.winStates(Table.array) == 22) {
                        Table.printing(WinState.winStates(Table.array));
                        stopSecond++;
                        continue;
                    } else if (Draw.draw() == 4) {
                        Table.printing(Draw.draw());
                        stopSecond++;
                        continue;
                    }
                    Table.typeOfActions(inputChecker[1], inputChecker[2]);
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }

    }
}
