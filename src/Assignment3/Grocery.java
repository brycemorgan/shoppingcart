package Assignment3;

public class Grocery extends Item {
	boolean perishable;
	Grocery(String nameG, double priceG, int quantityG, int weightG, String typeG, boolean perishableG){
		super(nameG, priceG, quantityG, weightG, typeG);
		perishable = perishableG;
	}
	double calculatePrice(){
		double finalPrice = price;
		if (perishable) finalPrice += 20.0 * weight * (double) quantity * 1.2;
		else finalPrice += 20.0 * weight * (double) quantity;
		return finalPrice;
	}
	void printItemAttributes(){
		System.out.print("Name: " + name + " Total price: " + calculatePrice() + " Weight: " + weight + " Quantity: " + quantity + " Perishable? ");
		if(perishable) System.out.print("Y");
		else System.out.print("N");
	}
	public boolean isPerishable() {
		return perishable;
	}
	public void setPerishable(boolean perishable) {
		this.perishable = perishable;
	}
	
}
