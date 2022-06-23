package assignment4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Part1 {
	
	// Decimal Rounding
	private static final DecimalFormat decimal = new DecimalFormat("0.00");
	
	// Scanner
	private static final Scanner scanner = new Scanner(System.in);
	
	// Method that does most of the work and returns the array
	public static ArrayList<String> itemAdd() {
		
		// Random integer value
		int cont = 5;
					
		// Create array to store all values
		ArrayList<String> items = new ArrayList<String>();
					
		//Actual total
		double total = 0;
		
		// While loop that runs until user wants it to stop
		while (cont != 0) {
			
			//Transaction total
			double transtotal = 0;
			
			//Reading the item name
			System.out.println("Please enter the item name: ");
			String name = scanner.nextLine();
			
			// Reading the item cost
			System.out.println("What is the unit cost?: ");
			double cost = scanner.nextDouble();
			
			// Reading Quantity
			System.out.println("Please enter the quantity: ");
			int quantity = scanner.nextInt();
			
			// Calculate Total Cost
			double quan = quantity;
			transtotal = (quan * cost);
			total += transtotal;
			
			// Add to Array
			items.add("\n" + "Item name: " + name + " |" + " Item Cost: " + cost + " |" + " Item Quantity: " + quantity + " |" + " Transaction Total: " + decimal.format(transtotal) + " |" + " Running Total: " + decimal.format(total));
			
			// Should the program continue? 
			System.out.println("Would you like to enter more? (1 for yes, 0 for no): ");
			int cont1 = scanner.nextInt();
			if (cont1 == 0) {
				cont = 0;
			}
			else {
				cont = 1;
			}
			
			// Scanner automatically reads next line, hence this is used so it does not skip to item cost
			scanner.nextLine();
			
			// Print Array with all the items
			System.out.println(items);
			
		}
		
		// Return Array to be used later
		return(items);
	}
	
	public static void main(String[] args) {
		
		try {
			
			// Create / Append file
			FileWriter main = new FileWriter("Part1.txt", true);
			
			// Run method and store return type in mainArray
			ArrayList<String> mainArray = itemAdd();
			
			// Loop that writes to the file
			for (String text : mainArray) {
				main.write (text + System.lineSeparator());
			}
			
			// Close scanner & File writer
			main.close();
			scanner.close();
		}
		
		// Catch & Print exception
		catch(IOException e) {
			System.out.println(e.toString());
		}

	}

}
