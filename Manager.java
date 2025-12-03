public class Manager extends Person {
    private String managerId;
    private String name;
    private boolean isManager;

    public Manager(String password, String name, String phoneNumber, String email, String id, String managerId){
        super(password,name,phoneNumber,email,id);
        this.managerId = managerId;
        this.name = name;
        this.isManager = true;
    }

    public boolean isManager(){
        return isManager;
    }

    //order
    public void viewOrder(Order order){
        System.out.println("Order for: " +order.getCustomer().getName());
        System.out.println("Status: " +order.getStatus());
        System.out.println("Total: $" +(order.total()/100.0));
    }

    public void changeOrder(Order order,int newStatus){
        order.setStatus(newStatus);
    }

    public void cancelOrder(Order order){
        order.setStatus(-1);
    }

    /*public void refundOrder(Order order){
        System.out.println("Refund issued for order : "+order.getCustomer().getName());
    }*/

    public void viewCustomer(Customer customer) {
        System.out.println("Customer Name: "+customer.getName());
        System.out.println("Address: "+customer.getAddress());
        System.out.println("Email: "+customer.getEmail());
    }

    public void updateCustomerAddress(Customer customer,String newAddress){
        customer.setAddress(newAddress);
    }

    public void updateCustomerCard(Customer customer,String newCard){
        customer.setCardNum(newCard);
    }

    public String viewPaymentDetails(Customer customer){
        return customer.getCardNum();
    }

    public void viewDriver(Driver driver){
        System.out.println("Driver Name: " + driver.getName());
        System.out.println("Car Model: " + driver.getCarModel());
        System.out.println("Odometer: " + driver.getOdometer());
    }

    public double viewDriverRating(Driver driver){
        return driver.getRaiting();
    }

    /*public void fireDriver(Driver driver) {
        System.out.println("Driver " + driver.getName() + " has been removed from the system.");
       
    }*/

    public void runBackgroundCheck(Driver driver){
        System.out.println("Background check" + driver.getName());
    }

    public void assignDriverToOrder(Order order, Driver driver){
        order.assignDriver();
        System.out.println("Driver " + driver.getName() + " assigned to order for " + order.getCustomer().getName());
    }

    public int viewOrderTotal(Order order){
        return order.total();
    }

    public void addItemToOrder(Order order, Item item) {
        order.addItem(item)
    }
}
