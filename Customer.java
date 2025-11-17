import java.util.ArrayList;

public class Customer extends Person {

    private String address;
    private String cardNum;
    private ArrayList<Order> orderHistory;
    private Order currentOrder;


    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCardNum(){ // need to figure out how to keep this private or confidential
        return cardNum;
    }

    public void setCardNum(){
        this.cardNum = cardNum; // ""
    }

    public ArrayList<Order> viewHistory(){
        return orderHistory;
    }

    public void sendOrder(){
        
    }

    // create order method
    

    
    
}
