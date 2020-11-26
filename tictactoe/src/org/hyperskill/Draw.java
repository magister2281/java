package org.hyperskill;

public class Draw extends Table {

    public static int draw() {
        int status = 0;
        if (getNumberOfSpace() == 0) {
            status = 4;
        }
        return status;
    }
}
