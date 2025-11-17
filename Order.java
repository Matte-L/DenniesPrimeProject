public class Order {
    private Customer customer;
    private Driver driver;
    private ArrayList<Item> cart;
    private int status;
    private int rating;


    public void assignDriver(){
        
    }

    public Customer getCustomer(){
        return Customer;
    }

    public void addItem(Item){
    }

    public String getStatus(){
        if (status == 0){
            return "In Cart";
        }
        if (status == 1){
            return "In delivery";
        }
        if (status == 2){
            return "Delivered";
        }
        if (status == -1){
            return "Cancelled";
        }
    }
}
