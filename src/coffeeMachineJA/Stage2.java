package coffeeMachineJA;

/* ****** PROJECT : Coffee Machine - Stage 2/6 ******
 * 
 * Description
 * Now let's consider a case where you need a lot of coffee. Maybe, for 
 * example, you’re hosting a party with a lot of guests. The program should 
 * calculate how much water, coffee, and milk are necessary to make the 
 * specified amount of coffee. One cup of coffee made on this coffee machine 
 * contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
 * 
 * The user should input the amount of coffee he needs, in cups, 
 * for all the guests.
 * 
 * Of course, all this coffee is not needed right now, so at this stage, 
 * the coffee machine doesn’t actually make any coffee.
 * 
 * Instruction
 * Write a program that calculates the amount of ingredients needed to 
 * make a certain amount of coffee.
 */

import java.util.Scanner;

public class Stage2 {

	final static int WATER_PER_CUP = 200; // 200 ml
	final static byte MILK_PER_CUP = 50; // 50 mL
	final static byte COFFEE_PER_CUP = 15; // 15g
	final static String NB_CUP_WANTED = "Write how many "
			+ "cups of coffee you will need:";
	final static String REQUIRED_INGREDIENTS = "For %d cups of coffee, you " 
			+ "will need:%n%d ml of water %n%d ml of milk " + 
			"%n%d g of coffee beans%n";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nbCups = -1; // invalid value
		do {
			nbCups = checkInt(NB_CUP_WANTED);
		} while (nbCups < 0);
		
		printIngredients(nbCups);
		

		scanner.close();
	}

	public static int checkInt(String invite) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.printf("%s%n> ", invite);
		int result = -1;
		if (scanner.hasNextInt()) {
			result = scanner.nextInt();
		} else {
			scanner.next();
		}
		return result;
	}
	
	public static void printIngredients(int nbCups) {
		int water = nbCups * WATER_PER_CUP;
		int milk = nbCups * MILK_PER_CUP;
		int coffee = nbCups * COFFEE_PER_CUP;
		System.out.printf(REQUIRED_INGREDIENTS, nbCups, water, milk, coffee);
	}

}
