import java.util.Scanner;
import java.util.HashMap;

public class Menu {
	HashMap<String, Double> menuItems = new HashMap<>();/* I made an item class if you just wanted to just store a list of items here
	private ArrayList<Item> itemList;

	public void printMenu(){
		for (Item item : itemList){
			item.print();
		}
	}	  

	public void addMenuItem(){
		itemList.add(new Item(input.next(), input.nextint()))
	}
	 */
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

