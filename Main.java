import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Order> allOrders = new ArrayList<>();
    private static CustomerManager customerManager = new CustomerManager();
    private static DriverManager DriverManager = new DriverManager();

    public static void main(String[] args){
    
        customerManager.importCustomers();

    
    boolean running = true; // keeps it CLI running until we exit in the switch cases


    while (running){
        System.out.println("\n====== Dennie's Prime Delivery ======");
        System.out.println("1. Customer Sign Up");
        System.out.println("2. Customer Log In");
        System.out.println("3. Driver Login");
        System.out.println("4. Create an Order");
        System.out.println("5. View Menu");
        System.out.println("6. Manager Menu");
        System.out.println("7. Exit");


        int choice = getIntInput();

        switch (choice){
            case 1: 
                customerSignup();
                break;

            case 2: 
                customerManager.customerLogin();
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
                ManagerManager.managerLogin(customerManager, DriverManager, allOrders);
                break;

            case 7:
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

    public static void customerSignup(){    // CUSTOMER LOGIN ============================== 
        System.out.println("\n --- Customer Signup ---");

        System.out.println("Enter your full name");
        String name = scanner.nextLine();

        System.out.println("Enter your phone number");
        String phone = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        Customer customer = customerManager.createCustomer(name, phone,email,password);

        System.out.println("Welcome, " + customer.getName() + "!");
    
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
    

