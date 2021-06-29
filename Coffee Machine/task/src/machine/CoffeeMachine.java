package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int disposable = 9;
    static int money = 550;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        String str = "";

        while (!str.equals("exit")) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            str = scanner.next();

            if(str.equals("buy")) {
                buyOption();
            }
            else if(str.equals("fill")) {
                fillOption();
            }
            else if(str.equals("take")) {
                takeOption();
            }
            else if(str.equals("remaining")) {
                machineState();
            }
        }










    }

    public static void coffeeSteps() {

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

    }

    public static void amountNeeded(int amount) {
        System.out.println("For "+ amount +" cups of coffee you will need:");
        System.out.println(amount*200 + " ml of water");
        System.out.println(amount*50 + " ml of milk");
        System.out.println(amount*15 + " g of coffee beans");
    }

    public static void makeCoffee(int amount) {

        int watercount = water / 200;
        int milkcount = milk/50;
        int beanscount = beans/15;

        int availableCount = Math.min(watercount,Math.min(milkcount,beanscount));

        if(availableCount > amount) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (availableCount - amount )+ " more than that)");
        }
        else if(availableCount == amount) {
            System.out.println("Yes, I can make that amount of coffee ");
        }
        else {
            System.out.println("No, I can make only " + availableCount +" cup(s) of coffee");
        }

    }

    public static void machineState() {

        System.out.println("The coffee machine has:");
        System.out.println( + water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans+ " g of coffee beans");
        System.out.println(disposable + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void buyOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String str = scanner.next();

        if(str.equals("back")) {
            return;
        }

        int n = Integer.valueOf(str);

        if(n == 1) {
            buyExpresso();
        }
        else if( n == 2) {
             buyLatte();
        }
        else if( n == 3) {
            buyCapacino();
        }

    }

    public static void fillOption() {

        Scanner scanner = new Scanner(System.in);

        int n = 0;

        System.out.println("Write how many ml of water you want to add:");
        n = scanner.nextInt();
        water += n;

        System.out.println("Write how many ml of milk you want to add: ");
        n = scanner.nextInt();
        milk += n;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        n = scanner.nextInt();
        beans += n;

        System.out.println("Write how many disposable cups of coffee you want to add:");
        n =scanner.nextInt();
        disposable += n;
    }

    public static void takeOption() {

        System.out.println("I gave you $" + money);
        money = 0;

    }

    public static void buyExpresso() {

        if(water < 250) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if(beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        water = water - 250;
        beans = beans - 16;
        money = money + 4;
        disposable--;


        System.out.println("I have enough resources, making you a coffee!");

    }

    public static void buyLatte() {

        if(water < 350) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if(milk < 75) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if(beans < 20) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        water = water - 350;
        milk = milk - 75;
        beans = beans - 20;
        money = money + 7;
        disposable--;


        System.out.println("I have enough resources, making you a coffee!");
    }

    public static void buyCapacino() {

        if(water < 200) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if(milk < 100) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if(beans < 12) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        water = water - 200;
        milk = milk - 100;
        beans = beans - 12;
        money = money + 6;
        disposable--;


        System.out.println("I have enough resources, making you a coffee!");

    }
}
