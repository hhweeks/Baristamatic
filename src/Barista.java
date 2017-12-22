import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Barista {
	private final HashMap<Ingredient, Integer> inventory;
	private final ArrayList<Drink> drinkList;
	private final int MAX_STOCK = 10;

	public Barista() {
		drinkList = new ArrayList<>();
		inventory = new HashMap<>();
		restock();
		populateDrinkList();
	}

	private void printInventory() {
		System.out.println("Inventory:");

		ArrayList<Ingredient> ingredientList = new ArrayList<>(Arrays.asList(Ingredient.values()));
		Collections.sort(ingredientList, new IngredientComparator());
		IngredientComparator ic = new IngredientComparator();

		for (Ingredient ingredient : ingredientList) {
			int quantity = inventory.get(ingredient);

			System.out.println(ingredient + "," + quantity);
		}
	}

	// TODO fix index off by 1 (1-6, not 0-5)
	private void printMenu() {
		System.out.println("Menu:");
		for (int i = 0; i < drinkList.size(); i++) {
			Drink drink = drinkList.get(i);
			DrinkType drinkType = drink.TYPE;

			System.out.println(i + "," + drinkType + "," + drink.getDollarPriceString() + "," + (inStock(drink)));
		}
	}

	private boolean inStock(Drink drink) {
		for (Ingredient ingredient : Ingredient.values()) {
			int qneeded = drink.quantityRequired(ingredient);
			int qsupply = inventory.get(ingredient);
			if (qneeded > qsupply) {
				return false;
			}
		}
		return true;
	}

	private void restock() {
		for (Ingredient ingredient : Ingredient.values()) {
			inventory.put(ingredient, MAX_STOCK);
		}
	}

	private void populateDrinkList() {
		for (DrinkType drinkType : DrinkType.values()) {
			drinkList.add(drinkType.getDrink());
		}

		Collections.sort(drinkList, new DrinkComparator());
	}

	public static void main(String[] args) {
		Barista bar = new Barista();
		bar.printInventory();
		bar.printMenu();
	}
}
