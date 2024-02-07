import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack implements IKnapsack {

	@Override
	public Double optimalKnapsack(List<Item> stockChoices, int capacity, double[][] arrayStocks) {
		int sizeStocks = stockChoices.size();
		int i;
		int j;

		for (i = 0; i <= sizeStocks; i++) {
			for (j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {
					arrayStocks[i][j] = 0;
				} else {
					Item stock = stockChoices.get(i - 1);
					if (stock.weight <= j) {
						arrayStocks[i][j] = Math.max(stock.earning + arrayStocks[i - 1][(int) (j - stock.weight)],
								arrayStocks[i - 1][j]);
					} else {
						arrayStocks[i][j] = arrayStocks[i - 1][j];
					}
				}
			}
		}
		double returnValue = arrayStocks[sizeStocks][capacity];
		return Math.floor(returnValue * 100) / 100;
	}

	@Override
	public List<Item> greedyKnapsack(List<Item> stockChoices, int capacity) {
		List<Item> selected = new ArrayList<Item>();

		Collections.sort(stockChoices, new ItemComparator());
		Collections.reverse(stockChoices);

		int i = 0;
		double sum = 0;
		double earned = 0;

		while (i < stockChoices.size() && capacity > 0) {
			double weight = stockChoices.get(i).getWeight();
			if (weight <= capacity) {
				sum += weight;
				earned += stockChoices.get(i).getEarning();
				capacity -= weight;
				selected.add(stockChoices.get(i));
				i++;
			} else {
				break;
			}
		}

		System.out.println("\n" + "Total spent greedy: " + Math.floor(sum * 100) / 100);
		System.out.println("Total earned greedy: " + Math.floor(earned * 100) / 100 + "\n");

		return selected;
	}

	public void findCombinations(List<Item> stocks, int n, int w, double[][] dp, List<Item> current,
			List<List<Item>> allCombinations) {
		if (w == 0 || n == 0) {
			allCombinations.add(new ArrayList<>(current));
			return;
		}

		if (dp[n][w] == dp[n - 1][w]) {
			// Exclude the current stock and move to the next
			findCombinations(stocks, n - 1, w, dp, current, allCombinations);
		}

		if (stocks.get(n - 1).weight <= w
				&& dp[n][w] == dp[n - 1][(int) (w - stocks.get(n - 1).weight)] + stocks.get(n - 1).earning) {
			// Include the current stock and move to the next
			current.add(stocks.get(n - 1));
			findCombinations(stocks, n - 1, (int) (w - stocks.get(n - 1).weight), dp, current, allCombinations);
			current.remove(current.size() - 1); // Backtrack
		}
	}

}
