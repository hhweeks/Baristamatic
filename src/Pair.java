
public class Pair {
	public final Ingredient ingredient;
	public final int unitCount;

	/**
	 * A pair that represents an ingredient and a quantity. Represents
	 * quantities needed for DrinkType
	 */
	public Pair(Ingredient ing, int count) {
		ingredient = ing;
		unitCount = count;
	}
}
