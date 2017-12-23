import java.util.Comparator;

public class DrinkComparator implements Comparator<Drink> {

	/**
	 * sort DrinkType enum alpha instead of order defined
	 */
	@Override
	public int compare(Drink d1, Drink d2) {
		return d1.TYPE.toString().compareTo(d2.TYPE.toString());
	}
}
