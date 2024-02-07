import java.util.ArrayList;
import java.util.List;

public class StockGenerator implements IGenerator {

	List<Item> listStocks;
	int size;

	public StockGenerator() {
		super();
		listStocks = generateRandom(size);
	}

	@Override
	public List<Item> generateRandom(int size) {
		listStocks = new ArrayList<Item>();
		for (int i = 1; i <= size; i++) {
			Stock stock = new Stock();
			listStocks.add(stock);
		}
		return listStocks;
	}

}
