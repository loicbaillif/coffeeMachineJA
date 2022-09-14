package v2;

import java.util.Objects;

public class PrepareDrink {
	public static void main(String userChoice) {
		// Treat the exit case first, to avoid useless variable instance.
		if (Objects.equals(userChoice, "back")) {
			System.out.println("Okay, let's go back.");
			return;
		} 
		
		
		// Drinks needs (water, milk, coffeeBeans, cup, cash)
		final int[] espresso = new int[] {-250, 0, -16, -1, 4};
		final int[] latte = new int[] {-350, -75, -20, -1, 7};
		final int[] cappuccino = new int[] {-200, -100, -12, -1, 6};
		final int[] unknown = new int[] {0, 0, 0, 0, 0};
		int[] drink;
		int[] machineStock = new int[] {
				CoffeeMachine.getWater(), 
				CoffeeMachine.getMilk(), 
				CoffeeMachine.getCoffeeBeans(), 
				CoffeeMachine.getCups()
		};
		String[] drinks = {"surprise", "espresso", "latte", "cappuccino"}; 
		String[] ingredients = {"water", "milk", "coffee beans", "cups"};
		String unsufficientStock = "Sorry, not enough %s%n";
		String prepareDrink = "I have enough resources, making you a %s%n";
		
		// Pick values corresponding to user choice
		switch (userChoice) {
		case "1":
			drink = espresso;
			break;
		case "2":
			drink = latte;
			break;
		case "3":
			drink = cappuccino;
			break;

		default:
			userChoice = "0";
			drink = unknown;
			break;
		}
		
		// Ensure the machine has enough resources
		for (int i = 0; i < machineStock.length; i++) {
			if (machineStock[i] + drink[i] < 0) {
				System.out.printf(unsufficientStock, ingredients[i]);
				return;
			}
		}
		
		// Enough stock in the machine, we can prepare the coffee
		System.out.printf(prepareDrink, drinks[Integer.parseInt(userChoice)]);
		CoffeeMachine.updateStock(drink);

	}
}
