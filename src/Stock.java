
public class Stock {

	private double price;
	private double probabilityIncreasePrice;
	private double possibleNewPrice;

	public Stock(double price, double probabilityIncreasePrice, double possibleNewPrice) {
		super();
		this.price = price;
		this.probabilityIncreasePrice = probabilityIncreasePrice;
		this.possibleNewPrice = possibleNewPrice;
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

}
