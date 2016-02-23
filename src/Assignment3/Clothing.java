package Assignment3;

public class Clothing extends Item 
{
	private double taxRate;
	private String state;
	
	Clothing(String nameC, double priceC, int quantityC, double weightC, String typeC, String stateC){
		super(nameC, priceC, quantityC, weightC, typeC);
		state = stateC;
	}
	double calculatePrice () 
	{	double finalPrice = 0;
		taxRate = .10;
		for (int i = 0;i < 5; i++){
			if (state.equals(noSalesTaxStates[i])) taxRate = 0;
		}
		finalPrice = price + price * taxRate;
		finalPrice += 20*weight * (double)quantity + price;
		return finalPrice;
	}
	
	void printItemAttributes () 
	{
		System.out.println("Name: " + name + " Total price: " + calculatePrice() + " Weight: " + weight + " Quantity: " + quantity + " Shipping state: " + state);
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
