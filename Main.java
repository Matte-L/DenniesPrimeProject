import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    String temp = "";
       
    Customer tester = new Customer("Password123", "Tafadzwe Dube","(805)123-4567","dube@my.cuesta.edu","0000001");
        System.out.println("Tester Credentials");
        System.out.println("Email: "+ tester.getEmail());
        System.out.println("Password: "+ tester.getPassword());

        System.out.println("Welcome to Dennies Prime Delivery!");      
        while (!temp.equals(tester.getEmail())){
            System.out.println("Please enter your email address:");
            temp = scnr.nextLine();
        }
        while (!temp.equals(tester.getPassword())){
            System.out.println("Please enter you password:");
            temp = scnr.nextLine();
        }
        System.out.println("Welcome " + tester.getName());      
        
        Item hamburger = new Item("Hamburger", 495);
        Item fries = new Item("Fries", 295);
        Item soda= new Item("Soda", 195);
        hamburger.print();
        fries.print();
        soda.print();





        Export toExport = new Export();
        toExport.toTxt(tester);
        /*toExport.toTxt(tester.getId());
        toExport.toTxt(tester.getEmail());
        toExport.toTxt(tester.getPhoneNumber());
        toExport.toTxt(tester.getPassword());*/
    }
    
}
