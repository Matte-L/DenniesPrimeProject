import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class DriverManager{

    public Driver createDriver(String password, String name, String phoneNumber, String email, String carModel, double odometer, double raiting){
        Driver newDriver = new Driver(password, name, phoneNumber, email, carModel, odometer, raiting);

        Main.driverManager.getDrivers().add(newDriver);        
        return newDriver;
    }

    public void driverLogin(){      // DRIVER LOGIN METHOD
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
    public void importDrivers(){
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
            String email = data[0];
            String password = data[1];
            String name = data[2];
            String phone = data[3];
            String model = data[4];
            double odo = Double.parseDouble(data[5]);
            double rating = Double.parseDouble(data[6]);
            drivers.add(new Driver(password,name,phone,email,model,odo,rating));
            }
        }catch (IOException e){
            System.out.println("Error reading drivers");
        }
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


    private ArrayList<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver d){
        drivers.add(d);
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
    



}