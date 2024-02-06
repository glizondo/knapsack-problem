
public class Stock extends Item {

	public Stock() {
		weight = generateRandomInitialPrice();
		probabilityIncreaseValue = generateRandomProbIncreasePrice();
		possibleNewValue = generateRandomPossibleNewPrice();
		earning = generatePossibleEarningAmnt(possibleNewValue, weight, probabilityIncreaseValue);
	}

	@Override
	public String toString() {
		return "\n" + this.weight + " " + super.probabilityIncreaseValue + " " + this.possibleNewValue + " "
				+ this.earning;
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

}
