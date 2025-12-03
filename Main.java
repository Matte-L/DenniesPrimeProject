import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Order> allOrders = new ArrayList<>();
    private static CustomerManager customerManager = new CustomerManager();
    private static DriverManager DriverManager = new DriverManager();

    public static void main(String[] args){


    boolean running = true; // keeps it CLI running until we exit in the switch cases


    while (running){
        System.out.println("\n====== Dennie's Prime Delivery ======");
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
                customerManager.saveCustomerToFile(); // ADDS LIST OF CUSTOMERS UPON EXITING TO TXT DOC
                DriverManager.saveDriverToFile(); 
                running = false;
                System.out.println("Thank-you for visiting");
                break;

            default:
                System.out.println("Invalid entry. Please try again.");
        }
    }





    }

    private static int getIntInput() { // SWTICH CASE INPUT =============================
        while (!scanner.hasNextInt()){ // VERIFIES INTEGER INPUT
            System.out.println("Invalid input. Enter a number:");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    public static void customerLogin(){    // CUSTOMER LOGIN ============================== 
        System.out.println("\n --- Customer Login ---");

        System.out.println("Enter your full name");
        String name = scanner.nextLine();

        System.out.println("Enter your phone number");
        String phone = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        Customer customer = customerManager.createCustomer(name, phone, email);

        System.out.println("Welcome, " + customer.getName() + "!");
        System.out.println("Your customer ID: " + customer.getId());
    }

    private static void createOrder(){  // CREATE ORDER ========================================
        
        System.out.println(" --- Create an Order --- ");

        Menu.viewMenu();

        Order order = new Order();
        boolean addingItems = true;

        System.out.println("What would you like ?");
        System.out.println("Enter 'go away' when you are finished");


        while(addingItems){
            System.out.print("Item: ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("go away")){  // ENDS THE ORDER ========================
                System.out.println("Thank-you!");
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

    private static void managerLogin(){     // MANAGER LOGIN METHOD
            System.out.println(" --- Manager Login --- ");

            System.out.println("Please Enter Manager's Name");
            String name = scanner.nextLine();

            String managerID = "MGR" + (int)(Math.random() * 10); // creates random manager ID

            System.out.println("Manger " + name + " logged in. ");
            System.out.println("Manager ID: " + managerID);
        }

    private static void driverLogin(){      // DRIVER LOGIN METHOD
        System.out.println(" --- Driver Login --- ");

        System.out.println("Enter driver name");
        String name = scanner.nextLine();

        System.out.println("Enter your car model");
        String carModel = scanner.nextLine();

        System.out.println("Enter your phone number");
        String phoneNumber = scanner.nextLine();        

        System.out.println("Enter your current odometer");
        double odometer = scanner.nextDouble();

        System.out.println("Enter your email");
        String email = scanner.nextLine();
        String password = "DriverPassword"; 


        String driverID = "Driver" + (int)(Math.random() * 10);
        double raiting = (int)(Math.random());
        Driver newDriver = DriverManager.createDriver(password, name, phoneNumber, email, driverID, carModel, odometer, raiting);

        System.out.println("Driver " + name + "logged in.");
        System.out.println("Driver ID: " + driverID);
    }

    



    

}
    

