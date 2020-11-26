package org.hyperskill;

import static org.hyperskill.WinState.winStates;

public class MediumBot extends EasyBot {
    static public void randomBotMedium () {
        int intState = winStates(array);
        if (intState >= 1 && intState <= 7) {
            int action = 0;
            if (intState == 1) {
                for (int i = 0; i < array.length; i++) {
                    for (int q = 0; ; ) {
                        if (array[i][q] == 32 && checkerOfMoving() && action == 0) {
                            array[i][q] = 88;
                            setNumberOfX(getNumberOfX() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else if (array[i][q] == 32 && !checkerOfMoving() && action == 0) {
                            array[i][q] = 79;
                            setNumberOfO(getNumberOfO() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (intState == 2) {
                for (int i = 0; i < array.length; i++) {
                    for (int q = 1; ; ) {
                        if (array[i][q] == 32 && checkerOfMoving() && action == 0) {
                            array[i][q] = 88;
                            setNumberOfX(getNumberOfX() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else if (array[i][q] == 32 && !checkerOfMoving() && action == 0) {
                            array[i][q] = 79;
                            setNumberOfO(getNumberOfO() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (intState == 3) {
                for (int i = 0; i < array.length; i++) {
                    for (int q = 2; ; ) {
                        if (array[i][q] == 32 && checkerOfMoving() && action == 0) {
                            array[i][q] = 88;
                            setNumberOfX(getNumberOfX() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else if (array[i][q] == 32 && !checkerOfMoving() && action == 0) {
                            array[i][q] = 79;
                            setNumberOfO(getNumberOfO() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                            action++;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (intState == 4) {
                for (int i = 0; i < array.length; i++) {
                    for (; ;) {
                        if (array[i][i] == 32 && checkerOfMoving()) {
                            array[i][i] = 88;
                            setNumberOfX(getNumberOfX() + 1);
                            action++;
                            setNumberOfSpace(getNumberOfSpace() - 1);
                        } else if (array[i][i] == 32 && action == 0) {
                            array[i][i] = 79;
                            setNumberOfO(getNumberOfO() + 1);
                            action++;
                            setNumberOfSpace(getNumberOfSpace() - 1);
                        } else {
                            break;
                        }
                    }
                }
            } else if (intState == 5) {
                for (int i = 0; i < array.length; i++) {
                    for (int q = 0; q < array[i].length; q++) {
                        if (array[i][q] == 32 && array[i].length - q == q && checkerOfMoving() && action == 0) {
                            array[i][q] = 88;
                            action++;
                            setNumberOfX(getNumberOfX() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                        } else if (array[i][q] == 32 && array[i].length - q == q && !checkerOfMoving() && action == 0) {
                            array[i][q] = 79;
                            action++;
                            setNumberOfO(getNumberOfO() + 1);
                            setNumberOfSpace(getNumberOfSpace() - 1);
                        } else {
                            break;
                        }
                    }
                }
            } else if (intState == 7) {
                int horizontal0X = 0;
                int horizontal1X = 0;
                int horizontal2X = 0;
                int horizontal0 = 0;
                int horizontal1 = 0;
                int horizontal2 = 0;
                for (int i = 0; i < array.length; i++) {
                    for (int q = 0; q < array[i].length; q++) {
                        if (array[i][q] == 88 && i == 0) {
                            horizontal0X++;
                        } else if (array[i][q] == 88 && i == 1) {
                            horizontal1X++;
                        } else if (array[i][q] == 88 && i == 2) {
                            horizontal2X++;
                        }
                        if (array[i][q] == 79 && i == 0) {
                            horizontal0++;
                        } else if (array[i][q] == 79 && i == 1) {
                            horizontal1++;
                        } else if (array[i][q] == 79 && i == 2) {
                            horizontal2++;
                        }
                    }
                }
                for (int w = 0; w < array.length; w++) {
                    for (int e = 0; e < array[w].length; e++) {
                        if (horizontal0 == 2 && w == 0 && horizontal0 + horizontal0X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                        if (horizontal1 == 2 && w == 1 && horizontal1 + horizontal1X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                        if (horizontal2 == 2 && w == 2 && horizontal2 + horizontal2X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                        if (horizontal0X == 2 && w == 0 && horizontal0 + horizontal0X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                        if (horizontal1X == 2 && w == 1 && horizontal1 + horizontal1X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                        if (horizontal2X == 2 && w == 2 && horizontal2 + horizontal2X != 3) {
                            if (array[w][e] == 32 && checkerOfMoving() && action == 0) {
                                array[w][e] = 88;
                                setNumberOfX(getNumberOfX() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            } else if (array[w][e] == 32 && !checkerOfMoving() && action == 0) {
                                array[w][e] = 79;
                                setNumberOfO(getNumberOfO() + 1);
                                setNumberOfSpace(getNumberOfSpace() - 1);
                                action++;
                            }
                        }
                    }
                }
            }
            if (action == 0) {
                randomBotEasy();
            }
        }   else {
            randomBotEasy();
        }
        System.out.println("Making move level \"medium\"");
    }
}
