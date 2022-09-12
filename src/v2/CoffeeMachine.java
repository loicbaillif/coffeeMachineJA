package v2;

public class CoffeeMachine {

	public static void main(String[] args) {
		System.out.println("***** Coffee Machine V2 *****");
		String currentState = "generalMenu";
		while (currentState != "exit") {
			currentState = CollectUserInput.main(currentState);
			System.out.println(currentState);
		}
		
	}

}
