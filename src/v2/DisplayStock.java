package v2;

public class DisplayStock {

	public static void main() {
		System.out.println("The coffee machine has:");
		System.out.printf("%s ml of water", CoffeeMachine.getWater());
		System.out.printf("%s ml of milk", CoffeeMachine.getMilk());
		System.out.printf("%s g of coffee beans", CoffeeMachine.getCoffeeBeans());
		System.out.printf("%s disposable cups", CoffeeMachine.getCups());
		System.out.printf("$%s of money", CoffeeMachine.getCash());

	}

}
