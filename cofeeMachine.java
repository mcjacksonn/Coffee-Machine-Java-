package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int mlOfWater = 400;
    private static int mlOfMilk = 540;
    private static int gramsOfCoffeeBeans = 120;
    private static int disposableCups = 9;
    private static int currentMoney = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printRemaining();
                    break;
                case "exit":
                    return; // Exit the program
                default:
                    System.out.println("Invalid action. Please choose 'buy', 'fill', 'take', 'remaining', or 'exit'.");
                    break;
            }
        }
    }

    public static void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(mlOfWater + " ml of water");
        System.out.println(mlOfMilk + " ml of milk");
        System.out.println(gramsOfCoffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + currentMoney + " of money");
    }

    public static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.next();

        switch (coffeeType) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid coffee type. Please choose 1, 2, 3 or 'back'.");
                break;
        }
    }

    public static void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (mlOfWater < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (mlOfMilk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (gramsOfCoffeeBeans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            mlOfWater -= waterNeeded;
            mlOfMilk -= milkNeeded;
            gramsOfCoffeeBeans -= beansNeeded;
            disposableCups -= 1;
            currentMoney += cost;
        }
    }

       public static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water to fill:");
        int mlOfWaterToAdd = scanner.nextInt();

        System.out.println("Write how many ml of milk to fill:");
        int mlOfMilkToAdd = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans to fill:");
        int gramsOfCoffeeBeansToAdd = scanner.nextInt();

        System.out.println("Write how many disposable cups to fill:");
        int disposableCupsToAdd = scanner.nextInt();

        mlOfWater += mlOfWaterToAdd;
        mlOfMilk += mlOfMilkToAdd;
        gramsOfCoffeeBeans += gramsOfCoffeeBeansToAdd;
        disposableCups += disposableCupsToAdd;
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + currentMoney);
        currentMoney = 0;
    }
}



