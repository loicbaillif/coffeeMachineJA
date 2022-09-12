package v2;

public class PrepareDrink {
	public static void main(String userChoice) {
		// Drinks needs (water, milk, coffeeBeans, cup, cash)
		final int[] espresso = new int[] {-250, 0, -16, -1, 4};
		final int[] latte = new int[] {-350, -75, -20, -1, 7};
		final int[] cappuccino = new int[] {-200, -100, -12, -1, 6};
		final int[] unknown = new int[] {0, 0, 0, 0, 0};
		int[] drink;

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
		
		CoffeeMachine.addWater(drink[0]);
		CoffeeMachine.addMilk(drink[1]);
		CoffeeMachine.addCoffeeBeans(drink[2]);
		CoffeeMachine.addCups(drink[3]);
		CoffeeMachine.addCash(drink[4]);
		

	}
}
