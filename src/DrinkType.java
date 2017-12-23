import java.util.Arrays;
import java.util.LinkedList;

public enum DrinkType {
	coffee {

		@Override
		public Drink getDrink() {
			Pair pairCoffee = new Pair(Ingredient.coffee, 3);
			Pair pairSugar = new Pair(Ingredient.sugar, 1);
			Pair pairCream = new Pair(Ingredient.cream, 1);

			LinkedList<Pair> coffeeList = new LinkedList<>(Arrays.asList(pairCoffee, pairSugar, pairCream));
			return new Drink(DrinkType.coffee, coffeeList);
		}

		@Override
		public String toString() {
			return "Coffee";
		}
	},
	decafCoffee {

		@Override
		public Drink getDrink() {
			Pair pairDecaf = new Pair(Ingredient.decafCoffee, 3);
			Pair pairSugar = new Pair(Ingredient.sugar, 1);
			Pair pairCream = new Pair(Ingredient.cream, 1);

			LinkedList<Pair> decafList = new LinkedList<>(Arrays.asList(pairDecaf, pairSugar, pairCream));
			return new Drink(DrinkType.decafCoffee, decafList);

		}

		@Override
		public String toString() {
			return "Decaf Coffee";
		}

	},
	caffeLatte {

		@Override
		public Drink getDrink() {
			Pair pairEspresso = new Pair(Ingredient.espresso, 2);
			Pair pairSteamedMilk = new Pair(Ingredient.steamedMilk, 1);

			LinkedList<Pair> latteList = new LinkedList<>(Arrays.asList(pairEspresso, pairSteamedMilk));
			return new Drink(DrinkType.caffeLatte, latteList);
		}

		@Override
		public String toString() {
			return "Caffe Latte";
		}

	},
	caffeAmericano {

		@Override
		public Drink getDrink() {
			Pair pairEspresso = new Pair(Ingredient.espresso, 3);

			LinkedList<Pair> americanoList = new LinkedList<>(Arrays.asList(pairEspresso));
			return new Drink(DrinkType.caffeAmericano, americanoList);
		}

		@Override
		public String toString() {
			return "Caffe Americano";
		}

	},
	caffeMocha {

		@Override
		public Drink getDrink() {
			Pair pairEspresso = new Pair(Ingredient.espresso, 1);
			Pair pairCocoa = new Pair(Ingredient.cocoa, 1);
			Pair pairSteamedMilk = new Pair(Ingredient.steamedMilk, 1);
			Pair pairWhippedCream = new Pair(Ingredient.whippedCream, 1);

			LinkedList<Pair> mochaList = new LinkedList<>(
					Arrays.asList(pairEspresso, pairCocoa, pairSteamedMilk, pairWhippedCream));
			return new Drink(DrinkType.caffeMocha, mochaList);
		}

		@Override
		public String toString() {
			return "Caffe Mocha";
		}

	},
	cappuccino {

		@Override
		public Drink getDrink() {
			Pair pairEspresso = new Pair(Ingredient.espresso, 2);
			Pair pairSteamedMilk = new Pair(Ingredient.steamedMilk, 1);
			Pair pairFoamedMilk = new Pair(Ingredient.foamedMilk, 1);

			LinkedList<Pair> cappuccinoList = new LinkedList<>(
					Arrays.asList(pairEspresso, pairSteamedMilk, pairFoamedMilk));
			return new Drink(DrinkType.cappuccino, cappuccinoList);
		}

		@Override
		public String toString() {
			return "Cappuccino";
		}
	};

	public abstract Drink getDrink();

	@Override
	public abstract String toString();
}
