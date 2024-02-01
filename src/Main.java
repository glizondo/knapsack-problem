import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StockGenerator generator = new StockGenerator();
		List<Stock> stockChoices = generator.generateRandom(100);
		//System.out.println((list));
		System.out.println(greedyKnapsack(stockChoices, 2500));
		

	}
	
	public static List<Stock> greedyKnapsack(List<Stock> stockChoices, int capacity) {
		
		List<Stock> selected = new ArrayList<Stock>();
        
        Collections.sort(stockChoices, new Comparator<Stock>() {
        	@Override
            public int compare(Stock s1, Stock s2) {
        		return Double.compare(s1.getPossibleEarningAmnt(), s2.getPossibleEarningAmnt());
            }
        });
        
        Collections.reverse(stockChoices);

        int i = 0;
        double sum = 0; 
        
        while (i < stockChoices.size() && capacity > 0) {
        	double weight = stockChoices.get(i).getPrice();
            if (weight <= capacity) {
            	sum += weight;
                capacity -= weight;
                selected.add(stockChoices.get(i));
                i++;
            } else {
                break;
            }
        }
        
        System.out.println("Total spent: " +  Math.floor(sum * 100) / 100 + "\n");
        
        return selected;
    }

}
