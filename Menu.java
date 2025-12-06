import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	private HashMap<String, Integer> menuItems = new HashMap<>();

	Scanner input = new Scanner(System.in);
	int counter = 0;

	public void addMenuItem(){
		String itemName = input.next();
		Integer itemPrice = input.nextInt();
		menuItems.put(itemName, itemPrice);
	}

	public String priceFormat(String name){
		if (menuItems.get(name)%100 == 0){
			return "$"+menuItems.get(name)/100+".00";
		}
		return "$"+menuItems.get(name)/100 + "."+menuItems.get(name)%100;
	}
	public void viewMenu() {						// ========================== ADDED A FILE READING METHOD FOR THE MENU ================================
		int counter = 1;
		for (String name : menuItems.keySet()){
			System.out.println(counter + ". "+name+": "+ priceFormat(name));
			counter++;
		}
	}
	public int getPrice(String name){
		return menuItems.getOrDefault(name,-1);
	}
	public HashMap<String, Integer> getMenuItems(){
		return menuItems;
	}
    public Menu(){
        menuItems = new HashMap<>();
        char c;
        String name = "";
        String price = "";
        boolean flip = false;
        try(BufferedReader reader = new BufferedReader(new FileReader("menu.txt"))){
            while(reader.ready()){
                c = (char)reader.read();
                switch (c){
                    case ':':
                        flip = true;
                        break;
                    case '\n':
                        menuItems.put(name,Integer.parseInt(price.trim()));
                        name = "";
                        price = "";
                        flip = false;
                        break;
                    default:
                        if (flip==false){
                            name +=c;
                        } else{
                            price+=c;
                        }
						break;
                }
                
            }
        }catch(IOException e){
            System.out.println("!! === Error loading menu === !!");
        }
    }
}

