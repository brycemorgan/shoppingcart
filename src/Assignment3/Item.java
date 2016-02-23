package Assignment3;

public abstract class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?

// You will need a constructor (Why?). Create it here.
	
	protected String name;
	protected double price;
	protected int quantity;
	protected int weight;
	protected String type;
	protected String[] allStates = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", 
			"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
	protected String[] noSalesTaxStates = {"TX", "NM", "VA", "AZ", "AK"};
	Item(String nameI, double priceI, int quantityI, int weightI, String typeI){
		name = nameI;
		price = priceI;
		quantity = quantityI;
		weight = weightI;
		type = typeI;
	}
	abstract double calculatePrice();
	abstract void printItemAttributes();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
