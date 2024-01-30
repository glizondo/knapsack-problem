
public class Stock {

	private double price;
	private double probabilityIncreasePrice;
	private double possibleNewPrice;

	public Stock() {
		super();
		price = getRandomInitialPrice();
		probabilityIncreasePrice = getRandomProbIncreasePrice();
		possibleNewPrice = getRandomPossibleNewPrice();
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

	@Override
	public String toString() {
		return "\n" + this.price + " " + this.probabilityIncreasePrice + " " + this.possibleNewPrice;
	}

	private double getRandomInitialPrice() {
		return 1 + (Math.random() * 99);
	}

	private double getRandomProbIncreasePrice() {
		return 0 + (Math.random() * 1);
	}

	private double getRandomPossibleNewPrice() {
		return price + (probabilityIncreasePrice * price);
	}

}
