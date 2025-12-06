import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class CustomerManager {
    private ArrayList<Customer> customers = new ArrayList<>();
    public void importCustomers(){
        String line; 
        try(BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))){
            while ((line = reader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }                

            String[] data = line.split(",");
            if (data.length!=4){
                System.out.println("Error reading line of Customer");
                continue;
            }
            String email = data[0];
            String password = data[1];
            String name = data[2];
            String phone = data[3];
            customers.add(new Customer(password,name,phone,email));
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }catch (IOException e){
            System.out.println("IO error");
        }
    }
    public Customer createCustomer(String name, String phone, String email, String password){

        Customer customer = new Customer(password, name, phone, email);
        customers.add(customer);

        return customer;
    }
    public Customer customerSignup(){    // CUSTOMER LOGIN ============================== 
        Scanner scnr = new Scanner(System.in); 
        System.out.println("\n --- Customer Signup ---");

        System.out.println("Enter your full name");
        String name = scnr.nextLine();

        System.out.println("Enter your phone number");
        String phone = scnr.nextLine();

        System.out.println("Enter your email: ");
        String email = scnr.nextLine();
        System.out.println("Enter your password: ");
        String password = scnr.nextLine();

        Customer customer = new Customer(password,name,phone,email);
        customers.add(customer);
        System.out.println("Welcome, " + customer.getName() + "!");
        
        return customer;
    }

    public void saveCustomerToFile(){               // FILE WRITER FOR CUSTOMERS LIST ////[[[[[[[FOR THRRACKS]]]]]]]\\\\\
        try(PrintWriter writer = new PrintWriter("customers.txt")){

            for (Customer c: customers){
                writer.println(c.getEmail() + "," + c.getPassword() + "," + c.getName() + "," + c.getPhoneNumber());
                }
            System.out.println("Customer list has been saved to customers.txt");
        }catch (FileNotFoundException e){
            System.out.println("Error saving customer data: " + e.getMessage());
        }
    }

    public Customer customerLogin(){
        String temp;
        Scanner scnr = new Scanner(System.in);
        boolean stuck = true;
        while (stuck == true){
            System.out.println("Enter you email:");
            temp = scnr.nextLine();
            for (Customer c: customers){
                if (c.getEmail().equalsIgnoreCase(temp)){
                    while (stuck == true){
                        System.out.println("Enter your password: (hint)"+c.getPassword());
                        if (c.getPassword().equals(scnr.nextLine())){
                            System.out.println("Welcome "+ c.getName());
                            return c;
                        }
                        System.out.println("Incorrect password.");
                    }
                }
            }
            System.out.println("Email not found.");
        }
        scnr.close();
        return null;
    }


    public void addCustomer(Customer c){
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public Customer findCustomerByEmail(String email){
        for(Customer c: customers){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c;
            }
        }
        return null;
    }

}
