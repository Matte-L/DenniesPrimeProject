import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Comparator;

public class DriverManager{
    private ArrayList<Driver> drivers = new ArrayList<>();

    public DriverManager(){
        String line; 
        try(BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))){
            while ((line = reader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }                

            String[] data = line.split(",");
            if (data.length!=7){
                System.out.println("Error reading line of Driver");
                continue;
            }
            String name = data[0];
            String password = data[1];
            String phone = data[2];
            String email = data[3];
            String model = data[4];
            double odo = Double.parseDouble(data[5]);
            double rating = Double.parseDouble(data[6]);
            drivers.add(new Driver(password,name,phone,email,model,odo,rating));
            }
            System.out.println("Drivers imported");
        }catch (IOException e){
            System.out.println("Error reading drivers");
        }
        for (Driver d : drivers){
            if (d.getCurrentOrder()==null){
                driverQ.add(d);
            }
        }

    }
    public Driver createDriver(String password, String name, String phoneNumber, String email, String carModel, double odometer, double raiting){
        Driver newDriver = new Driver(password, name, phoneNumber, email, carModel, odometer, raiting);

        drivers.add(newDriver);        
        return newDriver;
    }
    private PriorityQueue<Driver> driverQ = new PriorityQueue<>( //stores all available drivers sorted by rating
        Comparator.comparingDouble(Driver::getRaiting)
    );
    public void driverSignup(){      // DRIVER LOGIN METHOD
        System.out.println(" --- Driver Login --- ");
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter driver name");
        String name = scnr.nextLine();
        System.out.println("Enter your email");
        String email = scnr.nextLine();
        System.out.println("Enter your car model");
        String carModel = scnr.nextLine();

        System.out.println("Enter your phone number");
        String phoneNumber = scnr.nextLine();        

        System.out.println("Enter your password");
        String password = scnr.nextLine();

        do {
            System.out.println("Enter your current odometer");
        } while (!scnr.hasNextDouble());
        double odometer = scnr.nextDouble();

        double raiting = Math.random()*10;
        drivers.add(new Driver(password,name,phoneNumber,email,carModel,odometer,raiting));       
        System.out.println("Driver " + name + " signed up.");
    }

    public void saveDriverToFile(){
         try(PrintWriter writer = new PrintWriter("drivers.txt")){
                for (Driver d: drivers) {
                    writer.println(d.getName() +","+ d.getPassword()+"," + d.getPhoneNumber() + "," + d.getEmail() + "," + d.getCarModel() + "," + d.getOdometer() + "," + d.getRaiting());
                }
            
         }catch (IOException e){
            System.out.println("Error saving driver data: " + e.getMessage());
        }
        System.out.println("Drivers exported.");
    }




    public void addDriver(Driver d){
        drivers.add(d);
    }
    public Driver giveTopDriver(){
        return driverQ.poll();
    }

    public ArrayList<Driver> getDrivers(){
        return drivers;
    }

    public Driver findDriverByEmail(String email){
        for (Driver d : drivers){
            if (d.getEmail().equalsIgnoreCase(email)){
                return d;
            }
        }
        return null;
    }

    public Driver driverLogin(){  // DRIVER LOG IN ADDED
        String temp;
        Scanner scnr = new Scanner(System.in);
        boolean stuck = true;
        while (stuck == true){
            System.out.println("Enter you email:");
            temp = scnr.nextLine();
            for (Driver d: drivers){
                if (d.getEmail().equalsIgnoreCase(temp)){
                    while (stuck == true){
                        System.out.println("Enter your password: (hint)"+d.getPassword());
                        if (d.getPassword().equals(scnr.nextLine())){
                            System.out.println("Welcome "+ d.getName());
                            return d;
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
    



}