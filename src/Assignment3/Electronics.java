package Assignment3;

public class Electronics extends Item 
{
	private String state;
	private double taxRate;
	private boolean fragile;

	Electronics(String nameE, double priceE, int quantityE, int weightE, String typeE, String stateE, boolean fragileE){
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
		finalPrice = price*(double)quantity*(1+ taxRate);
		if(fragile) finalPrice += 20.0 * weight * (double) quantity * 1.2;
		else finalPrice += 20.0 * weight * (double) quantity;
		return finalPrice;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public boolean isFragile() {
		return fragile;
	}
	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}
	

}
