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
		case "buy":
			userInput = buyMenu(scanner);
			break;
		case "fill":
			userInput = fillMenu(scanner);
			break;	
		case "remaining":
			userInput = remainingMenu();
			break;
		case "exit":
			userInput = "exit";
			break;

		default:
			userInput = generalMenu(scanner);
			break;
		}

		return userInput;
	}

	public static String generalMenu(Scanner scanner) {		
		System.out.println("Write action (buy, fill, take, remaining, exit)");
		return scanner.nextLine();
	}

	public static String buyMenu(Scanner scanner) {
		System.out.println("What do you want to buy? 1 - espresso, "
				+ "2 - latte, 3 - cappuccino, back - to main menu:");
		PrepareDrink.main(scanner.nextLine());
		
		return "generalMenu";
	}

	public static String fillMenu(Scanner scanner) {
		// Variables
		String[] ingredientList = {"ml of water", "mk of milk", 
				"grams of coffee beans", "disposable cups"};
		String userInput = "";
		for (int i = 0; i < ingredientList.length; i++) {
			System.out.printf("Write how many %s you want to add:\n> ", ingredientList[i]);
			userInput += scanner.nextLine();
			if (i != ingredientList.length - 1) {
				userInput += ","; 
			}
		}

		return userInput;
	}
	
	public static String remainingMenu() {
		DisplayStock.main();
		
		return "generalMenu";
	}
}
