package v2;

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
	public static void addWater(int waterNew) {
		water += waterNew;
	}
	
	public static int getMilk() {
		return milk;
	}
	public static void addMilk(int milkNew) {
		milk += milkNew;
	}
	
	public static int getCoffeeBeans() {
		return coffeeBeans;
	}
	public static void addCoffeeBeans(int coffeeBeansNew) {
		coffeeBeans += coffeeBeansNew;
	}
	
	public static int getCups() {
		return cups;
	}
	public static void addCups(int cupsNew) {
		cups += cupsNew;
	}
	
	public static int getCash() {
		return cash;
	}
	public static void addCash(int cashNew) {
		cash += cashNew;
	}
	

	public static void main(String[] args) {
		System.out.println("***** Coffee Machine V2 *****");
		String currentState = "generalMenu";
		while (currentState != "exit") {
			currentState = CollectUserInput.main(currentState);
			System.out.println(currentState);
		}
		
	}

}
