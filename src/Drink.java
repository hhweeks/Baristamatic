import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Drink{
	private final HashMap<Ingredient, Integer> ingredientMap = new HashMap<>();
	public final DrinkType TYPE;
	public final double CENT_PRICE;

	public Drink(DrinkType type, LinkedList<Pair> plist) {
		TYPE = type;

		// add each ingredient and its required count to ingredientMap
		for (Pair pair : plist) {
			ingredientMap.put(pair.ingredient, pair.unitCount);
		}

		// add all other ingredients with count 0 to ingredientMap
		for (Ingredient ing : Ingredient.values()) {
			if (!ingredientMap.containsKey(ing)) {
				ingredientMap.put(ing, 0);
			}
		}

		CENT_PRICE = calculateCentPrice(TYPE);
	}

	private int calculateCentPrice(DrinkType drinkType) {
		int price = 0;

		for (Map.Entry<Ingredient, Integer> entry : ingredientMap.entrySet()) {
			Ingredient ingredient = entry.getKey();
			Integer quantity = entry.getValue();

			price += (ingredient.PRICE * quantity);
		}
		return price;
	}

	public int quantityRequired(Ingredient ing) {
		return ingredientMap.get(ing);
	}

	public String getDollarPriceString() {
		double dollarPrice = (double) CENT_PRICE / 100;
		String formattedDollarPrice = String.format("%.2f", dollarPrice);
		formattedDollarPrice = "$" + formattedDollarPrice;
		return formattedDollarPrice;
	}

	public void printMap() {
		for (Map.Entry<Ingredient, Integer> entry : ingredientMap.entrySet()) {
			Ingredient key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key=" + key + ", val=" + val + " , price per=" + key.PRICE);
		}
	}
}
