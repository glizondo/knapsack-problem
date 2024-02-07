import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StockGenerator generator = new StockGenerator();
		int capacity = 2500;
		int numberStocks = 5000;
		List<Item> stockChoices = generator.generateRandom(numberStocks);
		Knapsack kn = new Knapsack();
		
		// Greedy
		long greedyBegin = System.currentTimeMillis();
		System.out.println(kn.greedyKnapsack(stockChoices, capacity));
		long greedyEnd = System.currentTimeMillis();
		long greedyTime = greedyEnd - greedyBegin;
		System.out.println("Greedy time: " + greedyTime);

		// Optimal
		long optimalBegin = System.currentTimeMillis();
		double[][] arrayStocks = new double[stockChoices.size() + 1][capacity + 1];
		System.out.println("\n" +"Total earned optimal: " + kn.optimalKnapsack(stockChoices, capacity, arrayStocks));
		List<List<Item>> allCombinations = new ArrayList<>();
		kn.findCombinations(stockChoices, stockChoices.size(), capacity, arrayStocks, new ArrayList<>(), allCombinations);
		System.out.println("Total feasible solutions: " + allCombinations.size());
		
		for (List<Item> combination : allCombinations) {
		    double combinationSum = 0;
		    System.out.println(combination);
		    for (Item stock : combination) {
		        combinationSum += stock.weight;
		    }
		    System.out.println("Combination value: " + Math.floor(combinationSum * 100) / 100);
		}
		long optimalEnd = System.currentTimeMillis();
		long optimalTime = optimalEnd - optimalBegin;
		System.out.println("Optimal time: " + optimalTime);
	}


}
