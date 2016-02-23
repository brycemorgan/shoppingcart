package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class A3Driver {
	public static ArrayList<Item> shoppingCart = new ArrayList<Item>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err
					.println("Error: Incorrect number of command line arguments");
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
			System.out.println("Error: File not found. Exiting...");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}

		// Stub for arraylist.

		// Parse input, take appropriate actions.
		for (int x = 0; x < commands.size(); x++) {
			Scanner scanner = new Scanner(commands.get(x));

			String operation = getOperation(scanner);

			if (operation.equals(OPERATIONS[0])) {
				insert(scanner);
			} else if (operation.equals(OPERATIONS[1])) {
				search(scanner);
			} else if (operation.equals(OPERATIONS[2])) {
				delete(scanner);
			} else if (operation.equals(OPERATIONS[3])) {
				update(scanner);
			} else if (operation.equals(OPERATIONS[4])) {
				print(scanner);
			}

			scanner.close();
		}

		// General code example for how to iterate an array list. You will have
		// to modify this heavily, to suit your needs.
		/*
		 * Iterator<Item> i = shoppingCart.iterator(); while (i.hasNext()) {
		 * Item temp = i.next(); temp.calculatePrice();
		 * temp.printItemAttributes();
		 * 
		 * // This (above) works because of polymorphism: a determination is //
		 * made at runtime, // based on the inherited class type, as to which
		 * method is to be // invoked. Eg: If it is an instance // of Grocery,
		 * it will invoke the calculatePrice () method defined // in Grocery. }
		 */
	}

	public static void insert(Scanner s) {
		String category = getCategory(s);
		if (category.equals(""))
			return;

		String name = getName(s);
		if (name.equals(""))
			return;

		double price = getPrice(s);
		if (price == -1)
			return;

		int quantity = getQuantity(s);
		if (quantity == -1)
			return;

		int weight = getWeight(s);
		if (weight == -1)
			return;

		if (category.equals("clothing")) {
			Clothing tempItem = new Clothing(name, price, quantity, weight,
					category);
			shoppingCart.add(tempItem);
		}

		if (category.equals("electronics")) {
			String fragile = getFragile(s);
			if (fragile.equals("")) {
				return;
			}

			boolean fragileBool = true;
			if (fragile.equals("NF"))
				fragileBool = false;

			String state = getState(s);
			if (state.equals(""))
				return;

			Electronics tempItem = new Electronics(name, price, quantity,
					weight, category, state, fragileBool);
			shoppingCart.add(tempItem);
		}

		if (category.equals("groceries")) {
			String perishable = getPerishable(s);
			if (perishable.equals(""))
				return;

			boolean perishableBool = true;
			if (perishable.equals("NP"))
				perishableBool = false;

			Grocery tempItem = new Grocery(name, price, quantity, weight,
					category, perishableBool);
			shoppingCart.add(tempItem);
		}
	}

	public static void search(Scanner s) {
		int quantity = 0;
		String searchName = getName(s);
		if (searchName.equals(""))
			return;

		for (Iterator<Item> i = shoppingCart.iterator(); i.hasNext();) {
			Item temp = i.next();
			if (temp.name.equals(searchName)) {
				quantity += temp.quantity;
			}
		}
		System.out.println("Number of " + searchName + "(s): " + quantity);
	}

	public static void delete(Scanner s) {

		int index = 0, count = 0;
		String searchName = getName(s);
		if (searchName.equals(""))
			return;

		for (Iterator<Item> i = shoppingCart.iterator(); i.hasNext(); count++) {
			Item temp = i.next();
			if (temp.name.equals(searchName)) {
				shoppingCart.remove(count);

			}
		}
	}

	public static void update(Scanner s) {
		String searchName = getName(s);
		if (searchName.equals(""))
			return;

		int newQuantity = getQuantity(s);
		if (newQuantity == -1) {
			return;
		}

		for (Iterator<Item> i = shoppingCart.iterator(); i.hasNext();) {
			Item temp = i.next();
			if (temp.name.equals(searchName)) {
				temp.quantity = newQuantity;
			}
		}
	}

	public static void print(Scanner s) {
		Iterator<Item> i = shoppingCart.iterator();
		double finalPrice = 0;
		while (i.hasNext()) {
			Item temp = i.next();
			finalPrice += temp.calculatePrice();
			temp.printItemAttributes();
		}
		System.out.println("Final cost: " + finalPrice);
	}

	private static final String[] OPERATIONS = { "insert", "search", "delete",
			"update", "print" };

	private static String getOperation(Scanner scanner) {
		String operation = "";
		try {
			operation = scanner.next();
		} catch (Exception e) {
			System.out.println("missing operation");
			return "";
		}

		for (int x = 0; x < OPERATIONS.length; x++) {
			if (operation.equals(OPERATIONS[x])) {
				return operation;
			}
		}
		System.out.println("not a valid operation");
		return "";
	}

	private static final String[] CATEGORIES = { "clothing", "groceries",
			"electronics" };

	private static String getCategory(Scanner scanner) {
		String category = "";
		try {
			category = scanner.next();
		} catch (Exception e) {
			System.out.println("missing category field");
			return "";
		}

		for (int x = 0; x < CATEGORIES.length; x++) {
			if (category.equals(CATEGORIES[x])) {
				return category;
			}
		}

		System.out.println("not a valid category");
		return "";
	}

	private static String getName(Scanner scanner) {
		String name = "";
		try {
			name = scanner.next();
		} catch (Exception e) {
			System.out.println("missing name field");
			return "";
		}
		return name;
	}

	private static double getPrice(Scanner scanner) {
		double price = 0;
		try {
			price = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("missing price field");
			return -1;
		}
		if (price < 0) {
			System.out.println("Price must be positive");
			return -1;
		}
		return price;
	}

	private static int getQuantity(Scanner scanner) {
		int quantity = 0;
		try {
			quantity = scanner.nextInt();
		} catch (Exception e) {
			System.out
					.println("missing quantity field or quantity is not integer");
			return -1;
		}
		if (quantity < 0) {
			System.out.println("Quantity must be positive");
			return -1;
		}
		return quantity;
	}

	private static int getWeight(Scanner scanner) {
		int weight = 0;
		try {
			weight = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("missing weight integer field");
			return -1;
		}
		if (weight < 0) {
			System.out.println("weight must be positive");
			return -1;
		}
		return weight;
	}

	private static String getPerishable(Scanner scanner) {
		String perishable = "";
		try {
			perishable = scanner.next();
		} catch (Exception e) {
			System.out.println("missing perishable field");
			return "";
		}

		if (perishable.equals("NP")) {
			return perishable;
		} else if (perishable.equals("P")) {
			return perishable;
		}

		System.out.println("Perishable field must be P or NP");
		return "";
	}

	private static String getFragile(Scanner scanner) {
		String fragile = "";
		try {
			fragile = scanner.next();
		} catch (Exception e) {
			System.out.println("missing fragile field");
			return "";
		}

		if (fragile.equals("F")) {
			return fragile;
		} else if (fragile.equals("NF")) {
			return fragile;
		}

		System.out.println("Only F or NF");
		return "";
	}

	private static final String[] STATES = { "AL", "AK", "AZ", "AR", "CA",
			"CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
			"KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE",
			"NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA",
			"RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
			"WY" };

	private static String getState(Scanner scanner) {
		String state = "";
		try {
			state = scanner.next();
		} catch (Exception e) {
			System.out.println("missing state field");
			return "";
		}

		for (int x = 0; x < STATES.length; x++) {
			if (state.equals(STATES[x])) {
				return state;
			}
		}
		System.out.println("invalid state");
		return "";
	}
}
