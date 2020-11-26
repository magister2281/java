package org.hyperskill;

public class WinState extends Table {
    public static int winStates(char[][] array) {
        if (horizontalState(array) > 20) {
            return horizontalState(array);
        } else if (verticalState(array) > 20) {
            return verticalState(array);
        } else if (obliqueState(array) > 20) {
            return obliqueState(array);
        } else {
            if (horizontalState(array) != 0) {
                return horizontalState(array);
            } else if (verticalState(array) != 0) {
                return verticalState(array);
            } else if (obliqueState(array) != 0) {
                return obliqueState(array);
            }
        }
        return 0;
    }

    public static int horizontalState (char [][] array) {
        int status = 0;
        int numberOFXInArrayHorizontal = 0;
        int numberOFOInArrayHorizontal = 0;
        int numberOFXInArrayHorizontal1 = 0;
        int numberOFOInArrayHorizontal1 = 0;
        int numberOFXInArrayHorizontal2 = 0;
        int numberOFOInArrayHorizontal2 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 88) {
                    if (i == 0) {
                        numberOFXInArrayHorizontal++;
                    } else if (i == 1) {
                        numberOFXInArrayHorizontal1++;
                    } else if (i == 2) {
                        numberOFXInArrayHorizontal2++;
                    }
                } else if (array[i][j] == 79) {
                    if (i == 0) {
                        numberOFOInArrayHorizontal++;
                    } else if (i == 1) {
                        numberOFOInArrayHorizontal1++;
                    } else if (i == 2) {
                        numberOFOInArrayHorizontal2++;
                    }
                }
            }
        }

        int[] winX = {numberOFXInArrayHorizontal, numberOFXInArrayHorizontal1, numberOFXInArrayHorizontal2};
        int[] winO = {numberOFOInArrayHorizontal, numberOFOInArrayHorizontal1, numberOFOInArrayHorizontal2};
        for (Integer i: winX) {
            if (i == 3) {
                status = 21;
                break;
            }
        }
        for (Integer i: winO) {
            if (i == 3) {
                status = 22;
                break;
            }
        }
        if ((numberOFXInArrayHorizontal == 2 || numberOFOInArrayHorizontal == 2)
                && numberOFXInArrayHorizontal + numberOFOInArrayHorizontal != 3) {
            return  7;
        }
        if ((numberOFXInArrayHorizontal1 == 2 || numberOFOInArrayHorizontal1 == 2)
                && numberOFXInArrayHorizontal1 + numberOFOInArrayHorizontal1 != 3) {
            return  7;
        }
        if ((numberOFXInArrayHorizontal2 == 2 || numberOFOInArrayHorizontal2 == 2)
                && numberOFXInArrayHorizontal2 + numberOFOInArrayHorizontal2 != 3) {
            return  7;
        }
        return status;
    }
    public static int obliqueState (char [][] array) {
        int status = 0;
        int p = 2;
        int stateOFX0 = 0;
        int stateOFX1 = 0;
        int stateOFO = 0;
        int stateOFO1 = 0;
        for (int i = 0; i < array.length; i++) {
            for(int y = 0; y < array[i].length; y++) {
                if (array[i][y] == 88) {
                    if (y == p) {
                        stateOFX1++;
                    }
                    if (y == i) {
                        stateOFX0++;
                    }
                } else if (array[i][y] == 79) {
                    if (y == p) {
                        stateOFO1++;
                    }
                    if (y == i) {
                        stateOFO++;
                    }
                }
            }
            p--;
        }
        int[] winX = {stateOFX0, stateOFX1};
        int[] winO = {stateOFO, stateOFO1};
        for (Integer i: winX) {
            if (i == 3) {
                status = 21;
                break;
            }
        }
        for (Integer i: winO) {
            if (i == 3) {
                status = 22;
                break;
            }
        }
        if (stateOFX0 == 2 || stateOFO == 2 && stateOFX0 + stateOFO != 3) {
            return  4;
        }
        if (stateOFX1 == 2 || stateOFO1 == 2 && stateOFX1 + stateOFO1 != 3) {
            return 5;
        }

        return status;
    }
    public static int verticalState (char [][] array) {
        int status = 0;
        int numberOFOInArrayVertical0 = 0;
        int numberOFOInArrayVertical1 = 0;
        int numberOFOInArrayVertical2 = 0;
        int numberOFXInArrayVertical0 = 0;
        int numberOFXInArrayVertical1 = 0;
        int numberOFXInArrayVertical2 = 0;
        for(int i = 0; i < array.length; i++) {
            for(int y = 0; y < array[i].length; y++) {
                if (array[i][y] == 88) {
                    if (y == 0) {
                        numberOFXInArrayVertical0++;
                    } else if (y == 1) {
                        numberOFXInArrayVertical1++;
                    } else if (y == 2) {
                        numberOFXInArrayVertical2++;
                    }
                } else if (array[i][y] == 79) {
                    if (y == 0) {
                        numberOFOInArrayVertical0++;
                    } else if (y == 1) {
                        numberOFOInArrayVertical1++;
                    } else if (y == 2) {
                        numberOFOInArrayVertical2++;
                    }
                }
            }
        }
        int[] winX = {numberOFXInArrayVertical0, numberOFXInArrayVertical1, numberOFXInArrayVertical2};
        int[] winO = {numberOFOInArrayVertical0, numberOFOInArrayVertical1, numberOFOInArrayVertical2};
        if ((numberOFXInArrayVertical0 == 2 || numberOFOInArrayVertical0 == 2)
                && numberOFXInArrayVertical0 + numberOFOInArrayVertical0 != 3) {
            status = 1;
        }
        if ((numberOFXInArrayVertical1 == 2 || numberOFOInArrayVertical1 == 2)
                && numberOFXInArrayVertical1 + numberOFOInArrayVertical1 != 3) {
            status = 2;
        }
        if ((numberOFXInArrayVertical2 == 2 || numberOFOInArrayVertical2 == 2)
                && numberOFXInArrayVertical2 + numberOFOInArrayVertical2 != 3) {
            status = 3;
        }
        for (Integer i: winX) {
            if (i == 3) {
                status = 21;
                break;
            }
        }
        for (Integer i: winO) {
            if (i == 3) {
                status = 22;
                break;
            }
        }
        return status;
    }
}
