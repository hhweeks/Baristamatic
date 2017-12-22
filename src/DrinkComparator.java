import java.util.Comparator;

public class DrinkComparator implements Comparator<Drink>{

	/**
	 * sort drink enums alpha instead of order they're defined
	 */
	@Override
	public int compare(Drink d1, Drink d2) {
		return d1.TYPE.toString().compareTo(d2.TYPE.toString());
	}
}
