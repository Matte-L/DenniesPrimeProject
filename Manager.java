public class Manager extends Person {
    private String managerId;
    private boolean isManager;

    public Manager(String password, String name, String phoneNumber, String email, String managerId){
        super(password, name, phoneNumber, email);
        this.managerId = managerId;
        this.isManager = true;
    }

    public boolean isManager(){
        return isManager;
    }

    // View an order
    public void viewOrder(Order order){
        System.out.println("Order for: " + (order.getCustomer() != null ? order.getCustomer().getName() : "Unknown"));
        System.out.println("Status: " + order.getStatus());
        System.out.println("Total: $" + (order.total() / 100.0));
    }

    // Cancel an order
    public void cancelOrder(Order order){
        order.setStatus(-1);
        System.out.println("Order canceled.");
    }

    // View customer details
    public void viewCustomer(Customer customer){
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Email: " + customer.getEmail());
    }

    // Update customer address
    public void updateCustomerAddress(Customer customer, String newAddress){
        customer.setAddress(newAddress);
        System.out.println("Address updated.");
    }
    // View driver info
    public void viewDriver(Driver driver){
        System.out.println("Driver Name: " + driver.getName());
        System.out.println("Car Model: " + driver.getCarModel());
        System.out.println("Odometer: " + driver.getOdometer());
        System.out.println("Rating: " + driver.getRaiting());
    }

    // Assign driver to order
    public void assignDriverToOrder(Order order, Driver driver){
        order.assignDriver();
        System.out.println("Driver " + driver.getName() + " assigned to order.");
    }

    // Change order status
    public void changeOrderStatus(Order order, int status){
        order.setStatus(status);
        System.out.println("Order status updated.");
    }
}
