import java.util.ArrayList;

public class CustomerManager {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}
