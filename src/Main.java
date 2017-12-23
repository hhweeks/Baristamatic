import java.util.Scanner;

public class Main {

	private final Barista barista;
	private final Scanner userInput;

	public Main() {
		barista = new Barista();
		userInput = new Scanner(System.in);

	}

	private void getUserInputLoop() {
		barista.displayInventoryMenu();
		
		while (userInput.hasNext()) {
			handleInput(userInput.nextLine());
			barista.displayInventoryMenu();
		}
	}

	private void handleInput(String inputString) {
		try{
			int inputInt = Integer.parseInt(inputString);

			Drink drink = barista.getDrinkAtIndex(inputInt);
			barista.dispenseDrink(drink);
		}
		//input is not a drink index
		catch(NumberFormatException formatE){
			switch (inputString.toLowerCase()) {
			case "r":
				barista.restock();
				break;
			case "q":
				System.exit(0);
				break;
			case "":
				//ignore blank input
				return;
			default:
				System.out.println("Invalid selection: " + inputString);
				break;
			}
		}
		//got drink index but out of bounds
		catch(IndexOutOfBoundsException boundsE){
			System.out.println("Invalid selection: " + inputString);
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.getUserInputLoop();
	}
}
