package coffeeMachineJA;

import java.util.Objects;
import java.util.Scanner;

/* ****** PROJECT : Coffee Machine - Stage 5 / 6 ******
 * 
 *  
 *  Description: *  
 *  But just one action isn’t interesting. Let's improve the program so it can 
 *  do multiple actions, one after another. The program should repeatedly ask 
 *  what the user wants to do. If the user types "buy", "fill" or "take", then 
 *  just do what the program did in the previous step. However, if the user 
 *  wants to switch off the coffee machine, he should type "exit". Then the 
 *  program should terminate. Also, when the user types "remaining", the 
 *  program should output all the resources that the coffee machine has. 
 *  This means that you shouldn't show the remaining stock levels at the 
 *  beginning/end of the program.
 *  
 *  Also, do not forget that you can be out of resources for making coffee. 
 *  If the coffee machine doesn’t have enough resources to make coffee, the 
 *  program should output a message that says it can't make a cup of coffee 
 *  and state what is missing.
 *  
 *  And the last improvement to the program at this step—if the user types 
 *  "buy" to buy a cup of coffee and then changes his mind, he should be able 
 *  to type "back" to return into the main cycle.
 *  
 *  Remember, that:
 *  
 *  For the espresso, the coffee machine needs 250 ml of water and 
 *  16 g of coffee beans. It costs $4.
 *  For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, 
 *  and 20 g of coffee beans. It costs $7.
 *  And for the cappuccino, the coffee machine needs 200 ml of water, 
 *  100 ml of milk, and 12 g of coffee. It costs $6.
 *  
 *  
 *  Instruction:
 *  Write a program that will work endlessly to make coffee for all 
 *  interested persons until the shutdown signal is given.
 *  
 */

public class Stage5 {

	final static int COFFEE_BEANS = 120; // grams
	final static int DISPO_CUPS = 9; // number of cups
	final static int MILK = 540; // milliliters
	final static int MONEY = 550; // dollars
	final static int WATER = 400; // milliliters
	// We may add resources to the machine, but MONEY needs to be the last.
	static int[] machineStock = {WATER, MILK, COFFEE_BEANS, DISPO_CUPS, MONEY}; 

	// 1 - Top menu variables
	final static String MENU_TOP = "%nWrite action "
			+ "(buy, fill, take, remaining, exit):%n";
	final static String MENU_0 = "buy";
	final static String MENU_1 = "fill";
	final static String MENU_2 = "take";
	final static String MENU_3 = "remaining";
	final static String MENU_4 = "exit";

	// 2 - "buy" menu variables
	final static String MENU_BUY = "What do you want to buy? 1 - espresso, "
			+ "2 - latte, 3 - cappuccino, back - to main menu:%n";
	// DRINK_X variables are made of: water, milk, coffee beans, cups, money
	final static int[] DRINK_1 = {-250, 0, -16, -1, 4}; // Espresso
	final static int[] DRINK_2 = {-350, -75, -20, -1, 7}; // Latte
	final static int[] DRINK_3 = {-200, -100, -12, -1, 6}; // Cappuccino
	final static int[][] LIST_DRINKS = {DRINK_1, DRINK_2, DRINK_3};
	final static byte NB_DRINKS = 3;

	// 3 - "fill" menu variables
	final static String MENU_FILL = "Write how many %s you want to add:%n";
	final static String[] LIST_FILL = {
			"ml of water", "ml of milk", "grams of coffee beans", 
	"disposable cups of coffee" };

	// 4 - "take" menu variables
	final static String MENU_TAKE = "I gave you $%d%n%n";

	// 5 - "remaining" menu variables
	final static String MENU_STATUS = "The coffee machine has:%n"
			+ "%d ml of water %n%d ml of milk %n%d g of coffee beans %n"
			+ "%d disposable cups %n$%d of money %n";

	public static void main(String[] args) {
		
		boolean exit = false;
		String userInput = "";
		
		do {
			userInput = menu();
			
			switch (userInput) {
			case MENU_0: 
				buy(); // Needs to be updated
				break;
			case MENU_1:
				fill(); // Tested and validated
				break;
			case MENU_2:
				take(); // Tested and validated
				break;
			case MENU_3:
				remaining();
				break;
			case MENU_4:
				exit = true;
			default:
				System.out.println("I only have limited skills ...");
			}
		} while (!exit);


	}


	public static String menu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		do {
			System.out.printf(MENU_TOP);
			userInput = scanner.nextLine();
		} while (!(Objects.equals(MENU_0, userInput) 
				|| Objects.equals(MENU_1, userInput) 
				|| Objects.equals(MENU_2, userInput)));

		return userInput;
	}


	public static void buy() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		boolean returnToMenu = false;
		byte userDrink = -1;
		String pattern = "back";

		do {
			System.out.printf(MENU_BUY);
			
			if (scanner.hasNextByte()) {
				userDrink = scanner.nextByte();
				if (userDrink > 0 && userDrink <= NB_DRINKS) {
					validInput = true;					
				}
			} else if (Objects.equals(pattern, scanner.next())) {
				validInput = true;
				returnToMenu = true;
			} 
			
			System.out.printf("validInput = %b%n", validInput);
		} while (!validInput);
		
		if (!returnToMenu) {
			userDrink--; // from human counting to machine counting
			updateStock(LIST_DRINKS[userDrink]);			
		}
		
	}


	public static void fill() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int qty = -1; // default invalid quantity
		int[] addToStock = new int[machineStock.length];

		for (int i = 0; i < LIST_FILL.length; i++) {			
			do {
				System.out.printf(MENU_FILL, LIST_FILL[i]);
				if (scanner.hasNextInt()) {
					qty = scanner.nextInt();
				} else {
					qty = -1; // Important to reset qty for next resources
					scanner.next();
				}
			} while (qty < 0);
			addToStock[i] = qty;
		}
		updateStock(addToStock);
	}


	public static void remaining() {
		System.out.printf(MENU_STATUS, 
				machineStock[0], machineStock[1], machineStock[2], 
				machineStock[3], machineStock[4]);
	}


	public static void take() {
		int cash = machineStock[machineStock.length - 1];
		machineStock[machineStock.length - 1] = 0;
		System.out.printf(MENU_TAKE, cash);
	}


	public static void updateStock(int[] input) {
		if (input.length == machineStock.length) {
			for (int i = 0; i < machineStock.length; i++) {
				machineStock[i] += input[i];
			}
		} 
	}

}
