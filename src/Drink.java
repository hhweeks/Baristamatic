import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Drink {
	public final Ingredient coffee = Ingredient.coffee;

	private final HashMap<Ingredient, Integer> ingredientMap = new HashMap<>();
	private final DrinkType TYPE;

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
	}

	public void printMap() {

		for (Map.Entry<Ingredient, Integer> entry : ingredientMap.entrySet()) {
			Ingredient key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key=" + key + ", val=" + val + " , price per=" + key.PRICE);
		}
	}
}
