import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StockGenerator generator = new StockGenerator();
		int capacity = 2500;
		int numberStocks = 5000;
		List<Stock> stockChoices = generator.generateRandom(numberStocks);
		// Greedy
		System.out.println(greedyKnapsack(stockChoices, capacity));

		// Optimal
		double[][] arrayStocks = new double[stockChoices.size() + 1][capacity + 1];
		System.out.println("\n" +"Total earned optimal: " + optimalKnapsack(stockChoices, capacity, arrayStocks));
		List<List<Stock>> allCombinations = new ArrayList<>();
		findCombinations(stockChoices, stockChoices.size(), capacity, arrayStocks, new ArrayList<>(), allCombinations);
		System.out.println("Total feasible solutions: " + allCombinations.size());
		
		for (List<Stock> combination : allCombinations) {
		    double combinationSum = 0;
		    System.out.println(combination);
		    for (Stock stock : combination) {
		        combinationSum += stock.weight;
		    }
		    System.out.println("Combination value: " + Math.floor(combinationSum * 100) / 100);
		}

	}

	public static Double optimalKnapsack(List<Stock> stockChoices, int capacity, double[][] arrayStocks) {

		int sizeStocks = stockChoices.size();
		int i;
		int j;

		for (i = 0; i <= sizeStocks; i++) {
			for (j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {
					arrayStocks[i][j] = 0;
				} else {
					Stock stock = stockChoices.get(i - 1);
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

	public static void findCombinations(List<Stock> stocks, int n, int w, double[][] dp, List<Stock> current,
			List<List<Stock>> allCombinations) {
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

	public static List<Stock> greedyKnapsack(List<Stock> stockChoices, int capacity) {

		List<Stock> selected = new ArrayList<Stock>();

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

}
