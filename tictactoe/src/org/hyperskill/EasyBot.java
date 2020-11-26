package org.hyperskill;

import java.util.Random;

public class EasyBot extends Table {
    static Random random = new Random();
    static public String randomBotEasy () {
        int stop = 0;
        if (checkerOfMoving()) {
            while (stop == 0) {
                int randomc1 = random.nextInt(3);
                int randomc2 = random.nextInt(3);
                if (array[randomc1][randomc2] == 32) {
                    array[randomc1][randomc2] = 88;
                    setNumberOfX(getNumberOfX() + 1);
                    setNumberOfSpace(getNumberOfSpace() - 1);
                    stop++;
                }
            }
        } else {
            while (stop == 0) {
                int randomc1 = random.nextInt(3);
                int randomc2 = random.nextInt(3);
                if (array[randomc1][randomc2] == 32) {
                    array[randomc1][randomc2] = 79;
                    setNumberOfO(getNumberOfO() + 1);
                    setNumberOfSpace(getNumberOfSpace() - 1);
                    stop++;
                }
            }
        }
        return "Making move level \"easy\"";
    }
}
