import java.util.Scanner;
import java.util.HashMap;

public class Menu {
	HashMap<String, Double> menuItems = new HashMap<>();
	Scanner input = new Scanner(System.in);
	int counter = 0;

	public void addMenuItem(){
		String itemName = input.next();
		Double itemPrice = input.nextDouble();
		menuItems.put(itemName, itemPrice);
	}

	public String printMenu(){
		for(int i =0; i<menuItems.size(); i++){
			counter = counter +1;
			System.out.println(counter + ". " + menuItems.get(counter));
		}

	return "";
	}
}

