
package ObjectsProject;

import java.util.Scanner;
import java.util.Random;

public class BankMain {

	public static void main(String[] args) {
		String UserChoice = Menu();
		// Continued to program while the user doesn't type 2
		while (UserChoice.equals("1")) {
			// Runs game if user types 1
			if (UserChoice.equals("1")) {
				PlayGame();
			}
			// Brings user back to menu after they exit their piggy bank
			UserChoice = Menu();
		}
		// Goodbye message once user enters 2
		System.out.println("THANK YOU FOR VISITING THE COINCUBBY, GOODBYE");

	}

	private static void PlayGame() {
		// Creates new Banks
		Bank bank1 = new Bank(); // Creates first piggy bank
		Bank bank2 = new Bank(); // Creates second piggy bank
		Scanner input = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			System.out.println("\nWelcome to the Bank!\n=====================\n");
			System.out.println("1. Earn Money");
			System.out.println("2. Deposit coins");
			System.out.println("3. Withdraw coins");
			System.out.println("4. Check bank status");
			System.out.println("5. Compare piggy banks");
			System.out.println("6. Exit");
			System.out.print("Enter your choice (1-6): ");
			int choice = input.nextInt();
			if (choice == 1) {
				Random rand = new Random();
				int numberOne = rand.nextInt(100);
				int numberTwo = rand.nextInt(100);
				System.out.print("\nWhat is " + numberOne + " + " + numberTwo + "?: ");
				int userAnswer = input.nextInt();
				int numberAns = numberOne + numberTwo;
				while (!(userAnswer == numberAns)) {
					System.out.print("incorrect answer, enter again: ");
					userAnswer = input.nextInt();
					input.nextLine();
				}
				if (userAnswer == numberAns) {
					System.out.println("Congratulations, you earned $2 (stored in bank1)");
					int toonies = 1;
					int loonies = 0;
					int quarters = 0;
					int dimes = 0;
					int nickels = 0;
					bank1.deposit(toonies, loonies, quarters, dimes, nickels);

					// ask gpt to make this part ^^^^^
				}
			} else if (choice == 2) {
				System.out.print("1. BankOne: $" + bank1.getTotal() + "\n2. BankTwo: $" + bank2.getTotal()
						+ "\nWhich piggy bank would you like to deposit in?:");
				String BankNumber = input.next();
				while (!BankNumber.equals("1") && !BankNumber.equals("2")) {
					System.out.println("Invalid choice. Please enter either 1 or 2:");
					BankNumber = input.next();
				}
				if (BankNumber.equals("1")) {
					System.out.print("Enter the number of toonies to deposit: $");
					int toonies = input.nextInt();
					System.out.print("Enter the number of loonies to deposit: $");
					int loonies = input.nextInt();
					System.out.print("Enter the number of quarters to deposit: $");
					int quarters = input.nextInt();
					System.out.print("Enter the number of dimes to deposit: $");
					int dimes = input.nextInt();
					System.out.print("Enter the number of nickels to deposit: $");
					int nickels = input.nextInt();

					bank1.deposit(toonies, loonies, quarters, dimes, nickels);
					System.out.println("Coins deposited successfully!");

				} else if (BankNumber.equals("2")) {
					System.out.print("Enter the number of toonies to deposit: $");
					int toonies = input.nextInt();
					System.out.print("Enter the number of loonies to deposit: $");
					int loonies = input.nextInt();
					System.out.print("Enter the number of quarters to deposit: $");
					int quarters = input.nextInt();
					System.out.print("Enter the number of dimes to deposit: $");
					int dimes = input.nextInt();
					System.out.print("Enter the number of nickels to deposit: $");
					int nickels = input.nextInt();

					bank2.deposit(toonies, loonies, quarters, dimes, nickels);
					System.out.println("Coins deposited successfully!");
				}
			} else if (choice == 3) {
				System.out.print("1. BankOne: $" + bank1.getTotal() + "\n2. BankTwo: $" + bank2.getTotal()
						+ "\nWhich piggy bank would you like to withdraw from?:");
				String BankNumber = input.next();
				while (!BankNumber.equals("1") && !BankNumber.equals("2")) {
					System.out.println("Invalid choice. Please enter either 1 or 2:");
					BankNumber = input.next();
				}
				if (BankNumber.equals("1")) {
					System.out.println("Would you like to withdraw all change? (Yes/No)");
					String empty = input.next();
					while (!empty.equalsIgnoreCase("yes") && !empty.equalsIgnoreCase("no")) {
						System.out.println("Invalid choice. Please enter either yes or no:");
						empty = input.next();
					}
					if (empty.equalsIgnoreCase("yes")) {
						bank1.emptyBank();
						System.out.print("Successfully emptied piggy bank");
					} else if (empty.equalsIgnoreCase("no")) {
						System.out.print("Enter the amount to withdraw:");
						double amount = input.nextDouble();
						bank1.withdraw(amount);
					}
				} else if (BankNumber.equals("2")) {
					System.out.println("Would you like to withdraw all change? (Yes/No)");
					String empty = input.next();
					while (!empty.equalsIgnoreCase("yes") && !empty.equalsIgnoreCase("no")) {
						System.out.println("Invalid choice. Please enter either yes or no:");
						empty = input.next();
					}
					if (empty.equalsIgnoreCase("yes")) {
						bank1.emptyBank();
						System.out.print("Successfully emptied piggy bank");
					} else if (empty.equalsIgnoreCase("no")) {
						System.out.print("Enter the amount to withdraw:");
						double amount = input.nextDouble();
						bank2.withdraw(amount);
					}
				}
			} else if (choice == 4) {
				System.out.println("Bank status:");
				bank1.displayImage();
				bank2.displayImage();

			} else if (choice == 5) {
				bank1.compare(bank2);
			} else if (choice == 6) {
				System.out.println("\nExiting to main menu...");
				exit = true;
			} else {
				System.out.println("Invalid choice. Please enter a number between 1 and 4.");
			}
		}
	}

	private static String Menu() {
		Scanner input = new Scanner(System.in);

		// Start the game (Prints out title and asks user to play game)
		System.out.print("\n" + "   _____      _          _____      _     _           \n"
				+ "  / ____|    (_)        / ____|    | |   | |          \n"
				+ " | |     ___  _ _ __   | |    _   _| |__ | |__  _   _ \n"
				+ " | |    / _ \\| | '_ \\  | |   | | | | '_ \\| '_ \\| | | |\n"
				+ " | |___| (_) | | | | | | |___| |_| | |_) | |_) | |_| |\n"
				+ "  \\_____\\___/|_|_| |_|  \\_____\\__,_|_.__/|_.__/ \\__, |\n"
				+ "                                                 __/ |\n"
				+ "                                                |___/ \n");
		System.out.println("\n\t\t(Press Enter to Continue)");
		input.nextLine();

		System.out.print("\n\n    ============================" + "\n   |     <1> Visit Piggy Bank   |"
				+ "\n    ============================" + "\n\n    ============================"
				+ "\n   |     <2> Exit               |" + "\n    ============================"
				+ "\n\nSelect Your Choice: ");
		// User enters their choice
		String choice = input.next();
		// Making sure the user's choice is between 1 and 2
		while (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2")) {
			System.out.print("Select a Valid Choice: ");
			choice = input.next();
			input.nextLine();
		}
		// Once the user chooses between 1 and 2, it returns the choice and runs the
		// option they chose
		return choice;
	}

}

