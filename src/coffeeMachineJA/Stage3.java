package coffeeMachineJA;

/* ****** PROJECT : Coffee Machine - Stage 2/6 ******
 * 
 * Description
 * A real coffee machine never has an infinite supply of water, milk, or 
 * coffee beans. And if you input a really big number, it’s almost certain 
 * that a real coffee machine wouldn't have the supplies needed to make 
 * all that coffee.
 * 
 * In this stage, you need to improve the previous program. Now you need to 
 * input amounts of water, milk, and coffee beans that your coffee machine 
 * has at the moment.
 * 
 * 1) If the coffee machine has enough supplies to make the specified amount  
 * of coffee, the program should print 
 * "Yes, I can make that amount of coffee". 
 * 2) If the coffee machine can make more than that, the program should output 
 * "Yes, I can make that amount of coffee (and even N more than that)", 
 * where N is the number of additional cups of coffee that the coffee 
 * machine can make. 
 * 3) If the amount of resources is not enough to make the specified amount of 
 * coffee, the program should output 
 * "No, I can make only N cup(s) of coffee".
 * 
 * Like in the previous stage, the coffee machine needs 200 ml of water, 
 * 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.
 * 
 * Instruction
 * Write a program that calculates whether it will be able to make the 
 * required amount of coffee from the specified amount of ingredients.
 * 
 * 
 */

import java.util.Scanner;

public class Stage3 {

	final static int[] INGREDIENT_PER_CUP = {200, 50, 15}; //water milk coffee
	final static byte NB_INGREDIENTS = 3; // water, milk, coffee
	final static String[] INGREDIENTS_S = {
			"ml of water", 
			"ml of milk", 
			"grams of coffee beans"};
	final static String LIST_INGREDIENTS = "Write how many %s " 
			+ "the coffee machine has:";
	final static String NB_CUP_WANTED = "Write how many "
			+ "cups of coffee you will need:";
	final static String REQUIRED_INGREDIENTS = "For %d cups of coffee, you " 
			+ "will need:%n%d ml of water %n%d ml of milk " + 
			"%n%d g of coffee beans%n";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] ingredients = new int[NB_INGREDIENTS];		
		getIngredients(ingredients);
		int nbCups = getNbCups();
		
		analyseRequest(ingredients, nbCups);
		

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
	
	
	public static void getIngredients(int[] ingredients) {
		String request = "";
		for (int i = 0; i < NB_INGREDIENTS; i++) {
			request = String.format(LIST_INGREDIENTS, INGREDIENTS_S[i]);
			do {
			ingredients[i] = checkInt(request);
			} while (ingredients[i] < 0);
		}
	}
	
	
	public static int getNbCups() {
		int result = -1;
		do {
			result = checkInt(NB_CUP_WANTED);
		} while (result < 0);
		
		return result;		
	}
	
	
	public static void analyseRequest(int[] ingredients, int nbCups) {
		int[] nbCupsFeasible = new int[NB_INGREDIENTS];
		int nbCupsMax = 0;
		for (int i = 0; i < NB_INGREDIENTS; i++) {
			nbCupsFeasible[i] = INGREDIENT_PER_CUP[i] == 0 
					? 0
					: ingredients[i] / INGREDIENT_PER_CUP[i];
			if (i == 0 || nbCupsFeasible[i] < nbCupsMax) {
				nbCupsMax = nbCupsFeasible[i];
			}
		}
		if (nbCupsMax < nbCups) {
			System.out.printf("%nNo, I can make only %d cup(s) of coffee", 
					nbCupsMax);
		} else {
			System.out.printf("%nYes, I can make that amount of coffee");
			if (nbCupsMax > nbCups) {
				System.out.printf(" (and even %d more than that)", 
						nbCupsMax - nbCups);
			}
		} 
	}


}
