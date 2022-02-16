package coffeeMachineJA;

import java.util.Objects;

/* ****** PROJECT : Coffee Machine - Stage 4 / 6 ******
 * 
 * Description
 * Let's simulate an actual coffee machine. It has a limited supply of water, 
 * milk, coffee beans, and disposable cups. Also, it counts how much money it 
 * gets for selling coffee. The coffee machine has several options: first, it 
 * needs to be able to sell coffee. It can make different varieties of coffee: 
 * espresso, latte, and cappuccino. Of course, each variety requires a 
 * different amount of supplies, except that all of them require only one 
 * disposable cup. Second, the coffee machine should be able to get 
 * replenished by a special worker. Third, another special worker should be 
 * able to take money from the coffee machine.
 * 
 * Write the program that can do one of these actions at a time. It reads one 
 * line from the standard input, which can be "buy", "fill", or "take". 
 * - If you want to buy some coffee, input "buy". 
 * - If you are a special worker and you think that it is time to fill up 
 * all the supplies for the coffee machine, input "fill". 
 * - If you are another special worker and it is time to take the money 
 * from the coffee machine, input "take".
 * 
 * If the user writes "buy" then they must choose one of three varieties of 
 * coffee that the coffee machine can make: espresso, latte, or cappuccino.
 * 
 * - For the espresso, the coffee machine needs 250 ml of water and 
 * 16 g of coffee beans. It costs $4.
 * - For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, 
 * and 20 g of coffee beans. It costs $7.
 * - And for the cappuccino, the coffee machine needs 200 ml of water, 
 * 100 ml of milk, and 12 g of coffee beans. It costs $6.
 * 
 * If the user writes "fill", the program should ask them how much water, 
 * milk, coffee, and how many disposable cups they want to add to the coffee 
 * machine.
 * 
 * If the user writes "take" the program should give them all the money 
 * that it earned from selling coffee.
 * 
 * At the start, the coffee machine has $550, 400 ml of water, 
 * 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.
 * 
 * Write the program that prints the coffee machine’s state, processes one 
 * query from the user, and also prints the coffee machine’s state after that. 
 * Try to use methods to implement every action that the coffee machine can do.
 * 
 * Instruction
 * Write a program that offers to buy one cup of coffee, to fill up the 
 * ingredients, or to take its money. At the same time, the program should 
 * calculate how many ingredients it has left. And also display the number 
 * of ingredients before and after purchase.
 */


import java.util.Scanner;

public class Stage4 {

	final static int COFFEE_BEANS = 120; // grams
	final static int DISPO_CUPS = 9; // number of cups
	final static int MILK = 540; // milliliters
	final static int MONEY = 550; // dollars
	final static int WATER = 400; // milliliters
	static int[] machineStock = {WATER, MILK, COFFEE_BEANS, DISPO_CUPS, MONEY}; 
	final static String MENU_TOP = "Write action (buy, fill, take):";
	final static String MENU_0 = "buy";
	final static String MENU_1 = "fill";
	final static String MENU_2 = "take";
	final static String MENU_BUY = "What do you want to buy? 1 - espresso, "
			+ "2 - latte, 3 - cappuccino:";
	final static String MENU_FILL = "Write how many %s you want to add:";
	final static String MENU_STATUS = "The coffee machine has:%n"
			+ "%d ml of water %n%d ml of milk %n%d g of coffee beans %n"
			+ "%d disposable cups %n$%d of money %n";



	public static void main(String[] args) {
		showStatus();
		String userInput = menu();

		switch (userInput) {
			case MENU_0: 
				buy();
				break;
			case MENU_1:
				fill();
				break;
			case MENU_2:
				take();
				break;
			default:
				System.out.println("I only have limited skills ...");

		}

	}


	public static String menu() {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		do {
			System.out.println(MENU_TOP);
			userInput = scanner.nextLine();
		} while (!(Objects.equals(MENU_0, userInput) 
				|| Objects.equals(MENU_1, userInput) 
				|| Objects.equals(MENU_2, userInput)));

		return userInput;
	}


	public static void showStatus() {
		System.out.printf(MENU_STATUS, 
				machineStock[0], machineStock[1], machineStock[2], 
				machineStock[3], machineStock[4]);
	}


	public static void buy() {
		System.out.println("You want to buy");
	}


	public static void fill() {
		System.out.println("You want to fill");
	}


	public static void take() {
		System.out.println("You want to take");
	}

}
