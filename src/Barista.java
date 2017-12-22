import java.util.ArrayList;

public class Barista {
	//Data Structures for drinks, ingredients
	//drinks should be array-like (index accessed)
	//indgredients can be same
	
	private final ArrayList<DrinkType> drinkList;//should these be final?
	private final ArrayList<Ingredient> ingredientList;
	
	public Barista(){
		drinkList=new ArrayList<>();
		ingredientList=new ArrayList<>();
	}
	
	public static void main(String[] args){
		Drink coffee=DrinkType.coffee.getDrink();
		coffee.printMap();
	}
}
