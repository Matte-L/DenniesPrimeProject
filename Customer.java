import java.util.ArrayList;

public class Customer extends Person {

    private String address;
    private String cardNum;
    private ArrayList<Order> orderHistory;
    private Order currentOrder;

    public Customer(String password, String name, String phoneNumber, String email, String id, String address, String cardNum, ArrayList<Order> orderHistory, Order currentOrder){ //default constructor for txt
        super(password, name, phoneNumber,email,id);
        this.address = address;
        this.cardNum = cardNum;
        this.orderHistory=orderHistory;
        this.currentOrder = currentOrder;
    }
    public Customer(String password, String name, String phoneNumber, String email, String id){
        super(password, name, phoneNumber, email, id);
    }
    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCardNum(){ // need to figure out how to keep this private or confidential
        return cardNum;
    }

    public void setCardNum(String cardNum){
        this.cardNum = cardNum; // ""
    }

    public ArrayList<Order> viewHistory(){
        return orderHistory;
    }

    public void sendOrder(){
        currentOrder.setStatus(1);
        currentOrder.assignDriver();
    }

    public Order getCurrentOrder(){
        return currentOrder;
    }
    public void newOrder(){
        currentOrder = new Order();
    }

    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }

    

    // create order method
    

    
    
}
