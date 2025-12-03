import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerManager {

    public Customer createCustomer(String name, String phone, String email){
        String password = "Password";
        String customerID = "Customer" + (int)(Math.random() * 100);

        Customer customer = new Customer(password, name, phone, email, customerID);
        customers.add(customer);

        return customer;
    }

    public void saveCustomerToFile(){               // FILE WRITER FOR CUSTOMERS LIST ////[[[[[[[FOR THRRACKS]]]]]]]\\\\\
        try(PrintWriter writer = new PrintWriter("customers.txt")){

            for (Customer c: customers){
                writer.println(c.getName() + ", " + c.getPhoneNumber() + ", " + c.getEmail() + " ," + c.getId());
                }
            System.out.println("Customer list has been saved to customers.txt");
        }catch (FileNotFoundException e){
            System.out.println("Error saving customer data: " + e.getMessage());
        }
    }



    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}
