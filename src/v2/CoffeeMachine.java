package v2;

public class CoffeeMachine {
	// Variables
	private int water = 400;
	private int milk = 540;
	private int coffeeBeans = 120;
	private int cups = 9;
	private int cash = 550;
	
	// Getters & Setters
	public int getWater() {
		return this.water;
	}
	public void addWater(int water) {
		this.water += water;
	}
	
	public int getMilk() {
		return this.milk;
	}
	public void addMilk(int milk) {
		this.milk += milk;
	}
	
	public int getCoffeeBeans() {
		return this.coffeeBeans;
	}
	public void addCoffeeBeans(int coffeeBeans) {
		this.coffeeBeans += coffeeBeans;
	}
	
	public int getCups() {
		return this.cups;
	}
	public void addCups(int cups) {
		this.cups += cups;
	}
	
	public int getCash() {
		return this.cash;
	}
	public void addCash(int cash) {
		this.cash += cash;
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
