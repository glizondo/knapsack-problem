
//I don't think your generateRandomPossibleNewPrice function is accurate to what the assignment wants. Please take another look and let me know.
//For now, I've altered this class to what I think was required.
public class Stock {

	private double price;
	private double probabilityIncreasePrice;
	private double possibleNewPrice;
	private double possibleEarningAmnt;

	public Stock() {
		super();
		price = generateRandomInitialPrice();
		probabilityIncreasePrice = generateRandomProbIncreasePrice();
		possibleNewPrice = generateRandomPossibleNewPrice();
		possibleEarningAmnt =  generatePossibleEarningAmnt(possibleNewPrice, price, probabilityIncreasePrice);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getProbabilityIncreasePrice() {
		return probabilityIncreasePrice;
	}

	public void setProbabilityIncreasePrice(double probabilityIncreasePrice) {
		this.probabilityIncreasePrice = probabilityIncreasePrice;
	}

	public double getPossibleNewPrice() {
		return possibleNewPrice;
	}

	public void setPossibleNewPrice(double possibleNewPrice) {
		this.possibleNewPrice = possibleNewPrice;
	}

	public double getPossibleEarningAmnt() {
		return possibleEarningAmnt;
	}

	public void setPossibleEarningAmnt(double possibleEarningAmnt) {
		this.possibleEarningAmnt = possibleEarningAmnt;
	}

	@Override
	public String toString() {
		return "\n" + this.price + " " + this.probabilityIncreasePrice + " " + this.possibleNewPrice + " " + this.possibleEarningAmnt;
	}

	private double generateRandomInitialPrice() {
		double value = 1 + (Math.random() * 99);
		return Math.floor(value * 100) / 100;
	}

	private double generateRandomProbIncreasePrice() {
		double value = 0 + (Math.random() * 1);
		return Math.floor(value * 100) / 100;
	}
	
	private double generateRandomPossibleNewPrice() {
		double value = 1 + (Math.random() * 199);
		return Math.floor(value * 100) / 100;
	}
	
	private double generatePossibleEarningAmnt(double possibleNewPrice, double price, double probabilityIncreasePrice) {
		double value = (possibleNewPrice - price) * probabilityIncreasePrice;
		return Math.floor(value * 100) / 100;
	}
	
	/*
	private double generateRandomPossibleNewPrice() {
		return price + (probabilityIncreasePrice * price);
	}
	*/

}
