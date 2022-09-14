package v2;

public class PrepareDrink {
	public static void main(String userChoice) {
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
		String[] drinks = {"unknown", "espresso", "latte", "cappuccino"}; 
		String[] ingredients = {"water", "milk", "coffee beans", "cups"};
		boolean drinkFeasible = false;

		if (userChoice == "back") {
			return;
		} 
		
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
			drink = unknown;
			break;
		}
		
		String confirmationMessage = "";
		
		// Ensure the machine has enough resources
		for (int i = 0; i < machineStock.length; i++) {
			if (machineStock[i] + drink[i] < 0) {
				System.out.printf("Sorry, not enough %s%n", ingredients[i]);
				return;
			}
		}
		
		// Enough stock in the machine, we can prepare the coffee
		System.out.printf("I have enough resources, making you a %s%n", drinks[Integer.parseInt(userChoice)]);
		CoffeeMachine.addWater(drink[0]);
		CoffeeMachine.addMilk(drink[1]);
		CoffeeMachine.addCoffeeBeans(drink[2]);
		CoffeeMachine.addCups(drink[3]);
		CoffeeMachine.addCash(drink[4]);

	}
}
