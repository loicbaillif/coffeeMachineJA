package v2;

public class DisplayStock {

	public static void main() {
		System.out.println("The coffee machine has:");
		System.out.printf("%s ml of water%n", CoffeeMachine.getWater());
		System.out.printf("%s ml of milk%n", CoffeeMachine.getMilk());
		System.out.printf("%s g of coffee beans%n", CoffeeMachine.getCoffeeBeans());
		System.out.printf("%s disposable cups%n", CoffeeMachine.getCups());
		System.out.printf("$%s of money%n", CoffeeMachine.getCash());

	}

}
