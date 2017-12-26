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

		for (Ingredient ingredient : ingredientList) {
			int quantity = inventory.get(ingredient);

			System.out.println(ingredient + "," + quantity);
		}
	}

	private void printMenu() {
		System.out.println("Menu:");
		for (Drink drink : drinkList) {
			DrinkType drinkType = drink.TYPE;
			System.out.println(getIndexOfDrink(drink) + "," + drinkType + "," + drink.getDollarPriceString() + ","
					+ (inStock(drink)));
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

	public void restock() {
		for (Ingredient ingredient : Ingredient.values()) {
			inventory.put(ingredient, MAX_STOCK);
		}
	}

	private void decrementStock(Drink drink) {
		for (Ingredient ingredient : Ingredient.values()) {
			int qneeded = drink.quantityRequired(ingredient);
			int qsupply = inventory.get(ingredient);
			inventory.put(ingredient, (qsupply - qneeded));
		}
	}

	private void populateDrinkList() {
		for (DrinkType drinkType : DrinkType.values()) {
			drinkList.add(drinkType.getDrink());
		}

		Collections.sort(drinkList, new DrinkComparator());
	}

	public void displayInventoryMenu() {
		printInventory();
		printMenu();
	}

	/**
	 * return index as 1 to N (not 0 to N-1)
	 */
	public int getIndexOfDrink(Drink drink) {
		return drinkList.indexOf(drink) + 1;
	}

	/**
	 * return drink indexed 1 to N (not 0 to N-1)
	 */
	public Drink getDrinkAtIndex(int i) {
		return drinkList.get(i - 1);
	}

	public void dispenseDrink(Drink drink) {
		if (inStock(drink)) {
			decrementStock(drink);
			System.out.println("Dispensing: " + drink.TYPE.toString());
		} else {
			System.out.println("Out of stock: " + drink.TYPE.toString());
		}
	}
}
