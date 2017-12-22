
public enum Ingredient {
	coffee(.75),
	decafCoffee(.75),
	sugar(.25),
	cream(.25),
	steamedMilk(.35),
	foamedMilk(.35),
	espresso(1.10),
	cocoa(.9),
	whippedCream(1.00)
	;
	final double PRICE;
	
	Ingredient(double p){
		PRICE=p;
	}
}
