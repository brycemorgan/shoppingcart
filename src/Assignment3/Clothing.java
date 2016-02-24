package Assignment3;

public class Clothing extends Item
{
	private double taxRate;
	
	Clothing(String nameC, double priceC, int quantityC, int weightC, String typeC){
		super(nameC, priceC, quantityC, weightC, typeC);
	}
	double calculatePrice () 
	{	double finalPrice = 0;
		taxRate = .10;
		finalPrice = price + price * taxRate;
		finalPrice += 20*weight * (double)quantity + price * (double)quantity;
		return finalPrice;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
