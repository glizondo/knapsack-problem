import java.util.List;

public interface IKnapsack {
	
	public Double optimalKnapsack(List<Item> stockChoices, int capacity, double[][] arrayItems);
	
	public List<Item> greedyKnapsack(List<Item> stockChoices, int capacity);

}
