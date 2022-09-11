package v2;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectUserInput {
	public static String main(String currentState) {
		// Variables
		/*
		ArrayList<String> lv1State = new ArrayList<String>();
		lv1State.add("buy");
		lv1State.add("fill");
		lv1State.add("take");
		lv1State.add("remaining");
		lv1State.add("exit");
		*/
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		switch (currentState) {
		case "generalMenu":
			userInput = generalMenu(scanner);
			break;
		case "buyMenu":
			userInput = buyMenu(scanner);
			break;
		case "fillMenu":
			userInput = fillMenu(scanner);
			break;

		default:
			break;
		}
		
		return userInput;
	}
	
	public static String generalMenu(Scanner scanner) {		
		System.out.println("Write action (buy, fill, take, remaining, exit)");
		String userInput = scanner.nextLine();
		
		return userInput;
	}
	
	public static String buyMenu(Scanner scanner) {
		System.out.println("What do you want to buy? 1 - espresso, "
				+ "2 - latte, 3 - cappuccino, back - to main menu:");
		return scanner.nextLine();
	}
	
	public static String fillMenu(Scanner scanner) {
		// Variables
		String[] ingredientList = {"ml of water", "mk of milk", 
		                           "grams of coffee beans", "disposable cups"};
		String userInput = "";
		for (int i = 0; i < ingredientList.length; i++) {
			System.out.printf("Write how many %s you want to add:\n> ");
			userInput += scanner.nextLine();
			userInput += ","; 
		}
		
		return userInput;
	}
}
