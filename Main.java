import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Order> allOrders = new ArrayList<>();

    public static void main(String[] args){


    boolean running = true; // keeps it CLI running until we exit in the switch cases


    while (running){
        System.out.print("\n====== Dennie's Prime Delivery ======");
        System.out.println("1. Customer Login");
        System.out.println("2. Manager Login");
        System.out.println("3. Driver Login");
        System.out.println("4. Create an Order");
        System.out.println("5. View Menu");
        System.out.println("6. Exit");


        int choice = getIntInput();

        switch (choice){
            case 1: 
                customerLogin();
                break;

            case 2: 
                managerLogin();
                // STILL NEEDS WORK
                break;
            
            case 3: 
                driverLogin();
                // STILL NEEDS WORK
                break;
            
            case 4: 
                createOrder();
                break;

            case 5: 
                Menu.viewMenu();
                break;

            case 6:
                running = false;
                System.out.println("Thank-you for visiting");
                break;

            default:
                System.out.println("Invalid entry. Please try again.");
        }
    }





    }

    private static int getIntInput() { // SWTICH CASE INPUT =============================
        while (!scanner.hasNextInt()){
            System.out.println("Invalid input. Enter a number:");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static void customerLogin(){    // CUSTOMER LOGIN ============================== 
        System.out.println("\n --- Customer Login ---");

        System.out.print("Enter your full name");
        String name = scanner.nextLine();

        System.out.print("Enter your phone number");
        String phone = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        String password = "PW123";
        String customerID = "Customer" + (int)(Math.random() * 90 + 10); // creates a random number for each customer "represents their ID"

        Customer customer = new Customer(password, name, phone, email, customerID);

        System.out.println("Welcome, " + customer.getName() + "!");
        System.out.println("Your customer ID: " + customerID);
    }

    private static void createOrder(){  // CREATE ORDER ========================================
        
        System.out.println(" --- Create an Order --- ");

        Menu.viewMenu();

        Order order = new Order();
        boolean addingItems = true;

        System.out.println("What would you like ?");
        System.out.println("Enter 'Go away!' when you are finished");


        while(addingItems){
            System.out.print("Item: ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("go away!")){  // ENDS THE ORDER ========================
                addingItems = false;
            }else if (input.trim().isEmpty()){ // avoids white space so empty items aren't added to the list like " ". 
                System.out.println("Please enter a valid item name");
            }else{
                Item newItem = new Item(input, 1000);
                order.addItem(newItem);
                System.out.println(input + " added to order");
            }
        }
    }

    private static void managerLogin(){
            System.out.println(" --- Manager Login --- ");

            System.out.println("Please Enter Manager's Name");
            String name = scanner.nextLine();

            String managerID = "MGR" + (int)(Math.random() * 90 + 10); // creates random manager ID

            System.out.println("Manger " + name + " logged in. ");
            System.out.println("Manager ID: " + managerID);
        }

    private static void driverLogin(){
        System.out.println(" --- Driver Login --- ");

        System.out.print("Enter driver name");
        String name = scanner.nextLine();

        String driverID = "Driver" + (int)(Math.random() * 90 + 10);

        System.out.println("Driver " + name + "logged in.");
        System.out.println("Driver ID: " + driverID);
    }

    

}
    

