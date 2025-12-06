import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
    public static CustomerManager customerManager = new CustomerManager();
    public static DriverManager driverManager = new DriverManager();
    public static Menu menu = new Menu();
    public static ArrayList<Order> allOrders = Order.importOrders();

    public static void main(String[] args){
        
        customerManager.importCustomers();
        driverManager.importDrivers();
        Person activeUser;
    
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
                activeUser = customerManager.customerSignup();
                createOrder(activeUser);
                break;

            case 2: 
                activeUser = customerManager.customerLogin();
                createOrder(activeUser);
                break;
            
            case 3: 
                driverManager.driverLogin();
                // STILL NEEDS WORK
                break;
            
            case 4: 
                createOrder(null);
                break;

            case 5: 
                menu.viewMenu();
                break;
            
            case 6: 
                ManagerManager.managerLogin(customerManager, driverManager, allOrders);
                break;

            case 7:
                customerManager.saveCustomerToFile(); // ADDS LIST OF CUSTOMERS UPON EXITING TO TXT DOC
                driverManager.saveDriverToFile();
                //Order.exportOrders();
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
        scanner.reset();
        return val;
    }



    private static Order createOrder(Person c){  // CREATE ORDER ========================================
        Customer cust = (Customer)c;
        System.out.println(" --- Create an Order --- ");

        Main.menu.viewMenu();
        cust.setOrder(new Order(c));
        boolean addingItems = true;

        System.out.println("What item number would you like?");
        System.out.println("Enter '0' when you are finished");


        while(addingItems){
            System.out.print("Item number: ");
            int input = Main.getIntInput();

            if (input==0){
                System.out.println("Thank-you!");
                addingItems = false;
                cust.getOrder().cartPrint();
                break;
            } else if (input>0&&input<=Main.menu.getMenuItems().size()){
                    cust.getOrder().addItem(Main.menu.getMenuItems().keySet().toArray(new String[0])[input-1]);
                    System.out.println(Main.menu.getMenuItems().keySet().toArray()[input-1]+" added to order");
            } else{
                System.out.println("Invalid Number");
            }
            System.out.println("Your total is: "+ cust.getOrder().total());
            Main.menu.viewMenu();
            System.out.println("Enter '0' to complete order.");
        }
        allOrders.add(cust.getOrder());
        cust.getOrder().assignDriver();
        return cust.getOrder();
    }




    


    



    

}
    

