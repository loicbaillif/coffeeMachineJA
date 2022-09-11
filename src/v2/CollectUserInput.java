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
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Write action (buy, fill, take, remaining, exit)");
		userInput = scanner.nextLine();
		
		// int test = lv1State.indexOf(userInput);
		
		return userInput;
	}
}
