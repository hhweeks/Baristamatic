import java.util.Comparator;

public class IngredientComparator implements Comparator<Ingredient> {

	@Override
	public int compare(Ingredient i1, Ingredient i2) {
		return i1.toString().compareTo(i2.toString());
	}

}
