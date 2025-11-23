import java.util.ArrayList;

public class Order {
    private Customer customer;
    private Driver driver;
    private ArrayList<Item> cart;
    private int status;
    private int rating;

    public Order(Customer customer, Driver driver, ArrayList<Item> cart, int status, int rating){ //default toTxt constructor
        this.customer = customer;
        this.driver = driver;
        this.cart = cart;
        this.status = status;
        this.rating = rating;
    }

    public void assignDriver(){
        
    }

    public int total(){         //returns total price of order in cents
        int total = 0;
        for (Item item : cart){
            total += item.getPrice();
        }
        return total;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void addItem(Item item){
        cart.add(item);
    }

    public void setStatus(int status){
        this.status = status;
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
        return "Status unavailable";
    }
}
