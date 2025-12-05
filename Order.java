import java.util.HashMap;

public class Order {
    private Customer customer;
    private Driver driver;
    private HashMap<String,Integer> cart;
    private int status;
    private int rating;

    public Order(){}

    public Order(Customer customer, Driver driver, HashMap<String,Integer> cart, int status, int rating){ //default toTxt constructor
        this.customer = customer;
        this.driver = driver;
        this.cart = cart;
        this.status = status;
        this.rating = rating;
    }

    public void assignDriver(){
        
    }

    public String total(){         //returns total price of order formatted
        int total = 0;
        for (String itemName : cart.keySet()){
            total += Main.menu.getPrice(itemName)*cart.get(itemName);
        }
        if (total%100==0){
            return "$"+total/100+".00";
        }
        return "$"+total/100+"."+total%100;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void addItem(String itemName){
        cart.putIfAbsent(itemName,1);
        cart.put(itemName,cart.get(itemName)+1);
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
