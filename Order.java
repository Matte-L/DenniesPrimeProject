import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Order {
    private Customer customer;
    private Driver driver;
    private HashMap<String,Integer> cart;
    private int status;
    private int rating;

    public Order(){
        cart = new HashMap<>();
    }
    public Order(Person c){     //for customer creating an order passing themself as Person activeUser
        cart = new HashMap<>();
        customer = (Customer)c;
    }

    public Order(Customer customer, Driver driver, HashMap<String,Integer> cart, int status, int rating){ //default toTxt constructor
        this.customer = customer;
        this.driver = driver;
        this.cart = cart;
        this.status = status;
        this.rating = rating;
    }
    public static ArrayList<Order> importOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))){
            while((line = reader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] data = line.split(",");
                if (data.length!=7){
                    System.out.println("Skipping order: " + line);
                    continue;
                }
                    String customerEmail = data[0];
                    String driverEmail = data[1];
                    String cartString = data[2];
                    int status = Integer.parseInt(data[5]);
                    int rating = Integer.parseInt(data[6]);
                    // looks up customer and driver objects

                    Customer customer = Main.customerManager.findCustomerByEmail(customerEmail);
                    Driver driver = Main.driverManager.findDriverByEmail(driverEmail);

                    if (customer == null){
                        System.out.println("Warning: customer not found: " + customerEmail);
                        continue;
                    }
                    if(driver == null){
                        System.out.println("Warning: driver not found: " + driverEmail);
                        continue;
                    }

                    HashMap<String, Integer> cart = new HashMap<>();
                    String[] pairs = cartString.split(">");

                    for (String p: pairs){
                        if(p.contains("<")){
                            String[] split = p.split("<");
                            cart.put(split[0],Integer.parseInt(split[1]));
                        }
                    }

                    Order order = new Order(customer, driver, cart, status, rating);
                    orders.add(order);

                }
                
            } catch (IOException e){
            System.out.println("Error reading orders.");
        }

        return orders;
    }
    
    public static void exportOrders(){
        try (PrintWriter writer = new PrintWriter("orders.txt")){
            for (Order order : Main.allOrders){
                writer.write(order.getCustomer().getEmail()+","+order.getDriver().getEmail()+',');
                for (String key : order.getCart().keySet()){
                    writer.write(key + "<"+order.getCart().get(key)+">");
                }
                writer.write(","+order.getStatus()+","+order.getRating()+'\n');
            }
        } catch (IOException e){
            System.out.println("Error exporting orders to file.");
        }
    }

    public void assignDriver(){
        
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating=rating;
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
    public Driver getDriver(){
        return driver;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public void addItem(String itemName){
        if (cart.containsKey(itemName)){
            cart.put(itemName,cart.get(itemName)+1);
        } else {
        cart.put(itemName,1);
        }
    }
    public void cartPrint(){
        for(String name : cart.keySet()){
            System.out.println(name + " x"+cart.get(name));
        }
        System.out.println("Your total is: "+ total());
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
    public HashMap<String,Integer> getCart(){
        return cart;
    }
}
