import java.util.List;

public class Main {

	public static void main(String[] args) {
		StockGenerator generator = new StockGenerator();
		List<Stock> list = generator.generateRandom(100);
		System.out.println((list));

	}

}
