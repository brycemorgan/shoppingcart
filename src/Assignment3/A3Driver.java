package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class A3Driver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err.println("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}

		List<String> commands = new ArrayList<String>();
		// Open file; file name specified in args (command line)
		try {
			FileReader freader = new FileReader(args[0]);
			BufferedReader reader = new BufferedReader(freader);
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				commands.add(s);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}

		// Stub for arraylist.
		ArrayList<Item> shoppingCart = new ArrayList<Item>();

		// Parse input, take appropriate actions.
		for (int x = 0; x < commands.size(); x++) {
			Scanner scanner = new Scanner(commands.get(x));
			if (!isValidOperation(scanner)) {
				System.out.println("invalid operation");
				continue;
			}
				
			if (!isValidCategory(scanner)) {
				System.out.println("invalid category");
				continue;
			}
				
			if (!isValidName(scanner)) {
				System.out.println("invalid name");
				continue;
			}
				
			if (!isValidPrice(scanner)) {
				System.out.println("invalid price");
				continue;
			}
				
			if (!isValidQuantity(scanner)) {
				System.out.println("invalid quantity");
				continue;
			}
				
			if (!isValidWeight(scanner)) {
				System.out.println("invalid weight");
				continue;
			}
				
			if (!isValidPerishable(scanner)) {
				System.out.println("invalid perishable");
				continue;
			}
			
			if (!isValidState(scanner)) {
				System.out.println("invalid state");
				continue;
			}
				
			
				
			
		}

		// General code example for how to iterate an array list. You will have
		// to modify this heavily, to suit your needs.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) {
			Item temp = i.next();
			temp.calculatePrice();
			temp.printItemAttributes();
			// This (above) works because of polymorphism: a determination is
			// made at runtime,
			// based on the inherited class type, as to which method is to be
			// invoked. Eg: If it is an instance
			// of Grocery, it will invoke the calculatePrice () method defined
			// in Grocery.
		}
	}

	private static final String[] OPERATIONS = { "insert", "search", "delete",
			"update", "print" };

	private static boolean isValidOperation(Scanner scanner) {
		String operation = "";
		try {
			operation = scanner.next();
		} catch (Exception e) {
			return false;
		}

		for (int x = 0; x < OPERATIONS.length; x++) {
			if (operation.equals(OPERATIONS[x])) {
				return true;
			}
		}
		return false;
	}

	private static final String[] CATEGORIES = { "clothing", "groceries",
			"electronics" };

	private static boolean isValidCategory(Scanner scanner) {
		String category = "";
		try {
			category = scanner.next();
		} catch (Exception e) {
			return false;
		}

		for (int x = 0; x < CATEGORIES.length; x++) {
			if (category.equals(CATEGORIES[x])) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValidName(Scanner scanner) {
		String name = "";
		try {
			name = scanner.next();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidPrice(Scanner scanner) {
		double price = 0;
		try {
			price = scanner.nextDouble();
		} catch (Exception e) {
			return false;
		}
		if (price < 0) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidQuantity(Scanner scanner) {
		int quantity = 0;
		try {
			quantity = scanner.nextInt();
		} catch (Exception e) {
			return false;
		}
		if (quantity < 0) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidWeight(Scanner scanner) {
		double weight = 0;
		try {
			weight = scanner.nextDouble();
		} catch (Exception e) {
			return false;
		}
		if (weight < 0) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidPerishable(Scanner scanner) {
		String perishable = "";
		try {
			perishable = scanner.next();
		} catch (Exception e) {
			return false;
		}

		
		if (perishable.equals("NP")) {
			return true;
		} else if (perishable.equals("P")){
			return true;
		}
		return false;
	}
	
	private static boolean isValidFragile(Scanner scanner) {
		String fragile = "";
		try {
			fragile = scanner.next();
		} catch (Exception e) {
			return false;
		}

		
		if (fragile.equals("F")) {
			return true;
		} else if (fragile.equals("NF")){
			return true;
		}
		return false;
	}
	
	private static final String[] STATES = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", 
		"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

	private static boolean isValidState(Scanner scanner) {
		String state = "";
		try {
			state = scanner.next();
		} catch (Exception e) {
			return false;
		}

		for (int x = 0; x < STATES.length; x++) {
			if (state.equals(STATES[x])) {
				return true;
			}
		}
		return false;
	}
	
}
