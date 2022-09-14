package v2;

import java.util.Objects;

public class CoffeeMachine {
	// Variables
	private static int water = 400;
	private static int milk = 540;
	private static int coffeeBeans = 120;
	private static int cups = 9;
	private static int cash = 550;
	
	// Getters & Setters
	public static int getWater() {
		return water;
	}
	public static void addWater(int waterUsed) {
		water += waterUsed;
	}
	
	public static int getMilk() {
		return milk;
	}
	public static void addMilk(int milkUsed) {
		milk += milkUsed;
	}
	
	public static int getCoffeeBeans() {
		return coffeeBeans;
	}
	public static void addCoffeeBeans(int coffeeBeansUsed) {
		coffeeBeans += coffeeBeansUsed;
	}
	
	public static int getCups() {
		return cups;
	}
	public static void addCups(int cupsUsed) {
		cups += cupsUsed;
	}
	
	public static int getCash() {
		return cash;
	}
	public static void addCash(int cashUsed) {
		cash += cashUsed;
	}
	
	
	// Functions
	public static void updateStock(int[] resources) {
		// following order: water, milk, coffeeBeans, cup, cash
		if (resources.length != 5) {
			resources = new int[] {0, 0, 0, 0, 0};
		}
		addWater(resources[0]);
		addMilk(resources[1]);
		addCoffeeBeans(resources[2]);
		addCups(resources[3]);
		addCash(resources[4]);
	}
	

	// Main
	public static void main(String[] args) {
		System.out.println("***** Coffee Machine V2 *****");
		String currentState = "generalMenu";
		while (!Objects.equals(currentState, "exit")) {
			currentState = CollectUserInput.main(currentState);
		}
		
	}

}
