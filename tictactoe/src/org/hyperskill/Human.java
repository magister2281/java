package org.hyperskill;

public class Human extends Table {

    static  public  void realHuman() {
        if (checkerOfMoving()) {
            if (getC2() == 2) {
                array[getC2() - 1][getC1() - 1] = 88;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfX(getNumberOfX() + 1);
            } else if (getC2() == 1) {
                array[getC2() + 1][getC1() - 1] = 88;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfX(getNumberOfX() + 1);
            } else if (getC2() == 3) {
                array[getC2() - 3][getC1() - 1] = 88;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfX(getNumberOfX() + 1);
            }
        } else {
            if (getC2()== 2) {
                array[getC2() - 1][getC1() - 1] = 79;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfO(getNumberOfO() + 1);
            } else if (getC2() == 1) {
                array[getC2() + 1][getC1() - 1] = 79;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfO(getNumberOfO() + 1);
            } else if (getC2() == 3) {
                array[getC2() - 3][getC1() - 1] = 79;
                setNumberOfSpace(getNumberOfSpace() - 1);
                setNumberOfO(getNumberOfO() + 1);
            }
        }
    }
}
