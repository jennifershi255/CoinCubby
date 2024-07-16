package ObjectsProject;

public class Bank {
	
	// declaring class variables
	
	private int nickel, dime, quarter, loonie, toonie;
	
	private double total;
	
	
	// constructor method, sets all values to 0
	public Bank () {
		
		nickel = 0;
		
		dime = 0;
		
		quarter = 0;
		
		loonie = 0;
		
		toonie = 0;
		
		total = 0;
		
	}
	
	// modifier method
	public void deposit (int newToonie, int newLoonie,int newQuarter,  int newDime, int newNickel) {
		
		toonie += newToonie;
		
		loonie += newLoonie;
		
		quarter += newQuarter;
		
		dime += newDime;
		
		nickel += newNickel;
		
	}
	
	//accessor methods
	
	public int getToonie() {
		
		return toonie;
	}
	public int getLoonie() {
		
		return loonie;
	}
	
	public int getQuarter() {
		
		return quarter;
	}
	
	public int getDime() {
		
		return dime;
	}
	
	public int getNickel() {
		
		return nickel;
	}
	
	/* Pre: N/A
	 * Post: Returns the value of the total amount of money in the bank to the main class
	 * Action: Calculates the total amount by multiplying the amount of each coin by its value
	 */

	public double getTotal () {
		
		total = nickel*0.05 + dime*0.1 + quarter*0.25 + loonie + toonie*2; // calculates the total amount of money in bank
		
		return total; 
	}
	
	/* Pre: N/A
	 * Post: The amount of every coin is set to 0
	 * Action: Sets the amount of every coin to 0
	 */
	public void emptyBank () {
		
		nickel = 0;
		
		loonie = 0;
		
		quarter = 0;
		
		dime = 0;
		
		toonie = 0;
		
		
	}
	
	/* Pre: N/A
	 * Post: Returns how many of each type of coin is withdrawn from the piggy bank
	 * Action: Determines if the amount withdrawn is less or equal than the amount in the bank. 
	 * Calculates how many of each type of coin is needed, by dividing the withdrawn amount by value of each coin
	 */
	
	public void withdraw (double amount) {
		
		double [] coinValues = {2.00, 1.00, 0.25, 0.10, 0.05}; 
		
		int[] coinsCount = new int[5]; // creating an array of 5 to keep track of the amount of coins there are	
		
		if (amount <= getTotal()) { // makes sure there is enough money to take out
			
			// calculating how much of each coin is needed to withdraw 
			// go through each coin in descending order of value 
			  for (int i = 0; i < coinValues.length; i++) {
		        	
		            // calculate the number of coins of the current value to give out
		        	
		            int count = (int) (amount / coinValues[i]);
		            
		            amount -= count * coinValues[i];
		            
		            // updating how many coins are left after removing them
		            
		            if (i == 0) {
		            	
		            	toonie -= count;
		            }
		            
		            else if (i == 1) {
		            	
		            	loonie -= count;
		            }
		            
		            else if (i == 2) {
		            	
		            	quarter -= count;
		            }
		            
		            else if (i == 3) {
		            	
		            	dime -= count;
		            }
		            
		            else if (i == 4) {
		            	
		            	nickel -= count;
		            }

		            // update the count of the current coin to be given to the user
		            
		            coinsCount[i] = count;
			  }
			  
			  // displays the amount of coins that are withdrawn
		
			  System.out.println("Coins withdrawn successfully:");
              System.out.println("Toonies: " + coinsCount[0]);
              System.out.println("Loonies: " + coinsCount[1]);
              System.out.println("Quarters: " + coinsCount[2]);
              System.out.println("Dimes: " + coinsCount[3]);
              System.out.println("Nickels: " + coinsCount[4]);
		} 
		  else { // if there is not enough money to withdraw
			  
			  System.out.println("Insufficient funds.");
		  }
	
		
        
		} 
	
	/* Pre: There must be more than one bank created in the main
	 * Post: Prints out the comparisons of each type of coin as well as the total amount of money
	 * Action: Compares each type of coin, to see if one bank is greater, equal or less than the other
	 *         Compares the total amount of money, as well as if the total amount of each coin is the same
	 */
	
	public void compare (Bank b) {
	
		System.out.println("COIN COMPARISONS");
		
		// compares toonies
		
		System.out.println("TOONIES: \nBANK 1: " + getToonie() + "\nBANK 2: " + b.getToonie());
		
		if (getToonie() == b.getToonie()) {
			
			System.out.println("Toonies are equal");
		} 
		
		else if (getToonie() > b.getToonie()) {
			
			System.out.println("Bank 1 has more toonies");
		}
		
		else if (getToonie() < b.getToonie()) {
			
			System.out.println("Bank 2 has more toonies");
		}
		
		System.out.println();
		
		// compares loonies
		
		System.out.println("LOONIES: \nBANK 1: " + getLoonie() + "\nBANK 2: " + b.getLoonie());
		if (getLoonie() == b.getLoonie()) {
			
			System.out.println("Loonies are equal");
		} 
		
		else if (getLoonie() > b.getLoonie()) {
			
			System.out.println("Bank 1 has more loonies");
		}
		
		else if (getLoonie() < b.getLoonie()) {
			
			System.out.println("Bank 2 has more loonies");
		}
		
		System.out.println();
		//compares quarters
		
		System.out.println("QUARTERS: \nBANK 1: " + getQuarter() + "\nBANK 2: " + b.getQuarter());
		if (getQuarter() == b.getQuarter()) {
			
			System.out.println("Quarters are equal");
		} 
		
		else if (getQuarter() > b.getQuarter()) {
			
			System.out.println("Bank 1 has more quarters");
		}
		
		else if (getQuarter() < b.getQuarter()) {
			
			System.out.println("Bank 2 has more quarters");
		}
		
		System.out.println();
		//compares dimes
		System.out.println("DIMES: \nBANK 1: " + getDime() + "\nBANK 2: " + b.getDime());
		if (getDime() == b.getDime()) {
			
			System.out.println("Dimes are equal");
		} 
		
		else if (getDime() > b.getDime()) {
			
			System.out.println("Bank 1 has more dimes");
		}
		
		else if (getDime() < b.getDime()) {
			
			System.out.println("Bank 2 has more dimes");
		}
		
		System.out.println();
		// compares nickels
		
		System.out.println("NICKELS: \nBANK 1: " + getNickel() + "\nBANK 2: " + b.getNickel());
		
		if (getNickel() == b.getNickel()) {
			
			System.out.println("Nickels are equal");
		} 
		
		else if (getNickel() > b.getNickel()) {
			
			System.out.println("Bank 1 has more nickels");
		}
		
		else if (getNickel() < b.getNickel()) {
			
			System.out.println("Bank 2 has more nickles");
		}
		
		System.out.println();
		// determines if the banks are exactly identical by comparing the amount of every type of coin
		
		if ((getToonie() == b.getToonie() && getLoonie() == b.getLoonie() && getQuarter() == b.getQuarter() && getDime() == b.getDime() && getNickel() == b.getNickel())) {
			 
			System.out.print("Piggybanks are exactly the same");
		}
		
		else if (getTotal() == b.getTotal()) { // determines if banks have equal amount
			
			System.out.println("Piggybanks have equal total amounts");
		}
		
		else if (getTotal() < b.getTotal()) {
			
			System.out.println("Bank 2 has more money");
		}
		
		else if (getTotal() > b.getTotal()) {
			
			System.out.println("Bank 1 has more money");
		
		}
		
		
	
	}
	
	public void displayImage () {
		
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⠿⠋⠀            \n\n"
				+ "           TOTAL: $" + getTotal() +"       \n"
				+ "⠀⠀⢴⡄⢠⣴⢶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡔⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠈⠻⣿⡧⠾⠃⣠⣤⡖⠚⢛⣛⣉⣉⣛⠛⠂⣠⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⣷⡀⣰⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⡇⢠⣿⣿⡇⢠⡀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⠈⣿⣿⣿⣿Toonies: " + getToonie()+ "⣿⣿⣿⣿⡿⠿⢿⣄\n"
				+ "⠀⠀⠀⠀⢸⣿⣿⣿⣿Loonies: " +getLoonie() + "⣿⣿⣿⣿⣧⣠⣼⣿⣷⣶⣶\n"
				+ "⠀⠀⠀⠀⠸⣿⣿⣿⣿Quarters: " + getQuarter()+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\n"
				+ "⠀⠀⠀⠀⠀⠻⣿⣿⣿Dimes: " + getDime() +  "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\n"
				+ "⠀⠀⠀⠀  ⠻⣿⣿Nickels: " + getNickel() + "⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠋    \n ⠀"
				+ "⠀     ⠁⣸⣿⣿⣿⠿⣿⣿⣿⣿⡿⢿⣿⣿⣿⡉⠋⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀ ⠀⠀⠀⢀⣿⣿⣿⡏⠸⣿⣿⣿⣿⡧⠈⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀ ⠀⠀⠸⠿⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⠿⠿⠂⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");
	}
	
	
	

}
