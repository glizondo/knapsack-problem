import java.util.ArrayList;
import java.util.List;

public class StockGenerator implements IGenerator {

	List<Stock> listStocks;
	int size;

	public StockGenerator() {
		super();
		listStocks = generateRandom(size);
	}

	@Override
	public List<Stock> generateRandom(int size) {
		listStocks = new ArrayList<Stock>();
		for (int i = 1; i <= size; i++) {
			Stock stock = new Stock();
			listStocks.add(stock);
		}
		return listStocks;
	}

}
