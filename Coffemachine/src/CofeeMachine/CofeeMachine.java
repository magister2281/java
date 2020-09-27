package CofeeMachine;
import java.util.Scanner;
class CoffeeMachine {
    public static int waterConsist = 400;
    public static int milkConsist = 540;
    public static int coffeeBeansConsist = 120;
    public static int cupsOfCoffeeConsist = 9;
    public static int money = 550;
    public static int exit = 0;
    enum typeOfCoffee {
        ESPRESSO(250, 0, 16, 1, 4),
        LATTE(350, 75, 20, 1, 7),
        CAPPUCCINO(200, 100, 12, 1, 6);
        final int amountOfWater;
        final int amountOfMilk;
        final int amountOfCoffeeBeans;
        final int amountOfCups;
        final int cost;
        typeOfCoffee(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans, int amountOfCups, int cost) {
            this.amountOfWater = amountOfWater;
            this.amountOfMilk = amountOfMilk;
            this.amountOfCoffeeBeans = amountOfCoffeeBeans;
            this.amountOfCups = amountOfCups;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        while (exit == 0) {
            execution();
        }
    }
    public static void printing(int waterConsist, int milkConsist,
                                int coffeeBeansConsist, int cupsOfCoffeeConsist, int money) {
        String forPrinting = String.format("The coffee machine has:%n" +
                        "%d of water%n" +
                        "%d of milk%n%d of coffee beans%n" +
                        "%d of disposable cups%n%d of money",
                waterConsist, milkConsist, coffeeBeansConsist,
                cupsOfCoffeeConsist, money);
        System.out.println(forPrinting);

    }
    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int waterFill = scanner.nextInt();
        waterConsist += waterFill;
        System.out.println("Write how many ml of milk do you want to add:");
        int milkFill = scanner.nextInt();
        milkConsist += milkFill;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeansFill = scanner.nextInt();
        coffeeBeansConsist += coffeeBeansFill;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsOfCoffeeFill = scanner.nextInt();
        cupsOfCoffeeConsist += cupsOfCoffeeFill;
    }
    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                if ((waterConsist - typeOfCoffee.ESPRESSO.amountOfWater) >= 0
                        && (coffeeBeansConsist - typeOfCoffee.ESPRESSO.amountOfCoffeeBeans) >= 0
                        && (cupsOfCoffeeConsist - typeOfCoffee.ESPRESSO.amountOfCups) >= 0) {
                    waterConsist -= typeOfCoffee.ESPRESSO.amountOfWater;
                    coffeeBeansConsist -= typeOfCoffee.ESPRESSO.amountOfCoffeeBeans;
                    cupsOfCoffeeConsist -= typeOfCoffee.ESPRESSO.amountOfCups;
                    money += typeOfCoffee.ESPRESSO.cost;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                } else if((waterConsist - typeOfCoffee.ESPRESSO.amountOfWater) < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if((coffeeBeansConsist - typeOfCoffee.ESPRESSO.amountOfCoffeeBeans) < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "2":
                if ((waterConsist - typeOfCoffee.LATTE.amountOfWater) >= 0
                        && (milkConsist - typeOfCoffee.LATTE.amountOfMilk) >= 0
                        && (coffeeBeansConsist - typeOfCoffee.LATTE.amountOfCoffeeBeans) >= 0
                        && (cupsOfCoffeeConsist - typeOfCoffee.LATTE.amountOfCups) >= 0) {
                    waterConsist -= typeOfCoffee.LATTE.amountOfWater;
                    milkConsist -= typeOfCoffee.LATTE.amountOfMilk;
                    coffeeBeansConsist -= typeOfCoffee.LATTE.amountOfCoffeeBeans;
                    cupsOfCoffeeConsist -= typeOfCoffee.LATTE.amountOfCups;
                    money += typeOfCoffee.LATTE.cost;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                } else if((waterConsist - typeOfCoffee.LATTE.amountOfWater) < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if((milkConsist - typeOfCoffee.LATTE.amountOfMilk) < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if((coffeeBeansConsist - typeOfCoffee.ESPRESSO.amountOfCoffeeBeans) < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "3":
                if ((waterConsist - typeOfCoffee.CAPPUCCINO.amountOfWater) >= 0
                        && (milkConsist - typeOfCoffee.CAPPUCCINO.amountOfMilk) >= 0
                        && (coffeeBeansConsist - typeOfCoffee.CAPPUCCINO.amountOfCoffeeBeans) >= 0
                        && (cupsOfCoffeeConsist - typeOfCoffee.CAPPUCCINO.amountOfCups) >= 0) {
                    waterConsist -= typeOfCoffee.CAPPUCCINO.amountOfWater;
                    milkConsist -= typeOfCoffee.CAPPUCCINO.amountOfMilk;
                    coffeeBeansConsist -= typeOfCoffee.CAPPUCCINO.amountOfCoffeeBeans;
                    cupsOfCoffeeConsist -= typeOfCoffee.CAPPUCCINO.amountOfCups;
                    money += typeOfCoffee.CAPPUCCINO.cost;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                } else if((waterConsist - typeOfCoffee.CAPPUCCINO.amountOfWater) < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if((milkConsist - typeOfCoffee.CAPPUCCINO.amountOfMilk) < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if((coffeeBeansConsist - typeOfCoffee.CAPPUCCINO.amountOfCoffeeBeans) < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "back":
                execution();
        }
    }
    public static void take() {
        System.out.printf("I gave you $%d%n", money);
        money -= money;
    }
    public static void remaining() {
        printing(waterConsist, milkConsist, coffeeBeansConsist, cupsOfCoffeeConsist, money);
    }
    public static void execution() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "fill":
                fill();
                break;
            case "buy":
                buy();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                exit++;
        }
    }
}
