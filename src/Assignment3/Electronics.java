package Assignment3;

public class Electronics extends Item 
{
	private String state;
	private double taxRate;
	private boolean fragile;

	Electronics(String nameE, double priceE, int quantityE, double weightE, char typeE, String stateE, boolean fragileE){
		super(nameE, priceE, quantityE, weightE, typeE);
		state = stateE;
		fragile = fragileE;
	}
	double calculatePrice(){
		double finalPrice = 0;
		taxRate = .10;
		for (int i = 0;i < 5; i++){
			if (state.equals(noSalesTaxStates[i])) taxRate = 0;
		}
		finalPrice = price + price * taxRate;
		if(fragile) finalPrice += 20.0 * weight * (double) quantity * 1.2;
		else finalPrice += 20.0 * weight * (double) quantity;
		return finalPrice;
	}
	void printItemAttributes(){
		System.out.print("Name: " + name + " Total price: " + calculatePrice() + " Weight: " + weight + " Quantity: " + quantity + " Shipping state: " + state + " Fragile? ");
		if(fragile) System.out.print("Y");
		else System.out.print("N");
	}
	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
