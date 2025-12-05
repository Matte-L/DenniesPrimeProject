import java.util.ArrayList;
import java.util.Scanner;

public class ManagerManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void managerLogin(CustomerManager customerManager, DriverManager driverManager, ArrayList<Order> allOrders) {
        System.out.println(" --- Manager Login --- ");
        System.out.println("Enter Manager Name:");
        String name = scanner.nextLine();

        String managerID = "MGR" + (int)(Math.random() * 1000);
        String email = "manager@example.com";  // default
        String password = "manager123";        // default

        Manager manager = new Manager(password, name, "000-000-0000", email, managerID);

        System.out.println("Manager " + name + " logged in.");
        System.out.println("Manager ID: " + managerID);

        // Open Manager Menu
        managerMenu(manager, customerManager, driverManager, allOrders);
    }

    public static void managerMenu(Manager manager, CustomerManager customerManager, DriverManager driverManager, ArrayList<Order> allOrders) {
        boolean active = true;

        while (active) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. View all orders");
            System.out.println("2. View a customer");
            System.out.println("3. View a driver");
            System.out.println("4. Cancel an order");
            System.out.println("5. Assign Driver to Order");
            System.out.println("6. Exit Manager Menu");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    if (allOrders.isEmpty()) {
                        System.out.println("No orders exist.");
                    } else {
                        for (int i = 0; i < allOrders.size(); i++) {
                            System.out.println("\nOrder #" + (i + 1));
                            manager.viewOrder(allOrders.get(i));
                        }
                    }
                    break;

                /*case 2:
                    System.out.println("Enter customer email:");
                    Customer customer = customerManager.findCustomer(scanner.nextLine());
                    if (customer != null) manager.viewCustomer(customer);
                    else System.out.println("Customer not found.");
                    break;

                case 3:
                    System.out.println("Enter driver name:");
                    Driver driver = driverManager.findDriver(scanner.nextLine());
                    if (driver != null) manager.viewDriver(driver);
                    else System.out.println("Driver not found.");
                    break;*/

                case 4:
                    if (allOrders.isEmpty()) {
                        System.out.println("No orders to cancel.");
                        break;
                    }
                    System.out.println("Enter order number to cancel:");
                    int num = getIntInput();
                    if (num < 1 || num > allOrders.size()) {
                        System.out.println("Invalid order number.");
                    } else {
                        manager.cancelOrder(allOrders.get(num - 1));
                        System.out.println("Order canceled.");
                    }
                    break;

                /*case 5:
                    System.out.println("Enter driver name:");
                    Driver d = driverManager.findDriver(scanner.nextLine());
                    if (d == null) {
                        System.out.println("Driver not found.");
                        break;
                    }
                    if (allOrders.isEmpty()) {
                        System.out.println("No orders exist.");
                        break;
                    }
                    System.out.println("Select order number:");
                    int orderNum = getIntInput();
                    if (orderNum < 1 || orderNum > allOrders.size()) {
                        System.out.println("Invalid order.");
                    } else {
                        manager.assignDriverToOrder(allOrders.get(orderNum - 1), d);
                        System.out.println("Driver assigned.");
                    }
                    break;*/

                case 6:
                    active = false;
                    break;

                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a number:");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }
}
