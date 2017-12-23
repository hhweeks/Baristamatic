
public enum Ingredient {
	coffee(75) {
		@Override
		public String toString() {
			return "Coffee";
		}
	},
	decafCoffee(75) {
		@Override
		public String toString() {
			return "Decaf Coffee";
		}
	},
	sugar(25) {
		@Override
		public String toString() {
			return "Sugar";
		}
	},
	cream(25) {
		@Override
		public String toString() {
			return "Cream";
		}
	},
	steamedMilk(35) {
		@Override
		public String toString() {
			return "Steamed Milk";
		}
	},
	foamedMilk(35) {
		@Override
		public String toString() {
			return "Foamed Milk";
		}
	},
	espresso(110) {
		@Override
		public String toString() {
			return "Espresso";
		}
	},
	cocoa(90) {
		@Override
		public String toString() {
			return "Cocoa";
		}
	},
	whippedCream(100) {
		@Override
		public String toString() {
			return "Whipped Cream";
		}
	};

	final int PRICE;

	Ingredient(int p) {
		PRICE = p;
	}

	@Override
	public abstract String toString();
}
