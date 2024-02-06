import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

	@Override
	public int compare(Item s1, Item s2) {
		return Double.compare(s1.getEarning(), s2.getEarning());

	}

}
