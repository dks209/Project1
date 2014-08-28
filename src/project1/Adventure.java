package project1;

import java.util.Scanner;

public class Adventure {

	static Scanner input = new Scanner(System.in);
	static char firstLetter;
	static String response = "";
	static String tempResponse = "";
	static String[] splitResponse;
	static int x_coordinate = 0, y_coordinate = 0;
	// y_coordinate is North/South, x_coordinate is East/West
	static int[] position = { y_coordinate, x_coordinate };
	static String[] inventory = { "brass lantern", "rope", "rations", "staff" };

	public static void main(String[] args) {
		System.out
				.println("Welcome to your Adventure!\nPut on your big boy pants and proceed with caution...");

		while (!(response.equals("QUIT") || response.equals("quit"))) {
			System.out.println("\nWhat do you want to do?");
			tempResponse = input.nextLine();
			response = tempResponse.toUpperCase();
			splitResponse = response.split(" +");

			firstLetter = splitResponse[0].charAt(0);

			if (firstLetter == 'G'){
				if(splitResponse.length == 2)
					move(splitResponse[1], position);
				else
					System.out.println("\nThat was not a valid direction, please enter 'go' then north, south, east, or west.");
			}

			else if (splitResponse[0].equals("INVENTORY")) {
				System.out.println("\nInventory Items:");
				for (String item : inventory)
					System.out.println(item);
			}

			else if(!splitResponse[0].equals("QUIT"))
				System.out
						.println("That is not a valid input. Please try again.");
		}

		System.out
				.println("\nRun away...see you next time, if you've got the guts.");
		System.exit(0);
	}

	private static void move(String direction, int[] position) {

		switch (direction) {
		case "NORTH":
			if (position[0] != 0)
				y_coordinate--;
			else
				System.out
						.println("\nYou cannot go further North, there's a cliff. You wouldn't want to get hurt...");
			break;
		case "SOUTH":
			if (position[0] != 4)
				y_coordinate++;
			else
				System.out
						.println("\nGoing further South looks boring, you decide not to go that way.");
			break;
		case "EAST":
			if (position[1] != 4)
				x_coordinate++;
			else
				System.out
						.println("\nYou hear a scary noise to the East and decide against that direction. You chicken.");
			break;
		case "WEST":
			if (position[1] != 0)
				x_coordinate--;
			else
				System.out
						.println("\nYou're Uncle warned you about going too far west...let's just trust him on that.");
			break;

		default:
			System.out
					.println("\nThat was not a valid direction, please enter north, south, east, or west.\n");
			break;
		}

		position[0] = y_coordinate;
		position[1] = x_coordinate;
		
		System.out.println("You are located at (" + position[0] + ","
				+ position[1] + ").");
	}
}
